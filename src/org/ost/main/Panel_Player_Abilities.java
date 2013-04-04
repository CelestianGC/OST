/*
 * Panel_Player_Abilities.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.ABILITY_CHARISMA;
import static org.ost.main.MyClasses.MyStatics.ABILITY_COMELINESS;
import static org.ost.main.MyClasses.MyStatics.ABILITY_CONSTITUTION;
import static org.ost.main.MyClasses.MyStatics.ABILITY_DEXTERITY;
import static org.ost.main.MyClasses.MyStatics.ABILITY_INTELLIGENCE;
import static org.ost.main.MyClasses.MyStatics.ABILITY_STRENGTH;
import static org.ost.main.MyClasses.MyStatics.ABILITY_WISDOM;
import static org.ost.main.MyClasses.MyStatics.AC_NAMES;
import static org.ost.main.MyClasses.MyStatics.AC_NORMAL;
import static org.ost.main.MyClasses.MyStatics.AC_REAR;
import static org.ost.main.MyClasses.MyStatics.AC_SHIELDLESS;
import static org.ost.main.MyClasses.MyStatics.ALIGNMENTS;
import static org.ost.main.MyClasses.MyStatics.DEFAULT_FONT;
import static org.ost.main.MyClasses.MyStatics.MAX_CLERIC_SPELL_LEVEL;
import static org.ost.main.MyClasses.MyStatics.MAX_MAGE_SPELL_LEVEL;
import static org.ost.main.MyClasses.MyStatics.SAVES;
import static org.ost.main.MyClasses.MyStatics.SAVE_BREATH;
import static org.ost.main.MyClasses.MyStatics.SAVE_DEATH;
import static org.ost.main.MyClasses.MyStatics.SAVE_POLY;
import static org.ost.main.MyClasses.MyStatics.SAVE_ROD;
import static org.ost.main.MyClasses.MyStatics.SAVE_SPELL;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_100;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_1_50;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_51_75;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_76_90;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_91_99;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.SkillsClass;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_Abilities extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_Abilities */
	public Panel_Player_Abilities(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();
		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		// TODO Auto-generated method stub
		// added this incase we updated panel
		pc = oPlayer;

		RaceClass race = oPlayer.getMyRace().getRaceByID(ost.raceList);
		// portrait

		// abilties
		ArrayList<AbilityScoreClass> abilityScoresAdj = pc
				.getAllAbilityScoreAdjustments(ost);

		for (int i = 0; i < pc.getMyAbilityScores().size(); i++) {
			AbilityScoreClass aJ = abilityScoresAdj.get(i);
			AbilityScoreClass aS = pc.getMyAbilityScores().get(i);
			int abilityTotal = aS.getScore() + aJ.getScore();
			int abilityPercentTotal = aS.getPercentile() + aJ.getPercentile();

			if (abilityTotal >= 0) {
				//				AbilityStatClass aStat = ost.abilityStatList.getContent().get(
				//						abilityTotal);
				AbilityStatClass aStat = ost.abilityStatList
						.getStat(abilityTotal);
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
					if (pc.hasBarbarianCon(ost))
						nConBonus = aStat.consitution.hitpointAdjustmentBarbarian;
					if (pc.hasFighterCon(ost))
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
					if (pc.hasBarbarianDex(ost))
						nDexBonus = aStat.dexterity.defensiveAdjustmentBarbarian;
					pcDefenseAdjLabel.setText(String.format("%d", nDexBonus));

					break;
				case ABILITY_INTELLIGENCE:
					pcIntelligenceLabel.setText(String.format("%d",
							abilityTotal));
					//bonus arcane spells
					String magicSpells = "";
					if (pc.isCasterArcane(ost))
						for (int ii = 0; ii < MAX_MAGE_SPELL_LEVEL; ii++) {
							magicSpells = magicSpells
									+ String.format(
											"L%dX%d%s",
											ii + 1,
											aStat.intelligence.bonusSpells[ii],
											ii + 1 < MAX_MAGE_SPELL_LEVEL ? ", "
													: "");
						}
					pcBonusArcaneSpellsLabel.setText(String.format("%s",
							magicSpells));
					if (magicSpells.length() <= 0)
						pcBonusArcaneLabel.setText("");
					else
						pcBonusArcaneLabel.setText("Bonus");

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
					boolean hasPercentileStrength = pc.hasPercentileStrength(ost);
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
					if (pc.isCasterDivine(ost))
						for (int ii = 0; ii < MAX_CLERIC_SPELL_LEVEL; ii++) {
							clericSpells = clericSpells
									+ String.format(
											"L%dX%d%s",
											ii + 1,
											aStat.wisdom.bonusSpells[ii],
											ii + 1 < MAX_CLERIC_SPELL_LEVEL ? ", "
													: "");
						}
					pcBonusSpellsDivineLabel.setText(String.format("%s",
							clericSpells));
					if (clericSpells.length() <= 0)
						pcBonusDivineLabel.setText("");
					else
						pcBonusDivineLabel.setText("Bonus");

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

		repaint();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		AbilitiesPanel = new javax.swing.JPanel();
		pcStrengthLabel = new javax.swing.JLabel();
		strLabel = new javax.swing.JLabel();
		strPanel = new javax.swing.JPanel();
		pcPercentileStrLabel = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		pcHitAdjLabel = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		pcDmgAdjLabel = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		pcOpenDoorLabel = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		pcBendBarsLabel = new javax.swing.JLabel();
		jLabel49 = new javax.swing.JLabel();
		pcWeightAllowanceLabel = new javax.swing.JLabel();
		pcIntelligenceLabel = new javax.swing.JLabel();
		intLabel = new javax.swing.JLabel();
		intPanel = new javax.swing.JPanel();
		jLabel36 = new javax.swing.JLabel();
		pcLanguagesLabel = new javax.swing.JLabel();
		jLabel38 = new javax.swing.JLabel();
		pcKnowSpellLabel = new javax.swing.JLabel();
		jLabel40 = new javax.swing.JLabel();
		pcMinSpellsLabel = new javax.swing.JLabel();
		jLabel42 = new javax.swing.JLabel();
		pcMaxSpellsLabel = new javax.swing.JLabel();
		pcBonusArcaneLabel = new javax.swing.JLabel();
		pcBonusArcaneSpellsLabel = new javax.swing.JLabel();
		pcWisdomLabel = new javax.swing.JLabel();
		wisLabel = new javax.swing.JLabel();
		wisPanel = new javax.swing.JPanel();
		jLabel46 = new javax.swing.JLabel();
		pcMagicalAdjLabel = new javax.swing.JLabel();
		jLabel48 = new javax.swing.JLabel();
		pcSpellFailureLabel = new javax.swing.JLabel();
		pcBonusDivineLabel = new javax.swing.JLabel();
		pcBonusSpellsDivineLabel = new javax.swing.JLabel();
		pcDexterityLabel = new javax.swing.JLabel();
		dexLabel = new javax.swing.JLabel();
		dexPanel = new javax.swing.JPanel();
		jLabel52 = new javax.swing.JLabel();
		pcReactionAdjLabel = new javax.swing.JLabel();
		jLabel54 = new javax.swing.JLabel();
		pcMissileAdjLabel = new javax.swing.JLabel();
		jLabel56 = new javax.swing.JLabel();
		pcDefenseAdjLabel = new javax.swing.JLabel();
		pcConstitutionLabel = new javax.swing.JLabel();
		conLabel = new javax.swing.JLabel();
		conPanel = new javax.swing.JPanel();
		jLabel58 = new javax.swing.JLabel();
		pcHPAdjLabel = new javax.swing.JLabel();
		jLabel60 = new javax.swing.JLabel();
		pcSystemShockLabel = new javax.swing.JLabel();
		jLabel62 = new javax.swing.JLabel();
		pcResurrectionSurvivalLabel = new javax.swing.JLabel();
		pcCharismaLabel = new javax.swing.JLabel();
		chrLabel = new javax.swing.JLabel();
		chrPanel = new javax.swing.JPanel();
		jLabel64 = new javax.swing.JLabel();
		pcMaxHenchmenLabel = new javax.swing.JLabel();
		jLabel66 = new javax.swing.JLabel();
		pcLoyaltyLabel = new javax.swing.JLabel();
		jLabel68 = new javax.swing.JLabel();
		pcReactionAdjCharismaLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();

		setLayout(new java.awt.BorderLayout());

		AbilitiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Abilities"));
		AbilitiesPanel.setLayout(new java.awt.GridBagLayout());

		pcStrengthLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcStrengthLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcStrengthLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcStrengthLabel, gridBagConstraints);

		strLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		strLabel.setText("Str");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(strLabel, gridBagConstraints);

		strPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		pcPercentileStrLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcPercentileStrLabel.setText("00%");
		pcPercentileStrLabel.setToolTipText("Percentile strength.");
		strPanel.add(pcPercentileStrLabel);

		jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel28.setText("HitAdj");
		strPanel.add(jLabel28);

		pcHitAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcHitAdjLabel.setText("999");
		strPanel.add(pcHitAdjLabel);

		jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel30.setText("DmgAdj");
		strPanel.add(jLabel30);

		pcDmgAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDmgAdjLabel.setText("999");
		strPanel.add(pcDmgAdjLabel);

		jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel32.setText("OD");
		jLabel32.setToolTipText("Open doors");
		strPanel.add(jLabel32);

		pcOpenDoorLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcOpenDoorLabel.setText("1-3(1d6)");
		strPanel.add(pcOpenDoorLabel);

		jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel34.setText("BB");
		jLabel34.setToolTipText("Bend Bars/Lift Gates");
		strPanel.add(jLabel34);

		pcBendBarsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcBendBarsLabel.setText("999");
		strPanel.add(pcBendBarsLabel);

		jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel49.setText("Weight");
		jLabel49.setToolTipText("Bend Bars/Lift Gates");
		strPanel.add(jLabel49);

		pcWeightAllowanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcWeightAllowanceLabel.setText("999");
		strPanel.add(pcWeightAllowanceLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(strPanel, gridBagConstraints);

		pcIntelligenceLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcIntelligenceLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcIntelligenceLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcIntelligenceLabel, gridBagConstraints);

		intLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		intLabel.setText("Int");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(intLabel, gridBagConstraints);

		intPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel36.setText("Lang.");
		intPanel.add(jLabel36);

		pcLanguagesLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcLanguagesLabel.setText("99");
		intPanel.add(pcLanguagesLabel);

		jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel38.setText("% KS");
		jLabel38.setToolTipText("Percent to know/learn spell.");
		intPanel.add(jLabel38);

		pcKnowSpellLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcKnowSpellLabel.setText("999");
		intPanel.add(pcKnowSpellLabel);

		jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel40.setText("Min");
		intPanel.add(jLabel40);

		pcMinSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMinSpellsLabel.setText("999");
		intPanel.add(pcMinSpellsLabel);

		jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel42.setText("Max");
		intPanel.add(jLabel42);

		pcMaxSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMaxSpellsLabel.setText("999");
		intPanel.add(pcMaxSpellsLabel);

		pcBonusArcaneLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		pcBonusArcaneLabel.setText("Bonus");
		intPanel.add(pcBonusArcaneLabel);

		pcBonusArcaneSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		pcBonusArcaneSpellsLabel
				.setText("L1x0,L2x0,L3x0,L4x0,L5x0,L6x0,L7x0,L8x0,L9x0");
		intPanel.add(pcBonusArcaneSpellsLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(intPanel, gridBagConstraints);

		pcWisdomLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcWisdomLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcWisdomLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcWisdomLabel, gridBagConstraints);

		wisLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		wisLabel.setText("Wis");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(wisLabel, gridBagConstraints);

		wisPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel46.setText("MagAdj");
		wisPanel.add(jLabel46);

		pcMagicalAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMagicalAdjLabel.setText("99");
		wisPanel.add(pcMagicalAdjLabel);

		jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel48.setText("Failure");
		wisPanel.add(jLabel48);

		pcSpellFailureLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSpellFailureLabel.setText("999");
		wisPanel.add(pcSpellFailureLabel);

		pcBonusDivineLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		pcBonusDivineLabel.setText("Bonus");
		wisPanel.add(pcBonusDivineLabel);

		pcBonusSpellsDivineLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		pcBonusSpellsDivineLabel.setText("L1x0,L2x0,L3x0,L4x0,L5x0,L6x0,L7x0");
		wisPanel.add(pcBonusSpellsDivineLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(wisPanel, gridBagConstraints);

		pcDexterityLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcDexterityLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDexterityLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcDexterityLabel, gridBagConstraints);

		dexLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		dexLabel.setText("Dex");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(dexLabel, gridBagConstraints);

		dexPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel52.setText("Reaction");
		dexPanel.add(jLabel52);

		pcReactionAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcReactionAdjLabel.setText("99");
		dexPanel.add(pcReactionAdjLabel);

		jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel54.setText("MissileAdj");
		dexPanel.add(jLabel54);

		pcMissileAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMissileAdjLabel.setText("99");
		dexPanel.add(pcMissileAdjLabel);

		jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel56.setText("DefAdj");
		dexPanel.add(jLabel56);

		pcDefenseAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcDefenseAdjLabel.setText("99");
		dexPanel.add(pcDefenseAdjLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(dexPanel, gridBagConstraints);

		pcConstitutionLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcConstitutionLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcConstitutionLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcConstitutionLabel, gridBagConstraints);

		conLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		conLabel.setText("Con");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(conLabel, gridBagConstraints);

		conPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel58.setText("HPAdj");
		conPanel.add(jLabel58);

		pcHPAdjLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcHPAdjLabel.setText("999");
		conPanel.add(pcHPAdjLabel);

		jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel60.setText("SS");
		conPanel.add(jLabel60);

		pcSystemShockLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSystemShockLabel.setText("999");
		conPanel.add(pcSystemShockLabel);

		jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel62.setText("RS");
		conPanel.add(jLabel62);

		pcResurrectionSurvivalLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcResurrectionSurvivalLabel.setText("999");
		conPanel.add(pcResurrectionSurvivalLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(conPanel, gridBagConstraints);

		pcCharismaLabel.setBackground(new java.awt.Color(255, 255, 255));
		pcCharismaLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcCharismaLabel.setText("00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(pcCharismaLabel, gridBagConstraints);

		chrLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		chrLabel.setText("Chr");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		AbilitiesPanel.add(chrLabel, gridBagConstraints);

		chrPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel64.setText("Max");
		chrPanel.add(jLabel64);

		pcMaxHenchmenLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcMaxHenchmenLabel.setText("99");
		chrPanel.add(pcMaxHenchmenLabel);

		jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel66.setText("LoyaltyBase");
		chrPanel.add(jLabel66);

		pcLoyaltyLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcLoyaltyLabel.setText("999");
		chrPanel.add(pcLoyaltyLabel);

		jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel68.setText("Reaction Adj");
		chrPanel.add(jLabel68);

		pcReactionAdjCharismaLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcReactionAdjCharismaLabel.setText("999");
		chrPanel.add(pcReactionAdjCharismaLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		AbilitiesPanel.add(chrPanel, gridBagConstraints);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.weightx = 5.0;
		gridBagConstraints.weighty = 5.0;
		AbilitiesPanel.add(jPanel1, gridBagConstraints);

		add(AbilitiesPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel AbilitiesPanel;
	private javax.swing.JLabel chrLabel;
	private javax.swing.JPanel chrPanel;
	private javax.swing.JLabel conLabel;
	private javax.swing.JPanel conPanel;
	private javax.swing.JLabel dexLabel;
	private javax.swing.JPanel dexPanel;
	private javax.swing.JLabel intLabel;
	private javax.swing.JPanel intPanel;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel40;
	private javax.swing.JLabel jLabel42;
	private javax.swing.JLabel jLabel46;
	private javax.swing.JLabel jLabel48;
	private javax.swing.JLabel jLabel49;
	private javax.swing.JLabel jLabel52;
	private javax.swing.JLabel jLabel54;
	private javax.swing.JLabel jLabel56;
	private javax.swing.JLabel jLabel58;
	private javax.swing.JLabel jLabel60;
	private javax.swing.JLabel jLabel62;
	private javax.swing.JLabel jLabel64;
	private javax.swing.JLabel jLabel66;
	private javax.swing.JLabel jLabel68;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel pcBendBarsLabel;
	private javax.swing.JLabel pcBonusArcaneLabel;
	private javax.swing.JLabel pcBonusArcaneSpellsLabel;
	private javax.swing.JLabel pcBonusDivineLabel;
	private javax.swing.JLabel pcBonusSpellsDivineLabel;
	private javax.swing.JLabel pcCharismaLabel;
	private javax.swing.JLabel pcConstitutionLabel;
	private javax.swing.JLabel pcDefenseAdjLabel;
	private javax.swing.JLabel pcDexterityLabel;
	private javax.swing.JLabel pcDmgAdjLabel;
	private javax.swing.JLabel pcHPAdjLabel;
	private javax.swing.JLabel pcHitAdjLabel;
	private javax.swing.JLabel pcIntelligenceLabel;
	private javax.swing.JLabel pcKnowSpellLabel;
	private javax.swing.JLabel pcLanguagesLabel;
	private javax.swing.JLabel pcLoyaltyLabel;
	private javax.swing.JLabel pcMagicalAdjLabel;
	private javax.swing.JLabel pcMaxHenchmenLabel;
	private javax.swing.JLabel pcMaxSpellsLabel;
	private javax.swing.JLabel pcMinSpellsLabel;
	private javax.swing.JLabel pcMissileAdjLabel;
	private javax.swing.JLabel pcOpenDoorLabel;
	private javax.swing.JLabel pcPercentileStrLabel;
	private javax.swing.JLabel pcReactionAdjCharismaLabel;
	private javax.swing.JLabel pcReactionAdjLabel;
	private javax.swing.JLabel pcResurrectionSurvivalLabel;
	private javax.swing.JLabel pcSpellFailureLabel;
	private javax.swing.JLabel pcStrengthLabel;
	private javax.swing.JLabel pcSystemShockLabel;
	private javax.swing.JLabel pcWeightAllowanceLabel;
	private javax.swing.JLabel pcWisdomLabel;
	private javax.swing.JLabel strLabel;
	private javax.swing.JPanel strPanel;
	private javax.swing.JLabel wisLabel;
	private javax.swing.JPanel wisPanel;
	// End of variables declaration//GEN-END:variables

}