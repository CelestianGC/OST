package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyClasses.XMLManage.AliasClass;

public class ChartList {

	public List<ChartClass> entries = new ArrayList<ChartClass>();
	public XMLManage xm;
	public ChartList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		//omit.add("Encountered");
		omit = null;
		
		xm = new XMLManage(this, sFileName, 
				ChartList.class, "entries", 
				ChartClass.class, "ChartClass", omit);

		// add additional aliases to clean up the xml output
		xm.setAliasFields(new ArrayList<AliasClass>());
		xm.getAliasFields().add(xm.new AliasClass(ChartColumn.class, "ChartColumn"));
	}

	public void add(ChartClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<ChartClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new ChartClass("red-headed","need more charts!"));
	}
}// end ChartList
