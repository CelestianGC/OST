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

public class PlayerList {

	public List<PlayerClass> entries = new ArrayList<PlayerClass>();
	public XMLManage xm;
	public PlayerList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("fightingNode");
		xm = new XMLManage(this, sFileName, 
				PlayerList.class, "entries", 
				PlayerClass.class, "PlayerClass", omit);
	}

	public void add(PlayerClass entry) {
		// if the ID is not valid get one.
		if (entry.getMyID().length()==0)
			entry.setMyID(UUID.randomUUID().toString());
		
		entries.add(entry);
	}			
	public List<PlayerClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	public void generate() {
		add(new PlayerClass("Lost Bob"));
		add(new PlayerClass("Rupert"));
		add(new PlayerClass("Marry"));
		add(new PlayerClass("Sally"));
	}
}
