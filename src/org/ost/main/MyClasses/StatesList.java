package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatesList {

	public List<StatesClass> entries = new ArrayList<StatesClass>();
	public XMLManage xm;
	public StatesList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("bSmallFont");
		
		xm = new XMLManage(this, sFileName, 
				StatesList.class, "entries", 
				StatesClass.class, "StatesClass", omit);
	}

	public void add(StatesClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<StatesClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new StatesClass("slept","new-description"));
		add(new StatesClass("invisible","new-description"));
		add(new StatesClass("held/stunned","new-description"));
		add(new StatesClass("flying","new-description"));
	}
}
