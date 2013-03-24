package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;

public class DungeonList {

	public List<DungeonRoom> entries = new ArrayList<DungeonRoom>();
	public XMLManage xm;
	public DungeonList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("Encountered");
		
		xm = new XMLManage(this, sFileName, 
				DungeonList.class, "entries", 
				DungeonRoom.class, "DungeonRoom", omit);
	}

	public void add(DungeonRoom entry) {
		entries.add(entry);
	}			
	public List<DungeonRoom> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new DungeonRoom("101"));
		add(new DungeonRoom("102"));
		add(new DungeonRoom("103"));
	}
}// end DungeonList
