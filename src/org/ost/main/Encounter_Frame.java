/*
 * Encounter_Frame.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.jdom.Document;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.DungeonList;
import org.ost.main.MyClasses.DungeonRoom;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.StatesClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.XMLControl;

/**
 * 
 * @author __USER__
 */
public class Encounter_Frame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	/** Creates new form Encounter_Frame */
	public Encounter_Frame(MainClass ost) {
		this.ost = ost;
		initComponents();
		// set default location to middle of screen
		setLocationRelativeTo(null);

		iRoundCounter = 0;
		iTurnCounter = 1;
		iInitCounter = 1;
		iRoomCounter = -1;
		// creatureEncounterModel = (DefaultListModel) creatureEncounterList
		// .getModel();
		buildEncounterList();

		// set colors on the tree
		dungeonCell = (DefaultTreeCellRenderer) encountersTree
				.getCellRenderer();
		dungeonCell.setTextSelectionColor(new Color(51, 255, 0));
		dungeonCell.setTextNonSelectionColor(new Color(255, 255, 255));
		dungeonCell.setBackgroundNonSelectionColor(Color.BLACK);
		dungeonCell.setBackgroundSelectionColor(Color.BLACK);
		buildDungeonTree();

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		dungeonTreePopupMenu = new javax.swing.JPopupMenu();
		dungeonNameMenuItem = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		dungeonEditRoomMenuItem = new javax.swing.JMenuItem();
		dungeonDeleteRoomMenuItem = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JSeparator();
		dungeonCancelMenuItem = new javax.swing.JMenuItem();
		clearButton = new javax.swing.JButton();
		DISABLEDexpandTreeHandlesPanel = new javax.swing.JPanel();
		encountersExpansionToggleButton = new javax.swing.JToggleButton();
		encounterWindowScrollPane = new javax.swing.JScrollPane();
		encountersSplitPane = new javax.swing.JSplitPane();
		encountersPanel = new javax.swing.JPanel();
		encountersTreeScrollPane = new javax.swing.JScrollPane();
		nodeRootEncounters = new DefaultMutableTreeNode("Encounters");
		nodePC = new DefaultMutableTreeNode("Party");
		nodeNPC = new DefaultMutableTreeNode("NPC");
		nodeDungeons = new DefaultMutableTreeNode("Dungeons");
		encountersTreeModel = new DefaultTreeModel(nodeRootEncounters);
		nodeRootEncounters.add(nodePC);
		nodeRootEncounters.add(nodeNPC);
		nodeRootEncounters.add(nodeDungeons);
		encountersTree = new javax.swing.JTree();
		encountersTree.setTransferHandler(new myTransferHandler());
		savedCreaturesButtonPanel = new javax.swing.JPanel();
		encountersButtonPanel = new javax.swing.JPanel();
		killButton = new javax.swing.JButton();
		nameButton = new javax.swing.JButton();
		tagButton = new javax.swing.JButton();
		hpEditButton = new javax.swing.JButton();
		acEditButton = new javax.swing.JButton();
		peaceSelectedButton = new javax.swing.JButton();
		peaceAllButton = new javax.swing.JButton();
		dungeonButtonsPanel = new javax.swing.JPanel();
		dungeonAddRoomButton = new javax.swing.JButton();
		dungeonClearButton = new javax.swing.JButton();
		dungeonResetRoomButton = new javax.swing.JButton();
		dungeonSaveButton = new javax.swing.JButton();
		dungeonLoadButton = new javax.swing.JButton();
		dungeonDeleteRoomButton = new javax.swing.JButton();
		dungeonCloneButton = new javax.swing.JButton();
		dungeonFightButton = new javax.swing.JButton();
		encountersTabbedPane = new javax.swing.JTabbedPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		creatureEncounterDisplayPanel = new javax.swing.JPanel();
		encountFramebuttonPanel = new javax.swing.JPanel();
		resetTurnButton = new javax.swing.JButton();
		encounterTurnCounterLabel = new javax.swing.JLabel();
		nextTurnButton = new javax.swing.JButton();
		encounterResetButton = new javax.swing.JButton();
		encounterRoundTrackerLabel = new javax.swing.JLabel();
		nextRoundButton = new javax.swing.JButton();
		initRollButton = new javax.swing.JButton();
		initLabel = new javax.swing.JLabel();
		initNextButton = new javax.swing.JButton();

		dungeonNameMenuItem.setText("Item");
		dungeonNameMenuItem.setEnabled(false);
		dungeonTreePopupMenu.add(dungeonNameMenuItem);
		dungeonTreePopupMenu.add(jSeparator1);

		dungeonEditRoomMenuItem.setText("Edit Room Name");
		dungeonEditRoomMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonEditRoomMenuItemActionPerformed(evt);
					}
				});
		dungeonTreePopupMenu.add(dungeonEditRoomMenuItem);

		dungeonDeleteRoomMenuItem.setText("Delete Room");
		dungeonDeleteRoomMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonDeleteRoomMenuItemActionPerformed(evt);
					}
				});
		dungeonTreePopupMenu.add(dungeonDeleteRoomMenuItem);
		dungeonTreePopupMenu.add(jSeparator2);

		dungeonCancelMenuItem.setText("Cancel");
		dungeonTreePopupMenu.add(dungeonCancelMenuItem);

		clearButton.setBackground(new java.awt.Color(204, 204, 204));
		clearButton.setFont(new java.awt.Font("Segoe UI", 0, 8));
		clearButton.setText("clear");
		clearButton.setToolTipText("Remove all encounters.");
		clearButton.setName("clearButton");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});

		DISABLEDexpandTreeHandlesPanel.setBackground(new java.awt.Color(204,
				204, 204));
		DISABLEDexpandTreeHandlesPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Any",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));
		DISABLEDexpandTreeHandlesPanel.setLayout(new java.awt.GridBagLayout());

		encountersExpansionToggleButton.setBackground(new java.awt.Color(204,
				204, 204));
		encountersExpansionToggleButton.setFont(new java.awt.Font("Segoe UI",
				0, 10));
		encountersExpansionToggleButton.setText("expand");
		encountersExpansionToggleButton
				.setToolTipText("Toggle expansion of room contents.");
		encountersExpansionToggleButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						encountersExpansionToggleButtonActionPerformed(evt);
					}
				});
		DISABLEDexpandTreeHandlesPanel.add(encountersExpansionToggleButton,
				new java.awt.GridBagConstraints());

		setTitle("Encounters");
		setMinimumSize(new java.awt.Dimension(900, 700));
		setName("Form");

		encountersSplitPane.setBorder(javax.swing.BorderFactory
				.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		encountersSplitPane.setDividerLocation(280);
		encountersSplitPane.setName("encountersSplitPane");
		encountersSplitPane.setPreferredSize(new java.awt.Dimension(1100, 560));

		encountersPanel.setName("encountersPanel");
		encountersPanel.setLayout(new java.awt.BorderLayout());

		encountersTree.setBackground(new java.awt.Color(0, 0, 0));
		encountersTree.setFont(new java.awt.Font("Tahoma", 0, 12));
		encountersTree
				.setToolTipText("Drag and drop creatures into rooms or from rooms to encounter list.");
		encountersTree.setCellRenderer(new savedEncountersCellRendererTree());
		encountersTree.setDragEnabled(true);
		encountersTree.setDropMode(DropMode.ON_OR_INSERT);
		encountersTree.setFocusTraversalPolicyProvider(true);
		encountersTree.setModel(encountersTreeModel);
		encountersTree.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				encountersTreeMousePressed(evt);
			}
		});
		encountersTree
				.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
					public void valueChanged(
							javax.swing.event.TreeSelectionEvent evt) {
						encountersTreeValueChanged(evt);
					}
				});
		encountersTreeScrollPane.setViewportView(encountersTree);

		encountersPanel.add(encountersTreeScrollPane,
				java.awt.BorderLayout.CENTER);

		savedCreaturesButtonPanel.setBackground(new java.awt.Color(204, 204,
				204));
		savedCreaturesButtonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		savedCreaturesButtonPanel.setName("savedCreaturesButtonPanel");
		savedCreaturesButtonPanel.setLayout(new java.awt.GridBagLayout());

		encountersButtonPanel.setBackground(new java.awt.Color(204, 204, 204));
		encountersButtonPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						javax.swing.BorderFactory
								.createBevelBorder(javax.swing.border.BevelBorder.LOWERED),
						"Encounters",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));
		encountersButtonPanel.setLayout(new java.awt.GridBagLayout());

		killButton.setBackground(new java.awt.Color(204, 204, 204));
		killButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		killButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Red-Skull-icon-24.png"))); // NOI18N
		killButton.setText("kill ");
		killButton
				.setToolTipText("Remove the currently selected creature(s)/player(s).");
		killButton.setBorderPainted(false);
		killButton.setContentAreaFilled(false);
		killButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		killButton.setName("killButton");
		killButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				killButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(killButton, gridBagConstraints);

		nameButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Baby-icon-24.png"))); // NOI18N
		nameButton.setText("name");
		nameButton.setToolTipText("Rename this creature/player.");
		nameButton.setBorderPainted(false);
		nameButton.setContentAreaFilled(false);
		nameButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		nameButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(nameButton, gridBagConstraints);

		tagButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tagButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/blue-tag-icon-24.png"))); // NOI18N
		tagButton.setText("tag ");
		tagButton.setToolTipText("Add/edit [TAG] on creature/player.");
		tagButton.setBorderPainted(false);
		tagButton.setContentAreaFilled(false);
		tagButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		tagButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tagButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(tagButton, gridBagConstraints);

		hpEditButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		hpEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/orbz-life-icon-24.png"))); // NOI18N
		hpEditButton.setText("hp  ");
		hpEditButton
				.setToolTipText("Edit creature/player's total hit point value.");
		hpEditButton.setBorderPainted(false);
		hpEditButton.setContentAreaFilled(false);
		hpEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		hpEditButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hpEditButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(hpEditButton, gridBagConstraints);

		acEditButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		acEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/virus-protection-icon-24.png"))); // NOI18N
		acEditButton.setText("armor");
		acEditButton
				.setToolTipText("Edit creature/player's Armor Class value.");
		acEditButton.setBorderPainted(false);
		acEditButton.setContentAreaFilled(false);
		acEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		acEditButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				acEditButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(acEditButton, gridBagConstraints);

		peaceSelectedButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		peaceSelectedButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Yoshi-Flower-icon-24.png"))); // NOI18N
		peaceSelectedButton.setText("calm");
		peaceSelectedButton
				.setToolTipText("Clear fighting for selected players and creatures.");
		peaceSelectedButton.setBorderPainted(false);
		peaceSelectedButton.setContentAreaFilled(false);
		peaceSelectedButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		peaceSelectedButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						peaceSelectedButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(peaceSelectedButton, gridBagConstraints);

		peaceAllButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		peaceAllButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Retro-Flower-Yoshi-icon-24.png"))); // NOI18N
		peaceAllButton.setText("peace");
		peaceAllButton.setToolTipText("Clear out all fighting.");
		peaceAllButton.setBorderPainted(false);
		peaceAllButton.setContentAreaFilled(false);
		peaceAllButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		peaceAllButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				peaceAllButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		encountersButtonPanel.add(peaceAllButton, gridBagConstraints);

		savedCreaturesButtonPanel.add(encountersButtonPanel,
				new java.awt.GridBagConstraints());

		dungeonButtonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		dungeonButtonsPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						javax.swing.BorderFactory
								.createBevelBorder(javax.swing.border.BevelBorder.LOWERED),
						"Dungeon",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));
		dungeonButtonsPanel.setLayout(new java.awt.GridBagLayout());

		dungeonAddRoomButton.setBackground(new java.awt.Color(204, 204, 204));
		dungeonAddRoomButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonAddRoomButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Actions-list-add-icon-24.png"))); // NOI18N
		dungeonAddRoomButton.setText("add ");
		dungeonAddRoomButton.setToolTipText("Add a new room to the dungeon.");
		dungeonAddRoomButton.setBorderPainted(false);
		dungeonAddRoomButton.setContentAreaFilled(false);
		dungeonAddRoomButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonAddRoomButton.setName("dungeonAddRoomButton");
		dungeonAddRoomButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonAddRoomButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonAddRoomButton, gridBagConstraints);

		dungeonClearButton.setBackground(new java.awt.Color(204, 204, 204));
		dungeonClearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonClearButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Actions-window-close-icon-24.png"))); // NOI18N
		dungeonClearButton.setText("clear");
		dungeonClearButton.setToolTipText("Remove ALL rooms.");
		dungeonClearButton.setBorderPainted(false);
		dungeonClearButton.setContentAreaFilled(false);
		dungeonClearButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonClearButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonClearButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonClearButton, gridBagConstraints);

		dungeonResetRoomButton.setBackground(new java.awt.Color(204, 204, 204));
		dungeonResetRoomButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonResetRoomButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Button-Turn-Off-icon-24.png"))); // NOI18N
		dungeonResetRoomButton.setText("reset");
		dungeonResetRoomButton.setToolTipText("Reset room counter.");
		dungeonResetRoomButton.setBorderPainted(false);
		dungeonResetRoomButton.setContentAreaFilled(false);
		dungeonResetRoomButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonResetRoomButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonResetRoomButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonResetRoomButton, gridBagConstraints);

		dungeonSaveButton.setBackground(new java.awt.Color(204, 204, 204));
		dungeonSaveButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonSaveButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/piggy-bank-icon-24.png"))); // NOI18N
		dungeonSaveButton.setText("save");
		dungeonSaveButton.setToolTipText("Save dungeon to file.");
		dungeonSaveButton.setBorderPainted(false);
		dungeonSaveButton.setContentAreaFilled(false);
		dungeonSaveButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonSaveButton.setName("dungeonSaveButton");
		dungeonSaveButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonSaveButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonSaveButton, gridBagConstraints);

		dungeonLoadButton.setBackground(new java.awt.Color(204, 204, 204));
		dungeonLoadButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonLoadButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/G12-Book-4-icon-24.png"))); // NOI18N
		dungeonLoadButton.setText("load");
		dungeonLoadButton.setToolTipText("Load dungeon rooms from file.");
		dungeonLoadButton.setBorderPainted(false);
		dungeonLoadButton.setContentAreaFilled(false);
		dungeonLoadButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonLoadButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonLoadButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonLoadButton, gridBagConstraints);

		dungeonDeleteRoomButton
				.setBackground(new java.awt.Color(204, 204, 204));
		dungeonDeleteRoomButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonDeleteRoomButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/Status-dialog-error-icon-24.png"))); // NOI18N
		dungeonDeleteRoomButton.setText("cut  ");
		dungeonDeleteRoomButton
				.setToolTipText("Cut out creatures or rooms and any contents it might have.");
		dungeonDeleteRoomButton.setBorderPainted(false);
		dungeonDeleteRoomButton.setContentAreaFilled(false);
		dungeonDeleteRoomButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonDeleteRoomButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonDeleteRoomButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonDeleteRoomButton, gridBagConstraints);

		dungeonCloneButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonCloneButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/blood-drop-icon-16.png"))); // NOI18N
		dungeonCloneButton.setText("clone");
		dungeonCloneButton
				.setToolTipText("Copy selected creatures to the encounter.");
		dungeonCloneButton.setBorderPainted(false);
		dungeonCloneButton.setContentAreaFilled(false);
		dungeonCloneButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonCloneButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonCloneButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		dungeonButtonsPanel.add(dungeonCloneButton, gridBagConstraints);

		dungeonFightButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dungeonFightButton.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/blood-icon-black-24.png"))); // NOI18N
		dungeonFightButton.setText("fight");
		dungeonFightButton
				.setToolTipText("Move selected creatures to the encounter.");
		dungeonFightButton.setBorderPainted(false);
		dungeonFightButton.setContentAreaFilled(false);
		dungeonFightButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		dungeonFightButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dungeonFightButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		dungeonButtonsPanel.add(dungeonFightButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		savedCreaturesButtonPanel.add(dungeonButtonsPanel, gridBagConstraints);

		encountersPanel.add(savedCreaturesButtonPanel,
				java.awt.BorderLayout.WEST);

		encountersSplitPane.setLeftComponent(encountersPanel);

		encountersTabbedPane.setBackground(new java.awt.Color(204, 204, 204));
		encountersTabbedPane.setName("encountersTabbedPane");

		creatureEncounterDisplayPanel.setBackground(new java.awt.Color(204,
				204, 204));
		creatureEncounterDisplayPanel.setName("creatureEncounterDisplayPanel");
		creatureEncounterDisplayPanel.setLayout(new java.awt.GridLayout(0, 1));
		jScrollPane1.setViewportView(creatureEncounterDisplayPanel);

		encountersTabbedPane.addTab("Encounters", jScrollPane1);

		encountersSplitPane.setRightComponent(encountersTabbedPane);

		encounterWindowScrollPane.setViewportView(encountersSplitPane);

		getContentPane().add(encounterWindowScrollPane,
				java.awt.BorderLayout.CENTER);

		encountFramebuttonPanel
				.setBackground(new java.awt.Color(153, 153, 153));
		encountFramebuttonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		encountFramebuttonPanel
				.setMaximumSize(new java.awt.Dimension(32767, 23));
		encountFramebuttonPanel.setName("encountFramebuttonPanel");
		encountFramebuttonPanel.setLayout(new java.awt.GridLayout(1, 0));

		resetTurnButton.setBackground(new java.awt.Color(204, 204, 204));
		resetTurnButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		resetTurnButton.setText("Reset Turn");
		resetTurnButton.setToolTipText("Reset Turn tracking.");
		resetTurnButton.setName("resetTurnButton");
		resetTurnButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetTurnButtonActionPerformed(evt);
			}
		});
		encountFramebuttonPanel.add(resetTurnButton);

		encounterTurnCounterLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		encounterTurnCounterLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		encounterTurnCounterLabel.setText("Turn 1");
		encounterTurnCounterLabel
				.setToolTipText("Turn is 10 minutes. Useful for tracking durations of spells/items.");
		encounterTurnCounterLabel.setName("encounterTurnCounterLabel");
		encountFramebuttonPanel.add(encounterTurnCounterLabel);

		nextTurnButton.setBackground(new java.awt.Color(204, 204, 204));
		nextTurnButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nextTurnButton.setText("Next Turn");
		nextTurnButton.setName("nextTurnButton");
		nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextTurnButtonActionPerformed(evt);
			}
		});
		encountFramebuttonPanel.add(nextTurnButton);

		encounterResetButton.setBackground(new java.awt.Color(204, 204, 204));
		encounterResetButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		encounterResetButton.setText("New Encounter");
		encounterResetButton
				.setToolTipText("Reset the round tracker and start initiative.");
		encounterResetButton.setName("encounterResetButton");
		encounterResetButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						encounterResetButtonActionPerformed(evt);
					}
				});
		encountFramebuttonPanel.add(encounterResetButton);

		encounterRoundTrackerLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		encounterRoundTrackerLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		encounterRoundTrackerLabel.setText("Round 1");
		encounterRoundTrackerLabel
				.setToolTipText("Round tracker for this encounter.");
		encounterRoundTrackerLabel.setName("encounterRoundTrackerLabel");
		encountFramebuttonPanel.add(encounterRoundTrackerLabel);

		nextRoundButton.setBackground(new java.awt.Color(204, 204, 204));
		nextRoundButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nextRoundButton.setText("Next Round");
		nextRoundButton.setName("nextRoundButton");
		nextRoundButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextRoundButtonActionPerformed(evt);
			}
		});
		encountFramebuttonPanel.add(nextRoundButton);

		initRollButton.setBackground(new java.awt.Color(204, 204, 204));
		initRollButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		initRollButton.setText("Roll Initiative");
		initRollButton
				.setToolTipText("Roll initiative dice for all creatures in encounter and sort by order.");
		initRollButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initRollButtonActionPerformed(evt);
			}
		});
		encountFramebuttonPanel.add(initRollButton);

		initLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		initLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		initLabel.setText("Init 1");
		encountFramebuttonPanel.add(initLabel);

		initNextButton.setBackground(new java.awt.Color(204, 204, 204));
		initNextButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		initNextButton.setText("Next Init");
		initNextButton
				.setToolTipText("Proceed to next creature or characters initiative action.");
		initNextButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initNextButtonActionPerformed(evt);
			}
		});
		encountFramebuttonPanel.add(initNextButton);

		getContentPane().add(encountFramebuttonPanel,
				java.awt.BorderLayout.PAGE_END);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void dungeonFightButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		TreePath[] paths = encountersTree.getSelectionPaths();
		if (paths != null)
			for (int i = 0; i < paths.length; i++) {
				DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
						.getLastPathComponent();
				if (nodeDungeons.isNodeDescendant(oNode)
						&& Utils.isNPC(oNode.getUserObject())) {
					encountersTreeModel.removeNodeFromParent(oNode);
					copyNode(encountersTree, nodeNPC, oNode,
							nodeNPC.getChildCount());
					CreatureClass oC = (CreatureClass) oNode.getUserObject();
					// add creature to fighting array
					ost.fightingCreatureList.add(oC);
				}
			}
	}

	@SuppressWarnings("unchecked")
	private void peaceAllButtonActionPerformed(java.awt.event.ActionEvent evt) {

		// creatures
		ArrayList<DefaultMutableTreeNode> nodeList = Collections.list(nodeNPC
				.children());
		Iterator<DefaultMutableTreeNode> nodesIterator = nodeList.iterator();
		while (nodesIterator.hasNext()) {
			DefaultMutableTreeNode oNode = nodesIterator.next();
			removeFightingOnMe(oNode);
		}
		// players
		ArrayList<DefaultMutableTreeNode> pcnodeList = Collections.list(nodePC
				.children());
		Iterator<DefaultMutableTreeNode> pcnodesIterator = pcnodeList
				.iterator();
		while (pcnodesIterator.hasNext()) {
			DefaultMutableTreeNode oNode = pcnodesIterator.next();
			removeFightingOnMe(oNode);
		}

	}

	/**
	 * remove fighting nodes from this node
	 * 
	 * @param oNode
	 */
	private void removeFightingOnMe(DefaultMutableTreeNode oNode) {
		if (Utils.isPC(oNode.getUserObject()) && !oNode.isLeaf()) {
			PlayerClass oP = (PlayerClass) oNode.getUserObject();
			oP.getFightingList().clear();
			oP.getFightingNode().removeAllChildren();
			encountersTreeModel.removeNodeFromParent(oP.getFightingNode());
			encountersTreeModel.nodeChanged(oNode);
		} else if (Utils.isNPC(oNode.getUserObject()) && !oNode.isLeaf()) {
			CreatureClass oC = (CreatureClass) oNode.getUserObject();
			oC.getFightingList().clear();
			oC.getFightingNode().removeAllChildren();
			encountersTreeModel.removeNodeFromParent(oC.getFightingNode());
			encountersTreeModel.nodeChanged(oNode);
		}
	}

	private void peaceSelectedButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		TreePath[] paths = encountersTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(peaceSelectedButton,
					"Are you sure you want to clear fighting on ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null && nodeNPC.isNodeDescendant(oNode)
							&& Utils.isNPC(oNode.getUserObject())) {
						removeFightingOnMe(oNode);
					} else if (oNode != null && nodePC.isNodeDescendant(oNode)
							&& Utils.isPC(oNode.getUserObject())) {
						removeFightingOnMe(oNode);
					}
				}
			}
		}

		encountersTreeSetSelected();

	}

	private void dungeonCloneButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		TreePath[] paths = encountersTree.getSelectionPaths();
		if (paths != null)
			for (int i = 0; i < paths.length; i++) {
				DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
						.getLastPathComponent();
				if (nodeDungeons.isNodeDescendant(oNode)
						&& Utils.isNPC(oNode.getUserObject())) {
					DefaultMutableTreeNode copiedNode = myNodeCopy(oNode);
					CreatureClass oC = (CreatureClass) copiedNode
							.getUserObject();
					copiedNode.setUserObject(oC.cloneMe());
					ost.dprint("Adding to fight :" + oC.getName() + "\n");

					copyNode(encountersTree, nodeNPC, copiedNode,
							nodeNPC.getChildCount());
					// add creature to fighting array
					ost.fightingCreatureList.add((CreatureClass) copiedNode
							.getUserObject());
				}
			}
	}

	private void acEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultMutableTreeNode oNode = getSelectedNode(encountersTree);
		if (oNode != null && Utils.isNPC(oNode.getUserObject())) {
			CreatureClass oC = (CreatureClass) oNode.getUserObject();
			oC.Encountered.acEditMenuItemActionPerformed(null);
		} else if (oNode != null && Utils.isPC(oNode.getUserObject())) {
			PlayerClass oC = (PlayerClass) oNode.getUserObject();
			oC.Encountered.acEditMenuItemActionPerformed(null);
		}

	}

	private void hpEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultMutableTreeNode oNode = getSelectedNode(encountersTree);
		if (oNode != null && oNode.getUserObject() instanceof CreatureClass) {
			CreatureClass oC = (CreatureClass) oNode.getUserObject();
			oC.Encountered.hpEditMenuItemActionPerformed(null);
		} else if (oNode != null && Utils.isPC(oNode.getUserObject())) {
			PlayerClass oC = (PlayerClass) oNode.getUserObject();
			oC.Encountered.hpEditMenuItemActionPerformed(null);
		}

	}

	private void tagButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultMutableTreeNode oNode = getSelectedNode(encountersTree);
		if (oNode != null && oNode.getUserObject() instanceof CreatureClass) {
			CreatureClass oC = (CreatureClass) oNode.getUserObject();
			oC.Encountered.creatureTagAddMenuItemActionPerformed(null);
		} else if (oNode != null && Utils.isPC(oNode.getUserObject())) {
			PlayerClass oC = (PlayerClass) oNode.getUserObject();
			oC.Encountered.tagAddMenuItemActionPerformed(null);
		}
	}

	private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultMutableTreeNode oNode = getSelectedNode(encountersTree);
		if (oNode != null && Utils.isNPC(oNode.getUserObject())) {
			CreatureClass oC = (CreatureClass) oNode.getUserObject();
			oC.Encountered.creatureNameEditMenuItemActionPerformed(null);
		} else if (oNode != null && Utils.isPC(oNode.getUserObject())) {
			PlayerClass oC = (PlayerClass) oNode.getUserObject();
			oC.Encountered.nameEditMenuItemActionPerformed(null);
		}
	}

	/**
	 * return the last node selected.
	 * 
	 * @param tree
	 * @return
	 */
	public DefaultMutableTreeNode getSelectedNode(JTree tree) {
		DefaultMutableTreeNode oNode = null;
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			oNode = (DefaultMutableTreeNode) path.getLastPathComponent();
		}

		return (oNode);
	}

	private void dungeonDeleteRoomButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		dungeonDeleteRoomMenuItemActionPerformed(null);
	}

	private void encountersExpansionToggleButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (encountersExpansionToggleButton.isSelected()) {
			expandAll(encountersTree, true);
		} else {
			expandAll(encountersTree, false);
		}
	}

	private void encountersTreeValueChanged(
			javax.swing.event.TreeSelectionEvent evt) {
		TreePath path = evt.getNewLeadSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (Utils.isPC(oNode.getUserObject())) { // load selected PC
				PlayerClass oP = (PlayerClass) oNode.getUserObject();
				loadEncounterObjectFromList(oP);
			} else if (!nodeDungeons.isNodeDescendant(oNode)) {
				if (Utils.isNPC(oNode.getUserObject())) { // load selected NPC
					CreatureClass oC = (CreatureClass) oNode.getUserObject();
					loadEncounterObjectFromList(oC);
				}
			} else if (nodeDungeons.isNodeDescendant(oNode)) {
				if (Utils.isDungeon(oNode.getUserObject())) {
					DungeonRoom dR = (DungeonRoom) oNode.getUserObject();
					loadEncounterObjectFromList(dR);
				}
			}
		}
	}

	private void encountersTreeMousePressed(java.awt.event.MouseEvent evt) {
		TreePath path = encountersTree.getSelectionPath();
		if (evt.getButton() == MouseEvent.BUTTON1 && path != null) { // left
																		// click
			// handled by tree event change
		} else if (evt.getButton() == MouseEvent.BUTTON3 && path != null) { // right
																			// click
			DefaultMutableTreeNode editNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (nodeDungeons.isNodeDescendant(editNode)) {
				if (editNode.getUserObject() instanceof DungeonRoom) {
					DungeonRoom dR = (DungeonRoom) editNode.getUserObject();
					dungeonNameMenuItem.setText(dR.getName());
					dungeonTreePopupMenu.show(encountersTree, evt.getX(),
							evt.getY());
				}
			}
		}
	}

	private void initNextButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int initPrevious = iInitCounter;
		if (ost.initAscending)
			iInitCounter++;
		else
			iInitCounter--;

		initLabel.setText("Init " + iInitCounter);
		setCreatureInitiativeSelected(initPrevious);
	}

	private void initRollButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// push round counter up, reset attacks/etc
		nextRoundButtonActionPerformed(null);
	}

	/**
	 * 
	 * @author Celestian
	 * 
	 */
	private class sortNodesByInit implements Comparator<Object> {
		public int compare(Object inc1, Object inc2) {
			DefaultMutableTreeNode o1 = (DefaultMutableTreeNode) inc1;
			DefaultMutableTreeNode o2 = (DefaultMutableTreeNode) inc2;
			if (Utils.isNPC(o1.getUserObject())
					&& Utils.isNPC(o2.getUserObject())) {
				CreatureClass oC1 = (CreatureClass) o1.getUserObject();
				CreatureClass oC2 = (CreatureClass) o2.getUserObject();
				if (ost.initAscending)
					return (oC1.initRoll < oC2.initRoll ? -1
							: (oC1.initRoll == oC2.initRoll ? 0 : 1));
				else
					return (oC1.initRoll > oC2.initRoll ? -1
							: (oC1.initRoll == oC2.initRoll ? 0 : 1));
			} else if (Utils.isPC(o1.getUserObject())
					&& Utils.isPC(o2.getUserObject())) {
				PlayerClass oC1 = (PlayerClass) o1.getUserObject();
				PlayerClass oC2 = (PlayerClass) o2.getUserObject();
				if (ost.initAscending)
					return (oC1.initRoll < oC2.initRoll ? -1
							: (oC1.initRoll == oC2.initRoll ? 0 : 1));
				else
					return (oC1.initRoll > oC2.initRoll ? -1
							: (oC1.initRoll == oC2.initRoll ? 0 : 1));
			} else {
				ost.dprint("sortNodesByInit(): Unknown\n");
				return (0);
			}
		}

	}

	/**
	 * set selected to next person in init
	 * 
	 * @param initPrevious
	 */
	private void setCreatureInitiativeSelected(int initPrevious) {
		for (CreatureClass oT : ost.fightingCreatureList) {
			if (ost.initAscending) { // ascending init
				if (oT.getInitRoll() <= iInitCounter
						&& oT.getInitRoll() > initPrevious) {
					setSelectedNodeByObject(encountersTree,
							encountersTreeModel, nodeNPC, oT);
					break;
				}
				// descending init
			} else {
				if (oT.getInitRoll() >= iInitCounter
						&& oT.getInitRoll() < initPrevious) {
					setSelectedNodeByObject(encountersTree,
							encountersTreeModel, nodeNPC, oT);
					break;
				}
			}

		}

		// we check players last so we default to them on select
		for (PlayerClass oT : ost.fightingPlayerList) {
			if (ost.initAscending) // ascneding init
				if (oT.getInitRoll() <= iInitCounter
						&& oT.getInitRoll() > initPrevious) {
					setSelectedNodeByObject(encountersTree,
							encountersTreeModel, nodePC, oT);
					break;
				} else // descending init
				if (oT.getInitRoll() >= iInitCounter
						&& oT.getInitRoll() < initPrevious) {
					setSelectedNodeByObject(encountersTree,
							encountersTreeModel, nodePC, oT);
					break;
				}
		}

		// select something if nothing selected.
		//		TreePath path = encountersTree.getSelectionPath();
		//		if (path != null) {
		//			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) path
		//					.getLastPathComponent();
		//			if (oNode == null && !ost.fightingCreatureList.isEmpty()) {
		//				setSelectedNodeByObject(encountersTree, encountersTreeModel,
		//						nodeNPC, ost.fightingCreatureList.get(0));
		//			} else if (oNode == null && !ost.fightingPlayerList.isEmpty()) {
		//				setSelectedNodeByObject(encountersTree, encountersTreeModel,
		//						nodePC, ost.fightingPlayerList.get(0));
		//			}
		//		}
	}

	/**
	 * set node selected in tree by the object we want
	 * 
	 * @param tree
	 * @param tModel
	 * @param oMaster
	 * @param oFind
	 */
	private void setSelectedNodeByObject(JTree tree, DefaultTreeModel tModel,
			DefaultMutableTreeNode oMaster, Object oFind) {

		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(tModel, oMaster, oFind);
		if (oN != null)
			tree.setSelectionPath(new TreePath(oN.getPath()));
	}

	private void dungeonDeleteRoomMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		TreePath[] paths = encountersTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(killButton,
					"Are you sure you want to cut out ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (nodeDungeons.isNodeDescendant(oNode))
						encountersTreeModel.removeNodeFromParent(oNode);
				}
			}
		}
	}

	private void dungeonEditRoomMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		TreePath path = encountersTree.getSelectionPath();
		if (path != null) {
			DefaultMutableTreeNode editNode = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			if (editNode.getUserObject() instanceof DungeonRoom) {
				DungeonRoom dR = (DungeonRoom) editNode.getUserObject();
				String newRoomName = SimpleDialog
						.showQuestion(encountersTree, "What is new room name?",
								"New Room Name", dR.getName());
				dR.setName(newRoomName);
				if (dR.getEncountered() != null) {
					dR.getEncountered().dungeonTitleBorder.setTitle(String
							.format("%s", dR.getName()));
					dR.getEncountered().repaint();
				}
				encountersTreeModel.nodeChanged(editNode);
			}
		}
	}

	private void dungeonResetRoomButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		iRoomCounter = -1;
		checkRoomCounter();
	}

	/**
	 * clone all CreatureClass getUserObjects() in this node/tree of nodes
	 * 
	 * @param thisNode
	 * @return
	 */
	public DefaultMutableTreeNode cloneCreaturesInNode(
			DefaultMutableTreeNode thisNode) {
		if (Utils.isNPC(thisNode.getUserObject())) {
			CreatureClass oC = (CreatureClass) thisNode.getUserObject();
			thisNode.setUserObject(oC.cloneMe());
		}
		if (!thisNode.isLeaf()) {
			for (int i = 0; i < thisNode.getChildCount(); i++) {
				DefaultMutableTreeNode oN = (DefaultMutableTreeNode) thisNode
						.getChildAt(i);
				cloneCreaturesInNode(oN);
			}
		} else {
		}
		return thisNode;
	}

	/**
	 * 
	 * @param oldNode
	 * @return
	 */
	public DefaultMutableTreeNode myNodeCopy(DefaultMutableTreeNode oldNode) {
		DefaultMutableTreeNode newNode = null;
		// make sure to clone creature objects or they are all the same
		// if (oldNode.getUserObject() instanceof CreatureClass) {
		// CreatureClass oC = (CreatureClass) oldNode.getUserObject();
		// newNode = new DefaultMutableTreeNode(oC.cloneMe());
		// } else
		newNode = new DefaultMutableTreeNode(oldNode.getUserObject());

		// this is to snag any sub-nodes recursively
		if (!oldNode.isLeaf()) {
			for (int i = 0; i < oldNode.getChildCount(); i++) {
				DefaultMutableTreeNode oN = (DefaultMutableTreeNode) oldNode
						.getChildAt(i);
				DefaultMutableTreeNode subNode = myNodeCopy(oN);
				newNode.insert(subNode, i);
			}
		}
		return newNode;
	}

	/**
	 * remove a node
	 * 
	 * @param parent
	 * @param removeNode
	 */
	public void removeNode(JTree tree, DefaultMutableTreeNode parent,
			DefaultMutableTreeNode removeNode) {

		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

		if (removeNode.getChildCount() > 0)
			for (int i = 0; i < removeNode.getChildCount(); i++)
				removeNode(tree, removeNode,
						(DefaultMutableTreeNode) removeNode.getChildAt(i));

		int removeIndxs[] = { parent.getIndex(removeNode) };
		Object[] removedChilds = { removeNode };

		parent.remove(removeNode);
		model.nodesWereRemoved(parent, removeIndxs, removedChilds);
	}

	/**
	 * copy a node, not really a copy, you must copy the node, this just does
	 * not move the node
	 * 
	 * @param tree
	 * @param rootNode
	 * @param moveNode
	 * @param newIndex
	 */
	public void copyNode(JTree tree, DefaultMutableTreeNode rootNode,
			DefaultMutableTreeNode moveNode, int newIndex) {
		manageNode(tree, rootNode, moveNode, newIndex, true);
	}

	/**
	 * move a node
	 * 
	 * @param tree
	 * @param rootNode
	 * @param moveNode
	 * @param newIndex
	 * @param cCopy
	 */
	public void moveNode(JTree tree, DefaultMutableTreeNode rootNode,
			DefaultMutableTreeNode moveNode, int newIndex) {
		manageNode(tree, rootNode, moveNode, newIndex, false);
	}

	/**
	 * manage a node (move or copy)
	 * 
	 * @param moveNode
	 * @param newIndex
	 */
	public void manageNode(JTree tree, DefaultMutableTreeNode rootNode,
			DefaultMutableTreeNode moveNode, int newIndex, boolean bCopy) {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		TreeSelectionModel tS = tree.getSelectionModel();

		int origIndex = rootNode.getIndex(moveNode);

		// ost.dprint(String.format(
		// "Encounter_Frame->manageNode() managing (%s) index (%d) to (%d)\n",
		// moveNode.getUserObject().toString(), origIndex, newIndex));

		if (!bCopy) {
			int removeIndxs[] = { origIndex };
			Object[] removedChilds = { moveNode };
			rootNode.remove(moveNode);
			model.nodesWereRemoved(rootNode, removeIndxs, removedChilds);
		}

		int insertIndxs[] = { newIndex };
		rootNode.insert(moveNode, (newIndex));
		model.nodesWereInserted(rootNode, insertIndxs);

		TreePath newPath = new TreePath(moveNode.getPath());
		tree.expandPath(newPath);
		tS.setSelectionPath(newPath);

		tree.repaint();
	} // end moveNode

	/**
	 * make sure node is expanded and visible.
	 * 
	 * @param tree
	 * @param expNode
	 */
	private void expandNode(JTree tree, DefaultMutableTreeNode expNode) {
		TreePath newPath = new TreePath(expNode.getPath());
		tree.expandPath(newPath);

	}

	private void dungeonClearButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (SimpleDialog.AskYN(dungeonClearButton, "Remove ALL rooms?")) {
			iRoomCounter = -1; // reset to asked for new room start
			nodeDungeons.removeAllChildren();
			encountersTreeModel.reload(nodeDungeons);
			encountersTree.expandRow(0);
		}
	}

	private void dungeonLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String sFilename = SimpleDialog.askWhatFileToLoad(dungeonLoadButton,
				"Load Dungeon", MainClass.dir_dungeon);
		if (sFilename != null) {
			ArrayList<DungeonRoom> aListOLD = DungeonRoom.loadFromXML(sFilename);
			DungeonList aList = new DungeonList(sFilename);
			aList.xm.deserializeFromXMLFile();
			if (aList.getContent().isEmpty()) {
				if (aListOLD != null && aListOLD.size()>0) {
					SimpleDialog.showDone("Trying to import old file into new format.");
					for (DungeonRoom oD : aListOLD)
						aList.getContent().add(oD);
				} else
					aList.generate();
			}
			nodeDungeons.removeAllChildren();
			for (DungeonRoom dR : aList.getContent()) {
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(dR);
				encountersTreeModel.insertNodeInto(newNode, nodeDungeons,
						nodeDungeons.getChildCount());
				for (CreatureClass oC : dR.getMobs()) {
					DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(
							oC);
					encountersTreeModel.insertNodeInto(newChild, newNode,
							newNode.getChildCount());
				} // end for
			}// end for
			encountersTreeModel.reload(nodeDungeons);
			expandAll(encountersTree, true);
		} // 
	}

	private void dungeonSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//		ArrayList<DungeonRoom> aList = new ArrayList<DungeonRoom>();
		//		aList.clear();
		String sFilename = SimpleDialog.askWhereToSave(dungeonSaveButton,
				"Save Dungeon", MainClass.dir_dungeon);
		if (sFilename != null) {
			DungeonList aList = new DungeonList(sFilename);
			int childCount = nodeDungeons.getChildCount();
			for (int i = 0; i < childCount; i++) {
				DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) nodeDungeons
						.getChildAt(i);
				if (Utils.isDungeon(oNode.getUserObject())) {
					aList.add(getDungeonNodes(oNode));
				}
			} // end for
			//			Document doc = DungeonRoom.xmlBuildDocFromList(aList,
			//					"DungeonRooms");
			//			XMLControl.saveDoc(doc, sFilename);
			aList.xm.serializeToXMLFile();
			SimpleDialog.showDone("Saved dungeon to " + sFilename);
		}

	}

	/**
	 * return this nodes DungeonRoom class
	 * 
	 * @param oNode
	 * @return
	 */
	private DungeonRoom getDungeonNodes(DefaultMutableTreeNode oNode) {
		DungeonRoom dR = (DungeonRoom) oNode.getUserObject();
		dR.getMobs().clear();
		if (dR.getEncountered() != null) {
			dR.setDescriptionGM(dR.getEncountered().dungeonDMTextArea.getText());
			dR.setDescriptionPC(dR.getEncountered().dungeonPCTextArea.getText());
		}
		if (oNode.getChildCount() > 0) {
			for (int ii = 0; ii < oNode.getChildCount(); ii++) {
				DefaultMutableTreeNode oChild = (DefaultMutableTreeNode) oNode
						.getChildAt(ii);
				if (Utils.isNPC(oChild.getUserObject())) {
					CreatureClass oC = (CreatureClass) oChild.getUserObject();
					dR.getMobs().add(oC);
				} else if (Utils.isDungeon(oChild.getUserObject())) {
					// this is the recursive bit
					dR.getRooms().add(getDungeonNodes(oChild));
				}
			}// end for
		}
		return (dR);
	}

	/**
	 * check room counter and prompt if not set.
	 */
	private void checkRoomCounter() {
		while (iRoomCounter < 0) {
			String sRoomNumber = SimpleDialog.showQuestion(
					dungeonAddRoomButton, "Starting room number?",
					"Room Number", "101");
			if (MyParse.isInteger(sRoomNumber))
				iRoomCounter = Integer.parseInt(sRoomNumber);
		} // end while
	}

	private void dungeonAddRoomButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		checkRoomCounter();
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
				new DungeonRoom(String.format("%d", iRoomCounter)));
		// encountersTreeModel.insertNodeInto(newNode, nodeRootEncounters,
		// nodeRootEncounters.getChildCount());
		encountersTreeModel.insertNodeInto(newNode, nodeDungeons,
				nodeDungeons.getChildCount());
		expandAll(encountersTree, true);
		encountersTree.repaint();
		// ost.dprint(String.format("Adding dungeon room %d.\n", iRoomCounter));
		iRoomCounter++;
	}

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (SimpleDialog
				.AskYN(this,
						"Are you ABSOLUTELY SURE you want to remove ALL creatures in this encounter?"))
			for (CreatureClass oCc : ost.fightingCreatureList)
				removeEncounter(oCc);
		ost.fightingCreatureList.clear();
	}

	void killButtonActionPerformed(java.awt.event.ActionEvent evt) {
		TreePath[] paths = encountersTree.getSelectionPaths();
		if (paths != null) {
			if ((paths.length > 1 && SimpleDialog.AskYN(killButton,
					"Are you sure you want to delete ALL selected?"))
					|| (paths.length == 1)) {
				for (int i = 0; i < paths.length; i++) {
					DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) paths[i]
							.getLastPathComponent();
					if (oNode != null && nodeNPC.isNodeDescendant(oNode)
							&& Utils.isNPC(oNode.getUserObject())) {
						CreatureClass oC = (CreatureClass) oNode
								.getUserObject();
						ost.fightingCreatureList.remove(oC);
						removeEncounter(oC);
					} else if (oNode != null && nodePC.isNodeDescendant(oNode)
							&& Utils.isPC(oNode.getUserObject())) {
						PlayerClass oC = (PlayerClass) oNode.getUserObject();
						if (SimpleDialog.AskYN(this,
								"Are you sure you want to remove party member "
										+ oC.getName() + "?")) {
							ost.fightingPlayerList.remove(oC);
							removePartyMember(oC);
						}
					}
				}
			}
		}

		encountersTreeSetSelected();
	}

	/**
	 * sets something selected (first object) if nothing is selected.
	 * 
	 */
	public void encountersTreeSetSelected() {
		TreePath path = encountersTree.getSelectionPath();
		if (!nodeNPC.isLeaf() && path == null) {
			DefaultMutableTreeNode oN = nodeNPC.getFirstLeaf();
			encountersTree.setSelectionPath(new TreePath(oN.getPath()));
		} else if (!nodePC.isLeaf() && path == null) {
			DefaultMutableTreeNode oN = nodePC.getFirstLeaf();
			encountersTree.setSelectionPath(new TreePath(oN.getPath()));
		}
	}

	/**
	 * remove this creature from encounter frame
	 * 
	 * @param oC
	 */
	private void removeEncounter(CreatureClass oC) {
		ost.fightingKilledList.add(oC.getName());

		// check for and remove any fighting nodes associated with this
		for (PlayerClass opp : ost.playerList.getContent()) {
			if (opp.getFightingList().contains(oC)) {
				DefaultMutableTreeNode oNode = Utils.getMyNodeByObject(
						encountersTreeModel, opp.getFightingNode(), oC);
				opp.getFightingList().remove(oC);
				// if no more fighting, remove "Fighting" node
				if (opp.getFightingList().isEmpty()) {
					// removeNode(encountersTree, nodePC,
					// opp.getFightingNode());
					encountersTreeModel.removeNodeFromParent(opp
							.getFightingNode());
					encountersTreeModel.nodeChanged(nodePC);
				}
				// remove the creature node
				removeNode(encountersTree, opp.getFightingNode(), oNode);
			}
		}

		MainClass
				.ddprint(String.format("Killed/removed: [%s]\n", oC.getName()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(encountersTreeModel,
				nodeNPC, oC);
		removeNode(encountersTree, nodeNPC, oN);

		oC.Encountered.removeAll();
		creatureEncounterDisplayPanel.remove(oC.Encountered);
		creatureEncounterDisplayPanel.repaint(); // repaint to clear out
		this.validate(); // to resize window scroll
		oC.Encountered = null;
		oC = null;
	}

	/**
	 * remove partymember from tree
	 * 
	 * @param oC
	 */
	public void removePartyMember(PlayerClass oC) {
		// check for and remove any fighting nodes associated with this
		for (CreatureClass occ : ost.fightingCreatureList) {
			if (occ.getFightingList().contains(oC)) {
				DefaultMutableTreeNode oNode = Utils.getMyNodeByObject(
						encountersTreeModel, occ.getFightingNode(), oC);
				occ.getFightingList().remove(oC);
				// if no more fighting, remove "Fighting" node
				if (occ.getFightingList().isEmpty()) {
					// removeNode(encountersTree, nodePC,
					// opp.getFightingNode());
					encountersTreeModel.removeNodeFromParent(occ
							.getFightingNode());
					encountersTreeModel.nodeChanged(nodeNPC);
				}
				// remove the creature node
				removeNode(encountersTree, occ.getFightingNode(), oNode);
			}
		}

		ost.dprint(String.format("Killed/removed: [%s]\n", oC.getName()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(encountersTreeModel,
				nodePC, oC);
		removeNode(encountersTree, nodePC, oN);

		oC.Encountered.removeAll();
		creatureEncounterDisplayPanel.remove(oC.Encountered);
		creatureEncounterDisplayPanel.repaint(); // repaint to clear out
		this.validate(); // to resize window scroll
		oC.Encountered = null;
		// do not null this, the object still exists in the Innkeeper tab.
		// oC = null;
	}

	// private void loadEncounterCreatureFromList(CreatureClass oC) {
	private void loadEncounterObjectFromList(Object oO) {
		if (nodeNPC.isLeaf() && nodePC.isLeaf() && oO != null
				&& !Utils.isDungeon(oO)) {
			// lists is empty
			creatureEncounterDisplayPanel.removeAll();
		} else {
			if (oO != null) {
				creatureEncounterDisplayPanel.removeAll();

				if (Utils.isNPC(oO)) {
					CreatureClass oC = (CreatureClass) oO;
					// copy/moved from Dungeon saved list...
					if (oC.Encountered == null)
						oC.setEncountered(new EncounterCreature(ost, oC));
					creatureEncounterDisplayPanel.add(oC.Encountered);
					oC.Encountered.repaint();
					oC.Encountered.revalidate();
				} else if (Utils.isPC(oO)) {
					PlayerClass oC = (PlayerClass) oO;
					// copy/moved from Dungeon saved list...
					if (oC.Encountered == null)
						oC.setEncountered(new EncounterPlayer(ost, oC));
					creatureEncounterDisplayPanel.add(oC.Encountered);
					oC.Encountered.repaint();
					oC.Encountered.revalidate();
				} else if (Utils.isDungeon(oO)) {
					DungeonRoom dR = (DungeonRoom) oO;
					// copy/moved from Dungeon saved list...
					if (dR.Encountered == null)
						dR.setEncountered(new EncounterDungeon(ost, dR));
					creatureEncounterDisplayPanel.add(dR.getEncountered());
					dR.getEncountered().repaint();
					dR.getEncountered().revalidate();
				}
			}
		}
		creatureEncounterDisplayPanel.revalidate();
		creatureEncounterDisplayPanel.repaint();
	}

	@SuppressWarnings("unchecked")
	void nextRoundButtonActionPerformed(java.awt.event.ActionEvent evt) {
		iRoundCounter++;
		encounterRoundTrackerLabel.setText(String.format("Round %d",
				iRoundCounter));

		// reset attack/damage labels for new round.
		for (CreatureClass oC : ost.fightingCreatureList) {
			// copy/moved from Dungeon saved list...
			if (oC.Encountered == null)
				oC.setEncountered(new EncounterCreature(ost, oC));

			// remove existing, we're replacing.
			oC.Encountered.modelStatesListForCombatPanel.removeAllElements();
			// Collections.sort(oC.getStates());
			// update the states and it's labels, reduce states counters by 1.
			ArrayList<StatesClass> removeStates = new ArrayList<StatesClass>();
			for (StatesClass oS : oC.getStates()) {
				oS.setbSmallFont(true); // set this to true so small font is
										// used.
				if (oS.getCounter() > 1)
					oC.Encountered.modelStatesListForCombatPanel.addElement(oS);
				else {
					removeStates.add(oS);
				}
				oS.decreaseCounter(1);
			} // end for

			// can't remove states from the for cause of exception
			// (arraylist changes so forloop is bad) so we saved the removals
			// and then remove them here.
			for (StatesClass oS : removeStates) {
				oC.getStates().remove(oS);
				SimpleDialog.showDone(String.format("%s faded from %s.",
						oS.getName(), oC.getName()));
			}

			for (EncounterCreatureAttack oE : oC.Encountered.atkList) {
				oE.oA.setAttackDone(false);
				oE.oA.setDamageDone(false);
				oE.damageDoneLabel.setToolTipText("");
				oE.updateDamageDisplays("Ready!", oE.oA.getDamageDice());
				oE.updateAttackDisplays("Rolling...", "READY!");
			} // end for
		} // end for

		// now sort out the player states
		for (PlayerClass oC : ost.fightingPlayerList) {
			// remove existing, we're replacing.
			oC.Encountered.modelStatesListForCombatPanel.removeAllElements();
			Collections.sort(oC.getStates());
			// update the states and it's labels, reduce states counters by 1.
			ArrayList<StatesClass> removeStates = new ArrayList<StatesClass>();
			for (StatesClass oS : oC.getStates()) {
				oS.setbSmallFont(true); // set this to true so small font is
										// used.
				if (oS.getCounter() > 1)
					oC.Encountered.modelStatesListForCombatPanel.addElement(oS);
				else {
					removeStates.add(oS);
				}
				oS.decreaseCounter(1);
			} // end for

			// can't remove states from the for cause of exception
			// (arraylist changes so forloop is bad) so we saved the removals
			// and then remove them here.
			for (StatesClass oS : removeStates) {
				oC.getStates().remove(oS);
				SimpleDialog.showDone(String.format("%s faded from %s.",
						oS.getName(), oC.getName()));
			}
		}// end for

		// initiative setup
		// creatures
		int initGroupRoll = MyRandomClass.rollDice(1, ost.initDice);
		for (CreatureClass oT : ost.fightingCreatureList)
			oT.setInitRoll(ost.initGroup ? initGroupRoll : MyRandomClass
					.rollDice(1, ost.initDice));
		// players
		initGroupRoll = MyRandomClass.rollDice(1, ost.initDice);
		for (PlayerClass oT : ost.fightingPlayerList)
			oT.setInitRoll(ost.initGroup ? initGroupRoll : MyRandomClass
					.rollDice(1, ost.initDice));

		int iInitPrevious = 0;
		if (ost.initAscending) {
			iInitCounter = 1;
			iInitPrevious = iInitCounter - 1;
		} else {
			// descending initiative
			iInitCounter = ost.initDice;
			iInitPrevious = iInitCounter + 1;
		}

		buildEncounterList();

		initLabel.setText("Init " + iInitCounter);
		setCreatureInitiativeSelected(iInitPrevious);
	}

	void encounterResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		iRoundCounter = -1; // reset to -1, run the next round to force
							// states/attacks to reset.
		nextRoundButtonActionPerformed(evt);
	}

	void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {
		iTurnCounter++;
		encounterTurnCounterLabel.setText(String
				.format("Turn %d", iTurnCounter));
	}

	void resetTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {
		iTurnCounter = 0;
		nextTurnButtonActionPerformed(evt);
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void buildEncounterList() {
		ArrayList<DefaultMutableTreeNode> nodeList = Collections.list(nodeNPC
				.children());
		Collections.sort(nodeList, new sortNodesByInit());
		int i = 0;
		for (DefaultMutableTreeNode oNode : nodeList) {
			moveNode(encountersTree, nodeNPC, oNode, i);
			if (!oNode.isLeaf())
				expandNode(encountersTree,
						(DefaultMutableTreeNode) oNode.getFirstChild());
			i++;
		}
		encountersTreeModel.nodeChanged(nodeNPC);

		// // re-sort PCs
		nodeList.clear();
		nodeList = Collections.list(nodePC.children());
		Collections.sort(nodeList, new sortNodesByInit());
		i = 0;
		for (DefaultMutableTreeNode oNode : nodeList) {
			moveNode(encountersTree, nodePC, oNode, i);
			if (!oNode.isLeaf())
				expandNode(encountersTree,
						(DefaultMutableTreeNode) oNode.getFirstChild());
			i++;
		}
		encountersTreeModel.nodeChanged(nodePC);

		encountersTreeSetSelected();
	}

	void buildDungeonTree() {
		encountersTree.expandRow(0);
	}

	/**
	 * If expand is true, expands all nodes in the tree. Otherwise, collapses
	 * all nodes in the tree.
	 * 
	 * @param tree
	 * @param expand
	 */
	public void expandAll(JTree tree, boolean expand) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();

		// Traverse tree from root
		expandAll(tree, new TreePath(root), expand);
	}

	@SuppressWarnings("rawtypes")
	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}

		// Expansion or collapse must be done bottom-up
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}

	/**
	 * 
	 * @author Celestian
	 * 
	 */
	@SuppressWarnings("serial")
	public class savedEncountersCellRendererTree extends
			DefaultTreeCellRenderer {

		/**
		 * constructor
		 */
		public savedEncountersCellRendererTree() {
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
				Font defaultFont = new java.awt.Font("Tahoma", 0, 12);
				Font italicFont = new java.awt.Font("Tahoma", Font.ITALIC, 12);

				if (node.getUserObject() instanceof String) {
					setForeground(Color.lightGray);

					setText((String) node.getUserObject());
					if (node.getUserObject().toString()
							.equalsIgnoreCase("Party"))
						setToolTipText("Player characters in party.");
					if (node.getUserObject().toString().equalsIgnoreCase("NPC"))
						setToolTipText("Creatures the party is fighting.");
					if (node.getUserObject().toString()
							.equalsIgnoreCase("Dungeons"))
						setToolTipText("Rooms in the dungeon.");
				} else if (Utils.isPC(node.getUserObject())) {
					// player character
					PlayerClass oP = (PlayerClass) node.getUserObject();
					String sName = oP.getName();
					String sInit = String.format("%d", oP.getInitRoll());
					// we do not fiddle with the name if it is a fighting node
					if (!Utils.isFightingNode(node)) {
						sName = String.format("(%s%d)%s%s%s",
								sInit.length() == 1 ? "0" : "", oP
										.getInitRoll(),
								oP.getHpCurrent() < 1 ? "(down)" : "", oP
										.getName(),
								(oP.getTag().length() > 0 ? " [" + oP.getTag()
										+ "]" : ""));
					}
					setToolTipText(String.format("Initiative:%d",
							oP.getInitRoll()));
					setText(sName);
					setForeground(Color.CYAN);
					if (oP.getHpCurrent() < 1) {
						setFont(italicFont);
					} else {
						setFont(defaultFont);
					}
				} else if (Utils.isDungeon(node.getUserObject())) {
					DungeonRoom dR = (DungeonRoom) node.getUserObject();
					setToolTipText("Select and right click to edit/delete a Room");
					setText(dR.getName());
					setForeground(new Color(153, 153, 255)); // blue/purple
				} else if (Utils.isNPC(node.getUserObject())) {
					setForeground(Color.YELLOW);
					CreatureClass oQ = (CreatureClass) node.getUserObject();
					String sInit = String.format("%d", oQ.getInitRoll());
					String sName = oQ.getName();
					// not in npc tree, is a dungeon room creature
					if (!nodeNPC.isNodeDescendant(node)) {
						// if in fighting node we do not want anything but name
						if (!Utils.isFightingNode(node)) {
							sName = String.format("%s%s", oQ.getName(), oQ
									.getTag().length() > 0 ? " [" + oQ.getTag()
									+ "]" : "");
							setToolTipText(sName);
						}
					} else {
						// in nodeNPC so is critter we are fighting
						sName = String.format("(%s%d)%s%s%s",
								sInit.length() == 1 ? "0" : "", oQ
										.getInitRoll(), Integer.parseInt(oQ
										.getHitPoints()) < 1 ? "(down)" : "",
								oQ.getName(), (oQ.getTag().length() > 0 ? " ["
										+ oQ.getTag() + "]" : ""));
						setToolTipText(String.format(
								"Initiative:%d, %d attack%s left.",
								oQ.getInitRoll(), oQ.getAvailableAttacks(),
								oQ.getAvailableAttacks() == 1 ? "" : "s"));
						if (oQ.hasAvailableAttack()) {
							setForeground(Color.RED);
						}
						if (Integer.parseInt(oQ.getHitPoints()) < 1) {
							setFont(italicFont);
						} else {
							setFont(defaultFont);
						}

					}
					// else
					// setForeground(selected ? getTextSelectionColor() :
					// getTextNonSelectionColor());
					setText(sName);
				} else {
					if (!selected)
						setForeground(getTextNonSelectionColor());
				}

				if (selected) {
					// background doesnt set for some reason
					setBackground(getBackgroundSelectionColor());
					setForeground(getTextSelectionColor());
				} else {
					// background doesnt set for some reason
					setBackground(getBackgroundNonSelectionColor());
					// if (!hadSpecialFont)
					// setForeground(getTextNonSelectionColor());
				}
			}
			return this;
		}
	}

	@SuppressWarnings("serial")
	public class myTransferHandler extends TransferHandler {
		private DataFlavor localFlavor = new DataFlavor(ArrayList.class,
				"ArrayList-CreatureClass");
		private DefaultMutableTreeNode[] nodesToRemove;
		//		private DefaultMutableTreeNode[] nodesToCopy;
		private DefaultMutableTreeNode[] nodesToDelete;

		/**
		 * We only support importing strings.
		 */
		public boolean canImport(TransferHandler.TransferSupport info) {
			// Check for String flavor
			if (!info.isDataFlavorSupported(localFlavor)) {
				ost.dprint(String
						.format("TransferHandler-canImport() isDataFlavorSupported FALSE\n"));

				return false;
			}
			info.setShowDropLocation(true);

			if (info.getComponent() instanceof JTree) {

				JTree tree = (JTree) info.getComponent();
				JTree.DropLocation dl = (JTree.DropLocation) info
						.getDropLocation();
				TreePath dest = dl.getPath();
				if (dest == null)
					return false;
				TreePath[] paths = tree.getSelectionPaths();
				DefaultMutableTreeNode target = (DefaultMutableTreeNode) dest
						.getLastPathComponent();
				DefaultMutableTreeNode source = (DefaultMutableTreeNode) paths[0]
						.getLastPathComponent();

				// ost.dprint("canImport idx:("+dl.getChildIndex()+")"+"\n");
				// ost.dprint("canImport source:("+source.getLevel()+")"+"\n");

				// can't place anything in root, has to be in room
				if (!nodeDungeons.isNodeDescendant(target)
						&& !nodeNPC.isNodeDescendant(target)
						&& !nodePC.isNodeDescendant(target)) {
					return false;
				}

				// target drop spot can't be a Creature
				if (Utils.isNPC(target.getUserObject())
						&& !Utils.isPC(source.getUserObject())) {
					return false;
				}

				// don't allow drag/drop on source
				int dropRow = tree.getRowForPath(dl.getPath());
				int[] selRows = tree.getSelectionRows();
				if (selRows != null)
					for (int i = 0; i < selRows.length; i++) {
						if (selRows[i] == dropRow) {
							return false;
						}
					}

				// dont allow rooms to be moved into rooms
				if (Utils.isDungeon(source.getUserObject())
						&& Utils.isDungeon(target.getUserObject())) {
					return false;
				}
				// dont allow creatures to be moved into anything but
				// DungeonRooms
				// or the nodeNPC tree (encounter window critters)
				if (Utils.isNPC(source.getUserObject())
						&& ((!Utils.isDungeon(target.getUserObject()) && !nodeNPC
								.isNodeDescendant(target)) && (!nodeNPC
								.isNodeDescendant(source) && !Utils.isPC(target
								.getUserObject())))) {
					return false;
				}

				// do not allow pcs to be dropped straight into nodeNPC
				if (Utils.isPC(source.getUserObject()) && target == nodeNPC) {
					return false;
				}
				// do not allow npcs to be dropped straight into nodePC
				if (Utils.isNPC(source.getUserObject()) && target == nodePC) {
					return false;
				}

				// do not allow npcs to be dropped straight into dungeons, (put
				// in room)
				if (Utils.isNPC(source.getUserObject())
						&& target == nodeDungeons) {
					return false;
				}

				// if DungeonRoom only allow it to move to nodeDungeons
				if (Utils.isDungeon(source.getUserObject())
						&& !nodeDungeons.isNodeDescendant(target)) {
					return false;
				}

				if ((Utils.isNPC(source.getUserObject()) && Utils.isPC(target
						.getUserObject()))
						|| (Utils.isPC(source.getUserObject()) && Utils
								.isNPC(target.getUserObject()))) {
					// do not allow moving from or to fighting/defending nodes
					// you have to move the REAL one
					if (Utils.isFightingNode(source)
							|| Utils.isFightingNode(target)) {
						return false;
					}

				}
				if (Utils.isFightingNode(target))
					return false;
				if (Utils.isFightingNode(source))
					return false;

				// dont allow root nodes to get moved
				// if (source.getUserObject() instanceof String) {
				if (source.getLevel() == 1) {
					return false;
				}
			} // end was JTree

			// save for createTransferable later
			return true;
		}

		/**
		 * Bundle up the selected items in a single list for export. Each line
		 * is separated by a newline.
		 */
		protected Transferable createTransferable(JComponent c) {
			if (c instanceof JTree) {
				JTree tree = (JTree) c;
				TreePath[] paths = tree.getSelectionPaths();
				if (paths != null) {
					// Make up a node array of copies for transfer and
					// another for/of the nodes that will be removed in
					// exportDone after a successful drop.
					// / CHANGED ---
					// / for now the nodesToRemove are actually notesToCheck
					// / we then sort out the actual nodesToDelete in importData
					// TODO clean this up and change names to make more sense.
					ArrayList<DefaultMutableTreeNode> copies = new ArrayList<DefaultMutableTreeNode>();
					ArrayList<DefaultMutableTreeNode> toRemove = new ArrayList<DefaultMutableTreeNode>();
					for (int i = 0; i < paths.length; i++) {
						DefaultMutableTreeNode next = (DefaultMutableTreeNode) paths[i]
								.getLastPathComponent();
						// we do not move/copy "root" nodes, 0 is root, 1 is
						// PC/NPC/Dungeon names
						// if (!(next.getUserObject() instanceof String)) {
						if (next.getLevel() > 1) {
							copies.add(transNnodeCopy(next));
							toRemove.add(next);
						}
					}
					nodesToRemove = toRemove
							.toArray(new DefaultMutableTreeNode[toRemove.size()]);
					//					nodesToCopy = copies
					//							.toArray(new DefaultMutableTreeNode[copies.size()]);
					return new ListTransferable(copies);
				}
			} // was JTree

			ost.dprint(String
					.format("TransferHandler-createTransferable() returing data null\n"));
			return null;
		}

		protected DefaultMutableTreeNode transNnodeCopy(
				DefaultMutableTreeNode oldNode) {
			DefaultMutableTreeNode newNode = null;
			newNode = new DefaultMutableTreeNode(oldNode.getUserObject());

			// this is to snag any sub-nodes recursively
			if (!oldNode.isLeaf()) {
				for (int i = 0; i < oldNode.getChildCount(); i++) {
					DefaultMutableTreeNode oN = (DefaultMutableTreeNode) oldNode
							.getChildAt(i);
					// we do not copy sub-nodes of just String or below.
					// this keeps us from copying anything in the Fighting block
					if (!(oN.getUserObject() instanceof String)) {
						DefaultMutableTreeNode subNode = transNnodeCopy(oN);
						newNode.insert(subNode, i);
					}
				}
			}
			return newNode;
		}

		/**
		 * 
		 * @param oNode
		 * @return
		 */
		/**
		 * We support both copy and move actions.
		 */
		public int getSourceActions(JComponent c) {
			return TransferHandler.COPY_OR_MOVE;
		}

		/**
		 * Perform the actual import. This demo only supports drag and drop.
		 */
		public boolean importData(TransferHandler.TransferSupport info) {
			if (!info.isDrop()) {
				ost.dprint(String
						.format("TransferHandler-importData() isDrop FALSE\n"));
				return false;
			}
			if (info.getComponent() instanceof JTree) {
				JTree tree = (JTree) info.getComponent();
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				JTree.DropLocation dropLocation = (JTree.DropLocation) info
						.getDropLocation();
				TreePath path = dropLocation.getPath();
				//Transferable t = info.getTransferable();
				DefaultMutableTreeNode targetNode = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				TreePath[] paths = tree.getSelectionPaths();
				DefaultMutableTreeNode source = (DefaultMutableTreeNode) paths[0]
						.getLastPathComponent();

				// this array is where we store nodes that should be deleted
				// if the user is moving and not copying.
				ArrayList<DefaultMutableTreeNode> nodesToClear = new ArrayList<DefaultMutableTreeNode>();

				// TODO see below, re:"data" corruption on sub-nodes
				// ArrayList<DefaultMutableTreeNode> data = null;
				// try {
				// data = (ArrayList<DefaultMutableTreeNode>) t
				// .getTransferData(localFlavor);
				// } catch (Exception e) {
				// SimpleDialog
				// .showError(String
				// .format("TransferHandler-importData(JTree) exception (%s)[%s]\n",
				// e.getLocalizedMessage(),
				// e.toString()));
				// ost.dprint(String
				// .format("TransferHandler-importData(JTree) exception (%s)[%s]\n",
				// e.getLocalizedMessage(), e.toString()));
				// return false;
				// }

				int childIndex = dropLocation.getChildIndex();
				if (childIndex == -1)
					childIndex = model.getChildCount(path
							.getLastPathComponent());
				// TODO:FIX THIS
				// for some reason "data" is corrupted (on nodes with children)
				// but since we are
				// transfering in the same tree we use nodesToCopy for now.
				// for (DefaultMutableTreeNode thisNode : data) {
				// for (DefaultMutableTreeNode thisNode : nodesToCopy) {
				for (DefaultMutableTreeNode oldNode : nodesToRemove) {
					// copy old node
					DefaultMutableTreeNode newNode = transNnodeCopy(oldNode);
					// save targetLocationNode spot
					DefaultMutableTreeNode targetLocationNode = targetNode;
					int childLocationIndex = childIndex;

					// add new creature to fighting list if in nodeNPC
					// target is npc tree, and is creature
					if (nodeNPC.isNodeDescendant(targetNode)
							&& Utils.isNPC(newNode.getUserObject())) {
						cloneCreaturesInNode(newNode);
						ost.fightingCreatureList.add((CreatureClass) newNode
								.getUserObject());
						// clear old Node for this one
						nodesToClear.add(oldNode);
					}
					// target is pc and source is NPC
					else if (Utils.isPC(targetNode.getUserObject())
							&& Utils.isNPC(source.getUserObject())) {
						CreatureClass oC = (CreatureClass) oldNode
								.getUserObject();
						PlayerClass oP = (PlayerClass) targetNode
								.getUserObject();
						if (Utils.getMyNodeByObject(encountersTreeModel,
								oC.getFightingNode(), oP) == null) {
							oC.getFightingList().add(oP);
							targetLocationNode = oC.getFightingNode();
							childLocationIndex = oC.getFightingNode()
									.getChildCount();
							// place a node on the fightingNode with PC object
							newNode.setUserObject(oP);
							// if source, the NPC, has no nodes add the
							// "Fighting" node
							if (oldNode.isLeaf())
								copyNode(tree, oldNode, oC.getFightingNode(), 0);

						} else {
							// object already exists, do not copy it
							targetLocationNode = null;
						}
						// target is npc and source is PC
					} else if (Utils.isNPC(targetNode.getUserObject())
							&& Utils.isPC(oldNode.getUserObject())
							&& nodeNPC.isNodeDescendant(targetNode)) {
						CreatureClass oC = (CreatureClass) targetNode
								.getUserObject();
						PlayerClass oP = (PlayerClass) oldNode.getUserObject();
						if (Utils.getMyNodeByObject(encountersTreeModel,
								oP.getFightingNode(), oC) == null) {
							oP.getFightingList().add(oC);
							targetLocationNode = oP.getFightingNode();
							childLocationIndex = oP.getFightingNode()
									.getChildCount();
							// place a node on the fightingNode with NPC object
							newNode.setUserObject(oC);
							// if source, the PC, has no nodes add the
							// "Fighting" node
							if (oldNode.isLeaf())
								copyNode(tree, oldNode, oP.getFightingNode(), 0);
						} else {
							// object already exists, do not copy it
							targetLocationNode = null;
						}
					} else if (nodeDungeons.isNodeDescendant(targetNode)
							&& Utils.isNPC(oldNode.getUserObject())) {
						CreatureClass oC = (CreatureClass) oldNode
								.getUserObject();
						if (oC.getEncountered() != null)
							oC.setNotes(oC.Encountered.notesTextArea.getText());
						nodesToClear.add(oldNode);
					} else {
						ost.dprint("target/source is what?\n");
						// clear old node for this one
						nodesToClear.add(oldNode);
					}

					if (targetLocationNode != null) {
						copyNode(tree, targetLocationNode, newNode,
								childLocationIndex);
					} else
						ost.dprint("--10\n");

				} // end for

				nodesToDelete = nodesToClear
						.toArray(new DefaultMutableTreeNode[nodesToClear.size()]);
			} // end was JTree
			return true;
		}

		/**
		 * Remove the items moved from the list.
		 */
		protected void exportDone(JComponent c, Transferable data, int action) {

			if (c instanceof JTree) {
				if (action == TransferHandler.MOVE) {
					JTree tree = (JTree) c;
					DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
					for (int i = 0; i < nodesToDelete.length; i++) {
						if (nodeNPC.isNodeDescendant(nodesToDelete[i])) {
							if (Utils.isNPC(nodesToDelete[i].getUserObject())) {
								CreatureClass oC = (CreatureClass) nodesToDelete[i]
										.getUserObject();
								ost.fightingCreatureList.remove(oC);
							}
						}
						model.removeNodeFromParent(nodesToDelete[i]);
					}
				} // was a move
			} // was JTree
		}

		public class ListTransferable implements Transferable {
			ArrayList<DefaultMutableTreeNode> data;

			public ListTransferable(ArrayList<DefaultMutableTreeNode> alist) {
				this.data = alist;
			}

			@Override
			public Object getTransferData(DataFlavor flavor)
					throws UnsupportedFlavorException {
				if (!isDataFlavorSupported(flavor)) {
					throw new UnsupportedFlavorException(flavor);
				}
				return data;
			}

			@Override
			public DataFlavor[] getTransferDataFlavors() {
				return new DataFlavor[] { localFlavor };
			}

			@Override
			public boolean isDataFlavorSupported(DataFlavor flavor) {
				if (localFlavor.equals(flavor)) {
					return true;
				}
				ost.dprint("myListTransferHandler-isDataFlavorSupported() !flavor\n");

				return false;
			}
		}

	} // end myTransferHandler

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel DISABLEDexpandTreeHandlesPanel;
	private javax.swing.JButton acEditButton;
	private javax.swing.JButton clearButton;
	public javax.swing.JPanel creatureEncounterDisplayPanel;
	private javax.swing.JButton dungeonAddRoomButton;
	private javax.swing.JPanel dungeonButtonsPanel;
	private javax.swing.JMenuItem dungeonCancelMenuItem;
	private javax.swing.JButton dungeonClearButton;
	private javax.swing.JButton dungeonCloneButton;
	private javax.swing.JButton dungeonDeleteRoomButton;
	private javax.swing.JMenuItem dungeonDeleteRoomMenuItem;
	private javax.swing.JMenuItem dungeonEditRoomMenuItem;
	private javax.swing.JButton dungeonFightButton;
	private javax.swing.JButton dungeonLoadButton;
	private javax.swing.JMenuItem dungeonNameMenuItem;
	private javax.swing.JButton dungeonResetRoomButton;
	private javax.swing.JButton dungeonSaveButton;
	private javax.swing.JPopupMenu dungeonTreePopupMenu;
	private javax.swing.JPanel encountFramebuttonPanel;
	private javax.swing.JButton encounterResetButton;
	private javax.swing.JLabel encounterRoundTrackerLabel;
	private javax.swing.JLabel encounterTurnCounterLabel;
	private javax.swing.JScrollPane encounterWindowScrollPane;
	private javax.swing.JPanel encountersButtonPanel;
	private javax.swing.JToggleButton encountersExpansionToggleButton;
	private javax.swing.JPanel encountersPanel;
	private javax.swing.JSplitPane encountersSplitPane;
	public javax.swing.JTabbedPane encountersTabbedPane;
	public javax.swing.JTree encountersTree;
	private javax.swing.JScrollPane encountersTreeScrollPane;
	private javax.swing.JButton hpEditButton;
	private javax.swing.JLabel initLabel;
	private javax.swing.JButton initNextButton;
	private javax.swing.JButton initRollButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JButton killButton;
	private javax.swing.JButton nameButton;
	private javax.swing.JButton nextRoundButton;
	private javax.swing.JButton nextTurnButton;
	private javax.swing.JButton peaceAllButton;
	private javax.swing.JButton peaceSelectedButton;
	private javax.swing.JButton resetTurnButton;
	private javax.swing.JPanel savedCreaturesButtonPanel;
	private javax.swing.JButton tagButton;
	// End of variables declaration//GEN-END:variables

	private MainClass ost;
	private int iRoundCounter;
	private int iTurnCounter;
	private int iInitCounter;
	private int iRoomCounter;
	// public DefaultListModel creatureEncounterModel;
	public DefaultMutableTreeNode nodeRootEncounters;
	public DefaultMutableTreeNode nodeDungeons;
	public DefaultMutableTreeNode nodePC;
	public DefaultMutableTreeNode nodeNPC;
	public DefaultTreeModel encountersTreeModel;
	private DefaultTreeCellRenderer dungeonCell;

}