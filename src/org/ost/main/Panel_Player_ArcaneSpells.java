/*
 * Panel_Player_ArcaneSpells.java
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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ost.main.MyClasses.AbilityScoreClass;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyClasses.SkillsClass;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_ArcaneSpells extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_ArcaneSpells */
	public Panel_Player_ArcaneSpells(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();
		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		// added this incase we updated panel
		pc = oPlayer;

		// arcane spells
		int arcaneBase[] = pc.getAllArcaneSpellsPerLevel(ost);
		int arcaneAdj[] = pc.getAllArcaneBonusSpellsPerLevel(ost);

		arcaneSpellsPanel.removeAll();

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);

		Color aColor = new Color(255, 204, 105);
		Color bColor = new Color(255, 153, 51);

		boolean bFlip = false;

		JLabel sLevel = new JLabel(String.format("Level"));
		JPanel pLevel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pLevel.setBackground(new Color(204, 204, 204));
		sLevel.setToolTipText("Spell Level");
		sLevel.setFont(fFont);
		pLevel.add(sLevel);
		arcaneSpellsPanel.add(pLevel);

		for (int i = 0; i < arcaneBase.length; i++) {
			int base = arcaneBase[i];
			if (base != 0) {
				JLabel n = new JLabel(String.format("Level %d", (i + 1)));
				n.setFont(fFont);
				JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
				p.setBackground(bFlip ? bColor : aColor);
				bFlip = !bFlip;
				n.setToolTipText("Spell Level " + (i + 1));
				p.setToolTipText(n.getToolTipText());
				p.add(n);
				arcaneSpellsPanel.add(p);
			}
		}

		bFlip = false;
		JLabel sSpells = new JLabel(String.format("Count"));
		JPanel pSpells = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pSpells.setBackground(new Color(204, 204, 204));
		sSpells.setToolTipText("Number of Spells Slots");
		sSpells.setFont(fFont);
		pSpells.add(sSpells);
		arcaneSpellsPanel.add(pSpells);

		for (int i = 0; i < arcaneBase.length; i++) {
			int base = arcaneBase[i];
			int adj = arcaneAdj[i];
			int finalSkill = base + adj;
			if (base != 0) {
				JLabel n = new JLabel(String.format("%d", finalSkill));
				n.setFont(fFont);
				JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
				p.setBackground(bFlip ? bColor : aColor);
				bFlip = !bFlip;
				n.setToolTipText("Level " + (i + 1) + ": " + base + "+" + adj);
				p.setToolTipText(n.getToolTipText());
				p.add(n);
				arcaneSpellsPanel.add(p);
			}
		}

		//		for (int i = 0; i < arcaneBase.length; i++) {
		//			JPanel arcanePanel = new JPanel(new GridLayout(2, 0, 1, 1));
		//			arcanePanel.setBorder(new javax.swing.border.LineBorder(
		//					new java.awt.Color(0, 0, 0), 1, true));
		//			int base = arcaneBase[i];
		//			int adj = arcaneAdj[i];
		//			int finalSkill = base + adj;
		//			if (base != 0) {
		//				String tooltip = "Level " + (i + 1) + ": " + base + "+" + adj;
		//				JLabel name = new JLabel("L" + (i + 1));
		//				arcanePanel.setToolTipText(tooltip);
		//				name.setToolTipText(tooltip);
		//				JLabel value = new JLabel(String.format("%d", finalSkill));
		//				value.setToolTipText(tooltip);
		//
		//				arcanePanel.add(name);
		//				arcanePanel.add(value);
		//				arcaneSpellsPanel.add(arcanePanel);
		//			}
		//		}
		//		arcaneSpellsPanel.revalidate();

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

		arcaneSpellsPanel = new javax.swing.JPanel();

		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(new java.awt.BorderLayout());

		arcaneSpellsPanel.setBackground(new java.awt.Color(255, 255, 255));
		arcaneSpellsPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Arcane"));
		arcaneSpellsPanel.setLayout(new java.awt.GridLayout(2, 0, 1, 1));
		add(arcaneSpellsPanel, java.awt.BorderLayout.WEST);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel arcaneSpellsPanel;
	// End of variables declaration//GEN-END:variables

}