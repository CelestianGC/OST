package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.ost.main.MyClasses.MyStatics.*;

public class RaceClass implements Comparable{
	public String myID;
	public String name;
	public String description;
	
	public ArrayList<AbilityScoreClass> minAbility;
	public ArrayList<AbilityScoreClass> maxAbility;
	public ArrayList<AbilityScoreClass> abilityAdjustment;
	
	public ArrayList<SkillsClass> thiefAbiltyAdjustments;
	
	public ArrayList<String> bonusAbilities;
	public ArrayList<String> allowedClasses;
	
	public int moveRate;
	public int naturalAC;
	public int bonusStartHP;
	
	public RaceClass() {
		this("give-me-name","enter description");
	}
	public RaceClass(String name, String description) {
		this(name, description,
				
				new ArrayList<AbilityScoreClass>(),new ArrayList<AbilityScoreClass>(),
				new ArrayList<AbilityScoreClass>(),
				new ArrayList<SkillsClass>(),
				new ArrayList<String>(),new ArrayList<String>());
	}
	


	public RaceClass(String name, String description,
			ArrayList<AbilityScoreClass> minAbility, ArrayList<AbilityScoreClass> maxAbility,
			ArrayList<AbilityScoreClass> racialAdjustment,
			ArrayList<SkillsClass> thiefAbiltyAdjustments,
			ArrayList<String> bonusAbilities, ArrayList<String> allowedClasses) {
		super();
		this.name = name;
		this.description = description;
		
		this.minAbility = minAbility;
		for(int i=0;i<MAX_ABILITIES;i++)
		getMinAbility().add(
				new AbilityScoreClass(1,0, ABILITIES[i],ABILITIES_ABBREV[i],-25,25));

		this.maxAbility = maxAbility;
		for(int i=0;i<MAX_ABILITIES;i++)
		getMaxAbility().add(
				new AbilityScoreClass(18,0, ABILITIES[i],ABILITIES_ABBREV[i],-25,25));
		
		this.abilityAdjustment = racialAdjustment;
		for(int i=0;i<MAX_ABILITIES;i++)
			getAbilityAdjustment().add(
					new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],-25,25));

		
		this.thiefAbiltyAdjustments = thiefAbiltyAdjustments;
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			getThiefAbiltyAdjustments().add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
		
		this.bonusAbilities = bonusAbilities;
		this.allowedClasses = allowedClasses;
		
		this.setMoveRate(12);
		this.setNaturalAC(10);
		this.setBonusStartHP(0);
		
		this.setMyID(UUID.randomUUID().toString());
	}
	
	
	/**
	 * @return the moveRace
	 */
	public int getMoveRate() {
		return moveRate;
	}
	/**
	 * @param moveRace the moveRace to set
	 */
	public void setMoveRate(int moveRace) {
		this.moveRate = moveRace;
	}
	/**
	 * @return the naturalAC
	 */
	public int getNaturalAC() {
		return naturalAC;
	}
	/**
	 * @param naturalAC the naturalAC to set
	 */
	public void setNaturalAC(int naturalAC) {
		this.naturalAC = naturalAC;
	}
	/**
	 * @return the bonusStartHP
	 */
	public int getBonusStartHP() {
		return bonusStartHP;
	}
	/**
	 * @param bonusStartHP the bonusStartHP to set
	 */
	public void setBonusStartHP(int bonusStartHP) {
		this.bonusStartHP = bonusStartHP;
	}
	/**
	 * @return the abilityAdjustment
	 */
	public ArrayList<AbilityScoreClass> getAbilityAdjustment() {
		return abilityAdjustment;
	}
	/**
	 * @param abilityAdjustment the abilityAdjustment to set
	 */
	public void setAbilityAdjustment(ArrayList<AbilityScoreClass> abilityAdjustment) {
		this.abilityAdjustment = abilityAdjustment;
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
	 * @return the minAbility
	 */
	public ArrayList<AbilityScoreClass> getMinAbility() {
		return minAbility;
	}
	/**
	 * @param minAbility the minAbility to set
	 */
	public void setMinAbility(ArrayList<AbilityScoreClass> minAbility) {
		this.minAbility = minAbility;
	}
	/**
	 * @return the maxAbility
	 */
	public ArrayList<AbilityScoreClass> getMaxAbility() {
		return maxAbility;
	}
	/**
	 * @param maxAbility the maxAbility to set
	 */
	public void setMaxAbility(ArrayList<AbilityScoreClass> maxAbility) {
		this.maxAbility = maxAbility;
	}
	/**
	 * @return the thiefAbiltyAdjustments
	 */
	public ArrayList<SkillsClass> getThiefAbiltyAdjustments() {
		return thiefAbiltyAdjustments;
	}
	/**
	 * @param thiefAbiltyAdjustments the thiefAbiltyAdjustments to set
	 */
	public void setThiefAbiltyAdjustments(ArrayList<SkillsClass> thiefAbiltyAdjustments) {
		this.thiefAbiltyAdjustments = thiefAbiltyAdjustments;
	}
	/**
	 * @return the bonusAbilities
	 */
	public ArrayList<String> getBonusAbilities() {
		return bonusAbilities;
	}

	/**
	 * @param bonusAbilities the bonusAbilities to set
	 */
	public void setBonusAbilities(ArrayList<String> bonusAbilities) {
		this.bonusAbilities = bonusAbilities;
	}

	/**
	 * @return the allowedClasses
	 */
	public ArrayList<String> getAllowedClasses() {
		return allowedClasses;
	}

	/**
	 * @param allowedClasses the allowedClasses to set
	 */
	public void setAllowedClasses(ArrayList<String> allowedClasses) {
		this.allowedClasses = allowedClasses;
	}


	public class MyAllowedClasses {
		public int maxLevel;
		public String allowedClass;
	}


	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((RaceClass)o).name.toUpperCase());		
	}


	/**
	 * return an array of objects allowed from allowedList 
	 * 
	 * @param allowedList
	 * @param raceList
	 * @return
	 */
	public static ArrayList<RaceClass> getAllowed(ArrayList<String> allowedList, 
			RaceList raceList) {
		ArrayList<RaceClass> aList = new ArrayList<RaceClass>();

		for(RaceClass o: raceList.getContent()) 
			for (String idName: allowedList) {
				if (o.getMyID().equalsIgnoreCase(idName))
					aList.add(o);
			}

		return(aList);
	}

	/**
	 * return arrayList of objects myIDs.
	 * 
	 * @param allowedObject
	 * @return
	 */
	public static ArrayList<String> getAllowedAsString(ArrayList<RaceClass> allowedObject) {
		ArrayList<String> aList = new ArrayList<String>();

		for (RaceClass o: allowedObject)
			aList.add(o.getMyID());

		return aList;
	}

	/**
	 * return RaceClass matching on myID sent.
	 * 
	 * @param myID
	 * @param raceList
	 * @return
	 */
	public static RaceClass getRaceFromMyID(String myID, 
			RaceList raceList) {
		RaceClass oFound = null;
		
		for(RaceClass o: raceList.getContent()) 
			if (o.getMyID().equalsIgnoreCase(myID)) {
				oFound = o;
				break;
			}

		return(oFound);
	}

	
}
