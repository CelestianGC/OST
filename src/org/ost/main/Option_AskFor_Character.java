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

		updatePanels();
		setSize(580, 410);
		setLocationRelativeTo(parent);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		nameLabel = new javax.swing.JLabel();
		nameTextField = new javax.swing.JTextField();
		classLabel = new javax.swing.JLabel();
		classButton = new javax.swing.JButton();
		raceLabel = new javax.swing.JLabel();
		raceButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		playerTextField = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		hpSpinner = new javax.swing.JSpinner();
		jLabel3 = new javax.swing.JLabel();
		currentHPSpinner = new javax.swing.JSpinner();
		jLabel4 = new javax.swing.JLabel();
		acSpinner = new javax.swing.JSpinner();
		jLabel5 = new javax.swing.JLabel();
		acRearSpinner = new javax.swing.JSpinner();
		jLabel6 = new javax.swing.JLabel();
		acShieldlessSpinner = new javax.swing.JSpinner();
		jLabel7 = new javax.swing.JLabel();
		moveTextField = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		magicResistanceTextField = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		alignmentComboBox = new javax.swing.JComboBox();
		equipmentButton = new javax.swing.JButton();
		Labela12 = new javax.swing.JLabel();
		levelLabel = new javax.swing.JLabel();
		notesButton = new javax.swing.JButton();
		logsButton = new javax.swing.JButton();
		weaponProfsButton = new javax.swing.JButton();
		nonWeaponProfsButton = new javax.swing.JButton();
		abilitiesButton = new javax.swing.JButton();
		savesButton = new javax.swing.JButton();
		savesAdjustmentButton = new javax.swing.JButton();
		genderComboBox = new javax.swing.JComboBox();
		genderLabel = new javax.swing.JLabel();
		rollHDButton = new javax.swing.JButton();
		expAddButton = new javax.swing.JButton();
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
						1, true), "Character",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridBagLayout());

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(nameLabel, gridBagConstraints);

		nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		mainPanel.add(nameTextField, gridBagConstraints);

		classLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classLabel.setText("set class");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(classLabel, gridBagConstraints);

		classButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classButton.setText("pick class");
		classButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				classButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(classButton, gridBagConstraints);

		raceLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceLabel.setText("set race");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(raceLabel, gridBagConstraints);

		raceButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceButton.setText("pick race");
		raceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				raceButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(raceButton, gridBagConstraints);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("Player");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(jLabel1, gridBagConstraints);

		playerTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(playerTextField, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("hitpoints");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(jLabel2, gridBagConstraints);

		hpSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 999, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(hpSpinner, gridBagConstraints);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("current hp");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(jLabel3, gridBagConstraints);

		currentHPSpinner.setModel(new javax.swing.SpinnerNumberModel(1, -10,
				999, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(currentHPSpinner, gridBagConstraints);

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("AC");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel4, gridBagConstraints);

		acSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(acSpinner, gridBagConstraints);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel5.setText("AC, Rear");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel5, gridBagConstraints);

		acRearSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10, 10,
				1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(acRearSpinner, gridBagConstraints);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel6.setText("AC, Shieldless");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel6, gridBagConstraints);

		acShieldlessSpinner.setModel(new javax.swing.SpinnerNumberModel(10,
				-10, 10, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(acShieldlessSpinner, gridBagConstraints);

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel7.setText("move");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(jLabel7, gridBagConstraints);

		moveTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(moveTextField, gridBagConstraints);

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel8.setText("magic-resistance");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(jLabel8, gridBagConstraints);

		magicResistanceTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(magicResistanceTextField, gridBagConstraints);

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel9.setText("alignment");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel9, gridBagConstraints);

		alignmentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(alignmentComboBox, gridBagConstraints);

		equipmentButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		equipmentButton.setText("equipment");
		equipmentButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(equipmentButton, gridBagConstraints);

		Labela12.setFont(new java.awt.Font("Segoe UI", 0, 12));
		Labela12.setText("Level");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
		mainPanel.add(Labela12, gridBagConstraints);

		levelLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		levelLabel.setText("setLevel");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(levelLabel, gridBagConstraints);

		notesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		notesButton.setText("notes");
		notesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(notesButton, gridBagConstraints);

		logsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		logsButton.setText("logs");
		logsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logsButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(logsButton, gridBagConstraints);

		weaponProfsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		weaponProfsButton.setText("weapon profs");
		weaponProfsButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(weaponProfsButton, gridBagConstraints);

		nonWeaponProfsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nonWeaponProfsButton.setText("nonweapon profs");
		nonWeaponProfsButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(nonWeaponProfsButton, gridBagConstraints);

		abilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		abilitiesButton.setText("ability scores");
		abilitiesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				abilitiesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(abilitiesButton, gridBagConstraints);

		savesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesButton.setText("saves");
		savesButton.setEnabled(false);
		savesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(savesButton, gridBagConstraints);

		savesAdjustmentButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesAdjustmentButton.setText("save adjustments");
		savesAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						savesAdjustmentButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(savesAdjustmentButton, gridBagConstraints);

		genderComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(genderComboBox, gridBagConstraints);

		genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		genderLabel.setText("gender");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(genderLabel, gridBagConstraints);

		rollHDButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		rollHDButton.setText("re-roll HP");
		rollHDButton.setToolTipText("Re-roll Hitpoints.");
		rollHDButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rollHDButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(rollHDButton, gridBagConstraints);

		expAddButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		expAddButton.setText("experience");
		expAddButton.setToolTipText("Re-roll Hitpoints.");
		expAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				expAddButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(expAddButton, gridBagConstraints);

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

	private void expAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String addExp = SimpleDialog.showQuestion(this, "Enter value to add/remove.", "Modify Experince", "0");
		int nEXP = 0;
		try {
			nEXP = Integer.parseInt(addExp);
			int classCount = currentCharacter.getMyClass().size();
			nEXP /= classCount;
			for(PCClass pC : currentCharacter.getMyClass()) {
				int nOldLevel = pC.getLevel();
				pC.addExperience(nEXP);
				int nNewLevel = pC.getLevelActual(ost.characterClassList);
				int nDiffLevel = nNewLevel - nOldLevel; 
				if (nDiffLevel != 0) { // re-roll health?
					if (nDiffLevel > 0) {
						// TODO levelup();
						ost.dprint("Level up! "+nDiffLevel+"\n");
					}
					else {
						ost.dprint("De-Level! "+nDiffLevel+"\n");
						// TODO delevel();
					}
				}
				
			}
		} catch (Exception e) {
			SimpleDialog.showError("Value must be a number.");
		}
	}

	private void rollHDButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code he

		// get con bonuses
		// TODO
		// note: fighter/barb con bonus flag can be assigned
		// at a level other than 1, resolve that by updating conbonus
		// every level. -- for now we just check at start and assume
		// level 1 grants it for all rolls
		int nConScore = currentCharacter.getAbilityScore(ABILITY_CONSTITUTION,
				ost.characterClassList, ost.extraAbilitiesList, ost.raceList,
				ost.abilityStatList);
		AbilityStatClass aStat = ost.abilityStatList.getContent()
				.get(nConScore);
		int nConBonus = aStat.consitution.hitpointAdjustment;
		if (currentCharacter.hasBarbarianCon(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList))
			nConBonus = aStat.consitution.hitpointAdjustmentBarbarian;
		if (currentCharacter.hasFighterCon(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList))
			nConBonus = aStat.consitution.hitpointAdjustmentFighter;

		int nRollingHP = 0;
		int nRolledHP = 0;
		int nDiceCount = 1;
		int nDiceSize = 4;
		int nClassHPBonus = 0;
		int nRaceStartBonus = 0;
		boolean bRaceBonusUsed = false;
		RaceClass oR = currentCharacter.getMyRace().getRaceByID(ost.raceList);
		nRaceStartBonus = oR.getBonusStartHP();

		int classCount = currentCharacter.getMyClass().size();
		nConBonus /= classCount;
		for (int i = 0; i < currentCharacter.getMyClass().size(); i++) {
			PCClass pC = currentCharacter.getMyClass().get(i);
			CharacterClass cC = pC.getClassByID(ost.characterClassList);
			if (pC.getHdRolls() == null)
				pC.setHdRolls(new ArrayList<Integer>());
			pC.getHdRolls().clear();
			for (int ii = 0; ii < cC.getLevelDetails().size(); ii++) {
				LevelClass oL = cC.getLevelByLevel(ii);
				if (pC.getExperience() >= oL.getExpReq()) {
					nDiceCount = oL.getHitDiceNumber();
					nDiceSize = oL.getHitDiceSize();
					nClassHPBonus = oL.getHitPointBonus();
					nRollingHP = MyRandomClass.rollDice(nDiceCount, nDiceSize);
					ost.dprint(String.format("Level %d\n"
							+ "rolling %dd%d (%d)\n" + "plus classHP %d\n"
							+ "plus RaceStart %d\n" + "plus ConBonus %d\n",
							(ii + 1), nDiceCount, nDiceSize, nRollingHP,
							nClassHPBonus, nRaceStartBonus, nConBonus));
					nRollingHP += nClassHPBonus;
					nRollingHP += nConBonus; // update conBonus each level?
					if (ii == 0 && !bRaceBonusUsed) {
						nRollingHP += nRaceStartBonus;
						bRaceBonusUsed = true;
					}
					nRolledHP += nRollingHP;
					ost.dprint(String.format("nRollingHP = %d\n"
							+ "nRolledHP = %d\n", nRollingHP, nRolledHP));
					pC.getHdRolls().add(nRolledHP); // saved for de-level?
				}
			}
		}
		// multi-classed divide hp by number of classes
		nRolledHP /= classCount;
		ost.dprint(String.format("-----Final HP = %d\n", nRolledHP));
		currentCharacter.setHpCurrent(nRolledHP);
		currentCharacter.setHpMax(nRolledHP);
		hpSpinner.setValue(nRolledHP);
		currentHPSpinner.setValue(nRolledHP);
	}

	private void classButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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
		// when character levels up
		currentCharacter.setHpCurrent(0);
		currentCharacter.setHpMax(0);

		//TODO update panels
		updatePanels();
	}

	private void raceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ArrayList<String> cList = new ArrayList<String>();
		cList.add(currentCharacter.myRace.getRaceID());

		ArrayList<RaceClass> aList = RaceClass.getAllowed(cList, ost.raceList);
		Option_Set_Race dDialog = new Option_Set_Race(parent, true, ost, aList);

		dDialog.setVisible(true);

		currentCharacter.getMyRace().setRaceID(aList.get(0).getMyID());
		currentCharacter.getMyRace().setName(aList.get(0).getName());

		//TODO update panels
		updatePanels();
	}

	private void savesAdjustmentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Save Adjustments",
				currentCharacter.getMySaveAdjustments(), null, SAVES,
				SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void savesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Saves dDialog = new Option_AskFor_Saves(parent, true,
				ost, "Saves", currentCharacter.getMySaves(), null, SAVES,
				SAVES_ABBREV);
		dDialog.setVisible(true);
	}

	private void abilitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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
		// TODO add your handling code here:
		updateFromCurrentValues();
	}

	private void updateFromCurrentValues() {
		//TODO
		currentCharacter.setName(nameTextField.getText());
		currentCharacter.setNamePlayer(playerTextField.getText());
		currentCharacter.setHpMax((int) hpSpinner.getValue());
		currentCharacter.setHpCurrent((int) currentHPSpinner.getValue());
		//TODO need to configure this to cope with 3 types of ac
		currentCharacter.getArmorRatings().clear();
		currentCharacter.getArmorRatings().add(
				String.format("%d", acSpinner.getValue()));
		currentCharacter.getArmorRatings().add(
				String.format("%d", acRearSpinner.getValue()));
		currentCharacter.getArmorRatings().add(
				String.format("%d", acShieldlessSpinner.getValue()));

		currentCharacter.setMoveRate(moveTextField.getText());
		currentCharacter.setMagicResistance(magicResistanceTextField.getText());
		currentCharacter.setMyAlignmentType(alignmentComboBox
				.getSelectedIndex());
		currentCharacter.setGenderType(genderComboBox.getSelectedIndex());
		currentCharacter.setAlignment(ALIGNMENTS[currentCharacter
				.getMyAlignmentType()]);

	}

	private void updatePanels() {
		//TODO
		nameTextField.setText(currentCharacter.getName());
		playerTextField.setText(currentCharacter.getNamePlayer());
		hpSpinner.setValue(currentCharacter.getHpMax());
		currentHPSpinner.setValue(currentCharacter.getHpCurrent());
		//TODO need to configure this to cope with 3 types of ac
		acSpinner.setValue(Integer.parseInt(currentCharacter.getArmorRatings()
				.get(0)));
		moveTextField.setText(currentCharacter.getMoveRate());
		magicResistanceTextField.setText(currentCharacter.getMagicResistance());
		alignmentComboBox.setSelectedIndex(currentCharacter
				.getMyAlignmentType());
		genderComboBox.setSelectedIndex(currentCharacter.getGenderType());
		RaceClass oR = RaceClass.getRaceFromMyID(currentCharacter.getMyRace()
				.getRaceID(), ost.raceList);
		raceLabel.setText(oR != null ? oR.getName() : "");

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel Labela12;
	private javax.swing.JButton abilitiesButton;
	private javax.swing.JSpinner acRearSpinner;
	private javax.swing.JSpinner acShieldlessSpinner;
	private javax.swing.JSpinner acSpinner;
	private javax.swing.JComboBox alignmentComboBox;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton classButton;
	private javax.swing.JLabel classLabel;
	private javax.swing.JSpinner currentHPSpinner;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton equipmentButton;
	private javax.swing.JButton expAddButton;
	private javax.swing.JComboBox genderComboBox;
	private javax.swing.JLabel genderLabel;
	private javax.swing.JSpinner hpSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel levelLabel;
	private javax.swing.JButton logsButton;
	private javax.swing.JTextField magicResistanceTextField;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JTextField moveTextField;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JButton nonWeaponProfsButton;
	private javax.swing.JButton notesButton;
	private javax.swing.JTextField playerTextField;
	private javax.swing.JButton raceButton;
	private javax.swing.JLabel raceLabel;
	private javax.swing.JButton rollHDButton;
	private javax.swing.JButton savesAdjustmentButton;
	private javax.swing.JButton savesButton;
	private javax.swing.JButton weaponProfsButton;
	// End of variables declaration//GEN-END:variables
}