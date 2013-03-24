package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreatureList {

	public List<CreatureClass> entries = new ArrayList<CreatureClass>();
	public XMLManage xm;
	public CreatureList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("fightingNode");
		omit.add("fightingList");
		omit.add("Encountered");
				
		xm = new XMLManage(this, sFileName, 
				CreatureList.class, "entries", 
				CreatureClass.class, "CreatureClass", omit);
	}

	public void add(CreatureClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<CreatureClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new CreatureClass("orc"));
		add(new CreatureClass("goblin"));
		add(new CreatureClass("kobold"));
	}
}
