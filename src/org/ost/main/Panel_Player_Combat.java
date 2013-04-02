/*
 * Panel_Player_Combat.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.ABILITY_CHARISMA;
import static org.ost.main.MyClasses.MyStatics.ABILITY_COMELINESS;
import static org.ost.main.MyClasses.MyStatics.ABILITY_CONSTITUTION;
import static org.ost.main.MyClasses.MyStatics.ABILITY_DEXTERITY;
import static org.ost.main.MyClasses.MyStatics.ABILITY_INTELLIGENCE;
import static org.ost.main.MyClasses.MyStatics.ABILITY_STRENGTH;
import static org.ost.main.MyClasses.MyStatics.ABILITY_WISDOM;
import static org.ost.main.MyClasses.MyStatics.AC_NAMES;
import static org.ost.main.MyClasses.MyStatics.AC_NORMAL;
import static org.ost.main.MyClasses.MyStatics.AC_REAR;
import static org.ost.main.MyClasses.MyStatics.AC_SHIELDLESS;
import static org.ost.main.MyClasses.MyStatics.ALIGNMENTS;
import static org.ost.main.MyClasses.MyStatics.DEFAULT_FONT;
import static org.ost.main.MyClasses.MyStatics.MAX_CLERIC_SPELL_LEVEL;
import static org.ost.main.MyClasses.MyStatics.MAX_MAGE_SPELL_LEVEL;
import static org.ost.main.MyClasses.MyStatics.SAVES;
import static org.ost.main.MyClasses.MyStatics.SAVE_BREATH;
import static org.ost.main.MyClasses.MyStatics.SAVE_DEATH;
import static org.ost.main.MyClasses.MyStatics.SAVE_POLY;
import static org.ost.main.MyClasses.MyStatics.SAVE_ROD;
import static org.ost.main.MyClasses.MyStatics.SAVE_SPELL;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_100;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_1_50;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_51_75;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_76_90;
import static org.ost.main.MyClasses.MyStatics.STRENGTH_PERCENT_91_99;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.SkillsClass;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_Combat extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_Combat */
	public Panel_Player_Combat(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();

		// for some reason cellrenderer makes the cells align left, default
		// for int is right, so just cell render them all so they are all left
		// TODO figure out why it does that.
		// make that THACO cell red
		for (int i = 0; i < pcCombatMatrixTable.getColumnCount(); i++) {
			TableColumn thacoCol = pcCombatMatrixTable.getColumnModel()
					.getColumn(i);
			if (i == 10)
				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.red,
						Color.black));
			else
				thacoCol.setCellRenderer(new ColorColumnRenderer(Color.ORANGE,
						Color.black));
		}
		// this is to make the headers align left to match the numbers
		TableCellRenderer rendererFromHeader = pcCombatMatrixTable
				.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.LEFT);
		//---

		
		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		// TODO Auto-generated method stub
		// added this incase we updated panel
		pc = oPlayer;

		RaceClass race = oPlayer.getMyRace().getRaceByID(ost.raceList);
		// portrait

		// combat

		pcCurrentHPLabel.setText(String.format("%d", pc.getHpCurrent()));
		pcMaxHPLabel.setText(String.format("%d", pc.getHpMax()));
		int iTHACO = pc.getTHACO(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList);
		pcTHACOLabel.setText(String.format("%d", iTHACO));
		pcTHACOLabel.setToolTipText("Roll needed to hit armor class 0 is "
				+ iTHACO);

		for (int i = 0; i < pc.getArmorRatings().size(); i++) {
			switch (i) {
			case AC_NORMAL:
				pcArmorClassLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassLabel.setToolTipText(AC_NAMES[i]);
				break;
			case AC_REAR:
				pcArmorClassRearLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassRearLabel.setToolTipText(AC_NAMES[i]);
				break;
			case AC_SHIELDLESS:
				pcArmorClassShieldlessLabel.setText(String.format("%s", pc
						.getArmorRatings().get(i)));
				pcArmorClassShieldlessLabel.setToolTipText(AC_NAMES[i]);
				break;

			default:
				ost.dprint("Unknown AC type in Panel_Player_Combat updatePanel()\n");
				break;
			}
		}

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		pcCombatMatrixTable.getTableHeader().setFont(fFont);
		pcCombatMatrixTable.getTableHeader().setBackground(Color.yellow);

		int attackList[] = 
				pc.getMatrix(ost.characterClassList,
				ost.extraAbilitiesList, ost.raceList);

		for (int i = 0; i < attackList.length; i++) {
			pcCombatMatrixTable.setValueAt(attackList[i], 0, i);
		}

		repaint();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		combatPanel = new javax.swing.JPanel();
		jLabel29 = new javax.swing.JLabel();
		pcArmorClassLabel = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		pcArmorClassShieldlessLabel = new javax.swing.JLabel();
		jLabel33 = new javax.swing.JLabel();
		pcArmorClassRearLabel = new javax.swing.JLabel();
		jLabel35 = new javax.swing.JLabel();
		pcCurrentHPLabel = new javax.swing.JLabel();
		jLabel45 = new javax.swing.JLabel();
		pcMaxHPLabel = new javax.swing.JLabel();
		pcTHACOLabel = new javax.swing.JLabel();
		jLabel47 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		pcCombatMatrixTable = new javax.swing.JTable();

		setLayout(new java.awt.BorderLayout());

		combatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Combat"));

		jLabel29.setText("AC");
		jLabel29.setToolTipText("Armor Class");

		pcArmorClassLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassLabel.setText("-10");
		pcArmorClassLabel.setToolTipText("Normal Armor Class.");

		jLabel31.setText("/");

		pcArmorClassShieldlessLabel
				.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassShieldlessLabel.setText("-10");
		pcArmorClassShieldlessLabel
				.setToolTipText("Armor class without shield");

		jLabel33.setText("/");

		pcArmorClassRearLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcArmorClassRearLabel.setText("-10");
		pcArmorClassRearLabel.setToolTipText("Armor class from rear.");

		jLabel35.setText("HP");
		jLabel35.setToolTipText("Current hitpoint total.");

		pcCurrentHPLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcCurrentHPLabel.setText("999");

		jLabel45.setText("Max");
		jLabel45.setToolTipText("Maximum hitpoints.");

		pcMaxHPLabel.setFont(new java.awt.Font("Segoe UI", 2, 15));
		pcMaxHPLabel.setText("999");

		pcTHACOLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
		pcTHACOLabel.setText("00");

		jLabel47.setText("THACO");
		jLabel47.setToolTipText("To hit armor class 0 value.");

		pcCombatMatrixTable.setBackground(new java.awt.Color(255, 204, 102));
		pcCombatMatrixTable.setFont(new java.awt.Font("Segoe UI", 0, 10));
		pcCombatMatrixTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,
						null, null, null, null, null } },
				new String[] { "AC10", "AC9", "AC8", "AC7", "AC6", "AC5",
						"AC4", "AC3", "AC2", "AC1", "AC0", "AC-1", "AC-2",
						"AC-3", "AC-4", "AC-5", "AC-6", "AC-7", "AC-8", "AC-9",
						"AC-10" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(pcCombatMatrixTable);

		javax.swing.GroupLayout combatPanelLayout = new javax.swing.GroupLayout(
				combatPanel);
		combatPanel.setLayout(combatPanelLayout);
		combatPanelLayout
				.setHorizontalGroup(combatPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								combatPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel29)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel31)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassShieldlessLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel33)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcArmorClassRearLabel))
														.addGroup(
																combatPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel35)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcCurrentHPLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel45)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcMaxHPLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				492,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel47)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				pcTHACOLabel)))
										.addContainerGap())
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 717,
								Short.MAX_VALUE));
		combatPanelLayout
				.setVerticalGroup(combatPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								combatPanelLayout
										.createSequentialGroup()
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel29)
														.addComponent(
																pcArmorClassLabel)
														.addComponent(jLabel31)
														.addComponent(
																pcArmorClassShieldlessLabel)
														.addComponent(jLabel33)
														.addComponent(
																pcArmorClassRearLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												combatPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel35)
														.addComponent(
																pcCurrentHPLabel)
														.addComponent(jLabel45)
														.addComponent(
																pcMaxHPLabel)
														.addComponent(
																pcTHACOLabel)
														.addComponent(jLabel47))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		add(combatPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>
	//GEN-END:initComponents

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
	private javax.swing.JPanel combatPanel;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel45;
	private javax.swing.JLabel jLabel47;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel pcArmorClassLabel;
	private javax.swing.JLabel pcArmorClassRearLabel;
	private javax.swing.JLabel pcArmorClassShieldlessLabel;
	private javax.swing.JTable pcCombatMatrixTable;
	private javax.swing.JLabel pcCurrentHPLabel;
	private javax.swing.JLabel pcMaxHPLabel;
	private javax.swing.JLabel pcTHACOLabel;
	// End of variables declaration//GEN-END:variables

}