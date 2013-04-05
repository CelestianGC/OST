/*
 * Frame_Character_Sheet.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.print.PrinterException;

import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyUtils.ComponentPrinter;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class Frame_Character_Sheet extends javax.swing.JFrame {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Frame_Character_Sheet */
	public Frame_Character_Sheet(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();

		setTitle("Character Sheet - " + pc.getName());
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), pc.getName(),
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		updatePanel(pc);

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = ost.mainFrame.getSize();
		//
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 4, windowSize.height - 4);

		setLocationRelativeTo(null);
	}

	public void updatePanel(PlayerClass oPlayer) {
		mainPanel.removeAll();

		pc = oPlayer;

		// portrait?

		// details
		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		Panel_Player_Details playerDetailsPanel = new Panel_Player_Details(ost,
				pc);
		mainPanel.add(playerDetailsPanel, gridBagConstraints);

		// saves
		Panel_Player_Saves playerSavesPanel = new Panel_Player_Saves(ost, pc);
		GridBagConstraints gbSaves = new java.awt.GridBagConstraints();
		gbSaves.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbSaves.gridx = 0;
		gbSaves.gridy = 2;
		gbSaves.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(playerSavesPanel, gbSaves);

		// abilities
		Panel_Player_Abilities playerAbilitiesPanel = new Panel_Player_Abilities(
				ost, pc);
		GridBagConstraints gbAbilities = new java.awt.GridBagConstraints();
		gbAbilities.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbAbilities.gridx = 0;
		gbAbilities.gridy = 3;
		gbAbilities.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(playerAbilitiesPanel, gbAbilities);

		// combat
		Panel_Player_Combat playerCombatPanel = new Panel_Player_Combat(ost, pc);
		GridBagConstraints gbCombat = new java.awt.GridBagConstraints();
		gbCombat.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbCombat.gridx = 0;
		gbCombat.gridy = 4;
		gbCombat.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(playerCombatPanel, gbCombat);

		// skills?
		if (pc.isSkilled(ost)) {
			Panel_Player_Skills playerSkillsPanel = new Panel_Player_Skills(
					ost, pc);
			GridBagConstraints gbSkills = new java.awt.GridBagConstraints();
			gbSkills.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbSkills.gridx = 0;
			gbSkills.gridy = 5;
			gbSkills.anchor = java.awt.GridBagConstraints.WEST;
			mainPanel.add(playerSkillsPanel, gbSkills);
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
			mainPanel.add(playerArcaneSpellsPanel, gbArcane);
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
			mainPanel.add(playerDivineSpellsPanel, gbDivine);
		}

		// features/extra abilities
		Panel_Player_Features playerFeatures = 
				new Panel_Player_Features(ost, pc);
		GridBagConstraints gbFeatures = new java.awt.GridBagConstraints();
		gbFeatures.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbFeatures.gridx = 0;
		gbFeatures.gridy = 8;
		gbFeatures.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(playerFeatures, gbFeatures);

		mainPanel.repaint();
		pack();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		buttonsPanel = new javax.swing.JPanel();
		sheetMenuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		printMenuItem = new javax.swing.JMenuItem();
		closeMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Character Sheet");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(255, 204, 102));
		mainPanel.setLayout(new java.awt.GridBagLayout());

		jLabel1.setText("jLabel1");
		mainPanel.add(jLabel1, new java.awt.GridBagConstraints());

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

		fileMenu.setText("File");

		printMenuItem.setText("Print");
		printMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				printMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(printMenuItem);

		closeMenuItem.setText("Close");
		closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(closeMenuItem);

		sheetMenuBar.add(fileMenu);

		setJMenuBar(sheetMenuBar);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			ComponentPrinter.printComponent(mainPanel, String.format("OST [%s]",pc.getName()));
		} catch (PrinterException e) {
			SimpleDialog.showError(e.getLocalizedMessage());
			//e.printStackTrace();
		}
	}

	private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		formWindowClosed(null);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		dispose();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JMenuItem closeMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JMenuItem printMenuItem;
	private javax.swing.JMenuBar sheetMenuBar;
	// End of variables declaration//GEN-END:variables

}