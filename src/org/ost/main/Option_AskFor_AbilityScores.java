/*
 * Option_AskFor_AbilityScores.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import org.ost.main.MyClasses.AbilityScoreClass;

import static org.ost.main.MyClasses.MyStatics.*;

/**
 * 
 * @author Celestian
 *
 */
public class Option_AskFor_AbilityScores extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private ArrayList<JSpinner> abilityScores;
	private ArrayList<JSpinner> abilityPercentile;
	private ArrayList<JCheckBox> abilityExceptional;
	private ArrayList<JCheckBox> abilityPrime;
	private ArrayList<AbilityScoreClass> currentAbilities;
	private boolean settingClass;

	/**
	 * 
	 * @param parent
	 * @param modal
	 * @param ost
	 * @param sTitle - title of window
	 * @param cAbilities - array of ability scores
	 * @param settingClass - set true if setting abilities for a character class
	 */
	public Option_AskFor_AbilityScores(java.awt.Frame parent, boolean modal,
			MainClass ost, String sTitle,
			ArrayList<AbilityScoreClass> cAbilities, boolean settingClass) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.settingClass = settingClass; // setting class abilities, need prime/exceptional fields
		initComponents();

		setTitle(sTitle);
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), sTitle,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		abilityScores = new ArrayList<JSpinner>();
		abilityPercentile = new ArrayList<JSpinner>();
		abilityExceptional = new ArrayList<JCheckBox>();
		abilityPrime = new ArrayList<JCheckBox>();

		updatePanel(cAbilities);

		setLocationRelativeTo(parent);
		setSize(300, 520);

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		buttonsPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "TitleGoesHere",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridLayout(0, 1));
		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonsPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(doneButton);

		getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		updateValuesFromSpinners();
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		setVisible(false);
		formWindowClosed(null);
	}

	/**
	 * put the spinner values into the abilities array
	 * 
	 * @return
	 */
	public ArrayList<AbilityScoreClass> updateValuesFromSpinners() {
		for (int i = 0; i < abilityScores.size(); i++) {
			JSpinner score = abilityScores.get(i);
			JSpinner percentile = abilityPercentile.get(i);
			
			AbilityScoreClass aC = currentAbilities.get(i);
			aC.setScore((int) score.getValue());
			aC.setPercentile((int) percentile.getValue());
			if (settingClass) {
				JCheckBox exceptional = abilityExceptional.get(i);
				JCheckBox prime = abilityPrime.get(i);
				aC.setAllowExceptional(exceptional.isSelected());
				aC.setPrimeRequisite(prime.isSelected());
			}
		}
		return (currentAbilities);
	}

	/**
	 * load the incoming ability scores into the spinners
	 * 
	 * @param abilities
	 */
	void updatePanel(ArrayList<AbilityScoreClass> abilities) {
		//		int i = MAX_ABILITIES;
		Font fFont = new Font("Segoe UI", 0, 12);
		FlowLayout lFlow = new FlowLayout(FlowLayout.LEFT, 0, 1);

		currentAbilities = abilities;

		abilityScores.clear();
		abilityPercentile.clear();
		abilityExceptional.clear();
		abilityPrime.clear();
		
		mainPanel.removeAll();
		for (AbilityScoreClass aS : abilities) {

			JPanel pPanel = new JPanel(lFlow);
			pPanel.setToolTipText(aS.getName());
			pPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
					new javax.swing.border.LineBorder(new java.awt.Color(0, 0,
							0), 1, true), aS.getName(),
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.BELOW_TOP, fFont));

			JSpinner score = new JSpinner();
			JSpinner percentile = new JSpinner();
			score.setFont(fFont);
			score.setModel(new javax.swing.SpinnerNumberModel(0, aS.getMin(),
					aS.getMax(), 1));
			score.setValue(aS.getScore());

			percentile.setFont(fFont);
			percentile
					.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
			percentile.setValue(aS.getPercentile());

			abilityScores.add(score);
			abilityPercentile.add(percentile);

			JCheckBox exceptional = new JCheckBox("exceptional");
			exceptional.setFont(fFont);
			exceptional
					.setToolTipText("Allow exceptional value. Note: Only useful for Strength at this time.");
			exceptional.setSelected(aS.isAllowExceptional());
			
			JCheckBox primeReq = new JCheckBox("prime");
			primeReq.setFont(fFont);
			primeReq.setToolTipText("Prime requisite ability.");
			primeReq.setSelected(aS.isPrimeRequisite());
			
			pPanel.add(score);
			pPanel.add(new JLabel("/"));
			pPanel.add(percentile);
			pPanel.add(new JLabel("%"));
			if (settingClass) {
				abilityExceptional.add(exceptional);
				abilityPrime.add(primeReq);
				pPanel.add(exceptional);
				pPanel.add(primeReq);
			}

			mainPanel.add(pPanel);
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JPanel mainPanel;
	// End of variables declaration//GEN-END:variables

}