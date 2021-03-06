/*
 * Panel_Player_Saves.java
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
public class Panel_Player_Saves extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_Saves */
	public Panel_Player_Saves(MainClass ost, PlayerClass oPlayer) {
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

		// saves
		ArrayList<Integer> bestSaves = pc.getAllSaves(ost);
		pc.setMySaves(bestSaves);

		ArrayList<Integer> bestSaveAdj = pc.getAllSaveAdjustments(ost);
		pc.setMySaveAdjustments(bestSaveAdj);

		for (int i = 0; i < pc.getMySaves().size(); i++) {
			int aB = pc.getMySaves().get(i);
			int aJ = pc.getMySaveAdjustments().get(i);
			switch (i) {
			case SAVE_BREATH:
				pcSaveBreathLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveBreathLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				spellsSaveLabel.setText(SAVES[i]);
				break;
			case SAVE_DEATH:
				pcSavePoisonLabel.setText(String.format("%d", (aB - aJ)));
				pcSavePoisonLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				deathSaveLabel.setText(SAVES[i]);
				break;
			case SAVE_POLY:
				pcSavePolyLabel.setText(String.format("%d", (aB - aJ)));
				pcSavePolyLabel.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				polySaveLabel.setText(SAVES[i]);
				break;
			case SAVE_ROD:
				pcSaveRodLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveRodLabel.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				rodSaveLabel.setText(SAVES[i]);
				break;
			case SAVE_SPELL:
				pcSaveSpellsLabel.setText(String.format("%d", (aB - aJ)));
				pcSaveSpellsLabel
						.setToolTipText(SAVES[i] + ":" + aB + "+" + aJ);
				spellsSaveLabel.setText(SAVES[i]);
				break;

			default:
				ost.dprint("Unknown save type in Panel_Player updatePanel()\n");
				break;
			}

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

		savesPanel = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		pcSavePoisonLabel = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		deathSaveLabel = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		pcSavePolyLabel = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		polySaveLabel = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		pcSaveRodLabel = new javax.swing.JLabel();
		jPanel7 = new javax.swing.JPanel();
		rodSaveLabel = new javax.swing.JLabel();
		jPanel8 = new javax.swing.JPanel();
		pcSaveBreathLabel = new javax.swing.JLabel();
		jPanel9 = new javax.swing.JPanel();
		breathSaveLabel = new javax.swing.JLabel();
		jPanel10 = new javax.swing.JPanel();
		pcSaveSpellsLabel = new javax.swing.JLabel();
		jPanel11 = new javax.swing.JPanel();
		spellsSaveLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jPanel12 = new javax.swing.JPanel();
		jPanel13 = new javax.swing.JPanel();
		jPanel14 = new javax.swing.JPanel();
		jPanel15 = new javax.swing.JPanel();
		blackBackPanel = new javax.swing.JPanel();

		setLayout(new java.awt.BorderLayout());

		savesPanel.setBackground(new java.awt.Color(255, 255, 255));
		savesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Saves"));
		savesPanel.setLayout(new java.awt.GridBagLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setLayout(new java.awt.BorderLayout());

		pcSavePoisonLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSavePoisonLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pcSavePoisonLabel.setText("00");
		pcSavePoisonLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jPanel2.add(pcSavePoisonLabel, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
		savesPanel.add(jPanel2, gridBagConstraints);

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		deathSaveLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		deathSaveLabel.setText("Poison/Paralyzation");
		jPanel3.add(deathSaveLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel3, gridBagConstraints);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setLayout(new java.awt.BorderLayout());

		pcSavePolyLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSavePolyLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pcSavePolyLabel.setText("00");
		pcSavePolyLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jPanel4.add(pcSavePolyLabel, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
		savesPanel.add(jPanel4, gridBagConstraints);

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));
		jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		polySaveLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		polySaveLabel.setText("Petrify/Poly");
		jPanel5.add(polySaveLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel5, gridBagConstraints);

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));
		jPanel6.setLayout(new java.awt.BorderLayout());

		pcSaveRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveRodLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pcSaveRodLabel.setText("00");
		pcSaveRodLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jPanel6.add(pcSaveRodLabel, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
		savesPanel.add(jPanel6, gridBagConstraints);

		jPanel7.setBackground(new java.awt.Color(255, 255, 255));
		jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		rodSaveLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		rodSaveLabel.setText("Rod/Staff/Wand");
		jPanel7.add(rodSaveLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel7, gridBagConstraints);

		jPanel8.setBackground(new java.awt.Color(255, 255, 255));
		jPanel8.setLayout(new java.awt.BorderLayout());

		pcSaveBreathLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveBreathLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pcSaveBreathLabel.setText("00");
		pcSaveBreathLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jPanel8.add(pcSaveBreathLabel, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
		savesPanel.add(jPanel8, gridBagConstraints);

		jPanel9.setBackground(new java.awt.Color(255, 255, 255));
		jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		breathSaveLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		breathSaveLabel.setText("Breath");
		jPanel9.add(breathSaveLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel9, gridBagConstraints);

		jPanel10.setBackground(new java.awt.Color(255, 255, 255));
		jPanel10.setLayout(new java.awt.BorderLayout());

		pcSaveSpellsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcSaveSpellsLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pcSaveSpellsLabel.setText("00");
		pcSaveSpellsLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jPanel10.add(pcSaveSpellsLabel, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
		savesPanel.add(jPanel10, gridBagConstraints);

		jPanel11.setBackground(new java.awt.Color(255, 255, 255));
		jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		spellsSaveLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		spellsSaveLabel.setText("Spells");
		jPanel11.add(spellsSaveLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		savesPanel.add(jPanel11, gridBagConstraints);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 32,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 5.0;
		savesPanel.add(jPanel1, gridBagConstraints);

		jPanel12.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(
				jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));
		jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 31,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 5.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel12, gridBagConstraints);

		jPanel13.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(
				jPanel13);
		jPanel13.setLayout(jPanel13Layout);
		jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));
		jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 31,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 5.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel13, gridBagConstraints);

		jPanel14.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(
				jPanel14);
		jPanel14.setLayout(jPanel14Layout);
		jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));
		jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 31,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 5.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel14, gridBagConstraints);

		jPanel15.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(
				jPanel15);
		jPanel15.setLayout(jPanel15Layout);
		jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));
		jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 31,
				Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 5.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
		savesPanel.add(jPanel15, gridBagConstraints);

		blackBackPanel.setBackground(new java.awt.Color(0, 0, 0));

		javax.swing.GroupLayout blackBackPanelLayout = new javax.swing.GroupLayout(
				blackBackPanel);
		blackBackPanel.setLayout(blackBackPanelLayout);
		blackBackPanelLayout.setHorizontalGroup(blackBackPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE));
		blackBackPanelLayout.setVerticalGroup(blackBackPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 164, Short.MAX_VALUE));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		savesPanel.add(blackBackPanel, gridBagConstraints);

		add(savesPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel blackBackPanel;
	private javax.swing.JLabel breathSaveLabel;
	private javax.swing.JLabel deathSaveLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel13;
	private javax.swing.JPanel jPanel14;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JLabel pcSaveBreathLabel;
	private javax.swing.JLabel pcSavePoisonLabel;
	private javax.swing.JLabel pcSavePolyLabel;
	private javax.swing.JLabel pcSaveRodLabel;
	private javax.swing.JLabel pcSaveSpellsLabel;
	private javax.swing.JLabel polySaveLabel;
	private javax.swing.JLabel rodSaveLabel;
	private javax.swing.JPanel savesPanel;
	private javax.swing.JLabel spellsSaveLabel;
	// End of variables declaration//GEN-END:variables

}