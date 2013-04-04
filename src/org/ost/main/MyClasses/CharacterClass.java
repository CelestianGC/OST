package org.ost.main.MyClasses;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.ost.main.MainClass;

import static org.ost.main.MyClasses.MyStatics.*;

public class CharacterClass implements Comparable{
		public String myID;
		public String name;
		public String description;
		public String abbreviation;
		public int	levelMax;
		public boolean percentileStrength;
		public int classType; // for later use perhaps, fighter/thief/etc ?
		public ArrayList<AbilityScoreClass> abilityReqs;
		public ArrayList<String> raceReqs;
		public boolean[] alignmentReq;
		public ArrayList<String> allowedArmor;
		public ArrayList<String> allowedWeapons;
		public ArrayList<String> allowedMajorSpheres;
		public ArrayList<String> allowedMinorSpheres;
		public boolean allowAllMagicItems;
		public ArrayList<String> allowedMagic;
		public ArrayList<String> nwpReqs;
		public ArrayList<LevelClass> levelDetails;

		public boolean allowedMultiClass;
		public boolean allowedDualClass;

		public boolean allowedMale; 
		public boolean allowedFemale;

		public int maxSkillsSpent; // per skill for 2e style thieves later
		public int nonProfPenalty; // the minus for a weapon not proficient with.
		
		public String startingGold; // dice roll string for starting gold (3d6*10)
		
		public String gameVersion; // version of the game this class is from
		
		public CharacterClass(String name, String description, String abbrev) {
			this(name, description,abbrev,
					99,false,
					new ArrayList<AbilityScoreClass>(),
					new ArrayList<String>(),
					new boolean[MAX_ALIGNMENT],
					new ArrayList<String>(),
					new ArrayList<String>(),
					new ArrayList<String>(),
					new ArrayList<String>(),
					true,
					new ArrayList<String>(),
					new ArrayList<LevelClass>());
		}

		public CharacterClass(String name, String description,
				String abbreviation, int levelMax, boolean percentileStrength,
				ArrayList<AbilityScoreClass> abilityReqs, ArrayList<String> raceReqs,
				boolean[] alignmentReq,
				ArrayList<String> allowedArmor,
				ArrayList<String> allowedWeapons,
				ArrayList<String> allowedMajorSpheres,
				ArrayList<String> allowedMinorSpheres,
				boolean allowAllMagicItems, ArrayList<String> allowedMagic,
				ArrayList<LevelClass> levelDetails) {
			super();
			this.name = name;
			this.description = description;
			this.abbreviation = abbreviation;
			this.levelMax = levelMax;
			this.percentileStrength = percentileStrength;
			this.raceReqs = raceReqs;
			this.alignmentReq = alignmentReq;
				for (int i=0;i<getAlignmentReq().length;i++) // default to any alignment
					getAlignmentReq()[i] = true;
			this.allowedArmor = allowedArmor;
			this.allowedWeapons = allowedWeapons;
			this.allowedMajorSpheres = allowedMajorSpheres;
			this.allowedMinorSpheres = allowedMinorSpheres;
			this.allowAllMagicItems = allowAllMagicItems;
			this.allowedMagic = allowedMagic;
			this.nwpReqs = nwpReqs;
			
			this.nonProfPenalty = -4;
			this.maxSkillsSpent = 15;
			this.setAllowedFemale(true);
			this.setAllowedMale(true);
			this.setAllowedDualClass(true);
			this.setAllowedMultiClass(true);
			this.setStartingGold("3d6*10");
				
			this.levelDetails = levelDetails;

			this.abilityReqs = abilityReqs;
			for(int i=0;i<MAX_ABILITIES;i++)
				getAbilityReqs().add(
						new AbilityScoreClass(1,0, ABILITIES[i],ABILITIES_ABBREV[i]));

			this.setGameVersion("");
			this.setMyID(UUID.randomUUID().toString());
		}

		public class LevelClass {
			public int level;
			public int expReq;
			public int thaco;
			public int ac;
			public int acBase;
			public int hitDiceNumber;
			public int hitDiceSize;
			public int hitPointBonus;
			public int nonWeaponProfAdditional;
			public int weaponProfAdditional;
			public int[] attacksPerRound; // 1/2 or 3/2 or 1/1
			public int[] attacksPerRoundMax; // 1/2 etc
			public int[] attackMatrix; //21, 10..0..-10
			
			public ArrayList<Integer> saves;
			public ArrayList<Integer> savesAdjustments;
			
			public int[] spellsPerLevelArcane;
			public int[] spellsPerLevelDivine;
			public ArrayList<SkillsClass> thiefSkills;
			public ArrayList<SkillsClass> thiefSkillAdjustments;
			public ArrayList<String> nwpBonus;
			public ArrayList<String>	bonusAbilities;
			public ArrayList<AbilityScoreClass> abilityAdjustment;
			public ArrayList<String>	extraSpells;

			public int skillsPoints; // points gained this level, for 2e thief later on
			
			public ArrayList<Integer> turnMatrix; // for turn undead matrix later on
			
			public LevelClass(int level) {
				this(level,0,20,0,
						0,1,6,
						0,0,
						0,new int[2],
						new int[2],	new int[MAX_MATRIX],new ArrayList<Integer>(),new ArrayList<Integer>(),
						new ArrayList<SkillsClass>(),new ArrayList<SkillsClass>(),
						new int[MAX_MAGE_SPELL_LEVEL], new int[MAX_CLERIC_SPELL_LEVEL], new ArrayList<String>(),
						new ArrayList<String>(),
						new ArrayList<AbilityScoreClass>(),
						new ArrayList<String>());
			}
			
			
			public LevelClass(int level, int expReq, int thaco, int ac,
					int acBase, int hitDiceNumber, int hitDiceSize,
					int hitPointBonus, int nonWeaponProfAdditional,
					int weaponProfAdditional, int[] attacksPerRound,
					int[] attacksPerRoundMax, int[] attackMatrix, ArrayList<Integer> saves,ArrayList<Integer> savesAdj, 
					ArrayList<SkillsClass> thiefSkills,ArrayList<SkillsClass> thiefSkillsAdjustments,
					int[] spellsPerLevelArcane,int[] spellsPerLevelDivine, ArrayList<String> nwpBonus,
					ArrayList<String> bonusAbilities,
					ArrayList<AbilityScoreClass> abilityAdjustment,
					ArrayList<String> extraSpells) {
				super();
				this.level = level;
				this.expReq = expReq;
				this.thaco = thaco;
				this.ac = ac;
				this.acBase = acBase;
				this.hitDiceNumber = hitDiceNumber;
				this.hitDiceSize = hitDiceSize;
				this.hitPointBonus = hitPointBonus;
				this.nonWeaponProfAdditional = nonWeaponProfAdditional;
				this.weaponProfAdditional = weaponProfAdditional;
				this.attacksPerRound = attacksPerRound;
				this.attacksPerRoundMax = attacksPerRoundMax;
				this.attackMatrix = attackMatrix;
				this.spellsPerLevelArcane = spellsPerLevelArcane;
				this.spellsPerLevelDivine = spellsPerLevelDivine;
				this.nwpBonus = nwpBonus;
				this.bonusAbilities = bonusAbilities;
				this.extraSpells = extraSpells;

				this.skillsPoints = 0;
				this.turnMatrix = new ArrayList<Integer>();
				
				this.abilityAdjustment = abilityAdjustment;
				if (abilityAdjustment.size()<=0)
					for(int i=0;i<MAX_ABILITIES;i++)
						getAbilityAdjustment().add(
								new AbilityScoreClass(0,0, ABILITIES[i],ABILITIES_ABBREV[i],-25,25));

				this.saves = saves;
				if (saves.size()<=0)
					for(int i=0;i<MAX_SAVES;i++)
						getSaves().add(20);

				this.savesAdjustments = savesAdj;
				if (savesAdjustments.size()<=0)
					for(int i=0;i<MAX_SAVES;i++)
						getSavesAdjustments().add(0);

				this.thiefSkills = thiefSkills;
				if (thiefSkills.size()<=0)
					for(int i=0;i<MAX_THIEF_SKILLS;i++)
						getThiefSkills().add(new 
								SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));

				this.thiefSkillAdjustments = thiefSkillsAdjustments;
				if (thiefSkillAdjustments.size()<=0)
					for(int i=0;i<MAX_THIEF_SKILLS;i++)
						getThiefSkillAdjustments().add(new 
								SkillsClass(THIEF_ABILITIES_NAMES[i], THIEF_ABILITIES_ABBREV[i], 0));
			}


			/**
			 * @return the skillsPoints
			 */
			public int getSkillsPoints() {
				return skillsPoints;
			}


			/**
			 * @param skillsPoints the skillsPoints to set
			 */
			public void setSkillsPoints(int skillsPoints) {
				this.skillsPoints = skillsPoints;
			}


			/**
			 * @return the attacksPerRound
			 */
			public int[] getAttacksPerRound() {
				return attacksPerRound;
			}


			/**
			 * @param attacksPerRound the attacksPerRound to set
			 */
			public void setAttacksPerRound(int[] attacksPerRound) {
				this.attacksPerRound = attacksPerRound;
			}


			/**
			 * @return the attacksPerRoundMax
			 */
			public int[] getAttacksPerRoundMax() {
				return attacksPerRoundMax;
			}


			/**
			 * @param attacksPerRoundMax the attacksPerRoundMax to set
			 */
			public void setAttacksPerRoundMax(int[] attacksPerRoundMax) {
				this.attacksPerRoundMax = attacksPerRoundMax;
			}


			/**
			 * @return the attackMatrix
			 */
			public int[] getAttackMatrix() {
				return attackMatrix;
			}


			/**
			 * @param attackMatrix the attackMatrix to set
			 */
			public void setAttackMatrix(int[] attackMatrix) {
				this.attackMatrix = attackMatrix;
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
			 * @return the savesAdjustments
			 */
			public ArrayList<Integer> getSavesAdjustments() {
				return savesAdjustments;
			}


			/**
			 * @param savesAdjustments the savesAdjustments to set
			 */
			public void setSavesAdjustments(ArrayList<Integer> savesAdjustments) {
				this.savesAdjustments = savesAdjustments;
			}


			/**
			 * @return the thiefSkills
			 */
			public ArrayList<SkillsClass> getThiefSkills() {
				return thiefSkills;
			}


			/**
			 * @param thiefSkills the thiefSkills to set
			 */
			public void setThiefSkills(ArrayList<SkillsClass> thiefSkills) {
				this.thiefSkills = thiefSkills;
			}


			/**
			 * @return the thiefSkillAdjustments
			 */
			public ArrayList<SkillsClass> getThiefSkillAdjustments() {
				return thiefSkillAdjustments;
			}


			/**
			 * @param thiefSkillAdjustments the thiefSkillAdjustments to set
			 */
			public void setThiefSkillAdjustments(ArrayList<SkillsClass> thiefSkillAdjustments) {
				this.thiefSkillAdjustments = thiefSkillAdjustments;
			}


			/**
			 * @return the spellsPerLevelArcane
			 */
			public int[] getSpellsPerLevelArcane() {
				return spellsPerLevelArcane;
			}


			/**
			 * @param spellsPerLevelArcane the spellsPerLevelArcane to set
			 */
			public void setSpellsPerLevelArcane(int[] spellsPerLevelArcane) {
				this.spellsPerLevelArcane = spellsPerLevelArcane;
			}


			/**
			 * @return the spellsPerLevelDivine
			 */
			public int[] getSpellsPerLevelDivine() {
				return spellsPerLevelDivine;
			}


			/**
			 * @param spellsPerLevelDivine the spellsPerLevelDivine to set
			 */
			public void setSpellsPerLevelDivine(int[] spellsPerLevelDivine) {
				this.spellsPerLevelDivine = spellsPerLevelDivine;
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
			 * @return the expReq
			 */
			public int getExpReq() {
				return expReq;
			}
			/**
			 * @param expReq the expReq to set
			 */
			public void setExpReq(int expReq) {
				this.expReq = expReq;
			}
			/**
			 * @return the thaco
			 */
			public int getThaco() {
				return thaco;
			}
			/**
			 * @param thaco the thaco to set
			 */
			public void setThaco(int thaco) {
				this.thaco = thaco;
			}
			/**
			 * @return the ac
			 */
			public int getAc() {
				return ac;
			}
			/**
			 * @param ac the ac to set
			 */
			public void setAc(int ac) {
				this.ac = ac;
			}
			/**
			 * @return the acBase
			 */
			public int getAcBase() {
				return acBase;
			}
			/**
			 * @param acBase the acBase to set
			 */
			public void setAcBase(int acBase) {
				this.acBase = acBase;
			}
			/**
			 * @return the hitDiceNumber
			 */
			public int getHitDiceNumber() {
				return hitDiceNumber;
			}
			/**
			 * @param hitDiceNumber the hitDiceNumber to set
			 */
			public void setHitDiceNumber(int hitDiceNumber) {
				this.hitDiceNumber = hitDiceNumber;
			}
			/**
			 * @return the hitDiceSize
			 */
			public int getHitDiceSize() {
				return hitDiceSize;
			}
			/**
			 * @param hitDiceSize the hitDiceSize to set
			 */
			public void setHitDiceSize(int hitDiceSize) {
				this.hitDiceSize = hitDiceSize;
			}
			/**
			 * @return the hitPointBonus
			 */
			public int getHitPointBonus() {
				return hitPointBonus;
			}
			/**
			 * @param hitPointBonus the hitPointBonus to set
			 */
			public void setHitPointBonus(int hitPointBonus) {
				this.hitPointBonus = hitPointBonus;
			}
			/**
			 * @return the nonWeaponProfAdditional
			 */
			public int getNonWeaponProfAdditional() {
				return nonWeaponProfAdditional;
			}
			/**
			 * @param nonWeaponProfAdditional the nonWeaponProfAdditional to set
			 */
			public void setNonWeaponProfAdditional(int nonWeaponProfAdditional) {
				this.nonWeaponProfAdditional = nonWeaponProfAdditional;
			}
			/**
			 * @return the weaponProfAdditional
			 */
			public int getWeaponProfAdditional() {
				return weaponProfAdditional;
			}
			/**
			 * @param weaponProfAdditional the weaponProfAdditional to set
			 */
			public void setWeaponProfAdditional(int weaponProfAdditional) {
				this.weaponProfAdditional = weaponProfAdditional;
			}
			/**
			 * @return the nwpBonus
			 */
			public ArrayList<String> getNwpBonus() {
				return nwpBonus;
			}
			/**
			 * @param nwpBonus the nwpBonus to set
			 */
			public void setNwpBonus(ArrayList<String> nwpBonus) {
				this.nwpBonus = nwpBonus;
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
			 * @return the abilityAdjustment
			 */
			public ArrayList<AbilityScoreClass> getAbilityAdjustment() {
				return abilityAdjustment;
			}
			/**
			 * @param abilityAdjustment the abilityAdjustment to set
			 */
			public void setAbilityAdjustment(
					ArrayList<AbilityScoreClass> abilityAdjustment) {
				this.abilityAdjustment = abilityAdjustment;
			}
			/**
			 * @return the extraSpells
			 */
			public ArrayList<String> getExtraSpells() {
				return extraSpells;
			}
			/**
			 * @param extraSpells the extraSpells to set
			 */
			public void setExtraSpells(ArrayList<String> extraSpells) {
				this.extraSpells = extraSpells;
			}


			/**
			 * return a clone/new version of this object
			 * 
			 * @return
			 */
			public LevelClass cloneMe() {
				LevelClass newMe = 
						new LevelClass(level, expReq, thaco, ac, acBase, hitDiceNumber, 
								hitDiceSize, hitPointBonus, nonWeaponProfAdditional, 
								nonWeaponProfAdditional, new int[2],
								new int[2],	new int[MAX_MATRIX],new ArrayList<Integer>(),new ArrayList<Integer>(),
								new ArrayList<SkillsClass>(),new ArrayList<SkillsClass>(),
								new int[MAX_MAGE_SPELL_LEVEL], new int[MAX_CLERIC_SPELL_LEVEL], new ArrayList<String>(),
								new ArrayList<String>(),
								new ArrayList<AbilityScoreClass>(),
								new ArrayList<String>());

				for(int i = 0; i<getAttacksPerRound().length;i++) {
					int oS = getAttacksPerRound()[i];
					newMe.getAttacksPerRound()[i] = oS;
				}
				for(int i = 0; i<getAttacksPerRoundMax().length;i++) {
					int oS = getAttacksPerRoundMax()[i];
					newMe.getAttacksPerRoundMax()[i] = oS;
				}
				for(int i = 0; i<getAttackMatrix().length;i++) {
					int oS = getAttackMatrix()[i];
					newMe.getAttackMatrix()[i] = oS;
				}

				for(int i = 0; i<getSaves().size();i++) {
					int oS = getSaves().get(i);
					newMe.getSaves().set(i,oS);
				}

				for(int i = 0; i<getSavesAdjustments().size();i++) {
					int oS = getSavesAdjustments().get(i);
					newMe.getSavesAdjustments().set(i,oS);
				}
				
				for(int i = 0; i<getThiefSkills().size();i++) {
					SkillsClass oB = getThiefSkills().get(i);
					newMe.getThiefSkills().set(i, oB.cloneMe());
				}
				for(int i = 0; i<getThiefSkillAdjustments().size();i++) {
					SkillsClass oB = getThiefSkillAdjustments().get(i);
					newMe.getThiefSkillAdjustments().set(i, oB.cloneMe());
				}
				for(int i = 0; i<getSpellsPerLevelArcane().length;i++) {
					int oS = getSpellsPerLevelArcane()[i];
					newMe.getSpellsPerLevelArcane()[i] = oS;
				}
				for(int i = 0; i<getSpellsPerLevelDivine().length;i++) {
					int oS = getSpellsPerLevelDivine()[i];
					newMe.getSpellsPerLevelDivine()[i] = oS;
				}
				for(int i = 0; i<getNwpBonus().size();i++) {
					String oS = getNwpBonus().get(i);
					newMe.getNwpBonus().set(i, oS);
				}
				for(int i = 0; i<getBonusAbilities().size();i++) {
					String oS = getBonusAbilities().get(i);
					newMe.getBonusAbilities().add(oS);
				}
				for(int i = 0; i<getAbilityAdjustment().size();i++) {
					AbilityScoreClass oB = getAbilityAdjustment().get(i);
					newMe.getAbilityAdjustment().set(i, oB.cloneMe());
				}
				for(int i = 0; i<getExtraSpells().size();i++) {
					String oS = getExtraSpells().get(i);
					newMe.getExtraSpells().add(oS);
				}
				newMe.level = (getLevel()+1);
				return newMe;
			}
			
			
			
		}// end LevelClass

		/**
		 * @return the gameVersion
		 */
		public String getGameVersion() {
			return gameVersion;
		}

		/**
		 * @param gameVersion the gameVersion to set
		 */
		public void setGameVersion(String gameVersion) {
			this.gameVersion = gameVersion;
		}

		public class AlignementReqs  {
			public boolean alignmentRequired;
			public int alignmentType;
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
		 * @return the abbreviation
		 */
		public String getAbbreviation() {
			return abbreviation;
		}



		/**
		 * @param abbreviation the abbreviation to set
		 */
		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}



		/**
		 * @return the levelMax
		 */
		public int getLevelMax() {
			return levelMax;
		}



		/**
		 * @param levelMax the levelMax to set
		 */
		public void setLevelMax(int levelMax) {
			this.levelMax = levelMax;
		}




		/**
		 * @return the percentileStrength
		 */
		public boolean isPercentileStrength() {
			return percentileStrength;
		}



		/**
		 * @param percentileStrength the percentileStrength to set
		 */
		public void setPercentileStrength(boolean percentileStrength) {
			this.percentileStrength = percentileStrength;
		}




		/**
		 * @return the raceReqs
		 */
		public ArrayList<String> getRaceReqs() {
			return raceReqs;
		}



		/**
		 * @param raceReqs the raceReqs to set
		 */
		public void setRaceReqs(ArrayList<String> raceReqs) {
			this.raceReqs = raceReqs;
		}

		/**
		 * @return the alignmentReq
		 */
		public boolean[] getAlignmentReq() {
			return alignmentReq;
		}

		/**
		 * @param alignmentReq the alignmentReq to set
		 */
		public void setAlignmentReq(boolean[] alignmentReq) {
			this.alignmentReq = alignmentReq;
		}

		/**
		 * @return the allowedArmor
		 */
		public ArrayList<String> getAllowedArmor() {
			return allowedArmor;
		}



		/**
		 * @param allowedArmor the allowedArmor to set
		 */
		public void setAllowedArmor(ArrayList<String> allowedArmor) {
			this.allowedArmor = allowedArmor;
		}



		/**
		 * @return the allowedWeapons
		 */
		public ArrayList<String> getAllowedWeapons() {
			return allowedWeapons;
		}



		/**
		 * @param allowedWeapons the allowedWeapons to set
		 */
		public void setAllowedWeapons(ArrayList<String> allowedWeapons) {
			this.allowedWeapons = allowedWeapons;
		}



		/**
		 * @return the allowedMajorSpheres
		 */
		public ArrayList<String> getAllowedMajorSpheres() {
			return allowedMajorSpheres;
		}



		/**
		 * @param allowedMajorSpheres the allowedMajorSpheres to set
		 */
		public void setAllowedMajorSpheres(ArrayList<String> allowedMajorSpheres) {
			this.allowedMajorSpheres = allowedMajorSpheres;
		}



		/**
		 * @return the allowedMinorSpheres
		 */
		public ArrayList<String> getAllowedMinorSpheres() {
			return allowedMinorSpheres;
		}



		/**
		 * @param allowedMinorSpheres the allowedMinorSpheres to set
		 */
		public void setAllowedMinorSpheres(ArrayList<String> allowedMinorSpheres) {
			this.allowedMinorSpheres = allowedMinorSpheres;
		}



		/**
		 * @return the allowAllMagicItems
		 */
		public boolean isAllowAllMagicItems() {
			return allowAllMagicItems;
		}



		/**
		 * @param allowAllMagicItems the allowAllMagicItems to set
		 */
		public void setAllowAllMagicItems(boolean allowAllMagicItems) {
			this.allowAllMagicItems = allowAllMagicItems;
		}



		/**
		 * @return the allowedMagic
		 */
		public ArrayList<String> getAllowedMagic() {
			return allowedMagic;
		}



		/**
		 * @param allowedMagic the allowedMagic to set
		 */
		public void setAllowedMagic(ArrayList<String> allowedMagic) {
			this.allowedMagic = allowedMagic;
		}



		/**
		 * @return the nwpReqs
		 */
		public ArrayList<String> getNwpReqs() {
			return nwpReqs;
		}



		/**
		 * @param nwpReqs the nwpReqs to set
		 */
		public void setNwpReqs(ArrayList<String> nwpReqs) {
			this.nwpReqs = nwpReqs;
		}



		/**
		 * @return the levelDetails
		 */
		public ArrayList<LevelClass> getLevelDetails() {
			return levelDetails;
		}



		/**
		 * @param levelDetails the levelDetails to set
		 */
		public void setLevelDetails(ArrayList<LevelClass> levelDetails) {
			this.levelDetails = levelDetails;
		}


		/**
		 * @return the classType
		 */
		public int getClassType() {
			return classType;
		}

		/**
		 * @param classType the classType to set
		 */
		public void setClassType(int classType) {
			this.classType = classType;
		}


		/**
		 * @return the abilityReqs
		 */
		public ArrayList<AbilityScoreClass> getAbilityReqs() {
			return abilityReqs;
		}

		/**
		 * @param abilityReqs the abilityReqs to set
		 */
		public void setAbilityReqs(ArrayList<AbilityScoreClass> abilityReqs) {
			this.abilityReqs = abilityReqs;
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
		 * @return the classType
		 */
		public int getCasterType() {
			return classType;
		}

		/**
		 * @param classType the classType to set
		 */
		public void setCasterType(int casterType) {
			this.classType = casterType;
		}

		
		
		/**
		 * @return the startingGold
		 */
		public String getStartingGold() {
			return startingGold;
		}

		/**
		 * @param startingGold the startingGold to set
		 */
		public void setStartingGold(String startingGold) {
			this.startingGold = startingGold;
		}

		/**
		 * @return the allowedMultiClass
		 */
		public boolean isAllowedMultiClass() {
			return allowedMultiClass;
		}

		/**
		 * @param allowedMultiClass the allowedMultiClass to set
		 */
		public void setAllowedMultiClass(boolean allowedMultiClass) {
			this.allowedMultiClass = allowedMultiClass;
		}

		/**
		 * @return the allowedDualClass
		 */
		public boolean isAllowedDualClass() {
			return allowedDualClass;
		}

		/**
		 * @param allowedDualClass the allowedDualClass to set
		 */
		public void setAllowedDualClass(boolean allowedDualClass) {
			this.allowedDualClass = allowedDualClass;
		}

		/**
		 * @return the allowedMale
		 */
		public boolean isAllowedMale() {
			return allowedMale;
		}

		/**
		 * @param allowedMale the allowedMale to set
		 */
		public void setAllowedMale(boolean allowedMale) {
			this.allowedMale = allowedMale;
		}

		/**
		 * @return the allowedFemale
		 */
		public boolean isAllowedFemale() {
			return allowedFemale;
		}

		/**
		 * @param allowedFemale the allowedFemale to set
		 */
		public void setAllowedFemale(boolean allowedFemale) {
			this.allowedFemale = allowedFemale;
		}

		/**
		 * @return the maxSkillsSpent
		 */
		public int getMaxSkillsSpent() {
			return maxSkillsSpent;
		}

		/**
		 * @param maxSkillsSpent the maxSkillsSpent to set
		 */
		public void setMaxSkillsSpent(int maxSkillsSpent) {
			this.maxSkillsSpent = maxSkillsSpent;
		}

		/**
		 * @return the nonProfPenalty
		 */
		public int getNonProfPenalty() {
			return nonProfPenalty;
		}

		/**
		 * @param nonProfPenalty the nonProfPenalty to set
		 */
		public void setNonProfPenalty(int nonProfPenalty) {
			this.nonProfPenalty = nonProfPenalty;
		}

		@Override
		public int compareTo(Object o) {
		     return name.toUpperCase().compareTo(((CharacterClass)o).name.toUpperCase());		
		}


		/**
		 * get list of classes that match this name
		 * 
		 * @param name
		 * @param list
		 * @return
		 */
		public static ArrayList<CharacterClass> getFromName(String name,
				List<CharacterClass> list) {
			ArrayList<CharacterClass> eList = new ArrayList<>();
			for (CharacterClass eE: list) {
				if (eE.getName().equalsIgnoreCase(name)) 
					eList.add(eE);
			}
			return(eList);
		}

		

		/**
		 * return an array of objects allowed from allowedList 
		 * 
		 * @param allowedList
		 * @param raceList
		 * @return
		 */
		public static ArrayList<CharacterClass> getAllowed(ArrayList<String> allowedList, 
				CharacterClassList list) {
			ArrayList<CharacterClass> aList = new ArrayList<CharacterClass>();

			for(CharacterClass o: list.getContent()) 
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
		public static ArrayList<String> getAllowedAsString(ArrayList<CharacterClass> allowedObject) {
			ArrayList<String> aList = new ArrayList<String>();

			for (CharacterClass o: allowedObject)
				aList.add(o.getMyID());

			return aList;
		}

		/**
		 * return CharacterClass object matching myID
		 * 
		 * @param myID
		 * @param cList
		 * @return
		 */
		public static CharacterClass getClassByMyID(String myID, MainClass ost) {
			CharacterClass oFound = null;
			for (CharacterClass oC: ost.characterClassList.getContent()) 
				if (oC.getMyID().equalsIgnoreCase(myID)) {
					oFound = oC;
					break;
				}
			return oFound;
		}
		/**
		 * return level struct from nLevel
		 * 
		 * @param nLevel
		 * @return
		 */
		public LevelClass getLevelByLevel(int nLevel) {
			LevelClass oL = null;
			try {
				oL = getLevelDetails().get(nLevel);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return oL;
		}
		
		/**
		 * return a clone/new version of this object
		 * 
		 * @return
		 */
		public CharacterClass cloneMe() {
			CharacterClass newMe = new 
					CharacterClass(getName(), getDescription(), getAbbreviation(), 
							getLevelMax(),false,
							new ArrayList<AbilityScoreClass>(),
							new ArrayList<String>(),
							new boolean[MAX_ALIGNMENT],
							new ArrayList<String>(),
							new ArrayList<String>(),
							new ArrayList<String>(),
							new ArrayList<String>(),
							true,
							new ArrayList<String>(),
							new ArrayList<LevelClass>());
			
			newMe.setNonProfPenalty(getNonProfPenalty());
			
			newMe.getAbilityReqs().clear();
			for(int i = 0; i<getAbilityReqs().size();i++) {
				AbilityScoreClass oB = getAbilityReqs().get(i);
				newMe.getAbilityReqs().add(oB.cloneMe());
			}
			for(int i = 0; i<getRaceReqs().size();i++) {
				String oS = getRaceReqs().get(i);
				newMe.getRaceReqs().add(oS);
			}
			for(int i = 0; i<getAlignmentReq().length;i++) {
				boolean oS = getAlignmentReq()[i];
				newMe.getAlignmentReq()[i] = oS;
			}
			for(int i = 0; i<getAllowedArmor().size();i++) {
				String oS = getAllowedArmor().get(i);
				newMe.getAllowedArmor().set(i, oS);
			}
			for(int i = 0; i<getAllowedWeapons().size();i++) {
				String oS = getAllowedWeapons().get(i);
				newMe.getAllowedWeapons().set(i, oS);
			}
			for(int i = 0; i<getAllowedMajorSpheres().size();i++) {
				String oS = getAllowedMajorSpheres().get(i);
				newMe.getAllowedMajorSpheres().set(i, oS);
			}
			for(int i = 0; i<getAllowedMinorSpheres().size();i++) {
				String oS = getAllowedMinorSpheres().get(i);
				newMe.getAllowedMinorSpheres().set(i, oS);
			}
			newMe.setAllowAllMagicItems(isAllowAllMagicItems());
			for(int i = 0; i<getAllowedMagic().size();i++) {
				String oS = getAllowedMagic().get(i);
				newMe.getAllowedMagic().set(i, oS);
			}
			for(int i = 0; i<getLevelDetails().size();i++) {
				LevelClass oB = getLevelDetails().get(i);
				newMe.getLevelDetails().add(oB.cloneMe());
			}
			newMe.setPercentileStrength(isPercentileStrength());
			return newMe;
		}
}
