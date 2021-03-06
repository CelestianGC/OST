/*
 * Option_AskFor_Gear.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import static org.ost.main.MyClasses.MyStatics.*;

import org.ost.main.MyClasses.*;
import org.ost.main.MyUtils.*;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Gear extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private PlayerClass pc;
	private DefaultMutableTreeNode nodeRoot;
	private DefaultMutableTreeNode nodeEquipment;
	private DefaultMutableTreeNode nodeWorn;
	private DefaultMutableTreeNode nodeTreasure;
	private DefaultTreeModel gearTreeModel;
	private DefaultMutableTreeNode nodeBuyRoot;
	private DefaultMutableTreeNode nodeBuyEquipment;
	private DefaultMutableTreeNode nodeBuyTreasure;
	private DefaultMutableTreeNode nodeBuyContainers;
	private DefaultMutableTreeNode nodeBuyArmor;
	private DefaultMutableTreeNode nodeBuyWeapons;
	private DefaultTreeModel gearBuyTreeModel;
	private EquipmentClass currentGearNew;
	private DefaultMutableTreeNode gearNewCurrentNode;

	/** Creates new form Option_AskFor_Gear */
	public Option_AskFor_Gear(java.awt.Frame parent, boolean modal,
			MainClass ost, PlayerClass oP) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.pc = oP;
		initComponents();

		if (pc == null) {
			gearTabPanel.remove(gearPanel);
			gearTabPanel.remove(splitBarPanel);

			// these not needed I imagine
			gearScrollPane.setEnabled(false);
			gearTree.setEnabled(false);
			gearNewAddButton.setEnabled(false);
			gearRemoveItButton.setEnabled(false);
			gearBuyTree.setDragEnabled(false);
		} else {
			updatePanels();
		}
		updateGearBuyTree();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);
		//		setSize(370,275);
		//pack();

		setLocationRelativeTo(parent);
		setSize(720, 480);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		gearTabPanel = new javax.swing.JPanel();
		gearPanel = new javax.swing.JPanel();
		gearScrollPane = new javax.swing.JScrollPane();
		gearTree = new javax.swing.JTree();
		gearTree.setCellRenderer(new gearTreeCellRenderer());

		nodeRoot = new DefaultMutableTreeNode("Gear");
		nodeEquipment = new DefaultMutableTreeNode("Equipment");
		nodeWorn = new DefaultMutableTreeNode("Equipped");
		nodeTreasure = new DefaultMutableTreeNode("Treasure");
		gearTreeModel = new DefaultTreeModel(nodeRoot);
		nodeRoot.add(nodeEquipment);
		nodeRoot.add(nodeWorn);
		nodeRoot.add(nodeTreasure);

		adjustButtonPanel = new javax.swing.JPanel();
		chargesAdjustPanel = new javax.swing.JPanel();
		chargesLabel = new javax.swing.JLabel();
		chargesAdjustSpinner = new javax.swing.JSpinner();
		stacksAdjustPanel = new javax.swing.JPanel();
		stacksLabel = new javax.swing.JLabel();
		stacksAdjustSpinner = new javax.swing.JSpinner();
		equipGearButton = new javax.swing.JButton();
		removeGearButton = new javax.swing.JButton();
		splitBarPanel = new javax.swing.JPanel();
		gearNewAddButton = new javax.swing.JButton();
		gearRemoveItButton = new javax.swing.JButton();
		gearBuyPanel = new javax.swing.JPanel();
		gearButtonPanel = new javax.swing.JPanel();
		newGearBuyButton = new javax.swing.JButton();
		copyBuyGearButton = new javax.swing.JButton();
		editBuyGearButton = new javax.swing.JButton();
		deleteBuyGearButton = new javax.swing.JButton();
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

		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Gear");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Gear",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.BorderLayout());

		gearTabPanel.setLayout(new java.awt.GridBagLayout());

		gearPanel.setBackground(new java.awt.Color(0, 0, 0));
		gearPanel.setMinimumSize(new java.awt.Dimension(193, 63));
		gearPanel.setPreferredSize(new java.awt.Dimension(193, 63));
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
		adjustButtonPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT, 0, 0));

		chargesAdjustPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		chargesAdjustPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.CENTER, 0, 0));

		chargesLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chargesLabel.setText("charges");
		chargesAdjustPanel.add(chargesLabel);

		chargesAdjustSpinner.setFont(new java.awt.Font("Segoe UI", 0, 10));
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

		adjustButtonPanel.add(chargesAdjustPanel);

		stacksAdjustPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		stacksAdjustPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.CENTER, 0, 0));

		stacksLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		stacksLabel.setText("stacks");
		stacksAdjustPanel.add(stacksLabel);

		stacksAdjustSpinner.setFont(new java.awt.Font("Segoe UI", 0, 10));
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

		adjustButtonPanel.add(stacksAdjustPanel);

		equipGearButton.setBackground(new java.awt.Color(204, 204, 204));
		equipGearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		equipGearButton.setText("equip");
		equipGearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				equipGearButtonActionPerformed(evt);
			}
		});
		adjustButtonPanel.add(equipGearButton);

		removeGearButton.setBackground(new java.awt.Color(204, 204, 204));
		removeGearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		removeGearButton.setText("remove");
		removeGearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeGearButtonActionPerformed(evt);
			}
		});
		adjustButtonPanel.add(removeGearButton);

		gearPanel.add(adjustButtonPanel, java.awt.BorderLayout.PAGE_END);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gearTabPanel.add(gearPanel, gridBagConstraints);

		splitBarPanel.setBackground(new java.awt.Color(153, 153, 153));
		splitBarPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		splitBarPanel.setLayout(new java.awt.GridBagLayout());

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
		splitBarPanel.add(gearNewAddButton, new java.awt.GridBagConstraints());

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
		splitBarPanel.add(gearRemoveItButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gearTabPanel.add(splitBarPanel, gridBagConstraints);

		gearBuyPanel.setLayout(new java.awt.BorderLayout());

		gearButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		gearButtonPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.RIGHT, 0, 0));

		newGearBuyButton.setBackground(new java.awt.Color(204, 204, 204));
		newGearBuyButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		newGearBuyButton.setText("new");
		newGearBuyButton.setToolTipText("Create new item for equipment list.");
		newGearBuyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newGearBuyButtonActionPerformed(evt);
			}
		});
		gearButtonPanel.add(newGearBuyButton);

		copyBuyGearButton.setBackground(new java.awt.Color(204, 204, 204));
		copyBuyGearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		copyBuyGearButton.setText("copy");
		copyBuyGearButton
				.setToolTipText("Select a piece of equipment and click here to make changes to it.");
		copyBuyGearButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						copyBuyGearButtonActionPerformed(evt);
					}
				});
		gearButtonPanel.add(copyBuyGearButton);

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
		gearButtonPanel.add(editBuyGearButton);

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
		gearButtonPanel.add(deleteBuyGearButton);

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

		mainPanel.add(gearTabPanel, java.awt.BorderLayout.CENTER);

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

	private void copyBuyGearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (currentGearNew != null)
			doNewItem(currentGearNew.clone());

	}

	private void equipGearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		TreePath[] paths = gearTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(gearTree,
					"Are you sure you want to equip ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null
							&& Utils.isEquipment(oNode.getUserObject())) {
						EquipmentClass oE = (EquipmentClass) oNode
								.getUserObject();
						if (oE != null && !oE.isEquipped()) {
							oE.setEquipped(true);
							ost.encounterFrame.removeNode(gearTree,
									(DefaultMutableTreeNode) oNode.getParent(),
									oNode);
							DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(
									oE);
							DefaultMutableTreeNode oMyNode = getNodeByGearType(oE);
							gearTreeModel.insertNodeInto(oNewNode, oMyNode,
									oMyNode.getChildCount());
							Utils.expandPathOnNode(gearTree, oMyNode);
							gearTree.repaint();
						}

					}
				}
			}
		}
	}

	private void removeGearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		gearRemoveItButtonActionPerformed(null);
	}

	private void editBuyGearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (currentGearNew != null) {
			Option_AskFor_Equipment dDialog = new Option_AskFor_Equipment(
					parent, true, ost, currentGearNew);
			dDialog.setVisible(true);
			gearBuyTreeModel.nodeChanged(gearNewCurrentNode);
			gearBuyTree.repaint();
		}
	}

	private void newGearBuyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		EquipmentClass oNew = new EquipmentClass("NewItem",
				"New item description.");
		doNewItem(oNew);
	}

	/**
	 * show edit menu for new or copied item.
	 * @param oNew
	 */
	private void doNewItem(EquipmentClass oNew) {
		Option_AskFor_Equipment dDialog = new Option_AskFor_Equipment(parent,
				true, ost, oNew);
		dDialog.setVisible(true);

		ost.equipmentList.add(oNew);
		DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(oNew);
		DefaultMutableTreeNode oMyNode = getNodeHomeByGearType(oNew);
		gearBuyTreeModel.insertNodeInto(oNewNode, oMyNode,
				oMyNode.getChildCount());
		Utils.expandPathOnNode(gearBuyTree, oMyNode);
		gearBuyTree.repaint();
	}

	private void gearRemoveItButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
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
						pc.getGear().remove(oE);
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
						EquipmentClass oNew = oE.clone();
						pc.getGear().add(oNew);
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

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		formWindowClosed(null);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		updateCurrentValues();
	}

	private void updateCurrentValues() {
	}

	private void updatePanels() {

		//GEAR
		nodeEquipment.removeAllChildren();
		gearTreeModel.reload(nodeEquipment);
		nodeWorn.removeAllChildren();
		gearTreeModel.reload(nodeWorn);
		nodeTreasure.removeAllChildren();
		gearTreeModel.reload(nodeTreasure);
		for (EquipmentClass eQ : pc.getGear()) {
			DefaultMutableTreeNode oNewNode = new DefaultMutableTreeNode(eQ);
			DefaultMutableTreeNode oMyNode = getNodeByGearType(eQ);
			gearTreeModel.insertNodeInto(oNewNode, oMyNode,
					oMyNode.getChildCount());
			Utils.expandPathOnNode(gearTree, oMyNode);
			gearTree.repaint();
		}

	}

	/**
	 * clear out the tree and load up the equipmentList
	 */
	private void updateGearBuyTree() {
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

	private void gearBuyTreeValueChanged(
			javax.swing.event.TreeSelectionEvent evt) {
		TreePath path = evt.getNewLeadSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			gearNewCurrentNode = oNode;
			if (Utils.isEquipment(oNode.getUserObject())) {
				EquipmentClass oE = (EquipmentClass) oNode.getUserObject();
				currentGearNew = oE;
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
		case GEAR_TYPE_SHIELD:
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

		if (oE.isEquipped())
			myRootNode = nodeWorn;

		return (myRootNode);
	}

	private void deleteBuyGearButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
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
	private javax.swing.JPanel adjustButtonPanel;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JPanel chargesAdjustPanel;
	private javax.swing.JSpinner chargesAdjustSpinner;
	private javax.swing.JLabel chargesLabel;
	private javax.swing.JButton copyBuyGearButton;
	private javax.swing.JButton deleteBuyGearButton;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton editBuyGearButton;
	private javax.swing.JButton equipGearButton;
	private javax.swing.JPanel gearButtonPanel;
	private javax.swing.JPanel gearBuyPanel;
	private javax.swing.JScrollPane gearBuyScrollPane;
	private javax.swing.JTree gearBuyTree;
	private javax.swing.JButton gearNewAddButton;
	private javax.swing.JPanel gearPanel;
	private javax.swing.JButton gearRemoveItButton;
	private javax.swing.JScrollPane gearScrollPane;
	private javax.swing.JPanel gearTabPanel;
	private javax.swing.JTree gearTree;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JButton newGearBuyButton;
	private javax.swing.JButton removeGearButton;
	private javax.swing.JPanel splitBarPanel;
	private javax.swing.JPanel stacksAdjustPanel;
	private javax.swing.JSpinner stacksAdjustSpinner;
	private javax.swing.JLabel stacksLabel;
	// End of variables declaration//GEN-END:variables
}