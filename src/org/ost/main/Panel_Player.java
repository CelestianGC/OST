/*
 * Panel_Player.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.SkillsClass;

import static org.ost.main.MyClasses.MyStatics.*;

/**
 *
 * @author  __USER__
 */
public class Panel_Player extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player */
	public Panel_Player(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();

		// for some reason cellrenderer makes the cells align left, default
		// for int is right, so just cell render them all so they are all left
		// TODO figure out why it does that.
		// make that THACO cell red
		for (int i = 0; i < pcCombatMatrixTable.getColumnCount(); i++) {
			TableColumn thacoCol = pcCombatMatrixTable.getColumnModel()
					.getColumn(i);
			if (i == 10)
				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.red,
						Color.black));
			else
				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.ORANGE,
						Color.black));
		}
		// this is to make the headers align left to match the numbers
		TableCellRenderer rendererFromHeader = pcCombatMatrixTable
				.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.LEFT);
		//---

		updatePanel(oPlayer);

	}

	/**
	 * update Panel_Player with player data
	 * 
	 * @param oPlayer
	 */
	public void updatePanel(PlayerClass oPlayer) {
		// TODO Auto-generated method stub

		// added this incase we updated panel
		pc = oPlayer;
		// portrait

		// details
		pcCharacterNameLabel.setText(pc.getName());
		pcPlayerNameLabel.setText(pc.getNamePlayer());
		pcAlignmentLabel.setText(ALIGNMENTS[pc.getMyAlignmentType()]);
		pcRaceLabel.setText(pc.getMyRaceName(ost.raceList));
		pcClassNameLabel.setText(pc.getMyClassName(ost.characterClassList));
		pcClassLevelLabel.setText(pc.getMyLevelName(ost.characterClassList));
		pcExperienceTotalsLabel.setText(pc
				.getMyExperienceName(ost.characterClassList));
		pcMoveBaseLabel.setText(pc.getMoveRate());

		// abilties
		ArrayList<AbilityScoreClass> abilityScoresAdj = pc
				.getAllAbilityScoreAdjustments(ost.characterClassList,
						ost.extraAbilitiesList, ost.raceList);

		for (int i = 0; i < pc.getMyAbilityScores().size(); i++) {
			AbilityScoreClass aJ = abilityScoresAdj.get(i);
			AbilityScoreClass aS = pc.getMyAbilityScores().get(i);
			int abilityTotal = aS.getScore() + aJ.getScore();
			int abilityPercentTotal = aS.getPercentile() + aJ.getPercentile();

			if (abilityTotal >= 0) {
				AbilityStatClass aStat = ost.abilityStatList.getContent().get(
						abilityTotal);
				switch (i) {
				case ABILITY_CHARISMA:
					pcCharismaLabel.setText(String.format("%d", abilityTotal));
					pcLoyaltyLabel.setText(String.format("%d",
							aStat.charisma.loyaltyBase));
					pcMaxHenchmenLabel.setText(String.format("%d",
							aStat.charisma.maxNumberHenchmen));
					pcReactionAdjCharismaLabel.setText(String.format("%d",
							aStat.charisma.reactionAdjustment));
					break;
				case ABILITY_COMELINESS:

					break;
				case ABILITY_CONSTITUTION:
					pcConstitutionLabel.setText(String.format("%d",
							abilityTotal));

					//test for fighter/barb features in class and show just that
					int nConBonus = aStat.consitution.hitpointAdjustment;
					if (pc.hasBarbarianCon(ost.characterClassList,
							ost.extraAbilitiesList, ost.raceList))
						nConBonus = aStat.consitution.hitpointAdjustmentBarbarian;
					if (pc.hasFighterCon(ost.characterClassList,
							ost.extraAbilitiesList, ost.raceList))
						nConBonus = aStat.consitution.hitpointAdjustmentFighter;
					pcHPAdjLabel.setText(String.format("%d", nConBonus));

					pcResurrectionSurvivalLabel.setText(String.format("%d",
							aStat.consitution.resurrectionSurvival));
					pcSystemShockLabel.setText(String.format("%d",
							aStat.consitution.systemShock));
					break;
				case ABILITY_DEXTERITY:
					pcDexterityLabel.setText(String.format("%d", abilityTotal));
					pcMissileAdjLabel.setText(String.format("%d",
							aStat.dexterity.attackAdjustment));
					pcReactionAdjLabel.setText(String.format("%d",
							aStat.dexterity.reactionAdjustment));
					//sort out if they get barb bonuses
					int nDexBonus = aStat.dexterity.defensiveAdjustment;
					if (pc.hasBarbarianDex(ost.characterClassList,
							ost.extraAbilitiesList, ost.raceList))
						nDexBonus = aStat.dexterity.defensiveAdjustmentBarbarian;
					pcDefenseAdjLabel.setText(String.format("%d", nDexBonus));

					break;
				case ABILITY_INTELLIGENCE:
					pcIntelligenceLabel.setText(String.format("%d",
							abilityTotal));
					//bonus arcane spells
					String magicSpells = "";
					for (int ii = 0; ii < MAX_MAGE_SPELL_LEVEL; ii++) {
						magicSpells = magicSpells
								+ String.format("L%dX%d%s", ii + 1,
										aStat.intelligence.bonusSpells[ii],
										ii + 1 < MAX_MAGE_SPELL_LEVEL ? ", "
												: "");
					}
					pcBonusArcaneSpellsLabel.setText(String.format("%s",
							magicSpells));
					pcKnowSpellLabel.setText(String.format("%d",
							aStat.intelligence.knowSpell));
					pcLanguagesLabel.setText(String.format("%d",
							aStat.intelligence.languages));
					pcMaxSpellsLabel.setText(String.format("%d",
							aStat.intelligence.maxSpells));
					pcMinSpellsLabel.setText(String.format("%d",
							aStat.intelligence.minSpells));
					break;
				case ABILITY_STRENGTH: {
					pcStrengthLabel.setText(String.format("%d", abilityTotal));
					boolean hasPercentileStrength = pc.hasPercentileStrength(
							ost.characterClassList, ost.extraAbilitiesList,
							ost.raceList);
					int nBBars, nHit, nDmg, nOpen, nNumDice, nSizeDice, nWeight = 0;
					nBBars = aStat.strength.bendBars;
					nHit = aStat.strength.hitProbability;
					nDmg = aStat.strength.damageAdjustment;
					nOpen = aStat.strength.minOpenDoor;
					nNumDice = aStat.strength.numDiceOpenDoor;
					nSizeDice = aStat.strength.sizeDiceOpenDoor;
					nWeight = aStat.strength.weightAllowance;

					pcPercentileStrLabel.setText("");

					//sort out percentile strength if can have
					if (hasPercentileStrength) {
						pcPercentileStrLabel.setText(String.format("%d",
								abilityPercentTotal));
						if (abilityPercentTotal <= 0) {
							// 18/0 is 18 so do not need to assign here
						} else if (abilityPercentTotal <= 50) {
							nBBars = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).bendBars;
							nHit = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).hitProbability;
							nDmg = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).damageAdjustment;
							nOpen = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).minOpenDoor;
							nNumDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).numDiceOpenDoor;
							nSizeDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).sizeDiceOpenDoor;
							nWeight = aStat.strength.percentile
									.get(STRENGTH_PERCENT_1_50).weightAllowance;
						} else if (abilityPercentTotal <= 75) {
							nBBars = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).bendBars;
							nHit = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).hitProbability;
							nDmg = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).damageAdjustment;
							nOpen = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).minOpenDoor;
							nNumDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).numDiceOpenDoor;
							nSizeDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).sizeDiceOpenDoor;
							nWeight = aStat.strength.percentile
									.get(STRENGTH_PERCENT_51_75).weightAllowance;
						} else if (abilityPercentTotal <= 90) {
							nBBars = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).bendBars;
							nHit = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).hitProbability;
							nDmg = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).damageAdjustment;
							nOpen = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).minOpenDoor;
							nNumDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).numDiceOpenDoor;
							nSizeDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).sizeDiceOpenDoor;
							nWeight = aStat.strength.percentile
									.get(STRENGTH_PERCENT_76_90).weightAllowance;
						} else if (abilityPercentTotal <= 99) {
							nBBars = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).bendBars;
							nHit = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).hitProbability;
							nDmg = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).damageAdjustment;
							nOpen = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).minOpenDoor;
							nNumDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).numDiceOpenDoor;
							nSizeDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).sizeDiceOpenDoor;
							nWeight = aStat.strength.percentile
									.get(STRENGTH_PERCENT_91_99).weightAllowance;
						} else if (abilityPercentTotal >= 100) {
							nBBars = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).bendBars;
							nHit = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).hitProbability;
							nDmg = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).damageAdjustment;
							nOpen = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).minOpenDoor;
							nNumDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).numDiceOpenDoor;
							nSizeDice = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).sizeDiceOpenDoor;
							nWeight = aStat.strength.percentile
									.get(STRENGTH_PERCENT_100).weightAllowance;
						}
					}
					pcBendBarsLabel.setText(String.format("%d", nBBars));
					pcHitAdjLabel.setText(String.format("%d", nHit));
					pcDmgAdjLabel.setText(String.format("%d", nDmg));
					pcOpenDoorLabel.setText(String.format("1-%d (%dD%d)",
							nOpen, nNumDice, nSizeDice));
					pcWeightAllowanceLabel
							.setText(String.format("%d", nWeight));
				}
					break;
				case ABILITY_WISDOM:
					pcWisdomLabel.setText(String.format("%d", abilityTotal));
					//divine spells
					String clericSpells = "";
					for (int ii = 0; ii < MAX_CLERIC_SPELL_LEVEL; ii++) {
						clericSpells = clericSpells
								+ String.format("L%dX%d%s", ii + 1,
										aStat.intelligence.bonusSpells[ii],
										ii + 1 < MAX_CLERIC_SPELL_LEVEL ? ", "
												: "");
					}
					pcBonusSpellsDivineLabel.setText(String.format("%s",
							clericSpells));
					pcMagicalAdjLabel.setText(String.format("%d",
							aStat.wisdom.magicalAdjustment));
					pcSpellFailureLabel.setText(String.format("%d",
							aStat.wisdom.spellFailure));
					break;

				default:
					// error
					ost.dprint("Unknown ability type in Pnale_Player updatePanel()\n");
					break;
				}
			} // else abilityTotal was smaller than 0
		}

		// saves
		ArrayList<Integer> bestSaves = pc.getAllSaves(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList);
		pc.setMySaves(bestSaves);

		ArrayList<Integer> bestSaveAdj = pc.getAllSaveAdjustments(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList);
		pc.setMySaveAdjustments(bestSaveAdj);

		for (int i = 0; i < pc.getMySaves().size(); i++) {
			int aB = pc.getMySaves().get(i);
			int aJ = pc.getMySaveAdjustments().get(i);
			switch (i) {
			case SAVE_BREATH:
				pcSaveBreathLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveBreathLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				break;
			case SAVE_DEATH:
				pcSavePoisonLabel.setText(String.format("%d", (aB - aJ)));
				pcSavePoisonLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				break;
			case SAVE_POLY:
				pcSavePolyLabel.setText(String.format("%d", (aB - aJ)));
				pcSavePolyLabel.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				break;
			case SAVE_ROD:
				pcSaveRodLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveRodLabel.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				break;
			case SAVE_SPELL:
				pcSaveSpellsLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveSpellsLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				break;

			default:
				ost.dprint("Unknown save type in Panel_Player updatePanel()\n");
				break;
			}

		}


		// combat

		pcCurrentHPLabel.setText(String.format("%d", pc.getHpCurrent()));
		pcMaxHPLabel.setText(String.format("%d", pc.getHpMax()));
		int iTHACO = pc.getTHACO(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList);
		pcTHACOLabel.setText(String.format("%d", iTHACO));
		pcTHACOLabel.setToolTipText("Roll needed to hit armor class 0 is "
				+ iTHACO);

		for (int i = 0; i < pc.getArmorRatings().size(); i++) {
			switch (i) {
			case AC_NORMAL:
				pcArmorClassLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassLabel.setToolTipText(AC_NAMES[i]);
				break;
			case AC_REAR:
				pcArmorClassRearLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassRearLabel.setToolTipText(AC_NAMES[i]);
				break;
			case AC_SHIELDLESS:
				pcArmorClassShieldlessLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassShieldlessLabel.setToolTipText(AC_NAMES[i]);
				break;

			default:
				ost.dprint("Unknown AC type in Panel_Player updatePanel()\n");
				break;
			}
		}

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		pcCombatMatrixTable.getTableHeader().setFont(fFont);
		pcCombatMatrixTable.getTableHeader().setBackground(Color.yellow);

		int attackList[] = pc.getMatrix(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList);

		for (int i = 0; i < attackList.length; i++) {
			pcCombatMatrixTable.setValueAt(attackList[i], 0, i);
		}

		// skills?
		ArrayList<SkillsClass> skillsBase = pc.getAllThiefSkillsBase(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList);
		ArrayList<SkillsClass> skillsAdj = pc.getAllThiefSkillAdjustments(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList);

		skillsPanel.removeAll();
		for (int i = 0; i < skillsBase.size(); i++) {
			JPanel skills = new JPanel(new GridLayout(2, 0, 1, 1));
			SkillsClass tJ = skillsAdj.get(i);
			SkillsClass tS = skillsBase.get(i);
			int finalSkill = tS.getScore() + tJ.getScore();
			if (finalSkill != 0) {
				String tooltip = tS.getName() + ": " + tS.getScore() + "+"
						+ tJ.getScore();
				JLabel name = new JLabel(tS.getAbbrev());
				name.setToolTipText(tooltip);
				JLabel value = new JLabel(String.format("%d%%", finalSkill));
				value.setToolTipText(tooltip);

				skills.add(name);
				skills.add(value);
				skillsPanel.add(skills);
			}
		}

		// arcane spells
		int arcaneBase[] = pc.getAllArcaneSpellsPerLevel(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList);
		int arcaneAdj[] = pc.getAllArcaneBonusSpellsPerLevel(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList,
				ost.abilityStatList);

		arcaneSpellsPanel.removeAll();
		for (int i = 0; i < arcaneBase.length; i++) {
			JPanel arcanePanel = new JPanel(new GridLayout(2, 0, 1, 1));
			int base = arcaneBase[i];
			int adj = arcaneAdj[i];
			int finalSkill = base+adj;
			if (finalSkill != 0) {
				String tooltip ="Level "+(i+1)+": "+base + "+"+ adj;
				JLabel name = new JLabel("L"+(i+1));
				name.setToolTipText(tooltip);
				JLabel value = new JLabel(String.format("%d", finalSkill));
				value.setToolTipText(tooltip);

				arcanePanel.add(name);
				arcanePanel.add(value);
				arcaneSpellsPanel.add(arcanePanel);
			}
		}
		
		// divine spells
		int divineBase[] = pc.getAllDivineSpellsPerLevel(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList);
		int divineAdj[] = pc.getAllDivineBonusSpellsPerLevel(
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList,
				ost.abilityStatList);

		divineSpellsPanel.removeAll();
		for (int i = 0; i < divineBase.length; i++) {
			JPanel divinePanel = new JPanel(new GridLayout(2, 0, 1, 1));
			int base = divineBase[i];
			int adj = divineAdj[i];
			int finalSkill = base+adj;
			if (finalSkill != 0) {
				String tooltip ="Level "+(i+1)+": "+base + "+"+ adj;
				JLabel name = new JLabel("L"+(i+1));
				name.setToolTipText(tooltip);
				JLabel value = new JLabel(String.format("%d", finalSkill));
				value.setToolTipText(tooltip);

				divinePanel.add(name);
				divinePanel.add(value);
				divineSpellsPanel.add(divinePanel);
			}
		}
		
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		detailsPanel = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		pcCharacterNameLabel = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		pcClassNameLabel = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		pcRaceLabel = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		pcAlignmentLabel = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		pcClassLevelLabel = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		pcPlayerNameLabel = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		pcMoveBaseLabel = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		pcExperienceTotalsLabel = new javax.swing.JLabel();
		AbilitiesPanel = new javax.swing.JPanel();
		pcStrengthLabel = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		pcPercentileStrLabel = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		pcHitAdjLabel = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		pcDmgAdjLabel = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		pcOpenDoorLabel = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		pcBendBarsLabel = new javax.swing.JLabel();
		pcDexterityLabel = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel52 = new javax.swing.JLabel();
		pcReactionAdjLabel = new javax.swing.JLabel();
		jLabel54 = new javax.swing.JLabel();
		pcMissileAdjLabel = new javax.swing.JLabel();
		jLabel56 = new javax.swing.JLabel();
		pcDefenseAdjLabel = new javax.swing.JLabel();
		pcConstitutionLabel = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel58 = new javax.swing.JLabel();
		pcHPAdjLabel = new javax.swing.JLabel();
		jLabel60 = new javax.swing.JLabel();
		pcSystemShockLabel = new javax.swing.JLabel();
		jLabel62 = new javax.swing.JLabel();
		pcResurrectionSurvivalLabel = new javax.swing.JLabel();
		pcCharismaLabel = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel64 = new javax.swing.JLabel();
		pcMaxHenchmenLabel = new javax.swing.JLabel();
		jLabel66 = new javax.swing.JLabel();
		pcLoyaltyLabel = new javax.swing.JLabel();
		jLabel68 = new javax.swing.JLabel();
		pcReactionAdjCharismaLabel = new javax.swing.JLabel();
		pcIntelligenceLabel = new javax.swing.JLabel();
		pcWisdomLabel = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel36 = new javax.swing.JLabel();
		pcLanguagesLabel = new javax.swing.JLabel();
		jLabel38 = new javax.swing.JLabel();
		pcKnowSpellLabel = new javax.swing.JLabel();
		jLabel40 = new javax.swing.JLabel();
		pcMinSpellsLabel = new javax.swing.JLabel();
		jLabel42 = new javax.swing.JLabel();
		pcMaxSpellsLabel = new javax.swing.JLabel();
		jLabel44 = new javax.swing.JLabel();
		pcBonusArcaneSpellsLabel = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel46 = new javax.swing.JLabel();
		pcMagicalAdjLabel = new javax.swing.JLabel();
		jLabel48 = new javax.swing.JLabel();
		pcSpellFailureLabel = new javax.swing.JLabel();
		jLabel50 = new javax.swing.JLabel();
		pcBonusSpellsDivineLabel = new javax.swing.JLabel();
		jLabel49 = new javax.swing.JLabel();
		pcWeightAllowanceLabel = new javax.swing.JLabel();
		savesPanel = new javax.swing.JPanel();
		jLabel29 = new javax.swing.JLabel();
		pcArmorClassLabel = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		pcArmorClassShieldlessLabel = new javax.swing.JLabel();
		jLabel33 = new javax.swing.JLabel();
		pcArmorClassRearLabel = new javax.swing.JLabel();
		jLabel35 = new javax.swing.JLabel();
		pcCurrentHPLabel = new javax.swing.JLabel();
		jLabel45 = new javax.swing.JLabel();
		pcMaxHPLabel = new javax.swing.JLabel();
		pcTHACOLabel = new javax.swing.JLabel();
		jLabel47 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		pcCombatMatrixTable = new javax.swing.JTable();
		combatPanel = new javax.swing.JPanel();
		pcSavePoisonLabel = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		pcSavePolyLabel = new javax.swing.JLabel();
		pcSaveRodLabel = new javax.swing.JLabel();
		pcSaveBreathLabel = new javax.swing.JLabel();
		pcSaveSpellsLabel = new javax.swing.JLabel();
		jLabel37 = new javax.swing.JLabel();
		jLabel39 = new javax.swing.JLabel();
		jLabel41 = new javax.swing.JLabel();
		jLabel43 = new javax.swing.JLabel();
		skillsPanel = new javax.swing.JPanel();
		arcaneSpellsPanel = new javax.swing.JPanel();
		divineSpellsPanel = new javax.swing.JPanel();

		setBackground(new java.awt.Color(255, 204, 153));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Character Sheet",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Details"));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("Name");

		pcCharacterNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcCharacterNameLabel.setText("pcCharacterName");

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel5.setText("Class");

		pcClassNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcClassNameLabel.setText("pcClass");

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel9.setText("Race");

		pcRaceLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcRaceLabel.setText("pcRace");

		jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel11.setText("Alignment");

		pcAlignmentLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcAlignmentLabel.setText("pcAlignment");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel7.setText("Level");

		pcClassLevelLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcClassLevelLabel.setText("pcClassLevel");

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("Player Name");

		pcPlayerNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcPlayerNameLabel.setText("pcPlayerName");

		jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel13.setText("Move-base");

		pcMoveBaseLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMoveBaseLabel.setText("pcMoveBase");

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel6.setText("EXP");
		jLabel6.setToolTipText("Total Experience");

		pcExperienceTotalsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcExperienceTotalsLabel.setText("pcExperience");

		javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(
				detailsPanel);
		detailsPanel.setLayout(detailsPanelLayout);
		detailsPanelLayout
				.setHorizontalGroup(detailsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								detailsPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcCharacterNameLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcClassNameLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel11)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcAlignmentLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcExperienceTotalsLabel)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel13)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcMoveBaseLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel9)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcRaceLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcClassLevelLabel))
														.addGroup(
																detailsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcPlayerNameLabel)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		detailsPanelLayout
				.setVerticalGroup(detailsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								detailsPanelLayout
										.createSequentialGroup()
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																pcCharacterNameLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcPlayerNameLabel,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcClassNameLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel7,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcClassLevelLabel,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcExperienceTotalsLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcRaceLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel9,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												detailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel11,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcAlignmentLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel13,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																pcMoveBaseLabel,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addContainerGap(48, Short.MAX_VALUE)));

		AbilitiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Abilities"));

		pcStrengthLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcStrengthLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcStrengthLabel.setText("00");

		jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel21.setText("Str");

		pcPercentileStrLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcPercentileStrLabel.setText("00%");
		pcPercentileStrLabel.setToolTipText("Percentile strength.");

		jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel28.setText("HitAdj");

		pcHitAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcHitAdjLabel.setText("999");

		jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel30.setText("DmgAdj");

		pcDmgAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDmgAdjLabel.setText("999");

		jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel32.setText("OD");
		jLabel32.setToolTipText("Open doors");

		pcOpenDoorLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcOpenDoorLabel.setText("1-3(1d6)");

		jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel34.setText("BB");
		jLabel34.setToolTipText("Bend Bars/Lift Gates");

		pcBendBarsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcBendBarsLabel.setText("999");

		pcDexterityLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcDexterityLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDexterityLabel.setText("00");

		jLabel24.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel24.setText("Dex");

		jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel52.setText("Reaction");

		pcReactionAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcReactionAdjLabel.setText("99");

		jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel54.setText("MissileAdj");

		pcMissileAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMissileAdjLabel.setText("99");

		jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel56.setText("DefAdj");

		pcDefenseAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDefenseAdjLabel.setText("99");

		pcConstitutionLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcConstitutionLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcConstitutionLabel.setText("00");

		jLabel25.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel25.setText("Con");

		jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel58.setText("HPAdj");

		pcHPAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcHPAdjLabel.setText("999");

		jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel60.setText("SS");

		pcSystemShockLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSystemShockLabel.setText("999");

		jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel62.setText("RS");

		pcResurrectionSurvivalLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcResurrectionSurvivalLabel.setText("999");

		pcCharismaLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcCharismaLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcCharismaLabel.setText("00");

		jLabel26.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel26.setText("Chr");

		jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel64.setText("Max");

		pcMaxHenchmenLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMaxHenchmenLabel.setText("99");

		jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel66.setText("LoyaltyBase");

		pcLoyaltyLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcLoyaltyLabel.setText("999");

		jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel68.setText("Reaction Adj");

		pcReactionAdjCharismaLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcReactionAdjCharismaLabel.setText("999");

		pcIntelligenceLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcIntelligenceLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcIntelligenceLabel.setText("00");

		pcWisdomLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcWisdomLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcWisdomLabel.setText("00");

		jLabel22.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel22.setText("Int");

		jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel36.setText("Lang.");

		pcLanguagesLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcLanguagesLabel.setText("99");

		jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel38.setText("% KS");
		jLabel38.setToolTipText("Percent to know/learn spell.");

		pcKnowSpellLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcKnowSpellLabel.setText("999");

		jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel40.setText("Min");

		pcMinSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMinSpellsLabel.setText("999");

		jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel42.setText("Max");

		pcMaxSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMaxSpellsLabel.setText("999");

		jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel44.setText("Bonus");

		pcBonusArcaneSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		pcBonusArcaneSpellsLabel
				.setText("L1x0,L2x0,L3x0,L4x0,L5x0,L6x0,L7x0,L8x0,L9x0");

		jLabel23.setFont(new java.awt.Font("Segoe UI", 2, 15));
		jLabel23.setText("Wis");

		jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel46.setText("MagAdj");

		pcMagicalAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMagicalAdjLabel.setText("99");

		jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel48.setText("Failure");

		pcSpellFailureLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSpellFailureLabel.setText("999");

		jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel50.setText("Bonus");

		pcBonusSpellsDivineLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		pcBonusSpellsDivineLabel.setText("L1x0,L2x0,L3x0,L4x0,L5x0,L6x0,L7x0");

		jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel49.setText("Weight");
		jLabel49.setToolTipText("Bend Bars/Lift Gates");

		pcWeightAllowanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcWeightAllowanceLabel.setText("999");

		javax.swing.GroupLayout AbilitiesPanelLayout = new javax.swing.GroupLayout(
				AbilitiesPanel);
		AbilitiesPanel.setLayout(AbilitiesPanelLayout);
		AbilitiesPanelLayout
				.setHorizontalGroup(AbilitiesPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								AbilitiesPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																AbilitiesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcStrengthLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel21)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcPercentileStrLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel28)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcHitAdjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel30)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcDmgAdjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel32)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcOpenDoorLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel34)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcBendBarsLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel49)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcWeightAllowanceLabel))
														.addGroup(
																AbilitiesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcDexterityLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel24)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel52)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcReactionAdjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel54)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcMissileAdjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel56)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcDefenseAdjLabel))
														.addGroup(
																AbilitiesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcConstitutionLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel25)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel58)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcHPAdjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel60)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcSystemShockLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel62)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcResurrectionSurvivalLabel))
														.addGroup(
																AbilitiesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcCharismaLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel26)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel64)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcMaxHenchmenLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel66)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcLoyaltyLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel68)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcReactionAdjCharismaLabel))
														.addGroup(
																AbilitiesPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				AbilitiesPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								pcIntelligenceLabel)
																						.addComponent(
																								pcWisdomLabel))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				AbilitiesPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								AbilitiesPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel22)
																										.addGap(8,
																												8,
																												8)
																										.addComponent(
																												jLabel36)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcLanguagesLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel38)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcKnowSpellLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel40)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcMinSpellsLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel42)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcMaxSpellsLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel44)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcBonusArcaneSpellsLabel))
																						.addGroup(
																								AbilitiesPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel23)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel46)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcMagicalAdjLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel48)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcSpellFailureLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel50)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcBonusSpellsDivineLabel)))))
										.addContainerGap(29, Short.MAX_VALUE)));
		AbilitiesPanelLayout
				.setVerticalGroup(AbilitiesPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								AbilitiesPanelLayout
										.createSequentialGroup()
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcStrengthLabel)
														.addComponent(jLabel21)
														.addComponent(
																pcPercentileStrLabel)
														.addComponent(jLabel28)
														.addComponent(
																pcHitAdjLabel)
														.addComponent(jLabel30)
														.addComponent(
																pcDmgAdjLabel)
														.addComponent(jLabel32)
														.addComponent(
																pcOpenDoorLabel)
														.addComponent(jLabel34)
														.addComponent(
																pcBendBarsLabel)
														.addComponent(jLabel49)
														.addComponent(
																pcWeightAllowanceLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcIntelligenceLabel)
														.addComponent(jLabel22)
														.addComponent(jLabel36)
														.addComponent(
																pcLanguagesLabel)
														.addComponent(jLabel38)
														.addComponent(
																pcKnowSpellLabel)
														.addComponent(jLabel40)
														.addComponent(
																pcMinSpellsLabel)
														.addComponent(jLabel42)
														.addComponent(
																pcMaxSpellsLabel)
														.addComponent(jLabel44)
														.addComponent(
																pcBonusArcaneSpellsLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcWisdomLabel)
														.addComponent(jLabel23)
														.addComponent(jLabel46)
														.addComponent(
																pcMagicalAdjLabel)
														.addComponent(jLabel48)
														.addComponent(
																pcSpellFailureLabel)
														.addComponent(jLabel50)
														.addComponent(
																pcBonusSpellsDivineLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcDexterityLabel)
														.addComponent(jLabel24)
														.addComponent(jLabel52)
														.addComponent(
																pcReactionAdjLabel)
														.addComponent(jLabel54)
														.addComponent(
																pcMissileAdjLabel)
														.addComponent(jLabel56)
														.addComponent(
																pcDefenseAdjLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcConstitutionLabel)
														.addComponent(jLabel25)
														.addComponent(jLabel58)
														.addComponent(
																pcHPAdjLabel)
														.addComponent(jLabel60)
														.addComponent(
																pcSystemShockLabel)
														.addComponent(jLabel62)
														.addComponent(
																pcResurrectionSurvivalLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												AbilitiesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcCharismaLabel)
														.addComponent(jLabel26)
														.addComponent(jLabel64)
														.addComponent(
																pcMaxHenchmenLabel)
														.addComponent(jLabel66)
														.addComponent(
																pcLoyaltyLabel)
														.addComponent(jLabel68)
														.addComponent(
																pcReactionAdjCharismaLabel))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		savesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Combat"));

		jLabel29.setText("AC");
		jLabel29.setToolTipText("Armor Class");

		pcArmorClassLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassLabel.setText("-10");
		pcArmorClassLabel.setToolTipText("Normal Armor Class.");

		jLabel31.setText("/");

		pcArmorClassShieldlessLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassShieldlessLabel.setText("-10");
		pcArmorClassShieldlessLabel
				.setToolTipText("Armor class without shield");

		jLabel33.setText("/");

		pcArmorClassRearLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassRearLabel.setText("-10");
		pcArmorClassRearLabel.setToolTipText("Armor class from rear.");

		jLabel35.setText("HP");
		jLabel35.setToolTipText("Current hitpoint total.");

		pcCurrentHPLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcCurrentHPLabel.setText("999");

		jLabel45.setText("Max");
		jLabel45.setToolTipText("Maximum hitpoints.");

		pcMaxHPLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		pcMaxHPLabel.setText("999");

		pcTHACOLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcTHACOLabel.setText("00");

		jLabel47.setText("THACO");
		jLabel47.setToolTipText("To hit armor class 0 value.");

		pcCombatMatrixTable.setBackground(new java.awt.Color(255, 204, 102));
		pcCombatMatrixTable.setFont(new java.awt.Font("Segoe UI", 0, 10));
		pcCombatMatrixTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,
						null, null, null, null, null } },
				new String[] { "AC10", "AC9", "AC8", "AC7", "AC6", "AC5",
						"AC4", "AC3", "AC2", "AC1", "AC0", "AC-1", "AC-2",
						"AC-3", "AC-4", "AC-5", "AC-6", "AC-7", "AC-8", "AC-9",
						"AC-10" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(pcCombatMatrixTable);

		javax.swing.GroupLayout savesPanelLayout = new javax.swing.GroupLayout(
				savesPanel);
		savesPanel.setLayout(savesPanelLayout);
		savesPanelLayout
				.setHorizontalGroup(savesPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								savesPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												savesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																savesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel29)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel31)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassShieldlessLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel33)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassRearLabel))
														.addGroup(
																savesPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel35)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcCurrentHPLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel45)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcMaxHPLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				438,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel47)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcTHACOLabel)))
										.addContainerGap())
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 663,
								Short.MAX_VALUE));
		savesPanelLayout
				.setVerticalGroup(savesPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								savesPanelLayout
										.createSequentialGroup()
										.addGroup(
												savesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel29)
														.addComponent(
																pcArmorClassLabel)
														.addComponent(jLabel31)
														.addComponent(
																pcArmorClassShieldlessLabel)
														.addComponent(jLabel33)
														.addComponent(
																pcArmorClassRearLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												savesPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel35)
														.addComponent(
																pcCurrentHPLabel)
														.addComponent(jLabel45)
														.addComponent(
																pcMaxHPLabel)
														.addComponent(
																pcTHACOLabel)
														.addComponent(jLabel47))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		combatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Saves"));

		pcSavePoisonLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSavePoisonLabel.setText("00");

		jLabel27.setFont(new java.awt.Font("Segoe UI", 2, 12));
		jLabel27.setText("Poison/Paralyzation");

		pcSavePolyLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSavePolyLabel.setText("00");

		pcSaveRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveRodLabel.setText("00");

		pcSaveBreathLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveBreathLabel.setText("00");

		pcSaveSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveSpellsLabel.setText("00");

		jLabel37.setFont(new java.awt.Font("Segoe UI", 2, 12));
		jLabel37.setText("Petrify/Poly");

		jLabel39.setFont(new java.awt.Font("Segoe UI", 2, 12));
		jLabel39.setText("Rod/Staff/Wand");

		jLabel41.setFont(new java.awt.Font("Segoe UI", 2, 12));
		jLabel41.setText("Breath");

		jLabel43.setFont(new java.awt.Font("Segoe UI", 2, 12));
		jLabel43.setText("Spells");

		javax.swing.GroupLayout combatPanelLayout = new javax.swing.GroupLayout(
				combatPanel);
		combatPanel.setLayout(combatPanelLayout);
		combatPanelLayout
				.setHorizontalGroup(combatPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								combatPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcSavePoisonLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel27))
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcSavePolyLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel37))
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcSaveRodLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel39))
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcSaveBreathLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel41))
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				pcSaveSpellsLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel43)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		combatPanelLayout
				.setVerticalGroup(combatPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								combatPanelLayout
										.createSequentialGroup()
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcSavePoisonLabel)
														.addComponent(jLabel27))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcSavePolyLabel)
														.addComponent(jLabel37))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcSaveRodLabel)
														.addComponent(jLabel39))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcSaveBreathLabel)
														.addComponent(jLabel41))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																pcSaveSpellsLabel)
														.addComponent(jLabel43))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		skillsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Skills"));
		skillsPanel
				.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		arcaneSpellsPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						new javax.swing.border.LineBorder(new java.awt.Color(0,
								0, 0), 1, true), "Arcane Spells"));
		arcaneSpellsPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT));

		divineSpellsPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						new javax.swing.border.LineBorder(new java.awt.Color(0,
								0, 0), 1, true), "Divine Spells"));
		divineSpellsPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		detailsPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		combatPanel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(123,
																		123,
																		123))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						skillsPanel,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						673,
																						Short.MAX_VALUE)
																				.addComponent(
																						savesPanel,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						AbilitiesPanel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		arcaneSpellsPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		673,
																		Short.MAX_VALUE)
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		divineSpellsPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		673,
																		Short.MAX_VALUE)
																.addContainerGap()))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														detailsPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														combatPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(AbilitiesPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(5, 5, 5)
								.addComponent(savesPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(5, 5, 5)
								.addComponent(skillsPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(arcaneSpellsPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(divineSpellsPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(27, Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	class ColorColumnRenderer extends DefaultTableCellRenderer {
		Color bkgndColor, fgndColor;

		public ColorColumnRenderer(Color bkgnd, Color foregnd) {
			super();
			bkgndColor = bkgnd;
			fgndColor = foregnd;
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component cell = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);

			cell.setBackground(bkgndColor);
			cell.setForeground(fgndColor);

			return cell;
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel AbilitiesPanel;
	private javax.swing.JPanel arcaneSpellsPanel;
	private javax.swing.JPanel combatPanel;
	private javax.swing.JPanel detailsPanel;
	private javax.swing.JPanel divineSpellsPanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel37;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel39;
	private javax.swing.JLabel jLabel40;
	private javax.swing.JLabel jLabel41;
	private javax.swing.JLabel jLabel42;
	private javax.swing.JLabel jLabel43;
	private javax.swing.JLabel jLabel44;
	private javax.swing.JLabel jLabel45;
	private javax.swing.JLabel jLabel46;
	private javax.swing.JLabel jLabel47;
	private javax.swing.JLabel jLabel48;
	private javax.swing.JLabel jLabel49;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel50;
	private javax.swing.JLabel jLabel52;
	private javax.swing.JLabel jLabel54;
	private javax.swing.JLabel jLabel56;
	private javax.swing.JLabel jLabel58;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel60;
	private javax.swing.JLabel jLabel62;
	private javax.swing.JLabel jLabel64;
	private javax.swing.JLabel jLabel66;
	private javax.swing.JLabel jLabel68;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel pcAlignmentLabel;
	private javax.swing.JLabel pcArmorClassLabel;
	private javax.swing.JLabel pcArmorClassRearLabel;
	private javax.swing.JLabel pcArmorClassShieldlessLabel;
	private javax.swing.JLabel pcBendBarsLabel;
	private javax.swing.JLabel pcBonusArcaneSpellsLabel;
	private javax.swing.JLabel pcBonusSpellsDivineLabel;
	private javax.swing.JLabel pcCharacterNameLabel;
	private javax.swing.JLabel pcCharismaLabel;
	private javax.swing.JLabel pcClassLevelLabel;
	private javax.swing.JLabel pcClassNameLabel;
	private javax.swing.JTable pcCombatMatrixTable;
	private javax.swing.JLabel pcConstitutionLabel;
	private javax.swing.JLabel pcCurrentHPLabel;
	private javax.swing.JLabel pcDefenseAdjLabel;
	private javax.swing.JLabel pcDexterityLabel;
	private javax.swing.JLabel pcDmgAdjLabel;
	private javax.swing.JLabel pcExperienceTotalsLabel;
	private javax.swing.JLabel pcHPAdjLabel;
	private javax.swing.JLabel pcHitAdjLabel;
	private javax.swing.JLabel pcIntelligenceLabel;
	private javax.swing.JLabel pcKnowSpellLabel;
	private javax.swing.JLabel pcLanguagesLabel;
	private javax.swing.JLabel pcLoyaltyLabel;
	private javax.swing.JLabel pcMagicalAdjLabel;
	private javax.swing.JLabel pcMaxHPLabel;
	private javax.swing.JLabel pcMaxHenchmenLabel;
	private javax.swing.JLabel pcMaxSpellsLabel;
	private javax.swing.JLabel pcMinSpellsLabel;
	private javax.swing.JLabel pcMissileAdjLabel;
	private javax.swing.JLabel pcMoveBaseLabel;
	private javax.swing.JLabel pcOpenDoorLabel;
	private javax.swing.JLabel pcPercentileStrLabel;
	private javax.swing.JLabel pcPlayerNameLabel;
	private javax.swing.JLabel pcRaceLabel;
	private javax.swing.JLabel pcReactionAdjCharismaLabel;
	private javax.swing.JLabel pcReactionAdjLabel;
	private javax.swing.JLabel pcResurrectionSurvivalLabel;
	private javax.swing.JLabel pcSaveBreathLabel;
	private javax.swing.JLabel pcSavePoisonLabel;
	private javax.swing.JLabel pcSavePolyLabel;
	private javax.swing.JLabel pcSaveRodLabel;
	private javax.swing.JLabel pcSaveSpellsLabel;
	private javax.swing.JLabel pcSpellFailureLabel;
	private javax.swing.JLabel pcStrengthLabel;
	private javax.swing.JLabel pcSystemShockLabel;
	private javax.swing.JLabel pcTHACOLabel;
	private javax.swing.JLabel pcWeightAllowanceLabel;
	private javax.swing.JLabel pcWisdomLabel;
	private javax.swing.JPanel savesPanel;
	private javax.swing.JPanel skillsPanel;
	// End of variables declaration//GEN-END:variables

}