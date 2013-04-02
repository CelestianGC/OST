package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.*;

import java.util.ArrayList;

import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class AbilityStatClass {

	public int ID;
	
	public Strength strength;
	public Intelligence intelligence;
	public Wisdom wisdom;
	public Dexterity dexterity;
	public Consitution consitution;
	public Charisma charisma;
	public ArrayList<String> extraAbilityScores;
	
	
	public AbilityStatClass() {
		this.strength = new Strength();
		this.intelligence = new Intelligence();
		this.wisdom = new Wisdom();
		this.dexterity = new Dexterity();
		this.consitution = new Consitution();
		this.charisma = new Charisma();
		this.extraAbilityScores = new ArrayList<String>();
	}

	public class Strength {
		public int score;
		public String name;
		public String description;
		public int hitProbability;
		public int damageAdjustment;
		public int weightAllowance;
		public int minOpenDoor;
		public int numDiceOpenDoor;
		public int sizeDiceOpenDoor;
		public int bendBars;
		public ArrayList<String> bonusAbilities;

		// this is ugly but I could not come up with a more
		// elegant want to do it.
		public ArrayList<Strength> percentile;
		
		public Strength() {
			this(0,"Strength","Strength",0,0,0,1,6,0,0,new ArrayList<String>());
		}
		
		public Strength(int score, String name, String description,
				int hitProbability, int damageAdjustment, int weightAllowance,
				int minOpenDoor, int numDiceOpenDoor, int sizeDiceOpenDoor,
				int bendBars, ArrayList<String> bonusAbilities) {
			this.score = score;
			this.name = name;
			this.description = description;
			this.hitProbability = hitProbability;
			this.damageAdjustment = damageAdjustment;
			this.weightAllowance = weightAllowance;
			this.minOpenDoor = minOpenDoor;
			this.numDiceOpenDoor = numDiceOpenDoor;
			this.sizeDiceOpenDoor = sizeDiceOpenDoor;
			this.bendBars = bendBars;
			this.bonusAbilities = bonusAbilities;
			this.percentile = null; // set to null, only used for 18
		}
		

		

	}
	
	public class Intelligence {
		public int score;
		public String name;
		public String description;
		public int knowSpell;
		public int minSpells;
		public int maxSpells;
		public int languages;
		public int[] bonusSpells;
		public ArrayList<String> bonusAbilities;
		
		public Intelligence() {
			this(0,"Intelligence","Intelligence",0,0,0,0,new ArrayList<String>());
		}
		public Intelligence(int score, String name, String description,
				int knowSpell, int minSpells, int maxSpells, int languages,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.knowSpell = knowSpell;
			this.minSpells = minSpells;
			this.maxSpells = maxSpells;
			this.languages = languages;
			this.bonusAbilities = bonusAbilities;
			this.bonusSpells = new int[MAX_MAGE_SPELL_LEVEL];
		}

	}
	
	public class Wisdom {
		public int score;
		public String name;
		public String description;
		public int magicalAdjustment;
		public int spellFailure;
		public int[] bonusSpells;
		
		public ArrayList<String> bonusAbilities;
		
		public Wisdom() {
			this(0,"Wisdom","Wisdom",0,0,new ArrayList<String>());
		}
		public Wisdom(int score, String name, String description,
				int magicalAdjustment, int spellFailure,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.magicalAdjustment = magicalAdjustment;
			this.spellFailure = spellFailure;
			this.bonusAbilities = bonusAbilities;
			this.bonusSpells = new int[MAX_CLERIC_SPELL_LEVEL];
		}
		
	}

	public class Dexterity {
		public int score;
		public String name;
		public String description;
		public int reactionAdjustment;
		public int attackAdjustment;
		public int defensiveAdjustment;
		public int defensiveAdjustmentBarbarian;
		
		public ArrayList<SkillsClass> skillsAdjustments;
		
		public ArrayList<String> bonusAbilities;
		
		public Dexterity() {
			this(0,"Dexterity","Dexterity",0,0,0,0,new ArrayList<SkillsClass>(),
					new ArrayList<String>());
		}

		public Dexterity(int score, String name, String description,
				int reactionAdjustment, int attackAdjustment,
				int defensiveAdjustment, int defensiveAdjustmentBarbarian, ArrayList<SkillsClass> skillsAdjustments,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.reactionAdjustment = reactionAdjustment;
			this.attackAdjustment = attackAdjustment;
			this.defensiveAdjustment = defensiveAdjustment;
			this.defensiveAdjustmentBarbarian = defensiveAdjustmentBarbarian;
			this.bonusAbilities = bonusAbilities;
			
			this.skillsAdjustments = skillsAdjustments;
			for(int i=0;i<MAX_THIEF_SKILLS;i++)
				skillsAdjustments.add(new 
						SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
			
		}
		
	}
	
	public class Consitution {
		public int score;
		public String name;
		public String description;
		public int hitpointAdjustment;
		public int hitpointAdjustmentFighter;
		public int hitpointAdjustmentBarbarian;
		public int systemShock;
		public int resurrectionSurvival;
		public ArrayList<String> bonusAbilities;
		public int conIron;
		public int conResistance;
		
		public Consitution() {
			this(0,"Consitution","Consitution",0,0,0,0,0,new ArrayList<String>());
		}
		public Consitution(int score, String name, String description,
				int hitpointAdjustment, int hitpointAdjustmentFighter,int hitpointAdjustmentBarbarian,
				int systemShock, int resurrectionSurvival,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.hitpointAdjustment = hitpointAdjustment;
			this.hitpointAdjustmentFighter = hitpointAdjustmentFighter;
			this.hitpointAdjustmentBarbarian = hitpointAdjustmentBarbarian;
			this.systemShock = systemShock;
			this.resurrectionSurvival = resurrectionSurvival;
			this.bonusAbilities = bonusAbilities;
		}
		
	}
	
	public class Charisma {
		public int score;
		public String name;
		public String description;
		public int maxNumberHenchmen;
		public int loyaltyBase;
		public int reactionAdjustment;
		public ArrayList<String> bonusAbilities;
		
		public Charisma() {
			this(0,"Charisma","Charisma",0,0,0,new ArrayList<String>());
		}
		
		public Charisma(int score, String name, String description,
				int maxNumberHenchmen, int loyaltyBase, int reactionAdjustment,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.maxNumberHenchmen = maxNumberHenchmen;
			this.loyaltyBase = loyaltyBase;
			this.reactionAdjustment = reactionAdjustment;
			this.bonusAbilities = bonusAbilities;
		}
	}

	public class ExtraAbilityType {
		public int score;
		public String name;
		public String description;
		public ArrayList<String> bonusAbilities;
		
		public ExtraAbilityType() {
			this(0,"ExtraAbilityType","ExtraAbilityType",new ArrayList<String>());
		}
		
		public ExtraAbilityType(int score, String name, String description,
				ArrayList<String> bonusAbilities) {
			super();
			this.score = score;
			this.name = name;
			this.description = description;
			this.bonusAbilities = bonusAbilities;
		}
	}

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
	 * @return the strength
	 */
	public Strength getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	/**
	 * @return the intelligence
	 */
	public Intelligence getIntelligence() {
		return intelligence;
	}

	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(Intelligence intelligence) {
		this.intelligence = intelligence;
	}

	/**
	 * @return the wisdom
	 */
	public Wisdom getWisdom() {
		return wisdom;
	}

	/**
	 * @param wisdom the wisdom to set
	 */
	public void setWisdom(Wisdom wisdom) {
		this.wisdom = wisdom;
	}

	/**
	 * @return the dexterity
	 */
	public Dexterity getDexterity() {
		return dexterity;
	}

	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(Dexterity dexterity) {
		this.dexterity = dexterity;
	}

	/**
	 * @return the consitution
	 */
	public Consitution getConsitution() {
		return consitution;
	}

	/**
	 * @param consitution the consitution to set
	 */
	public void setConsitution(Consitution consitution) {
		this.consitution = consitution;
	}

	/**
	 * @return the charisma
	 */
	public Charisma getCharisma() {
		return charisma;
	}

	/**
	 * @param charisma the charisma to set
	 */
	public void setCharisma(Charisma charisma) {
		this.charisma = charisma;
	}

	/**
	 * @return the extraAbilityScores
	 */
	public ArrayList<String> getExtraAbilityScores() {
		return extraAbilityScores;
	}

	/**
	 * @param extraAbilityScores the extraAbilityScores to set
	 */
	public void setExtraAbilityScores(ArrayList<String> extraAbilityScores) {
		this.extraAbilityScores = extraAbilityScores;
	}
}
