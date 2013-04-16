/*
 * Panel_Player_Skills.java
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
import org.ost.main.MyUtils.Utils;

/**
 *
 * @author  __USER__
 */
public class Panel_Player_Skills extends javax.swing.JPanel {
	private MainClass ost;
	private PlayerClass pc;

	/** Creates new form Panel_Player_Skills */
	public Panel_Player_Skills(MainClass ost, PlayerClass oPlayer) {
		this.ost = ost;
		this.pc = oPlayer;
		initComponents();
		updatePanel(oPlayer);
	}

	public void updatePanel(PlayerClass oPlayer) {
		// added this incase we updated panel
		pc = oPlayer;

		//		ArrayList<SkillsClass> skillsBase = pc.getAllThiefSkillsBase(ost);
		//		ArrayList<SkillsClass> skillsAdj = pc.getAllThiefSkillAdjustments(ost);

		skillsPanel.removeAll();
		//		for (int i = 0; i < skillsBase.size(); i++) {
		//			JPanel skills = new JPanel(new GridLayout(2, 0, 1, 1));
		//			SkillsClass tJ = skillsAdj.get(i);
		//			SkillsClass tS = skillsBase.get(i);
		//			int finalSkill = tS.getScore() + tJ.getScore();
		//			if (tS.getScore() != 0) {
		//				String tooltip = tS.getName() + ": " + tS.getScore() + "+"
		//						+ tJ.getScore();
		//				JLabel name = new JLabel(tS.getAbbrev());
		//				name.setToolTipText(tooltip);
		//				JLabel value = new JLabel(String.format("%d%%", finalSkill));
		//				value.setToolTipText(tooltip);
		//
		//				skills.add(name);
		//				skills.add(value);
		//				skillsPanel.add(skills);
		//			}
		//		}
		Utils.updateSkillsPanelPC(skillsPanel, oPlayer, ost);
		skillsPanel.revalidate();
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

		skillsPanel = new javax.swing.JPanel();

		setBackground(new java.awt.Color(255, 255, 255));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Skills"));
		setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		skillsPanel.setBackground(new java.awt.Color(255, 255, 255));
		skillsPanel.setLayout(new java.awt.GridLayout(2, 0, 1, 1));
		add(skillsPanel);
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel skillsPanel;
	// End of variables declaration//GEN-END:variables

}