package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharacterClassList {

	public List<CharacterClass> entries = new ArrayList<CharacterClass>();
	public XMLManage xm;
	public CharacterClassList(String sFileName) {
			xm = new XMLManage(this, sFileName, 
				CharacterClassList.class, "entries", 
				CharacterClass.class, "CharacterClass", null);
	}
	public void add(CharacterClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<CharacterClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		CharacterClass oR = new CharacterClass("noob", "Very new blood class.", "NOOB");
		add(oR);
	}
}
