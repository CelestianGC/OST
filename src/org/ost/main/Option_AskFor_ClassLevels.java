/*
 * Option_AskFor_ClassLevels.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.CharacterClass.LevelClass;
import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_ClassLevels extends javax.swing.JDialog {
	private MainClass ost;
	private CharacterClass currentClass;
	private CharacterClass.LevelClass currentLevel;
	private java.awt.Frame parent;
	private VerifyIntegerPositive verifier;
	private int previousLevel;

	/** Creates new form Option_AskFor_ClassLevels */
	public Option_AskFor_ClassLevels(java.awt.Frame parent, boolean modal,
			MainClass ost, CharacterClass oClass) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentClass = oClass;
		this.verifier = new VerifyIntegerPositive();
		initComponents();

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		//		matrixTable.getTableHeader().setFont(fFont);
		//		matrixTable.getTableHeader().setBackground(Color.yellow);
		attackMatrixTable.getTableHeader().setFont(fFont);
		attackMatrixTable.getTableHeader().setBackground(Color.yellow);

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
		levelPanel = new javax.swing.JPanel();
		nameLabel = new javax.swing.JLabel();
		levelSpinner = new javax.swing.JSpinner();
		healthPanel = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		hdNumberField = new javax.swing.JFormattedTextField();
		jLabel5 = new javax.swing.JLabel();
		hdSizeField = new javax.swing.JFormattedTextField();
		jLabel6 = new javax.swing.JLabel();
		hdBonusField = new javax.swing.JFormattedTextField();
		skillsPanel = new javax.swing.JPanel();
		thiefSkillsButton = new javax.swing.JButton();
		thiefSkillAdjustmentButton = new javax.swing.JButton();
		spellsPerLevelPanel = new javax.swing.JPanel();
		spellsArcaneButton = new javax.swing.JButton();
		spellsDivineButton = new javax.swing.JButton();
		savesPanel = new javax.swing.JPanel();
		savesBaseButton = new javax.swing.JButton();
		savesBonusButton = new javax.swing.JButton();
		featuresPanel = new javax.swing.JPanel();
		extraAbilitiesButton = new javax.swing.JButton();
		armorClassPanel = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		acBaseField = new javax.swing.JFormattedTextField();
		jLabel2 = new javax.swing.JLabel();
		acAdjustmentField = new javax.swing.JFormattedTextField();
		levelPanel1 = new javax.swing.JPanel();
		jLabel13 = new javax.swing.JLabel();
		expReqField = new javax.swing.JFormattedTextField();
		abilityScoreAdjustPanel = new javax.swing.JPanel();
		abilityScoreAdjustmentButton = new javax.swing.JButton();
		profsPanel = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		weaponProfsSpinner = new javax.swing.JSpinner();
		nonWeaponProfSpinner = new javax.swing.JSpinner();
		grantedProfsPanel = new javax.swing.JPanel();
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
		matrixPanel = new javax.swing.JPanel();
		thacoTextLabel = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		attackMatrixTable = new javax.swing.JTable();
		thacoField = new javax.swing.JFormattedTextField();
		autoMatrixLabel = new javax.swing.JLabel();
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
		mainPanel.setLayout(new java.awt.GridBagLayout());

		jPanel11.setBackground(new java.awt.Color(153, 153, 153));
		jPanel11.setLayout(new java.awt.GridBagLayout());

		levelPanel.setBackground(new java.awt.Color(153, 153, 153));
		levelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Level",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		levelPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("Current");
		levelPanel.add(nameLabel);

		levelSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
		levelSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				levelSpinnerStateChanged(evt);
			}
		});
		levelPanel.add(levelSpinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(levelPanel, gridBagConstraints);

		healthPanel.setBackground(new java.awt.Color(153, 153, 153));
		healthPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Health",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		healthPanel
				.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("Hitdice");
		healthPanel.add(jLabel4);

		hdNumberField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								java.text.NumberFormat.getIntegerInstance())));
		hdNumberField.setInputVerifier(verifier);
		hdNumberField.setPreferredSize(new java.awt.Dimension(25, 22));
		healthPanel.add(hdNumberField);

		jLabel5.setText("d");
		healthPanel.add(jLabel5);

		hdSizeField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								java.text.NumberFormat.getIntegerInstance())));
		hdSizeField.setInputVerifier(verifier);
		hdSizeField.setPreferredSize(new java.awt.Dimension(25, 22));
		healthPanel.add(hdSizeField);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel6.setText("additional");
		healthPanel.add(jLabel6);

		hdBonusField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								java.text.NumberFormat.getIntegerInstance())));
		hdBonusField.setInputVerifier(verifier);
		hdBonusField.setPreferredSize(new java.awt.Dimension(25, 22));
		healthPanel.add(hdBonusField);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(healthPanel, gridBagConstraints);

		skillsPanel.setBackground(new java.awt.Color(153, 153, 153));
		skillsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Thief Skills",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		thiefSkillsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		thiefSkillsButton.setText("base");
		thiefSkillsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thiefSkillsButtonActionPerformed(evt);
					}
				});
		skillsPanel.add(thiefSkillsButton);

		thiefSkillAdjustmentButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		thiefSkillAdjustmentButton.setText("adjustments");
		thiefSkillAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thiefSkillAdjustmentButtonActionPerformed(evt);
					}
				});
		skillsPanel.add(thiefSkillAdjustmentButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(skillsPanel, gridBagConstraints);

		spellsPerLevelPanel.setBackground(new java.awt.Color(153, 153, 153));
		spellsPerLevelPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Spells Per Level",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		spellsArcaneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		spellsArcaneButton.setText("arcane");
		spellsArcaneButton.setToolTipText("Magic-user, Illusionist/etc.");
		spellsArcaneButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						spellsArcaneButtonActionPerformed(evt);
					}
				});
		spellsPerLevelPanel.add(spellsArcaneButton);

		spellsDivineButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		spellsDivineButton.setText("divine");
		spellsDivineButton.setToolTipText("Cleric, druid/etc.");
		spellsDivineButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						spellsDivineButtonActionPerformed(evt);
					}
				});
		spellsPerLevelPanel.add(spellsDivineButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(spellsPerLevelPanel, gridBagConstraints);

		savesPanel.setBackground(new java.awt.Color(153, 153, 153));
		savesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Saves",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		savesBaseButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesBaseButton.setText("base");
		savesBaseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesBaseButtonActionPerformed(evt);
			}
		});
		savesPanel.add(savesBaseButton);

		savesBonusButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		savesBonusButton.setText("adjustments");
		savesBonusButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				savesBonusButtonActionPerformed(evt);
			}
		});
		savesPanel.add(savesBonusButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(savesPanel, gridBagConstraints);

		featuresPanel.setBackground(new java.awt.Color(153, 153, 153));
		featuresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Class Features",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		extraAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		extraAbilitiesButton.setText("extra-abilities");
		extraAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						extraAbilitiesButtonActionPerformed(evt);
					}
				});
		featuresPanel.add(extraAbilitiesButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(featuresPanel, gridBagConstraints);

		armorClassPanel.setBackground(new java.awt.Color(153, 153, 153));
		armorClassPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Armor Class",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		armorClassPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("base");
		armorClassPanel.add(jLabel3);

		acBaseField.setPreferredSize(new java.awt.Dimension(25, 22));
		armorClassPanel.add(acBaseField);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("adjustment");
		armorClassPanel.add(jLabel2);

		acAdjustmentField.setPreferredSize(new java.awt.Dimension(25, 22));
		armorClassPanel.add(acAdjustmentField);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(armorClassPanel, gridBagConstraints);

		levelPanel1.setBackground(new java.awt.Color(153, 153, 153));
		levelPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Experience",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		levelPanel1
				.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel13.setText("EXP Requirement");
		jLabel13.setToolTipText("Experience required for this level.");
		levelPanel1.add(jLabel13);

		expReqField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								java.text.NumberFormat.getIntegerInstance())));
		expReqField.setInputVerifier(verifier);
		expReqField.setPreferredSize(new java.awt.Dimension(120, 22));
		levelPanel1.add(expReqField);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel11.add(levelPanel1, gridBagConstraints);

		abilityScoreAdjustPanel
				.setBackground(new java.awt.Color(153, 153, 153));
		abilityScoreAdjustPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Ability Scores",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		abilityScoreAdjustmentButton.setFont(new java.awt.Font("Segoe UI", 0,
				12));
		abilityScoreAdjustmentButton.setText("adjustments");
		abilityScoreAdjustmentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						abilityScoreAdjustmentButtonActionPerformed(evt);
					}
				});
		abilityScoreAdjustPanel.add(abilityScoreAdjustmentButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		jPanel11.add(abilityScoreAdjustPanel, gridBagConstraints);

		profsPanel.setBackground(new java.awt.Color(153, 153, 153));
		profsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Proficiencies",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		profsPanel.setLayout(new java.awt.GridBagLayout());

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel8.setText("non-weapon");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		profsPanel.add(jLabel8, gridBagConstraints);

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel7.setText("weapon");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		profsPanel.add(jLabel7, gridBagConstraints);

		weaponProfsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				99, 1));
		weaponProfsSpinner.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		profsPanel.add(weaponProfsSpinner, gridBagConstraints);

		nonWeaponProfSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				99, 1));
		nonWeaponProfSpinner.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		profsPanel.add(nonWeaponProfSpinner, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel11.add(profsPanel, gridBagConstraints);

		grantedProfsPanel.setBackground(new java.awt.Color(153, 153, 153));
		grantedProfsPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Granted Proficiencies",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		nonweaponBonusButton.setText("non-weapon");
		nonweaponBonusButton.setEnabled(false);
		grantedProfsPanel.add(nonweaponBonusButton);

		nonweaponBonusButton1.setText("weapon");
		nonweaponBonusButton1.setEnabled(false);
		grantedProfsPanel.add(nonweaponBonusButton1);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		jPanel11.add(grantedProfsPanel, gridBagConstraints);

		attacksPanel.setBackground(new java.awt.Color(153, 153, 153));
		attacksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Attacks Per Round",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		attacksPanel.setLayout(new java.awt.GridBagLayout());

		maxAtkPerRound2Spinner.setModel(new javax.swing.SpinnerNumberModel(1,
				1, 10, 1));
		maxAtkPerRound2Spinner.setEnabled(false);
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
		maxAtkPerRound1Spinner.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		attacksPanel.add(maxAtkPerRound1Spinner, gridBagConstraints);

		jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel11.setText("max");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		attacksPanel.add(jLabel11, gridBagConstraints);

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel9.setText("attacks");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		attacksPanel.add(jLabel9, gridBagConstraints);

		atkPerRound1Spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1,
				10, 1));
		atkPerRound1Spinner.setEnabled(false);
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
		atkPerRound2Spinner.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		attacksPanel.add(atkPerRound2Spinner, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel11.add(attacksPanel, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		mainPanel.add(jPanel11, gridBagConstraints);

		matrixPanel.setBackground(new java.awt.Color(153, 153, 153));
		matrixPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Attack Matrix",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		thacoTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		thacoTextLabel.setText("THACO");
		thacoTextLabel
				.setToolTipText("To-hit armor rating 0 if using the THACO mode.\n");

		attackMatrixTable.setFont(new java.awt.Font("Segoe UI", 0, 12));
		attackMatrixTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null },
						{ null, null } }, new String[] { "AC", "Roll" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(attackMatrixTable);

		thacoField.setText("20");

		autoMatrixLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		autoMatrixLabel.setText("auto");
		autoMatrixLabel
				.setToolTipText("Generate table based on THACO value for auto fill.");
		autoMatrixLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				autoMatrixLabelMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				autoMatrixLabelMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				autoMatrixLabelMouseExited(evt);
			}
		});

		javax.swing.GroupLayout matrixPanelLayout = new javax.swing.GroupLayout(
				matrixPanel);
		matrixPanel.setLayout(matrixPanelLayout);
		matrixPanelLayout
				.setHorizontalGroup(matrixPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								matrixPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												matrixPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																matrixPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				thacoTextLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				thacoField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				6,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(6,
																				6,
																				6)
																		.addComponent(
																				autoMatrixLabel))
														.addGroup(
																matrixPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addContainerGap()))));

		matrixPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { thacoField, thacoTextLabel });

		matrixPanelLayout
				.setVerticalGroup(matrixPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								matrixPanelLayout
										.createSequentialGroup()
										.addGroup(
												matrixPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																thacoField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																autoMatrixLabel)
														.addComponent(
																thacoTextLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												392, Short.MAX_VALUE)));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		mainPanel.add(matrixPanel, gridBagConstraints);

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

	private void autoMatrixLabelMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		if (evt.getButton() == MouseEvent.BUTTON1) {
			int nThaco = MyParse.formattedIntegerParse(thacoField.getText());
			int nStart = nThaco - 10;
			for (int i = 0;i<MAX_MATRIX;i++) 
				attackMatrixTable.setValueAt(nStart+i, i, 1);
		}
	}

	private void autoMatrixLabelMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		autoMatrixLabel.setForeground(Color.black);
	}

	private void autoMatrixLabelMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		autoMatrixLabel.setForeground(Color.green);
	}

	private void abilityScoreAdjustmentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_AbilityScores dDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Ability Score Adjustments",
				currentLevel.getAbilityAdjustment(), false);
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
				//				CharacterClass.LevelClass newLevel = currentClass.new LevelClass(
				//						i + 1);
				CharacterClass.LevelClass newLevel = null;
				CharacterClass.LevelClass currentLevel = currentClass
						.getLevelDetails().get((i - 1));
				if (currentLevel != null) {
					newLevel = currentLevel.cloneMe();
					newLevel.setLevel(i + 1);
				} else
					newLevel = currentClass.new LevelClass(i + 1);

				currentClass.getLevelDetails().add(newLevel);

				int lastEXP = 0;
				int secondEXP = 0;
				int newEXP = -1;
				try {
					lastEXP = currentClass.getLevelDetails().get((i - 1))
							.getExpReq();
					secondEXP = currentClass.getLevelDetails().get((i - 2))
							.getExpReq();
				} catch (Exception e) {
					// do not really care if we failed
				}
				if (secondEXP != 0) // figure out diff and use that
					newEXP = (lastEXP - secondEXP) + lastEXP;
				else
					newEXP = lastEXP + 1;

				newLevel.setExpReq(newEXP);

				// cloning previous level should negate the need for this
				//				// set some defaults for ease 
				//				newLevel.setThaco(currentLevel.getThaco());
				//				newLevel.setExpReq(currentLevel.getExpReq() + 1);
				//				newLevel.setHitDiceNumber(currentLevel.getHitDiceNumber());
				//				newLevel.setHitDiceSize(currentLevel.getHitDiceSize());
				//				newLevel.setHitPointBonus(currentLevel.getHitPointBonus());
				//
				//				for (int ii = 0; ii < currentLevel.getSaves().size(); ii++)
				//					newLevel.getSaves()
				//							.set(ii, currentLevel.getSaves().get(ii));
				//
				//				for (int ii = 0; ii < newLevel.getSpellsPerLevelArcane().length; ii++)
				//					newLevel.getSpellsPerLevelArcane()[ii] = currentLevel
				//							.getSpellsPerLevelArcane()[ii];
				//
				//				for (int ii = 0; ii < newLevel.getSpellsPerLevelDivine().length; ii++)
				//					newLevel.getSpellsPerLevelDivine()[ii] = currentLevel
				//							.getSpellsPerLevelDivine()[ii];
				//
				//				for (int ii = 0; ii < newLevel.getThiefSkills().size(); ii++)
				//					newLevel.getThiefSkills().set(ii,
				//							currentLevel.getThiefSkills().get(ii));
				//
				//				// set the new level values to previous just to have preset.
				//				if (matrixTable.isEditing())
				//					matrixTable.getCellEditor().stopCellEditing();
				//				for (int ii = 0; ii < MAX_MATRIX; ii++)
				//					newLevel.getAttackMatrix()[ii] = currentLevel
				//							.getAttackMatrix()[ii];
			}
		} // end creating default level values for new levels

		// now that all that is done set currentLevel to the new value;
		currentLevel = currentClass.getLevelDetails().get(nLevel - 1);

		expReqField.setValue(currentLevel.getExpReq());

		thacoField.setValue(currentLevel.getThaco());
		acAdjustmentField.setValue(currentLevel.getAc());
		acBaseField.setValue(currentLevel.getAcBase());
		hdNumberField.setValue(currentLevel.getHitDiceNumber());
		hdSizeField.setValue(currentLevel.getHitDiceSize());
		hdBonusField.setValue(currentLevel.getHitPointBonus());

		weaponProfsSpinner.setValue(currentLevel.getWeaponProfAdditional());
		nonWeaponProfSpinner
				.setValue(currentLevel.getNonWeaponProfAdditional());

		atkPerRound1Spinner.setValue(currentLevel.getAttacksPerRound()[0]);
		atkPerRound2Spinner.setValue(currentLevel.getAttacksPerRound()[1]);

		maxAtkPerRound1Spinner
				.setValue(currentLevel.getAttacksPerRoundMax()[0]);
		maxAtkPerRound2Spinner
				.setValue(currentLevel.getAttacksPerRoundMax()[1]);

		for (int i = 0; i < currentLevel.getAttackMatrix().length; i++) {
			int acNumber = (10 - i);
			int atkRollNeeded = currentLevel.getAttackMatrix()[i];
			//			matrixTable.setValueAt(atkRollNeeded, 0, i);
			attackMatrixTable.setValueAt(String.format("AC%d", acNumber), i, 0);
			attackMatrixTable.setValueAt(atkRollNeeded, i, 1);
		}

		previousLevel = nLevel;
	}

	private void getCurrentValues() {

		try {
			currentLevel.setLevel(previousLevel);

			currentLevel.setExpReq(MyParse.formattedIntegerParse(expReqField
					.getText()));

			currentLevel.setThaco(MyParse.formattedIntegerParse(thacoField
					.getText()));
			currentLevel.setAc(MyParse.formattedIntegerParse(acAdjustmentField
					.getText()));
			currentLevel.setAcBase(MyParse.formattedIntegerParse(acBaseField
					.getText()));
			currentLevel.setHitDiceNumber(MyParse
					.formattedIntegerParse(hdNumberField.getText()));
			currentLevel.setHitDiceSize(MyParse
					.formattedIntegerParse(hdSizeField.getText()));
			currentLevel.setHitPointBonus(MyParse
					.formattedIntegerParse(hdBonusField.getText()));
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

			for (int i = 0; i < attackMatrixTable.getRowCount(); i++) {
				//			currentLevel.getAttackMatrix()[i] = 
				//					(int) matrixTable.getValueAt(0,i);
				currentLevel.getAttackMatrix()[i] = (int) attackMatrixTable
						.getValueAt(i, 1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			SimpleDialog
					.showError("Error with format of data. Values not stored: "
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * 
	 * @author Celestian
	 *
	 */
	class VerifyIntegerPositive extends InputVerifier implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComponent source = (JComponent) arg0.getSource();
			shouldYieldFocus(source); //ignore return value
		}

		@Override
		public boolean shouldYieldFocus(JComponent input) {
			boolean inputOK = verify(input);
			if (inputOK) {
				return true;
			} else {
				Toolkit.getDefaultToolkit().beep();
				return false;
			}
		}

		@Override
		public boolean verify(JComponent testThis) {
			boolean verified = false;
			JTextComponent textComponent = (JTextComponent) testThis;
			NumberFormat nF = NumberFormat.getIntegerInstance();
			Number n = null;

			try {
				n = nF.parse(textComponent.getText());
			} catch (ParseException e1) {
				verified = false;
				//e1.printStackTrace();
			}

			try {
				if (n.intValue() >= 0)
					verified = true;
			} catch (Exception e) {
				verified = false;
			}

			return verified;
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel abilityScoreAdjustPanel;
	private javax.swing.JButton abilityScoreAdjustmentButton;
	private javax.swing.JFormattedTextField acAdjustmentField;
	private javax.swing.JFormattedTextField acBaseField;
	private javax.swing.JPanel armorClassPanel;
	private javax.swing.JSpinner atkPerRound1Spinner;
	private javax.swing.JSpinner atkPerRound2Spinner;
	private javax.swing.JTable attackMatrixTable;
	private javax.swing.JPanel attacksPanel;
	private javax.swing.JLabel autoMatrixLabel;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JFormattedTextField expReqField;
	private javax.swing.JButton extraAbilitiesButton;
	private javax.swing.JPanel featuresPanel;
	private javax.swing.JPanel grantedProfsPanel;
	private javax.swing.JFormattedTextField hdBonusField;
	private javax.swing.JFormattedTextField hdNumberField;
	private javax.swing.JFormattedTextField hdSizeField;
	private javax.swing.JPanel healthPanel;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JPanel levelPanel;
	private javax.swing.JPanel levelPanel1;
	private javax.swing.JSpinner levelSpinner;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel matrixPanel;
	private javax.swing.JSpinner maxAtkPerRound1Spinner;
	private javax.swing.JSpinner maxAtkPerRound2Spinner;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JSpinner nonWeaponProfSpinner;
	private javax.swing.JButton nonweaponBonusButton;
	private javax.swing.JButton nonweaponBonusButton1;
	private javax.swing.JPanel profsPanel;
	private javax.swing.JButton savesBaseButton;
	private javax.swing.JButton savesBonusButton;
	private javax.swing.JPanel savesPanel;
	private javax.swing.JPanel skillsPanel;
	private javax.swing.JButton spellsArcaneButton;
	private javax.swing.JButton spellsDivineButton;
	private javax.swing.JPanel spellsPerLevelPanel;
	private javax.swing.JFormattedTextField thacoField;
	private javax.swing.JLabel thacoTextLabel;
	private javax.swing.JButton thiefSkillAdjustmentButton;
	private javax.swing.JButton thiefSkillsButton;
	private javax.swing.JSpinner weaponProfsSpinner;
	// End of variables declaration//GEN-END:variables
}
