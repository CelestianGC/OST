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
import org.ost.main.MainWindow;
import org.ost.main.MyClasses.AbilityStatClass.Charisma;
import org.ost.main.MyClasses.AbilityStatClass.Consitution;
import org.ost.main.MyClasses.AbilityStatClass.Dexterity;
import org.ost.main.MyClasses.AbilityStatClass.Intelligence;
import org.ost.main.MyClasses.AbilityStatClass.Strength;
import org.ost.main.MyClasses.AbilityStatClass.Wisdom;
import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyUtils.MyRandomClass;
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
	
	public int totalExperience;
	
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
		getArmorRatings().add("10");
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
		getMyClass().add(new PCClass("Fighter", DEFAULT_CLASS_ID));
		
		setMyRace(new PCRace("NoRaceYet", "NoRaceSET")); // has to be set when pc selects race
		setMyWeaponProfs(new ArrayList<String>());
		setMyNonWeaponProfs(new ArrayList<String>());
		setMyAbilityScores(new ArrayList<AbilityScoreClass>());
		for(int i=0;i<MAX_ABILITIES;i++)
			getMyAbilityScores().add(
					new AbilityScoreClass(9,0, ABILITIES[i],ABILITIES_ABBREV[i],0,25));

		setMySaveAdjustments(new ArrayList<Integer>());
		for(int i=0;i<MAX_SAVES;i++)
			getMySaveAdjustments().add(0);

		setMySaves(new ArrayList<Integer>());
		for(int i=0;i<MAX_SAVES;i++)
			getMySaves().add(0);
						
		setMyAlignmentType(0);
		
		setTotalExperience(0);
		
		setMyID(UUID.randomUUID().toString());
	}

	/**
	 * create clone of this object
	 * 
	 * @return
	 */
	public PlayerClass cloneMe(MainClass ost) {
		//TODO finish
		PlayerClass oNew = new PlayerClass();
		
		oNew.name = name;
		oNew.namePlayer = namePlayer;
		oNew.hpMax = hpMax;
		oNew.hpCurrent = hpCurrent;

		oNew.armorRatings.clear();
		for(String s: armorRatings)
			oNew.armorRatings.add(s);
		
		oNew.moveRate = moveRate;
		oNew.magicResistance = magicResistance;
		oNew.specialDefense = specialDefense;
		oNew.specialAttacks = specialAttacks;
		oNew.alignment = alignment;

		oNew.gear.clear();
		for(EquipmentClass oG: gear) {
			try {
				EquipmentClass oN = 
						EquipmentClass.getEquipmentByID(oG.getMyID(), ost.equipmentList).clone();
				// save charge and stack count
				// allow max to be changed
				oN.setCharges(oG.getCharges());
				oN.setCount(oG.getCount());
				oNew.gear.add(oN);
			} catch (Exception e) {
				ost.dprint("Player updates: "+getName()+">Unable to find gear object ID:"+
							oG.getName()+"("+oG.getMyID()+")\n");
			}
		}
		
		oNew.pcClass = pcClass;
		oNew.pcLevel = pcLevel;
		oNew.notes = notes;
		
		if (log == null)
			log = "";
		oNew.log = log;
		
		oNew.saveLast = saveLast;
		oNew.tag = tag;
		oNew.initRoll = initRoll;
		
		//TODO this should be oNew.states.add(oS.clone()); 
		oNew.states.clear();
		for(StatesClass oS: states)
			oNew.states.add(oS);
		
		oNew.fightingNode = fightingNode;
		oNew.fightingList = fightingList;
		
		oNew.myClass.clear();
		for(PCClass oC: myClass) 
			oNew.myClass.add(oC.clone());
		
		oNew.myRace = myRace.clone();

		oNew.myWeaponProfs.clear();
		for(String s: myWeaponProfs)
			oNew.myWeaponProfs.add(s);
		
		oNew.myNonWeaponProfs.clear();
		for(String s: myNonWeaponProfs)
			oNew.myNonWeaponProfs.add(s);
		
		oNew.myAbilityScores.clear();
		for(AbilityScoreClass oA: myAbilityScores)
			oNew.myAbilityScores.add(oA.cloneMe());
		
		oNew.mySaves.clear();
		for(Integer i : mySaves)
			oNew.mySaves.add(i);
		
		oNew.mySaveAdjustments.clear();
		for(Integer i : mySaveAdjustments)
			oNew.mySaveAdjustments.add(i);

		oNew.myAlignmentType = myAlignmentType;
		oNew.genderType = genderType;
		oNew.totalExperience = totalExperience;
		
		oNew.setMyID(getMyID());

		return(oNew);
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
		 * return this race struct from ID
		 * 
		 * @param cList
		 * @return
		 */
		public RaceClass getRaceByID(RaceList rList) {
			RaceClass oFound = null;
			for (RaceClass oR: rList.getContent()) 
				if (oR.getMyID().equalsIgnoreCase(getRaceID())) {
					oFound = oR;
					break;
				}
			return oFound;
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

		public PCRace clone() {
			PCRace oNew = new PCRace(getName(), getRaceID());
			
			oNew.name = name;
			oNew.raceID = raceID;

			return(oNew);
		}
	}

	public class PCClass {
		public String name; // just to have a copy of the class name
		public String classID; // myID for the class
		public int experience;
		public int level;
		public boolean primaryClass; // not used at this time
		public boolean lockedClass; // class exp/level locked, dual classed to something else.
		public ArrayList<Integer> hdRolls; // list of health rolled per level

		public PCClass(String name, String classID) {
			this(name,classID,0,false,new ArrayList<Integer>());
		}
		
		public PCClass(String name, String classID, int experience,
				 boolean primaryClass, ArrayList<Integer> hdRolls) {
			super();
			this.name = name;
			this.classID = classID;
			this.experience = experience;
			this.primaryClass = primaryClass;
			this.hdRolls = hdRolls;
		}
		/**
		 * level up a character for levels not applied yet
		 * 
		 * @param cList
		 * @param eList
		 * @param rList
		 * @param aList
		 */
		public void levelUP(MainClass ost) {
			if (getClassCount()>0) {
				// TODO
				if (!isDualClass() || 
						(isDualClass() && this == getPrimaryDualClass())) {
						int nRaceStartBonus = 0;
						boolean bRaceBonusUsed = false;
						RaceClass oR = getMyRace().getRaceByID(ost.raceList);
						nRaceStartBonus = oR.getBonusStartHP();
						int nRolledHP = 0;
						// if dual classing we only count 1 class
						int classCount = isDualClass()?1:getMyClass().size();

						CharacterClass cC = getClassByID(ost.characterClassList);

						if (getHdRolls() == null) // not sure I will ever use this
							setHdRolls(new ArrayList<Integer>());

						for (int ii = 0; ii < cC.getLevelDetails().size(); ii++) {

							ost.dprint("new level "+(ii+1)+"\n");

							LevelClass oL = cC.getLevelByLevel(ii);
							ost.dprint(String.format("character level: %d\nLevel level:%d\n" +
									"character exp: %d\nlevelEXPReq: %d\n",
									getLevel(),
									oL.getLevel(),
									getExperience(),
									oL.getExpReq()));
							if (getLevel()< (oL.getLevel()) && 
									getExperience() >= oL.getExpReq()) {
								int nRollingHP = 0;
								int nDiceCount = 1;
								int nDiceSize = 4;
								int nClassHPBonus = 0;

								int nConScore = getAbilityScore(ABILITY_CONSTITUTION,ost);
								AbilityStatClass aStat = 
										ost.abilityStatList.getContent().get(nConScore);
								int nConBonus = aStat.consitution.hitpointAdjustment;
								if (hasBarbarianCon(ost))
									nConBonus = aStat.consitution.hitpointAdjustmentBarbarian;
								if (hasFighterCon(ost))
									nConBonus = aStat.consitution.hitpointAdjustmentFighter;
								nConBonus /= classCount;

								nDiceCount = oL.getHitDiceNumber();
								nDiceSize = oL.getHitDiceSize();
								nClassHPBonus = oL.getHitPointBonus();
								// some classes stop getting HD
								// fighters at level 9 just get +3 hp
								if (nDiceCount <= 0 || nDiceSize <= 0)
									nRollingHP = 0; 
								else
									nRollingHP = MyRandomClass.rollDice(nDiceCount, nDiceSize);

								ost.dprint(String.format("Level %d\n"
										+ "rolling %dd%d (%d)\n" + "plus classHP %d\n"
										+ "plus RaceStart %d\n" + "plus ConBonus %d\n",
										(ii + 1), nDiceCount, nDiceSize, nRollingHP,
										nClassHPBonus, nRaceStartBonus, nConBonus));

								nRollingHP += nClassHPBonus;
								nRollingHP += nConBonus; // update conBonus each level?
								if (ii == 0 && !bRaceBonusUsed) {
									nRollingHP += nRaceStartBonus;
									bRaceBonusUsed = true;
								}
								if  (isDualClass() && 
										getDualClassLevelHighest() > getPrimaryClassLevel()) {
									// do not get hitpoints until primary >= previous classes
									// when dual classing
									ost.dprint("Level only, dual class, no HP for level "+(getLevel())+"\n");
									nRolledHP = 0;
								} else {
									nRolledHP += nRollingHP;
									ost.dprint(String.format("nRollingHP = %d\n"
											+ "nRolledHP = %d\n", nRollingHP, nRolledHP));
									getHdRolls().add(nRolledHP); // saved for de-level?
								}
								setLevel((getLevel()+1)); // set level to new level
							} else if (oL.getExpReq() > getExperience()) {
								//to little exp or same level
								//no need to go any further
								break;
							}
						}

						// multi-classed divide hp by number of classes
						nRolledHP /= classCount;
						int hpDiff = ((getHpMax()+nRolledHP)-getHpMax());
						int newHP = getHpMax()+nRolledHP;
						int oldHP = getHpMax();

						ost.dprint(String.format("hpDIFF = %d\n"
								+ "original = %d\n----------------\n", hpDiff, getHpMax()));
						setLog(getLog()+"character level up, new MaxHP:"+ newHP +" from "+oldHP+"\n");
						setHpCurrent((getHpMax()+nRolledHP));
						setHpMax((getHpMax()+nRolledHP));
						ost.dprint("Level MaxHP:"+ getHpMax()+"\n");
						ost.dprint("Level CurHP:"+ getHpCurrent()+"\n");
					}
				}
		}
		
		public void deLevel(MainClass ost) {

			if (getMyClass().size() > 0) {
				if (!isDualClass() || 
						(isDualClass() && this == getPrimaryDualClass())) {
					int classCount = isDualClass()?1:getMyClass().size();
					int nRolledHP = 0;

					CharacterClass cC = getClassByID(ost.characterClassList);

					if (getHdRolls() == null)
						setHdRolls(new ArrayList<Integer>());

					for (int ii = (getLevel()); ii >= 0; ii--) {
						LevelClass oL = cC.getLevelByLevel(ii);

						ost.dprint("checking deLevel "+(oL.getLevel()-1)+"\n");

						if (getExperience() < oL.getExpReq()) {
							int nRollingHP = 0;
							int nDiceCount = 1;
							int nDiceSize = 4;
							int nClassHPBonus = 0;

							int nConScore = getAbilityScore(ABILITY_CONSTITUTION,ost);
							AbilityStatClass aStat = 
									ost.abilityStatList.getContent().get(nConScore);
							int nConBonus = aStat.consitution.hitpointAdjustment;
							if (hasBarbarianCon(ost))
								nConBonus = aStat.consitution.hitpointAdjustmentBarbarian;
							if (hasFighterCon(ost))
								nConBonus = aStat.consitution.hitpointAdjustmentFighter;
							nConBonus /= classCount;

							nDiceCount = oL.getHitDiceNumber();
							nDiceSize = oL.getHitDiceSize();
							nClassHPBonus = oL.getHitPointBonus();
							// some classes stop getting HD
							// fighters at level 9 just get +3 hp
							if (nDiceCount <= 0 || nDiceSize <= 0)
								nRollingHP = 0; 
							else
								nRollingHP = MyRandomClass.rollDice(nDiceCount, nDiceSize);
							if  (isDualClass() && 
									getDualClassLevelHighest() >= getPrimaryClassLevel()) {
								// do not get hitpoints until primary >= previous classes
								// when dual classing
								ost.dprint("DE-Level only, dual class, no HP for level "+getLevel()+"\n");
							} else {
								ost.dprint(String.format("deLevel %d\n"
										+ "rolling %dd%d (%d)\n" + "plus classHP %d\n"
										+ "plus ConBonus %d\n",
										(ii), nDiceCount, nDiceSize, nRollingHP,
										nClassHPBonus, nConBonus));

								nRollingHP += nClassHPBonus;
								nRollingHP += nConBonus; // update conBonus each level?
								nRolledHP -= nRollingHP;
								ost.dprint(String.format("nRollingHP = %d\n"
										+ "nRolledHP = %d\n", nRollingHP, nRolledHP));
								//						pC.getHdRolls().add(nRolledHP); // saved for de-level?
							}
							setLevel((getLevel()-1)); // set level to new level
						}
					}
					// multi-classed divide hp by number of classes
					nRolledHP /= classCount;
					int hpDiff = ((getHpMax()+nRolledHP)-getHpMax());
					int newHP = getHpMax()-nRolledHP;
					int oldHP = getHpMax();
					ost.dprint(String.format("hpDIFF = %d\n"
							+ "original = %d\n----------------\n", hpDiff, getHpMax()));

					setLog(getLog()+"character de-level, new MaxHP:"+ newHP +" from "+oldHP+"\n");

					setHpCurrent((getHpMax()+nRolledHP));
					setHpMax((getHpMax()+nRolledHP));

					ost.dprint("DeLevel MaxHP:"+ getHpMax()+"\n");
					ost.dprint("DeLevel CurHP:"+ getHpCurrent()+"\n");
				}
			}
		}
		
		
		/**
		 * return this class struct from ID
		 * @param cList
		 * @return
		 */
		public CharacterClass getClassByID(CharacterClassList cList) {
			CharacterClass oFound = null;
			for (CharacterClass oC: cList.getContent()) 
				if (oC.getMyID().equalsIgnoreCase(getClassID())) {
					oFound = oC;
					break;
				}
			return oFound;
		}
		
		/**
		 * @return the lockedClass
		 */
		public boolean isLockedClass() {
			return lockedClass;
		}

		/**
		 * @param lockedClass the lockedClass to set
		 */
		public void setLockedClass(boolean lockedClass) {
			this.lockedClass = lockedClass;
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
		 * add/modify exp by passed value
		 * @param experience
		 */
		public void addExperience(int experience) {
			this.experience += experience;
			if (this.experience < 0)
				this.experience = 0;
			log += "character experience modified :"+experience+"\n";
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
		 * @return the actual level of classlevel
		 */
		public int getLevelActual(MainClass ost) {
			return getCurrentLevel(ost);
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
		 * return max level of character for this class
		 * 
		 * @param cList
		 * @return
		 */
		public int getCurrentLevel(MainClass ost) {
			int maxLevel = 0;
			CharacterClass oC = CharacterClass.getClassByMyID(getClassID(), ost);
			if (oC != null) {
			for (int i=0;i<oC.getLevelDetails().size();i++) {
				CharacterClass.LevelClass lC = oC.getLevelDetails().get(i);
				if (getExperience() >= lC.getExpReq())
					maxLevel = lC.getLevel();
			}
			}
			return maxLevel;
		}

		public PCClass clone() {
			PCClass oNew = new PCClass(getName(), getClassID());
			
			oNew.classID = classID;
			oNew.experience = experience;
			oNew.level = level;
			oNew.hdRolls.clear();
			oNew.primaryClass = primaryClass;
			return (oNew);
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
	public String getMyClassName(MainClass ost) {
		String classNames = "";
		for (PCClass aClass : myClass) {
			CharacterClass oC = CharacterClass.getClassByMyID(aClass.getClassID(), ost);
			if (oC != null) {
				if (classNames.length()<1) {
					classNames = oC.getName();
				} else {
					classNames = String.format("%s/%s",classNames,oC.getName());
				}
			}
		}
		if (classNames.length()<1)
			classNames = "NoClassSet";
		return classNames;
	}
	/**
	 * return class levels in string format "2/3"
	 * @param cList
	 * @return
	 */
	public String getMyLevelName(MainClass ost) {
		String level = "";
		for (PCClass aClass : myClass) {
			int cLevel = aClass.getCurrentLevel(ost);
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
	
	/**
	 * @return the totalExperience
	 */
	public int getTotalExperience() {
		return totalExperience;
	}
	/**
	 * @param totalExperience the totalExperience to set
	 */
	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
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
	public ArrayList<Integer> getAllSaves(MainClass ost) {
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);
		
		ArrayList<Integer> saves = new ArrayList<>();
		for(int i=0;i<MAX_SAVES;i++)
			saves.add(20);
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					if (!isDualClass() || getDualClassOK(pC))
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
	public ArrayList<Integer> getAllSaveAdjustments(MainClass ost) {
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		ArrayList<Integer> saves = new ArrayList<>();
		for(int i=0;i<MAX_SAVES;i++)
			saves.add(0);
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						if (!isDualClass() || getDualClassOK(pC))
							for (int i=0;i<lE.getSavesAdjustments().size();i++) {
								// if current save value greater than this 
								// use new value
								if (lE.getSavesAdjustments().get(i)!= 0) {
									saves.set(i,saves.get(i)+lE.getSavesAdjustments().get(i));
								}
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
		
		int nConScore = getAbilityScore(ABILITY_CONSTITUTION,ost);
		AbilityStatClass aStat = 
				ost.abilityStatList.getContent().get(nConScore);
		int nIronConBonus = 0;
		int nResistConBonus = 0;
		if (hasIronCon(ost))
			nIronConBonus = aStat.consitution.conIron;
		if (hasResistCon(ost))
			nResistConBonus = aStat.consitution.conResistance;
		saves.set(SAVE_ROD,(saves.get(SAVE_ROD)+nResistConBonus));
		saves.set(SAVE_SPELL,(saves.get(SAVE_SPELL)+nResistConBonus));
		saves.set(SAVE_DEATH,(saves.get(SAVE_DEATH)+nIronConBonus));
		
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
	public ArrayList<AbilityScoreClass> getAllAbilityScores(MainClass ost) {
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
	public ArrayList<AbilityScoreClass> getAllAbilityScoreAdjustments(MainClass ost) {
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this,ost);
		
		ArrayList<AbilityScoreClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_ABILITIES;i++)
			aScores.add(
					new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],0,25));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						if (!isDualClass() || getDualClassOK(pC))
							for (int i=0;i<lE.getAbilityAdjustment().size();i++) {
								AbilityScoreClass oS = lE.getAbilityAdjustment().get(i);
								AbilityScoreClass aS = aScores.get(i);
								aS = abilityScoreAdjCompare(oS, aS);
							}
					} // was high enough level/exp

				}
		}

		// get racial adjustments
		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),ost.raceList);
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
	public int getAbilityScore(int findMe, MainClass ost) {
		
		int theStat = 0;
		
		ArrayList<AbilityScoreClass> abilityScoresAdj = 
				getAllAbilityScoreAdjustments(ost);

		AbilityScoreClass aJ = abilityScoresAdj.get(findMe);
		AbilityScoreClass aS = getMyAbilityScores().get(findMe);
		int abilityTotal = aS.getScore() + aJ.getScore();
		int abilityPercentTotal = aS.getPercentile() + aJ.getPercentile();
		
		if (abilityPercentTotal > 100) {
			abilityTotal += 1;
			abilityPercentTotal -= 100;
		}
		
		if (abilityTotal > MAX_ABILITY_SCORE)
			abilityTotal = MAX_ABILITY_SCORE;
		//TODO this probably not going to work if we use comeliness
		if (abilityTotal < 1)
			abilityTotal = 1;
		
		theStat = abilityTotal;

		return theStat;
	}

	public int getAbilityPercentileScore(int findMe, MainClass ost) {
		
		int theStat = 0;
		
		ArrayList<AbilityScoreClass> abilityScoresAdj = 
				getAllAbilityScoreAdjustments(ost);

		AbilityScoreClass aJ = abilityScoresAdj.get(findMe);
		AbilityScoreClass aS = getMyAbilityScores().get(findMe);
		//int abilityTotal = aS.getScore() + aJ.getScore();
		int abilityPercentTotal = aS.getPercentile() + aJ.getPercentile();

		if (abilityPercentTotal > 100)
			abilityPercentTotal -= 100;

		theStat = abilityPercentTotal;

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
	public ArrayList<SkillsClass> getAllThiefSkillsBase(MainClass ost) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);
		
		ArrayList<SkillsClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			aScores.add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					if (!isDualClass() || getDualClassOK(pC))
						for (int i=0;i<lE.getThiefSkills().size();i++) {
						SkillsClass oS = lE.getThiefSkills().get(i);
						SkillsClass aS = aScores.get(i);
						aS = skillsCompare(oS, aS);
					}
				} // was high enough level/exp
				
			}
		}

// RACE does not grant base skills, you can apply a extra-ability to do that
//		// get racial adjustments
//		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),rList);
//		if (myRace != null) {
//			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
//				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
//				SkillsClass aS = aScores.get(i);
//				aS = skillsCompare(oS, aS);
//			}
//		}
		
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
		if (oS.getScore() > aS.getScore())
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
	public ArrayList<SkillsClass> getAllThiefSkillAdjustments(MainClass ost) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);
		
		ArrayList<SkillsClass> aScores = new ArrayList<>();
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			aScores.add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					if (!isDualClass() || getDualClassOK(pC))
					for (int i=0;i<lE.getThiefSkillAdjustments().size();i++) {
						SkillsClass oS = lE.getThiefSkillAdjustments().get(i);
						SkillsClass aS = aScores.get(i);
						aS = skillsAdjustments(oS, aS);
					}
				} // was high enough level/exp
				
			}
		}

		// get racial adjustments
		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),ost.raceList);
		if (myRace != null) {
			for (int i=0;i<myRace.getThiefAbiltyAdjustments().size();i++) {
				SkillsClass oS = myRace.getThiefAbiltyAdjustments().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsAdjustments(oS, aS);
			}
		}
		
		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getThiefSkillsBonus().size();i++) {
				SkillsClass oS = eA.getThiefSkillsBonus().get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsAdjustments(oS, aS);
			}

		// now check dex ability score
		int abilityTotal = 
				getAbilityScore(ABILITY_DEXTERITY, ost);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = 
					ost.abilityStatList.getContent().get(abilityTotal);
			for(int i=0;i<aStat.dexterity.skillsAdjustments.size();i++) {
				SkillsClass oS = aStat.dexterity.skillsAdjustments.get(i);
				SkillsClass aS = aScores.get(i);
				aS = skillsAdjustments(oS, aS);
			}
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
	public int[] getAllArcaneSpellsPerLevel(MainClass ost) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		int aScores[] = new int[MAX_MAGE_SPELL_LEVEL];


		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						if (!isDualClass() || getDualClassOK(pC))
						for (int i=0;i<lE.getSpellsPerLevelArcane().length;i++) {
							int iS = lE.getSpellsPerLevelArcane()[i];
							if (iS > aScores[i])
								aScores[i] = iS;
						}
					} // was high enough level/exp

				}
		}

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getMageSpellsBase().length;i++) {
				int  iS = eA.getMageSpellsBase()[i];
				if (iS > aScores[i])
					aScores[i] = iS;
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
	public int[] getAllDivineSpellsPerLevel(MainClass ost) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		int aScores[] = new int[MAX_CLERIC_SPELL_LEVEL];


		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					// get saves from level settings
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						if (!isDualClass() || getDualClassOK(pC))
						for (int i=0;i<lE.getSpellsPerLevelDivine().length;i++) {
							int iS = lE.getSpellsPerLevelDivine()[i];
							if (iS > aScores[i])
								aScores[i] = iS;
						}
					} // was high enough level/exp

				}
		}

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getClericSpellsBase().length;i++) {
				int  iS = eA.getClericSpellsBase()[i];
				if (iS > aScores[i])
					aScores[i] = iS;
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
	public int[] getAllArcaneBonusSpellsPerLevel(MainClass ost) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		int aScores[] = new int[MAX_MAGE_SPELL_LEVEL];

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getMageSpellsBonus().length;i++) {
				int  iS = eA.getMageSpellsBonus()[i];
				aScores[i] += iS;
			}
		//get spells from ability scores (wisdom/int)
		int abilityTotal = 
				getAbilityScore(ABILITY_INTELLIGENCE, ost);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = 
					ost.abilityStatList.getContent().get(abilityTotal);
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
	public int[] getAllDivineBonusSpellsPerLevel(MainClass ost) {

		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		int aScores[] = new int[MAX_CLERIC_SPELL_LEVEL];

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			for (int i=0;i<eA.getClericSpellsBonus().length;i++) {
				int  iS = eA.getClericSpellsBonus()[i];
				aScores[i] += iS;
			}
		
		//get spells from ability scores (wisdom/int)	
		int abilityTotal = 
				getAbilityScore(ABILITY_WISDOM, ost);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = 
					ost.abilityStatList.getContent().get(abilityTotal);
			for(int i=0;i<aStat.wisdom.bonusSpells.length;i++)
				aScores[i] += aStat.wisdom.bonusSpells[i];
		}
		
		return(aScores);
	}

	
	public int getTHACO(MainClass ost) {
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);
		
		int bestTHACO = 20;
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				if (!isDualClass() || getDualClassOK(pC))
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

	public int[] getMatrix(MainClass ost) {
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);
		
		int aMatrix[] = new int[MAX_MATRIX];
		for(int i=0;i<aMatrix.length;i++)
			aMatrix[i] = 99;
		
		// iterate over all classes pc might have
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
			for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
				// get saves from level settings
				if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
					// get the lowest roll needed to hit
					if (!isDualClass() || getDualClassOK(pC))
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
	public boolean hasBarbarianDex(MainClass ost) {

		boolean isBarb = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasBarbarianCon(MainClass ost) {
		boolean isBarb = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasFighterCon(MainClass ost) {
		boolean isFighter = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasWeaponMastery(MainClass ost) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasDoubleSpecialization(MainClass ost) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasSpecialization(MainClass ost) {
		boolean isTrue = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

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
	public boolean hasPercentileStrength(MainClass ost) {
		boolean isTrue = false;

		for(PCClass cC: getMyClass()) {
			CharacterClass oC = CharacterClass.getClassByMyID(cC.getClassID(), ost);
			if (oC != null) {
				if (oC.percentileStrength)
					isTrue = true;
			}
		}
		
		return isTrue;	
	}
	
	/**
	 * have iron stomach resistance to poison bonus?
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasIronCon(MainClass ost) {
		boolean isSet = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isAllowedIronCon())
				isSet = true;

		return isSet;	
	}
	/**
	 * have highly resistance to magic con bonus?
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean hasResistCon(MainClass ost) {
		boolean isSet = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isAllowedResistanceCon())
				isSet = true;

		return isSet;	
	}

	/**
	 * returns true if character can cast arcane spells
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean isCasterArcane(MainClass ost) {
		boolean caster = false;
		int base[] = getAllArcaneSpellsPerLevel(ost);
		for(Integer i: base)
			if (i > 0) {
				caster = true;
				break;
			}
		return caster;
	}
	/**
	 * return true if the caster can cast divine spells
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean isCasterDivine(MainClass ost) {
		boolean caster = false;
		int base[] = getAllDivineSpellsPerLevel(ost);
		for(Integer i: base)
			if (i > 0) {
				caster = true;
				break;
			}
		return caster;
	}

	/**
	 * return true if this person has any "base" skill value > 0
	 * 
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public boolean isSkilled(MainClass ost) {
		boolean skilled = false;
		ArrayList<SkillsClass> base = getAllThiefSkillsBase(ost);
		for(SkillsClass sC: base)
			if (sC.getScore() > 0) {
				skilled = true;
				break;
			}
		return skilled;
	}
	
	/**
	 * return AC value of specific type AC_NORMAL/etc
	 * 
	 * @param acType
	 * @param cList
	 * @param eList
	 * @param rList
	 * @param aList
	 * @return
	 */
	public int getArmorClassByType(int acType, MainClass ost) {
		
		ost.log = "";
		
		int shieldAC = getShieldAdjustments();
		int baseAC = getArmorBase();
		int acAdjustments = getArmorAdjustments();
		int abilityACAdjust = 0;
		
		//get spells from ability scores (wisdom/int)	
		int abilityTotal = 
				getAbilityScore(ABILITY_DEXTERITY, ost);

		if (abilityTotal >= 0 && !isRestrictedFromDexAC(ost)) {
			AbilityStatClass aStat = 
					ost.abilityStatList.getContent().get(abilityTotal);
			int acNormal = aStat.dexterity.defensiveAdjustment;
			int acBarb = aStat.dexterity.defensiveAdjustmentBarbarian;
			abilityACAdjust = hasBarbarianDex(ost)?acBarb:acNormal;
		}
		
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		// iterate over all classes pc might have
		int classACAdj = 0;
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						int curBaseAC = lE.getAcBase();
						int curACAdj = lE.getAc();
						if (curBaseAC < baseAC)
							baseAC = curBaseAC;
						if (curACAdj < classACAdj)
							classACAdj = curACAdj;
					} else
						break;
				} // was high enough level/exp
		}

		RaceClass myRace = RaceClass.getRaceFromMyID(getMyRace().getRaceID(),ost.raceList);
		if (myRace != null){
			if (myRace.getNaturalAC() < baseAC)
				baseAC = myRace.getNaturalAC();
		}
		
		int acResult = 0;
		int setAC = Integer.parseInt(getArmorRatings().get(AC_NORMAL));
		int setACRear = Integer.parseInt(getArmorRatings().get(AC_REAR));
		int setACShieldless = Integer.parseInt(getArmorRatings().get(AC_SHIELDLESS));
		
		// if they have set their ac manually use that, if not figure it out
		switch (acType) {
		case AC_REAR: {
			acResult = setACRear==10?((baseAC + (classACAdj+acAdjustments))):setACRear;
			ost.log = String.format(
					"AC:%d, ((%d(base) + (%d(classAdj) + %d(acAdjustments)))",
					acResult,baseAC,classACAdj,acAdjustments);
		}break;
		case AC_SHIELDLESS:{
			acResult = setACShieldless==10?baseAC + (abilityACAdjust + classACAdj + acAdjustments):setACShieldless;
			ost.log = String.format(
					"AC:%d, (%d(base) + (%d(abilityScore) + %d(classAdj) + %d(acAdjustments))",
					acResult,baseAC,abilityACAdjust,classACAdj,acAdjustments);
		}break;

		default:{
			acResult = setAC==10?baseAC + (abilityACAdjust + classACAdj + acAdjustments + shieldAC):setAC;
			ost.log = String.format(
					"AC:%d, %d(base) + (%d(abilityScore) + %d(classAdj) + %d(acAdjustments) +%d(shield))",
					acResult,baseAC,abilityACAdjust,classACAdj,acAdjustments,shieldAC);
		}break;
		}

		return (acResult);
	}
	
	/**
	 * return the best move rate granted by classes
	 * 
	 * @param ost
	 * @return
	 */
	public int getMoveRateFromClass(MainClass ost) {
		int moveRate = 0;
		for (PCClass pC: getMyClass()) {
			// get CharacterClass object
			CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), ost);
			if (oC!= null) // if no class is set == null
				for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
					if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
						if (lE.getMoveBase() > moveRate)
							moveRate = lE.getMoveBase();
					} else
						break;
				} // was high enough level/exp
		}

		return moveRate;
	}
	/**
	 * get move rate from race
	 * 
	 * @param raceList
	 * @return
	 */
	public int getMoveRateFromRace(RaceList raceList) {
		int moveRate = 12;
		RaceClass race = getMyRace().getRaceByID(raceList);
		if (race != null)
			moveRate = race.getMoveRate();
		
		return moveRate;
	}
	/**
	 * return move rate checking race/class (eventually checking encumbrance)
	 * 
	 * @param ost
	 * @return
	 */
	public int getModifiedMoveRate(MainClass ost) {
		
		int moveBase = getMoveRateFromRace(ost.raceList);
		int nClassMoveBase = getMoveRateFromClass(ost);
		if (nClassMoveBase > moveBase)
			moveBase = nClassMoveBase;
		
		int bulkType = getArmorBulkType();
		
		switch (bulkType) {
		case ARMOR_TYPE_NONE:
			break;
			
		case ARMOR_TYPE_NONBULKY:
			break;
			
		case ARMOR_TYPE_FAIRLYBULKY:
			moveBase -= (moveBase/4);
			break;
			
		case ARMOR_TYPE_BULKY:
			moveBase -= (moveBase/2);
			break;
			
		case ARMOR_TYPE_VERYBULKY:
			moveBase = (moveBase/4);
			break;

		default:
			break;
		}
		
		return moveBase;
	}
	
	/**
	 * return true if restricted from dex AC bonus is set
	 * 
	 * @param ost
	 * @return
	 */
	public boolean isRestrictedFromDexAC(MainClass ost) {
		boolean isSet = false;
		// get all the extras
		ArrayList<ExtraAbilitiesClass> extras = 
				ExtraAbilitiesClass.getAllExtraAbilities(this, ost);

		// now flip through all extraAbilities
		for (ExtraAbilitiesClass eA : extras)
			if (eA.isRestrictedFromDexAC())
				isSet = true;

		return isSet;	
	}

	/**
	 * get best base armor from equipment worn
	 *  
	 * @return
	 */
	public int getArmorBase() {
		int acBase = 10;

		for(EquipmentClass oE: getGear()) {
			if (oE.isEquipped())
				if (oE.getType() == GEAR_TYPE_ARMOR) {
					if (oE.getAcBase()<acBase)
						acBase = oE.getAcBase();
				}
		}
		return acBase;
	}

	/**
	 * get adjustments for rings, cloaks, armor
	 * 
	 * @return
	 */
	public int getArmorAdjustments() {
		int ac = 0;

		for(EquipmentClass oE: getGear()) {
			if (oE.isEquipped())
				if (oE.getType() == GEAR_TYPE_ARMOR) {
				ac += oE.getAc();
				if (oE.isMagic())
					ac -= oE.getMagicAdjustmentPrimary(); // assume good is + so remove
			}
		}
		return ac;
	}

	/**
	 * return shield ac adjustments
	 * 
	 * @return
	 */
	public int getShieldAdjustments() {
		int ac = 0;

		for(EquipmentClass oE: getGear()) {
			if (oE.isEquipped())
				if (oE.getType() == GEAR_TYPE_SHIELD) {
				ac += oE.getAc();
				if (oE.isMagic())
					ac -= oE.getMagicAdjustmentPrimary(); // assume good is + so remove
			}
		}
		return ac;
	}

	/**
	 * return bulk type of most bulky item worn (armor)
	 * 
	 * @return
	 */
	public int getArmorBulkType() {
		int bulk = 0;

		for(EquipmentClass oE: getGear()) {
			if (oE.isEquipped())
				if (oE.getType() == GEAR_TYPE_ARMOR) {
					if (oE.getArmorBulkType()>bulk)
						bulk = oE.getArmorBulkType();
				}
		}
		return bulk;
	}

	/**
	 * return weapon struct in slot whichWeapon
	 * 
	 * @param whichWeapon
	 * @return
	 */
	public EquipmentClass getWeapon(int whichWeapon) {
		EquipmentClass oWeapon = null;
		ArrayList<EquipmentClass> aList = getAllWeapons();
		if ((whichWeapon) <= (aList.size()-1)) {
			oWeapon =  aList.get(whichWeapon);
		}
		return oWeapon;
	}
	/**
	 * return all equipped weapons in array
	 * 
	 * @return
	 */
	public ArrayList<EquipmentClass> getAllEquippedWeapons() {
		ArrayList<EquipmentClass> aList = new ArrayList<>();
		for(EquipmentClass oE: getGear()) {
			if (oE.isEquipped() && 
					oE.getType() == GEAR_TYPE_WEAPON)
				aList.add(oE);
		}
		return(aList);
	}
	
	/**
	 * return list of all weapons in inventory
	 * @return
	 */
	public ArrayList<EquipmentClass> getAllWeapons() {
		ArrayList<EquipmentClass> aList = new ArrayList<>();
		for(EquipmentClass oE: getGear()) {
			if (oE.getType() == GEAR_TYPE_WEAPON)
				aList.add(oE);
		}
		return(aList);
	}

	public Strength getStrength(MainClass ost) {
		Strength oStat = null;

		int abilityTotal = 
				getAbilityScore(ABILITY_STRENGTH, ost);
		int abilityPercentTotal = 
				getAbilityPercentileScore(ABILITY_STRENGTH, ost);

		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.strength;

			if (hasPercentileStrength(ost)) {
				if (abilityPercentTotal <= 0) {
					oStat = aStat.strength;
				} else if (abilityPercentTotal <= 50) {
					oStat = aStat.strength.percentile.get(STRENGTH_PERCENT_1_50);
				} else if (abilityPercentTotal <= 75) {
					oStat = aStat.strength.percentile.get(STRENGTH_PERCENT_51_75);
				} else if (abilityPercentTotal <= 90) {
					oStat = aStat.strength.percentile.get(STRENGTH_PERCENT_76_90);
				} else if (abilityPercentTotal <= 99) {
					oStat = aStat.strength.percentile.get(STRENGTH_PERCENT_91_99);
				} else if (abilityPercentTotal >= 100) {
					oStat = aStat.strength.percentile.get(STRENGTH_PERCENT_100);
				}
			}
		}
		return oStat;
	}

	public Dexterity getDexterity(MainClass ost) {
		Dexterity oStat = null;
		int abilityTotal = 
				getAbilityScore(ABILITY_DEXTERITY, ost);
		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.dexterity;
		}
		return oStat;
	}
	public Intelligence getIntelligence(MainClass ost) {
		Intelligence oStat = null;
		int abilityTotal = 
				getAbilityScore(ABILITY_INTELLIGENCE, ost);
		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.intelligence;
		}
		return oStat;
	}
	public Wisdom getWisdom(MainClass ost) {
		Wisdom oStat = null;
		int abilityTotal = 
				getAbilityScore(ABILITY_WISDOM, ost);
		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.wisdom;
		}
		return oStat;
	}
	public Charisma getCharisma(MainClass ost) {
		Charisma oStat = null;
		int abilityTotal = 
				getAbilityScore(ABILITY_CHARISMA, ost);
		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.charisma;
		}
		return oStat;
	}
	public Consitution getConsitution(MainClass ost) {
		Consitution oStat = null;
		int abilityTotal = 
				getAbilityScore(ABILITY_CONSTITUTION, ost);
		if (abilityTotal >= 0) {
			AbilityStatClass aStat = ost.abilityStatList.getStat(abilityTotal);
			oStat = aStat.consitution;
		}
		return oStat;
	}

	/**
	 * does this player have any weapons equipped?
	 * 
	 * @return
	 */
	public boolean hasWeaponsEquipped() {
		return(getAllEquippedWeapons().size()>0);
	}

	/**
	 * have any weapons in inventory?
	 * @return
	 */
	public boolean hasWeapons() {
		return(getAllWeapons().size()>0);
	}

	/**
	 * return true/false if the character has/is dual classing
	 * 
	 * @param ost
	 * @return
	 */
	public boolean isDualClass() {
		boolean isSet = false;
		for (PCClass pc : getMyClass()) {
			if (pc.isLockedClass()) {
				isSet = true;
				break;
			}
		}
		return(isSet);
	}
	/**
	 * return primary PCClass if player is dualclassed
	 * 
	 * @return
	 */
	public PCClass getPrimaryDualClass() {
		PCClass pClass = null;
		if (isDualClass()) {
			for(PCClass pC: getMyClass())
				// everything should be locked cept one class
				if (!pC.isLockedClass()) {
					pClass = pC;
					break;
				}
		}
		return pClass;
	}

	/**
	 * return the highest level in dual class set other
	 * than primary class
	 * 
	 * @return
	 */
	public int getDualClassLevelHighest() {
		int nLevel = 0;
		
		for(PCClass cC : getMyClass())
			if (cC.isLockedClass() && cC.getLevel()> nLevel)
				nLevel = cC.getLevel();
		
		return nLevel;
	}
	/**
	 * return level of the primary class for a dual class character
	 * 
	 * @return
	 */
	public int getPrimaryClassLevel() {
		int nLevel = 0;
		PCClass cC = getPrimaryDualClass();
		if (cC != null)
			nLevel = cC.getLevel();
		return nLevel;
	}
	
	/**
	 * return if dual class requirements for access to class feature
	 * save, thaco/etc is valid
	 * 
	 * @param cC
	 * @return
	 */
	public boolean getDualClassOK(PCClass cC) {
		boolean bOK = false;
		boolean bDualClass = isDualClass();
		int nDualClassLevel = getDualClassLevelHighest();
		int nPrimaryClassLevel = getPrimaryClassLevel();

		if (bDualClass && nDualClassLevel <= nPrimaryClassLevel)
			bOK = true;

		if (cC !=null && cC == getPrimaryDualClass())
			bOK = true;
		
		return bOK;
	}
	/**
	 * add PCClass to player, set addDualClass true if it is dual class
	 * 
	 * @param o
	 * @param addDualClass
	 * @return
	 */
	public PCClass addPCClass(CharacterClass o, boolean addDualClass) {
		
		PCClass e = new PCClass(o.getName(),o.getMyID(), 0, false, null);
		
		// set all other classes LOCKED
		if (addDualClass || isDualClass()) {
			for(PCClass pC: getMyClass())
				pC.setLockedClass(true);
		}

		getMyClass().add(e);
		
		return(e);
	}
	
	/**
	 * remove PCClass w/matching myID from object
	 *  
	 * @param thisID
	 */
	public void removePCClass(String thisID) {
		ArrayList<PCClass> pcList = new ArrayList<>();

		for(PCClass pC: getMyClass())
			if (pC.getClassID().equalsIgnoreCase(thisID))
				pcList.add(pC);

		for(PCClass remove: pcList) 
			getMyClass().remove(remove);

		// if dual classed but has no primary class set last class as
		// the primary class
		if (isDualClass() && getPrimaryDualClass() == null) {
			getMyClass().get(getMyClass().size()-1).setLockedClass(false);
		}
		
	}
	
	/**
	 * reset level to 0 and re-level up hit points
	 * 
	 * @param ost
	 */
	public void reRollHitPoints(MainClass ost) {
		
		if (!isDualClass()) {
			for (PCClass pC : getMyClass())
				pC.setLevel(0);// set level to 0 so it re-levels character up
			setHpCurrent(0);
			setHpMax(0);
		} else {
			// delevel dualclass primary class to reduce
			// hitpoints
			PCClass pCC = getPrimaryDualClass();
			int nSavedEXP = pCC.getExperience();
			pCC.setExperience(0);
			pCC.deLevel(ost);
			pCC.setExperience(nSavedEXP);
			
		}
		updateLevelDifferential(ost, -1, false);
	}
	
	/**
	 * update levels by either passing +EXP value and addEXP or -1 and false
	 * to use current EXP values and re-roll
	 * 
	 * @param nEXP
	 * @param addEXP
	 */
	public void updateLevelDifferential(MainClass ost, int nEXP, boolean addEXP) {
		if (nEXP != 0 || !addEXP) { // either we have exp to adjust or we want to force re-roll
			int classCount = 
					isDualClass()?1:getMyClass().size();
				nEXP /= classCount;
			for (PCClass pC : getMyClass()) {
				if (!pC.isLockedClass()) {
					int nOldLevel = pC.getLevel();
					if (addEXP)
						pC.addExperience(nEXP);
					int nNewLevel = pC.getLevelActual(ost);
					int nDiffLevel = nNewLevel - nOldLevel;
					if (nDiffLevel != 0) { // re-roll health?
						if (nDiffLevel > 0) {
							ost.dprint(pC.getName() + " is leveling up! "
									+ nDiffLevel + "\n");

							pC.levelUP(ost);
						} else {
							ost.dprint(pC.getName() + " De-Leveled! " + nDiffLevel
									+ "\n");
							pC.deLevel(ost);
						}

					}
				} else {
					// class was locked
				}

			}
			//			currentHPSpinner.setValue(currentCharacter.getHpCurrent());
			//			hpSpinner.setValue(currentCharacter.getHpMax());
		}

	}
	
	/**
	 * reset all multiclass classes to 0 level/exp value
	 *  
	 */
	public void multiclassUpdates() {
		for(PCClass cC: getMyClass()) {
			cC.setExperience(0);
			cC.setLevel(0);
		}
	}
	/**
	 * return the number of classes this player has
	 * 
	 * @return
	 */
	public int getClassCount() {
		return(getMyClass().size());
	}
	
	/**
	 * get PCClass at index
	 * 
	 * @param index
	 * @return
	 */
	public PCClass getClassAt(int index) {
		PCClass cC = null;
		try {
			cC = getMyClass().get(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cC;
	}
	/**
	 * is PC multi-classed?
	 * 
	 * @return
	 */
	public boolean isMultiClassed() {
		return (getClassCount() > 1 && !isDualClass());
	}
	/**
	 * is player single classed?
	 * 
	 * @return
	 */
	public boolean isSingleClassed() {
		return(getClassCount()<=1);
	}
} // end PlayerClass
