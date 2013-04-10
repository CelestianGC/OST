/*
 * DM_Config_Tab_Players.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;

import static org.ost.main.MyClasses.MyStatics.*;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.jdom.Document;
import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.CharacterClassList;
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.ExtraAbilitiesList;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.SkillsClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.XMLControl;

/**
 *
 * @author  __USER__
 */
public class DM_Config_Tab_Players extends javax.swing.JPanel {
	private MainClass ost;
	private Panel_Player_Details playerDetailsPanel;
	private Panel_Player_Saves playerSavesPanel;
	private Panel_Player_Abilities playerAbilitiesPanel;

	/** Creates new form DM_Config_Tab_Players */
	public DM_Config_Tab_Players(MainClass ost) {
		this.ost = ost;
		initComponents();
		currentPlayer = null;
		updatePlayerList(null);
		updateGearBuyTree();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		gearNewDialog = new javax.swing.JDialog();
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
		gearNewButtonsPanel = new javax.swing.JPanel();
		gearNewDoneButton = new javax.swing.JButton();
		gearNewCancelButton = new javax.swing.JButton();
		gearNewButtonGroup = new javax.swing.ButtonGroup();
		gearTabPanel = new javax.swing.JPanel();
		gearPanel = new javax.swing.JPanel();
		gearScrollPane = new javax.swing.JScrollPane();
		gearTree = new javax.swing.JTree();
		gearTree.setCellRenderer(new gearTreeCellRenderer());

		nodeRoot = new DefaultMutableTreeNode("Gear");
		nodeEquipment = new DefaultMutableTreeNode("Equipment");
		nodeTreasure = new DefaultMutableTreeNode("Treasure");
		gearTreeModel = new DefaultTreeModel(nodeRoot);
		nodeRoot.add(nodeEquipment);
		nodeRoot.add(nodeTreasure);

		adjustButtonPanel = new javax.swing.JPanel();
		chargesAdjustPanel = new javax.swing.JPanel();
		chargesAdjustSpinner = new javax.swing.JSpinner();
		stacksAdjustPanel = new javax.swing.JPanel();
		stacksAdjustSpinner = new javax.swing.JSpinner();
		jPanel3 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		gearNewAddButton = new javax.swing.JButton();
		gearRemoveItButton = new javax.swing.JButton();
		gearBuyPanel = new javax.swing.JPanel();
		gearButtonPanel = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		newGearBuyButton = new javax.swing.JButton();
		deleteBuyGearButton = new javax.swing.JButton();
		editBuyGearButton = new javax.swing.JButton();
		gearBuyScrollPane = new javax.swing.JScrollPane();
		gearBuyTree = new javax.swing.JTree();
		gearBuyTree.setCellRenderer(new gearBuyTreeCellRenderer());

		nodeBuyRoot = new DefaultMutableTreeNode("Gear");
		nodeBuyEquipment = new DefaultMutableTreeNode("Equipment");
		nodeBuyTreasure = new DefaultMutableTreeNode("Treasure");
		nodeBuyContainers = new DefaultMutableTreeNode("Containers");
		nodeBuyArmor = new DefaultMutableTreeNode("Armor");
		nodeBuyWeapons = new DefaultMutableTreeNode("Weapons");

		gearBuyTreeModel = new DefaultTreeModel(nodeBuyRoot);
		//gearBuyTree.setModel(gearBuyTreeModel);

		nodeBuyRoot.add(nodeBuyArmor);
		nodeBuyRoot.add(nodeBuyContainers);
		nodeBuyRoot.add(nodeBuyEquipment);
		nodeBuyRoot.add(nodeBuyWeapons);
		nodeBuyRoot.add(nodeBuyTreasure);

		playerSplitPane = new javax.swing.JSplitPane();
		mainPanel = new javax.swing.JPanel();
		playerTabbedPane = new javax.swing.JTabbedPane();
		playerTabPanel = new javax.swing.JPanel();
		notesPanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		notesField = new javax.swing.JTextArea();
		buttonsPanel = new javax.swing.JPanel();
		addEncounterButton = new javax.swing.JButton();
		playerEditButton = new javax.swing.JButton();
		testButton = new javax.swing.JButton();
		listPlayerPanel = new javax.swing.JPanel();
		jPanel10 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		playerSearchTextField = new javax.swing.JTextField();
		jPanel17 = new javax.swing.JPanel();
		newButton = new javax.swing.JButton();
		copyButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		playerListModel = new DefaultListModel();
		playerList = new javax.swing.JList(playerListModel);
		playerList.setCellRenderer(new MyCellRendererList());
		jPanel8 = new javax.swing.JPanel();
		importButton = new javax.swing.JButton();
		exportButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();

		gearNewDialog.setTitle("New Equipment");
		gearNewDialog.setAlwaysOnTop(true);
		gearNewDialog.setMinimumSize(new java.awt.Dimension(600, 300));

		gearNewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "New Item",
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
		gearNewWeightSpinner
				.setModel(new javax.swing.SpinnerNumberModel(Float
						.valueOf(0.0f), Float.valueOf(0.0f), null, Float
						.valueOf(0.1f)));
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
		gearNewChargedCheckBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gearNewChargedCheckBoxActionPerformed(evt);
					}
				});
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

		gearNewChargesMaxSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				0, 300, 1));
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

		gearNewDialog.getContentPane().add(gearNewPanel,
				java.awt.BorderLayout.CENTER);

		gearNewButtonsPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		gearNewDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewDoneButton.setText("done");
		gearNewDoneButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gearNewDoneButtonActionPerformed(evt);
					}
				});
		gearNewButtonsPanel.add(gearNewDoneButton);

		gearNewCancelButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewCancelButton.setText("cancel");
		gearNewCancelButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gearNewCancelButtonActionPerformed(evt);
					}
				});
		gearNewButtonsPanel.add(gearNewCancelButton);

		gearNewDialog.getContentPane().add(gearNewButtonsPanel,
				java.awt.BorderLayout.PAGE_END);

		gearTabPanel.setLayout(new java.awt.GridBagLayout());

		gearPanel.setBackground(new java.awt.Color(0, 0, 0));
		gearPanel.setLayout(new java.awt.BorderLayout());

		gearScrollPane.setBackground(new java.awt.Color(51, 51, 51));

		gearTree.setBackground(new java.awt.Color(0, 0, 0));
		gearTree.setToolTipText("Select and adjust charges and stacks.");
		gearTree.setModel(gearTreeModel);
		gearTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				gearTreeValueChanged(evt);
			}
		});
		gearScrollPane.setViewportView(gearTree);

		gearPanel.add(gearScrollPane, java.awt.BorderLayout.CENTER);

		adjustButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		adjustButtonPanel.setLayout(new java.awt.GridBagLayout());

		chargesAdjustPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "charges",
						javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		chargesAdjustPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.CENTER, 0, 0));

		chargesAdjustSpinner.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chargesAdjustSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0,
				999, 1));
		chargesAdjustSpinner
				.setToolTipText("Adjust the number of charges left on item.");
		chargesAdjustSpinner.setEnabled(false);
		chargesAdjustSpinner.setPreferredSize(new java.awt.Dimension(45, 22));
		chargesAdjustSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						chargesAdjustSpinnerStateChanged(evt);
					}
				});
		chargesAdjustPanel.add(chargesAdjustSpinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		adjustButtonPanel.add(chargesAdjustPanel, gridBagConstraints);

		stacksAdjustPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "stacks",
						javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		stacksAdjustPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.CENTER, 0, 0));

		stacksAdjustSpinner.setFont(new java.awt.Font("Segoe UI", 0, 10));
		stacksAdjustSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0,
				999, 1));
		stacksAdjustSpinner
				.setToolTipText("Adjust the number of stacks (days of food, number of arrows)");
		stacksAdjustSpinner.setEnabled(false);
		stacksAdjustSpinner.setPreferredSize(new java.awt.Dimension(45, 22));
		stacksAdjustSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						stacksAdjustSpinnerStateChanged(evt);
					}
				});
		stacksAdjustPanel.add(stacksAdjustSpinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		adjustButtonPanel.add(stacksAdjustPanel, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weightx = 1.0;
		adjustButtonPanel.add(jPanel3, gridBagConstraints);

		gearPanel.add(adjustButtonPanel, java.awt.BorderLayout.PAGE_END);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gearTabPanel.add(gearPanel, gridBagConstraints);

		jPanel5.setBackground(new java.awt.Color(153, 153, 153));
		jPanel5.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jPanel5.setLayout(new java.awt.GridBagLayout());

		gearNewAddButton.setBackground(new java.awt.Color(204, 204, 204));
		gearNewAddButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gearNewAddButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Arrow-Left-icon-16.png"))); // NOI18N
		gearNewAddButton
				.setToolTipText("Add selected items to players inventory.");
		gearNewAddButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		gearNewAddButton
				.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		gearNewAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gearNewAddButtonActionPerformed(evt);
			}
		});
		jPanel5.add(gearNewAddButton, new java.awt.GridBagConstraints());

		gearRemoveItButton.setBackground(new java.awt.Color(204, 204, 204));
		gearRemoveItButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		gearRemoveItButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Arrow-Right-icon-16.png"))); // NOI18N
		gearRemoveItButton
				.setToolTipText("Remove selected item from players inventory.");
		gearRemoveItButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		gearRemoveItButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gearRemoveItButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		jPanel5.add(gearRemoveItButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gearTabPanel.add(jPanel5, gridBagConstraints);

		gearBuyPanel.setLayout(new java.awt.BorderLayout());

		gearButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		gearButtonPanel.setLayout(new java.awt.BorderLayout());

		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
		gearButtonPanel.add(jPanel1, java.awt.BorderLayout.WEST);

		jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		newGearBuyButton.setBackground(new java.awt.Color(204, 204, 204));
		newGearBuyButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		newGearBuyButton.setText("new");
		newGearBuyButton.setToolTipText("Create new item for equipment list.");
		newGearBuyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newGearBuyButtonActionPerformed(evt);
			}
		});
		jPanel2.add(newGearBuyButton);

		deleteBuyGearButton.setBackground(new java.awt.Color(204, 204, 204));
		deleteBuyGearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		deleteBuyGearButton.setText("delete");
		deleteBuyGearButton
				.setToolTipText("Delete currently selected item from list.");
		deleteBuyGearButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteBuyGearButtonActionPerformed(evt);
					}
				});
		jPanel2.add(deleteBuyGearButton);

		editBuyGearButton.setBackground(new java.awt.Color(204, 204, 204));
		editBuyGearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		editBuyGearButton.setText("edit");
		editBuyGearButton
				.setToolTipText("Select a piece of equipment and click here to make changes to it.");
		editBuyGearButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						editBuyGearButtonActionPerformed(evt);
					}
				});
		jPanel2.add(editBuyGearButton);

		gearButtonPanel.add(jPanel2, java.awt.BorderLayout.EAST);

		gearBuyPanel.add(gearButtonPanel, java.awt.BorderLayout.PAGE_END);

		gearBuyTree.setBackground(new java.awt.Color(0, 0, 0));
		gearBuyTree.setToolTipText("Select items to add to player.");
		gearBuyTree.setModel(gearBuyTreeModel);
		gearBuyTree
				.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
					public void valueChanged(
							javax.swing.event.TreeSelectionEvent evt) {
						gearBuyTreeValueChanged(evt);
					}
				});
		gearBuyScrollPane.setViewportView(gearBuyTree);

		gearBuyPanel.add(gearBuyScrollPane, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gearTabPanel.add(gearBuyPanel, gridBagConstraints);

		setLayout(new java.awt.BorderLayout());

		playerSplitPane.setDividerLocation(250);

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		mainPanel.setName("Main-Panel");

		playerTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 10));

		playerTabPanel.setLayout(new java.awt.GridBagLayout());
		playerTabbedPane.addTab("Player", playerTabPanel);

		notesPanel.setBackground(new java.awt.Color(204, 204, 204));
		notesPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		notesPanel.setName("Description");
		notesPanel.setLayout(new java.awt.BorderLayout());

		notesField.setColumns(20);
		notesField.setLineWrap(true);
		notesField.setRows(5);
		notesField.setWrapStyleWord(true);
		jScrollPane2.setViewportView(notesField);

		notesPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		playerTabbedPane.addTab("Notes", notesPanel);

		buttonsPanel.setBackground(new java.awt.Color(153, 153, 153));
		buttonsPanel.setLayout(new java.awt.GridBagLayout());

		addEncounterButton.setBackground(new java.awt.Color(255, 204, 0));
		addEncounterButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		addEncounterButton.setText("add to party");
		addEncounterButton.setToolTipText("add selected player to party.");
		addEncounterButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						addEncounterButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(addEncounterButton, gridBagConstraints);

		playerEditButton.setBackground(new java.awt.Color(204, 204, 204));
		playerEditButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		playerEditButton.setText("edit");
		playerEditButton.setToolTipText("Edit character.");
		playerEditButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playerEditButtonActionPerformed(evt);
			}
		});

		testButton.setBackground(new java.awt.Color(204, 204, 204));
		testButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		testButton.setText("sheet");
		testButton.setToolTipText("View a character sheet. *test*");
		testButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				testButtonActionPerformed(evt);
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
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addGap(14, 14, 14)
										.addComponent(playerEditButton)
										.addGap(0, 0, 0)
										.addComponent(testButton)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												242, Short.MAX_VALUE)
										.addComponent(
												buttonsPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8))
						.addComponent(playerTabbedPane,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 483,
								Short.MAX_VALUE));

		mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { playerEditButton, testButton });

		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addComponent(
												playerTabbedPane,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												433, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																buttonsPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																mainPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				playerEditButton)
																		.addComponent(
																				testButton)))
										.addContainerGap()));

		playerSplitPane.setRightComponent(mainPanel);

		listPlayerPanel.setBackground(new java.awt.Color(153, 153, 153));
		listPlayerPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		listPlayerPanel.setName("List-Panel");
		listPlayerPanel.setLayout(new java.awt.BorderLayout());

		jPanel10.setBackground(new java.awt.Color(204, 204, 204));

		jPanel9.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel4.setText("Search");
		jLabel4.setToolTipText("Enter text in the box to filter the players listed.");
		jPanel9.add(jLabel4);

		playerSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		playerSearchTextField
				.setToolTipText("String to search for in creature list.");
		playerSearchTextField.setMinimumSize(new java.awt.Dimension(150, 20));
		playerSearchTextField.setPreferredSize(new java.awt.Dimension(150, 20));
		playerSearchTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						playerSearchTextFieldActionPerformed(evt);
					}
				});
		playerSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				playerSearchTextFieldKeyTyped(evt);
			}
		});
		jPanel9.add(playerSearchTextField);

		jPanel17.setBackground(new java.awt.Color(153, 153, 153));
		jPanel17.setLayout(new java.awt.GridLayout(1, 0));

		newButton.setBackground(new java.awt.Color(204, 204, 204));
		newButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		newButton.setText("New");
		newButton.setToolTipText("Create new blank player.");
		newButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newButtonActionPerformed(evt);
			}
		});
		jPanel17.add(newButton);

		copyButton.setBackground(new java.awt.Color(204, 204, 204));
		copyButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		copyButton.setText("Copy");
		copyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				copyButtonActionPerformed(evt);
			}
		});
		jPanel17.add(copyButton);

		saveButton.setBackground(new java.awt.Color(204, 204, 204));
		saveButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		saveButton.setText("Save");
		saveButton.setToolTipText("Save all players to file");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		jPanel17.add(saveButton);

		playerList.setBackground(new java.awt.Color(204, 204, 204));
		playerList
				.setToolTipText("Select player to load or press enter after selected.");
		playerList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				playerListMousePressed(evt);
			}
		});
		playerList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						playerListValueChanged(evt);
					}
				});
		playerList.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				playerListKeyTyped(evt);
			}
		});
		jScrollPane1.setViewportView(playerList);

		jPanel8.setBackground(new java.awt.Color(153, 153, 153));
		jPanel8.setLayout(new java.awt.GridLayout(1, 0));

		importButton.setBackground(new java.awt.Color(204, 204, 204));
		importButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importButton.setText("Import");
		importButton.setToolTipText("Import options.");
		importButton.setEnabled(false);
		importButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importButtonActionPerformed(evt);
			}
		});
		jPanel8.add(importButton);

		exportButton.setBackground(new java.awt.Color(204, 204, 204));
		exportButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		exportButton.setText("Export");
		exportButton.setEnabled(false);
		exportButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exportButtonActionPerformed(evt);
			}
		});
		jPanel8.add(exportButton);

		deleteButton.setBackground(new java.awt.Color(204, 204, 204));
		deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		deleteButton.setText("Delete");
		deleteButton.setToolTipText("Delete currently selected player.");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});
		jPanel8.add(deleteButton);

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel9,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel10Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jPanel8,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								217,
																								Short.MAX_VALUE)
																						.addComponent(
																								jPanel17,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								217,
																								Short.MAX_VALUE)
																						.addComponent(
																								jScrollPane1,
																								0,
																								217,
																								Short.MAX_VALUE))
																		.addGap(2,
																				2,
																				2)))
										.addContainerGap()));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel10Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel9,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel17,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 373,
								Short.MAX_VALUE)
						.addGap(0, 0, 0)
						.addComponent(jPanel8,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		listPlayerPanel.add(jPanel10, java.awt.BorderLayout.CENTER);

		playerSplitPane.setLeftComponent(listPlayerPanel);

		add(playerSplitPane, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

	private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		PlayerClass oP = (PlayerClass) playerList.getSelectedValue();
		if (oP != null) {
			currentPlayer = oP;

			//		JDialog dDialog = new JDialog();
			//		dDialog.add(new Panel_Player(ost, currentPlayer));
			//
			//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			//		Dimension windowSize = ost.mainFrame.getSize();
			//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
			//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
			//		//		setLocation(windowX, windowY);
			//		dDialog.setSize(windowSize.width - 2, windowSize.height - 2);
			//		dDialog.setLocationRelativeTo(ost.mainFrame);
			//		//dDialog.setSize(480, 360);
			//
			//		dDialog.setVisible(true);

			Frame_Character_Sheet fSheet = new Frame_Character_Sheet(ost,
					currentPlayer);
			fSheet.setVisible(true);
		}
	}

	private void playerEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		PlayerClass oP = (PlayerClass) playerList.getSelectedValue();
		if (oP != null) {
			currentPlayer = oP;
			Option_AskFor_Character dDialog = new Option_AskFor_Character(
					ost.mainFrame, true, ost, currentPlayer);
			dDialog.setVisible(true);

			// when edit done reload character to panel to update w/changes
			updatePlayerPanel();
		}
	}

	private void gearRemoveItButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		TreePath[] paths = gearTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(gearTree,
					"Are you sure you want to delete ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null
							&& Utils.isEquipment(oNode.getUserObject())) {
						EquipmentClass oE = (EquipmentClass) oNode
								.getUserObject();
						currentPlayer.getGear().remove(oE);
						ost.encounterFrame.removeNode(gearTree,
								(DefaultMutableTreeNode) oNode.getParent(),
								oNode);
					}
				}
				chargesAdjustSpinner.setEnabled(false);
				stacksAdjustSpinner.setEnabled(false);
			}
		}

	}

	private void gearNewAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		TreePath[] paths = gearBuyTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(ost.dmConfigTab,
					"Are you sure you want to add ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null
							&& Utils.isEquipment(oNode.getUserObject())) {
						EquipmentClass oE = (EquipmentClass) oNode
								.getUserObject();
						EquipmentClass oNew = oE.getCopy();
						currentPlayer.getGear().add(oNew);
						//ask for how many on stackable item
						int nCount = -1;
						if (oNew.getCount() > 0) {
							do {
								String sCount = SimpleDialog.showQuestion(null,
										"How many " + oNew.getName()
												+ " in this stack?",
										"How many?", "1");
								if (MyParse.isInteger(sCount))
									nCount = Integer.parseInt(sCount);
							} while (nCount <= 0);
							oNew.setCount(nCount);
						}
						//ask for how many charges on this charged item
						int nCharges = -1;
						if (oNew.getCharges() > 0) {
							do {
								String sCharges = SimpleDialog.showQuestion(
										null,
										"How many charges on " + oNew.getName()
												+ "?", "How many?", "1");
								if (MyParse.isInteger(sCharges))
									nCharges = Integer.parseInt(sCharges);
							} while (nCharges <= 0);
							oNew.setCharges(nCharges);
						}

						DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(
								oNew);
						DefaultMutableTreeNode oMyNode = getNodeByGearType(oNew);
						gearTreeModel.insertNodeInto(oNewNode, oMyNode,
								oMyNode.getChildCount());
						Utils.expandPathOnNode(gearTree, oMyNode);
						gearTree.repaint();

					}
				}
			}
		}

	}

	private void gearBuyTreeValueChanged(
			javax.swing.event.TreeSelectionEvent evt) {
		TreePath path = evt.getNewLeadSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			gearNewCurrentNode = oNode;
			if (Utils.isEquipment(oNode.getUserObject())) {
				EquipmentClass oE = (EquipmentClass) oNode.getUserObject();
				gearNewCurrent = oE;
			}
		}

	}

	private void gearNewChargedCheckBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		boolean isCharged = gearNewChargedCheckBox.isSelected();
		gearNewChargesMaxLabel.setEnabled(isCharged);
		gearNewChargesMaxSpinner.setEnabled(isCharged);
	}

	private void editBuyGearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (gearNewCurrent != null) {
			gearNewNameTextField.setText(gearNewCurrent.getName());
			gearNewDescriptionTextField
					.setText(gearNewCurrent.getDescription());
			switch (gearNewCurrent.getType()) {
			case GEAR_TYPE_ARMOR:
				gearNewArmorRadioButton.setSelected(true);
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
			gearNewMagicCheckBox.setSelected(gearNewCurrent.isMagic());
			gearNewChargedCheckBox
					.setSelected(gearNewCurrent.getCharges() > -1);
			gearNewStackableCheckBox
					.setSelected(gearNewCurrent.getCount() > -1);
			gearNewChargesMaxSpinner.setValue(gearNewCurrent.getChargesMax());
			gearNewWeightSpinner.setValue(new Float(0.0));

			gearNewDoneButton.setText("save-edit"); // 
			//		display dialog at current mouse
			gearNewDialog.setLocationRelativeTo(null); // mid-screen
			gearNewDialog.setVisible(true);
		}
	}

	private void stacksAdjustSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		TreePath path = gearTree.getSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (Utils.isEquipment(oNode.getUserObject())) {
				EquipmentClass oE = (EquipmentClass) oNode.getUserObject();
				int nStacks = Integer.parseInt(stacksAdjustSpinner.getValue()
						.toString());
				if (oE.getCount() != -1) {
					oE.setCount(nStacks);
					gearTreeModel.nodeChanged(oNode);
				}
			}
		}
	}

	private void chargesAdjustSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		TreePath path = gearTree.getSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (Utils.isEquipment(oNode.getUserObject())) {
				EquipmentClass oE = (EquipmentClass) oNode.getUserObject();
				int nCharges = Integer.parseInt(chargesAdjustSpinner.getValue()
						.toString());
				if (oE.getCharges() != -1) {
					oE.setCharges(nCharges);
					gearTreeModel.nodeChanged(oNode);
				}
			}
		}

	}

	private void gearTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
		// TODO add your handling code here:
		TreePath path = evt.getNewLeadSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (Utils.isEquipment(oNode.getUserObject())) {
				EquipmentClass oE = (EquipmentClass) oNode.getUserObject();
				if (oE.getCharges() > -1) {
					chargesAdjustSpinner.setEnabled(true);
					chargesAdjustSpinner.setValue(oE.getCharges());
					SpinnerNumberModel sModel = (SpinnerNumberModel) chargesAdjustSpinner
							.getModel();
					if (oE.getChargesMax() > 0) {
						sModel.setMaximum(oE.getChargesMax());
						if (oE.getCharges() > oE.getChargesMax())
							oE.setCharges(oE.getChargesMax());
					} else {
						sModel.setMaximum(999);
					}
				} else {
					chargesAdjustSpinner.setEnabled(false);
					chargesAdjustSpinner.setValue(new Integer(0));
				}
				if (oE.getCount() > -1) {
					stacksAdjustSpinner.setEnabled(true);
					stacksAdjustSpinner.setValue(oE.getCount());
				} else {
					stacksAdjustSpinner.setEnabled(false);
					stacksAdjustSpinner.setValue(new Integer(0));
				}
			}
		}

	}

	/**
	 * returns the node that we place this type of gear into on the
	 * store tree
	 * 
	 * @param oE
	 * @return
	 */
	private DefaultMutableTreeNode getNodeHomeByGearType(EquipmentClass oE) {
		DefaultMutableTreeNode myRootNode = null;

		switch (oE.getType()) {
		case GEAR_TYPE_ARMOR:
			myRootNode = nodeBuyArmor;
			break;
		case GEAR_TYPE_CONTAINER:
			myRootNode = nodeBuyContainers;
			break;
		case GEAR_TYPE_TREASURE:
			myRootNode = nodeBuyTreasure;
			break;
		case GEAR_TYPE_WEAPON:
			myRootNode = nodeBuyWeapons;
			break;
		// default to EquipmentList node
		default:
			myRootNode = nodeBuyEquipment;
			break;
		}

		return (myRootNode);
	}

	/**
	 * get the node to place this item on a player
	 * 
	 * @param oE
	 * @return
	 */
	private DefaultMutableTreeNode getNodeByGearType(EquipmentClass oE) {
		DefaultMutableTreeNode myRootNode = null;

		switch (oE.getType()) {
		case GEAR_TYPE_TREASURE:
			myRootNode = nodeTreasure;
			break;
		// default to EquipmentList node
		default:
			myRootNode = nodeEquipment;
			break;
		}

		return (myRootNode);
	}

	private void gearNewDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		boolean editMode = gearNewDoneButton.getText().equalsIgnoreCase(
				"save-edit");
		EquipmentClass oNew = null;

		if (editMode) {
			oNew = gearNewCurrent;
			oNew.setName(gearNewNameTextField.getText());
			oNew.setDescription(gearNewDescriptionTextField.getText());
		} else
			oNew = new EquipmentClass(gearNewNameTextField.getText(),
					gearNewDescriptionTextField.getText());

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

		oNew.setType(nType);
		float fWeight = Float.parseFloat(gearNewWeightSpinner.getValue()
				.toString());
		oNew.setWeight(fWeight);

		int maxCharges = Integer.parseInt(gearNewChargesMaxSpinner.getValue()
				.toString());
		oNew.setMagic(gearNewMagicCheckBox.isSelected());

		// if count > 0 then we call it a stackable item
		oNew.setCount(gearNewStackableCheckBox.isSelected() ? 1 : -1);
		// if charges > 0 then we call it chargable item
		oNew.setCharges(gearNewChargedCheckBox.isSelected() ? 1 : -1);
		oNew.setChargesMax(maxCharges);

		//TODO do something with this later
		//deal with armor/weapons eventually

		if (!editMode) {
			ost.equipmentList.add(oNew);
			DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(oNew);
			DefaultMutableTreeNode oMyNode = getNodeHomeByGearType(oNew);
			gearBuyTreeModel.insertNodeInto(oNewNode, oMyNode,
					oMyNode.getChildCount());
			Utils.expandPathOnNode(gearBuyTree, oMyNode);
			gearBuyTree.repaint();
		} else {
			gearBuyTreeModel.nodeChanged(gearNewCurrentNode);
			gearBuyTree.repaint();
		}
		gearNewDialog.setVisible(false);
	}

	private void gearNewCancelButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		gearNewDialog.setVisible(false);
	}

	private void deleteBuyGearButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		TreePath[] paths = gearBuyTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(deleteBuyGearButton,
					"Are you sure you want to delete ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null
							&& Utils.isEquipment(oNode.getUserObject())) {
						EquipmentClass oE = (EquipmentClass) oNode
								.getUserObject();
						ost.equipmentList.getContent().remove(oE);
						ost.encounterFrame.removeNode(gearBuyTree,
								(DefaultMutableTreeNode) oNode.getParent(),
								oNode);
					}
				}
			}
		}
	}

	private void newGearBuyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// set default values
		gearNewNameTextField.setText("Name");
		gearNewDescriptionTextField.setText("Enter description");
		gearNewEquipmentRadioButton.setSelected(true);
		gearNewMagicCheckBox.setSelected(false);
		gearNewChargedCheckBox.setSelected(false);
		gearNewChargesMaxSpinner.setValue(new Integer(0));
		gearNewStackableCheckBox.setSelected(false);
		gearNewWeightSpinner.setValue(new Float(0.0));

		gearNewDoneButton.setText("done"); // 
		//		display dialog at current mouse
		gearNewDialog.setLocationRelativeTo(null); // mid-screen
		gearNewDialog.setVisible(true);
	}

	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//Object[] oList = playerList.getSelectedValues();
		List aList = playerList.getSelectedValuesList();
		if (aList.size() > 0) {
			PlayerClass oC = (PlayerClass) aList.get(0);
			boolean bDelete = false;

			if (aList.size() > 1)
				bDelete = SimpleDialog.AskYN(deleteButton,
						"Delete ALL selected players?");
			else
				bDelete = SimpleDialog.AskYN(deleteButton,
						"Are you sure you want to delete " + oC.getName());

			if (bDelete) {
				for (Object oO : aList) {
					//for (int i = 0; i < oList.length; i++) {
					PlayerClass oP = (PlayerClass) oO;
					ost.playerList.getContent().remove(oP);
					if (ost.fightingPlayerList.contains(oP)) {
						ost.fightingPlayerList.remove(oP);
						ost.encounterFrame.removePartyMember(oP);
					}
					oP = null;
				}// end for

				savePlayersToFile();
				updatePlayerList(null);
			} // bDelete
		}
	}

	private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//TODO allow export of players

		//		Object[] aList = playerListOLD.getSelectedValues();
		//		ArrayList<PlayerClass> cList = new ArrayList<PlayerClass>();
		//
		//		for (int i = 0; i < aList.length; i++) {
		//			PlayerClass oC = (PlayerClass) aList[i];
		//			cList.add(oC);
		//		}
		//		Document doc = PlayerClass.xmlBuildDocFromList(cList,
		//				"ExportCreature");
		//		exportTextArea.setText(XMLControl.getDocAsText(doc));
		//		exportDialog.setLocation(exportButton.getLocation());
		//		exportDialog.setVisible(true);
	}

	private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//TODO allow import of player
		//		importDialog.setVisible(true);
	}

	private void loadListSelectedPlayer() {

		if (currentPlayer != null
				&& !ost.fightingPlayerList.contains(currentPlayer)) {
			// make sure to get current fields before switching incase they
			// changed something
			currentPlayer = getPlayerPanelFields(currentPlayer);
		}
		// load selected
		currentPlayer = (PlayerClass) playerList.getSelectedValue();
		updatePlayerPanel();
	}

	private void playerListKeyTyped(java.awt.event.KeyEvent evt) {
		if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
			loadListSelectedPlayer();
		}
	}

	private void playerListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		loadListSelectedPlayer();
	}

	private void playerListMousePressed(java.awt.event.MouseEvent evt) {
		loadListSelectedPlayer();
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		savePlayersToFile();
		SimpleDialog.showDone("Saved players to file.");
	}

	/**
	 * 
	 */
	public void savePlayersToFile() {
		if (currentPlayer != null) {
			currentPlayer = getPlayerPanelFields(currentPlayer);
			updatePlayerList(currentPlayer);
		}

		//		Document doc = PlayerClass.xmlBuildDocFromList(ost.playerListOLD,
		//				"PlayerList");
		//		XMLControl.saveDoc(doc, ost.sPlayerListFile);
		ost.playerList.xm.serializeToXMLFile();
	}

	//	public void saveEquipmentToFile() {
	//		Document doc = EquipmentClass.xmlBuildDocFromList(ost.equipmentList,
	//				"EquipmentList");
	//		XMLControl.saveDoc(doc, ost.sEquipmentListFile);
	//	}

	private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		PlayerClass newPC = new PlayerClass(currentPlayer.getName());
		ost.playerList.getContent().add(newPC);
		newPC = getPlayerPanelFields(newPC);
		updatePlayerList(newPC);
		savePlayersToFile();
	}

	private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {
		PlayerClass newPC = new PlayerClass("New");
		addNewPlayer(newPC);
		savePlayersToFile();
	}

	private void addNewPlayer(PlayerClass newPC) {
		ost.playerList.getContent().add(newPC);
		// update the player list which also updated the player panel fields.
		updatePlayerList(newPC);
	}

	private void playerSearchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
		updatePlayerList(currentPlayer);
	}

	private void playerSearchTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		updatePlayerList(currentPlayer);
	}

	private void addEncounterButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
//		Object[] pList = playerList.getSelectedValues();
		List pList = playerList.getSelectedValuesList();
		if (pList.size() > 0)
			for (int i = 0; i < pList.size(); i++) {
				PlayerClass oC = (PlayerClass) pList.get(i);
				oC.setEncountered(new EncounterPlayer(ost, oC));

				ost.fightingPlayerList.add(oC);
				ost.encounterFrame.copyNode(ost.encounterFrame.encountersTree,
						ost.encounterFrame.nodePC, new DefaultMutableTreeNode(
								oC), ost.encounterFrame.nodePC.getChildCount());
			} // end for

		if (!ost.encounterFrame.isVisible()) {
			ost.encounterFrame.pack();
			ost.encounterFrame.setVisible(true);
		} else {
			ost.encounterFrame.validate();
		}

		ost.encounterFrame.encountersTree.expandPath(new TreePath(
				ost.encounterFrame.nodePC.getPath()));

		// if nothing selected select one
		ost.encounterFrame.encountersTreeSetSelected();

		// should reset values back to previous since we didn't alter currentPlayer
		// used incase we set AC or some other value that changes depending on critter
		//updatePlayerPanel();
		playerList.clearSelection();
	}

	@SuppressWarnings("unchecked")
	public void updatePlayerList(PlayerClass oPreviousSelect) {
		String findThese = playerSearchTextField.getText().trim();

		playerListModel.removeAllElements();
		Collections.sort(ost.playerList.getContent());
		for (PlayerClass oC : ost.playerList.getContent()) {
			if (findThese == null
					|| findThese.length() < 1
					|| oC.getName().toLowerCase()
							.contains(findThese.toLowerCase())) {
				playerListModel.addElement(oC); // add ones we're searching for...
			}// end if
		} // end for
		if (oPreviousSelect == null)
			playerList.setSelectedIndex(0);
		else
			playerList.setSelectedValue(oPreviousSelect, true);

		currentPlayer = (PlayerClass) playerList.getSelectedValue();

		updatePlayerPanel();
	}// end updatePlayerList

	/**
	 * updates the displayed player from currentPlayer object
	 */
	private void updatePlayerPanel() {
		// string fields

		if (currentPlayer != null && currentPlayer.getName() != null) {

			if (playerDetailsPanel == null) {
				playerDetailsPanel = new Panel_Player_Details(ost,
						currentPlayer);
				GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;

				playerTabPanel.add(playerDetailsPanel, gridBagConstraints);
				playerTabPanel.validate();
			} else
				playerDetailsPanel.updatePanel(currentPlayer);

			if (playerSavesPanel == null) {
				playerSavesPanel = new Panel_Player_Saves(ost, currentPlayer);
				GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
				playerTabPanel.add(playerSavesPanel, gridBagConstraints);
				playerTabPanel.validate();
			} else
				playerSavesPanel.updatePanel(currentPlayer);

			if (playerAbilitiesPanel == null) {
				playerAbilitiesPanel = new Panel_Player_Abilities(ost,
						currentPlayer);
				GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
				playerTabPanel.add(playerAbilitiesPanel, gridBagConstraints);
				playerTabPanel.validate();
			} else
				playerAbilitiesPanel.updatePanel(currentPlayer);

			notesField.setText(currentPlayer.getNotes());

			//GEAR
			nodeEquipment.removeAllChildren();
			gearTreeModel.reload(nodeEquipment);
			nodeTreasure.removeAllChildren();
			gearTreeModel.reload(nodeTreasure);
			for (EquipmentClass eQ : currentPlayer.getGear()) {
				DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(eQ);
				DefaultMutableTreeNode oMyNode = getNodeByGearType(eQ);
				gearTreeModel.insertNodeInto(oNewNode, oMyNode,
						oMyNode.getChildCount());
				Utils.expandPathOnNode(gearTree, oMyNode);
				gearTree.repaint();
			}
			//			playerStatsPanel.revalidate();
			//			playerStatsPanel.repaint();
		}

		playerList.repaint();
	}// end updatePlayerPanel

	/**
	 * 
	 * @param cC
	 * @return
	 */
	private PlayerClass getPlayerPanelFields(PlayerClass cC) {

		//		cC.setName(nameField.getText());
		//		cC.setNamePlayer(namePlayerField.getText());
		//		cC.setPcClass(classField.getText());
		//		cC.setPcLevel(levelField.getText());

		//		if (MyParse.isInteger(hpMaxField.getText()))
		//			cC.setHpMax(Integer.parseInt(hpMaxField.getText()));
		//		cC.setHpCurrent(cC.getHpMax());
		//		cC.getArmorRatings().clear();
		//		cC.getArmorRatings().add(acField.getText());

		//		cC.setMoveRate(moveField.getText());
		//		cC.setSpecialAttacks(specialAttackField.getText());
		//
		//		cC.setSpecialDefense(specialDefenseField.getText());
		//		cC.setMagicResistance(magicresistanceField.getText());
		cC.setNotes(notesField.getText());
		//		cC.setAlignment(alignmentField.getText());

		return (cC);
	} // end loadPlayerPanelFields

	/**
	 * clear out the tree and load up the equipmentList
	 */
	private void updateGearBuyTree() {
		//TODO finish this

		nodeBuyArmor.removeAllChildren();
		nodeBuyContainers.removeAllChildren();
		nodeBuyEquipment.removeAllChildren();
		nodeBuyTreasure.removeAllChildren();
		nodeBuyWeapons.removeAllChildren();
		gearBuyTreeModel.reload(nodeBuyArmor);
		gearBuyTreeModel.reload(nodeBuyContainers);
		gearBuyTreeModel.reload(nodeBuyEquipment);
		gearBuyTreeModel.reload(nodeBuyTreasure);
		gearBuyTreeModel.reload(nodeBuyWeapons);

		for (EquipmentClass eQ : ost.equipmentList.getContent()) {
			DefaultMutableTreeNode oMyRoot = getNodeHomeByGearType(eQ);
			DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(eQ);
			gearBuyTreeModel.insertNodeInto(oNewNode, oMyRoot,
					oMyRoot.getChildCount());
		}
		// expand the eq/treasure/etc rows
		gearBuyTree.repaint();
		Utils.expandPathOnNode(gearBuyTree, nodeBuyArmor);
		Utils.expandPathOnNode(gearBuyTree, nodeBuyContainers);
		Utils.expandPathOnNode(gearBuyTree, nodeBuyEquipment);
		Utils.expandPathOnNode(gearBuyTree, nodeBuyTreasure);
		Utils.expandPathOnNode(gearBuyTree, nodeBuyWeapons);
	}

	public class gearTreeCellRenderer extends DefaultTreeCellRenderer {

		public gearTreeCellRenderer() {
			super();
			// TODO Auto-generated constructor stub
		}

		/* (non-Javadoc)
		 * @see javax.swing.tree.DefaultTreeCellRenderer#getTreeCellRendererComponent(javax.swing.JTree, java.lang.Object, boolean, boolean, boolean, int, boolean)
		 */
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean sel, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			if (value instanceof DefaultMutableTreeNode) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				if (node.getUserObject() instanceof String) {
					setText((String) node.getUserObject());
				} else if (Utils.isEquipment(node.getUserObject())) {
					EquipmentClass eQ = (EquipmentClass) node.getUserObject();
					String sName = "";
					String sCharges = "";
					String sStacks = "";
					if (eQ.getCharges() > -1)
						sCharges = String.format(" (charges:%s)",
								eQ.getCharges());
					if (eQ.getCount() > -1)
						sStacks = String.format("[%s]", eQ.getCount());
					sName = String.format("%s%s%s", eQ.getName(), sCharges,
							sStacks);

					setToolTipText(eQ.getDescription());
					setText(sName);
				}
				if (sel) {
					setForeground(Color.yellow);
					setOpaque(true);
					setBackground(Color.GRAY);
				} else {
					setForeground(Color.white);
					setOpaque(true);
					setBackground(Color.black);
				}
			}

			//			return super.getTreeCellRendererComponent(tree, value, sel,
			//					expanded, leaf, row, hasFocus);
			return this;
		}

	}

	public class gearBuyTreeCellRenderer extends DefaultTreeCellRenderer {

		/**
		 * constructor
		 */
		public gearBuyTreeCellRenderer() {
		}

		/**
		 * 
		 */
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			if (value instanceof DefaultMutableTreeNode) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				if (node.getUserObject() instanceof String) {
					setText((String) node.getUserObject());
				} else if (Utils.isEquipment(node.getUserObject())) {
					EquipmentClass dR = (EquipmentClass) node.getUserObject();
					setToolTipText(dR.getDescription());
					setText(dR.getName());
				}
				if (selected) {
					setForeground(Color.yellow);
					setOpaque(true);
					setBackground(Color.GRAY);
				} else {
					setForeground(Color.white);
					setOpaque(true);
					setBackground(Color.black);
				}
			}
			return this;
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton addEncounterButton;
	private javax.swing.JPanel adjustButtonPanel;
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JPanel chargesAdjustPanel;
	private javax.swing.JSpinner chargesAdjustSpinner;
	private javax.swing.JButton copyButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton deleteBuyGearButton;
	private javax.swing.JButton editBuyGearButton;
	private javax.swing.JButton exportButton;
	private javax.swing.JPanel gearButtonPanel;
	private javax.swing.JPanel gearBuyPanel;
	private javax.swing.JScrollPane gearBuyScrollPane;
	private javax.swing.JTree gearBuyTree;
	private javax.swing.JButton gearNewAddButton;
	private javax.swing.JRadioButton gearNewArmorRadioButton;
	private javax.swing.ButtonGroup gearNewButtonGroup;
	private javax.swing.JPanel gearNewButtonsPanel;
	private javax.swing.JButton gearNewCancelButton;
	private javax.swing.JCheckBox gearNewChargedCheckBox;
	private javax.swing.JLabel gearNewChargesMaxLabel;
	private javax.swing.JSpinner gearNewChargesMaxSpinner;
	private javax.swing.JRadioButton gearNewContainerRadioButton;
	private javax.swing.JLabel gearNewDescriptionLabel;
	private javax.swing.JTextField gearNewDescriptionTextField;
	private javax.swing.JPanel gearNewDetailsPanel;
	private javax.swing.JDialog gearNewDialog;
	private javax.swing.JButton gearNewDoneButton;
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
	private javax.swing.JPanel gearPanel;
	private javax.swing.JButton gearRemoveItButton;
	private javax.swing.JScrollPane gearScrollPane;
	private javax.swing.JPanel gearTabPanel;
	private javax.swing.JTree gearTree;
	private javax.swing.JPanel gearTypePanel;
	private javax.swing.JButton importButton;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPanel listPlayerPanel;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JButton newButton;
	private javax.swing.JButton newGearBuyButton;
	private javax.swing.JTextArea notesField;
	private javax.swing.JPanel notesPanel;
	private javax.swing.JButton playerEditButton;
	private javax.swing.JList playerList;
	private javax.swing.JTextField playerSearchTextField;
	private javax.swing.JSplitPane playerSplitPane;
	private javax.swing.JPanel playerTabPanel;
	private javax.swing.JTabbedPane playerTabbedPane;
	private javax.swing.JButton saveButton;
	private javax.swing.JPanel stacksAdjustPanel;
	private javax.swing.JSpinner stacksAdjustSpinner;
	private javax.swing.JButton testButton;
	// End of variables declaration//GEN-END:variables
	private PlayerClass currentPlayer;
	private DefaultListModel playerListModel;
	private DefaultMutableTreeNode nodeRoot;
	private DefaultMutableTreeNode nodeEquipment;
	private DefaultMutableTreeNode nodeTreasure;
	private DefaultTreeModel gearTreeModel;
	private DefaultMutableTreeNode nodeBuyRoot;
	private DefaultMutableTreeNode nodeBuyEquipment;
	private DefaultMutableTreeNode nodeBuyTreasure;
	private DefaultMutableTreeNode nodeBuyContainers;
	private DefaultMutableTreeNode nodeBuyArmor;
	private DefaultMutableTreeNode nodeBuyWeapons;
	private DefaultTreeModel gearBuyTreeModel;
	private EquipmentClass gearNewCurrent;
	private DefaultMutableTreeNode gearNewCurrentNode;

}