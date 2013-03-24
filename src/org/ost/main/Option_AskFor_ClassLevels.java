/*
 * Option_AskFor_ClassLevels.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyClasses.ExtraAbilitiesClass;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_ClassLevels extends javax.swing.JDialog {
	private MainClass ost;
	private CharacterClass currentClass;
	private CharacterClass.LevelClass currentLevel;
	private java.awt.Frame parent;

	/** Creates new form Option_AskFor_ClassLevels */
	public Option_AskFor_ClassLevels(java.awt.Frame parent, boolean modal,
			MainClass ost, CharacterClass oClass) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentClass = oClass;
		initComponents();

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		matrixTable.getTableHeader().setFont(fFont);
		matrixTable.getTableHeader().setBackground(Color.yellow);

		// tweak the level max spinner to max level of class
		levelSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1,
				currentClass.getLevelMax(), 1));

		updatePanels();

		//setSize(780, 650);
		setLocationRelativeTo(parent);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		jPanel11 = new javax.swing.JPanel();
		jPanel10 = new javax.swing.JPanel();
		nameLabel = new javax.swing.JLabel();
		levelSpinner = new javax.swing.JSpinner();
		jPanel9 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		expSpinner = new javax.swing.JSpinner();
		jPanel3 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		hdNumberSpinner = new javax.swing.JSpinner();
		jLabel5 = new javax.swing.JLabel();
		hdSizeSpinner = new javax.swing.JSpinner();
		jLabel6 = new javax.swing.JLabel();
		hdBonusSpinner = new javax.swing.JSpinner();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		acBaseSpinner = new javax.swing.JSpinner();
		jLabel2 = new javax.swing.JLabel();
		acAdjustmentSpinner = new javax.swing.JSpinner();
		jPanel5 = new javax.swing.JPanel();
		thiefSkillsButton = new javax.swing.JButton();
		thiefSkillAdjustmentButton = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		spellsArcaneButton = new javax.swing.JButton();
		spellsDivineButton = new javax.swing.JButton();
		jPanel13 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		savesBaseButton = new javax.swing.JButton();
		savesBonusButton = new javax.swing.JButton();
		abilityScoreAdjustPanel = new javax.swing.JPanel();
		abilityScoreAdjustmentButton = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		weaponProfsSpinner = new javax.swing.JSpinner();
		nonWeaponProfSpinner = new javax.swing.JSpinner();
		jPanel6 = new javax.swing.JPanel();
		nonweaponBonusButton = new javax.swing.JButton();
		nonweaponBonusButton1 = new javax.swing.JButton();
		attacksPanel = new javax.swing.JPanel();
		maxAtkPerRound2Spinner = new javax.swing.JSpinner();
		jLabel12 = new javax.swing.JLabel();
		maxAtkPerRound1Spinner = new javax.swing.JSpinner();
		jLabel11 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		atkPerRound1Spinner = new javax.swing.JSpinner();
		jLabel10 = new javax.swing.JLabel();
		atkPerRound2Spinner = new javax.swing.JSpinner();
		jPanel12 = new javax.swing.JPanel();
		extraAbilitiesButton = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		matrixTable = new javax.swing.JTable();
		jLabel14 = new javax.swing.JLabel();
		thacoSpinner = new javax.swing.JSpinner();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Class");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Levels",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		jPanel11.setBackground(new java.awt.Color(153, 153, 153));
		jPanel11.setLayout(new java.awt.GridLayout(0, 1));

		jPanel10.setBackground(new java.awt.Color(153, 153, 153));
		jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Level"));
		jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("Current");
		jPanel10.add(nameLabel);

		levelSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
		levelSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				levelSpinnerStateChanged(evt);
			}
		});
		jPanel10.add(levelSpinner);

		jPanel11.add(jPanel10);

		jPanel9.setBackground(new java.awt.Color(153, 153, 153));
		jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Experience"));
		jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel1.setText("required");
		jPanel9.add(jLabel1);

		expSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999999999,
				1));
		jPanel9.add(expSpinner);

		jPanel11.add(jPanel9);

		jPanel3.setBackground(new java.awt.Color(153, 153, 153));
		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Health"));
		jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel4.setText("Hitdice");
		jPanel3.add(jLabel4);

		hdNumberSpinner
				.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
		jPanel3.add(hdNumberSpinner);

		jLabel5.setText("d");
		jPanel3.add(jLabel5);

		hdSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, 99, 1));
		jPanel3.add(hdSizeSpinner);

		jLabel6.setText("bonus");
		jPanel3.add(jLabel6);

		hdBonusSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		jPanel3.add(hdBonusSpinner);

		jPanel11.add(jPanel3);

		jPanel2.setBackground(new java.awt.Color(153, 153, 153));
		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Armor Class"));
		jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel3.setText("base");
		jPanel2.add(jLabel3);

		acBaseSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -10, 10, 1));
		acBaseSpinner.setEnabled(false);
		jPanel2.add(acBaseSpinner);

		jLabel2.setText("adjustment");
		jPanel2.add(jLabel2);

		acAdjustmentSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -10,
				10, 1));
		jPanel2.add(acAdjustmentSpinner);

		jPanel11.add(jPanel2);

		jPanel5.setBackground(new java.awt.Color(153, 153, 153));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Thief Skills"));

		thiefSkillsButton.setText("base");
		thiefSkillsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thiefSkillsButtonActionPerformed(evt);
					}
				});
		jPanel5.add(thiefSkillsButton);

		thiefSkillAdjustmentButton.setText("adjustments");
		thiefSkillAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thiefSkillAdjustmentButtonActionPerformed(evt);
					}
				});
		jPanel5.add(thiefSkillAdjustmentButton);

		jPanel11.add(jPanel5);

		jPanel4.setBackground(new java.awt.Color(153, 153, 153));
		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Spells Per Level"));

		spellsArcaneButton.setText("arcane");
		spellsArcaneButton.setToolTipText("Magic-user, Illusionist/etc.");
		spellsArcaneButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						spellsArcaneButtonActionPerformed(evt);
					}
				});
		jPanel4.add(spellsArcaneButton);

		spellsDivineButton.setText("divine");
		spellsDivineButton.setToolTipText("Cleric, druid/etc.");
		spellsDivineButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						spellsDivineButtonActionPerformed(evt);
					}
				});
		jPanel4.add(spellsDivineButton);

		jPanel11.add(jPanel4);

		jPanel13.setBackground(new java.awt.Color(153, 153, 153));
		jPanel13.setLayout(new java.awt.GridLayout(0, 1));

		jPanel7.setBackground(new java.awt.Color(153, 153, 153));
		jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Saves"));

		savesBaseButton.setText("base");
		savesBaseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesBaseButtonActionPerformed(evt);
			}
		});
		jPanel7.add(savesBaseButton);

		savesBonusButton.setText("adjustments");
		savesBonusButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesBonusButtonActionPerformed(evt);
			}
		});
		jPanel7.add(savesBonusButton);

		jPanel13.add(jPanel7);

		abilityScoreAdjustPanel
				.setBackground(new java.awt.Color(153, 153, 153));
		abilityScoreAdjustPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Ability Scores",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		abilityScoreAdjustmentButton.setText("adjustments");
		abilityScoreAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						abilityScoreAdjustmentButtonActionPerformed(evt);
					}
				});
		abilityScoreAdjustPanel.add(abilityScoreAdjustmentButton);

		jPanel13.add(abilityScoreAdjustPanel);

		jPanel1.setBackground(new java.awt.Color(153, 153, 153));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Proficiencies"));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		jLabel8.setText("non-weapon");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel8, gridBagConstraints);

		jLabel7.setText("weapon");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel7, gridBagConstraints);

		weaponProfsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				99, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(weaponProfsSpinner, gridBagConstraints);

		nonWeaponProfSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				99, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(nonWeaponProfSpinner, gridBagConstraints);

		jPanel13.add(jPanel1);

		jPanel6.setBackground(new java.awt.Color(153, 153, 153));
		jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Granted Proficiencies"));

		nonweaponBonusButton.setText("non-weapon");
		jPanel6.add(nonweaponBonusButton);

		nonweaponBonusButton1.setText("weapon");
		jPanel6.add(nonweaponBonusButton1);

		jPanel13.add(jPanel6);

		attacksPanel.setBackground(new java.awt.Color(153, 153, 153));
		attacksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Attacks Per Round"));
		attacksPanel.setLayout(new java.awt.GridBagLayout());

		maxAtkPerRound2Spinner.setModel(new javax.swing.SpinnerNumberModel(1,
				1, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		attacksPanel.add(maxAtkPerRound2Spinner, gridBagConstraints);

		jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16));
		jLabel12.setText("/");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		attacksPanel.add(jLabel12, gridBagConstraints);

		maxAtkPerRound1Spinner.setModel(new javax.swing.SpinnerNumberModel(1,
				1, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		attacksPanel.add(maxAtkPerRound1Spinner, gridBagConstraints);

		jLabel11.setText("max");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		attacksPanel.add(jLabel11, gridBagConstraints);

		jLabel9.setText("attacks");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		attacksPanel.add(jLabel9, gridBagConstraints);

		atkPerRound1Spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1,
				10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		attacksPanel.add(atkPerRound1Spinner, gridBagConstraints);

		jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16));
		jLabel10.setText("/");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		attacksPanel.add(jLabel10, gridBagConstraints);

		atkPerRound2Spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1,
				10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		attacksPanel.add(atkPerRound2Spinner, gridBagConstraints);

		jPanel13.add(attacksPanel);

		jPanel12.setBackground(new java.awt.Color(153, 153, 153));
		jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Class Features"));

		extraAbilitiesButton.setText("extra-abilities");
		extraAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						extraAbilitiesButtonActionPerformed(evt);
					}
				});
		jPanel12.add(extraAbilitiesButton);

		jPanel13.add(jPanel12);

		jPanel8.setBackground(new java.awt.Color(153, 153, 153));
		jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Attack Matrix"));

		jScrollPane2.setBackground(new java.awt.Color(153, 153, 153));

		matrixTable.setFont(new java.awt.Font("Segoe UI", 0, 12));
		matrixTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,
						null, null, null, null, null } }, new String[] {
						"AC 10", "AC 9", "AC 8", "AC 7", "AC 6", "AC 5",
						"AC 4", "AC 3", "AC 2", "AC 1", "AC 0", "AC -1",
						"AC -2", "AC -3", "AC -4", "AC -5", "AC -6", "AC -7",
						"AC -8", "AC -9", "AC -10" }) {
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

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane2.setViewportView(matrixTable);

		jLabel14.setText("THACO");
		jLabel14.setToolTipText("To-hit armor rating 0 if using the THACO mode.\n");

		thacoSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -20, 20, 1));
		thacoSpinner
				.setToolTipText("To-hit armor rating 0 if using the THACO mode.\n");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout
				.setHorizontalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel8Layout
										.createSequentialGroup()
										.addComponent(jLabel14)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												thacoSpinner,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(664, Short.MAX_VALUE))
						.addComponent(jScrollPane2,
								javax.swing.GroupLayout.DEFAULT_SIZE, 775,
								Short.MAX_VALUE));
		jPanel8Layout
				.setVerticalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel8Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												77,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel14)
														.addComponent(
																thacoSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(mainPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						mainPanelLayout
								.createSequentialGroup()
								.addComponent(jPanel11,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										410, Short.MAX_VALUE)
								.addGap(0, 0, 0)
								.addComponent(jPanel13,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										375, Short.MAX_VALUE))
				.addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
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
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jPanel11,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																432,
																Short.MAX_VALUE)
														.addComponent(jPanel13,
																0, 0,
																Short.MAX_VALUE))
										.addGap(0, 0, 0)
										.addComponent(
												jPanel8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		jScrollPane1.setViewportView(mainPanel);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		buttonPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		doneButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(doneButton);

		getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void abilityScoreAdjustmentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_AbilityScores dDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Ability Score Adjustments",
				currentLevel.getAbilityAdjustment(),false);
		dDialog.setVisible(true);
	}

	private void extraAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		ArrayList<ExtraAbilitiesClass> aList = ExtraAbilitiesClass.getAllowed(
				currentLevel.getBonusAbilities(), ost.extraAbilitiesList);

		Option_Set_ExtraAbilities dDialog = new Option_Set_ExtraAbilities(
				parent, true, ost, aList);

		dDialog.setVisible(true);

		// changes done now set the new values
		currentLevel.setBonusAbilities(ExtraAbilitiesClass
				.getAllowedAsString(aList));
	}

	private void savesBonusButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Save Adjustments", currentLevel.getSavesAdjustments(),
				null, SAVES, SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void savesBaseButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Saves", currentLevel.getSaves(), null, SAVES,
				SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void thiefSkillsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_ThiefSkills nDialog = new Option_AskFor_ThiefSkills(
				parent, true, ost, "Thief Skills",
				currentLevel.getThiefSkills());

		nDialog.setVisible(true);
	}

	private void thiefSkillAdjustmentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Option_AskFor_ThiefSkills nDialog = new Option_AskFor_ThiefSkills(
				parent, true, ost, "Thief Skill Adjustments",
				currentLevel.getThiefSkillAdjustments());

		nDialog.setVisible(true);
	}

	private void spellsDivineButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Option_AskFor_SpellSlots nDialog = new Option_AskFor_SpellSlots(parent,
				true, ost, "Divine Spells Per-Level",
				currentLevel.getSpellsPerLevelDivine(), CLERIC_SPELL_NAMES,
				CLERIC_SPELL_NAMES_ABBREV);

		nDialog.setVisible(true);
	}

	private void spellsArcaneButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Option_AskFor_SpellSlots nDialog = new Option_AskFor_SpellSlots(parent,
				true, ost, "Arcane Spells Per-Level",
				currentLevel.getSpellsPerLevelArcane(), MAGE_SPELL_NAMES,
				MAGE_SPELL_NAMES_ABBREV);

		nDialog.setVisible(true);

	}

	private void levelSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {
		// TODO add your handling code here:
		getCurrentValues();
		int nLevel = (int) levelSpinner.getValue();
		if (nLevel > currentClass.getLevelMax())
			levelSpinner.setValue(currentClass.getLevelMax());
		updatePanels();
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		// before dying off make sure to store last values
		getCurrentValues();
	}

	private void updatePanels() {
		//TODO finish/test this

		if (currentClass.getLevelDetails().isEmpty()) {
			CharacterClass.LevelClass newLevel = currentClass.new LevelClass(1);
			currentClass.getLevelDetails().add(newLevel);
			for (int ii = 0; ii < MAX_MATRIX; ii++)
				newLevel.getAttackMatrix()[ii] = 10 + ii;
		}

		// if the level we moved to does not exist copy previous level values
		// 
		int nLevel = (int) levelSpinner.getValue();
		if (nLevel > currentClass.getLevelDetails().size()) {
			for (int i = currentClass.getLevelDetails().size(); i < nLevel; i++) {
				CharacterClass.LevelClass newLevel = currentClass.new LevelClass(
						i + 1);
				currentClass.getLevelDetails().add(newLevel);
				// set some defaults for ease 
				newLevel.setThaco(currentLevel.getThaco());
				newLevel.setExpReq(currentLevel.getExpReq() + 1);
				newLevel.setHitDiceNumber(currentLevel.getHitDiceNumber());
				newLevel.setHitDiceSize(currentLevel.getHitDiceSize());
				newLevel.setHitPointBonus(currentLevel.getHitPointBonus());

				for (int ii = 0; ii < currentLevel.getSaves().size(); ii++)
					newLevel.getSaves()
							.set(ii, currentLevel.getSaves().get(ii));

				for (int ii = 0; ii < newLevel.getSpellsPerLevelArcane().length; ii++)
					newLevel.getSpellsPerLevelArcane()[ii] = currentLevel
							.getSpellsPerLevelArcane()[ii];
				
				for (int ii = 0; ii < newLevel.getSpellsPerLevelDivine().length; ii++)
					newLevel.getSpellsPerLevelDivine()[ii] = currentLevel
							.getSpellsPerLevelDivine()[ii];

				for (int ii = 0; ii < newLevel.getThiefSkills().size(); ii++)
					newLevel.getThiefSkills().set(ii,currentLevel.getThiefSkills().get(ii));

				// set the new level values to previous just to have preset.
				for (int ii = 0; ii < MAX_MATRIX; ii++)
					newLevel.getAttackMatrix()[ii] = currentLevel
							.getAttackMatrix()[ii];
			}

		} // end creating default level values for new levels

		// now that all that is done set currentLevel to the new value;
		currentLevel = currentClass.getLevelDetails().get(nLevel - 1);

		expSpinner.setValue(currentLevel.getExpReq());
		thacoSpinner.setValue(currentLevel.getThaco());
		acAdjustmentSpinner.setValue(currentLevel.getAc());
		acBaseSpinner.setValue(currentLevel.getAcBase());
		hdNumberSpinner.setValue(currentLevel.getHitDiceNumber());
		hdSizeSpinner.setValue(currentLevel.getHitDiceSize());
		hdBonusSpinner.setValue(currentLevel.getHitPointBonus());

		weaponProfsSpinner.setValue(currentLevel.getWeaponProfAdditional());
		nonWeaponProfSpinner
				.setValue(currentLevel.getNonWeaponProfAdditional());

		atkPerRound1Spinner.setValue(currentLevel.getAttacksPerRound()[0]);
		atkPerRound2Spinner.setValue(currentLevel.getAttacksPerRound()[1]);

		maxAtkPerRound1Spinner
				.setValue(currentLevel.getAttacksPerRoundMax()[0]);
		maxAtkPerRound2Spinner
				.setValue(currentLevel.getAttacksPerRoundMax()[1]);

		//TODO sort out the table/matrix
		//matrixTable

		for (int i = 0; i < currentLevel.getAttackMatrix().length; i++) {
			//			int acNumber = (10 - i);
			int atkRollNeeded = currentLevel.getAttackMatrix()[i];
			matrixTable.setValueAt(atkRollNeeded, 0, i);
		}

	}

	private void getCurrentValues() {

		currentLevel.setExpReq((int) expSpinner.getValue());
		currentLevel.setThaco((int) thacoSpinner.getValue());
		currentLevel.setAc((int) acAdjustmentSpinner.getValue());
		currentLevel.setAcBase((int) acBaseSpinner.getValue());
		currentLevel.setHitDiceNumber((int) hdNumberSpinner.getValue());
		currentLevel.setHitDiceSize((int) hdSizeSpinner.getValue());
		currentLevel.setHitPointBonus((int) hdBonusSpinner.getValue());
		currentLevel.setWeaponProfAdditional((int) weaponProfsSpinner
				.getValue());
		currentLevel.setNonWeaponProfAdditional((int) nonWeaponProfSpinner
				.getValue());

		currentLevel.getAttacksPerRound()[0] = ((int) atkPerRound1Spinner
				.getValue());
		currentLevel.getAttacksPerRound()[1] = ((int) atkPerRound2Spinner
				.getValue());

		currentLevel.getAttacksPerRoundMax()[0] = ((int) maxAtkPerRound1Spinner
				.getValue());
		currentLevel.getAttacksPerRoundMax()[1] = ((int) maxAtkPerRound2Spinner
				.getValue());

		//TODO sort out the table/matrix
		//matrixTable

		matrixTable.editingStopped(null);
		for (int i = 0; i < matrixTable.getColumnCount(); i++) {
			currentLevel.getAttackMatrix()[i] = (int) matrixTable.getValueAt(0,
					i);
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel abilityScoreAdjustPanel;
	private javax.swing.JButton abilityScoreAdjustmentButton;
	private javax.swing.JSpinner acAdjustmentSpinner;
	private javax.swing.JSpinner acBaseSpinner;
	private javax.swing.JSpinner atkPerRound1Spinner;
	private javax.swing.JSpinner atkPerRound2Spinner;
	private javax.swing.JPanel attacksPanel;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JSpinner expSpinner;
	private javax.swing.JButton extraAbilitiesButton;
	private javax.swing.JSpinner hdBonusSpinner;
	private javax.swing.JSpinner hdNumberSpinner;
	private javax.swing.JSpinner hdSizeSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel13;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSpinner levelSpinner;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JTable matrixTable;
	private javax.swing.JSpinner maxAtkPerRound1Spinner;
	private javax.swing.JSpinner maxAtkPerRound2Spinner;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JSpinner nonWeaponProfSpinner;
	private javax.swing.JButton nonweaponBonusButton;
	private javax.swing.JButton nonweaponBonusButton1;
	private javax.swing.JButton savesBaseButton;
	private javax.swing.JButton savesBonusButton;
	private javax.swing.JButton spellsArcaneButton;
	private javax.swing.JButton spellsDivineButton;
	private javax.swing.JSpinner thacoSpinner;
	private javax.swing.JButton thiefSkillAdjustmentButton;
	private javax.swing.JButton thiefSkillsButton;
	private javax.swing.JSpinner weaponProfsSpinner;
	// End of variables declaration//GEN-END:variables
}