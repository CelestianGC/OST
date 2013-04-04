/*
 * DM_Config_Tab_Config_Options.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class DM_Config_Tab_Config_Options extends javax.swing.JPanel {
	private MainClass ost;

	/** Creates new form DM_Config_Tab_Config_Options */
	public DM_Config_Tab_Config_Options(MainClass ost) {
		this.ost = ost;
		initComponents();

		initAllOptions();

		tablesConfig = new DM_Config_Tab_Tables(ost);
		chartsConfig = new DM_Config_Tab_Charts(ost);

		tableMainPanel.add(tablesConfig);
		chartMainPanel.add(chartsConfig);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		tableDialog = new javax.swing.JDialog();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableMainPanel = new javax.swing.JPanel();
		tableButtonPanel = new javax.swing.JPanel();
		chartDoneButton = new javax.swing.JButton();
		chartDialog = new javax.swing.JDialog();
		jScrollPane2 = new javax.swing.JScrollPane();
		chartMainPanel = new javax.swing.JPanel();
		chartButtonPanel = new javax.swing.JPanel();
		tableDoneButton1 = new javax.swing.JButton();
		mainPanel = new javax.swing.JPanel();
		abilityScoresButton = new javax.swing.JButton();
		tablesButton = new javax.swing.JButton();
		chartsButton = new javax.swing.JButton();
		raceButton = new javax.swing.JButton();
		classButton = new javax.swing.JButton();
		itemButton = new javax.swing.JButton();
		extraAbilitiesButton = new javax.swing.JButton();
		nonWeaponProfsButton = new javax.swing.JButton();
		nonWeaponProfsButton1 = new javax.swing.JButton();

		tableDialog.setTitle("Tables");

		tableMainPanel.setBackground(new java.awt.Color(153, 153, 153));
		tableMainPanel.setLayout(new java.awt.BorderLayout());
		jScrollPane1.setViewportView(tableMainPanel);

		tableDialog.getContentPane().add(jScrollPane1,
				java.awt.BorderLayout.CENTER);

		tableButtonPanel.setBackground(new java.awt.Color(204, 204, 204));
		tableButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		chartDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		chartDoneButton.setText("done");
		chartDoneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chartDoneButtonActionPerformed(evt);
			}
		});
		tableButtonPanel.add(chartDoneButton);

		tableDialog.getContentPane().add(tableButtonPanel,
				java.awt.BorderLayout.PAGE_END);

		chartDialog.setTitle("Charts");

		chartMainPanel.setBackground(new java.awt.Color(153, 153, 153));
		chartMainPanel.setLayout(new java.awt.BorderLayout());
		jScrollPane2.setViewportView(chartMainPanel);

		chartDialog.getContentPane().add(jScrollPane2,
				java.awt.BorderLayout.CENTER);

		chartButtonPanel.setBackground(new java.awt.Color(204, 204, 204));
		chartButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		tableDoneButton1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		tableDoneButton1.setText("done");
		tableDoneButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tableDoneButton1ActionPerformed(evt);
			}
		});
		chartButtonPanel.add(tableDoneButton1);

		chartDialog.getContentPane().add(chartButtonPanel,
				java.awt.BorderLayout.PAGE_END);

		setLayout(new java.awt.BorderLayout());

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Custom Configuration",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		abilityScoresButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		abilityScoresButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Muscles-icon-24.png"))); // NOI18N
		abilityScoresButton.setText("ability stats");
		abilityScoresButton
				.setToolTipText("Configure the adjustments for ability scores.");
		abilityScoresButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						abilityScoresButtonActionPerformed(evt);
					}
				});

		tablesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		tablesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d8-icon-24.png"))); // NOI18N
		tablesButton.setText("tables");
		tablesButton.setToolTipText("Create and edit tables.");
		tablesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tablesButtonActionPerformed(evt);
			}
		});

		chartsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		chartsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Compass-icon-24.png"))); // NOI18N
		chartsButton.setText("charts");
		chartsButton.setToolTipText("Create and edit charts.");
		chartsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chartsButtonActionPerformed(evt);
			}
		});

		raceButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Male-Face-D2-icon-24.png"))); // NOI18N
		raceButton.setText("race");
		raceButton.setToolTipText("Create and modify races.");
		raceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				raceButtonActionPerformed(evt);
			}
		});

		classButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/books-icon-24.png"))); // NOI18N
		classButton.setText("class");
		classButton.setToolTipText("Create and modify classes.");
		classButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				classButtonActionPerformed(evt);
			}
		});

		itemButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		itemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/treasure-chest-open-icon-24.png"))); // NOI18N
		itemButton.setText("item");
		itemButton.setToolTipText("Create and modify items.");
		itemButton.setEnabled(false);
		itemButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				itemButtonActionPerformed(evt);
			}
		});

		extraAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		extraAbilitiesButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource(
						"/images/Apps-utilities-desktop-extra-icon-24.png"))); // NOI18N
		extraAbilitiesButton.setText("features");
		extraAbilitiesButton
				.setToolTipText("Extra-Abilities attached to class, race, objects or proficiencies.");
		extraAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						extraAbilitiesButtonActionPerformed(evt);
					}
				});

		nonWeaponProfsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nonWeaponProfsButton.setText("non-weapon");
		nonWeaponProfsButton.setEnabled(false);
		nonWeaponProfsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						nonWeaponProfsButtonActionPerformed(evt);
					}
				});

		nonWeaponProfsButton1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nonWeaponProfsButton1.setText("weapon profs");
		nonWeaponProfsButton1.setEnabled(false);
		nonWeaponProfsButton1
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						nonWeaponProfsButton1ActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								mainPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												abilityScoresButton)
																										.addComponent(
																												tablesButton))
																						.addGroup(
																								mainPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												classButton)
																										.addComponent(
																												raceButton)))
																		.addGap(0,
																				0,
																				0)
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								chartsButton)
																						.addComponent(
																								extraAbilitiesButton)))
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				itemButton)
																		.addGap(0,
																				0,
																				0)
																		.addComponent(
																				nonWeaponProfsButton)
																		.addGap(0,
																				0,
																				0)
																		.addComponent(
																				nonWeaponProfsButton1)))
										.addContainerGap(60, Short.MAX_VALUE)));

		mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { abilityScoresButton, chartsButton,
						classButton, extraAbilitiesButton, itemButton,
						nonWeaponProfsButton, nonWeaponProfsButton1,
						raceButton, tablesButton });

		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																abilityScoresButton)
														.addComponent(
																tablesButton)
														.addComponent(
																chartsButton))
										.addGap(0, 0, 0)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																classButton)
														.addComponent(
																raceButton)
														.addComponent(
																extraAbilitiesButton))
										.addGap(0, 0, 0)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nonWeaponProfsButton)
														.addComponent(
																nonWeaponProfsButton1)
														.addComponent(
																itemButton))
										.addContainerGap(175, Short.MAX_VALUE)));

		mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { abilityScoresButton, classButton,
						extraAbilitiesButton, itemButton, nonWeaponProfsButton,
						nonWeaponProfsButton1, raceButton });

		add(mainPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

	private void nonWeaponProfsButton1ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_List_WeaponProfs dDialog = new Option_List_WeaponProfs(
				ost.mainFrame, true, ost);
		dDialog.setVisible(true);
	}

	private void nonWeaponProfsButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_List_NonWeaponProfs dDialog = new Option_List_NonWeaponProfs(
				ost.mainFrame, true, ost);
		dDialog.setVisible(true);

	}

	private void extraAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		Option_List_ExtraAbilities dDialog = new Option_List_ExtraAbilities(
				ost.mainFrame, true, ost);
		dDialog.setVisible(true);
	}

	private void itemButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		SimpleDialog.showError("Under construction.");

	}

	private void classButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_List_CharacterClasses dDialog = new Option_List_CharacterClasses(
				ost.mainFrame, true, ost);
		dDialog.setVisible(true);
	}

	private void raceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_List_Races dDialog = new Option_List_Races(ost.mainFrame, true,
				ost);
		dDialog.setVisible(true);
	}

	private void chartsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = mainPanel.getSize();

		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		chartDialog.setLocation(windowX, windowY);
		chartDialog.setSize(windowSize.width - 4, windowSize.height - 4);

		chartDialog.setLocationRelativeTo(null);
		chartDialog.setVisible(true);
	}

	private void tableDoneButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		chartDialog.setVisible(false);
	}

	private void chartDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		tableDialog.setVisible(false);
	}

	private void tablesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = mainPanel.getSize();

		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		tableDialog.setLocation(windowX, windowY);
		tableDialog.setSize(windowSize.width - 4, windowSize.height - 4);

		tableDialog.setLocationRelativeTo(null);
		tableDialog.setVisible(true);
	}

	private void abilityScoresButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		optionAbilityScores.setVisible(true);
	}

	private void initAllOptions() {
		optionAbilityScores = new Option_AbilityScores(ost.mainFrame, true, ost);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton abilityScoresButton;
	private javax.swing.JPanel chartButtonPanel;
	private javax.swing.JDialog chartDialog;
	private javax.swing.JButton chartDoneButton;
	private javax.swing.JPanel chartMainPanel;
	private javax.swing.JButton chartsButton;
	private javax.swing.JButton classButton;
	private javax.swing.JButton extraAbilitiesButton;
	private javax.swing.JButton itemButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JButton nonWeaponProfsButton;
	private javax.swing.JButton nonWeaponProfsButton1;
	private javax.swing.JButton raceButton;
	private javax.swing.JPanel tableButtonPanel;
	private javax.swing.JDialog tableDialog;
	private javax.swing.JButton tableDoneButton1;
	private javax.swing.JPanel tableMainPanel;
	private javax.swing.JButton tablesButton;
	// End of variables declaration//GEN-END:variables
	public Option_AbilityScores optionAbilityScores;
	public DM_Config_Tab_Tables tablesConfig;
	public DM_Config_Tab_Charts chartsConfig;
	//TODO temp
	public int[] abilities;
}