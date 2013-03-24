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

public class WeaponProfList {

	public List<WeaponProfClass> entries = new ArrayList<WeaponProfClass>();
	public XMLManage xm;
	public WeaponProfList(String sFileName) {
			xm = new XMLManage(this, sFileName, 
				WeaponProfList.class, "entries", 
				WeaponProfClass.class, "WeaponProfClass", null);
	}
	public void add(WeaponProfClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<WeaponProfClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		WeaponProfClass oR = new WeaponProfClass();
		oR.name = "long sword";
		oR.description = "Longword prof";
		oR.cost = 1;
		oR.setCost(1);
		oR.setAttackAdjustment(0);
		oR.setDamageAdjustment(0);
		oR.setSpeedAdjustment(0);
		add(oR);
	}

}
