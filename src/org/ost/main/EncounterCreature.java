/*
 * EncounterCreature.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;

import org.ost.main.MyClasses.CreatureAttackClass;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.StatesClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;

/**
 *
 * @author  __USER__
 */
public class EncounterCreature extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private MainClass ost;

	/** Creates new form EncounterCreature */
	public EncounterCreature(MainClass ost, CreatureClass incomingCreature) {
		this.ost = ost;
		initComponents();

		oC = incomingCreature;
		// we set values that do not change here for labels

		// used to see what attacks are available in CreatureClass
		atkList = new ArrayList<EncounterCreatureAttack>();

		hpBarLast = Integer.parseInt(oC.getHitPoints());
		specialDefenseLabel.setText("SD: " + oC.getSpecialDefense());
		specialAttackLabel.setText("SA: " + oC.getSpecialAttack());
		moveLabel.setText("Move: " + oC.getMove());
		sizeLabel.setText("Size: " + oC.getSize());
		magicResistanceLabel.setText("MR: " + oC.getMagicResistance());
		if (oC.getSource().length() > 1)
			sourceLabel.setText("Source: " + oC.getSource());
		else
			sourceLabel.setText("");
		attackCountLabel.setText(String.format("Attacks: %d", oC.getAttacks()));
		armorClassLabel.setText(MyParse.displayArmorClass(
				ost.mainFrame.d20ModeRadioButton.isSelected(), oC.getAC()));
		hdLabel.setText("HD: " + oC.getHD());
		damageLabel.setText("Dam: " + oC.getDamage());
		intelligenceLabel.setText("Intelligence: " + oC.getIntelligence());
		hitpointLabel.setText(oC.getMaxHP());
		hitpointSlider.setMaximum(Integer.parseInt(oC.getMaxHP()));
		hitpointSlider.setValue(Integer.parseInt(oC.getHitPoints()));

		notesTextArea.setText(oC.getNotes());

		creatureTitleBorder = (TitledBorder) this.getBorder();
		creatureTitleBorder.setTitle(String.format("%s", oC.getName()));

		creatureSheetTitleBorder = (TitledBorder) creatureSheetScrollPane
				.getBorder();
		creatureSheetTitleBorder.setTitle(String.format("%s", oC.getName()));

		loadCreatureSheetIntoDialog();

		setSavePanelDetails(oC);

		setAttackChartPanelDetails(oC);
		//		// for some reason cellrenderer makes the cells align left, default
		//		// for int is right, so just cell render them all so they are all left
		//		// TODO figure out why it does that.
		//		// make that THACO cell red
		//		for (int i = 0; i < attackChartTable.getColumnCount(); i++) {
		//			TableColumn thacoCol = attackChartTable.getColumnModel().getColumn(
		//					i);
		//			if (i == 10)
		//				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.red,
		//						Color.black));
		//			else
		//				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.ORANGE,
		//						Color.black));
		//		}

		// build attack panels now for each attack
		for (CreatureAttackClass oA : oC.getAttackList())
			addAttackToCreature(oA, oC);
		attacksPanel.add(addAttackPanel);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		statePopupMenu = new javax.swing.JPopupMenu();
		stateNameMenuItem = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JSeparator();
		stateEditMenuItem = new javax.swing.JMenuItem();
		stateDeleteMenuItem = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		stateCancelMenuItem = new javax.swing.JMenuItem();
		creatureTagNamePopupMenu = new javax.swing.JPopupMenu();
		creatureTagNameMenuItem = new javax.swing.JMenuItem();
		creatureNameEditMenuItem = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JSeparator();
		creatureTagAddMenuItem = new javax.swing.JMenuItem();
		creatureTagEditMenuItem = new javax.swing.JMenuItem();
		creatureTagDeleteMenuItem = new javax.swing.JMenuItem();
		jSeparator4 = new javax.swing.JSeparator();
		creatureTagCancelMenuItem = new javax.swing.JMenuItem();
		creatureSheetDialog = new javax.swing.JDialog();
		creatureSheetScrollPane = new javax.swing.JScrollPane();
		creatureSheetTextArea = new javax.swing.JTextArea();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();
		acPopupMenu = new javax.swing.JPopupMenu();
		acDetailsMenuItem = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JSeparator();
		acEditMenuItem = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JSeparator();
		acCancelMenuItem = new javax.swing.JMenuItem();
		hpPopupMenu = new javax.swing.JPopupMenu();
		hpDetailsMenuItem = new javax.swing.JMenuItem();
		jSeparator7 = new javax.swing.JSeparator();
		hpEditMenuItem = new javax.swing.JMenuItem();
		jSeparator8 = new javax.swing.JSeparator();
		hpCancelMenuItem = new javax.swing.JMenuItem();
		attackPopupMenu = new javax.swing.JPopupMenu();
		attackAddMenuItem = new javax.swing.JMenuItem();
		jSeparator9 = new javax.swing.JSeparator();
		attackCancelMenuItem = new javax.swing.JMenuItem();
		creatureSavePopupMenu = new javax.swing.JPopupMenu();
		saveDeathMenuItem = new javax.swing.JMenuItem();
		savePolymorphMenuItem = new javax.swing.JMenuItem();
		saveRodStaffWandMenuItem = new javax.swing.JMenuItem();
		saveBreathMenuItem = new javax.swing.JMenuItem();
		saveSpellsMenuItem = new javax.swing.JMenuItem();
		saveCancelMenuItem = new javax.swing.JMenuItem();
		addAttackPanel = new javax.swing.JPanel();
		addAttackIcon = new javax.swing.JLabel();
		statsSubPanel1 = new javax.swing.JPanel();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		helpIcon = new javax.swing.JLabel();
		armorClassLabel = new javax.swing.JLabel();
		hitpointLabel = new javax.swing.JLabel();
		hitpointChangeLabel = new javax.swing.JLabel();
		hitpointIcon = new javax.swing.JLabel();
		armorClassIcon = new javax.swing.JLabel();
		creatureSaveIcon = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		mobDetailsPanel = new javax.swing.JPanel();
		attackCountLabel = new javax.swing.JLabel();
		sourceLabel = new javax.swing.JLabel();
		moveLabel = new javax.swing.JLabel();
		specialDefenseLabel = new javax.swing.JLabel();
		hdLabel = new javax.swing.JLabel();
		specialAttackLabel = new javax.swing.JLabel();
		sizeLabel = new javax.swing.JLabel();
		magicResistanceLabel = new javax.swing.JLabel();
		thacoLabel = new javax.swing.JLabel();
		damageLabel = new javax.swing.JLabel();
		intelligenceLabel = new javax.swing.JLabel();
		savesPanel = new javax.swing.JPanel();
		saveDeathNameLabel = new javax.swing.JLabel();
		saveDeathTextField = new javax.swing.JTextField();
		savePolyNameLabel = new javax.swing.JLabel();
		savePolyTextField = new javax.swing.JTextField();
		saveRodNameLabel = new javax.swing.JLabel();
		saveRodTextField = new javax.swing.JTextField();
		saveBreathNameLabel = new javax.swing.JLabel();
		saveBreathTextField = new javax.swing.JTextField();
		saveSpellNameLabel = new javax.swing.JLabel();
		saveSpellTextField = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		modelStatesListForCombatPanel = new DefaultListModel();
		statesEffectList = new javax.swing.JList(modelStatesListForCombatPanel);
		statesEffectList.setCellRenderer(new StatesCellRendererList());
		statesAddLabel = new javax.swing.JLabel();
		healthBarPanel = new javax.swing.JPanel();
		hitpointSlider = new javax.swing.JSlider();
		attackChartPanel = new javax.swing.JPanel();
		attacksPanel = new javax.swing.JPanel();
		notesPanel = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		notesTextArea = new javax.swing.JTextArea();

		stateNameMenuItem.setText("Working On");
		stateNameMenuItem.setEnabled(false);
		statePopupMenu.add(stateNameMenuItem);
		statePopupMenu.add(jSeparator2);

		stateEditMenuItem.setText("Edit");
		statePopupMenu.add(stateEditMenuItem);

		stateDeleteMenuItem.setText("Delete");
		stateDeleteMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						stateDeleteMenuItemActionPerformed(evt);
					}
				});
		statePopupMenu.add(stateDeleteMenuItem);
		statePopupMenu.add(jSeparator1);

		stateCancelMenuItem.setText("Cancel");
		stateCancelMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						stateCancelMenuItemActionPerformed(evt);
					}
				});
		statePopupMenu.add(stateCancelMenuItem);

		creatureTagNameMenuItem.setText("CreatureName");
		creatureTagNameMenuItem.setEnabled(false);
		creatureTagNamePopupMenu.add(creatureTagNameMenuItem);

		creatureNameEditMenuItem.setText("Edit Name");
		creatureNameEditMenuItem.setToolTipText("Change creature name.");
		creatureNameEditMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureNameEditMenuItemActionPerformed(evt);
					}
				});
		creatureTagNamePopupMenu.add(creatureNameEditMenuItem);
		creatureTagNamePopupMenu.add(jSeparator3);

		creatureTagAddMenuItem.setText("Add Tag");
		creatureTagAddMenuItem.setToolTipText("Add tag to creatures name");
		creatureTagAddMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureTagAddMenuItemActionPerformed(evt);
					}
				});
		creatureTagNamePopupMenu.add(creatureTagAddMenuItem);

		creatureTagEditMenuItem.setText("Edit");
		creatureTagEditMenuItem.setToolTipText("Edit tag");
		creatureTagEditMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureTagEditMenuItemActionPerformed(evt);
					}
				});
		creatureTagNamePopupMenu.add(creatureTagEditMenuItem);

		creatureTagDeleteMenuItem.setText("Delete Tag");
		creatureTagDeleteMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureTagDeleteMenuItemActionPerformed(evt);
					}
				});
		creatureTagNamePopupMenu.add(creatureTagDeleteMenuItem);
		creatureTagNamePopupMenu.add(jSeparator4);

		creatureTagCancelMenuItem.setText("Cancel");
		creatureTagCancelMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureTagCancelMenuItemActionPerformed(evt);
					}
				});
		creatureTagNamePopupMenu.add(creatureTagCancelMenuItem);

		creatureSheetDialog.setTitle("Creature Sheet");
		creatureSheetDialog.setAlwaysOnTop(true);
		creatureSheetDialog.setCursor(new java.awt.Cursor(
				java.awt.Cursor.DEFAULT_CURSOR));
		creatureSheetDialog.setMinimumSize(new java.awt.Dimension(480, 500));

		creatureSheetScrollPane
				.setBackground(new java.awt.Color(204, 204, 204));
		creatureSheetScrollPane.setBorder(javax.swing.BorderFactory
				.createTitledBorder(javax.swing.BorderFactory
						.createLineBorder(new java.awt.Color(0, 0, 0)),
						"CreatureNameHere"));

		creatureSheetTextArea.setBackground(new java.awt.Color(204, 204, 204));
		creatureSheetTextArea.setColumns(20);
		creatureSheetTextArea.setEditable(false);
		creatureSheetTextArea.setLineWrap(true);
		creatureSheetTextArea.setRows(5);
		creatureSheetTextArea.setWrapStyleWord(true);
		creatureSheetScrollPane.setViewportView(creatureSheetTextArea);

		creatureSheetDialog.getContentPane().add(creatureSheetScrollPane,
				java.awt.BorderLayout.CENTER);

		buttonPanel.setBackground(new java.awt.Color(153, 153, 153));

		doneButton.setBackground(new java.awt.Color(204, 204, 204));
		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(doneButton);

		creatureSheetDialog.getContentPane().add(buttonPanel,
				java.awt.BorderLayout.PAGE_END);

		acDetailsMenuItem.setText("Item");
		acDetailsMenuItem.setEnabled(false);
		acPopupMenu.add(acDetailsMenuItem);
		acPopupMenu.add(jSeparator5);

		acEditMenuItem.setText("Edit AC");
		acEditMenuItem.setToolTipText("Change Armor Class value.");
		acEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				acEditMenuItemActionPerformed(evt);
			}
		});
		acPopupMenu.add(acEditMenuItem);
		acPopupMenu.add(jSeparator6);

		acCancelMenuItem.setText("Cancel");
		acPopupMenu.add(acCancelMenuItem);

		hpDetailsMenuItem.setText("Item");
		hpDetailsMenuItem.setEnabled(false);
		hpPopupMenu.add(hpDetailsMenuItem);
		hpPopupMenu.add(jSeparator7);

		hpEditMenuItem.setText("Edit Hitpoints");
		hpEditMenuItem.setToolTipText("Change maximum hitpoints.");
		hpEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hpEditMenuItemActionPerformed(evt);
			}
		});
		hpPopupMenu.add(hpEditMenuItem);
		hpPopupMenu.add(jSeparator8);

		hpCancelMenuItem.setText("Cancel");
		hpPopupMenu.add(hpCancelMenuItem);

		attackAddMenuItem.setText("Add Attack");
		attackAddMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						attackAddMenuItemActionPerformed(evt);
					}
				});
		attackPopupMenu.add(attackAddMenuItem);
		attackPopupMenu.add(jSeparator9);

		attackCancelMenuItem.setText("Cancel");
		attackPopupMenu.add(attackCancelMenuItem);

		saveDeathMenuItem.setText("Paralyzation, Poison or Death");
		saveDeathMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveDeathMenuItemActionPerformed(evt);
					}
				});
		creatureSavePopupMenu.add(saveDeathMenuItem);

		savePolymorphMenuItem.setText("Petrification or Polymorph");
		savePolymorphMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						savePolymorphMenuItemActionPerformed(evt);
					}
				});
		creatureSavePopupMenu.add(savePolymorphMenuItem);

		saveRodStaffWandMenuItem.setText("Rod, Staff or Wand");
		saveRodStaffWandMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveRodStaffWandMenuItemActionPerformed(evt);
					}
				});
		creatureSavePopupMenu.add(saveRodStaffWandMenuItem);

		saveBreathMenuItem.setText("Breath Weapon");
		saveBreathMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveBreathMenuItemActionPerformed(evt);
					}
				});
		creatureSavePopupMenu.add(saveBreathMenuItem);

		saveSpellsMenuItem.setText("Spells");
		saveSpellsMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveSpellsMenuItemActionPerformed(evt);
					}
				});
		creatureSavePopupMenu.add(saveSpellsMenuItem);

		saveCancelMenuItem.setText("Cancel");
		creatureSavePopupMenu.add(saveCancelMenuItem);

		addAttackPanel.setBackground(new java.awt.Color(153, 153, 153));
		addAttackPanel.setMinimumSize(new java.awt.Dimension(100, 100));

		addAttackIcon.setBackground(new java.awt.Color(204, 204, 204));
		addAttackIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Actions-list-add-icon.png"))); // NOI18N
		addAttackIcon.setLabelFor(addAttackIcon);
		addAttackIcon.setToolTipText("Add more attacks.");
		addAttackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addAttackIconMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout addAttackPanelLayout = new javax.swing.GroupLayout(
				addAttackPanel);
		addAttackPanel.setLayout(addAttackPanelLayout);
		addAttackPanelLayout.setHorizontalGroup(addAttackPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(addAttackIcon,
						javax.swing.GroupLayout.PREFERRED_SIZE, 100,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		addAttackPanelLayout
				.setVerticalGroup(addAttackPanelLayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								addAttackPanelLayout.createSequentialGroup()
										.addGap(84, 84, 84)
										.addComponent(addAttackIcon)));

		setBackground(new java.awt.Color(102, 102, 102));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(255, 153,
						0), 1, true), "CreatureNameHere",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(255,
						255, 51)));
		setToolTipText("Right click to edit name or set \"tag\".");
		setFont(new java.awt.Font("Segoe UI", 0, 14));
		setName("Creature-Panel");
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				formMousePressed(evt);
			}
		});

		statsSubPanel1.setBackground(new java.awt.Color(204, 204, 204));
		statsSubPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Stats",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		statsSubPanel1.setToolTipText("");
		statsSubPanel1.setName("Stats-Sub-Panel");

		jLayeredPane1.setBackground(new java.awt.Color(255, 204, 0));

		helpIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		helpIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/16-Help-Info-2-icon.png"))); // NOI18N
		helpIcon.setToolTipText("Click to see creature sheet.");
		helpIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				helpIconMousePressed(evt);
			}
		});
		helpIcon.setBounds(0, 0, 20, 16);
		jLayeredPane1.add(helpIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

		armorClassLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		armorClassLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		armorClassLabel.setText("10");
		armorClassLabel.setBounds(0, 10, 60, 21);
		jLayeredPane1.add(armorClassLabel,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		hitpointLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		hitpointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		hitpointLabel.setText("21");
		hitpointLabel.setBounds(50, 10, 60, 30);
		jLayeredPane1
				.add(hitpointLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

		hitpointChangeLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		hitpointChangeLabel.setText("(0)");
		hitpointChangeLabel.setToolTipText("Health adjustment.");
		hitpointChangeLabel.setBounds(90, 40, 30, 21);
		jLayeredPane1.add(hitpointChangeLabel,
				javax.swing.JLayeredPane.DEFAULT_LAYER);
		hitpointChangeLabel.setText("");

		hitpointIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		hitpointIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Heart-icon.png"))); // NOI18N
		hitpointIcon.setLabelFor(hitpointIcon);
		hitpointIcon
				.setToolTipText("Hit points remaining. Right click to change maximum value.");
		hitpointIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				hitpointIconMousePressed(evt);
			}
		});
		hitpointIcon.setBounds(50, -10, 64, 64);
		jLayeredPane1.add(hitpointIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

		armorClassIcon
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		armorClassIcon.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/shield-icon.png"))); // NOI18N
		armorClassIcon.setLabelFor(armorClassIcon);
		armorClassIcon
				.setToolTipText("Armor Class Value. Right click to change value.");
		armorClassIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				armorClassIconMousePressed(evt);
			}
		});
		armorClassIcon.setBounds(0, 0, 60, 60);
		jLayeredPane1.add(armorClassIcon,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		creatureSaveIcon.setFont(new java.awt.Font("Segoe UI", 1, 10));
		creatureSaveIcon
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		creatureSaveIcon.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/32-Fire-Dragon-Breath-icon.png"))); // NOI18N
		creatureSaveIcon.setLabelFor(creatureSaveIcon);
		creatureSaveIcon.setText("Save!");
		creatureSaveIcon.setToolTipText("Roll save for this creature.");
		creatureSaveIcon.setIconTextGap(1);
		creatureSaveIcon
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		creatureSaveIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				creatureSaveIconMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				creatureSaveIconMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				creatureSaveIconMousePressed(evt);
			}
		});
		creatureSaveIcon.setBounds(40, 40, 60, 50);
		jLayeredPane1.add(creatureSaveIcon,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));

		mobDetailsPanel.setBackground(new java.awt.Color(204, 204, 204));
		mobDetailsPanel.setLayout(new java.awt.GridBagLayout());

		attackCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		attackCountLabel.setText("Attacks:");
		attackCountLabel.setToolTipText("Number of attack routines per round.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mobDetailsPanel.add(attackCountLabel, gridBagConstraints);

		sourceLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		sourceLabel.setText("Source");
		sourceLabel.setToolTipText("What book can you find this creature in.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		mobDetailsPanel.add(sourceLabel, gridBagConstraints);

		moveLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		moveLabel.setText("Move");
		moveLabel.setToolTipText("Move base of the creature.");
		moveLabel.setPreferredSize(new java.awt.Dimension(13, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		mobDetailsPanel.add(moveLabel, gridBagConstraints);

		specialDefenseLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialDefenseLabel.setText("SD:");
		specialDefenseLabel.setToolTipText("Special defenses.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		mobDetailsPanel.add(specialDefenseLabel, gridBagConstraints);

		hdLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		hdLabel.setText("HD: ");
		hdLabel.setToolTipText("Creatures Hit Dice.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		mobDetailsPanel.add(hdLabel, gridBagConstraints);

		specialAttackLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialAttackLabel.setText("SA:");
		specialAttackLabel.setToolTipText("Special attacks.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		mobDetailsPanel.add(specialAttackLabel, gridBagConstraints);

		sizeLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		sizeLabel.setText("Size");
		sizeLabel.setToolTipText("Creature size");
		sizeLabel.setPreferredSize(new java.awt.Dimension(13, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		mobDetailsPanel.add(sizeLabel, gridBagConstraints);

		magicResistanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		magicResistanceLabel.setText("MR:");
		magicResistanceLabel.setToolTipText("Magic Resistances");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		mobDetailsPanel.add(magicResistanceLabel, gridBagConstraints);

		thacoLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		thacoLabel.setText("THACO/BaB: ");
		thacoLabel.setToolTipText("To hit AC 0/Base Attack Bonus");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mobDetailsPanel.add(thacoLabel, gridBagConstraints);

		damageLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		damageLabel.setText("Damage:");
		damageLabel.setToolTipText("Damage that the creature can do.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		mobDetailsPanel.add(damageLabel, gridBagConstraints);

		intelligenceLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		intelligenceLabel.setText("Intelligence:");
		intelligenceLabel.setToolTipText("Creature's intelligence level.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		mobDetailsPanel.add(intelligenceLabel, gridBagConstraints);

		savesPanel.setBackground(new java.awt.Color(204, 204, 204));
		savesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Saves",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.TOP, new java.awt.Font(
						"Segoe UI", 0, 8)));
		savesPanel.setToolTipText("Left click on save value to roll save.");
		savesPanel.setLayout(new java.awt.GridBagLayout());

		saveDeathNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveDeathNameLabel.setText("Save1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		savesPanel.add(saveDeathNameLabel, gridBagConstraints);

		saveDeathTextField.setBackground(new java.awt.Color(204, 255, 204));
		saveDeathTextField.setEditable(false);
		saveDeathTextField.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveDeathTextField.setText("  ");
		saveDeathTextField
				.setToolTipText("Left click on save value to roll save.");
		saveDeathTextField.setPreferredSize(new java.awt.Dimension(15, 13));
		saveDeathTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				saveDeathTextFieldMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		savesPanel.add(saveDeathTextField, gridBagConstraints);

		savePolyNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		savePolyNameLabel.setText("Save1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		savesPanel.add(savePolyNameLabel, gridBagConstraints);

		savePolyTextField.setBackground(new java.awt.Color(204, 255, 204));
		savePolyTextField.setEditable(false);
		savePolyTextField.setFont(new java.awt.Font("Segoe UI", 0, 8));
		savePolyTextField.setText("  ");
		savePolyTextField
				.setToolTipText("Left click on save value to roll save.");
		savePolyTextField.setPreferredSize(new java.awt.Dimension(15, 13));
		savePolyTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				savePolyTextFieldMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		savesPanel.add(savePolyTextField, gridBagConstraints);

		saveRodNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveRodNameLabel.setText("Save1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		savesPanel.add(saveRodNameLabel, gridBagConstraints);

		saveRodTextField.setBackground(new java.awt.Color(204, 255, 204));
		saveRodTextField.setEditable(false);
		saveRodTextField.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveRodTextField.setText("  ");
		saveRodTextField
				.setToolTipText("Left click on save value to roll save.");
		saveRodTextField.setPreferredSize(new java.awt.Dimension(15, 13));
		saveRodTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				saveRodTextFieldMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		savesPanel.add(saveRodTextField, gridBagConstraints);

		saveBreathNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveBreathNameLabel.setText("Save1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		savesPanel.add(saveBreathNameLabel, gridBagConstraints);

		saveBreathTextField.setBackground(new java.awt.Color(204, 255, 204));
		saveBreathTextField.setEditable(false);
		saveBreathTextField.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveBreathTextField.setText("  ");
		saveBreathTextField
				.setToolTipText("Left click on save value to roll save.");
		saveBreathTextField.setPreferredSize(new java.awt.Dimension(15, 13));
		saveBreathTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				saveBreathTextFieldMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		savesPanel.add(saveBreathTextField, gridBagConstraints);

		saveSpellNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveSpellNameLabel.setText("Save1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		savesPanel.add(saveSpellNameLabel, gridBagConstraints);

		saveSpellTextField.setBackground(new java.awt.Color(204, 255, 204));
		saveSpellTextField.setEditable(false);
		saveSpellTextField.setFont(new java.awt.Font("Segoe UI", 0, 8));
		saveSpellTextField.setText("  ");
		saveSpellTextField
				.setToolTipText("Left click on save value to roll save.");
		saveSpellTextField.setPreferredSize(new java.awt.Dimension(15, 13));
		saveSpellTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				saveSpellTextFieldMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		savesPanel.add(saveSpellTextField, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		mobDetailsPanel.add(savesPanel, gridBagConstraints);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mobDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addComponent(mobDetailsPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));
		jScrollPane2
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 8));

		statesEffectList.setBackground(new java.awt.Color(204, 204, 204));
		statesEffectList.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		statesEffectList.setFont(new java.awt.Font("Segoe UI", 0, 8));
		statesEffectList.setModel(modelStatesListForCombatPanel);
		statesEffectList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		statesEffectList.setToolTipText("Right click states for more options.");
		statesEffectList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				statesEffectListMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(statesEffectList);

		statesAddLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		statesAddLabel.setText("Add State");
		statesAddLabel.setToolTipText("Add state to this creature.");
		statesAddLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				statesAddLabelMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				statesAddLabelMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				statesAddLabelMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				statesAddLabelMousePressed(evt);
			}
		});

		javax.swing.GroupLayout statsSubPanel1Layout = new javax.swing.GroupLayout(
				statsSubPanel1);
		statsSubPanel1.setLayout(statsSubPanel1Layout);
		statsSubPanel1Layout
				.setHorizontalGroup(statsSubPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								statsSubPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jLayeredPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												119,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												statsSubPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																statsSubPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				statesAddLabel)
																		.addGap(13,
																				13,
																				13))
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																73,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(198, Short.MAX_VALUE)));
		statsSubPanel1Layout
				.setVerticalGroup(statsSubPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								statsSubPanel1Layout
										.createSequentialGroup()
										.addGroup(
												statsSubPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLayeredPane1,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addGroup(
																statsSubPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				64,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(2,
																				2,
																				2)
																		.addComponent(
																				statesAddLabel))
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																92,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		healthBarPanel.setBackground(new java.awt.Color(204, 204, 204));
		healthBarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Health Bar",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		healthBarPanel.setToolTipText("");
		healthBarPanel.setMinimumSize(new java.awt.Dimension(0, 0));
		healthBarPanel.setName("Health-Bar");
		healthBarPanel.setLayout(new javax.swing.BoxLayout(healthBarPanel,
				javax.swing.BoxLayout.LINE_AXIS));

		hitpointSlider.setBackground(new java.awt.Color(204, 204, 204));
		hitpointSlider.setFont(new java.awt.Font("Tahoma", 0, 10));
		hitpointSlider.setForeground(new java.awt.Color(153, 0, 0));
		hitpointSlider.setMajorTickSpacing(5);
		hitpointSlider.setMaximum(50);
		hitpointSlider.setMinorTickSpacing(1);
		hitpointSlider.setPaintLabels(true);
		hitpointSlider.setPaintTicks(true);
		hitpointSlider.setSnapToTicks(true);
		hitpointSlider.setToolTipText("Adjust creatures health.");
		hitpointSlider.setValue(10);
		hitpointSlider.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				hitpointSliderMouseReleased(evt);
			}
		});
		hitpointSlider
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						hitpointSliderStateChanged(evt);
					}
				});
		hitpointSlider
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						hitpointSliderPropertyChange(evt);
					}
				});
		healthBarPanel.add(hitpointSlider);

		attackChartPanel.setBackground(new java.awt.Color(153, 153, 153));
		attackChartPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Attack Chart",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));
		attackChartPanel.setLayout(new java.awt.BorderLayout());

		attacksPanel.setBackground(new java.awt.Color(153, 153, 153));
		attacksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Attacks",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		attacksPanel.setToolTipText("Right click to add more attacks.");
		attacksPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				attacksPanelMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout attacksPanelLayout = new javax.swing.GroupLayout(
				attacksPanel);
		attacksPanel.setLayout(attacksPanelLayout);
		attacksPanelLayout.setHorizontalGroup(attacksPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 785, Short.MAX_VALUE));
		attacksPanelLayout.setVerticalGroup(attacksPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 207, Short.MAX_VALUE));

		notesPanel.setLayout(new java.awt.BorderLayout());

		jScrollPane3.setBackground(new java.awt.Color(204, 204, 204));
		jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Notes"));

		notesTextArea.setColumns(20);
		notesTextArea.setLineWrap(true);
		notesTextArea.setRows(5);
		notesTextArea.setWrapStyleWord(true);
		jScrollPane3.setViewportView(notesTextArea);

		notesPanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(notesPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
						795, Short.MAX_VALUE)
				.addComponent(statsSubPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(healthBarPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 795,
						Short.MAX_VALUE)
				.addComponent(attacksPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(attackChartPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 795,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(statsSubPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(healthBarPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 77,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(attackChartPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 63,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(attacksPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(2, 2, 2)
						.addComponent(notesPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE, 108,
								Short.MAX_VALUE)));

		attacksPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
		attacksPanel.setSize(new Dimension(100, 1));
	}// </editor-fold>
	//GEN-END:initComponents

	private void saveSpellTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			doSaveRoll(Integer.parseInt(saveSpellTextField.getText()),
					SAVES[SAVE_SPELL]);
		}
	}

	private void saveBreathTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			doSaveRoll(Integer.parseInt(saveBreathTextField.getText()),
					SAVES[SAVE_BREATH]);
		}
	}

	private void saveRodTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			doSaveRoll(Integer.parseInt(saveRodTextField.getText()),
					SAVES[SAVE_ROD]);
		}
	}

	private void savePolyTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			doSaveRoll(Integer.parseInt(savePolyTextField.getText()),
					SAVES[SAVE_POLY]);
		}

	}

	private void saveDeathTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			doSaveRoll(Integer.parseInt(saveDeathTextField.getText()),
					SAVES[SAVE_DEATH]);
		}
	}

	private void addAttackIconMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			attackAddMenuItemActionPerformed(null);
		}

	}

	//GEN-END:initComponents

	private void creatureSaveIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			creatureSavePopupMenu
					.show(creatureSaveIcon, evt.getX(), evt.getY());
		}
	}

	private void creatureSaveIconMouseExited(java.awt.event.MouseEvent evt) {
		creatureSaveIcon.setForeground(Color.BLACK);
	}

	void creatureSaveIconMouseEntered(java.awt.event.MouseEvent evt) {
		creatureSaveIcon.setForeground(Color.red);
	}

	private void saveSpellsMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		JMenuItem mI = (JMenuItem) evt.getSource();
		doSaveRoll(oC.getSave(SAVE_SPELL, ost.chartList.getContent()),
				mI.getText());
	}

	private void saveBreathMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		JMenuItem mI = (JMenuItem) evt.getSource();
		doSaveRoll(oC.getSave(SAVE_BREATH, ost.chartList.getContent()),
				mI.getText());
	}

	private void saveRodStaffWandMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		JMenuItem mI = (JMenuItem) evt.getSource();
		doSaveRoll(oC.getSave(SAVE_ROD, ost.chartList.getContent()),
				mI.getText());
	}

	private void savePolymorphMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		JMenuItem mI = (JMenuItem) evt.getSource();
		doSaveRoll(oC.getSave(SAVE_POLY, ost.chartList.getContent()),
				mI.getText());
	}

	private void saveDeathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JMenuItem mI = (JMenuItem) evt.getSource();
		doSaveRoll(oC.getSave(SAVE_DEATH, ost.chartList.getContent()),
				mI.getText());
	}

	private void setSavePanelDetails(CreatureClass oCreature) {
		ArrayList<String> saveList = oCreature.getSaves(ost.chartList
				.getContent());
		saveDeathTextField.setText(saveList.get(SAVE_DEATH));
		saveDeathNameLabel.setToolTipText(SAVES[SAVE_DEATH]);
		saveDeathNameLabel.setText(SAVES_ABBREV[SAVE_DEATH]);

		savePolyTextField.setText(saveList.get(SAVE_POLY));
		savePolyNameLabel.setToolTipText(SAVES[SAVE_POLY]);
		savePolyNameLabel.setText(SAVES_ABBREV[SAVE_POLY]);

		saveRodTextField.setText(saveList.get(SAVE_ROD));
		saveRodNameLabel.setToolTipText(SAVES[SAVE_ROD]);
		saveRodNameLabel.setText(SAVES_ABBREV[SAVE_ROD]);

		saveBreathTextField.setText(saveList.get(SAVE_BREATH));
		saveBreathNameLabel.setToolTipText(SAVES[SAVE_BREATH]);
		saveBreathNameLabel.setText(SAVES_ABBREV[SAVE_BREATH]);

		saveSpellTextField.setText(saveList.get(SAVE_SPELL));
		saveSpellNameLabel.setToolTipText(SAVES[SAVE_SPELL]);
		saveSpellNameLabel.setText(SAVES_ABBREV[SAVE_SPELL]);
	}

	private void setAttackChartPanelDetails(CreatureClass oCreature) {
		ArrayList<String> attackList = oCreature.getMatrix(ost.chartList
				.getContent());
		// table stored backwards and as String, lets flip it and 
		// convert to integer
		int[] atkList = new int[attackList.size()];

		// if using 2e THACO mode, make a attach chart based on the THACO value
		// from creature struct
		if (ost.mainFrame.thacoModeRadioButton.isSelected()) {
			int nThaco = oC.getTHACO(null);
			for (int i = 0; i < MAX_MATRIX; i++)
				atkList[i] = nThaco-(10-i);
		} else
			// otherwise we use HD, figure out thaco and build one (1e/basic style)
		for (int i = attackList.size(); i > 0; i--)
			atkList[MAX_MATRIX - i] = Integer.parseInt(attackList.get(i - 1));

		
		attackChartPanel.removeAll();
		JTable matrix = Utils.getMatrixTable(atkList);
		attackChartPanel.add(matrix.getTableHeader(), BorderLayout.PAGE_START);
		attackChartPanel.add(matrix, BorderLayout.CENTER);

		//		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		//		attackChartTable.getTableHeader().setFont(fFont);
		//		attackChartTable.getTableHeader().setBackground(Color.yellow);
		//
		//		// this is to make the headers align left to match the numbers
		//		TableCellRenderer rendererFromHeader = attackChartTable
		//				.getTableHeader().getDefaultRenderer();
		//		JLabel headerLabel = (JLabel) rendererFromHeader;
		//		headerLabel.setHorizontalAlignment(JLabel.LEFT);
		//
		//		for (int i = 0; i < attackList.size(); i++) {
		//			//			int acNumber = (10 - i);
		//			int atkRollNeeded = Integer.parseInt(attackList.get(attackList
		//					.size() - (i + 1)));
		//			attackChartTable.setValueAt(atkRollNeeded, 0, i);
		//		}
	}

	/**
	 * display a save result
	 * @param mySave
	 * @param saveName
	 */
	private void doSaveRoll(int mySave, String saveName) {
		int d20 = MyRandomClass.rollDice(1, 20);
		String saveResult = "";
		if (d20 >= mySave) {
			//Saved!
			saveResult = String.format("Saved versus %s. Rolled %d, needed %d",
					saveName, d20, mySave);
			SimpleDialog.showDone(saveResult);
		} else {
			//FAILED!
			saveResult = String.format(
					"FAILED versus %s. Rolled %d, needed %d", saveName, d20,
					mySave);
			SimpleDialog.showError(saveResult);
		}
		ost.dprint(oC.getName() + ":" + saveResult + "\n");
	}

	public void creatureNameEditMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		String sNewName = SimpleDialog.showQuestion(creatureNameEditMenuItem,
				"New name for " + oC.getName(), "New Name", oC.getName());
		if (!sNewName.isEmpty()) {
			oC.setName(sNewName);
			creatureTitleBorder.setTitle(String.format("%s%s", oC.getName(), oC
					.getTag().isEmpty() ? "" : " [" + oC.getTag() + "]"));
			//this.revalidate();
			DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
					ost.encounterFrame.encountersTreeModel,
					ost.encounterFrame.nodeNPC, oC);
			ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
			repaint();
		}
	}

	private void attackAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String supAtk = "";
		while (!MyParse.isInteger(MyParse.parseDice(supAtk))) {
			supAtk = SimpleDialog.showQuestion(this, "Add new attack.",
					"Attack damage", "1d6");
		}
		CreatureAttackClass oA = new CreatureAttackClass(supAtk, -1);
		oA.setAttackName("Other");
		oC.getAttackList().add(oA); // add to array
		attacksPanel.remove(addAttackPanel);
		addAttackToCreature(oA, oC); // add to panel
		attacksPanel.add(addAttackPanel);
		attacksPanel.revalidate();
	}

	private void attacksPanelMouseClicked(java.awt.event.MouseEvent evt) {
		// right clicked...
		if (evt.getButton() == MouseEvent.BUTTON3) {
			attackPopupMenu.show(attacksPanel, evt.getX(), evt.getY());
		}
	}

	public void hpEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String newHP = "";
		while (!MyParse.isInteger(newHP)) {
			newHP = SimpleDialog.showQuestion(hpPopupMenu, "New Max HP Value",
					"Max HP", oC.getMaxHP());
			// has to be at least 1 hp
			if (MyParse.isInteger(newHP) && Integer.parseInt(newHP) > 0) {
				oC.setMaxHP(newHP);
				oC.setHitPoints(newHP);
				hpBarLast = Integer.parseInt(newHP);
				hitpointSlider.setMaximum(hpBarLast);
				hitpointSlider.setValue(hpBarLast);
				hitpointLabel.setText(oC.getMaxHP());
				hitpointSliderMouseReleased(null);
			} else {
				newHP = "";
			}
		}
	}

	public void acEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		oC.setAC(SimpleDialog.showQuestion(acPopupMenu, "New Armor Class",
				"New AC", oC.getAC()));
		armorClassLabel.setText(MyParse.displayArmorClass(
				ost.mainFrame.d20ModeRadioButton.isSelected(), oC.getAC()));
	}

	private void hitpointIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) {
			hpDetailsMenuItem.setText(String.format("MaxHP:%s", oC.getMaxHP()));
			hpPopupMenu.show(statsSubPanel1, evt.getX(), evt.getY());
		}
	}

	private void armorClassIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) {
			acDetailsMenuItem.setText(String.format("AC:%s", oC.getAC()));
			acPopupMenu.show(statsSubPanel1, evt.getX(), evt.getY());
		}
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		creatureSheetDialog.setVisible(false);
	}

	private void helpIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			//			loadCreatureSheetIntoDialog();
			creatureSheetDialog.setLocation(MouseInfo.getPointerInfo()
					.getLocation());
			creatureSheetDialog.setVisible(true);
		}
	}

	void addCreatureFeature(String topic, String desc) {
		creatureSheetTextArea.append(String.format("%s\t%s\n", topic, desc));
	}

	void loadCreatureSheetIntoDialog() {

		myThaco = oC.getTHACO(ost.chartList.getContent());
		thacoLabel.setText(String.format("THACO/BaB: %d/%d", myThaco,
				oC.getBab(ost.chartList.getContent())));

		creatureSheetTextArea.setText(""); // clear the description panel

		addCreatureFeature("Source", oC.getSource());
		addCreatureFeature("Freq", oC.getFrequency());
		addCreatureFeature(
				"Armor Class",
				MyParse.displayArmorClass(
						ost.mainFrame.d20ModeRadioButton.isSelected(),
						oC.getAC()));
		addCreatureFeature("Move", oC.getMove());
		addCreatureFeature("HD", oC.getHD());
		//		addCreatureFeature("atkHD", oC.getMatrixHD());
		addCreatureFeature("In Lair %", oC.getInLair());
		addCreatureFeature("Treasure Type", oC.getTreasure());
		addCreatureFeature("# of Attacks", String.format("%d", oC.getAttacks()));
		addCreatureFeature("Damage", oC.getDamage());
		addCreatureFeature("Special Atk", oC.getSpecialAttack());
		addCreatureFeature("Special Def", oC.getSpecialDefense());
		addCreatureFeature("Magic Res.", oC.getMagicResistance());
		addCreatureFeature("Intelligence", oC.getIntelligence());
		addCreatureFeature("Alignment", oC.getAlignment());
		addCreatureFeature("Size", oC.getSize());
		addCreatureFeature(
				"THACO/BaB",
				String.format("%d/%d", myThaco,
						oC.getBab(ost.chartList.getContent())));

		addCreatureFeature("Description", "\n" + oC.getDescription());
	}

	private void creatureTagEditMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		creatureTagNamePopupMenu.setVisible(false);
		oC.setTag(SimpleDialog.showQuestion(this, "Edit tag", "Editing Tag",
				oC.getTag()));
		creatureTitleBorder.setTitle(String.format("%s [%s]", oC.getName(),
				oC.getTag()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodeNPC, oC);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	private void creatureTagCancelMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		creatureTagNamePopupMenu.setVisible(false);
	}

	private void creatureTagDeleteMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		creatureTagNamePopupMenu.setVisible(false);
		oC.setTag("");
		creatureTitleBorder.setTitle(String.format("%s", oC.getName()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodeNPC, oC);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	public void creatureTagAddMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		creatureTagNamePopupMenu.setVisible(false);
		oC.setTag(SimpleDialog.showQuestion(this, "Enter tag or brief note",
				"Adding Tag", oC.getTag()));
		creatureTitleBorder.setTitle(String.format("%s [%s]", oC.getName(),
				oC.getTag()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodeNPC, oC);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	private void formMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) { // right click
			creatureTagNamePopupMenu.setLocation(MouseInfo.getPointerInfo()
					.getLocation());
			creatureTagAddMenuItem.setEnabled(oC.getTag().isEmpty());
			creatureTagEditMenuItem.setEnabled(!oC.getTag().isEmpty());
			creatureTagDeleteMenuItem.setEnabled(!oC.getTag().isEmpty());
			creatureTagNameMenuItem.setText(oC.getName());
			creatureTagNamePopupMenu.show(this, evt.getX(), evt.getY());
		}
	}

	private void stateDeleteMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		StatesClass oS = (StatesClass) statesEffectList.getSelectedValue();
		modelStatesListForCombatPanel.removeElement(oS);
		oC.getStates().remove(oS);
		statePopupMenu.setVisible(false);
	}

	private void stateCancelMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		statePopupMenu.setVisible(false);
	}

	private void statesEffectListMouseClicked(java.awt.event.MouseEvent evt) {
		StatesClass oS = (StatesClass) statesEffectList.getSelectedValue();
		if (oS != null) {
			// right click on item and we do these
			if (evt.getButton() == MouseEvent.BUTTON3) {
				stateEditMenuItem.setEnabled(false); // disabled for now

				stateNameMenuItem.setText(oS.getName());
				stateNameMenuItem
						.setToolTipText("You will be making changes to "
								+ oS.getName());
				statePopupMenu.show(statesEffectList, evt.getX(), evt.getY());
			}
		}

	}

	private void statesAddLabelMousePressed(java.awt.event.MouseEvent evt) {
		statesAddLabelMouseClicked(evt);
	}

	private void statesAddLabelMouseExited(java.awt.event.MouseEvent evt) {
		statesAddLabel.setForeground(Color.black);
	}

	private void statesAddLabelMouseEntered(java.awt.event.MouseEvent evt) {
		statesAddLabel.setForeground(Color.BLUE);
	}

	private void statesAddLabelMouseClicked(java.awt.event.MouseEvent evt) {
		//		statesAddDialog.setLocation(MouseInfo.getPointerInfo().getLocation());
		//		statesComboBox.setSelectedIndex(0);
		//		statesAddDialog.setVisible(true);
		ost.mainFrame.currentStatesAddObject = oC;
		ost.mainFrame.statesAddDialog.setLocation(MouseInfo.getPointerInfo()
				.getLocation());
		ost.mainFrame.statesAddDialog.setVisible(true);
	}

	// this is to remove the (-0) you get when first making slider
	private void hitpointSliderPropertyChange(java.beans.PropertyChangeEvent evt) {
		hitpointChangeLabel.setText("");
	}

	// mouse released, new hpBar value
	private void hitpointSliderMouseReleased(java.awt.event.MouseEvent evt) {
		int hpBarPrevious = hpBarLast;
		hpBarLast = hitpointSlider.getValue();
		int changeValue = hpBarLast - hpBarPrevious;
		String hpChange = String.format("health adjusted (%c%d)",
				changeValue > 0 ? '+' : '-', Math.abs(changeValue));
		ost.dprint(oC.getName() + " " + hpChange + "\n");
		//		oC.setLog(oC.getLog() + hpChange + "\n");
		//		oC.Encountered.logTextArea.setText(oC.getLog());

		oC.setHitPoints(String.format("%d", hpBarLast));
		hitpointChangeLabel.setText("");
		hitpointChangeLabel.setForeground(Color.black);
		// update the nodes in NPC since someone took damage and might be "down"
		ost.encounterFrame.encountersTreeModel.nodeChanged(Utils
				.getMyNodeByObject(ost.encounterFrame.encountersTreeModel,
						ost.encounterFrame.nodeNPC, oC));

	}

	private void hitpointSliderStateChanged(javax.swing.event.ChangeEvent evt) {
		Color mGreen = new Color(0, 153, 51);
		int currentSlider = hitpointSlider.getValue();
		int changeValue = currentSlider - hpBarLast;
		hitpointChangeLabel.setText(String.format("(%c%d)",
				changeValue > 0 ? '+' : '-', Math.abs(changeValue)));
		hitpointLabel.setText(String.format("%d", currentSlider));
		if (changeValue > 0) {
			hitpointChangeLabel.setForeground(mGreen);
		} else {
			hitpointChangeLabel.setForeground(Color.red);
		}
	}

	@SuppressWarnings("serial")
	static class StatesCellRendererList extends DefaultListCellRenderer {

		/**
		 * constructor 
		 */
		public StatesCellRendererList() {
		}

		/**
		 * 
		 */
		public Component getListCellRendererComponent(JList list, Object value,
				int nIndex, boolean bisSelected, boolean bHasFocus) {
			boolean bChangeFont = true;

			if (value instanceof StatesClass) {
				StatesClass oO = (StatesClass) value;
				setText(oO.getName());
				//
				setToolTipText(String.format("%d rounds left: %s",
						oO.getCounter(), oO.getDescription()));
				// this is to be a small object font in the list
				if (oO.isbSmallFont()) {
					bChangeFont = false;
					setFont(new Font("Dialog", Font.PLAIN, 8));
					if (oO.getCounter() < 9 && oO.getCounter() > 3)
						setForeground(Color.blue);
					else if (oO.getCounter() <= 3)
						setForeground(Color.red);
					else
						setForeground(Color.black);
					if (bisSelected) {
						setBackground(Color.BLACK);
						setForeground(Color.YELLOW);
					} else {
						setBackground(new Color(204, 204, 204));
					}
				}
			} else { // just string, not a creature, probably NO-TARGET
				setText((String) value);
			}

			if (bChangeFont) {
				// setFont(new Font("Dialog", Font.PLAIN, 10));
				setBackground(bisSelected ? Color.BLACK : Color.lightGray);
				setForeground(bisSelected ? Color.YELLOW : Color.black);
			}
			return this;
		}

	}

	/**
	 * add attack list and associated panels
	 * 
	 * @param oA
	 * @param oC
	 */
	private void addAttackToCreature(CreatureAttackClass oA, CreatureClass oC) {
		EncounterCreatureAttack oE = new EncounterCreatureAttack(ost, oC, oA);
		atkList.add(oE);
		attacksPanel.add(oE);
	}

	class ColorColumnRenderer extends DefaultTableCellRenderer {
		Color bkgndColor, fgndColor;

		public ColorColumnRenderer(Color bkgnd, Color foregnd) {
			super();
			bkgndColor = bkgnd;
			fgndColor = foregnd;
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component cell = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);

			cell.setBackground(bkgndColor);
			cell.setForeground(fgndColor);

			return cell;
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	javax.swing.JMenuItem acCancelMenuItem;
	javax.swing.JMenuItem acDetailsMenuItem;
	javax.swing.JMenuItem acEditMenuItem;
	javax.swing.JPopupMenu acPopupMenu;
	javax.swing.JLabel addAttackIcon;
	javax.swing.JPanel addAttackPanel;
	javax.swing.JLabel armorClassIcon;
	javax.swing.JLabel armorClassLabel;
	javax.swing.JMenuItem attackAddMenuItem;
	javax.swing.JMenuItem attackCancelMenuItem;
	javax.swing.JPanel attackChartPanel;
	javax.swing.JLabel attackCountLabel;
	javax.swing.JPopupMenu attackPopupMenu;
	javax.swing.JPanel attacksPanel;
	javax.swing.JPanel buttonPanel;
	public javax.swing.JMenuItem creatureNameEditMenuItem;
	javax.swing.JLabel creatureSaveIcon;
	javax.swing.JPopupMenu creatureSavePopupMenu;
	javax.swing.JDialog creatureSheetDialog;
	javax.swing.JScrollPane creatureSheetScrollPane;
	javax.swing.JTextArea creatureSheetTextArea;
	public javax.swing.JMenuItem creatureTagAddMenuItem;
	public javax.swing.JMenuItem creatureTagCancelMenuItem;
	public javax.swing.JMenuItem creatureTagDeleteMenuItem;
	public javax.swing.JMenuItem creatureTagEditMenuItem;
	public javax.swing.JMenuItem creatureTagNameMenuItem;
	public javax.swing.JPopupMenu creatureTagNamePopupMenu;
	javax.swing.JLabel damageLabel;
	javax.swing.JButton doneButton;
	javax.swing.JLabel hdLabel;
	javax.swing.JPanel healthBarPanel;
	javax.swing.JLabel helpIcon;
	javax.swing.JLabel hitpointChangeLabel;
	javax.swing.JLabel hitpointIcon;
	javax.swing.JLabel hitpointLabel;
	javax.swing.JSlider hitpointSlider;
	javax.swing.JMenuItem hpCancelMenuItem;
	javax.swing.JMenuItem hpDetailsMenuItem;
	javax.swing.JMenuItem hpEditMenuItem;
	javax.swing.JPopupMenu hpPopupMenu;
	javax.swing.JLabel intelligenceLabel;
	javax.swing.JLayeredPane jLayeredPane1;
	javax.swing.JPanel jPanel3;
	javax.swing.JScrollPane jScrollPane2;
	javax.swing.JScrollPane jScrollPane3;
	javax.swing.JSeparator jSeparator1;
	javax.swing.JSeparator jSeparator2;
	public javax.swing.JSeparator jSeparator3;
	public javax.swing.JSeparator jSeparator4;
	javax.swing.JSeparator jSeparator5;
	javax.swing.JSeparator jSeparator6;
	javax.swing.JSeparator jSeparator7;
	javax.swing.JSeparator jSeparator8;
	javax.swing.JSeparator jSeparator9;
	javax.swing.JLabel magicResistanceLabel;
	javax.swing.JPanel mobDetailsPanel;
	javax.swing.JLabel moveLabel;
	javax.swing.JPanel notesPanel;
	public javax.swing.JTextArea notesTextArea;
	javax.swing.JMenuItem saveBreathMenuItem;
	javax.swing.JLabel saveBreathNameLabel;
	javax.swing.JTextField saveBreathTextField;
	javax.swing.JMenuItem saveCancelMenuItem;
	javax.swing.JMenuItem saveDeathMenuItem;
	javax.swing.JLabel saveDeathNameLabel;
	javax.swing.JTextField saveDeathTextField;
	javax.swing.JLabel savePolyNameLabel;
	javax.swing.JTextField savePolyTextField;
	javax.swing.JMenuItem savePolymorphMenuItem;
	javax.swing.JLabel saveRodNameLabel;
	javax.swing.JMenuItem saveRodStaffWandMenuItem;
	javax.swing.JTextField saveRodTextField;
	javax.swing.JLabel saveSpellNameLabel;
	javax.swing.JTextField saveSpellTextField;
	javax.swing.JMenuItem saveSpellsMenuItem;
	javax.swing.JPanel savesPanel;
	javax.swing.JLabel sizeLabel;
	javax.swing.JLabel sourceLabel;
	javax.swing.JLabel specialAttackLabel;
	javax.swing.JLabel specialDefenseLabel;
	javax.swing.JMenuItem stateCancelMenuItem;
	javax.swing.JMenuItem stateDeleteMenuItem;
	javax.swing.JMenuItem stateEditMenuItem;
	javax.swing.JMenuItem stateNameMenuItem;
	javax.swing.JPopupMenu statePopupMenu;
	javax.swing.JLabel statesAddLabel;
	javax.swing.JList statesEffectList;
	javax.swing.JPanel statsSubPanel1;
	javax.swing.JLabel thacoLabel;
	// End of variables declaration//GEN-END:variables

	private TitledBorder creatureTitleBorder;
	private TitledBorder creatureSheetTitleBorder;
	private CreatureClass oC;
	private int hpBarLast;
	public DefaultListModel modelStatesListForCombatPanel;
	// used to store current attack list to see what is ready for coloring names
	public ArrayList<EncounterCreatureAttack> atkList;
	public int myThaco;

}