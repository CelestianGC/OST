/**
 * 
 */
package org.ost.main.MyClasses;

import java.io.Serializable;
import static org.ost.main.MyClasses.MyStatics.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.EncounterPlayer;
import org.ost.main.MainClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

/**
 * @author Celestian
 *
 */
public class PlayerClass implements Serializable, Comparable {
	private static final long serialVersionUID = 1L;

	public String name;
	public String namePlayer;
	public String myID;
	public int hpMax;
	public int hpCurrent;
	public ArrayList<String> armorRatings;
	public String moveRate;
	public String magicResistance;
	public String specialDefense;
	public String specialAttacks;
	public String alignment;
	public ArrayList<EquipmentClass> gear;
	
	public String pcClass; // tmp for now but to hold class info
	public String pcLevel; // tmp for now but to hold level info
	
	public String notes;
	public String log;
	public String saveLast;
	
	// these are temp sorta vars
	public String tag;
	public int initRoll;
	public ArrayList<StatesClass> states;
	public transient EncounterPlayer Encountered;
	public DefaultMutableTreeNode fightingNode;
	public ArrayList<CreatureClass> fightingList; // fighting these
	//-
	
	public ArrayList<PCClass> myClass;
	public PCRace myRace;
	public ArrayList<String> myWeaponProfs; // list of myIDs.
	public ArrayList<String> myNonWeaponProfs; 
	public ArrayList<AbilityScoreClass> myAbilityScores; 
	public ArrayList<Integer> mySaves;
	public ArrayList<Integer> mySaveAdjustments;
	public int myAlignmentType;
	
	public int genderType;
	
	/**
	 * 
	 */
	public PlayerClass() {
		this("Rip Dirtnap");
	}
	/**
	 * 
	 * @param sName
	 * @param iID
	 */
	public PlayerClass(String sName) {
		setName(sName);
		setNamePlayer("John Smith");
		setHpMax(10);
		setHpCurrent(10);
		setMoveRate("12");
		setAlignment("Neutral");
		setArmorRatings(new ArrayList<String>());
		getArmorRatings().add("10");
		
		setGear(new ArrayList<EquipmentClass>());

		setPcClass("Fighter");
		setPcLevel("1");
		setGenderType(GENDER_TYPE_MALE);
		
		setMagicResistance("None");
		setSpecialAttacks("");
		setSpecialDefense("");
		setLog("");
		setNotes("");
		setSaveLast("");
		
		setStates((new ArrayList<StatesClass>()));
		setFightingList(new ArrayList<CreatureClass>());
		setFightingNode(new DefaultMutableTreeNode("Fighting"));
		setTag("");

		setMyClass(new ArrayList<PCClass>());
		getMyClass().add(new PCClass("NoClassYet", "NoClassSet"));
		setMyRace(new PCRace("NoRaceYet", "NoRaceSET")); // has to be set when pc selects race
		setMyWeaponProfs(new ArrayList<String>());
		setMyNonWeaponProfs(new ArrayList<String>());
		setMyAbilityScores(new ArrayList<AbilityScoreClass>());
		for(int i=0;i<MAX_ABILITIES;i++)
			getMyAbilityScores().add(
					new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],0,25));

		setMySaveAdjustments(new ArrayList<Integer>());
		for(int i=0;i<MAX_SAVES;i++)
			getMySaveAdjustments().add(0);

		setMySaves(new ArrayList<Integer>());
		for(int i=0;i<MAX_SAVES;i++)
			getMySaves().add(0);
						
		setMyAlignmentType(0);
		
		setMyID(UUID.randomUUID().toString());
	}

	public class PCRace {
		public String name; // just to have a copy of the race name
		public String raceID; // myID for the class
		
		public PCRace(String name, String classID) {
			super();
			this.name = name;
			this.raceID = classID;
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
		 * @return the raceID
		 */
		public String getRaceID() {
			return raceID;
		}

		/**
		 * @param raceID the raceID to set
		 */
		public void setRaceID(String raceID) {
			this.raceID = raceID;
		}

	}

	public class PCClass {
		public String name; // just to have a copy of the class name
		public String classID; // myID for the class
		public int experience;
		public int level;
		public boolean primaryClass; //when dual classing we need to know current class
		public ArrayList<Integer> hdRolls; // list of health rolled per level

		public PCClass(String name, String classID) {
			this(name,classID,0,1,false,new ArrayList<Integer>());
		}
		
		public PCClass(String name, String classID, int experience,
				int level, boolean primaryClass, ArrayList<Integer> hdRolls) {
			super();
			this.name = name;
			this.classID = classID;
			this.experience = experience;
			this.level = level;
			this.primaryClass = primaryClass;
			this.hdRolls = hdRolls;
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
		 * @return the pcClass
		 */
		public String getClassID() {
			return classID;
		}
		/**
		 * @param pcClass the pcClass to set
		 */
		public void setClassID(String classID) {
			this.classID = classID;
		}
		/**
		 * @return the experience
		 */
		public int getExperience() {
			return experience;
		}
		/**
		 * @param experience the experience to set
		 */
		public void setExperience(int experience) {
			this.experience = experience;
		}
		/**
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}
		/**
		 * @param level the level to set
		 */
		public void setLevel(int level) {
			this.level = level;
		}
		/**
		 * @return the primaryClass
		 */
		public boolean isPrimaryClass() {
			return primaryClass;
		}
		/**
		 * @param primaryClass the primaryClass to set
		 */
		public void setPrimaryClass(boolean primaryClass) {
			this.primaryClass = primaryClass;
		}
		/**
		 * @return the hdRolls
		 */
		public ArrayList<Integer> getHdRolls() {
			return hdRolls;
		}
		/**
		 * @param hdRolls the hdRolls to set
		 */
		public void setHdRolls(ArrayList<Integer> hdRolls) {
			this.hdRolls = hdRolls;
		}

		/**
		 * return max level for this class
		 * 
		 * @param cList
		 * @return
		 */
		public int getCurrentLevel(CharacterClassList cList) {
			int maxLevel = 0;
			CharacterClass oC = CharacterClass.getClassByMyID(getClassID(), cList);
			if (oC != null) {
			for (int i=0;i<oC.getLevelDetails().size();i++) {
				CharacterClass.LevelClass lC = oC.getLevelDetails().get(i);
				if (getExperience() >= lC.getExpReq())
					maxLevel = lC.getLevel();
			}
			}
			return maxLevel;
		}

		
		
	}
	
	/**
	 * @return the myClass
	 */
	public ArrayList<PCClass> getMyClass() {
		return myClass;
	}
	/**
	 * return character's classes names i.e. "Fighter/Magic-User"
	 * 
	 * @param cList
	 * @return
	 */
	public String getMyClassName(CharacterClassList cList) {
		String classNames = "";
		for (PCClass aClass : myClass) {
			CharacterClass oC = CharacterClass.getClassByMyID(aClass.getClassID(), cList);
			if (oC != null) {
				if (classNames.length()<1) {
					classNames = oC.getName();
				} else {
					classNames = String.format("%s/%s",classNames,oC.getName());
				}
			}
		}
		return classNames;
	}
	/**
	 * return class levels in string format "2/3"
	 * @param cList
	 * @return
	 */
	public String getMyLevelName(CharacterClassList cList) {
		String level = "";
		for (PCClass aClass : myClass) {
			int cLevel = aClass.getCurrentLevel(cList);
			level = level+String.format("%d%s", cLevel,
					myClass.get(myClass.size()-1).equals(aClass)?"":"/");
		}
		return level;
	}

	/**
	 * return exp in string format "2000/2500"
	 * @param cList
	 * @return
	 */
	public String getMyExperienceName(CharacterClassList cList) {
		String exp = "";
		for (PCClass aClass : myClass) {
			int cEXP = aClass.getExperience();
			exp = exp+String.format("%d%s", cEXP,
					myClass.get(myClass.size()-1).equals(aClass)?"":"/");
		}
		return exp;
	}
	
	/**
	 * @param myClass the myClass to set
	 */
	public void setMyClass(ArrayList<PCClass> myClass) {
		this.myClass = myClass;
	}
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
	 * @return the gear
	 */
	public ArrayList<EquipmentClass> getGear() {
		return gear;
	}
	/**
	 * @param gear the gear to set
	 */
	public void setGear(ArrayList<EquipmentClass> gear) {
		this.gear = gear;
	}
	/**
	 * @return the fightingNode
	 */
	public DefaultMutableTreeNode getFightingNode() {
		return fightingNode;
	}
	/**
	 * @param fightingNode the fightingNode to set
	 */
	public void setFightingNode(DefaultMutableTreeNode fightingNode) {
		this.fightingNode = fightingNode;
	}
	/**
	 * @return the fightingList
	 */
	public ArrayList<CreatureClass> getFightingList() {
		return fightingList;
	}
	/**
	 * @param fightingList the fightingList to set
	 */
	public void setFightingList(ArrayList<CreatureClass> fightingList) {
		this.fightingList = fightingList;
	}
	/**
	 * @return the initRoll
	 */
	public int getInitRoll() {
		return initRoll;
	}
	/**
	 * @param initRoll the initRoll to set
	 */
	public void setInitRoll(int initRoll) {
		this.initRoll = initRoll;
	}
	/**
	 * @return the encountered
	 */
	public EncounterPlayer getEncountered() {
		return Encountered;
	}
	/**
	 * @param encountered the encountered to set
	 */
	public void setEncountered(EncounterPlayer encountered) {
		Encountered = encountered;
	}
	/**
	 * @return the pcClass
	 */
	public String getPcClass() {
		return pcClass;
	}
	/**
	 * @param pcClass the pcClass to set
	 */
	public void setPcClass(String pcClass) {
		this.pcClass = pcClass;
	}
	/**
	 * @return the pcLevel
	 */
	public String getPcLevel() {
		return pcLevel;
	}
	/**
	 * @param pcLevel the pcLevel to set
	 */
	public void setPcLevel(String pcLevel) {
		this.pcLevel = pcLevel;
	}
	/**
	 * @return the states
	 */
	public ArrayList<StatesClass> getStates() {
		return states;
	}
	/**
	 * @param states the states to set
	 */
	public void setStates(ArrayList<StatesClass> states) {
		this.states = states;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the saveLast
	 */
	public String getSaveLast() {
		return saveLast;
	}
	/**
	 * @param saveLast the saveLast to set
	 */
	public void setSaveLast(String saveLast) {
		this.saveLast = saveLast;
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
	 * @return the namePlayer
	 */
	public String getNamePlayer() {
		return namePlayer;
	}
	/**
	 * @param namePlayer the namePlayer to set
	 */
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	/**
	 * @return the hpMax
	 */
	public int getHpMax() {
		return hpMax;
	}
	/**
	 * @param hpMax the hpMax to set
	 */
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	/**
	 * @return the hpCurrent
	 */
	public int getHpCurrent() {
		return hpCurrent;
	}
	/**
	 * @param hpCurrent the hpCurrent to set
	 */
	public void setHpCurrent(int hpCurrent) {
		this.hpCurrent = hpCurrent;
	}
	/**
	 * @return the armorRatings
	 */
	public ArrayList<String> getArmorRatings() {
		return armorRatings;
	}
	/**
	 * @param armorRatings the armorRatings to set
	 */
	public void setArmorRatings(ArrayList<String> armorRatings) {
		this.armorRatings = armorRatings;
	}
	/**
	 * @return the moveRate
	 */
	public String getMoveRate() {
		return moveRate;
	}
	/**
	 * @param moveRate the moveRate to set
	 */
	public void setMoveRate(String moveRate) {
		this.moveRate = moveRate;
	}
	/**
	 * @return the magicResistance
	 */
	public String getMagicResistance() {
		return magicResistance;
	}
	/**
	 * @param magicResistance the magicResistance to set
	 */
	public void setMagicResistance(String magicResistance) {
		this.magicResistance = magicResistance;
	}
	/**
	 * @return the specialDefense
	 */
	public String getSpecialDefense() {
		return specialDefense;
	}
	/**
	 * @param specialDefense the specialDefense to set
	 */
	public void setSpecialDefense(String specialDefense) {
		this.specialDefense = specialDefense;
	}
	/**
	 * @return the specialAttacks
	 */
	public String getSpecialAttacks() {
		return specialAttacks;
	}
	/**
	 * @param specialAttacks the specialAttacks to set
	 */
	public void setSpecialAttacks(String specialAttacks) {
		this.specialAttacks = specialAttacks;
	}
	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}
	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}

	
	/**
	 * returns item as Element for XML output
	 * @return
	 */
//	public Element getAsElement(){
//		Element ePlayer = new Element("Player");
//		try {
//			// strings
//			ePlayer.addContent(new Element("name").setText(XMLControl.escapeChars(name)));	
//			ePlayer.addContent(new Element("namePlayer").setText(XMLControl.escapeChars(namePlayer)));			
//			
//			ePlayer.addContent(new Element("specialDefense").setText(XMLControl.escapeChars(specialDefense)));
//			ePlayer.addContent(new Element("specialAttacks").setText(XMLControl.escapeChars(specialAttacks)));
//			
//			ePlayer.addContent(new Element("moveRate").setText(XMLControl.escapeChars(moveRate)));
//			ePlayer.addContent(new Element("magicResistance").setText(XMLControl.escapeChars(magicResistance)));
//			ePlayer.addContent(new Element("alignment").setText(XMLControl.escapeChars(alignment)));
//
//
//			ePlayer.addContent(new Element("tag").setText(XMLControl.escapeChars(tag)));
//			ePlayer.addContent(new Element("notes").setText(XMLControl.escapeChars(notes)));
//			ePlayer.addContent(new Element("log").setText(XMLControl.escapeChars(log)));
//
//			ePlayer.addContent(new Element("pcClass").setText(XMLControl.escapeChars(pcClass)));
//			ePlayer.addContent(new Element("pcLevel").setText(XMLControl.escapeChars(pcLevel)));
//
//			// numbers
//			ePlayer.addContent(new Element("ID").setText(String.format("%d",iD)));
//			ePlayer.addContent(new Element("hpMax").setText(String.format("%d",hpMax)));
//			ePlayer.addContent(new Element("hpCurrent").setText(String.format("%d",hpCurrent)));
//
//		    
//			/**
//			 * Insert AC block
//			 */
//			if (getArmorRatings().size() > 0) {
//				Element eF = new Element("acRank");
//				for (String oAC : getArmorRatings())
//					eF.addContent(oAC);
//
//				ePlayer.addContent(eF);
//			}
//
//			if (getGear().size()> 0) {
//				Element eF = new Element("Gear");
//				for (EquipmentClass oE : getGear())
//					eF.addContent(oE.getAsElement());
//
//				ePlayer.addContent(eF);
//			}
//			
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save player.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return ePlayer;
//	}

	/**
	 * returns the entire Player listing as a Document
	 * so it can be output to XML file.
	 * 
	 * @param lList
	 * @param sRootName
	 * @return
	 */
//	public static Document xmlBuildDocFromList(ArrayList<PlayerClass> lList,	String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			PlayerClass oO = lList.get(i);
//			eRoot.addContent(oO.getAsElement());
//		}
//
//		return doc;
//	} // end buildDoc	
	
	/**
	 * build list of Players from XML Document
	 * @param doc
	 * @return
	 */
	public static ArrayList<PlayerClass> getListFromDoc(Document doc) {
		ArrayList<PlayerClass> lList = new ArrayList<PlayerClass>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("Player");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				PlayerClass oO = PlayerClass.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
			SimpleDialog
					.showError("NullpointerException:"
							+ err.getLocalizedMessage()
							+ "\n"
							+ "Error occured while trying to load player from XML.");
		}

		return lList;
	}

	/**
	 * return PlayerClass from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static PlayerClass getFromElements(Element eItem) {
		PlayerClass oO = new PlayerClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown");
		}
		try {		
			oO.setNamePlayer(XMLControl.unEscapeChars(eItem.getChild("namePlayer").getText()));		
		} catch (NullPointerException err) {
			oO.setNamePlayer("Unknown Player");
		}

		try {		
		oO.setSpecialDefense(XMLControl.unEscapeChars(eItem.getChild("specialDefense").getText()));		
		} catch (NullPointerException err) {
			oO.setSpecialDefense("NA");
		}
		try {		
		oO.setSpecialAttacks(XMLControl.unEscapeChars(eItem.getChild("specialAttack").getText()));		
		} catch (NullPointerException err) {
			oO.setSpecialAttacks("NA");
		}

		try {		
		oO.setMoveRate(XMLControl.unEscapeChars(eItem.getChild("moveRate").getText()));		
		} catch (NullPointerException err) {
			oO.setMoveRate("7");
		}
		try {		
		oO.setMagicResistance(XMLControl.unEscapeChars(eItem.getChild("magicResistance").getText()));		
		} catch (NullPointerException err) {
			oO.setMagicResistance("Standard");
		}

		try {		
		oO.setAlignment(XMLControl.unEscapeChars(eItem.getChild("alignment").getText()));		
		} catch (NullPointerException err) {
			oO.setAlignment("Neutral");
		}
		
		try {		
			oO.setNotes(XMLControl.unEscapeChars(eItem.getChild("notes").getText()));		
		} catch (NullPointerException err) {
				oO.setNotes("");
		}
		try {		
			oO.setLog(XMLControl.unEscapeChars(eItem.getChild("log").getText()));		
		} catch (NullPointerException err) {
				oO.setLog("");
		}
		
		try {		
			oO.setTag(XMLControl.unEscapeChars(eItem.getChild("tag").getText()));		
		} catch (NullPointerException err) {
				oO.setTag("");
		}
		
		try {		
			oO.setPcClass(XMLControl.unEscapeChars(eItem.getChild("pcClass").getText()));		
		} catch (NullPointerException err) {
				oO.setPcClass("");
		}
		try {		
			oO.setPcLevel(XMLControl.unEscapeChars(eItem.getChild("pcLevel").getText()));		
		} catch (NullPointerException err) {
				oO.setPcLevel("");
		}
		
		// ------------ ints
		
		try {		
		oO.setHpMax(Integer.parseInt(eItem.getChild("hpMax").getText()));		
		} catch (NullPointerException err) {
			oO.setHpMax(11);
		}
		try {		
		oO.setHpCurrent(Integer.parseInt(eItem.getChild("hpCurrent").getText()));		
		} catch (NullPointerException err) {
			oO.setHpCurrent(10);
		}


		try {
			oO.getArmorRatings().clear();
			java.util.List lacRanks = eItem.getChildren("acRank");
			Iterator inacRank = lacRanks.iterator();
			while (inacRank.hasNext()) {
				Element oE = (Element) inacRank.next();
				oO.getArmorRatings().add(oE.getText());				
			}
		} catch (NullPointerException err) {
			oO.getArmorRatings().clear();
		}			    
			
		try {
			oO.getGear().clear();
//			Element eTT = (Element) eItem.getChild("Gear");
//			java.util.List lTT = eTT.getChildren("EquipmentList");
//			Iterator inTTs = lTT.iterator();
//			while (inTTs.hasNext()) {
//				Element oE = (Element) inTTs.next();
//				oO.getGear().add(EquipmentClass.getFromElements(oE));
//			}
		} catch (NullPointerException err) {
			oO.getGear().clear();
		}			    
		
		return oO;
		
		
	}
	/**
	 * load xml sFilename and return the arraylist of Creatures
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<PlayerClass> loadFromXML(String sFileName) {
		ArrayList<PlayerClass> lList = new ArrayList<PlayerClass>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = PlayerClass.getListFromDoc(doc);
		return lList;
	}
	
	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((PlayerClass)o).name.toUpperCase());		
	}
	/**
	 * @return the myRace
	 */
	public PCRace getMyRace() {
		return myRace;
	}
	/**
	 * @param myRace the myRace to set
	 */
	public void setMyRace(PCRace myRace) {
		this.myRace = myRace;
	}
	/**
	 * @return the myWeaponProfs
	 */
	public ArrayList<String> getMyWeaponProfs() {
		return myWeaponProfs;
	}
	/**
	 * @param myWeaponProfs the myWeaponProfs to set
	 */
	public void setMyWeaponProfs(ArrayList<String> myWeaponProfs) {
		this.myWeaponProfs = myWeaponProfs;
	}
	/**
	 * @return the myNonWeaponProfs
	 */
	public ArrayList<String> getMyNonWeaponProfs() {
		return myNonWeaponProfs;
	}
	/**
	 * @param myNonWeaponProfs the myNonWeaponProfs to set
	 */
	public void setMyNonWeaponProfs(ArrayList<String> myNonWeaponProfs) {
		this.myNonWeaponProfs = myNonWeaponProfs;
	}
	/**
	 * @return the myAlignmentType
	 */
	public int getMyAlignmentType() {
		return myAlignmentType;
	}
	/**
	 * @param myAlignmentType the myAlignmentType to set
	 */
	public void setMyAlignmentType(int myAlignmentType) {
		this.myAlignmentType = myAlignmentType;
	}
	/**
	 * @return the myAbilityScores
	 */
	public ArrayList<AbilityScoreClass> getMyAbilityScores() {
		return myAbilityScores;
	}
	/**
	 * @param myAbilityScores the myAbilityScores to set
	 */
	public void setMyAbilityScores(ArrayList<AbilityScoreClass> myAbilityScores) {
		this.myAbilityScores = myAbilityScores;
	}
	/**
	 * @return the mySaves
	 */
	public ArrayList<Integer> getMySaves() {
		return mySaves;
	}
	/**
	 * @param mySaves the mySaves to set
	 */
	public void setMySaves(ArrayList<Integer> mySaves) {
		this.mySaves = mySaves;
	}
	/**
	 * @return the mySaveAdjustments
	 */
	public ArrayList<Integer> getMySaveAdjustments() {
		return mySaveAdjustments;
	}
	/**
	 * @param mySaveAdjustments the mySaveAdjustments to set
	 */
	public void setMySaveAdjustments(ArrayList<Integer> mySaveAdjustments) {
		this.mySaveAdjustments = mySaveAdjustments;
	}

	/**
	 * @return the genderType
	 */
	public int getGenderType() {
		return genderType;
	}
	/**
	 * @param genderType the genderType to set
	 */
	public void setGenderType(int genderType) {
		this.genderType = genderType;
	}
	//--------------------------------------------------------------
	//TODO finish these functions
	/**
	 * get best saves from class/race/extra-abilities and return them
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<Integer> getAllSaves(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		ArrayList<Integer> saves = new ArrayList<>();
		for(int i=0;i<MAX_SAVES;i++)
			saves.add(20);
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					for (int i=0;i<lE.getSaves().size();i++) {
						// if current save value greater than this 
						// use new value
						if (saves.get(i)> lE.getSaves().get(i)) {
							saves.set(i, lE.getSaves().get(i));
						}
					}
				} // was high enough level/exp
				
			}
		}

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getSaves().size();i++) {
				// if current save value greater than this 
				// use new value
			if (saves.get(i)> eA.getSaves().get(i)) {
				saves.set(i, eA.getSaves().get(i));
			}
		}
		
		return(saves);
	}
	
	/**
	 * return save bonuses total
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<Integer> getAllSaveAdjustments(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		ArrayList<Integer> saves = new ArrayList<>();
		for(int i=0;i<MAX_SAVES;i++)
			saves.add(0);
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					for (int i=0;i<lE.getSavesAdjustments().size();i++) {
						// if current save value greater than this 
						// use new value
						if (lE.getSavesAdjustments().get(i)!= 0)
							saves.set(i,saves.get(i)+lE.getSavesAdjustments().get(i));
					}
				} // was high enough level/exp
			}
		}
		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getSaveAdjustments().size();i++) {
				if (eA.getSaveAdjustments().get(i)!= 0)
					saves.set(i,saves.get(i)+eA.getSaveAdjustments().get(i));
			}
		
		return(saves);
	}
	
	/**
	 * there is no "base" ability score set. does nothing
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<AbilityScoreClass> getAllAbilityScores(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		return null;
	}
	
	/**
	 * get all the ability score adjustments from class/level/extra added up and return them
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<AbilityScoreClass> getAllAbilityScoreAdjustments(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		ArrayList<AbilityScoreClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_ABILITIES;i++)
			aScores.add(
					new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],0,25));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					for (int i=0;i<lE.getAbilityAdjustment().size();i++) {
						AbilityScoreClass oS = lE.getAbilityAdjustment().get(i);
						AbilityScoreClass aS = aScores.get(i);
						aS = abilityScoreAdjCompare(oS, aS);
					}
				} // was high enough level/exp
				
			}
		}

		// get racial adjustments
		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
		if (myRace != null) {
			for (int i=0;i<myRace.getAbilityAdjustment().size();i++) {
				AbilityScoreClass oS = myRace.getAbilityAdjustment().get(i);
				AbilityScoreClass aS = aScores.get(i);
				aS = abilityScoreAdjCompare(oS, aS);
			}
		}
		
		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getAbilityScoreAdjustments().size();i++) {
				AbilityScoreClass oS = eA.getAbilityScoreAdjustments().get(i);
				AbilityScoreClass aS = aScores.get(i);
				aS = abilityScoreAdjCompare(oS, aS);
			}

		return(aScores);
	}
	/**
	 * get a single ability score ABILITY_* = findMe
	 * 
	 * @param findMe
	 * @param cList
	 * @param eList
	 * @param rList
	 * @param aList
	 * @return
	 */
	public int getAbilityScore(int findMe, CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList, AbilityStatList aList) {
		
		int theStat = 0;
		
		ArrayList<AbilityScoreClass> abilityScoresAdj = 
				getAllAbilityScoreAdjustments(cList,eList, rList);

		AbilityScoreClass aJ = abilityScoresAdj.get(findMe);
		AbilityScoreClass aS = getMyAbilityScores().get(findMe);
		int abilityTotal = aS.getScore() + aJ.getScore();
		//int abilityPercentTotal = aS.getPercentile() + aJ.getPercentile();
		
		theStat = abilityTotal;

		return theStat;
	}
	
	/**
	 * add adjustment oS to aS, account for percentile > 100 and return updated aS
	 * 
	 * @param oS
	 * @param aS
	 * @return
	 */
	private AbilityScoreClass abilityScoreAdjCompare(AbilityScoreClass oS, AbilityScoreClass aS) {
		int oScore = oS.getScore();
		int oPercentile = oS.getPercentile();
		int aScore = aS.getScore();
		int aPercentile = aS.getPercentile();
		aScore += oScore;
		aPercentile += oPercentile;
		// at > 100% inc score 1, add extra to next percentile
		if (aPercentile > 100) {
			aPercentile = aPercentile - 100;
			aScore ++;
		}
		aS.setScore(aScore);
		aS.setPercentile(aPercentile);
		return(aS);
	}
	
	/**
	 * return arraylist of base skills
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<SkillsClass> getAllThiefSkillsBase(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		ArrayList<SkillsClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			aScores.add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					for (int i=0;i<lE.getThiefSkills().size();i++) {
						SkillsClass oS = lE.getThiefSkills().get(i);
						SkillsClass aS = aScores.get(i);
						aS = skillsCompare(oS, aS);
					}
				} // was high enough level/exp
				
			}
		}

		// get racial adjustments
		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
		if (myRace != null) {
			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsCompare(oS, aS);
			}
		}
		
		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getThiefSkillsBase().size();i++) {
				SkillsClass oS = eA.getThiefSkillsBase().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsCompare(oS, aS);
			}

		return(aScores);
	}
	/**
	 * test oS for valid value, if valid set base score to it.
	 * 
	 * @param oS
	 * @param aS
	 * @return
	 */
	private SkillsClass skillsCompare(SkillsClass oS, SkillsClass aS) {
		if (oS.getScore() > oS.getScore())
			aS.setScore(oS.getScore());
		return(aS);
	}
	
	/**
	 * return array list of all skill adjustment values
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public ArrayList<SkillsClass> getAllThiefSkillAdjustments(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		ArrayList<SkillsClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			aScores.add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					for (int i=0;i<lE.getThiefSkills().size();i++) {
						SkillsClass oS = lE.getThiefSkills().get(i);
						SkillsClass aS = aScores.get(i);
						aS = skillsAdjustments(oS, aS);
					}
				} // was high enough level/exp
				
			}
		}

		// get racial adjustments
		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
		if (myRace != null) {
			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsAdjustments(oS, aS);
			}
		}
		
		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getThiefSkillsBase().size();i++) {
				SkillsClass oS = eA.getThiefSkillsBase().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsAdjustments(oS, aS);
			}

		return(aScores);
	}
	
	/**
	 * add adjustment to total
	 * 
	 * @param oS
	 * @param aS
	 * @return
	 */
	private SkillsClass skillsAdjustments(SkillsClass oS, SkillsClass aS) {
			aS.score += oS.getScore();
		return(aS);
	}

	/**
	 * return spells per level from all sources
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public int[] getAllArcaneSpellsPerLevel(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		int aScores[] = new int[MAX_MAGE_SPELL_LEVEL];


		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						for (int i=0;i<lE.getSpellsPerLevelArcane().length;i++) {
							int iS = lE.getSpellsPerLevelArcane()[i];
							aScores[i] += iS;
						}
					} // was high enough level/exp

				}
		}

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getMageSpellsBase().length;i++) {
				int  iS = eA.getMageSpellsBase()[i];
				aScores[i] += iS;
			}

		return(aScores);
	}

	/**
	 * return all cleric spells per level from all sources
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public int[] getAllDivineSpellsPerLevel(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		int aScores[] = new int[MAX_CLERIC_SPELL_LEVEL];


		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						for (int i=0;i<lE.getSpellsPerLevelDivine().length;i++) {
							int iS = lE.getSpellsPerLevelDivine()[i];
							aScores[i] += iS;
						}
					} // was high enough level/exp

				}
		}

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getClericSpellsBase().length;i++) {
				int  iS = eA.getClericSpellsBase()[i];
				aScores[i] += iS;
			}

		return(aScores);
	}

	/**
	 * return all bonus spell slots from all sources
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @param aList
	 * @return
	 */
	public int[] getAllArcaneBonusSpellsPerLevel(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList, AbilityStatList aList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		int aScores[] = new int[MAX_MAGE_SPELL_LEVEL];

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getMageSpellsBonus().length;i++) {
				int  iS = eA.getMageSpellsBonus()[i];
				aScores[i] += iS;
			}
		//get spells from ability scores (wisdom/int)
		int abilityTotal = 
				getAbilityScore(ABILITY_INTELLIGENCE, cList, eList, rList, aList);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = 
					aList.getContent().get(abilityTotal);
			for(int i=0;i<aStat.intelligence.bonusSpells.length;i++)
				aScores[i] += aStat.intelligence.bonusSpells[i];
		}
		
		return(aScores);
	}

	/**
	 * return all bonus spell slots from all sources
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @param aList
	 * @return
	 */
	public int[] getAllDivineBonusSpellsPerLevel(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList, AbilityStatList aList) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		int aScores[] = new int[MAX_CLERIC_SPELL_LEVEL];

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getClericSpellsBonus().length;i++) {
				int  iS = eA.getClericSpellsBonus()[i];
				aScores[i] += iS;
			}
		
		//get spells from ability scores (wisdom/int)	
		int abilityTotal = 
				getAbilityScore(ABILITY_WISDOM, cList, eList, rList, aList);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = 
					aList.getContent().get(abilityTotal);
			for(int i=0;i<aStat.wisdom.bonusSpells.length;i++)
				aScores[i] += aStat.wisdom.bonusSpells[i];
		}
		
		return(aScores);
	}

	
	public int getTHACO(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		int bestTHACO = 20;
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					if (lE.getThaco() < bestTHACO)
						bestTHACO = lE.getThaco();
				} // was high enough level/exp
				
			}
		}

//		// get racial adjustments
//		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
//		if (myRace != null) {
//			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
//				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
//				SkillsClass aS = aScores.get(i);
//				aS = skillsCompare(oS, aS);
//			}
//		}
		
//		// now flip through all extraAbilities
//		for (ExtraAbilitiesClass eA : extras)
//			for (int i=0;i<eA.getThiefSkillsBase().size();i++) {
//				SkillsClass oS = eA.getThiefSkillsBase().get(i);
//				SkillsClass aS = aScores.get(i);
//				aS = skillsCompare(oS, aS);
//			}

		return(bestTHACO);
	}

	public int[] getMatrix(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);
		
		int aMatrix[] = new int[MAX_MATRIX];
		for(int i=0;i<aMatrix.length;i++)
			aMatrix[i] = 99;
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					// get the lowest roll needed to hit
					for (int i=0;i<lE.getAttackMatrix().length;i++) {
						int curTHAC = lE.getAttackMatrix()[i];
						if (curTHAC < aMatrix[i])
							aMatrix[i] = curTHAC;
					}
				} // was high enough level/exp
				
			}
		}

//		// get racial adjustments
//		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
//		if (myRace != null) {
//			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
//				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
//				SkillsClass aS = aScores.get(i);
//				aS = skillsCompare(oS, aS);
//			}
//		}
		
//		// now flip through all extraAbilities
//		for (ExtraAbilitiesClass eA : extras)
//			for (int i=0;i<eA.getThiefSkillsBase().size();i++) {
//				SkillsClass oS = eA.getThiefSkillsBase().get(i);
//				SkillsClass aS = aScores.get(i);
//				aS = skillsCompare(oS, aS);
//			}

		return(aMatrix);
	}
	
	/**
	 * return the name of this character's race
	 * 
	 * @param rList
	 * @return
	 */
	public String getMyRaceName(RaceList rList) {
		String myRaceName = "NoRaceFound";

		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
		if (myRace != null)
			myRaceName = myRace.getName();
		
		return(myRaceName);
	}
	
	/**
	 * return if the character has barbarian dex feature
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasBarbarianDex(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {

		boolean isBarb = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isBarbarianDexBonus())
				isBarb = true;

		return isBarb;	
	}
	
	/**
	 * return if has barbarian con feature
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasBarbarianCon(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isBarb = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isBarbarianConBonus())
				isBarb = true;

		return isBarb;	
	}

	/**
	 * return is the character has a fighter con feature
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasFighterCon(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isFighter = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isFighterConBonus())
				isFighter = true;

		return isFighter;	
	}

	/**
	 * can they have weapon mastery
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasWeaponMastery(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isAllowedWeaponMastery())
				isTrue = true;

		return isTrue;	
	}
	/**
	 * can they double specialize 
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasDoubleSpecialization(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isAllowedDoubeSpecialize())
				isTrue = true;

		return isTrue;	
	}
	/**
	 * can they specialize
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasSpecialization(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, cList, eList, rList);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isAllowedSpecialize())
				isTrue = true;

		return isTrue;	
	}

	/**
	 * does the character have the percentile strength feature
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasPercentileStrength(CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {
		boolean isTrue = false;

		for(PCClass cC: getMyClass()) {
			CharacterClass oC = CharacterClass.getClassByMyID(cC.getClassID(), cList);
			if (oC != null) {
				if (oC.percentileStrength)
					isTrue = true;
			}
		}
		
		return isTrue;	
	}
	
}
