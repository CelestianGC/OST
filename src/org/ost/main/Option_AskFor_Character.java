/*
 * Option_AskFor_Character.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import static org.ost.main.MyClasses.MyStatics.*;
import org.ost.main.MyClasses.*;
import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyClasses.PlayerClass.PCClass;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Character extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private PlayerClass currentCharacter;
	private DefaultComboBoxModel modelBox;
	private DefaultComboBoxModel modelBoxGender;

	/** Creates new form Option_AskFor_CharacterClass */
	public Option_AskFor_Character(java.awt.Frame parent, boolean modal,
			MainClass ost, PlayerClass oCharacter) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentCharacter = oCharacter;
		initComponents();

		modelBox = new DefaultComboBoxModel<>(ALIGNMENTS);
		alignmentComboBox.setModel(modelBox);

		modelBoxGender = new DefaultComboBoxModel<>(GENDERS);
		genderComboBox.setModel(modelBoxGender);

		setLocationRelativeTo(parent);

		updatePanels();
		//setSize(580, 410);
		pack();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		detailsPanel = new javax.swing.JPanel();
		genderLabel = new javax.swing.JLabel();
		Labela12 = new javax.swing.JLabel();
		nameLabel = new javax.swing.JLabel();
		nameTextField = new javax.swing.JTextField();
		levelLabel = new javax.swing.JLabel();
		genderComboBox = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		raceLabel = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		classLabel = new javax.swing.JLabel();
		playerTextField = new javax.swing.JTextField();
		alignmentComboBox = new javax.swing.JComboBox();
		raceLabel1 = new javax.swing.JLabel();
		classLabel1 = new javax.swing.JLabel();
		hitpointsPanel = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		hpSpinner = new javax.swing.JSpinner();
		jLabel3 = new javax.swing.JLabel();
		currentHPSpinner = new javax.swing.JSpinner();
		jLabel7 = new javax.swing.JLabel();
		moveTextField = new javax.swing.JTextField();
		acDetailsPanel = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		acSpinner = new javax.swing.JSpinner();
		jLabel5 = new javax.swing.JLabel();
		acRearSpinner = new javax.swing.JSpinner();
		jLabel6 = new javax.swing.JLabel();
		acShieldlessSpinner = new javax.swing.JSpinner();
		buttonsPanel = new javax.swing.JPanel();
		savesAdjustmentButton = new javax.swing.JButton();
		abilitiesButton = new javax.swing.JButton();
		equipmentButton = new javax.swing.JButton();
		expAddButton = new javax.swing.JButton();
		savesButton = new javax.swing.JButton();
		weaponProfsButton = new javax.swing.JButton();
		nonWeaponProfsButton = new javax.swing.JButton();
		raceButton = new javax.swing.JButton();
		classButton = new javax.swing.JButton();
		rollHDButton = new javax.swing.JButton();
		notesButton = new javax.swing.JButton();
		logsButton = new javax.swing.JButton();
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
						1, true), "Character"));

		detailsPanel.setBackground(new java.awt.Color(153, 153, 153));
		detailsPanel.setLayout(new java.awt.GridBagLayout());

		genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		genderLabel.setText("Gender");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		detailsPanel.add(genderLabel, gridBagConstraints);

		Labela12.setFont(new java.awt.Font("Segoe UI", 0, 12));
		Labela12.setText("Level");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		detailsPanel.add(Labela12, gridBagConstraints);

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		detailsPanel.add(nameLabel, gridBagConstraints);

		nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameTextField.setPreferredSize(new java.awt.Dimension(100, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		detailsPanel.add(nameTextField, gridBagConstraints);

		levelLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		levelLabel.setText("set class/exp");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		detailsPanel.add(levelLabel, gridBagConstraints);

		genderComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		detailsPanel.add(genderComboBox, gridBagConstraints);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("Player");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		detailsPanel.add(jLabel1, gridBagConstraints);

		raceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		raceLabel.setText("set race");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		detailsPanel.add(raceLabel, gridBagConstraints);

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel9.setText("Alignment");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		detailsPanel.add(jLabel9, gridBagConstraints);

		classLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		classLabel.setText("set class");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		detailsPanel.add(classLabel, gridBagConstraints);

		playerTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		playerTextField.setPreferredSize(new java.awt.Dimension(150, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		detailsPanel.add(playerTextField, gridBagConstraints);

		alignmentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
		detailsPanel.add(alignmentComboBox, gridBagConstraints);

		raceLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceLabel1.setText("Race");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
		detailsPanel.add(raceLabel1, gridBagConstraints);

		classLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classLabel1.setText("Class");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
		detailsPanel.add(classLabel1, gridBagConstraints);

		hitpointsPanel.setBackground(new java.awt.Color(153, 153, 153));
		hitpointsPanel.setLayout(new java.awt.GridBagLayout());

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("Hitpoints");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(jLabel2, gridBagConstraints);

		hpSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 999, 1));
		hpSpinner.setPreferredSize(new java.awt.Dimension(45, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(hpSpinner, gridBagConstraints);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("Current hp");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(jLabel3, gridBagConstraints);

		currentHPSpinner.setModel(new javax.swing.SpinnerNumberModel(1, -10,
				999, 1));
		currentHPSpinner.setPreferredSize(new java.awt.Dimension(45, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(currentHPSpinner, gridBagConstraints);

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel7.setText("Move");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(jLabel7, gridBagConstraints);

		moveTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		moveTextField.setPreferredSize(new java.awt.Dimension(40, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		hitpointsPanel.add(moveTextField, gridBagConstraints);

		acDetailsPanel.setBackground(new java.awt.Color(153, 153, 153));
		acDetailsPanel.setLayout(new java.awt.GridBagLayout());

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("AC");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
		acDetailsPanel.add(jLabel4, gridBagConstraints);

		acSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		acDetailsPanel.add(acSpinner, gridBagConstraints);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel5.setText("AC, Rear");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
		acDetailsPanel.add(jLabel5, gridBagConstraints);

		acRearSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10, 10,
				1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		acDetailsPanel.add(acRearSpinner, gridBagConstraints);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel6.setText("AC, Shieldless");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
		acDetailsPanel.add(jLabel6, gridBagConstraints);

		acShieldlessSpinner.setModel(new javax.swing.SpinnerNumberModel(10,
				-10, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.5;
		acDetailsPanel.add(acShieldlessSpinner, gridBagConstraints);

		buttonsPanel.setBackground(new java.awt.Color(153, 153, 153));
		buttonsPanel.setLayout(new java.awt.GridBagLayout());

		savesAdjustmentButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesAdjustmentButton.setText("save adjustments");
		savesAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						savesAdjustmentButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(savesAdjustmentButton, gridBagConstraints);

		abilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		abilitiesButton.setText("ability scores");
		abilitiesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				abilitiesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(abilitiesButton, gridBagConstraints);

		equipmentButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		equipmentButton.setText("equipment");
		equipmentButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				equipmentButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(equipmentButton, gridBagConstraints);

		expAddButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		expAddButton.setText("experience");
		expAddButton.setToolTipText("Re-roll Hitpoints.");
		expAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				expAddButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(expAddButton, gridBagConstraints);

		savesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesButton.setText("saves");
		savesButton.setEnabled(false);
		savesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(savesButton, gridBagConstraints);

		weaponProfsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		weaponProfsButton.setText("weapon profs");
		weaponProfsButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(weaponProfsButton, gridBagConstraints);

		nonWeaponProfsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nonWeaponProfsButton.setText("nonweapon profs");
		nonWeaponProfsButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(nonWeaponProfsButton, gridBagConstraints);

		raceButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceButton.setText("set race");
		raceButton.setPreferredSize(new java.awt.Dimension(123, 25));
		raceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				raceButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(raceButton, gridBagConstraints);

		classButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classButton.setText("set class");
		classButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				classButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(classButton, gridBagConstraints);

		rollHDButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		rollHDButton.setText("re-roll HP");
		rollHDButton.setToolTipText("Re-roll Hitpoints.");
		rollHDButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rollHDButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(rollHDButton, gridBagConstraints);

		notesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		notesButton.setText("notes");
		notesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(notesButton, gridBagConstraints);

		logsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		logsButton.setText("logs");
		logsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logsButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		buttonsPanel.add(logsButton, gridBagConstraints);

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
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				hitpointsPanel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				14,
																				Short.MAX_VALUE)
																		.addComponent(
																				acDetailsPanel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				148,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				0)
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								detailsPanel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								372,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								buttonsPanel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap()));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addComponent(
												detailsPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												114, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																hitpointsPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																acDetailsPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												buttonsPanel,
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

	private void equipmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Gear dDialog = new Option_AskFor_Gear(parent, true, ost,
				currentCharacter);
		dDialog.setVisible(true);
	}

	private void expAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String addExp = SimpleDialog.showQuestion(this,
				"Enter value to add/remove.", "Modify Experince", "0");
		int nEXP = 0;
		try {
			nEXP = Integer.parseInt(addExp);
		} catch (Exception e) {
			SimpleDialog.showError("Value must be a number.");
		}

		currentCharacter.setTotalExperience(currentCharacter
				.getTotalExperience() + nEXP);

		updateLevelDifferential(nEXP, true);
		// set these on the dialog or we lose them if they changed
		hpSpinner.setValue(currentCharacter.getHpMax());
		currentHPSpinner.setValue(currentCharacter.getHpCurrent());
		levelLabel.setText(currentCharacter.getMyLevelName(ost));
	}

	private void rollHDButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (currentCharacter.getMyClass().size() > 0) {
			for (PCClass pC : currentCharacter.getMyClass())
				pC.setLevel(0);// set level to 0 so it re-levels character up
			currentCharacter.setHpCurrent(0);
			currentCharacter.setHpMax(0);
			updateLevelDifferential(-1, false);

			// set these on the dialog or we lose them if they changed
			hpSpinner.setValue(currentCharacter.getHpMax());
			currentHPSpinner.setValue(currentCharacter.getHpCurrent());
			levelLabel.setText(currentCharacter.getMyLevelName(ost));
		}
	}

	/**
	 * update levels by either passing +EXP value and addEXP or -1 and false
	 * to use current EXP values and re-roll
	 * 
	 * @param nEXP
	 * @param addEXP
	 */
	private void updateLevelDifferential(int nEXP, boolean addEXP) {
		if (nEXP != 0 || !addEXP) { // either we have exp to adjust or we want to force re-roll
			int classCount = currentCharacter.getMyClass().size();
			nEXP /= classCount;
			for (PCClass pC : currentCharacter.getMyClass()) {
				int nOldLevel = pC.getLevel();
				if (addEXP)
					pC.addExperience(nEXP);
				int nNewLevel = pC.getLevelActual(ost);
				int nDiffLevel = nNewLevel - nOldLevel;
				if (nDiffLevel != 0) { // re-roll health?
					if (nDiffLevel > 0) {
						ost.dprint(pC.getName() + " is leveling up! "
								+ nDiffLevel + "\n");

						pC.levelUP(ost);
					} else {
						ost.dprint(pC.getName() + " De-Leveled! " + nDiffLevel
								+ "\n");
						pC.deLevel(ost);
					}

				}
			}
			//			currentHPSpinner.setValue(currentCharacter.getHpCurrent());
			//			hpSpinner.setValue(currentCharacter.getHpMax());
		}

	}

	private void classButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<String> cList = new ArrayList<String>();
		for (PlayerClass.PCClass pc : currentCharacter.getMyClass())
			cList.add(pc.getClassID());

		ArrayList<CharacterClass> aList = CharacterClass.getAllowed(cList,
				ost.characterClassList);
		Option_Set_CharacterClass dDialog = new Option_Set_CharacterClass(
				parent, true, ost, aList);

		dDialog.setVisible(true);

		currentCharacter.getMyClass().clear();
		cList = CharacterClass.getAllowedAsString(aList);
		for (CharacterClass o : aList) {
			PlayerClass.PCClass e = currentCharacter.new PCClass(o.getName(),
					o.getMyID(), 0, false, null);
			currentCharacter.getMyClass().add(e);
		}

		// we reset classes so reset hp and they are rerolled
		if (currentCharacter.getMyClass().size() > 0) {
			for (PCClass pC : currentCharacter.getMyClass())
				pC.setLevel(0);// set level to 0 so it re-levels character up
			currentCharacter.setHpCurrent(0);
			currentCharacter.setHpMax(0);

			updateLevelDifferential(currentCharacter.getTotalExperience(), true);
			// set these on the dialog or we lose them if they changed
			hpSpinner.setValue(currentCharacter.getHpMax());
			currentHPSpinner.setValue(currentCharacter.getHpCurrent());
			levelLabel.setText(currentCharacter.getMyLevelName(ost));
		}
		updateFromCurrentValues();
		updatePanels();
	}

	private void raceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		updateFromCurrentValues();

		ArrayList<String> cList = new ArrayList<String>();
		cList.add(currentCharacter.myRace.getRaceID());

		ArrayList<RaceClass> aList = RaceClass.getAllowed(cList, ost.raceList);
		Option_Set_Race dDialog = new Option_Set_Race(currentCharacter, parent,
				true, ost, aList);

		dDialog.setVisible(true);

		currentCharacter.getMyRace().setRaceID(aList.get(0).getMyID());
		currentCharacter.getMyRace().setName(aList.get(0).getName());

		updatePanels();
	}

	private void savesAdjustmentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Save Adjustments",
				currentCharacter.getMySaveAdjustments(), null, SAVES,
				SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void savesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Saves", currentCharacter.getMySaves(), null, SAVES,
				SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void abilitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_AbilityScores dDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Ability Scores",
				currentCharacter.getMyAbilityScores(), false);
		dDialog.setVisible(true);
	}

	private void logsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				parent, true, ost, "Logs", currentCharacter.getLog());
		dDialog.setVisible(true);

		currentCharacter.setLog(dDialog.currentDescription);

	}

	private void notesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				parent, true, ost, "Notes", currentCharacter.getNotes());
		dDialog.setVisible(true);

		currentCharacter.setNotes(dDialog.currentDescription);
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		updateFromCurrentValues();
	}

	private void updateFromCurrentValues() {
		currentCharacter.setName(nameTextField.getText());
		currentCharacter.setNamePlayer(playerTextField.getText());
		currentCharacter.setHpMax((int) hpSpinner.getValue());
		currentCharacter.setHpCurrent((int) currentHPSpinner.getValue());

		currentCharacter.getArmorRatings().clear();
		currentCharacter.getArmorRatings().add(
				String.format("%d", acSpinner.getValue()));
		currentCharacter.getArmorRatings().add(
				String.format("%d", acRearSpinner.getValue()));
		currentCharacter.getArmorRatings().add(
				String.format("%d", acShieldlessSpinner.getValue()));

		currentCharacter.setMoveRate(moveTextField.getText());
		//		currentCharacter.setMagicResistance(magicResistanceTextField.getText());
		currentCharacter.setMyAlignmentType(alignmentComboBox
				.getSelectedIndex());
		currentCharacter.setGenderType(genderComboBox.getSelectedIndex());
		currentCharacter.setAlignment(ALIGNMENTS[currentCharacter
				.getMyAlignmentType()]);

	}

	private void updatePanels() {
		nameTextField.setText(currentCharacter.getName());
		playerTextField.setText(currentCharacter.getNamePlayer());
		hpSpinner.setValue(currentCharacter.getHpMax());
		currentHPSpinner.setValue(currentCharacter.getHpCurrent());
		//TODO need to configure this to cope with 3 types of ac
		acSpinner.setValue(Integer.parseInt(currentCharacter.getArmorRatings()
				.get(0)));
		moveTextField.setText(currentCharacter.getMoveRate());
		//		magicResistanceTextField.setText(currentCharacter.getMagicResistance());
		alignmentComboBox.setSelectedIndex(currentCharacter
				.getMyAlignmentType());
		genderComboBox.setSelectedIndex(currentCharacter.getGenderType());
		RaceClass oR = RaceClass.getRaceFromMyID(currentCharacter.getMyRace()
				.getRaceID(), ost.raceList);
		raceLabel.setText(oR != null ? oR.getName() : "");

		levelLabel.setText(currentCharacter.getMyLevelName(ost));

		classLabel.setText(currentCharacter.getMyClassName(ost));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel Labela12;
	private javax.swing.JButton abilitiesButton;
	private javax.swing.JPanel acDetailsPanel;
	private javax.swing.JSpinner acRearSpinner;
	private javax.swing.JSpinner acShieldlessSpinner;
	private javax.swing.JSpinner acSpinner;
	private javax.swing.JComboBox alignmentComboBox;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton classButton;
	private javax.swing.JLabel classLabel;
	private javax.swing.JLabel classLabel1;
	private javax.swing.JSpinner currentHPSpinner;
	private javax.swing.JPanel detailsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton equipmentButton;
	private javax.swing.JButton expAddButton;
	private javax.swing.JComboBox genderComboBox;
	private javax.swing.JLabel genderLabel;
	private javax.swing.JPanel hitpointsPanel;
	private javax.swing.JSpinner hpSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel levelLabel;
	private javax.swing.JButton logsButton;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JTextField moveTextField;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JButton nonWeaponProfsButton;
	private javax.swing.JButton notesButton;
	private javax.swing.JTextField playerTextField;
	private javax.swing.JButton raceButton;
	private javax.swing.JLabel raceLabel;
	private javax.swing.JLabel raceLabel1;
	private javax.swing.JButton rollHDButton;
	private javax.swing.JButton savesAdjustmentButton;
	private javax.swing.JButton savesButton;
	private javax.swing.JButton weaponProfsButton;
	// End of variables declaration//GEN-END:variables
}