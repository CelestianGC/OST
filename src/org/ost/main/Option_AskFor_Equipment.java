/*
 * 
 */
package org.ost.main;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.NonWeaponProfClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.WeaponProfClass;

/**
 * 
 * @author Celestian
 *
 */
public class Option_AskFor_Equipment extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private EquipmentClass oE;

	/** Creates new form Option_AskFor_Equipment */
	public Option_AskFor_Equipment(java.awt.Frame parent, boolean modal,
			MainClass ost, EquipmentClass oEquipment) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.oE = oEquipment;
		initComponents();

		updatePanels();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);

		//		setSize(370, 275);
		setLocationRelativeTo(parent);
		pack();

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		gearNewButtonGroup = new javax.swing.ButtonGroup();
		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		gearNewPanel = new javax.swing.JPanel();
		gearTypePanel = new javax.swing.JPanel();
		gearNewArmorRadioButton = new javax.swing.JRadioButton();
		gearNewContainerRadioButton = new javax.swing.JRadioButton();
		gearNewEquipmentRadioButton = new javax.swing.JRadioButton();
		gearNewWeaponRadioButton = new javax.swing.JRadioButton();
		gearNewTreasureRadioButton = new javax.swing.JRadioButton();
		gearNewDetailsPanel = new javax.swing.JPanel();
		gearNewNameLabel = new javax.swing.JLabel();
		gearNewNameTextField = new javax.swing.JTextField();
		gearNewDescriptionLabel = new javax.swing.JLabel();
		gearNewDescriptionTextField = new javax.swing.JTextField();
		gearNewWeightSpinner = new javax.swing.JSpinner();
		gearNewWeightLabel = new javax.swing.JLabel();
		gearNewMagicCheckBox = new javax.swing.JCheckBox();
		gearNewChargedCheckBox = new javax.swing.JCheckBox();
		gearNewStackableCheckBox = new javax.swing.JCheckBox();
		gearNewChargesMaxSpinner = new javax.swing.JSpinner();
		gearNewChargesMaxLabel = new javax.swing.JLabel();
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
						1, true), "Equipment",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.BorderLayout());

		gearNewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Item",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		gearNewPanel.setPreferredSize(new java.awt.Dimension(600, 250));

		gearTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Type",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));

		gearNewButtonGroup.add(gearNewArmorRadioButton);
		gearNewArmorRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewArmorRadioButton.setText("Armor");
		gearTypePanel.add(gearNewArmorRadioButton);

		gearNewButtonGroup.add(gearNewContainerRadioButton);
		gearNewContainerRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewContainerRadioButton.setText("Container");
		gearTypePanel.add(gearNewContainerRadioButton);

		gearNewButtonGroup.add(gearNewEquipmentRadioButton);
		gearNewEquipmentRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewEquipmentRadioButton.setSelected(true);
		gearNewEquipmentRadioButton.setText("Equipment");
		gearTypePanel.add(gearNewEquipmentRadioButton);

		gearNewButtonGroup.add(gearNewWeaponRadioButton);
		gearNewWeaponRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeaponRadioButton.setText("Weapon");
		gearTypePanel.add(gearNewWeaponRadioButton);

		gearNewButtonGroup.add(gearNewTreasureRadioButton);
		gearNewTreasureRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewTreasureRadioButton.setText("Treasure");
		gearTypePanel.add(gearNewTreasureRadioButton);

		gearNewPanel.add(gearTypePanel);

		gearNewDetailsPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Details",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 8)));
		gearNewDetailsPanel.setLayout(new java.awt.GridBagLayout());

		gearNewNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewNameLabel.setText("Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel.add(gearNewNameLabel, gridBagConstraints);

		gearNewNameTextField.setPreferredSize(new java.awt.Dimension(200, 27));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel.add(gearNewNameTextField, gridBagConstraints);

		gearNewDescriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewDescriptionLabel.setText("Description");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel.add(gearNewDescriptionLabel, gridBagConstraints);

		gearNewDescriptionTextField.setPreferredSize(new java.awt.Dimension(
				400, 27));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel
				.add(gearNewDescriptionTextField, gridBagConstraints);

		gearNewWeightSpinner.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeightSpinner.setToolTipText("Item weight.");
		gearNewWeightSpinner.setPreferredSize(new java.awt.Dimension(50, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel.add(gearNewWeightSpinner, gridBagConstraints);

		gearNewWeightLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeightLabel.setText("Weight");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gearNewDetailsPanel.add(gearNewWeightLabel, gridBagConstraints);

		gearNewMagicCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewMagicCheckBox.setText("Magic");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gearNewDetailsPanel.add(gearNewMagicCheckBox, gridBagConstraints);

		gearNewChargedCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewChargedCheckBox.setText("Charged");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gearNewDetailsPanel.add(gearNewChargedCheckBox, gridBagConstraints);

		gearNewStackableCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewStackableCheckBox.setText("Stackable");
		gearNewStackableCheckBox
				.setToolTipText("Does this item stack? Arrows stack, iron rations stack.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gearNewDetailsPanel.add(gearNewStackableCheckBox, gridBagConstraints);

		gearNewChargesMaxSpinner.setEnabled(false);
		gearNewChargesMaxSpinner
				.setPreferredSize(new java.awt.Dimension(50, 22));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 6;
		gridBagConstraints.gridy = 2;
		gearNewDetailsPanel.add(gearNewChargesMaxSpinner, gridBagConstraints);

		gearNewChargesMaxLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewChargesMaxLabel.setText("Max Charges");
		gearNewChargesMaxLabel.setToolTipText("Maximum charges for this item.");
		gearNewChargesMaxLabel.setEnabled(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 2;
		gearNewDetailsPanel.add(gearNewChargesMaxLabel, gridBagConstraints);

		gearNewPanel.add(gearNewDetailsPanel);

		mainPanel.add(gearNewPanel, java.awt.BorderLayout.CENTER);

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

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		updateCurrentValues();
	}

	private void updateCurrentValues() {
		//TODO
	}

	private void updatePanels() {
		//TODO
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JRadioButton gearNewArmorRadioButton;
	private javax.swing.ButtonGroup gearNewButtonGroup;
	private javax.swing.JCheckBox gearNewChargedCheckBox;
	private javax.swing.JLabel gearNewChargesMaxLabel;
	private javax.swing.JSpinner gearNewChargesMaxSpinner;
	private javax.swing.JRadioButton gearNewContainerRadioButton;
	private javax.swing.JLabel gearNewDescriptionLabel;
	private javax.swing.JTextField gearNewDescriptionTextField;
	private javax.swing.JPanel gearNewDetailsPanel;
	private javax.swing.JRadioButton gearNewEquipmentRadioButton;
	private javax.swing.JCheckBox gearNewMagicCheckBox;
	private javax.swing.JLabel gearNewNameLabel;
	private javax.swing.JTextField gearNewNameTextField;
	private javax.swing.JPanel gearNewPanel;
	private javax.swing.JCheckBox gearNewStackableCheckBox;
	private javax.swing.JRadioButton gearNewTreasureRadioButton;
	private javax.swing.JRadioButton gearNewWeaponRadioButton;
	private javax.swing.JLabel gearNewWeightLabel;
	private javax.swing.JSpinner gearNewWeightSpinner;
	private javax.swing.JPanel gearTypePanel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	// End of variables declaration//GEN-END:variables
}