/*
 * Frame_Character_Sheet.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.PrintUtilities;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.VerticalLayout;
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

		mainPanel.setLayout(
				new VerticalLayout(1, VerticalLayout.BOTH, VerticalLayout.TOP));
		secondPanel.setLayout(
				new VerticalLayout(1, VerticalLayout.BOTH, VerticalLayout.TOP));
		
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
		int gridY = 1;
		mainPanel.removeAll();
		secondPanel.removeAll();

		pc = oPlayer;

		// portrait?

		// details
//		GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
//		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
//		gridBagConstraints.gridx = 0;
//		gridBagConstraints.gridy = gridY;
//		gridY++;
//		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		Panel_Player_Details playerDetailsPanel = new Panel_Player_Details(ost,
				pc);
//		mainPanel.add(playerDetailsPanel, gridBagConstraints);
		mainPanel.add(playerDetailsPanel);

		// saves
		Panel_Player_Saves playerSavesPanel = new Panel_Player_Saves(ost, pc);
//		GridBagConstraints gbSaves = new java.awt.GridBagConstraints();
//		gbSaves.fill = java.awt.GridBagConstraints.HORIZONTAL;
//		gbSaves.gridx = 0;
//		gbSaves.gridy = gridY;
//		gridY++;
//		gbSaves.anchor = java.awt.GridBagConstraints.WEST;
//		mainPanel.add(playerSavesPanel, gbSaves);
		mainPanel.add(playerSavesPanel);

		// abilities
		Panel_Player_Abilities playerAbilitiesPanel = new Panel_Player_Abilities(
				ost, pc);
//		GridBagConstraints gbAbilities = new java.awt.GridBagConstraints();
//		gbAbilities.fill = java.awt.GridBagConstraints.HORIZONTAL;
//		gbAbilities.gridx = 0;
//		gbAbilities.gridy = gridY;
//		gridY++;
//		gbAbilities.anchor = java.awt.GridBagConstraints.WEST;
//		mainPanel.add(playerAbilitiesPanel, gbAbilities);
		mainPanel.add(playerAbilitiesPanel);

		// combat
		Panel_Player_Combat playerCombatPanel = new Panel_Player_Combat(ost, pc);
//		GridBagConstraints gbCombat = new java.awt.GridBagConstraints();
//		gbCombat.fill = java.awt.GridBagConstraints.HORIZONTAL;
//		gbCombat.gridx = 0;
//		gbCombat.gridy = gridY;
//		gridY++;
//		gbCombat.anchor = java.awt.GridBagConstraints.WEST;
//		mainPanel.add(playerCombatPanel, gbCombat);
		mainPanel.add(playerCombatPanel);

		// skills?
		if (pc.isSkilled(ost)) {
			Panel_Player_Skills playerSkillsPanel = new Panel_Player_Skills(
					ost, pc);
//			GridBagConstraints gbSkills = new java.awt.GridBagConstraints();
//			gbSkills.fill = java.awt.GridBagConstraints.HORIZONTAL;
//			gbSkills.gridx = 0;
//			gbSkills.gridy = gridY;
//			gridY++;
//			gbSkills.anchor = java.awt.GridBagConstraints.WEST;
//			secondPanel.add(playerSkillsPanel, gbSkills);
			secondPanel.add(playerSkillsPanel);
		}

		if (pc.isCasterArcane(ost) || pc.isCasterDivine(ost)) {
			Panel_Player_Spells_All playerAllSpells = new Panel_Player_Spells_All(
					ost, pc);
//			GridBagConstraints gbAllSpells = new java.awt.GridBagConstraints();
//			gbAllSpells.fill = java.awt.GridBagConstraints.HORIZONTAL;
//			gbAllSpells.gridx = 0;
//			gbAllSpells.gridy = gridY;
//			gridY++;
//			gbAllSpells.anchor = java.awt.GridBagConstraints.WEST;
//			secondPanel.add(playerAllSpells, gbAllSpells);
			secondPanel.add(playerAllSpells);
		}

		// features/extra abilities
		Panel_Player_Features playerFeatures = new Panel_Player_Features(ost,
				pc);
//		GridBagConstraints gbFeatures = new java.awt.GridBagConstraints();
//		gbFeatures.fill = java.awt.GridBagConstraints.HORIZONTAL;
//		gbFeatures.gridx = 0;
//		gbFeatures.gridy = gridY;
//		gridY++;
//		gbFeatures.anchor = java.awt.GridBagConstraints.WEST;
//		secondPanel.add(playerFeatures, gbFeatures);
		secondPanel.add(playerFeatures);

		Panel_Player_WeaponsBlock playerWeapons = 
				new Panel_Player_WeaponsBlock(ost,pc);
		secondPanel.add(playerWeapons);
		
		secondPanel.repaint();
		//mainPanel.repaint();
		pack();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		secondPanel = new javax.swing.JPanel();
		mainPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		buttonsPanel = new javax.swing.JPanel();
		sheetMenuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		printMenuItem = new javax.swing.JMenuItem();
		closeMenuItem = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		nextPageMenuItem = new javax.swing.JMenuItem();
		previousPageMenuItem = new javax.swing.JMenuItem();

		secondPanel.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout secondPanelLayout = new javax.swing.GroupLayout(
				secondPanel);
		secondPanel.setLayout(secondPanelLayout);
		secondPanelLayout
				.setHorizontalGroup(secondPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));
		secondPanelLayout
				.setVerticalGroup(secondPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Character Sheet");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(255, 255, 255));
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
		fileMenu.add(jSeparator1);

		nextPageMenuItem.setText("Next");
		nextPageMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextPageMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(nextPageMenuItem);

		previousPageMenuItem.setText("Previous");
		previousPageMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						previousPageMenuItemActionPerformed(evt);
					}
				});
		fileMenu.add(previousPageMenuItem);

		sheetMenuBar.add(fileMenu);

		setJMenuBar(sheetMenuBar);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void previousPageMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.remove(secondPanel);
		this.add(mainPanel, BorderLayout.CENTER);
		revalidate();
		mainPanel.repaint();
		repaint();
	}

	private void nextPageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.remove(mainPanel);
		this.add(secondPanel, BorderLayout.CENTER);
		revalidate();
		secondPanel.repaint();
		repaint();
	}

	private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String printJobName = String.format("OST [%s]", pc.getName());

		PrinterJob printJob = PrinterJob.getPrinterJob();

		printJob.setJobName(printJobName);

		PageFormat format = printJob.getPageFormat(null);
		Paper paper = format.getPaper();
		paper.setSize(8.5 * 72, 11 * 72);
		paper.setImageableArea(0.0 * 72, 0.0 * 72, 7.5 * 72, 10.5 * 72);	
		format.setPaper(paper);

		Book book = new Book();
		book.append(new PrintUtilities(mainPanel), format);
		book.append(new PrintUtilities(secondPanel), format);
		printJob.setPageable(book);
		if(printJob.pageDialog(format) != null)
			if(printJob.printDialog()) {
				try {
					printJob.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					SimpleDialog.showError(e.getLocalizedMessage());
				}
			}
		
//		try {
//			ComponentPrinter.printComponent(mainPanel,printJobName);
//			ComponentPrinter.printComponent(secondPanel,printJobName+"2");
//		} catch (PrinterException e) {
//			SimpleDialog.showError(e.getLocalizedMessage());
//			//e.printStackTrace();
//		}

//		PrintUtilities printHelper = new PrintUtilities(mainPanel,printJobName);
//		
//		printHelper.print();
		
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
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JMenuItem nextPageMenuItem;
	private javax.swing.JMenuItem previousPageMenuItem;
	private javax.swing.JMenuItem printMenuItem;
	private javax.swing.JPanel secondPanel;
	private javax.swing.JMenuBar sheetMenuBar;
	// End of variables declaration//GEN-END:variables

}