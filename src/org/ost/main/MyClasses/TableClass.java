package org.ost.main.MyClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.MainClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class TableClass  implements Comparable{
	public String myID;
	public String name;
	public String description;
	public String type;
	public ArrayList<TreasureTableClass> treasureEntry;
	
	public TableClass() {
		this("Un-named Table","Needs description.","Treasure");
	}
	/**
	 * 
	 * @param nname
	 * @param ddesc
	 */
	public TableClass(String nname, String ddesc, String ttype) {
		this.setName(nname);
		this.setDescription(ddesc);
		this.setType(ttype);
		this.setTreasureEntry(new ArrayList<TreasureTableClass>());
		this.setMyID(UUID.randomUUID().toString());
	} // end construct

	
	/**
	 * @return the myID
	 */
	public String getMyID() {
		return myID;
	}
	/**
	 * @param myID the myID to set
	 */
	public void setMyID(String myID) {
		this.myID = myID;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the treasureEntry
	 */
	public ArrayList<TreasureTableClass> getTreasureEntry() {
		return treasureEntry;
	}
	/**
	 * @param treasureEntry the treasureEntry to set
	 */
	public void setTreasureEntry(ArrayList<TreasureTableClass> treasureEntry) {
		this.treasureEntry = treasureEntry;
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
	 * 
	 */
	public String toString() {
		return(getName());
	}

	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((TableClass)o).name.toUpperCase());		
	}
	
	/**
	 * return the highest roll needed for this table
	 * 
	 * @return
	 */
	public int getHighestRoll() {
		int maxDice = 0;
		for (TreasureTableClass oTT : getTreasureEntry()) {
			if (oTT.getHighDice() > maxDice)
				maxDice = oTT.getHighDice();
		}
		return(maxDice);
	}
	
	private boolean isExcluded(String myName, String excluded[]) {
		boolean foundExclude = false;
		for (int i=0;i<excluded.length;i++) {
			if (excluded[i].equalsIgnoreCase(myName)) {
				foundExclude = true;
				break;
			}
		}
		return(foundExclude);
	}
	

	/**
	 * get all treasure rewards and place theminto rewardList for output later
	 * @param rewardList
	 * @param tableList
	 * @param diceRolled
	 * @param exclude
	 * @param skipReferences
	 */
	public void getAllRewards(ArrayList<TableRewardClass> rewardList,
			List<TableClass> tableList,
			int diceRolled, String exclude[], boolean skipReferences) {
//		ArrayList<TableRewardClass> oRewards = new ArrayList<TableRewardClass>();
		TreasureTableClass oT = getOneReward(tableList, diceRolled, exclude, skipReferences);
		TableRewardClass oR = new TableRewardClass("");
		while(oT != null) {
			if (oT.getGoldvalue()!=0 || oT.getExp()!=0) {
				String nameParsed = MyParse.parseDice(oT.getName());
				String newName = String.format("%s%s", oR.getName(),
						oR.getName().length()>0?", "+nameParsed:nameParsed);
				
				int iExp = oT.getExp()<0?0:oT.getExp();
				int iGold = oT.getGoldvalue()<0?0:oT.getGoldvalue();
				
				oR.appendDebugLog(String.format("debug>dicerolled(%d)\n", diceRolled));
				oR.appendDebugLog(String.format("debug>ref:(%s)\n",oT.getReferToTable()));
				// need to parse reward macros here
				oR.setExpValue(oR.getExpValue()+iExp);
				oR.setGoldValue((oR.getGoldValue()+iGold));
				
				if (!oT.getReferToTable().equalsIgnoreCase("NONE")
						&& oT.getReferToTable().length() > 0) {
						oR.setName(newName);
						oR.parseRewardMacros(rewardList,tableList);
						oR.appendDebugLog("debug>added ["+nameParsed+"]\n");
						
MainClass.ddprint(String.format("getAllRewards() reward w/ref (%s)[%s]\n",oR.getName(),oT.getName()));
				} else { // !None
					oR.setName(newName);
					oR.parseRewardMacros(rewardList,tableList);
					oR.setName(oR.getName().replaceAll(Pattern.quote(",,"),","));

MainClass.ddprint(String.format("getAllRewards() reward w/o ref (%s)[%s]\n",oR.getName(),oT.getName()));
					oR.appendDebugLog("debug>added "+nameParsed+" and finished entry.\n");
					rewardList.add(oR);
					oR = new TableRewardClass("aaa");
				} // 
MainClass.ddprint(String.format("getAllRewards() xp and gold for (%s)\n",oR.getName()));
			} else {
MainClass.ddprint(String.format("getAllRewards() skipping %s\n",oT.getName()));
			}
			if (!oT.getReferToTable().equalsIgnoreCase("NONE")
					&& oT.getReferToTable().length() > 0 && !skipReferences) {
MainClass.ddprint(String.format("getAllRewards() got refer(%s)\n",oT.getReferToTable()));
				TableClass oTable = TableClass.findTableClass(oT.getReferToTable(), tableList);
				if (oTable != null) {
MainClass.ddprint(String.format("getAllRewards() got oTable (%s)\n",oTable.getName()));
				MyRandomClass oRand = new MyRandomClass(1, oTable.getHighestRoll());
				oT = oTable.getOneReward(tableList, 
						oRand.rollRandomDice(), exclude, skipReferences);
MainClass.ddprint(String.format("getAllRewards() got ref oT=(%s)\n",oT.getName()));
				} else {
					oT = null; // done.
MainClass.ddprint(String.format("getAllRewards() got oT null\n"));
				}
			}  else { // end if ReferTo
				oT = null;
MainClass.ddprint(String.format("getAllRewards() got oT null\n"));
			}
		} // end while
		//oRewards = TableRewardClass.parseRewardMacros(tableList, oRewards);
		//return (oRewards);
	}
	public TreasureTableClass getOneReward(List<TableClass> tableList,
			int diceRolled, String exclude[], boolean skipReferences) {
		TreasureTableClass oFound = null;
		
		//TableRewardClass oR = new TableRewardClass("nothing");
		//oR.appendDebugLog(String.format("nothing on roll (%d)\n", diceRolled));
		// String reward = String.format("nothing (%d)",diceRolled);

		for (TreasureTableClass oTT : getTreasureEntry()) {
			if (diceRolled >= oTT.getLowDice()
					&& diceRolled <= oTT.getHighDice()) {
				// reroll on this table till we don't get a excluded name
				if (exclude != null
						&& isExcluded(oTT.getReferToTable(), exclude)) {
					// excluded
				} else {
					oFound = oTT;
				} // end if isExcluded
			} // end if diceRolled

		} // end for
		return (oFound);
	}
	
	/**
	 * return TableClass object if one of them matches sName
	 * 
	 * @param sName
	 * @param tableList
	 * @return
	 */
	public static TableClass findTableClass(String sName,List<TableClass> tableList) {
		TableClass oT = null;
		for (TableClass tC : tableList) {
			if (tC.getName().equalsIgnoreCase(sName))
				oT = tC;
		}
		return(oT);
	}
	
	/**
	 * 
	 * @param rewardList
	 */
	static void consolidateRewards(ArrayList<TableRewardClass> rewardList) {
		ArrayList<TableRewardClass> oRemove = new ArrayList<TableRewardClass>();
		
		for(TableRewardClass oR: rewardList) {
			int iGold = oR.getGoldValue()>0?oR.getGoldValue():0;
			int iExp = oR.getExpValue()>0?oR.getExpValue():0;
			int iCount = 1;
			
			for(TableRewardClass oN: rewardList) {
				if (oR.getName().equalsIgnoreCase(oN.getName()) && oR != oN && 
						(!oRemove.contains(oR))) {
					iGold += oN.getGoldValue()>0?oN.getGoldValue():0;
					iExp += oN.getExpValue()>0?oN.getExpValue():0;
					iCount++;
					oRemove.add(oN);
					MainClass.ddprint("--consolidateRewards() removing duplicate "+oN.getName()+"\n");
				}
			}// end for oN
			oR.setGoldValue(iGold);
			oR.setExpValue(iExp);
			oR.setCount(iCount);
		} // end for oR

		// now remove all the duplicates from the list
		for (TableRewardClass oDelete: oRemove)
			rewardList.remove(oDelete);
		//return(rewardList);
	}
	//-------------------------------------------------------------------
//	/**
//	 * returns item as Element for XML output
//	 * @return
//	 */
//	public Element getAsElement(){
//		Element eTable = new Element("Table");
//		try {
//			// strings
//			eTable.addContent(new Element("Name").setText(XMLControl.escapeChars(name)));	
//			eTable.addContent(new Element("Description").setText(XMLControl.escapeChars(description)));
//			eTable.addContent(new Element("Type").setText(XMLControl.escapeChars(type)));
//		    
//			/**
//			 * Insert TreatureTable entries block
//			 */
//			if (getTreasureEntry().size() > 0) {
//				Element eF = new Element("TreasureList");
//				// add all the TT entries
//				for (TreasureTableClass oT : getTreasureEntry()) 
//					eF.addContent(oT.getAsElement());
//				// now add them to Tables xml
//				eTable.addContent(eF);
//			}// if
//
//
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save Table.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return eTable;
//	}
//
//	/**
//	 * returns the entire Class listing as a Document
//	 * so it can be output to XML file.
//	 * 
//	 * @param lList
//	 * @param sRootName
//	 * @return
//	 */
//	public static Document xmlBuildDocFromList(ArrayList<TableClass> lList,String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			TableClass oO = lList.get(i);
//			eRoot.addContent(oO.getAsElement());
//		}
//
//		return doc;
//	} // end buildDoc	
	
	/**
	 * build list of Class from XML Document
	 * @param doc
	 * @return
	 */
	public static ArrayList<TableClass> getListFromDoc(Document doc) {
		ArrayList<TableClass> lList = new ArrayList<TableClass>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("Table");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				TableClass oO = TableClass.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
			SimpleDialog
					.showError("NullpointerException:"
							+ err.getLocalizedMessage()
							+ "\n"
							+ "Error occured while trying to load Tables from XML.");
		}

		return lList;
	}

	/**
	 * return Class from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static TableClass getFromElements(Element eItem) {
		TableClass oO = new TableClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown name in XML");
		}

		try {		
		oO.setDescription(XMLControl.unEscapeChars(eItem.getChild("Description").getText()));		
		} catch (NullPointerException err) {
			oO.setDescription("No table description in XML.");
		}
		try {		
			oO.setType(XMLControl.unEscapeChars(eItem.getChild("Type").getText()));		
			} catch (NullPointerException err) {
				oO.setType("Treasure");
			}

		try {
			oO.getTreasureEntry().clear();
			Element eTT = (Element) eItem.getChild("TreasureList");
			java.util.List lTT = eTT.getChildren("Treasure");
			Iterator inTTs = lTT.iterator();
			while (inTTs.hasNext()) {
				Element oE = (Element) inTTs.next();
				oO.getTreasureEntry().add(TreasureTableClass.getFromElements(oE));
			}
		} catch (NullPointerException err) {
			oO.getTreasureEntry().clear();
			oO.getTreasureEntry().add(new TreasureTableClass("Null-XML", "Null-Desc-XML", 0, 1,0,0));
		}			    
			
	    return oO;
		
		
	}
	/**
	 * load xml sFilename and return the arraylist of Class
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<TableClass> loadFromXML(String sFileName) {
		ArrayList<TableClass> lList = new ArrayList<TableClass>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = TableClass.getListFromDoc(doc);
		return lList;
	}
	//---------------------------------------------


}// end TableClass
