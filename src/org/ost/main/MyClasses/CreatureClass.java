/**
 * 
 */
package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.EncounterCreature;
import org.ost.main.EncounterCreatureAttack;
import org.ost.main.MainClass;
import org.ost.main.MyUtils.*;

/**
 * @author Celestian
 *
 */
public class CreatureClass implements Serializable, Comparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public int ID;
	public String myID;
	public String Name;
	public String HD; // hit dice
	public int Level;
	public int Attacks; // number of attacks
	public String Damage; // attack string 1d3/1d3/1d12 or by weapon
	public String AC; // armor class
	public String MaxHP; 
	public String HitPoints; // rolled hit points or dice to roll 1d4/etc
	public String Description;
	public String Treasure;
	public String Size;
	public String SpecialDefense;
	public String SpecialAttack;
	public String EncounterSize; // dice roll of number encounterd
	public String Move;
	public String MagicResistance;
	public String Intelligence;
	public String Alignment;
	public int BaseXP;
	public int XPperHP;
	public String Frequency;
	public ArrayList<String> Atks;

	public String Type; 
	public String Climate;
	public String Terrain;
	public String ActivityCycle;
	public String Diet;
	public String InLair;
	public String Morale;
	public String PsionicAbility;
	public String PsionicModes;
	public String Source;
	public String THACO;
	public String Organization;

	//	tmp value used when managing an encounter
	public int initRoll;
	// vars used when saving creatures in encounters
	public String Tag; // temporary tag/note flag encounters
	public transient EncounterCreature Encountered;
	//public AttackMatrix attackMatrix;
	public String matrixHD; // HD formated for AttackMatrix lookups.
	public ArrayList<StatesClass> states;
	public ArrayList<CreatureAttackClass> AttackList; // list of attacks for Encounters
	public String notes;
	public ArrayList<PlayerClass> fightingList; // fighting these
	public DefaultMutableTreeNode fightingNode;

	// 

	
	public CreatureClass() {
		this("Critter",0);
	}
	/**
	 * 
	 * @param sName
	 */
	public CreatureClass(String sName) {
		this(sName,0);
	}

	/***
	 * 
	 * @param sName
	 * @param iID
	 */
	public CreatureClass(String sName, int iID) {
		this.setName(sName);
		//this.setID(iID);
		this.setAtks(new ArrayList<String>());
		Atks.add("1d4");
		
		this.setHD("1");
		this.setAC("10");
		this.setMaxHP("1");
		this.setHitPoints("1");
		this.setDamage("1d4");
		this.setAttacks(1);
		this.setLevel(-1);
		this.setDescription("A strange and wonderful creature.");
		this.setTreasure("J");
		this.setSize("M");
		this.setSpecialAttack("NA");
		this.setSpecialDefense("NA");
		this.setEncounterSize("1d4");
		this.setMove("9");
		this.setMagicResistance("Standard");
		this.setIntelligence("Low");
		this.setAlignment("Chaotic Evil");
		this.setBaseXP(10);
		this.setXPperHP(1);
		this.setFrequency("Common");
		
		this.setType("NA");
		this.setClimate("NA");
		this.setTerrain("NA");
		this.setActivityCycle("NA");
		this.setDiet("NA");
		this.setInLair("NA");
		this.setMorale("NA");
		this.setPsionicAbility("NA");
		this.setPsionicModes("NA");
		this.setSource("NA");
		this.setTHACO("NA");
		
		this.setEncountered(null);
		this.setStates((new ArrayList<StatesClass>()));
		this.setAttackList((new ArrayList<CreatureAttackClass>()));
		this.setMatrixHD("");
		this.setTag("");
		this.setNotes("");
		this.setFightingList(new ArrayList<PlayerClass>());
		this.setFightingNode(new DefaultMutableTreeNode("Fighting"));

		this.setMyID(UUID.randomUUID().toString());

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
	public ArrayList<PlayerClass> getFightingList() {
		return fightingList;
	}
	/**
	 * @param fightingList the fightingList to set
	 */
	public void setFightingList(ArrayList<PlayerClass> fightingList) {
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
	@Override
	public String toString() {
		return(getName());
	}
	
	/**
	 * @return the matrixHD
	 */
	public String getMatrixHD() {
		return matrixHD;
	}
	/**
	 * @param matrixHD the matrixHD to set
	 */
	public void setMatrixHD(String matrixHD) {
		this.matrixHD = matrixHD;
	}
	/**
	 * @return the attackList
	 */
	public ArrayList<CreatureAttackClass> getAttackList() {
		return AttackList;
	}
	/**
	 * @param attackList the attackList to set
	 */
	public void setAttackList(ArrayList<CreatureAttackClass> attackList) {
		AttackList = attackList;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return Tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		Tag = tag;
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
	 * @return the encountered
	 */
	public EncounterCreature getEncountered() {
		return Encountered;
	}
	/**
	 * @param encountered the encountered to set
	 */
	public void setEncountered(EncounterCreature encountered) {
		Encountered = encountered;
	}
	/**
	 * @return the attackMatrix
	 */
//	public AttackMatrix getAttackMatrix() {
//		return attackMatrix;
//	}
//	/**
//	 * @param attackMatrix the attackMatrix to set
//	 */
//	public void setAttackMatrix(AttackMatrix attackMatrix) {
//		this.attackMatrix = attackMatrix;
//	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return Organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		Organization = organization;
	}
	/***
	 * create class with no parameters.
	 */
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * @return the climate
	 */
	public String getClimate() {
		return Climate;
	}
	/**
	 * @param climate the climate to set
	 */
	public void setClimate(String climate) {
		Climate = climate;
	}
	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return Terrain;
	}
	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(String terrain) {
		Terrain = terrain;
	}
	/**
	 * @return the activityCycle
	 */
	public String getActivityCycle() {
		return ActivityCycle;
	}
	/**
	 * @param activityCycle the activityCycle to set
	 */
	public void setActivityCycle(String activityCycle) {
		ActivityCycle = activityCycle;
	}
	/**
	 * @return the diet
	 */
	public String getDiet() {
		return Diet;
	}
	/**
	 * @param diet the diet to set
	 */
	public void setDiet(String diet) {
		Diet = diet;
	}
	/**
	 * @return the inLair
	 */
	public String getInLair() {
		return InLair;
	}
	/**
	 * @param inLair the inLair to set
	 */
	public void setInLair(String inLair) {
		InLair = inLair;
	}
	/**
	 * @return the morale
	 */
	public String getMorale() {
		return Morale;
	}
	/**
	 * @param morale the morale to set
	 */
	public void setMorale(String morale) {
		Morale = morale;
	}
	/**
	 * @return the psionicAbility
	 */
	public String getPsionicAbility() {
		return PsionicAbility;
	}
	/**
	 * @param psionicAbility the psionicAbility to set
	 */
	public void setPsionicAbility(String psionicAbility) {
		PsionicAbility = psionicAbility;
	}
	/**
	 * @return the psionicModes
	 */
	public String getPsionicModes() {
		return PsionicModes;
	}
	/**
	 * @param psionicModes the psionicModes to set
	 */
	public void setPsionicModes(String psionicModes) {
		PsionicModes = psionicModes;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return Source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		Source = source;
	}
	/**
	 * @return the tHACO
	 */
	public int getTHACO(List<ChartClass> chartList) {
		int myThaco = 20;
		// 20 is default, if it is a number and not 20 we use it, otherwise we figure it out
		if (MyParse.isInteger(THACO) && Integer.parseInt(THACO)!=20)
			myThaco = Integer.parseInt(THACO);
		else if (chartList != null){
			// if level is not -1 or 1 then use it, otherwise use HD 
			String myHD = Math.abs(getLevel())==1?getMatrixHD():String.format("%d", getLevel());

			if (MyParse.isInteger(myHD)) {
				// if HD > 26 max save chart is 26
				if (Integer.parseInt(myHD)>26)
					myHD = "26";
				// if HD < 0 minimum save chart is 0
				if (Integer.parseInt(myHD)< 0)
					myHD = "0";
			}
			myThaco = Utils.getChartColumnValue(CHART_MONSTER_THACO,myHD, 0, 1, chartList);
		}
		return myThaco;
	}
	/**
	 * @param tHACO the tHACO to set
	 */
	public void setTHACO(String tHACO) {
		THACO = tHACO;
	}
	
	/**
	 * @return the attacks
	 */
	public String getDamage() {
		return Damage;
	}
	/**
	 * @param attacks the attacks to set
	 */
	public void setDamage(String attacks) {
		Damage = attacks;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return Level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		Level = level;
	}
	/**
	 * @param attacks the attacks to set
	 */
	public void setAttacks(int attacks) {
		Attacks = attacks;
	}
	/**
	 * @return the attacks
	 */
	public int getAttacks() {
		return Attacks;
	}
	
	@Override
	public int compareTo(Object o) {
	     return Name.toUpperCase().compareTo(((CreatureClass)o).Name.toUpperCase());		
	}

	/**
	 * @return the aC
	 */
	public String getAC() {
		return AC;
	}
	/**
	 * @param aC the aC to set
	 */
	public void setAC(String aC) {
		AC = aC;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}


	/**
	 * @return the hD
	 */
	public String getHD() {
		return HD;
	}


	/**
	 * @param hD the hD to set
	 */
	public void setHD(String hD) {
		HD = hD;
	}


	/**
	 * @return the maxHP
	 */
	public String getMaxHP() {
		return MaxHP;
	}


	/**
	 * @param maxHP the maxHP to set
	 */
	public void setMaxHP(String maxHP) {
		MaxHP = maxHP;
	}


	/**
	 * @return the hitPoints
	 */
	public String getHitPoints() {
		return HitPoints;
	}


	/**
	 * @param hitPoints the hitPoints to set
	 */
	public void setHitPoints(String hitPoints) {
		HitPoints = hitPoints;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}


	/**
	 * @return the treasure
	 */
	public String getTreasure() {
		return Treasure;
	}


	/**
	 * @param treasure the treasure to set
	 */
	public void setTreasure(String treasure) {
		Treasure = treasure;
	}


	/**
	 * @return the size
	 */
	public String getSize() {
		return Size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		Size = size;
	}


	/**
	 * @return the specialDefense
	 */
	public String getSpecialDefense() {
		return SpecialDefense;
	}


	/**
	 * @param specialDefense the specialDefense to set
	 */
	public void setSpecialDefense(String specialDefense) {
		SpecialDefense = specialDefense;
	}


	/**
	 * @return the specialAttack
	 */
	public String getSpecialAttack() {
		return SpecialAttack;
	}


	/**
	 * @param specialAttack the specialAttack to set
	 */
	public void setSpecialAttack(String specialAttack) {
		SpecialAttack = specialAttack;
	}


	/**
	 * @return the encounterSize
	 */
	public String getEncounterSize() {
		return EncounterSize;
	}


	/**
	 * @param encounterSize the encounterSize to set
	 */
	public void setEncounterSize(String encounterSize) {
		EncounterSize = encounterSize;
	}


	/**
	 * @return the move
	 */
	public String getMove() {
		return Move;
	}


	/**
	 * @param move the move to set
	 */
	public void setMove(String move) {
		Move = move;
	}


	/**
	 * @return the magicResistance
	 */
	public String getMagicResistance() {
		return MagicResistance;
	}


	/**
	 * @param magicResistance the magicResistance to set
	 */
	public void setMagicResistance(String magicResistance) {
		MagicResistance = magicResistance;
	}


	/**
	 * @return the intelligence
	 */
	public String getIntelligence() {
		return Intelligence;
	}


	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(String intelligence) {
		Intelligence = intelligence;
	}


	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return Alignment;
	}


	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		Alignment = alignment;
	}


	/**
	 * @return the baseXP
	 */
	public int getBaseXP() {
		return BaseXP;
	}


	/**
	 * @param baseXP the baseXP to set
	 */
	public void setBaseXP(int baseXP) {
		BaseXP = baseXP;
	}


	/**
	 * @return the xPperHP
	 */
	public int getXPperHP() {
		return XPperHP;
	}


	/**
	 * @param xPperHP the xPperHP to set
	 */
	public void setXPperHP(int xPperHP) {
		XPperHP = xPperHP;
	}


	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return Frequency;
	}


	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		Frequency = frequency;
	}


	/**
	 * @return the atks
	 */
	public ArrayList<String> getAtks() {
		return Atks;
	}


	/**
	 * @param atks the atks to set
	 */
	public void setAtks(ArrayList<String> atks) {
		Atks = atks;
	}
	
	/**
	 * 
	 * @param aList
	 * @return
	 */
	public boolean exists(List<CreatureClass> aList) {
		boolean foundMatch = false;
		for (CreatureClass oS : aList) {
			if (getName().equalsIgnoreCase(oS.getName())) {
				foundMatch = true;
				break; // kill for(), start over with new name.
			}
		}
		return(foundMatch);
	}

	/**
	 * return AC hit from matrix chart
	 * 
	 * @param attackRoll
	 * @param chartList
	 * @return
	 */
	public int getACHit(int attackRoll, List<ChartClass> chartList) {
		int myACHit = 10;
		int myLevel = 0;
		// if level is not -1 or 1 then use it, otherwise use HD 
		String myHD = Math.abs(getLevel())==1?getMatrixHD():String.format("%d", getLevel());

		if (MyParse.isInteger(myHD)) {
			// if HD > 26 max save chart is 26
			if (Integer.parseInt(myHD)>26)
				myHD = "26";
			// if HD < 0 minimum save chart is 0
			if (Integer.parseInt(myHD)< 0)
				myHD = "0";
		}

		ChartClass oC = ChartClass.getChartByName(CHART_MONSTER_MATRIX, chartList);
		if (oC != null) {
			ChartColumn levelsC = (ChartColumn) oC.getColumn().toArray()[0];
			//ChartColumn savesC = (ChartColumn) oC.getColumn().toArray()[saveType];

			for (int i=0;i<levelsC.row.size();i++) {
				//					MainClass.ddprint(String.format("levelsC row:%s\n", levelsC.getRowValue(i)));

				//	this row is our level, find matching spot in saves column.
				if (myHD.equalsIgnoreCase(levelsC.getRowValue(i))) {
					myLevel = i;
					break; // kill for loop
				}
			}

			Object[] list = oC.getColumn().toArray();
			for (int i=1;i<list.length;i++) {
				ChartColumn currentChart = (ChartColumn) list[i];
				int currentAC = i-(11);
				int currentRoll = Integer.parseInt(currentChart.getRowValue(myLevel)); 
				if (attackRoll >= currentRoll) {
					myACHit = currentAC;
					break;
				}

				//MainClass.ddprint(String.format("savesC row:%s\n", savesC.getRowValue(i)));
			}

		} else {
			SimpleDialog.showError("Unable to find monster matrix chart:"+CHART_MONSTER_MATRIX+"");
		}
		return(myACHit);
	}
	
	/**
	 * return String array containing the list of dice rolls needed to hit
	 * 10..0..-10
	 * @param chartList
	 * @return
	 */
	public ArrayList<String> getMatrix(List<ChartClass> chartList) {
		int myLevel = 0;
		// if level is not -1 or 1 then use it, otherwise use HD 
		String myHD = Math.abs(getLevel())==1?getMatrixHD():String.format("%d", getLevel());

		if (MyParse.isInteger(myHD)) {
			// if HD > 26 max save chart is 26
			if (Integer.parseInt(myHD)>26)
				myHD = "26";
			// if HD < 0 minimum save chart is 0
			if (Integer.parseInt(myHD)< 0)
				myHD = "0";
		}
		
		return(Utils.getChartRow(CHART_MONSTER_MATRIX,myHD,chartList));
	}

	/**
	 * return Base Attack bonuse
	 * @param chartList
	 * @return
	 */
	public int getBab(List<ChartClass> chartList) {
		int myBAB = 0;
			// if level is not -1 or 1 then use it, otherwise use HD 
		String myHD = Math.abs(getLevel())==1?getMatrixHD():String.format("%d", getLevel());

			if (MyParse.isInteger(myHD)) {
				// if HD > 26 max save chart is 26
				if (Integer.parseInt(myHD)>26)
					myHD = "26";
				// if HD < 0 minimum save chart is 0
				if (Integer.parseInt(myHD)< 0)
					myHD = "0";
			}
			myBAB = Utils.getChartColumnValue(CHART_MONSTER_BAB, 
							myHD, 0, 1, chartList);
		return myBAB;
	}
	
	/**
	 * get required roll to save for this type
	 * 
	 * @param saveType
	 * @param chartList
	 * @return
	 */
	public int getSave(int saveType, List<ChartClass> chartList) {
		String myHD = getHD();
		String regEX = "(\\d+).*?"; // match just the first number for this
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(getHD());

		if (m.find()) {
			myHD = m.group(1);
			//				MainClass.ddprint(String.format("getSave FOUND myHD=%s\n", myHD));
		} else {
			MainClass.ddprint(String.format("getSave NOFIND HD=%s for %s\n", myHD, getName()));
		}

		// if HD > 20 max save chart is 20
		if (Integer.parseInt(myHD)>20)
			myHD = "20";
		// if HD < 0 minimum save chart is 0
		if (Integer.parseInt(myHD)< 0)
			myHD = "0";

		//			MainClass.ddprint(String.format("getSave HD=%s\n", myHD));
		return(Utils.getChartColumnValue(CHART_MONSTER_SAVE, 
				myHD, 0, saveType, chartList));
	}


	/**
	 * return array list of save values for this creature
	 * 
	 * @param chartList
	 * @return
	 */
	public ArrayList<String> getSaves(List<ChartClass> chartList) {
		String myHD = getHD();
		String regEX = "(\\d+).*?"; // match just the first number for this
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(getHD());

		if (m.find()) {
			myHD = m.group(1);
			//				MainClass.ddprint(String.format("getSave FOUND myHD=%s\n", myHD));
		} else {
			MainClass.ddprint(String.format("getSaves NOFIND HD=%s for %s\n", myHD, getName()));
		}

		// if HD > 20 max save chart is 20
		if (Integer.parseInt(myHD)>20)
			myHD = "20";
		// if HD < 0 minimum save chart is 0
		if (Integer.parseInt(myHD)< 0)
			myHD = "0";

		return(Utils.getChartRow(CHART_MONSTER_SAVE,myHD,chartList));
	}
	
	/**
	 * returns item as Element for XML output
	 * @return
	 */
	public Element getAsElement(){
		Element eCreature = new Element("Creature");
		try {
			// strings
			eCreature.addContent(new Element("Name").setText(XMLControl.escapeChars(Name)));	
			eCreature.addContent(new Element("Description").setText(XMLControl.escapeChars(Description)));
			eCreature.addContent(new Element("HD").setText(XMLControl.escapeChars(HD)));
			eCreature.addContent(new Element("matrixHD").setText(XMLControl.escapeChars(matrixHD)));
			eCreature.addContent(new Element("AC").setText(XMLControl.escapeChars(AC)));
			
			eCreature.addContent(new Element("MaxHP").setText(XMLControl.escapeChars(MaxHP)));
			eCreature.addContent(new Element("HitPoints").setText(XMLControl.escapeChars(HitPoints)));
			eCreature.addContent(new Element("Damage").setText(XMLControl.escapeChars(Damage)));
			eCreature.addContent(new Element("Treasure").setText(XMLControl.escapeChars(Treasure)));
			eCreature.addContent(new Element("Size").setText(XMLControl.escapeChars(Size)));

			eCreature.addContent(new Element("SpecialDefense").setText(XMLControl.escapeChars(SpecialDefense)));
			eCreature.addContent(new Element("SpecialAttack").setText(XMLControl.escapeChars(SpecialAttack)));
			eCreature.addContent(new Element("EncounterSize").setText(XMLControl.escapeChars(EncounterSize)));
			eCreature.addContent(new Element("Move").setText(XMLControl.escapeChars(Move)));
			eCreature.addContent(new Element("MagicResistance").setText(XMLControl.escapeChars(MagicResistance)));
			eCreature.addContent(new Element("Intelligence").setText(XMLControl.escapeChars(Intelligence)));
			eCreature.addContent(new Element("Alignment").setText(XMLControl.escapeChars(Alignment)));
			eCreature.addContent(new Element("Frequency").setText(XMLControl.escapeChars(Frequency)));


			eCreature.addContent(new Element("Type").setText(XMLControl.escapeChars(Type)));
			eCreature.addContent(new Element("Climate").setText(XMLControl.escapeChars(Climate)));
			eCreature.addContent(new Element("Terrain").setText(XMLControl.escapeChars(Terrain)));
			eCreature.addContent(new Element("ActivityCycle").setText(XMLControl.escapeChars(ActivityCycle)));
			eCreature.addContent(new Element("Diet").setText(XMLControl.escapeChars(Diet)));
			eCreature.addContent(new Element("InLair").setText(XMLControl.escapeChars(InLair)));
			eCreature.addContent(new Element("Morale").setText(XMLControl.escapeChars(Morale)));
			eCreature.addContent(new Element("PsionicAbility").setText(XMLControl.escapeChars(PsionicAbility)));
			eCreature.addContent(new Element("PsionicModes").setText(XMLControl.escapeChars(PsionicModes)));
			eCreature.addContent(new Element("Source").setText(XMLControl.escapeChars(Source)));
			eCreature.addContent(new Element("THACO").setText(XMLControl.escapeChars(THACO)));

			eCreature.addContent(new Element("Organization").setText(XMLControl.escapeChars(Organization)));

			eCreature.addContent(new Element("Tag").setText(XMLControl.escapeChars(Tag)));
			eCreature.addContent(new Element("notes").setText(XMLControl.escapeChars(notes)));

			// numbers
			eCreature.addContent(new Element("BaseXP").setText(String.format("%d",BaseXP)));
			eCreature.addContent(new Element("XPperHP").setText(String.format("%d",XPperHP)));

			eCreature.addContent(new Element("Level").setText(String.format("%d",Level)));
			eCreature.addContent(new Element("Attacks").setText(String.format("%d",Attacks)));
		    
			/**
			 * Insert Atks block
			 */
			if (getAttackList().size() > 0) {
				Element eF = new Element("AttacksList");
				for (CreatureAttackClass oAtk : getAttackList())
					eF.addContent(oAtk.getAsElement());

				eCreature.addContent(eF);
			}


		}
	    catch (java.lang.OutOfMemoryError err) {
	      SimpleDialog.showError("Out of memory error while trying to save creature.\nError:" +
	                        err.getLocalizedMessage());
	    }
		return eCreature;
	}

	/**
	 * returns the entire Race listing as a Document
	 * so it can be output to XML file.
	 * 
	 * @param lList
	 * @param sRootName
	 * @return
	 */
	public static Document xmlBuildDocFromList(ArrayList<CreatureClass> lList,	String sRootName) {
		Element eRoot = new Element(sRootName);
		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
		Document doc = new Document(eRoot);

		for (int i = 0; i < lList.size(); i++) {
			CreatureClass oO = lList.get(i);
			eRoot.addContent(oO.getAsElement());
		}

		return doc;
	} // end buildDoc	
	
	/**
	 * build list of Creatures from XML Document
	 * @param doc
	 * @return
	 */
	public static ArrayList<CreatureClass> getListFromDoc(Document doc) {
		ArrayList<CreatureClass> lList = new ArrayList<CreatureClass>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("Creature");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				CreatureClass oO = CreatureClass.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
			SimpleDialog
					.showError("NullpointerException:"
							+ err.getLocalizedMessage()
							+ "\n"
							+ "Error occured while trying to load creature from XML.");
		}

		return lList;
	}

	/**
	 * return CreatureClass from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static CreatureClass getFromElements(Element eItem) {
		CreatureClass oO = new CreatureClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown");
		}
		
		try {		
			oO.setHD(XMLControl.unEscapeChars(eItem.getChild("HD").getText()));
		} catch (NullPointerException err) {
			oO.setHD("1");
		}

		try {		
			oO.setMatrixHD(XMLControl.unEscapeChars(eItem.getChild("matrixHD").getText()));
		} catch (NullPointerException err) {
			oO.setMatrixHD("0");
		}

		try {		
		oO.setAC(XMLControl.unEscapeChars(eItem.getChild("AC").getText()));
		} catch (NullPointerException err) {
			oO.setAC("10");
		}
		
		try {		
		oO.setMaxHP(XMLControl.unEscapeChars(eItem.getChild("MaxHP").getText()));		
		} catch (NullPointerException err) {
			oO.setMaxHP("1");
		}
		try {		
		oO.setHitPoints(XMLControl.unEscapeChars(eItem.getChild("HitPoints").getText()));		
		} catch (NullPointerException err) {
			oO.setHitPoints("1");
		}

		try {		
		oO.setDamage(XMLControl.unEscapeChars(eItem.getChild("Damage").getText()));		
		} catch (NullPointerException err) {
			oO.setDamage("1d7");
		}

		try {		
		oO.setDescription(XMLControl.unEscapeChars(eItem.getChild("Description").getText()));		
		} catch (NullPointerException err) {
			oO.setDescription("Lost.");
		}
		try {		
		oO.setTreasure(XMLControl.unEscapeChars(eItem.getChild("Treasure").getText()));		
		} catch (NullPointerException err) {
			oO.setTreasure("J");
		}
		try {		
		oO.setSize(XMLControl.unEscapeChars(eItem.getChild("Size").getText()));		
		} catch (NullPointerException err) {
			oO.setSize("Tiny");
		}

		try {		
		oO.setSpecialDefense(XMLControl.unEscapeChars(eItem.getChild("SpecialDefense").getText()));		
		} catch (NullPointerException err) {
			oO.setSpecialDefense("NA");
		}
		try {		
		oO.setSpecialAttack(XMLControl.unEscapeChars(eItem.getChild("SpecialAttack").getText()));		
		} catch (NullPointerException err) {
			oO.setSpecialAttack("NA");
		}

		try {		
		oO.setEncounterSize(XMLControl.unEscapeChars(eItem.getChild("EncounterSize").getText()));		
		} catch (NullPointerException err) {
			oO.setEncounterSize("1");
		}
		try {		
		oO.setMove(XMLControl.unEscapeChars(eItem.getChild("Move").getText()));		
		} catch (NullPointerException err) {
			oO.setMove("7");
		}
		try {		
		oO.setMagicResistance(XMLControl.unEscapeChars(eItem.getChild("MagicResistance").getText()));		
		} catch (NullPointerException err) {
			oO.setMagicResistance("Standard");
		}
		try {		
		oO.setIntelligence(XMLControl.unEscapeChars(eItem.getChild("Intelligence").getText()));		
		} catch (NullPointerException err) {
			oO.setIntelligence("Lowest");
		}

		try {		
		oO.setAlignment(XMLControl.unEscapeChars(eItem.getChild("Alignment").getText()));		
		} catch (NullPointerException err) {
			oO.setAlignment("Neutral");
		}
		try {		
		oO.setFrequency(XMLControl.unEscapeChars(eItem.getChild("Frequency").getText()));		
		} catch (NullPointerException err) {
			oO.setFrequency("Common");
		}

		try {		
			oO.setType(XMLControl.unEscapeChars(eItem.getChild("Type").getText()));		
		} catch (NullPointerException err) {
				oO.setType("Unknown");
		}
		try {		
			oO.setClimate(XMLControl.unEscapeChars(eItem.getChild("Climate").getText()));		
		} catch (NullPointerException err) {
				oO.setClimate("NA");
		}
		try {		
			oO.setTerrain(XMLControl.unEscapeChars(eItem.getChild("Terrain").getText()));		
		} catch (NullPointerException err) {
				oO.setTerrain("NA");
		}
		try {		
			oO.setActivityCycle(XMLControl.unEscapeChars(eItem.getChild("ActivityCycle").getText()));		
		} catch (NullPointerException err) {
				oO.setActivityCycle("NA");
		}
		try {		
			oO.setDiet(XMLControl.unEscapeChars(eItem.getChild("Diet").getText()));		
		} catch (NullPointerException err) {
				oO.setDiet("NA");
		}
		try {		
			oO.setInLair(XMLControl.unEscapeChars(eItem.getChild("InLair").getText()));		
		} catch (NullPointerException err) {
				oO.setInLair("NA");
		}
		try {		
			oO.setMorale(XMLControl.unEscapeChars(eItem.getChild("Morale").getText()));		
		} catch (NullPointerException err) {
				oO.setMorale("NA");
		}
		try {		
			oO.setPsionicAbility(XMLControl.unEscapeChars(eItem.getChild("PsionicAbility").getText()));		
		} catch (NullPointerException err) {
				oO.setPsionicAbility("NA");
		}
		try {		
			oO.setPsionicModes(XMLControl.unEscapeChars(eItem.getChild("PsionicModes").getText()));		
		} catch (NullPointerException err) {
				oO.setFrequency("NA");
		}
		try {		
			oO.setSource(XMLControl.unEscapeChars(eItem.getChild("Source").getText()));		
		} catch (NullPointerException err) {
				oO.setSource("Unknown");
		}
		try {		
			oO.setTHACO(XMLControl.unEscapeChars(eItem.getChild("THACO").getText()));		
		} catch (NullPointerException err) {
				oO.setTHACO("NA");
		}
		try {		
			oO.setOrganization(XMLControl.unEscapeChars(eItem.getChild("Organization").getText()));		
		} catch (NullPointerException err) {
				oO.setOrganization("NA");
		}
		try {		
			oO.setNotes(XMLControl.unEscapeChars(eItem.getChild("notes").getText()));		
		} catch (NullPointerException err) {
				oO.setNotes("");
		}
		try {		
			oO.setTag(XMLControl.unEscapeChars(eItem.getChild("Tag").getText()));		
		} catch (NullPointerException err) {
				oO.setTag("");
		}
		
		
		// ------------ ints
		
		try {		
		oO.setBaseXP(Integer.parseInt(eItem.getChild("BaseXP").getText()));		
		} catch (NullPointerException err) {
			oO.setBaseXP(11);
		}
		try {		
		oO.setXPperHP(Integer.parseInt(eItem.getChild("XPperHP").getText()));		
		} catch (NullPointerException err) {
			oO.setXPperHP(1);
		}

		try {		
		oO.setLevel(Integer.parseInt(eItem.getChild("Level").getText()));		
		} catch (NullPointerException err) {
			oO.setLevel(1);
		}
		try {		
		oO.setAttacks(Integer.parseInt(eItem.getChild("Attacks").getText()));		
		} catch (NullPointerException err) {
			oO.setAttacks(1);
		}

		try {
			oO.AttackList.clear();
			Element eAtkBlock = (Element) eItem.getChild("AttacksList");
			java.util.List lAtkDamage = eAtkBlock.getChildren("Attack");
			Iterator inAttacks = lAtkDamage.iterator();
			while (inAttacks.hasNext()) {
				Element oE = (Element) inAttacks.next();
				oO.getAttackList().add(CreatureAttackClass.getFromElements(oE));				
			}
		} catch (NullPointerException err) {
			oO.AttackList.clear();
		}			    
			
	    return oO;
		
		
	}
	/**
	 * load xml sFilename and return the arraylist of Creatures
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<CreatureClass> loadFromXML(String sFileName) {
		ArrayList<CreatureClass> lList = new ArrayList<CreatureClass>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = CreatureClass.getListFromDoc(doc);
		return lList;
	}
	

	/**
	 * 
	 * @param currentName
	 * @param ost
	 * @return
	 */
	public static boolean isFightCreatureNameUsed(String currentName, MainClass ost) {
		boolean foundMatch = false;
		for (CreatureClass oS : ost.fightingCreatureList) {
			if (currentName.equalsIgnoreCase(oS.getName())) {
				foundMatch = true;
				break; // kill for(), start over with new name.
			}
		}
		return(foundMatch);
	}
	/**
	 * 
	 * @param currentName
	 * @param ost
	 * @return
	 */
	public static boolean isKilledCreatureNameUsed (String currentName, MainClass ost) {
		boolean foundMatch = false;
		for (String sName : ost.fightingKilledList) {
			if (currentName.equalsIgnoreCase(sName)) {
				foundMatch = true;
				break; // kill for(), start over with new name.
			}
		}
		return(foundMatch);
		
	}
	/**
	 * return an name that isn't being used or hasn't been used for
	 * creature panel name
	 * 
	 * @param currentName
	 * @param ost
	 * @return
	 */
	public static String getUnusedCreatureName(String currentName, MainClass ost) {
		String cName;
		int creatureCount = 1;
		do {
			cName = String.format("%s #%d", currentName, creatureCount);
			creatureCount++;
		} while (isKilledCreatureNameUsed(cName, ost) || 
				isFightCreatureNameUsed(cName, ost));

//DM_Config_Tab_Log.logit(String.format("Returning getUnusedCreatureName:[%s]\n", cName));
		return(cName);
	} // end get un used creature name
	
	/**
	 * return true if the creature has an attack unused
	 * @return
	 */
	public boolean hasAvailableAttack() {
		boolean hasAttack = false;
		if (Encountered != null && Encountered.atkList != null)
		for (EncounterCreatureAttack oE : Encountered.atkList) {
			if (!oE.oA.isAttackDone()) {
				hasAttack = true;
				break;
			}
		} // end for
		return(hasAttack);
	}// end hasAvailableAttack
	/**
	 * return number of attacks left to use this round
	 * @return
	 */
	public int getAvailableAttacks() {
		int atkLeft = 0;
		if (Encountered != null && Encountered.atkList != null)
		for (EncounterCreatureAttack oE : Encountered.atkList) {
			if (!oE.oA.isAttackDone()) atkLeft++;
		} // end for
		return(atkLeft);
	}// end hasAvailableAttack

	//TODO make sure this works
	/**
	 * return a cloned/new version of this creature
	 * @return
	 */
	public CreatureClass cloneMe() {
		CreatureClass oClone = new CreatureClass();
		oClone.setName(getName());
		oClone.setMyID(getMyID());
		oClone.setAtks(new ArrayList<String>());
		for (String atk: getAtks())
			oClone.Atks.add(atk);
		
		oClone.setHD(getHD());
		oClone.setAC(getAC());
		oClone.setMaxHP(getMaxHP());
		oClone.setHitPoints(getHitPoints());
		oClone.setDamage(getDamage());
		oClone.setAttacks(getAttacks());
		oClone.setLevel(getLevel());
		oClone.setDescription(getDescription());
		oClone.setTreasure(getTreasure());
		oClone.setSize(getSize());
		oClone.setSpecialAttack(getSpecialAttack());
		oClone.setSpecialDefense(getSpecialDefense());
		oClone.setEncounterSize(getEncounterSize());
		oClone.setMove(getMove());
		oClone.setMagicResistance(getMagicResistance());
		oClone.setIntelligence(getIntelligence());
		oClone.setAlignment(getAlignment());
		oClone.setBaseXP(getBaseXP());
		oClone.setXPperHP(getXPperHP());
		oClone.setFrequency(getFrequency());
		
		oClone.setType(getType());
		oClone.setClimate(getClimate());
		oClone.setTerrain(getTerrain());
		oClone.setActivityCycle(getActivityCycle());
		oClone.setDiet(getDiet());
		oClone.setInLair(getInLair());
		oClone.setMorale(getMorale());
		oClone.setPsionicAbility(getPsionicAbility());
		oClone.setPsionicModes(getPsionicModes());
		oClone.setSource(getSource());

//		oClone.setTHACO(getTHACO(chartList));
		
		oClone.setEncountered(null);
		oClone.setStates((new ArrayList<StatesClass>()));
		oClone.setAttackList((new ArrayList<CreatureAttackClass>()));
		for (CreatureAttackClass oA: getAttackList())
			oClone.getAttackList().add(oA.cloneMe());
		oClone.setMatrixHD(getMatrixHD());
		oClone.setTag(getTag());
		oClone.setNotes(getNotes());
		
		return(oClone);
	}
	

} // end CreatureClass
