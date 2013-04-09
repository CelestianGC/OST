/*
 * Panel_Player_DivineSpells.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.DEFAULT_FONT;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ost.main.MyClasses.PlayerClass;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_Spells_All extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_DivineSpells */
	public Panel_Player_Spells_All(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();
		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		pc = oPlayer;
		allSpellsPanel.removeAll();

		if (pc.isCasterArcane(ost))
			allSpellsPanel.add(new Panel_Player_ArcaneSpells(ost, pc));
		if (pc.isCasterDivine(ost))
			allSpellsPanel.add(new Panel_Player_DivineSpells(ost, pc));
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

		allSpellsPanel = new javax.swing.JPanel();

		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(new java.awt.BorderLayout());

		allSpellsPanel.setBackground(new java.awt.Color(255, 255, 255));
		allSpellsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Spells"));
		allSpellsPanel.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.LEFT));
		add(allSpellsPanel, java.awt.BorderLayout.WEST);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel allSpellsPanel;
	// End of variables declaration//GEN-END:variables

}