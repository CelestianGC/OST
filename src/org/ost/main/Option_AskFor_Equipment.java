/*
 * 
 */
package org.ost.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyClasses.NonWeaponProfClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.VerifyDiceText;
import org.ost.main.MyClasses.WeaponProfClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 * 
 * @author Celestian
 *
 */
public class Option_AskFor_Equipment extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private EquipmentClass oE;

	//	private DefaultComboBoxModel modelWeaponProf;
	//	private DefaultComboBoxModel modelWeaponGroup;
	//	private DefaultComboBoxModel modelWeaponGroupTight;

	/** Creates new form Option_AskFor_Equipment */
	public Option_AskFor_Equipment(java.awt.Frame parent, boolean modal,
			MainClass ost, EquipmentClass oEquipment) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.oE = oEquipment;
		initComponents();

		valueTable.getTableHeader().setFont(
				new Font(DEFAULT_FONT, Font.PLAIN, 10));
		//valueTable.getTableHeader().setBackground(Color.yellow);

		weaponTypeComboBox.setModel(new DefaultComboBoxModel<>(WEAPON_NAMES));
		armorBulkTypeComboBox.setModel(new DefaultComboBoxModel<>(
				ARMOR_TYPE_NAMES));

		ArrayList<String> armorTypeList = new ArrayList<>();
		for (EquipmentClass cC : ost.equipmentList.getContent()) {
			if (!armorTypeList.contains(cC.getArmorType()))
				armorTypeList.add(cC.getArmorType());
		}
		Collections.sort(armorTypeList);
		armorTypeComboBox.setModel(new DefaultComboBoxModel<>(armorTypeList
				.toArray()));

		ArrayList<String> weaponGroupTight = new ArrayList<>();
		ArrayList<String> weaponGroup = new ArrayList<>();
		ArrayList<String> weaponProfList = new ArrayList<>();
		for (EquipmentClass cC : ost.equipmentList.getContent()) {
			if (!weaponProfList.contains(cC.getWeaponProfType()))
				weaponProfList.add(cC.getWeaponProfType());
			if (!weaponGroup.contains(cC.getWeaponGroupType()))
				weaponGroup.add(cC.getWeaponGroupType());
			if (!weaponGroupTight.contains(cC.getWeaponTightGroupType()))
				weaponGroupTight.add(cC.getWeaponTightGroupType());
		}
		Collections.sort(weaponGroup);
		weaponTypeGroupComboBox.setModel(new DefaultComboBoxModel<>(weaponGroup
				.toArray()));

		Collections.sort(weaponGroupTight);
		weaponTypeGroupTightComboBox.setModel(new DefaultComboBoxModel<>(
				weaponGroupTight.toArray()));

		Collections.sort(weaponProfList);
		weaponTypeProfComboBox.setModel(new DefaultComboBoxModel<>(
				weaponProfList.toArray()));

		updatePanels();

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
		gearPanel = new javax.swing.JPanel();
		typePanel = new javax.swing.JPanel();
		gearNewArmorRadioButton = new javax.swing.JRadioButton();
		gearNewShieldRadioButton = new javax.swing.JRadioButton();
		gearNewContainerRadioButton = new javax.swing.JRadioButton();
		gearNewEquipmentRadioButton = new javax.swing.JRadioButton();
		gearNewWeaponRadioButton = new javax.swing.JRadioButton();
		gearNewTreasureRadioButton = new javax.swing.JRadioButton();
		detailsPanel = new javax.swing.JPanel();
		valuePanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		valueTable = new javax.swing.JTable();
		namePanel = new javax.swing.JPanel();
		gearNewNameLabel = new javax.swing.JLabel();
		gearNewNameTextField = new javax.swing.JTextField();
		gearNewDescriptionButton = new javax.swing.JButton();
		featuresButton = new javax.swing.JButton();
		magicPanel = new javax.swing.JPanel();
		gearNewMagicCheckBox = new javax.swing.JCheckBox();
		gearNewChargedCheckBox = new javax.swing.JCheckBox();
		gearNewChargesMaxLabel = new javax.swing.JLabel();
		gearNewChargesMaxSpinner = new javax.swing.JSpinner();
		magicMod1Label = new javax.swing.JLabel();
		magicBonus1Spinner = new javax.swing.JSpinner();
		magicMod2Label = new javax.swing.JLabel();
		magicBonus2Spinner = new javax.swing.JSpinner();
		weightPanel = new javax.swing.JPanel();
		gearNewWeightLabel = new javax.swing.JLabel();
		gearNewWeightSpinner = new javax.swing.JSpinner();
		gearNewStackableCheckBox = new javax.swing.JCheckBox();
		weaponPanel = new javax.swing.JPanel();
		damageDicePanel = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		speedFactorSpinner = new javax.swing.JSpinner();
		jLabel1 = new javax.swing.JLabel();
		damageSmallTextField = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		damageMediumTextField = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		damageLargeTextField = new javax.swing.JTextField();
		weaponTypePanel = new javax.swing.JPanel();
		weaponTypeLabel = new javax.swing.JLabel();
		weaponTypeComboBox = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		weaponTypeProfComboBox = new javax.swing.JComboBox();
		jLabel7 = new javax.swing.JLabel();
		weaponTypeGroupComboBox = new javax.swing.JComboBox();
		jLabel8 = new javax.swing.JLabel();
		weaponTypeGroupTightComboBox = new javax.swing.JComboBox();
		armorPanel = new javax.swing.JPanel();
		armorBulkTypeComboBox = new javax.swing.JComboBox();
		armorTypeComboBox = new javax.swing.JComboBox();
		jLabel5 = new javax.swing.JLabel();
		acBaseSpinner = new javax.swing.JSpinner();
		jLabel2 = new javax.swing.JLabel();
		acAdjustmentSpinner = new javax.swing.JSpinner();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Equipment");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setLayout(new java.awt.BorderLayout());

		gearPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Item",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		gearPanel.setLayout(new java.awt.GridBagLayout());

		typePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Type",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		typePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,
				1, 1));

		gearNewButtonGroup.add(gearNewArmorRadioButton);
		gearNewArmorRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewArmorRadioButton.setText("Armor");
		gearNewArmorRadioButton
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						gearNewArmorRadioButtonItemStateChanged(evt);
					}
				});
		typePanel.add(gearNewArmorRadioButton);

		gearNewButtonGroup.add(gearNewShieldRadioButton);
		gearNewShieldRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewShieldRadioButton.setText("Shield");
		gearNewShieldRadioButton
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						gearNewShieldRadioButtonItemStateChanged(evt);
					}
				});
		typePanel.add(gearNewShieldRadioButton);

		gearNewButtonGroup.add(gearNewContainerRadioButton);
		gearNewContainerRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewContainerRadioButton.setText("Container");
		typePanel.add(gearNewContainerRadioButton);

		gearNewButtonGroup.add(gearNewEquipmentRadioButton);
		gearNewEquipmentRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewEquipmentRadioButton.setSelected(true);
		gearNewEquipmentRadioButton.setText("Equipment");
		typePanel.add(gearNewEquipmentRadioButton);

		gearNewButtonGroup.add(gearNewWeaponRadioButton);
		gearNewWeaponRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeaponRadioButton.setText("Weapon");
		gearNewWeaponRadioButton
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						gearNewWeaponRadioButtonItemStateChanged(evt);
					}
				});
		typePanel.add(gearNewWeaponRadioButton);

		gearNewButtonGroup.add(gearNewTreasureRadioButton);
		gearNewTreasureRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewTreasureRadioButton.setText("Treasure");
		typePanel.add(gearNewTreasureRadioButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gearPanel.add(typePanel, gridBagConstraints);

		detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Details",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		detailsPanel.setLayout(new java.awt.GridBagLayout());

		valuePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Value",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		valuePanel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		valuePanel.setLayout(new java.awt.BorderLayout());

		jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 55));

		valueTable.setFont(new java.awt.Font("Segoe UI", 0, 12));
		valueTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null } },
				new String[] { "EXP", "CP", "SP", "EP", "GP", "PP" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		valueTable.getTableHeader().setReorderingAllowed(false);
		jScrollPane2.setViewportView(valueTable);

		valuePanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		detailsPanel.add(valuePanel, gridBagConstraints);

		namePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				1, 1));

		gearNewNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewNameLabel.setText("Name  ");
		namePanel.add(gearNewNameLabel);

		gearNewNameTextField.setPreferredSize(new java.awt.Dimension(200, 27));
		namePanel.add(gearNewNameTextField);

		gearNewDescriptionButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewDescriptionButton.setText("description");
		gearNewDescriptionButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gearNewDescriptionButtonActionPerformed(evt);
					}
				});
		namePanel.add(gearNewDescriptionButton);

		featuresButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		featuresButton.setText("features");
		featuresButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				featuresButtonActionPerformed(evt);
			}
		});
		namePanel.add(featuresButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		detailsPanel.add(namePanel, gridBagConstraints);

		magicPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				1, 1));

		gearNewMagicCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewMagicCheckBox.setText("Magic");
		gearNewMagicCheckBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				gearNewMagicCheckBoxItemStateChanged(evt);
			}
		});
		magicPanel.add(gearNewMagicCheckBox);

		gearNewChargedCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewChargedCheckBox.setText("Charged");
		gearNewChargedCheckBox
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						gearNewChargedCheckBoxItemStateChanged(evt);
					}
				});
		magicPanel.add(gearNewChargedCheckBox);

		gearNewChargesMaxLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewChargesMaxLabel.setText("Charges");
		gearNewChargesMaxLabel.setToolTipText("Maximum charges for this item.");
		gearNewChargesMaxLabel.setEnabled(false);
		magicPanel.add(gearNewChargesMaxLabel);

		gearNewChargesMaxSpinner.setEnabled(false);
		gearNewChargesMaxSpinner
				.setPreferredSize(new java.awt.Dimension(50, 22));
		magicPanel.add(gearNewChargesMaxSpinner);

		magicMod1Label.setFont(new java.awt.Font("Segoe UI", 0, 12));
		magicMod1Label.setText("Magic +/-");
		magicMod1Label.setToolTipText("Primary bonus, typically bonus to hit.");
		magicPanel.add(magicMod1Label);

		magicBonus1Spinner.setModel(new javax.swing.SpinnerNumberModel());
		magicBonus1Spinner.setEnabled(false);
		magicBonus1Spinner.setPreferredSize(new java.awt.Dimension(40, 22));
		magicPanel.add(magicBonus1Spinner);

		magicMod2Label.setFont(new java.awt.Font("Segoe UI", 0, 12));
		magicMod2Label.setText("Magic +/-");
		magicMod2Label.setToolTipText("Secondary, typically bonus to damage.");
		magicPanel.add(magicMod2Label);

		magicBonus2Spinner.setModel(new javax.swing.SpinnerNumberModel());
		magicBonus2Spinner.setEnabled(false);
		magicBonus2Spinner.setPreferredSize(new java.awt.Dimension(40, 22));
		magicPanel.add(magicBonus2Spinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		detailsPanel.add(magicPanel, gridBagConstraints);

		weightPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				1, 1));

		gearNewWeightLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeightLabel.setText("Weight");
		weightPanel.add(gearNewWeightLabel);

		gearNewWeightSpinner.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewWeightSpinner.setModel(new javax.swing.SpinnerNumberModel(Float
				.valueOf(0.0f), null, null, Float.valueOf(1.0f)));
		gearNewWeightSpinner.setToolTipText("Item weight.");
		gearNewWeightSpinner.setPreferredSize(new java.awt.Dimension(50, 22));
		weightPanel.add(gearNewWeightSpinner);

		gearNewStackableCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewStackableCheckBox.setText("Stackable");
		gearNewStackableCheckBox
				.setToolTipText("Does this item stack? Arrows stack, iron rations stack.");
		weightPanel.add(gearNewStackableCheckBox);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		detailsPanel.add(weightPanel, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gearPanel.add(detailsPanel, gridBagConstraints);

		weaponPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Weapons",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		weaponPanel.setLayout(new java.awt.GridBagLayout());

		damageDicePanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT));

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel9.setText("speed");
		damageDicePanel.add(jLabel9);

		speedFactorSpinner.setModel(new javax.swing.SpinnerNumberModel());
		speedFactorSpinner.setEnabled(false);
		speedFactorSpinner.setPreferredSize(new java.awt.Dimension(40, 22));
		damageDicePanel.add(speedFactorSpinner);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("damage S");
		damageDicePanel.add(jLabel1);

		damageSmallTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		damageSmallTextField.setText("jTextField1");
		damageSmallTextField.setEnabled(false);
		damageSmallTextField.setInputVerifier(new VerifyDiceText());
		damageSmallTextField.setMinimumSize(new java.awt.Dimension(92, 22));
		damageSmallTextField.setPreferredSize(new java.awt.Dimension(92, 22));
		damageDicePanel.add(damageSmallTextField);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel3.setText("M");
		damageDicePanel.add(jLabel3);

		damageMediumTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		damageMediumTextField.setText("jTextField1");
		damageMediumTextField.setEnabled(false);
		damageMediumTextField.setInputVerifier(new VerifyDiceText());
		damageMediumTextField.setMinimumSize(new java.awt.Dimension(92, 22));
		damageMediumTextField.setPreferredSize(new java.awt.Dimension(92, 22));
		damageDicePanel.add(damageMediumTextField);

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel4.setText("L");
		damageDicePanel.add(jLabel4);

		damageLargeTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		damageLargeTextField.setText("jTextField1");
		damageLargeTextField.setEnabled(false);
		damageLargeTextField.setInputVerifier(new VerifyDiceText());
		damageLargeTextField.setMinimumSize(new java.awt.Dimension(92, 22));
		damageLargeTextField.setPreferredSize(new java.awt.Dimension(92, 22));
		damageDicePanel.add(damageLargeTextField);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		weaponPanel.add(damageDicePanel, gridBagConstraints);

		weaponTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		weaponTypeLabel.setText("type");
		weaponTypePanel.add(weaponTypeLabel);

		weaponTypeComboBox.setToolTipText("Weapon Type");
		weaponTypeComboBox.setEnabled(false);
		weaponTypePanel.add(weaponTypeComboBox);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel6.setText("prof");
		weaponTypePanel.add(jLabel6);

		weaponTypeProfComboBox.setEditable(true);
		weaponTypeProfComboBox.setToolTipText("Weapon proficieny used.");
		weaponTypeProfComboBox.setEnabled(false);
		weaponTypePanel.add(weaponTypeProfComboBox);

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel7.setText("group");
		weaponTypePanel.add(jLabel7);

		weaponTypeGroupComboBox.setEditable(true);
		weaponTypeGroupComboBox.setToolTipText("Weapon group.");
		weaponTypeGroupComboBox.setEnabled(false);
		weaponTypePanel.add(weaponTypeGroupComboBox);

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel8.setText("tight");
		weaponTypePanel.add(jLabel8);

		weaponTypeGroupTightComboBox.setEditable(true);
		weaponTypeGroupTightComboBox.setToolTipText("Weapon tight group.");
		weaponTypeGroupTightComboBox.setEnabled(false);
		weaponTypePanel.add(weaponTypeGroupTightComboBox);

		weaponPanel.add(weaponTypePanel, new java.awt.GridBagConstraints());

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gearPanel.add(weaponPanel, gridBagConstraints);

		armorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Armor",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		armorPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		armorBulkTypeComboBox.setEnabled(false);
		armorBulkTypeComboBox.setPreferredSize(new java.awt.Dimension(150, 27));
		armorPanel.add(armorBulkTypeComboBox);

		armorTypeComboBox.setEditable(true);
		armorTypeComboBox.setEnabled(false);
		armorPanel.add(armorTypeComboBox);

		jLabel5.setText("ac base");
		armorPanel.add(jLabel5);

		acBaseSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10, 10,
				1));
		acBaseSpinner.setEnabled(false);
		armorPanel.add(acBaseSpinner);

		jLabel2.setText("ac");
		armorPanel.add(jLabel2);

		acAdjustmentSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -10,
				10, 1));
		acAdjustmentSpinner.setEnabled(false);
		armorPanel.add(acAdjustmentSpinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gearPanel.add(armorPanel, gridBagConstraints);

		mainPanel.add(gearPanel, java.awt.BorderLayout.CENTER);

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

	private void gearNewShieldRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		boolean isSet = gearNewShieldRadioButton.isSelected();
		acAdjustmentSpinner.setEnabled(isSet);
		acBaseSpinner.setEnabled(isSet);
		armorBulkTypeComboBox.setEnabled(isSet);
		armorTypeComboBox.setEnabled(isSet);
		
	}

	private void featuresButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<ExtraAbilitiesClass> aList = ExtraAbilitiesClass.getAllowed(
				oE.getFeatures(), ost.extraAbilitiesList);
		Option_Set_ExtraAbilities dDialog = new Option_Set_ExtraAbilities(
				parent, true, ost, aList);
		dDialog.setVisible(true);

		// changes done now set the new values
		oE.setFeatures(ExtraAbilitiesClass.getAllowedAsString(aList));

	}

	private void gearNewChargedCheckBoxItemStateChanged(
			java.awt.event.ItemEvent evt) {
		boolean isSet = gearNewChargedCheckBox.isSelected();
		gearNewChargesMaxLabel.setEnabled(isSet);
		gearNewChargesMaxSpinner.setEnabled(isSet);
	}

	private void gearNewMagicCheckBoxItemStateChanged(
			java.awt.event.ItemEvent evt) {

		boolean isSet = gearNewMagicCheckBox.isSelected();
		magicBonus1Spinner.setEnabled(isSet);
		magicBonus2Spinner.setEnabled(isSet);
	}

	private void gearNewArmorRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {

		boolean isSet = gearNewArmorRadioButton.isSelected();
		acAdjustmentSpinner.setEnabled(isSet);
		acBaseSpinner.setEnabled(isSet);
		armorBulkTypeComboBox.setEnabled(isSet);
		armorTypeComboBox.setEnabled(isSet);
	}

	private void gearNewWeaponRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {

		boolean isSet = gearNewWeaponRadioButton.isSelected();
		weaponTypeProfComboBox.setEnabled(isSet);
		weaponTypeComboBox.setEnabled(isSet);
		weaponTypeGroupComboBox.setEnabled(isSet);
		weaponTypeGroupTightComboBox.setEnabled(isSet);
		damageLargeTextField.setEnabled(isSet);
		damageMediumTextField.setEnabled(isSet);
		damageSmallTextField.setEnabled(isSet);
		speedFactorSpinner.setEnabled(isSet);
	}

	private void gearNewDescriptionButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Option_AskFor_Description dDialog = new Option_AskFor_Description(
				parent, true, ost, "Equipment Description", oE.getDescription());
		dDialog.setVisible(true);

		oE.setDescription(dDialog.currentDescription);
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		updateCurrentValues();
	}

	private void updateCurrentValues() {
		//TODO
		oE.setName(gearNewNameTextField.getText());

		int nType = GEAR_TYPE_EQUIPMENT;
		if (gearNewArmorRadioButton.isSelected())
			nType = GEAR_TYPE_ARMOR;
		else if (gearNewContainerRadioButton.isSelected())
			nType = GEAR_TYPE_CONTAINER;
		else if (gearNewEquipmentRadioButton.isSelected())
			nType = GEAR_TYPE_EQUIPMENT;
		else if (gearNewTreasureRadioButton.isSelected())
			nType = GEAR_TYPE_TREASURE;
		else if (gearNewWeaponRadioButton.isSelected())
			nType = GEAR_TYPE_WEAPON;
		else if (gearNewShieldRadioButton.isSelected())
			nType = GEAR_TYPE_SHIELD;

		oE.setType(nType);
		float fWeight = Float.parseFloat(gearNewWeightSpinner.getValue()
				.toString());
		oE.setWeight(fWeight);

		int maxCharges = Integer.parseInt(gearNewChargesMaxSpinner.getValue()
				.toString());
		oE.setMagic(gearNewMagicCheckBox.isSelected());

		// if count > 0 then we call it a stackable item
		oE.setCount(gearNewStackableCheckBox.isSelected() ? 1 : -1);
		// if charges > 0 then we call it chargable item
		oE.setCharges(gearNewChargedCheckBox.isSelected() ? 1 : -1);
		oE.setChargesMax(maxCharges);

		oE.setExperience((int) valueTable.getValueAt(0, 0));
		oE.getValue()[COIN_CP] = ((int) valueTable.getValueAt(0, 1));
		oE.getValue()[COIN_SP] = ((int) valueTable.getValueAt(0, 2));
		oE.getValue()[COIN_EP] = ((int) valueTable.getValueAt(0, 3));
		oE.getValue()[COIN_GP] = ((int) valueTable.getValueAt(0, 4));
		oE.getValue()[COIN_PP] = ((int) valueTable.getValueAt(0, 5));

		oE.setWeaponType(weaponTypeComboBox.getSelectedIndex());

		oE.setWeaponProfType(weaponTypeProfComboBox.getSelectedItem()
				.toString());
		oE.setWeaponGroupType(weaponTypeGroupComboBox.getSelectedItem()
				.toString());
		oE.setWeaponTightGroupType(weaponTypeGroupTightComboBox
				.getSelectedItem().toString());

		oE.setDamageSmall(damageSmallTextField.getText());
		oE.setDamageMedium(damageMediumTextField.getText());
		oE.setDamageLarge(damageLargeTextField.getText());

		oE.setArmorBulkType(armorBulkTypeComboBox.getSelectedIndex());
		oE.setArmorType(armorTypeComboBox.getSelectedItem().toString());
		oE.setAcBase((int) acBaseSpinner.getValue());
		oE.setAc((int) acAdjustmentSpinner.getValue());

		oE.setSpeedFactor((int) speedFactorSpinner.getValue());

		oE.setMagicAdjustmentPrimary((int) magicBonus1Spinner.getValue());
		oE.setMagicAdjustmentSecondary((int) magicBonus2Spinner.getValue());

	}

	private void updatePanels() {
		//TODO
		if (oE != null) {
			gearNewNameTextField.setText(oE.getName());
			switch (oE.getType()) {
			case GEAR_TYPE_ARMOR:
				gearNewArmorRadioButton.setSelected(true);
				break;
			case GEAR_TYPE_SHIELD:
				gearNewShieldRadioButton.setSelected(true);
				break;
			case GEAR_TYPE_CONTAINER:
				gearNewContainerRadioButton.setSelected(true);
				break;
			case GEAR_TYPE_TREASURE:
				gearNewTreasureRadioButton.setSelected(true);
				break;
			case GEAR_TYPE_WEAPON:
				gearNewWeaponRadioButton.setSelected(true);
				break;

			default:
				gearNewEquipmentRadioButton.setSelected(true);
				break;
			}
			gearNewMagicCheckBox.setSelected(oE.isMagic());
			gearNewChargedCheckBox.setSelected(oE.getCharges() > -1);
			gearNewStackableCheckBox.setSelected(oE.getCount() > -1);
			gearNewChargesMaxSpinner.setValue(oE.getChargesMax());
			gearNewWeightSpinner.setValue(oE.getWeight());

			valueTable.setValueAt(oE.getExperience(), 0, 0);
			valueTable.setValueAt(oE.getValue()[COIN_CP], 0, 1);
			valueTable.setValueAt(oE.getValue()[COIN_SP], 0, 2);
			valueTable.setValueAt(oE.getValue()[COIN_EP], 0, 3);
			valueTable.setValueAt(oE.getValue()[COIN_GP], 0, 4);
			valueTable.setValueAt(oE.getValue()[COIN_PP], 0, 5);

			weaponTypeComboBox.setSelectedIndex(oE.getWeaponType());

			weaponTypeProfComboBox.setSelectedItem(oE.getWeaponProfType());
			weaponTypeGroupComboBox.setSelectedItem(oE.getWeaponGroupType());
			weaponTypeGroupTightComboBox.setSelectedItem(oE
					.getWeaponTightGroupType());

			damageSmallTextField.setText(oE.getDamageSmall());
			damageMediumTextField.setText(oE.getDamageMedium());
			damageLargeTextField.setText(oE.getDamageLarge());

			armorBulkTypeComboBox.setSelectedIndex(oE.getArmorBulkType());
			armorTypeComboBox.setSelectedItem(oE.getArmorType());
			acBaseSpinner.setValue(oE.getAcBase());
			acAdjustmentSpinner.setValue(oE.getAc());

			speedFactorSpinner.setValue(oE.getSpeedFactor());

			magicBonus1Spinner.setValue(oE.getMagicAdjustmentPrimary());
			magicBonus2Spinner.setValue(oE.getMagicAdjustmentSecondary());
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JSpinner acAdjustmentSpinner;
	private javax.swing.JSpinner acBaseSpinner;
	private javax.swing.JComboBox armorBulkTypeComboBox;
	private javax.swing.JPanel armorPanel;
	private javax.swing.JComboBox armorTypeComboBox;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JPanel damageDicePanel;
	private javax.swing.JTextField damageLargeTextField;
	private javax.swing.JTextField damageMediumTextField;
	private javax.swing.JTextField damageSmallTextField;
	private javax.swing.JPanel detailsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton featuresButton;
	private javax.swing.JRadioButton gearNewArmorRadioButton;
	private javax.swing.ButtonGroup gearNewButtonGroup;
	private javax.swing.JCheckBox gearNewChargedCheckBox;
	private javax.swing.JLabel gearNewChargesMaxLabel;
	private javax.swing.JSpinner gearNewChargesMaxSpinner;
	private javax.swing.JRadioButton gearNewContainerRadioButton;
	private javax.swing.JButton gearNewDescriptionButton;
	private javax.swing.JRadioButton gearNewEquipmentRadioButton;
	private javax.swing.JCheckBox gearNewMagicCheckBox;
	private javax.swing.JLabel gearNewNameLabel;
	private javax.swing.JTextField gearNewNameTextField;
	private javax.swing.JRadioButton gearNewShieldRadioButton;
	private javax.swing.JCheckBox gearNewStackableCheckBox;
	private javax.swing.JRadioButton gearNewTreasureRadioButton;
	private javax.swing.JRadioButton gearNewWeaponRadioButton;
	private javax.swing.JLabel gearNewWeightLabel;
	private javax.swing.JSpinner gearNewWeightSpinner;
	private javax.swing.JPanel gearPanel;
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
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSpinner magicBonus1Spinner;
	private javax.swing.JSpinner magicBonus2Spinner;
	private javax.swing.JLabel magicMod1Label;
	private javax.swing.JLabel magicMod2Label;
	private javax.swing.JPanel magicPanel;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel namePanel;
	private javax.swing.JSpinner speedFactorSpinner;
	private javax.swing.JPanel typePanel;
	private javax.swing.JPanel valuePanel;
	private javax.swing.JTable valueTable;
	private javax.swing.JPanel weaponPanel;
	private javax.swing.JComboBox weaponTypeComboBox;
	private javax.swing.JComboBox weaponTypeGroupComboBox;
	private javax.swing.JComboBox weaponTypeGroupTightComboBox;
	private javax.swing.JLabel weaponTypeLabel;
	private javax.swing.JPanel weaponTypePanel;
	private javax.swing.JComboBox weaponTypeProfComboBox;
	private javax.swing.JPanel weightPanel;
	// End of variables declaration//GEN-END:variables
}