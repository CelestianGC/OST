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

public class EquipmentList {

	public List<EquipmentClass> entries = new ArrayList<EquipmentClass>();
	public XMLManage xm;
	public EquipmentList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("contains");
		
			xm = new XMLManage(this, sFileName, 
				EquipmentList.class, "entries", 
				EquipmentClass.class, "EquipmentClass", omit);
	}

	public void add(EquipmentClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		entries.add(entry);
	}			
	public List<EquipmentClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generateEquipment() {
		EquipmentClass oR = new EquipmentClass();
		oR.name = "wineskin";
		oR.description = "Carries 1 day supply of water or other substances.";
		oR.setCount(1);
		oR.setWeight(new Float(0.5));
		add(oR);
	}
	
	
	/**
	 * @return the entries
	 */
	public List<EquipmentClass> getEntries() {
		return entries;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<EquipmentClass> entries) {
		this.entries = entries;
	}

}
