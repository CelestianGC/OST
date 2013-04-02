package org.ost.main.MyClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.ost.main.MyClasses.AbilityStatClass.Strength;
import org.ost.main.MyUtils.SimpleDialog;
import static org.ost.main.MyClasses.MyStatics.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class AbilityStatList {

	public List<AbilityStatClass> entries = new ArrayList<AbilityStatClass>();
	public XMLManage xm;
	public AbilityStatList(String sFileName) {
		ArrayList<String> omit = new ArrayList<String>();
		omit.add("bSmallFont");
		
		xm = new XMLManage(this, sFileName, 
				AbilityStatList.class, "entries", 
				AbilityStatClass.class, "AbilityStatClass", omit);
	}

	public void add(AbilityStatClass entry) {
		entries.add(entry);
	}			
	public List<AbilityStatClass> getContent() {
		return entries;
	}
	public void clear() {
		entries.clear();
	}

	/**
	 * create blank ability scores
	 * 
	 */
	public void generateAllScores() {
		clear();
		
		for (int i=0;i<26;i++) {
			AbilityStatClass oA = new AbilityStatClass();
			oA.strength.score = i; 
			oA.strength.numDiceOpenDoor = 1; 
			oA.strength.sizeDiceOpenDoor = 6;
			if (i==18) {
				oA.strength.percentile = new ArrayList<Strength>();
				AbilityStatClass.Strength oS = oA.new Strength();
				oS.score = 50;
				oS.name = "Strength-Percentile";
				oA.strength.percentile.add(oS);
				oS = oA.new Strength();
				oS.score = 75;
				oS.name = "Strength-Percentile";
				oA.strength.percentile.add(oS);
				oS = oA.new Strength();
				oS.score = 90;
				oS.name = "Strength-Percentile";
				oA.strength.percentile.add(oS);
				oS = oA.new Strength();
				oS.score = 99;
				oS.name = "Strength-Percentile";
				oA.strength.percentile.add(oS);
				oS = oA.new Strength();
				oS.score = 100;
				oS.name = "Strength-Percentile";
				oA.strength.percentile.add(oS);
			}
			
			oA.charisma.score = i;
			oA.consitution.score = i;
			
			oA.dexterity.score = i;
//			for (int ii=0;ii<MAX_THIEF_SKILLS;ii++)
//				oA.dexterity.dexAbilityAdjustments[ii] = 0;
			
			oA.intelligence.score = i;
				for (int ii=0;ii<MAX_MAGE_SPELL_LEVEL;ii++)
					oA.intelligence.bonusSpells[ii] = 0;
				
			oA.wisdom.score = i;
			for (int ii=0;ii<MAX_CLERIC_SPELL_LEVEL;ii++)
				oA.wisdom.bonusSpells[ii] = 0;
			
			add(oA);
		}
		
	}
	/**
	 * return AbilityStatClass with ability nScore value
	 * 
	 * @param nScore
	 * @return
	 */
	public AbilityStatClass getStat(int nScore) {
		AbilityStatClass oA = null;
		for(AbilityStatClass aS : getContent()) {
			if (aS.getStrength().score == nScore) {
				oA = aS;
				break;
			}
		}
		return oA;
	}
	
//	
//	/**
//	 * generate XML file from struct
//	 * 
//	 * @param fileName
//	 * @param aList
//	 */
//	public void aserializeToXML(String fileName) {
//		XStream xs = new XStream();
//		xs.alias("entries", AbilityStatList.class);
//		xs.alias("AbilityStatClass", AbilityStatClass.class);
//		xs.addImplicitCollection(AbilityStatList.class, "entries");
//
//		try {
//			FileOutputStream fs = new FileOutputStream(fileName);
//			xs.toXML(this,fs);
//		} catch (Exception e) {
//			SimpleDialog.showError(e.getLocalizedMessage()+":error in serializeListToXML");
//		}
//	}
//
//	/**
//	 * return list of objects from XML
//	 * 
//	 * @param fileName
//	 * @return
//	 */
//	public void adeserializeFromXML(String fileName) {
//		XStream xs = new XStream(new DomDriver());
//		xs.alias("entries", AbilityStatList.class);
//		xs.alias("AbilityStatClass", AbilityStatClass.class);
//		xs.addImplicitCollection(AbilityStatList.class, "entries");
//		try {
//			FileInputStream fis = new FileInputStream(fileName);
//			xs.fromXML(fis, this);
//		} catch (Exception e) {
//			SimpleDialog.showError(e.getLocalizedMessage()+":error in deserializeFromXML");
//		}
//	}

}
