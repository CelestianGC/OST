/*
 * Option_AskFor_CharacterClass.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.RaceClass;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_CharacterClass extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private DefaultComboBoxModel modelBoxGameVersions;

	/** Creates new form Option_AskFor_CharacterClass */
	public Option_AskFor_CharacterClass(java.awt.Frame parent, boolean modal,
			MainClass ost, CharacterClass oClass) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentClass = oClass;
		initComponents();

		ArrayList<String> gameList = new ArrayList<>();
		for (CharacterClass cC : ost.characterClassList.getContent())
			if (!gameList.contains(cC.getGameVersion()))
				gameList.add(cC.getGameVersion());
		Collections.sort(gameList);
		modelBoxGameVersions = new DefaultComboBoxModel<>(gameList.toArray());
		gameVersionComboBox.setModel(modelBoxGameVersions);

		updatePanels();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);

		//setSize(360, 340);
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
		descriptionButton = new javax.swing.JButton();
		levelsButton = new javax.swing.JButton();
		racesButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		abbrevTextField = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		maxLevelSpinner = new javax.swing.JSpinner();
		percentileStrengthCheckBox = new javax.swing.JCheckBox();
		alignmentAllowedButton = new javax.swing.JButton();
		armorAllowedButton = new javax.swing.JButton();
		weaponsAllowedButton = new javax.swing.JButton();
		magicAllowedButton = new javax.swing.JButton();
		abilityReqsButton = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		startingGoldDiceRollTextField = new javax.swing.JTextField();
		allowMaleCheckBox = new javax.swing.JCheckBox();
		allowFemaleCheckBox = new javax.swing.JCheckBox();
		nonProfLabel = new javax.swing.JLabel();
		nonProfPenaltySpinner = new javax.swing.JSpinner();
		allowDualClassing = new javax.swing.JCheckBox();
		allowMultiClassing = new javax.swing.JCheckBox();
		gameVersionLabel = new javax.swing.JLabel();
		gameVersionComboBox = new javax.swing.JComboBox();
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
						1, true), "Class",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridBagLayout());

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
		mainPanel.add(nameLabel, gridBagConstraints);

		nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		mainPanel.add(nameTextField, gridBagConstraints);

		descriptionButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		descriptionButton.setText("set description");
		descriptionButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						descriptionButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(descriptionButton, gridBagConstraints);

		levelsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		levelsButton.setText("levels");
		levelsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				levelsButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(levelsButton, gridBagConstraints);

		racesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		racesButton.setText("allowed races");
		racesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				racesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(racesButton, gridBagConstraints);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("abbrev");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(jLabel1, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(abbrevTextField, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("max level");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(jLabel2, gridBagConstraints);

		maxLevelSpinner.setModel(new javax.swing.SpinnerNumberModel(20, 1, 99,
				1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(maxLevelSpinner, gridBagConstraints);

		percentileStrengthCheckBox.setBackground(new java.awt.Color(153, 153,
				153));
		percentileStrengthCheckBox
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		percentileStrengthCheckBox.setText("percentile strength");
		percentileStrengthCheckBox
				.setToolTipText("Class allows percentile strength when at 18.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(percentileStrengthCheckBox, gridBagConstraints);

		alignmentAllowedButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		alignmentAllowedButton.setText("alignment");
		alignmentAllowedButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						alignmentAllowedButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(alignmentAllowedButton, gridBagConstraints);

		armorAllowedButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		armorAllowedButton.setText("armor");
		armorAllowedButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(armorAllowedButton, gridBagConstraints);

		weaponsAllowedButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		weaponsAllowedButton.setText("weapons");
		weaponsAllowedButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(weaponsAllowedButton, gridBagConstraints);

		magicAllowedButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		magicAllowedButton.setText("magic");
		magicAllowedButton.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(magicAllowedButton, gridBagConstraints);

		abilityReqsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		abilityReqsButton.setText("ability reqs");
		abilityReqsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						abilityReqsButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(abilityReqsButton, gridBagConstraints);

		jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel10.setText("starting gold");
		jLabel10.setToolTipText("Dice roll to generate starting gold.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(jLabel10, gridBagConstraints);

		startingGoldDiceRollTextField.setFont(new java.awt.Font("Segoe UI", 0,
				12));
		startingGoldDiceRollTextField
				.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
		startingGoldDiceRollTextField.setText("3d6*10");
		startingGoldDiceRollTextField
				.setToolTipText("Dice roll to generate starting gold.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(startingGoldDiceRollTextField, gridBagConstraints);

		allowMaleCheckBox.setBackground(new java.awt.Color(153, 153, 153));
		allowMaleCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		allowMaleCheckBox.setText("allow male");
		allowMaleCheckBox
				.setToolTipText("Allow male characters to be this class.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(allowMaleCheckBox, gridBagConstraints);

		allowFemaleCheckBox.setBackground(new java.awt.Color(153, 153, 153));
		allowFemaleCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		allowFemaleCheckBox.setText("allow female");
		allowFemaleCheckBox
				.setToolTipText("Allow female characters to be this class.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(allowFemaleCheckBox, gridBagConstraints);

		nonProfLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nonProfLabel.setText("non-prof");
		nonProfLabel
				.setToolTipText("Penalty to hit with any weapon character is not proficient with.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(nonProfLabel, gridBagConstraints);

		nonProfPenaltySpinner.setModel(new javax.swing.SpinnerNumberModel(-4,
				-20, 20, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(nonProfPenaltySpinner, gridBagConstraints);

		allowDualClassing.setBackground(new java.awt.Color(153, 153, 153));
		allowDualClassing.setFont(new java.awt.Font("Segoe UI", 0, 12));
		allowDualClassing.setText("dual class");
		allowDualClassing.setToolTipText("Dual class option allowed.");
		allowDualClassing.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(allowDualClassing, gridBagConstraints);

		allowMultiClassing.setBackground(new java.awt.Color(153, 153, 153));
		allowMultiClassing.setFont(new java.awt.Font("Segoe UI", 0, 12));
		allowMultiClassing.setText("multi-class");
		allowMultiClassing.setToolTipText("Multi-class option allowed.");
		allowMultiClassing.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(allowMultiClassing, gridBagConstraints);

		gameVersionLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gameVersionLabel.setText("game version");
		gameVersionLabel
				.setToolTipText("game version this class was modeled after.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(gameVersionLabel, gridBagConstraints);

		gameVersionComboBox.setEditable(true);
		gameVersionComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(gameVersionComboBox, gridBagConstraints);

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

	private void alignmentAllowedButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Alignment dDialog = new Option_AskFor_Alignment(parent,
				true, ost, "Alignment Restrictions",
				currentClass.getAlignmentReq(), ALIGNMENTS, ALIGNMENTS_ABBREV);
		dDialog.setVisible(true);
	}

	private void abilityReqsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_AbilityScores dDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Ability Requirements",
				currentClass.getAbilityReqs(), true);

		dDialog.setVisible(true);
	}

	private void racesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ArrayList<RaceClass> aList = RaceClass.getAllowed(
				currentClass.getRaceReqs(), ost.raceList);
		Option_Set_Race dDialog = new Option_Set_Race(null, parent, true, ost, aList);

		dDialog.setVisible(true);

		currentClass.setRaceReqs(RaceClass.getAllowedAsString(aList));
	}

	private void levelsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		// we update incase they tweaked max level, need it 
		updateCurrentValues();

		Option_AskFor_ClassLevels dDialog = new Option_AskFor_ClassLevels(
				ost.mainFrame, true, ost, currentClass);

		dDialog.setVisible(true);

	}

	private void descriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				ost.mainFrame, true, ost, "Class Description",
				currentClass.getDescription());

		dDialog.setVisible(true);
		currentClass.setDescription(dDialog.getDescription());
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		updateCurrentValues();
	}

	private void updateCurrentValues() {
		currentClass.setName(nameTextField.getText());
		currentClass.setAbbreviation(abbrevTextField.getText());
		currentClass.percentileStrength = percentileStrengthCheckBox
				.isSelected();
		currentClass.setAllowedFemale(allowFemaleCheckBox.isSelected());
		currentClass.setAllowedMale(allowMaleCheckBox.isSelected());
		currentClass.setNonProfPenalty((int) nonProfPenaltySpinner.getValue());

		//		TODO check they entered valid dice string
		currentClass.setStartingGold(startingGoldDiceRollTextField.getText());

		currentClass.setLevelMax((int) maxLevelSpinner.getValue());
		currentClass.setGameVersion(gameVersionComboBox.getSelectedItem()
				.toString());
	}

	private void updatePanels() {
		nameTextField.setText(currentClass.getName());
		abbrevTextField.setText(currentClass.getAbbreviation());
		percentileStrengthCheckBox.setSelected(currentClass
				.isPercentileStrength());
		allowFemaleCheckBox.setSelected(currentClass.isAllowedFemale());
		allowMaleCheckBox.setSelected(currentClass.isAllowedMale());
		nonProfPenaltySpinner.setValue(currentClass.getNonProfPenalty());
		startingGoldDiceRollTextField.setText(currentClass.getStartingGold());
		maxLevelSpinner.setValue(currentClass.getLevelMax());

		gameVersionComboBox.getModel().setSelectedItem(
				currentClass.getGameVersion());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField abbrevTextField;
	private javax.swing.JButton abilityReqsButton;
	private javax.swing.JButton alignmentAllowedButton;
	private javax.swing.JCheckBox allowDualClassing;
	private javax.swing.JCheckBox allowFemaleCheckBox;
	private javax.swing.JCheckBox allowMaleCheckBox;
	private javax.swing.JCheckBox allowMultiClassing;
	private javax.swing.JButton armorAllowedButton;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton descriptionButton;
	private javax.swing.JButton doneButton;
	private javax.swing.JComboBox gameVersionComboBox;
	private javax.swing.JLabel gameVersionLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton levelsButton;
	private javax.swing.JButton magicAllowedButton;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JSpinner maxLevelSpinner;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JLabel nonProfLabel;
	private javax.swing.JSpinner nonProfPenaltySpinner;
	private javax.swing.JCheckBox percentileStrengthCheckBox;
	private javax.swing.JButton racesButton;
	private javax.swing.JTextField startingGoldDiceRollTextField;
	private javax.swing.JButton weaponsAllowedButton;
	// End of variables declaration//GEN-END:variables
	private CharacterClass currentClass;
}