package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExtraAbilitiesList {

	public List<ExtraAbilitiesClass> entries = new ArrayList<ExtraAbilitiesClass>();
	public XMLManage xm;
	public ExtraAbilitiesList(String sFileName) {
			xm = new XMLManage(this, sFileName, 
				ExtraAbilitiesList.class, "entries", 
				ExtraAbilitiesClass.class, "ExtraAbilitiesClass", null);
	}
	public void add(ExtraAbilitiesClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		
		entries.add(entry);
	}			
	public List<ExtraAbilitiesClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		ExtraAbilitiesClass oR = new ExtraAbilitiesClass("x-ability-name","x-ability description");
		add(oR);
	}
}
