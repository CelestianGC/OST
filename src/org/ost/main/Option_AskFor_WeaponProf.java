/*
 * Option_AskFor_WeaponProf.java
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
import org.ost.main.MyClasses.WeaponProfClass;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_WeaponProf extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private WeaponProfClass currentProf;

	/** Creates new form Option_AskFor_CharacterClass */
	public Option_AskFor_WeaponProf(java.awt.Frame parent, boolean modal,
			MainClass ost, WeaponProfClass oProf) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentProf = oProf;
		initComponents();

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
		jLabel2 = new javax.swing.JLabel();
		damageSpinner = new javax.swing.JSpinner();
		jLabel3 = new javax.swing.JLabel();
		attackSpinner = new javax.swing.JSpinner();
		jLabel4 = new javax.swing.JLabel();
		costSpinner = new javax.swing.JSpinner();
		classesButton = new javax.swing.JButton();
		weaponsButton = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		speedSpinner = new javax.swing.JSpinner();
		preReqButton = new javax.swing.JButton();
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
						1, true), "Weapon Proficiencies",
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
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(racesButton, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel2.setText("damage adjustment");
		jLabel2.setToolTipText("Starting adjustment (tracking -6 to non-ranger/etc).");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel2, gridBagConstraints);

		damageSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(damageSpinner, gridBagConstraints);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("attack adjustment");
		jLabel3.setToolTipText("Adjustment to checks per rank.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel3, gridBagConstraints);

		attackSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(attackSpinner, gridBagConstraints);

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("cost");
		jLabel4.setToolTipText("Cost in proficiencies.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(classesButton, gridBagConstraints);

		weaponsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		weaponsButton.setText("matching weapons");
		weaponsButton.setToolTipText("What weapons does this match.");
		weaponsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				weaponsButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(weaponsButton, gridBagConstraints);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel5.setText("speed adjustment");
		jLabel5.setToolTipText("Starting adjustment (tracking -6 to non-ranger/etc).");
		jLabel5.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
		mainPanel.add(jLabel5, gridBagConstraints);

		speedSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -20, 20, 1));
		speedSpinner.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(speedSpinner, gridBagConstraints);

		preReqButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		preReqButton.setText("pre-req profs");
		preReqButton
				.setToolTipText("Weapon prficiencies required before this one can be taken.");
		preReqButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				preReqButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(preReqButton, gridBagConstraints);

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

	private void preReqButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<WeaponProfClass> aList = WeaponProfClass.getAllowed(
				currentProf.getPreReqWeaponProfs(), ost.WeaponProfList);
		Option_Set_WeaponProfs dDialog = new Option_Set_WeaponProfs(parent,
				true, ost, aList);

		dDialog.setVisible(true);
		currentProf.setPreReqWeaponProfs(WeaponProfClass
				.getAllowedAsString(aList));
	}

	private void weaponsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void classesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<CharacterClass> aList = CharacterClass.getAllowed(
				currentProf.getAllowedClass(), ost.characterClassList);
		Option_Set_CharacterClass dDialog = new Option_Set_CharacterClass(
				parent, true, ost, aList);

		dDialog.setVisible(true);

		currentProf.setAllowedClass(CharacterClass.getAllowedAsString(aList));
	}

	private void racesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<RaceClass> aList = RaceClass.getAllowed(
				currentProf.getAllowedRace(), ost.raceList);
		Option_Set_Race dDialog = new Option_Set_Race(parent, true, ost, aList);

		dDialog.setVisible(true);

		currentProf.setAllowedRace(RaceClass.getAllowedAsString(aList));
	}

	private void descriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				ost.mainFrame, true, ost, "Weapon Proficiency Description",
				currentProf.getDescription());

		dDialog.setVisible(true);
		currentProf.setDescription(dDialog.getDescription());
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
		currentProf.setAttackAdjustment((int) attackSpinner.getValue());
		currentProf.setDamageAdjustment((int) damageSpinner.getValue());
		currentProf.setSpeedAdjustment((int) speedSpinner.getValue());
	}

	private void updatePanels() {
		nameTextField.setText(currentProf.getName());
		costSpinner.setValue(currentProf.getCost());
		attackSpinner.setValue(currentProf.getAttackAdjustment());
		damageSpinner.setValue(currentProf.getDamageAdjustment());
		speedSpinner.setValue(currentProf.getSpeedAdjustment());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JSpinner attackSpinner;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton classesButton;
	private javax.swing.JSpinner costSpinner;
	private javax.swing.JSpinner damageSpinner;
	private javax.swing.JButton descriptionButton;
	private javax.swing.JButton doneButton;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JButton preReqButton;
	private javax.swing.JButton racesButton;
	private javax.swing.JSpinner speedSpinner;
	private javax.swing.JButton weaponsButton;
	// End of variables declaration//GEN-END:variables
}