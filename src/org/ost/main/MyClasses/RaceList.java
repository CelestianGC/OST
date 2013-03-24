package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.MAX_ABILITIES;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RaceList {

	public List<RaceClass> entries = new ArrayList<RaceClass>();
	public XMLManage xm;
	public RaceList(String sFileName) {
			xm = new XMLManage(this, sFileName, 
				RaceList.class, "entries", 
				RaceClass.class, "RaceClass", null);
	}
	public void add(RaceClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<RaceClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generateRaces() {
		RaceClass oR = new RaceClass();
		oR.name = "Human";
		oR.description = "Human, what more can you say. You are one.";
		add(oR);
	}
}
