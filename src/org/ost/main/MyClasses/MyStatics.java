package org.ost.main.MyClasses;

public class MyStatics {
	public static final String DEFAULT_FONT = "Segoe UI";
	
	public static final int MAX_MATRIX = 21;
	
	public static final int SAVE_DEATH = 0;
	public static final int SAVE_POLY = 1;
	public static final int SAVE_ROD = 2;
	public static final int SAVE_BREATH = 3;
	public static final int SAVE_SPELL = 4;
	public static final String[] SAVES = {"Death/Paralyzation/Poison","Petrification/Polymorph",
		"Rod/Staff/Wand","Breath Weapon","Spells","Unknown","Unknown"};
	public static final String[] SAVES_ABBREV = {"Death","Poly","R/S/W","Breath","Spells","NA","NA"};
	public static final int MAX_SAVES = 5;
	
	public static final String CHART_MONSTER_SAVE = "Monster Saves";
	public static final String CHART_MONSTER_MATRIX = "Monster Attack Matrix";
	public static final String CHART_MONSTER_THACO = "Monster THACO Matrix";
	public static final String CHART_MONSTER_BAB = "Monster BaB Matrix";

	public static final int ABILITY_STRENGTH = 0;
	public static final int ABILITY_INTELLIGENCE = 1;
	public static final int ABILITY_WISDOM = 2;
	public static final int ABILITY_DEXTERITY = 3;
	public static final int ABILITY_CONSTITUTION = 4;
	public static final int ABILITY_CHARISMA = 5;
	public static final int ABILITY_COMELINESS = 6;
	public static final int MAX_ABILITY_SCORE=25;
	public static final int MAX_ABILITIES=7;
	public static final	String[] ABILITIES = {"Strength","Intelligence","Wisdom",
		"Dexterity","Constitution","Charisma","Comeliness"};
	public static final	String[] ABILITIES_ABBREV = {"STR","INT","WIS","DEX","CON","CHR","COM"};
	public static final int STRENGTH_PERCENT_0 = -1;
	public static final int STRENGTH_PERCENT_1_50 = 0;
	public static final int STRENGTH_PERCENT_51_75 = 1;
	public static final int STRENGTH_PERCENT_76_90 = 2;
	public static final int STRENGTH_PERCENT_91_99 = 3;
	public static final int STRENGTH_PERCENT_100 = 4;
	public static final String[] STRENGTH_PERCENTILE = 
		{"0", "1-50", "51-75", "76-90", "91-99", "100"};
			
	public static final int MAX_ALIGNMENT=9;
	public static final String[] ALIGNMENTS = {"Lawful Good","Lawful Neutral","Lawful Evil",
		"Neutral Good","True Neutral","Neutral Evil",
		"Chaotic Good","Chaotic Neutral","Chaotic Evil"};
	public static final String[] ALIGNMENTS_ABBREV = {"LG","LN","LE","NG","N","NG","CG","CN","CE"};

	public static final String[] MATRIX_AC_HIT = {"10","9","8","7","6","5","4","3","2","1","0",
		"-1","-2","-3","-4","-5","-6","-7","-8","-9","-10"};

	public static final int CASTER_TYPE_ARCANE = 1;
	public static final int CASTER_TYPE_DIVINE = 2;
	public static final int MAX_MAGE_SPELL_LEVEL=9;
	public static final String[] MAGE_SPELL_NAMES = 
					{"Level 1","Level 2","Level 3","Level 4",
					"Level 5","Level 6","Level 7","Level 8","Level 9"};
	public static final String[] MAGE_SPELL_NAMES_ABBREV = 
		{"1","2","3","4","5","6","7","8","9"};

	public static final int MAX_CLERIC_SPELL_LEVEL=7;
	public static final String[] CLERIC_SPELL_NAMES = 
		{"Level 1","Level 2","Level 3","Level 4",
		"Level 5","Level 6","Level 7"};
	public static final String[] CLERIC_SPELL_NAMES_ABBREV = 
		{"1","2","3","4","5","6","7"};
	
	
	public static final int GEAR_TYPE_EQUIPMENT = 0;
	public static final int GEAR_TYPE_WEAPON = 1;
	public static final int GEAR_TYPE_ARMOR = 2;
	public static final int GEAR_TYPE_TREASURE = 3;
	public static final int GEAR_TYPE_CONTAINER = 4;
	public static final int MAX_GEAR_TYPE = 5;
	public static final String[] GEAR_NAMES = 
		{"Equipment","Weapon","Armor","Treasure","Container"};

	public static final int WEAPON_TYPE_SLASH = 1;
	public static final int WEAPON_TYPE_PIERCE = 2;
	public static final int WEAPON_TYPE_BLUDGEON = 3;
	public static final int WEAPON_TYPE_OTHER = 4;

	public static final int ARMOR_TYPE_NONE = 0;
	public static final int ARMOR_TYPE_NONBULKY = 1;
	public static final int ARMOR_TYPE_FAIRLYBULKY = 2;
	public static final int ARMOR_TYPE_BULKY = 3;
	public static final int ARMOR_TYPE_VERYBULKY = 4;
	public static final int ARMOR_TYPE_MASSIVEBULK = 5;

	public static final int EXTRA_ABILITY_TYPE_GENERAL = 0;
	public static final int EXTRA_ABILITY_TYPE_RACE = 1;
	public static final int EXTRA_ABILITY_TYPE_CLASS = 2;
	public static final int EXTRA_ABILITY_TYPE_WEAPONPROF = 3;
	public static final int EXTRA_ABILITY_TYPE_NONWEAPONPROF = 4;
	public static final int MAX_EXTRA_ABILITY = 5;
	public static final String[] EXTRA_ABILITY_NAMES = 
		{"General","Race","Class","Weapon","NonWeapon"};
	public static final String[] EXTRA_ABILITY_ABBREV = 
		{"G","R","C","W","N"};
	
	public static final int MAX_THIEF_SKILLS=8;
	public static final String[] THIEF_ABILITIES_NAMES = {
							"Pick Pockets","Open Locks","Find/Remove Traps","Move Silently",
							"Hide in Shadows","Hear Noise","Climb Walls",
							"Read Languages","Unknown","Unknown"};
	public static final String[] THIEF_ABILITIES_ABBREV = 
			{"PP","OL","F/R","MS","HS","HN","CW","RL","NA","NA"};
	
	public static final int GENDER_TYPE_MALE = 0;
	public static final int GENDER_TYPE_FEMALE = 1;
	public static final int GENDER_TYPE_OTHER = 2;
	public static final String[] GENDERS = 
		{"Male","Female","Other"};
	public static final String[] GENDERS_ABBREV = 
		{"M","F","O"};

	public static final int AC_NORMAL = 0;
	public static final int AC_SHIELDLESS = 1;
	public static final int AC_REAR = 2;
	public static final String[] AC_NAMES = 
		{"Normal","No-Shield","Rear"};
	public static final String[] AC_ABBREV = 
		{"N","NS","R"};

	public static final int GENERATION_HP_MAX = 0;
	public static final int GENERATION_HP_80 = 1;
	public static final int GENERATION_HP_AVG = 2;
	public static final int GENERATION_HP_NORMAL = 3;
	
}
