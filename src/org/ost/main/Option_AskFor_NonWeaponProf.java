/*
 * Option_AskFor_NonWeaponProf.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.NonWeaponProfClass;
import org.ost.main.MyClasses.RaceClass;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_NonWeaponProf extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private NonWeaponProfClass currentProf;

	/** Creates new form Option_AskFor_CharacterClass */
	public Option_AskFor_NonWeaponProf(java.awt.Frame parent, boolean modal,
			MainClass ost, NonWeaponProfClass oProf) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentProf = oProf;
		initComponents();

		DefaultComboBoxModel modelBox = new DefaultComboBoxModel<>();
		abilityBasedOnComboBox.setModel(modelBox);
		for (int i = 0; i < MAX_ABILITIES; i++)
			modelBox.addElement(ABILITIES[i]);

		updatePanels();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);

		setSize(370,275);
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
		racesButton = new javax.swing.JButton();
		abilityBasedOnComboBox = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		baseAdjustmentSpinner = new javax.swing.JSpinner();
		jLabel3 = new javax.swing.JLabel();
		bonusSpinner = new javax.swing.JSpinner();
		jLabel4 = new javax.swing.JLabel();
		costSpinner = new javax.swing.JSpinner();
		classesButton = new javax.swing.JButton();
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
						1, true), "Non-Weapon Proficiencies",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridBagLayout());

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		nameLabel.setText("name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
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

		racesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		racesButton.setText("allowed races");
		racesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				racesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(racesButton, gridBagConstraints);

		abilityBasedOnComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		abilityBasedOnComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		abilityBasedOnComboBox
				.setToolTipText("What ability that is checked for this non-weapon prof.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(abilityBasedOnComboBox, gridBagConstraints);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("check");
		jLabel1.setToolTipText("What ability that is checked for this non-weapon prof.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
		mainPanel.add(jLabel1, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("base adjustment");
		jLabel2.setToolTipText("Starting adjustment (tracking -6 to non-ranger/etc).");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel2, gridBagConstraints);

		baseAdjustmentSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				-20, 20, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(baseAdjustmentSpinner, gridBagConstraints);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("rank bonus");
		jLabel3.setToolTipText("Adjustment to checks per rank.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel3, gridBagConstraints);

		bonusSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(bonusSpinner, gridBagConstraints);

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("cost");
		jLabel4.setToolTipText("Cost in proficiencies.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel4, gridBagConstraints);

		costSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 20, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(costSpinner, gridBagConstraints);

		classesButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		classesButton.setText("allowed classes");
		classesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				classesButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(classesButton, gridBagConstraints);

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

	private void classesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code he
		ArrayList<CharacterClass> aList = CharacterClass.getAllowed(
				currentProf.getAllowedClass(), ost.characterClassList);
		Option_Set_CharacterClass dDialog = new 
				Option_Set_CharacterClass(parent, true, ost, aList,null);

		dDialog.setVisible(true);

		currentProf.setAllowedClass(CharacterClass.getAllowedAsString(aList));
		
	}

	private void racesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ArrayList<RaceClass> aList = RaceClass.getAllowed(
				currentProf.getAllowedRace(), ost.raceList);
		Option_Set_Race dDialog = new Option_Set_Race(null, parent, true, ost, aList);

		dDialog.setVisible(true);

		currentProf.setAllowedRace(RaceClass.getAllowedAsString(aList));
	}

	private void descriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				ost.mainFrame, true, ost, "NonWeapon Proficiency Description",
				currentProf.getDescription());

		dDialog.setVisible(true);
		currentProf.setDescription(dDialog.getDescription());
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
		currentProf.setName(nameTextField.getText());
		currentProf.setCost((int) costSpinner.getValue());
		currentProf.setAbilityBase(abilityBasedOnComboBox.getSelectedIndex());
		currentProf.setBaseAdjustment((int) baseAdjustmentSpinner.getValue());
		currentProf.setPerAdjustment((int) bonusSpinner.getValue());
	}

	private void updatePanels() {
		nameTextField.setText(currentProf.getName());
		costSpinner.setValue(currentProf.getCost());
		abilityBasedOnComboBox.setSelectedIndex(currentProf.getAbilityBase());
		baseAdjustmentSpinner.setValue(currentProf.getBaseAdjustment());
		bonusSpinner.setValue(currentProf.getPerAdjustment());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JComboBox abilityBasedOnComboBox;
	private javax.swing.JSpinner baseAdjustmentSpinner;
	private javax.swing.JSpinner bonusSpinner;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton classesButton;
	private javax.swing.JSpinner costSpinner;
	private javax.swing.JButton descriptionButton;
	private javax.swing.JButton doneButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JButton racesButton;
	// End of variables declaration//GEN-END:variables
}