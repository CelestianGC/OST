package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.Iterator;

import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class TreasureTableClass  implements Comparable {
	public int ID;
	public String name;
	public String description;
	public int lowDice; //in a 1-20 value this is 1
	public int highDice;// in a 1-20 value this is 20
	
	public int exp;
	public int goldvalue;

	public String referToTable; // if the result requires roll on another table,it's name is here.
	
	public TreasureTableClass() {
		this("new","empty",0,1,0,0);
	}	
	/**
	 * constructor
	 */
	public TreasureTableClass(String nname, String ddesc, int lowInt, int highInt, int expInt, int goldInt) {
		this.setName(nname);
		this.setDescription(ddesc);
		this.setLowDice(lowInt);
		this.setHighDice(highInt);
		this.setReferToTable("");
		this.setExp(expInt);
		this.setGoldvalue(goldInt);

	} // end construct


	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}
	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	/**
	 * @return the goldvalue
	 */
	public int getGoldvalue() {
		return goldvalue;
	}
	/**
	 * @param goldvalue the goldvalue to set
	 */
	public void setGoldvalue(int goldvalue) {
		this.goldvalue = goldvalue;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the lowDice
	 */
	public int getLowDice() {
		return lowDice;
	}
	/**
	 * @param lowDice the lowDice to set
	 */
	public void setLowDice(int lowDice) {
		this.lowDice = lowDice;
	}
	/**
	 * @return the highDice
	 */
	public int getHighDice() {
		return highDice;
	}
	/**
	 * @param highDice the highDice to set
	 */
	public void setHighDice(int highDice) {
		this.highDice = highDice;
	}
	/**
	 * @return the referToTable
	 */
	public String getReferToTable() {
		return referToTable;
	}
	/**
	 * @param referToTable the referToTable to set
	 */
	public void setReferToTable(String referToTable) {
		this.referToTable = referToTable;
	}
	/**
	 * return the reward for this treasure
	 * 
	 * @return
	 */
	public String getReward() {
		return(getName());
	}
	
	//-------------------------------------------------------------------
//	/**
//	 * returns item as Element for XML output
//	 * @return
//	 */
//	public Element getAsElement(){
//		Element eE = new Element("Treasure");
//		try {
//			// strings
//			eE.addContent(new Element("Name").setText(XMLControl.escapeChars(name)));	
//			eE.addContent(new Element("Description").setText(XMLControl.escapeChars(description)));
//			eE.addContent(new Element("ReferTo").setText(XMLControl.escapeChars(referToTable)));
//
//			// ints
//			eE.addContent(new Element("lowDice").setText(String.format("%d",lowDice)));
//			eE.addContent(new Element("highDice").setText(String.format("%d",highDice)));
//
//			eE.addContent(new Element("exp").setText(String.format("%d",exp)));
//			eE.addContent(new Element("goldValue").setText(String.format("%d",goldvalue)));
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save TreasureTable.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return eE;
//	}
//
	/**
	 * return Class from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static TreasureTableClass getFromElements(Element eItem) {
		TreasureTableClass oO = new TreasureTableClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown tt-name in XML");
		}

		try {
			oO.setDescription(XMLControl.unEscapeChars(eItem.getChild(
					"Description").getText()));
		} catch (NullPointerException err) {
			oO.setDescription("No treasure-table description in XML.");
		}

		try {
			oO.setReferToTable(XMLControl.unEscapeChars(eItem.getChild(
					"ReferTo").getText()));
		} catch (NullPointerException err) {
			oO.setReferToTable("");
		}

		// numbers
		try {
			oO
					.setLowDice(Integer.parseInt(eItem.getChild("lowDice")
							.getText()));
		} catch (NullPointerException err) {
			oO.setLowDice(0);
		}

		try {
			oO.setHighDice(Integer.parseInt(eItem.getChild("highDice")
					.getText()));
		} catch (NullPointerException err) {
			oO.setHighDice(10);
		}

		try {
			oO.setExp(Integer.parseInt(eItem.getChild("exp").getText()));
		} catch (NullPointerException err) {
			oO.setExp(0);
		}

		try {
			oO.setGoldvalue(Integer.parseInt(eItem.getChild("goldValue")
					.getText()));
		} catch (NullPointerException err) {
			oO.setGoldvalue(0);
		}
			
	    return oO;
	}
	
	/**
	 * sort by counter
	 */
	public int compareTo(Object o) {
	     //return name.toUpperCase().compareTo(((StatesClass)o).name.toUpperCase());		
	     return this.lowDice - (((TreasureTableClass)o).lowDice);		
	}
	
} // end TreasureTableClass
