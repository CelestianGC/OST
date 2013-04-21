/*
 * Panel_Player_WeaponsBlock.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.SkillsClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.w3c.dom.ranges.RangeException;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_WeaponsBlock extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_Combat */
	public Panel_Player_WeaponsBlock(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();

		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		// TODO Auto-generated method stub
		// added this incase we updated panel
		pc = oPlayer;

		//Utils.updateMatrixPanelPC(attackMatrixPanel, pc, ost);

		ArrayList<String> columnNames = new ArrayList<>();

		columnNames.add("weapon");

		columnNames.add("mod hit/dmg");

		columnNames.add("thaco");

		columnNames.add("speed");

		columnNames.add("dmg S");
		columnNames.add("dmg M");
		columnNames.add("dmg L");

		columnNames.add("rng S");
		columnNames.add("rng M");
		columnNames.add("rng L");

		ArrayList<EquipmentClass> eList = pc.getAllWeapons();
		JTable table = new TableNoEdit(eList.size(), columnNames.size());

		for (String s : columnNames) {
			int i = columnNames.indexOf(s);
			table.getColumnModel().getColumn(i).setHeaderValue(s);
		}

		int missileAdj = pc.getDexterity(ost).attackAdjustment;
		int hitAdj = pc.getStrength(ost).hitProbability;
		int dmgAdj = pc.getStrength(ost).damageAdjustment;
		
		for (EquipmentClass oE : eList) {
			int idx = eList.indexOf(oE);
			int meleeHit = hitAdj+oE.getMagicAdjustmentPrimary();
			int meleeDmg = dmgAdj+oE.getMagicAdjustmentSecondary();
			int rangeHit = missileAdj+oE.getMagicAdjustmentPrimary();
			
			table.setValueAt(oE.getName(), idx, 0);
			
			// range or not 
			if (oE.isRangedWeapon()) {
				table.setValueAt(rangeHit + "/"
						+ 0, idx, 1);
				table.setValueAt(
						(pc.getTHACO(ost) - rangeHit), idx, 2);
			}
			else {
				table.setValueAt(meleeHit + "/"
						+ meleeDmg, idx, 1);
				table.setValueAt(
						(pc.getTHACO(ost) - meleeHit), idx, 2);
			}

			table.setValueAt(oE.getSpeedFactor(), idx, 3);
			table.setValueAt(oE.getDamageSmall(), idx, 4);
			table.setValueAt(oE.getDamageMedium(), idx, 5);
			table.setValueAt(oE.getDamageLarge(), idx, 6);
			table.setValueAt(oE.getRange()[RANGE_SHORT], idx, 7);
			table.setValueAt(oE.getRange()[RANGE_MEDIUM], idx, 8);
			table.setValueAt(oE.getRange()[RANGE_LONG], idx, 9);
		}

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		table.getTableHeader().setFont(fFont);
		table.setFont(fFont);

		weaponsPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		weaponsPanel.add(table, BorderLayout.CENTER);

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

		weaponsPanel = new javax.swing.JPanel();

		setLayout(new java.awt.BorderLayout());

		weaponsPanel.setBackground(new java.awt.Color(255, 255, 255));
		weaponsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Weapons",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		weaponsPanel.setLayout(new java.awt.BorderLayout());
		add(weaponsPanel, java.awt.BorderLayout.LINE_START);
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

	public class TableNoEdit extends JTable{
		public TableNoEdit(int size, int size2) {
			super(size,size2);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel weaponsPanel;
	// End of variables declaration//GEN-END:variables

}