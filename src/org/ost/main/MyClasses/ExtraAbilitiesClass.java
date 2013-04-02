package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ost.main.MyClasses.PlayerClass.PCClass;

import static org.ost.main.MyClasses.MyStatics.*;

public class ExtraAbilitiesClass implements Comparable{
	public String myID;
	public String name;
	public String description;
	
	public int bonusWeaponProfs;
	public int bonusNonWeaponProfs;

	// base thief skills or bonus to thief skill
	public ArrayList<SkillsClass> thiefSkillsBase;
	public ArrayList<SkillsClass> thiefSkillsBonus;
	
	public ArrayList<Integer> saves;
	public ArrayList<Integer> saveAdjustments;

	public ArrayList<AbilityScoreClass> abilityScoreAdjustments;

	// bonus spells per spell level
	public int[] mageSpellsBase;
	public int[] mageSpellsBonus;
	public int[] clericSpellsBase;
	public int[] clericSpellsBonus;
	
	public int	type;
	
	public boolean fighterConBonus;
	public boolean barbarianConBonus;
	public boolean barbarianDexBonus; // in light armor
	public boolean allowedWeaponMastery;
	public boolean allowedSpecialize;
	public boolean allowedDoubeSpecialize;
	public boolean allowedIronCon;
	public boolean allowedResistanceCon;
	
	public ExtraAbilitiesClass(String name, String desc) {
		this(name,desc,0,0,
				new ArrayList<SkillsClass>(),
				new ArrayList<SkillsClass>(),
				new int[MAX_MAGE_SPELL_LEVEL],
				new int[MAX_MAGE_SPELL_LEVEL],
				new int[MAX_CLERIC_SPELL_LEVEL],
				new int[MAX_CLERIC_SPELL_LEVEL],
				0,
				new ArrayList<Integer>(),new ArrayList<Integer>(),
				new ArrayList<AbilityScoreClass>(),
				false,false);
	}
	
	
	public ExtraAbilitiesClass(String name, String description,
			int bonusWeaponProfs, int bonusNonWeaponProfs,
			ArrayList<SkillsClass> thiefSkillsBase,
			ArrayList<SkillsClass> thiefSkillsBonus,
			int[] mageSpellsBase,
			int[] mageSpellsBonus,
			int[] clericSpellsBase,
			int[] clericSpellsBonus,
			int extraType,
			ArrayList<Integer> saves, ArrayList<Integer> saveAdjustments,
			ArrayList<AbilityScoreClass> abilityScoreAdjustments,
			boolean ironCon, boolean resistanceCon) {
		
		super();
		this.name = name;
		this.description = description;
		this.bonusWeaponProfs = bonusWeaponProfs;
		this.bonusNonWeaponProfs = bonusNonWeaponProfs;
		this.mageSpellsBase = mageSpellsBase;
		this.mageSpellsBonus = mageSpellsBonus;
		this.clericSpellsBase = clericSpellsBase;
		this.clericSpellsBonus = clericSpellsBonus;
		this.type = extraType;
		this.allowedIronCon = ironCon;
		this.allowedResistanceCon = resistanceCon;
		
		this.thiefSkillsBase = thiefSkillsBase;
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			getThiefSkillsBase().add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));

		this.thiefSkillsBonus = thiefSkillsBonus;
		for(int i=0;i<MAX_THIEF_SKILLS;i++)
			getThiefSkillsBonus().add(new 
					SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));

		this.saves = saves;
		for(int i=0;i<MAX_SAVES;i++)
			getSaves().add(20);

		this.saveAdjustments = saveAdjustments;
		for(int i=0;i<MAX_SAVES;i++)
			getSaveAdjustments().add(0);

		this.abilityScoreAdjustments = abilityScoreAdjustments;
		for(int i=0;i<MAX_ABILITIES;i++)
			getAbilityScoreAdjustments().add(
					new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],-25,25));
		

		//TODO fill in to test
		for(int i=0;i<MAX_MAGE_SPELL_LEVEL;i++)
			getMageSpellsBase()[i] = 0;
		for(int i=0;i<MAX_MAGE_SPELL_LEVEL;i++)
			getMageSpellsBonus()[i] = 0;
		for(int i=0;i<MAX_CLERIC_SPELL_LEVEL;i++)
			getClericSpellsBase()[i] = 0;
		for(int i=0;i<MAX_CLERIC_SPELL_LEVEL;i++)
			getClericSpellsBonus()[i] = 0;

		this.setMyID(UUID.randomUUID().toString());
	}
	

	/**
	 * @return the allowedIronCon
	 */
	public boolean isAllowedIronCon() {
		return allowedIronCon;
	}


	/**
	 * @param allowedIronCon the allowedIronCon to set
	 */
	public void setAllowedIronCon(boolean allowedIronCon) {
		this.allowedIronCon = allowedIronCon;
	}


	/**
	 * @return the allowedResistanceCon
	 */
	public boolean isAllowedResistanceCon() {
		return allowedResistanceCon;
	}


	/**
	 * @param allowedResistanceCon the allowedResistanceCon to set
	 */
	public void setAllowedResistanceCon(boolean allowedResistanceCon) {
		this.allowedResistanceCon = allowedResistanceCon;
	}


	/**
	 * @return the fighterConBonus
	 */
	public boolean isFighterConBonus() {
		return fighterConBonus;
	}


	/**
	 * @param fighterConBonus the fighterConBonus to set
	 */
	public void setFighterConBonus(boolean fighterConBonus) {
		this.fighterConBonus = fighterConBonus;
	}


	/**
	 * @return the barbarianConBonus
	 */
	public boolean isBarbarianConBonus() {
		return barbarianConBonus;
	}


	/**
	 * @param barbarianConBonus the barbarianConBonus to set
	 */
	public void setBarbarianConBonus(boolean barbarianConBonus) {
		this.barbarianConBonus = barbarianConBonus;
	}


	/**
	 * @return the barbarianDexBonus
	 */
	public boolean isBarbarianDexBonus() {
		return barbarianDexBonus;
	}


	/**
	 * @param barbarianDexBonus the barbarianDexBonus to set
	 */
	public void setBarbarianDexBonus(boolean barbarianDexBonus) {
		this.barbarianDexBonus = barbarianDexBonus;
	}


	/**
	 * @return the allowedWeaponMastery
	 */
	public boolean isAllowedWeaponMastery() {
		return allowedWeaponMastery;
	}


	/**
	 * @param allowedWeaponMastery the allowedWeaponMastery to set
	 */
	public void setAllowedWeaponMastery(boolean allowedWeaponMastery) {
		this.allowedWeaponMastery = allowedWeaponMastery;
	}


	/**
	 * @return the allowedSpecialize
	 */
	public boolean isAllowedSpecialize() {
		return allowedSpecialize;
	}


	/**
	 * @param allowedSpecialize the allowedSpecialize to set
	 */
	public void setAllowedSpecialize(boolean allowedSpecialize) {
		this.allowedSpecialize = allowedSpecialize;
	}


	/**
	 * @return the allowedDoubeSpecialize
	 */
	public boolean isAllowedDoubeSpecialize() {
		return allowedDoubeSpecialize;
	}


	/**
	 * @param allowedDoubeSpecialize the allowedDoubeSpecialize to set
	 */
	public void setAllowedDoubeSpecialize(boolean allowedDoubeSpecialize) {
		this.allowedDoubeSpecialize = allowedDoubeSpecialize;
	}


	/**
	 * @return the abilityScoreAdjustments
	 */
	public ArrayList<AbilityScoreClass> getAbilityScoreAdjustments() {
		return abilityScoreAdjustments;
	}


	/**
	 * @param abilityScoreAdjustments the abilityScoreAdjustments to set
	 */
	public void setAbilityScoreAdjustments(
			ArrayList<AbilityScoreClass> abilityScoreAdjustments) {
		this.abilityScoreAdjustments = abilityScoreAdjustments;
	}


	/**
	 * @return the saves
	 */
	public ArrayList<Integer> getSaves() {
		return saves;
	}


	/**
	 * @param saves the saves to set
	 */
	public void setSaves(ArrayList<Integer> saves) {
		this.saves = saves;
	}


	/**
	 * @return the saveAdjustments
	 */
	public ArrayList<Integer> getSaveAdjustments() {
		return saveAdjustments;
	}


	/**
	 * @param saveAdjustments the saveAdjustments to set
	 */
	public void setSaveAdjustments(ArrayList<Integer> saveAdjustments) {
		this.saveAdjustments = saveAdjustments;
	}


	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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
	 * @return the thiefSkillsBase
	 */
	public ArrayList<SkillsClass> getThiefSkillsBase() {
		return thiefSkillsBase;
	}


	/**
	 * @param thiefSkillsBase the thiefSkillsBase to set
	 */
	public void setThiefSkillsBase(ArrayList<SkillsClass> thiefSkillsBase) {
		this.thiefSkillsBase = thiefSkillsBase;
	}


	/**
	 * @return the thiefSkillsBonus
	 */
	public ArrayList<SkillsClass> getThiefSkillsBonus() {
		return thiefSkillsBonus;
	}


	/**
	 * @param thiefSkillsBonus the thiefSkillsBonus to set
	 */
	public void setThiefSkillsBonus(ArrayList<SkillsClass> thiefSkillsBonus) {
		this.thiefSkillsBonus = thiefSkillsBonus;
	}


	/**
	 * @return the mageSpellsBase
	 */
	public int[] getMageSpellsBase() {
		return mageSpellsBase;
	}


	/**
	 * @param mageSpellsBase the mageSpellsBase to set
	 */
	public void setMageSpellsBase(int[] mageSpellsBase) {
		this.mageSpellsBase = mageSpellsBase;
	}


	/**
	 * @return the mageSpellsBonus
	 */
	public int[] getMageSpellsBonus() {
		return mageSpellsBonus;
	}


	/**
	 * @param mageSpellsBonus the mageSpellsBonus to set
	 */
	public void setMageSpellsBonus(int[] mageSpellsBonus) {
		this.mageSpellsBonus = mageSpellsBonus;
	}


	/**
	 * @return the clericSpellsBase
	 */
	public int[] getClericSpellsBase() {
		return clericSpellsBase;
	}


	/**
	 * @param clericSpellsBase the clericSpellsBase to set
	 */
	public void setClericSpellsBase(int[] clericSpellsBase) {
		this.clericSpellsBase = clericSpellsBase;
	}


	/**
	 * @return the clericSpellsBonus
	 */
	public int[] getClericSpellsBonus() {
		return clericSpellsBonus;
	}


	/**
	 * @param clericSpellsBonus the clericSpellsBonus to set
	 */
	public void setClericSpellsBonus(int[] clericSpellsBonus) {
		this.clericSpellsBonus = clericSpellsBonus;
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
	 * @return the bonusWeaponProfs
	 */
	public int getBonusWeaponProfs() {
		return bonusWeaponProfs;
	}
	/**
	 * @param bonusWeaponProfs the bonusWeaponProfs to set
	 */
	public void setBonusWeaponProfs(int bonusWeaponProfs) {
		this.bonusWeaponProfs = bonusWeaponProfs;
	}
	/**
	 * @return the bonusNonWeaponProfs
	 */
	public int getBonusNonWeaponProfs() {
		return bonusNonWeaponProfs;
	}
	/**
	 * @param bonusNonWeaponProfs the bonusNonWeaponProfs to set
	 */
	public void setBonusNonWeaponProfs(int bonusNonWeaponProfs) {
		this.bonusNonWeaponProfs = bonusNonWeaponProfs;
	}

	
	/**
	 * return list of extra abilities matching name
	 * 
	 * @param name
	 * @param list
	 * @return
	 */
	public static ArrayList<ExtraAbilitiesClass> getExtraFromName(String name, 
						List<ExtraAbilitiesClass> list) {
		ArrayList<ExtraAbilitiesClass> eList = new ArrayList<>();
		for (ExtraAbilitiesClass eE: list) {
			if (eE.getName().equalsIgnoreCase(name)) 
				eList.add(eE);
		}
		return(eList);
	}


	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((ExtraAbilitiesClass)o).name.toUpperCase());		
	}

	/**
	 * return an array of objects allowed from allowedList 
	 * 
	 * @param allowedList
	 * @param extraList
	 * @return
	 */
	public static ArrayList<ExtraAbilitiesClass> getAllowed(ArrayList<String> allowedList, 
			ExtraAbilitiesList extraList) {
		ArrayList<ExtraAbilitiesClass> aList = new ArrayList<ExtraAbilitiesClass>();

		for(ExtraAbilitiesClass o: extraList.getContent()) 
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
	public static ArrayList<String> getAllowedAsString(ArrayList<ExtraAbilitiesClass> allowedObject) {
		ArrayList<String> aList = new ArrayList<String>();

		for (ExtraAbilitiesClass o: allowedObject)
			aList.add(o.getMyID());

		return aList;
	}
	
	
	//TODO 
	
	/**
	 * return all extra-abilities for class/level/race
	 * 
	 * @param pc
	 * @param cList
	 * @param eList
	 * @param rList
	 * @return
	 */
	public static ArrayList<ExtraAbilitiesClass> getAllExtraAbilities(
			PlayerClass pc, CharacterClassList cList,
			ExtraAbilitiesList eList, RaceList rList) {

		ArrayList<ExtraAbilitiesClass> extraList = new ArrayList<>();

		if (pc != null) {
			// iterate over all classes pc might have
			for (PCClass pC: pc.getMyClass()) {
				// get CharacterClass object
				CharacterClass oC = CharacterClass.getClassByMyID(pC.getClassID(), cList);
				if (oC!= null) // if no class is set == null
					for (CharacterClass.LevelClass lE: oC.getLevelDetails()) { // iterate over levels
						// get saves from level settings
						if (pC.getExperience()>= lE.getExpReq()) { // high enough exp
							// now get from extra-abilities in level
							// and store in extraList
							ArrayList<ExtraAbilitiesClass> extraLevelList =
									ExtraAbilitiesClass.getAllowed(lE.getBonusAbilities(), eList);
							for (ExtraAbilitiesClass eC: extraLevelList) {
								if (!extraList.contains(eC)) 
									extraList.add(eC);
							}
						} // was high enough level/exp

					}
			}
			// add race extra-abilities to the running total of
			// extra-abilities then test for saves
			RaceClass myRace = RaceClass.getRaceFromMyID(pc.getMyRace().getRaceID(),rList);
			if (myRace != null) {
				ArrayList<ExtraAbilitiesClass> extraLevelList =
						ExtraAbilitiesClass.getAllowed(myRace.getBonusAbilities(), eList);
				for (ExtraAbilitiesClass eC: extraLevelList) 
					if (!extraList.contains(eC)) 
						extraList.add(eC);

			}
		}

		return(extraList);
	}

}
