package org.ost.main.MyClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyUtils.SimpleDialog;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class NonWeaponProfList {

	public List<NonWeaponProfClass> entries = new ArrayList<NonWeaponProfClass>();
	public XMLManage xm;
	public NonWeaponProfList(String sFileName) {
			xm = new XMLManage(this, sFileName, 
				NonWeaponProfList.class, "entries", 
				NonWeaponProfClass.class, "NonWeaponProfClass", null);
	}
	public void add(NonWeaponProfClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<NonWeaponProfClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generateNonWeaponProfs() {
		NonWeaponProfClass oR = new NonWeaponProfClass();
		oR.name = "swimming";
		oR.description = "You know more than the average person when it comes to swimming.";
		oR.abilityBase = ABILITY_STRENGTH;
		oR.baseAdjustment = 0;
		oR.cost = 1;
		oR.perAdjustment = 1;
		add(oR);
	}

}
