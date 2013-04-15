/*
 * EncounterPlayer.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;

import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.StatesClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.Utils.ColorColumnRenderer;

/**
 *
 * @author  __USER__
 */
public class EncounterPlayer extends javax.swing.JPanel {
	private MainClass ost;

	/** Creates new form EncounterPlayer */
	public EncounterPlayer(MainClass ost, PlayerClass oP) {
		this.ost = ost;
		this.oP = oP;
		initComponents();

		updatePanel(oP);
	}

	/**
	 * update bars/panels/values for this user
	 * 
	 * @param oP
	 */
	private void updatePanel(PlayerClass oP) {
		hpBarLast = oP.getHpCurrent();
		hitpointSlider.setMaximum(oP.getHpMax());
		hitpointSlider.setValue(oP.getHpCurrent());
		armorClassLabel.setText(MyParse.displayArmorClass(
				ost.mainFrame.d20ModeRadioButton.isSelected(), oP
						.getArmorRatings().get(0)));

		notesTextArea.setText(oP.getNotes());
		logTextArea.setText(oP.getLog());

		playerTitleBorder = (TitledBorder) this.getBorder();
		playerTitleBorder.setTitle(String.format("%s", oP.getName()));

		pcNameLabel.setText("Name: " + oP.getNamePlayer());
		pcCharacterNameLabel.setText("Player: " + oP.getName());
		levelLabel.setText("Level: " + oP.getMyLevelName(ost));
		classLabel.setText("Class: " + oP.getMyClassName(ost));
		moveLabel.setText("Move: " + oP.getModifiedMoveRate(ost));

		detailsACLabel.setText(String.format("AC:%d, Rear:%d, No Shield:%d",
				oP.getArmorClassByType(AC_NORMAL, ost),
				oP.getArmorClassByType(AC_REAR, ost),
				oP.getArmorClassByType(AC_SHIELDLESS, ost)));

		specialAttackLabel.setText("SA: " + oP.getSpecialAttacks());
		specialDefenseLabel.setText("SD: " + oP.getSpecialDefense());
		magicResistanceLabel.setText("MR: " + oP.getMagicResistance());

		// matrix bar
		//Utils.updateMatrixPanelPC(matrixPanel, oP, ost);
		JTable matrix = Utils.getMatrixTable(oP.getMatrix(ost));
		matrixPanel.add(matrix.getTableHeader(), BorderLayout.PAGE_START);
		matrixPanel.add(matrix, BorderLayout.CENTER);

		// saves
		for (int i = 0; i < oP.getMySaves().size(); i++) {
			int aB = oP.getMySaves().get(i);
			int aJ = oP.getMySaveAdjustments().get(i);
			switch (i) {
			case SAVE_BREATH:
				saveBreathNameLabel.setText(SAVES_ABBREV[i]);
				saveBreathNameLabel.setToolTipText(String.format("%s, %d - %d",
						SAVES[i], aB, aJ));
				saveBreathTextField.setText(String.format("%d", (aB - aJ)));
				break;
			case SAVE_DEATH:
				saveDeathNameLabel.setText(SAVES_ABBREV[i]);
				saveDeathNameLabel.setToolTipText(String.format("%s, %d - %d",
						SAVES[i], aB, aJ));
				saveDeathTextField.setText(String.format("%d", (aB - aJ)));
				break;
			case SAVE_POLY:
				savePolyNameLabel.setText(SAVES_ABBREV[i]);
				savePolyNameLabel.setToolTipText(String.format("%s, %d - %d",
						SAVES[i], aB, aJ));
				savePolyTextField.setText(String.format("%d", (aB - aJ)));
				break;
			case SAVE_ROD:
				saveRodNameLabel.setText(SAVES_ABBREV[i]);
				saveRodNameLabel.setToolTipText(String.format("%s, %d - %d",
						SAVES[i], aB, aJ));
				saveRodTextField.setText(String.format("%d", (aB - aJ)));
				break;
			case SAVE_SPELL:
				saveSpellNameLabel.setText(SAVES_ABBREV[i]);
				saveSpellNameLabel.setToolTipText(String.format("%s, %d - %d",
						SAVES[i], aB, aJ));
				saveSpellTextField.setText(String.format("%d", (aB - aJ)));
				break;

			default:
				ost.dprint("Unknown save type in EncounterPlayer updatePanel()\n");
				break;
			}

		}

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
		acPopupMenu = new javax.swing.JPopupMenu();
		acDetailsMenuItem = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JSeparator();
		acEditMenuItem = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JSeparator();
		acCancelMenuItem = new javax.swing.JMenuItem();
		tagNamePopupMenu = new javax.swing.JPopupMenu();
		tagNameMenuItem = new javax.swing.JMenuItem();
		nameEditMenuItem = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JSeparator();
		tagAddMenuItem = new javax.swing.JMenuItem();
		tagEditMenuItem = new javax.swing.JMenuItem();
		tagDeleteMenuItem = new javax.swing.JMenuItem();
		jSeparator4 = new javax.swing.JSeparator();
		tagCancelMenuItem = new javax.swing.JMenuItem();
		hpPopupMenu = new javax.swing.JPopupMenu();
		hpDetailsMenuItem = new javax.swing.JMenuItem();
		jSeparator7 = new javax.swing.JSeparator();
		hpEditMenuItem = new javax.swing.JMenuItem();
		jSeparator8 = new javax.swing.JSeparator();
		hpCancelMenuItem = new javax.swing.JMenuItem();
		savePopupMenu = new javax.swing.JPopupMenu();
		saveDeathMenuItem = new javax.swing.JMenuItem();
		savePolymorphMenuItem = new javax.swing.JMenuItem();
		saveRodStaffWandMenuItem = new javax.swing.JMenuItem();
		saveBreathMenuItem = new javax.swing.JMenuItem();
		saveSpellsMenuItem = new javax.swing.JMenuItem();
		saveCancelMenuItem = new javax.swing.JMenuItem();
		jPanel5 = new javax.swing.JPanel();
		statsSubPanel1 = new javax.swing.JPanel();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		helpIcon = new javax.swing.JLabel();
		armorClassLabel = new javax.swing.JLabel();
		hitpointLabel = new javax.swing.JLabel();
		hitpointChangeLabel = new javax.swing.JLabel();
		hitpointIcon = new javax.swing.JLabel();
		armorClassIcon = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		pcCharacterNameLabel = new javax.swing.JLabel();
		pcNameLabel = new javax.swing.JLabel();
		moveLabel = new javax.swing.JLabel();
		specialDefenseLabel = new javax.swing.JLabel();
		specialAttackLabel = new javax.swing.JLabel();
		magicResistanceLabel = new javax.swing.JLabel();
		levelLabel = new javax.swing.JLabel();
		classLabel = new javax.swing.JLabel();
		detailsACLabel = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		modelStatesListForCombatPanel = new DefaultListModel();
		statesEffectList = new javax.swing.JList(modelStatesListForCombatPanel);
		statesEffectList
				.setCellRenderer(new EncounterCreature.StatesCellRendererList());
		statesAddLabel = new javax.swing.JLabel();
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
		healthBarPanel = new javax.swing.JPanel();
		hitpointSlider = new javax.swing.JSlider();
		matrixPanel = new javax.swing.JPanel();
		logTabbedPane = new javax.swing.JTabbedPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		notesTextArea = new javax.swing.JTextArea();
		jScrollPane4 = new javax.swing.JScrollPane();
		logTextArea = new javax.swing.JTextArea();

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

		tagNameMenuItem.setText("CreatureName");
		tagNameMenuItem.setEnabled(false);
		tagNamePopupMenu.add(tagNameMenuItem);

		nameEditMenuItem.setText("Edit Name");
		nameEditMenuItem.setToolTipText("Change creature name.");
		nameEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameEditMenuItemActionPerformed(evt);
			}
		});
		tagNamePopupMenu.add(nameEditMenuItem);
		tagNamePopupMenu.add(jSeparator3);

		tagAddMenuItem.setText("Add Tag");
		tagAddMenuItem.setToolTipText("Add tag to creatures name");
		tagAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tagAddMenuItemActionPerformed(evt);
			}
		});
		tagNamePopupMenu.add(tagAddMenuItem);

		tagEditMenuItem.setText("Edit");
		tagEditMenuItem.setToolTipText("Edit tag");
		tagEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tagEditMenuItemActionPerformed(evt);
			}
		});
		tagNamePopupMenu.add(tagEditMenuItem);

		tagDeleteMenuItem.setText("Delete Tag");
		tagDeleteMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						tagDeleteMenuItemActionPerformed(evt);
					}
				});
		tagNamePopupMenu.add(tagDeleteMenuItem);
		tagNamePopupMenu.add(jSeparator4);

		tagCancelMenuItem.setText("Cancel");
		tagCancelMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						tagCancelMenuItemActionPerformed(evt);
					}
				});
		tagNamePopupMenu.add(tagCancelMenuItem);

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

		saveDeathMenuItem.setText("Paralyzation, Poison or Death");
		saveDeathMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveDeathMenuItemActionPerformed(evt);
					}
				});
		savePopupMenu.add(saveDeathMenuItem);

		savePolymorphMenuItem.setText("Petrification or Polymorph");
		savePolymorphMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						savePolymorphMenuItemActionPerformed(evt);
					}
				});
		savePopupMenu.add(savePolymorphMenuItem);

		saveRodStaffWandMenuItem.setText("Rod, Staff or Wand");
		saveRodStaffWandMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveRodStaffWandMenuItemActionPerformed(evt);
					}
				});
		savePopupMenu.add(saveRodStaffWandMenuItem);

		saveBreathMenuItem.setText("Breath Weapon");
		saveBreathMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveBreathMenuItemActionPerformed(evt);
					}
				});
		savePopupMenu.add(saveBreathMenuItem);

		saveSpellsMenuItem.setText("Spells");
		saveSpellsMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saveSpellsMenuItemActionPerformed(evt);
					}
				});
		savePopupMenu.add(saveSpellsMenuItem);

		saveCancelMenuItem.setText("Cancel");
		savePopupMenu.add(saveCancelMenuItem);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 517,
				Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 556,
				Short.MAX_VALUE));

		setBackground(new java.awt.Color(102, 51, 0));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(
						new java.awt.Color(153, 51, 0), 1, true),
				"PlayerNameHere",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(204,
						204, 0)));
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
		helpIcon.setBounds(0, 0, 20, 20);
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
		hitpointIcon
				.setToolTipText("Hit points remaining. Right click to change maximum value.");
		hitpointIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				hitpointIconMousePressed(evt);
			}
		});
		hitpointIcon.setBounds(50, -10, 64, 60);
		jLayeredPane1.add(hitpointIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

		armorClassIcon
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		armorClassIcon.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/shield-icon.png"))); // NOI18N
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

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));

		jPanel4.setBackground(new java.awt.Color(204, 204, 204));
		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Details",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		jPanel4.setLayout(new java.awt.GridBagLayout());

		pcCharacterNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		pcCharacterNameLabel.setText("Name:");
		pcCharacterNameLabel
				.setToolTipText("Number of attack routines per round.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel4.add(pcCharacterNameLabel, gridBagConstraints);

		pcNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		pcNameLabel.setText("Player:");
		pcNameLabel.setToolTipText("Damage that the creature can do.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		jPanel4.add(pcNameLabel, gridBagConstraints);

		moveLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		moveLabel.setText("Move:");
		moveLabel.setToolTipText("Move base of the creature.");
		moveLabel.setPreferredSize(new java.awt.Dimension(13, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		jPanel4.add(moveLabel, gridBagConstraints);

		specialDefenseLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialDefenseLabel.setText("SD:");
		specialDefenseLabel.setToolTipText("Special defenses.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		jPanel4.add(specialDefenseLabel, gridBagConstraints);

		specialAttackLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialAttackLabel.setText("SA:");
		specialAttackLabel.setToolTipText("Special attacks.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 3.0;
		jPanel4.add(specialAttackLabel, gridBagConstraints);

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
		jPanel4.add(magicResistanceLabel, gridBagConstraints);

		levelLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		levelLabel.setText("Level");
		levelLabel.setToolTipText("Player Level");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel4.add(levelLabel, gridBagConstraints);

		classLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		classLabel.setText("Class");
		classLabel.setToolTipText("Player Class");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel4.add(classLabel, gridBagConstraints);

		detailsACLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		detailsACLabel.setText("AC: 10, 10, 10");
		detailsACLabel
				.setToolTipText("AC:Normal, Rear: From behind, No Shield: Without a shield.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel4.add(detailsACLabel, gridBagConstraints);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addComponent(jPanel4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 318,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addComponent(jPanel4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 86,
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
										.addGap(0, 0, 0)
										.addComponent(
												savesPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(98, 98, 98)));
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
																javax.swing.GroupLayout.DEFAULT_SIZE,
																103,
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
																savesPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)));

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
		healthBarPanel.setLayout(new java.awt.BorderLayout());

		hitpointSlider.setBackground(new java.awt.Color(204, 204, 204));
		hitpointSlider.setFont(new java.awt.Font("Tahoma", 0, 10));
		hitpointSlider.setForeground(new java.awt.Color(153, 0, 0));
		hitpointSlider.setMajorTickSpacing(5);
		hitpointSlider.setMaximum(50);
		hitpointSlider.setMinimum(-10);
		hitpointSlider.setMinorTickSpacing(1);
		hitpointSlider.setPaintLabels(true);
		hitpointSlider.setPaintTicks(true);
		hitpointSlider.setSnapToTicks(true);
		hitpointSlider.setToolTipText("Adjust players health.");
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
		healthBarPanel.add(hitpointSlider, java.awt.BorderLayout.CENTER);

		matrixPanel.setBackground(new java.awt.Color(255, 204, 0));
		matrixPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Matrix",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		matrixPanel.setLayout(new java.awt.BorderLayout());

		jScrollPane3.setBackground(new java.awt.Color(204, 204, 204));
		jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Notes",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));

		notesTextArea.setColumns(20);
		notesTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12));
		notesTextArea.setLineWrap(true);
		notesTextArea.setRows(5);
		notesTextArea.setWrapStyleWord(true);
		jScrollPane3.setViewportView(notesTextArea);

		logTabbedPane.addTab("Notes", jScrollPane3);

		jScrollPane4.setBackground(new java.awt.Color(153, 153, 153));
		jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Log",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));

		logTextArea.setBackground(new java.awt.Color(153, 153, 153));
		logTextArea.setColumns(20);
		logTextArea.setEditable(false);
		logTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12));
		logTextArea.setRows(5);
		jScrollPane4.setViewportView(logTextArea);

		logTabbedPane.addTab("Log", jScrollPane4);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(healthBarPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 685,
						Short.MAX_VALUE)
				.addComponent(logTabbedPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, 685,
						Short.MAX_VALUE)
				.addComponent(statsSubPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(matrixPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 685,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(statsSubPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 126,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(healthBarPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(matrixPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 61,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(logTabbedPane,
								javax.swing.GroupLayout.PREFERRED_SIZE, 283,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
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

	/**
	 * pop up effects of rolled save
	 * 
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
		ost.dprint(oP.getName() + ":" + saveResult + "\n");
	}

	private void formMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) { // right click
			tagNamePopupMenu.setLocation(MouseInfo.getPointerInfo()
					.getLocation());
			tagAddMenuItem.setEnabled(oP.getTag().isEmpty());
			tagEditMenuItem.setEnabled(!oP.getTag().isEmpty());
			tagDeleteMenuItem.setEnabled(!oP.getTag().isEmpty());
			tagNameMenuItem.setText(oP.getName());
			tagNamePopupMenu.show(this, evt.getX(), evt.getY());
		}
	}

	private void saveSpellsMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		saveSpellTextFieldMouseClicked(null);
	}

	private void saveBreathMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		saveBreathTextFieldMouseClicked(null);
	}

	private void saveRodStaffWandMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		saveRodTextFieldMouseClicked(null);
	}

	private void savePolymorphMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		savePolyTextFieldMouseClicked(null);
	}

	private void saveDeathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		saveDeathTextFieldMouseClicked(null);
	}

	public void hpEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String newHP = "";
		while (!MyParse.isInteger(newHP)) {
			newHP = SimpleDialog.showQuestion(hpPopupMenu, "New Max HP Value",
					"Max HP", String.format("%d", oP.getHpMax()));
			// has to be at least 1 hp
			if (MyParse.isInteger(newHP) && Integer.parseInt(newHP) > 0) {
				oP.setHpMax(Integer.parseInt(newHP));
				oP.setHpCurrent(oP.getHpMax());
				hpBarLast = Integer.parseInt(newHP);
				hitpointSlider.setMaximum(hpBarLast);
				hitpointSlider.setValue(hpBarLast);
				hitpointLabel.setText(String.format("%d", oP.getHpMax()));
				hitpointSliderMouseReleased(null);
			} else {
				newHP = "";
			}
		}
	}

	private void tagCancelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		tagNamePopupMenu.setVisible(false);
	}

	private void tagDeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		tagNamePopupMenu.setVisible(false);
		oP.setTag("");
		playerTitleBorder.setTitle(String.format("%s", oP.getName()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodePC, oP);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	private void tagEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		tagNamePopupMenu.setVisible(false);
		oP.setTag(SimpleDialog.showQuestion(this, "Edit tag", "Editing Tag",
				oP.getTag()));
		playerTitleBorder.setTitle(String.format("%s [%s]", oP.getName(),
				oP.getTag()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodePC, oP);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	public void tagAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		tagNamePopupMenu.setVisible(false);
		oP.setTag(SimpleDialog.showQuestion(this, "Enter tag or brief note",
				"Adding Tag", oP.getTag()));
		playerTitleBorder.setTitle(String.format("%s [%s]", oP.getName(),
				oP.getTag()));
		DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
				ost.encounterFrame.encountersTreeModel,
				ost.encounterFrame.nodePC, oP);
		ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
		repaint();
	}

	public void nameEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String sNewName = SimpleDialog.showQuestion(nameEditMenuItem,
				"New name for " + oP.getName(), "New Name", oP.getName());
		if (!sNewName.isEmpty()) {
			oP.setName(sNewName);
			playerTitleBorder.setTitle(String.format("%s%s", oP.getName(), oP
					.getTag().isEmpty() ? "" : " [" + oP.getTag() + "]"));
			//this.revalidate();
			DefaultMutableTreeNode oN = Utils.getMyNodeByObject(
					ost.encounterFrame.encountersTreeModel,
					ost.encounterFrame.nodePC, oP);
			ost.encounterFrame.encountersTreeModel.nodeChanged(oN);
			repaint();
		}
	}

	public void acEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		//TODO allow multiple ACs
		String sAC = SimpleDialog.showQuestion(acPopupMenu, "New Armor Class",
				"New AC", oP.getArmorRatings().get(0));
		//oP.getArmorRatings().clear();
		oP.getArmorRatings().set(0, sAC);
		armorClassLabel.setText(MyParse.displayArmorClass(
				ost.mainFrame.d20ModeRadioButton.isSelected(), sAC));

	}

	private void stateCancelMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		statePopupMenu.setVisible(false);
	}

	private void stateDeleteMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		StatesClass oS = (StatesClass) statesEffectList.getSelectedValue();
		modelStatesListForCombatPanel.removeElement(oS);
		oP.getStates().remove(oS);
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
		ost.mainFrame.currentStatesAddObject = oP;
		ost.mainFrame.statesAddDialog.setLocation(MouseInfo.getPointerInfo()
				.getLocation());
		ost.mainFrame.statesAddDialog.setVisible(true);
	}

	private void armorClassIconMousePressed(java.awt.event.MouseEvent evt) {
		//TODO add support for multiple ACs
		if (evt.getButton() == MouseEvent.BUTTON3) {
			acDetailsMenuItem.setText(String.format("AC:%s", oP
					.getArmorRatings().get(0)));
			acPopupMenu.show(statsSubPanel1, evt.getX(), evt.getY());
		}
	}

	private void hitpointIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) {
			hpDetailsMenuItem.setText(String.format("MaxHP:%s", oP.getHpMax()));
			hpPopupMenu.show(statsSubPanel1, evt.getX(), evt.getY());
		}
	}

	private void helpIconMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			Frame_Character_Sheet fSheet = new Frame_Character_Sheet(ost, oP);
			fSheet.setVisible(true);
		}
	}

	private void hitpointSliderPropertyChange(java.beans.PropertyChangeEvent evt) {
		hitpointChangeLabel.setText("");
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

	public void hitpointSliderMouseReleased(java.awt.event.MouseEvent evt) {
		int hpBarPrevious = hpBarLast;
		hpBarLast = hitpointSlider.getValue();
		int changeValue = hpBarLast - hpBarPrevious;
		String hpChange = String.format("health adjusted (%c%d)",
				changeValue > 0 ? '+' : '-', Math.abs(changeValue));
		ost.dprint(oP.getName() + " " + hpChange + "\n");
		oP.setLog(oP.getLog() + hpChange + "\n");
		oP.Encountered.logTextArea.setText(oP.getLog());
		oP.setHpCurrent(hpBarLast);
		hitpointChangeLabel.setText("");
		hitpointChangeLabel.setForeground(Color.black);

		// update the nodes in PC since someone took damage and might be "down"
		ost.encounterFrame.encountersTreeModel.nodeChanged(Utils
				.getMyNodeByObject(ost.encounterFrame.encountersTreeModel,
						ost.encounterFrame.nodePC, oP));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem acCancelMenuItem;
	private javax.swing.JMenuItem acDetailsMenuItem;
	private javax.swing.JMenuItem acEditMenuItem;
	private javax.swing.JPopupMenu acPopupMenu;
	private javax.swing.JLabel armorClassIcon;
	private javax.swing.JLabel armorClassLabel;
	private javax.swing.JLabel classLabel;
	private javax.swing.JLabel detailsACLabel;
	private javax.swing.JPanel healthBarPanel;
	private javax.swing.JLabel helpIcon;
	private javax.swing.JLabel hitpointChangeLabel;
	private javax.swing.JLabel hitpointIcon;
	private javax.swing.JLabel hitpointLabel;
	public javax.swing.JSlider hitpointSlider;
	private javax.swing.JMenuItem hpCancelMenuItem;
	private javax.swing.JMenuItem hpDetailsMenuItem;
	private javax.swing.JMenuItem hpEditMenuItem;
	private javax.swing.JPopupMenu hpPopupMenu;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public javax.swing.JSeparator jSeparator3;
	public javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JSeparator jSeparator7;
	private javax.swing.JSeparator jSeparator8;
	private javax.swing.JLabel levelLabel;
	private javax.swing.JTabbedPane logTabbedPane;
	private javax.swing.JTextArea logTextArea;
	private javax.swing.JLabel magicResistanceLabel;
	private javax.swing.JPanel matrixPanel;
	private javax.swing.JLabel moveLabel;
	public javax.swing.JMenuItem nameEditMenuItem;
	public javax.swing.JTextArea notesTextArea;
	private javax.swing.JLabel pcCharacterNameLabel;
	private javax.swing.JLabel pcNameLabel;
	private javax.swing.JMenuItem saveBreathMenuItem;
	private javax.swing.JLabel saveBreathNameLabel;
	private javax.swing.JTextField saveBreathTextField;
	private javax.swing.JMenuItem saveCancelMenuItem;
	private javax.swing.JMenuItem saveDeathMenuItem;
	private javax.swing.JLabel saveDeathNameLabel;
	private javax.swing.JTextField saveDeathTextField;
	private javax.swing.JLabel savePolyNameLabel;
	private javax.swing.JTextField savePolyTextField;
	private javax.swing.JMenuItem savePolymorphMenuItem;
	private javax.swing.JPopupMenu savePopupMenu;
	private javax.swing.JLabel saveRodNameLabel;
	private javax.swing.JMenuItem saveRodStaffWandMenuItem;
	private javax.swing.JTextField saveRodTextField;
	private javax.swing.JLabel saveSpellNameLabel;
	private javax.swing.JTextField saveSpellTextField;
	private javax.swing.JMenuItem saveSpellsMenuItem;
	private javax.swing.JPanel savesPanel;
	private javax.swing.JLabel specialAttackLabel;
	private javax.swing.JLabel specialDefenseLabel;
	private javax.swing.JMenuItem stateCancelMenuItem;
	private javax.swing.JMenuItem stateDeleteMenuItem;
	private javax.swing.JMenuItem stateEditMenuItem;
	private javax.swing.JMenuItem stateNameMenuItem;
	private javax.swing.JPopupMenu statePopupMenu;
	private javax.swing.JLabel statesAddLabel;
	private javax.swing.JList statesEffectList;
	private javax.swing.JPanel statsSubPanel1;
	public javax.swing.JMenuItem tagAddMenuItem;
	public javax.swing.JMenuItem tagCancelMenuItem;
	public javax.swing.JMenuItem tagDeleteMenuItem;
	public javax.swing.JMenuItem tagEditMenuItem;
	public javax.swing.JMenuItem tagNameMenuItem;
	public javax.swing.JPopupMenu tagNamePopupMenu;
	// End of variables declaration//GEN-END:variables

	public DefaultListModel modelStatesListForCombatPanel;
	private TitledBorder playerTitleBorder;
	private int hpBarLast;
	private PlayerClass oP;

}