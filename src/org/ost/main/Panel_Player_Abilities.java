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
					if (pc.isCasterArcane(ost.characterClassList,
							ost.extraAbilitiesList, ost.raceList))
						for (int ii = 0; ii < MAX_MAGE_SPELL_LEVEL; ii++) {
							magicSpells = magicSpells
									+ String.format(
											"L%dX%d%s",
											ii + 1,
											aStat.intelligence.bonusSpells[ii],
											ii + 1 < MAX_MAGE_SPELL_LEVEL ? ", "
													: "");
						}
					pcBonusArcaneSpellsLabel.setText(
							String.format("%s",magicSpells));
					if (magicSpells.length()<=0) 
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
					if (pc.isCasterDivine(ost.characterClassList,
							ost.extraAbilitiesList, ost.raceList))
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
					if (clericSpells.length()<=0) 
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
		pcBonusArcaneLabel = new javax.swing.JLabel();
		pcBonusArcaneSpellsLabel = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel46 = new javax.swing.JLabel();
		pcMagicalAdjLabel = new javax.swing.JLabel();
		jLabel48 = new javax.swing.JLabel();
		pcSpellFailureLabel = new javax.swing.JLabel();
		pcBonusDivineLabel = new javax.swing.JLabel();
		pcBonusSpellsDivineLabel = new javax.swing.JLabel();
		jLabel49 = new javax.swing.JLabel();
		pcWeightAllowanceLabel = new javax.swing.JLabel();

		setLayout(new java.awt.BorderLayout());

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

		pcBonusArcaneLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		pcBonusArcaneLabel.setText("Bonus");

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

		pcBonusDivineLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		pcBonusDivineLabel.setText("Bonus");

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
																												pcBonusArcaneLabel)
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
																												pcBonusDivineLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pcBonusSpellsDivineLabel)))))
										.addContainerGap(22, Short.MAX_VALUE)));
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
														.addComponent(
																pcBonusArcaneLabel)
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
														.addComponent(
																pcBonusDivineLabel)
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
										.addContainerGap(20, Short.MAX_VALUE)));

		add(AbilitiesPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel AbilitiesPanel;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
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
	// End of variables declaration//GEN-END:variables

}