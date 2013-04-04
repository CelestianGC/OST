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
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.SkillsClass;
import org.ost.main.MyUtils.ComponentPrinter;
import org.ost.main.MyUtils.SimpleDialog;

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

		updatePanel(oPlayer);
	}

	/**
	 * update Panel_Player with player data
	 * 
	 * @param oPlayer
	 */
	public void updatePanel(PlayerClass oPlayer) {
		// added this incase we updated panel
		removeAll();

		pc = oPlayer;

		RaceClass race = oPlayer.getMyRace().getRaceByID(ost.raceList);

		// portrait?

		// details
		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		Panel_Player_Details playerDetailsPanel = new Panel_Player_Details(ost,
				pc);
		add(playerDetailsPanel, gridBagConstraints);

		// saves
		Panel_Player_Saves playerSavesPanel = new Panel_Player_Saves(ost, pc);
		GridBagConstraints gbSaves = new java.awt.GridBagConstraints();
		gbSaves.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbSaves.gridx = 0;
		gbSaves.gridy = 2;
		gbSaves.anchor = java.awt.GridBagConstraints.WEST;
		add(playerSavesPanel, gbSaves);

		// abilities
		Panel_Player_Abilities playerAbilitiesPanel = new Panel_Player_Abilities(
				ost, pc);
		GridBagConstraints gbAbilities = new java.awt.GridBagConstraints();
		gbAbilities.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbAbilities.gridx = 0;
		gbAbilities.gridy = 3;
		gbAbilities.anchor = java.awt.GridBagConstraints.WEST;
		add(playerAbilitiesPanel, gbAbilities);

		// combat
		Panel_Player_Combat playerCombatPanel = new Panel_Player_Combat(ost, pc);
		GridBagConstraints gbCombat = new java.awt.GridBagConstraints();
		gbCombat.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbCombat.gridx = 0;
		gbCombat.gridy = 4;
		gbCombat.anchor = java.awt.GridBagConstraints.WEST;
		add(playerCombatPanel, gbCombat);

		// skills?
		if (pc.isSkilled(ost)) {
			Panel_Player_Skills playerSkillsPanel = new Panel_Player_Skills(
					ost, pc);
			GridBagConstraints gbSkills = new java.awt.GridBagConstraints();
			gbSkills.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbSkills.gridx = 0;
			gbSkills.gridy = 5;
			gbSkills.anchor = java.awt.GridBagConstraints.WEST;
			add(playerSkillsPanel, gbSkills);
		}

		// arcane spells
		if (pc.isCasterArcane(ost)) {
			Panel_Player_ArcaneSpells playerArcaneSpellsPanel = new Panel_Player_ArcaneSpells(
					ost, pc);
			GridBagConstraints gbArcane = new java.awt.GridBagConstraints();
			gbArcane.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbArcane.gridx = 0;
			gbArcane.gridy = 6;
			gbArcane.anchor = java.awt.GridBagConstraints.WEST;
			add(playerArcaneSpellsPanel, gbArcane);
		}

		// divine spells
		if (pc.isCasterDivine(ost)) {
			Panel_Player_DivineSpells playerDivineSpellsPanel = new Panel_Player_DivineSpells(
					ost, pc);
			GridBagConstraints gbDivine = new java.awt.GridBagConstraints();
			gbDivine.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbDivine.gridx = 0;
			gbDivine.gridy = 7;
			gbDivine.anchor = java.awt.GridBagConstraints.WEST;
			add(playerDivineSpellsPanel, gbDivine);
		}

		repaint();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setBackground(new java.awt.Color(255, 204, 153));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Character Sheet",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		setLayout(new java.awt.GridBagLayout());
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	// End of variables declaration//GEN-END:variables

}