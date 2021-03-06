package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ost.main.MyClasses.XMLManage.AliasClass;

public class TableList {

	public List<TableClass> entries = new ArrayList<TableClass>();
	public XMLManage xm;
	public TableList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		//omit.add("Encountered");
		omit = null;
		
		xm = new XMLManage(this, sFileName, 
				TableList.class, "entries", 
				TableClass.class, "TableClass", omit);
		
		// add additional aliases to clean up the xml output
		xm.setAliasFields(new ArrayList<AliasClass>());
		xm.getAliasFields().add(xm.new AliasClass(TreasureTableClass.class, "TreasureTableClass"));
	}

	public void add(TableClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<TableClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new TableClass());
	}
}// end TableList
