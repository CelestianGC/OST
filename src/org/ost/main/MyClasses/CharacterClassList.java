package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyClasses.PlayerClass.PCClass;
import org.ost.main.MyClasses.XMLManage.AliasClass;

public class CharacterClassList {

	public List<CharacterClass> entries = new ArrayList<CharacterClass>();
	public XMLManage xm;
	public CharacterClassList(String sFileName) {
		xm = new XMLManage(this, sFileName, 
				CharacterClassList.class, "entries", 
				CharacterClass.class, "CharacterClass", null);

		// add additional aliases to clean up the xml output
		xm.setAliasFields(new ArrayList<AliasClass>());
		xm.getAliasFields().add(xm.new AliasClass(LevelClass.class, "LevelClass"));
		xm.getAliasFields().add(xm.new AliasClass(AbilityScoreClass.class, "AbilityScoreClass"));
		xm.getAliasFields().add(xm.new AliasClass(SkillsClass.class, "SkillsClass"));
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
