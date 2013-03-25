/*
 * Option_AskFor_Race.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.RaceClass;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Race extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;

	/** Creates new form Option_AskFor_Race */
	public Option_AskFor_Race(java.awt.Frame parent, boolean modal,
			MainClass ost, RaceClass oRace) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.currentRace = oRace;
		initComponents();

		updatePanels();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);

		//setSize(360, 340);
		setLocationRelativeTo(parent);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jScrollPane1 = new javax.swing.JScrollPane();
		mainPanel = new javax.swing.JPanel();
		raceNameLabel = new javax.swing.JLabel();
		raceNameTextField = new javax.swing.JTextField();
		raceAbilitiesPanel = new javax.swing.JPanel();
		raceMinAbilitiesButton = new javax.swing.JButton();
		raceMaxAbilitiesButton = new javax.swing.JButton();
		raceAdjustmentAbilitiesButton = new javax.swing.JButton();
		raceThiefAbilitiesPanel = new javax.swing.JPanel();
		raceThiefAbilitiesButton = new javax.swing.JButton();
		raceDescriptionButton = new javax.swing.JButton();
		raceExtraAbilitiesPanel = new javax.swing.JPanel();
		raceExtraABilitiesButton = new javax.swing.JButton();
		moveACStartHPPanel = new javax.swing.JPanel();
		moveRateLabel = new javax.swing.JLabel();
		moveRateSpinner = new javax.swing.JSpinner();
		naturalACLabel = new javax.swing.JLabel();
		naturalACSpinner = new javax.swing.JSpinner();
		bonusHPLabel = new javax.swing.JLabel();
		bonusStartHPSpinner = new javax.swing.JSpinner();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Race",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridBagLayout());

		raceNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceNameLabel.setText("Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
		mainPanel.add(raceNameLabel, gridBagConstraints);

		raceNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		mainPanel.add(raceNameTextField, gridBagConstraints);

		raceAbilitiesPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Ability Scores",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		raceMinAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		raceMinAbilitiesButton.setText("minimum");
		raceMinAbilitiesButton
				.setToolTipText("The minimum abilities allowed by this race.");
		raceMinAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceMinAbilitiesButtonActionPerformed(evt);
					}
				});
		raceAbilitiesPanel.add(raceMinAbilitiesButton);

		raceMaxAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		raceMaxAbilitiesButton.setText("maximum");
		raceMaxAbilitiesButton
				.setToolTipText("Maximum ability scores allowed by this race.");
		raceMaxAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceMaxAbilitiesButtonActionPerformed(evt);
					}
				});
		raceAbilitiesPanel.add(raceMaxAbilitiesButton);

		raceAdjustmentAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0,
				10));
		raceAdjustmentAbilitiesButton.setText("adjustments");
		raceAdjustmentAbilitiesButton
				.setToolTipText("Adjustments applies to abilities because of racial stock.");
		raceAdjustmentAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceAdjustmentAbilitiesButtonActionPerformed(evt);
					}
				});
		raceAbilitiesPanel.add(raceAdjustmentAbilitiesButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(raceAbilitiesPanel, gridBagConstraints);

		raceThiefAbilitiesPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Thief Ability Scores",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		raceThiefAbilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		raceThiefAbilitiesButton.setText("adjustments");
		raceThiefAbilitiesButton
				.setToolTipText("Thief skill adjustments applied because of this race.");
		raceThiefAbilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceThiefAbilitiesButtonActionPerformed(evt);
					}
				});
		raceThiefAbilitiesPanel.add(raceThiefAbilitiesButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(raceThiefAbilitiesPanel, gridBagConstraints);

		raceDescriptionButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		raceDescriptionButton.setText("set description");
		raceDescriptionButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceDescriptionButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(raceDescriptionButton, gridBagConstraints);

		raceExtraAbilitiesPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Racial Features",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		raceExtraABilitiesButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		raceExtraABilitiesButton.setText("features");
		raceExtraABilitiesButton
				.setToolTipText("Racial features granted by the racial stock.");
		raceExtraABilitiesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						raceExtraABilitiesButtonActionPerformed(evt);
					}
				});
		raceExtraAbilitiesPanel.add(raceExtraABilitiesButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(raceExtraAbilitiesPanel, gridBagConstraints);

		moveACStartHPPanel.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		moveACStartHPPanel.setLayout(new java.awt.GridLayout(0, 2));

		moveRateLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		moveRateLabel.setText("base move");
		moveACStartHPPanel.add(moveRateLabel);

		moveRateSpinner
				.setModel(new javax.swing.SpinnerNumberModel(1, 1, 48, 1));
		moveACStartHPPanel.add(moveRateSpinner);

		naturalACLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		naturalACLabel.setText("natural AC");
		moveACStartHPPanel.add(naturalACLabel);

		naturalACSpinner.setModel(new javax.swing.SpinnerNumberModel(10, -10,
				10, 1));
		moveACStartHPPanel.add(naturalACSpinner);

		bonusHPLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
		bonusHPLabel.setText("bonus start HP");
		moveACStartHPPanel.add(bonusHPLabel);

		bonusStartHPSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				100, 1));
		moveACStartHPPanel.add(bonusStartHPSpinner);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		mainPanel.add(moveACStartHPPanel, gridBagConstraints);

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

	private void raceExtraABilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ArrayList<ExtraAbilitiesClass> aList = ExtraAbilitiesClass.getAllowed(
				currentRace.getBonusAbilities(), ost.extraAbilitiesList);
		Option_Set_ExtraAbilities dDialog = new Option_Set_ExtraAbilities(
				parent, true, ost, aList);
		dDialog.setVisible(true);

		currentRace.setBonusAbilities(ExtraAbilitiesClass
				.getAllowedAsString(aList));
	}

	private void raceDescriptionButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_Description nDialogDescription = new Option_AskFor_Description(
				parent, true, ost, "Extra Description",
				currentRace.getDescription());

		nDialogDescription.setVisible(true);
		currentRace.setDescription(nDialogDescription.getDescription());
	}

	private void raceThiefAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		Option_AskFor_ThiefSkills nDialog = new Option_AskFor_ThiefSkills(
				parent, true, ost, "Racial Thief Ability Adjustments",
				currentRace.getThiefAbiltyAdjustments());

		nDialog.setVisible(true);
	}

	private void raceAdjustmentAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		Option_AskFor_AbilityScores nDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Racial Ability Score Adjustments",
				currentRace.getAbilityAdjustment(),false);

		nDialog.updatePanel(currentRace.getAbilityAdjustment());

		nDialog.setVisible(true);
	}

	private void raceMaxAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Option_AskFor_AbilityScores nDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Racial Maximum Ability Scores",
				currentRace.getMaxAbility(),false);
		nDialog.setVisible(true);
	}

	private void raceMinAbilitiesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		Option_AskFor_AbilityScores nDialog = new Option_AskFor_AbilityScores(
				parent, true, ost, "Racial Minimum Ability Scores",
				currentRace.getMinAbility(),false);
		nDialog.setVisible(true);
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		// need to get the current values and insert into currentRace
		currentRace.setName(raceNameTextField.getText());
		currentRace.setMoveRate((int) moveRateSpinner.getValue());
		currentRace.setNaturalAC((int) naturalACSpinner.getValue());
		currentRace.setBonusStartHP((int) bonusStartHPSpinner.getValue());
	}

	private void updatePanels() {
		raceNameTextField.setText(currentRace.getName());
		moveRateSpinner.setValue(currentRace.getMoveRate());
		naturalACSpinner.setValue(currentRace.getNaturalAC());
		bonusStartHPSpinner.setValue(currentRace.getBonusStartHP());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel bonusHPLabel;
	private javax.swing.JSpinner bonusStartHPSpinner;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel moveACStartHPPanel;
	private javax.swing.JLabel moveRateLabel;
	private javax.swing.JSpinner moveRateSpinner;
	private javax.swing.JLabel naturalACLabel;
	private javax.swing.JSpinner naturalACSpinner;
	private javax.swing.JPanel raceAbilitiesPanel;
	private javax.swing.JButton raceAdjustmentAbilitiesButton;
	private javax.swing.JButton raceDescriptionButton;
	private javax.swing.JButton raceExtraABilitiesButton;
	private javax.swing.JPanel raceExtraAbilitiesPanel;
	private javax.swing.JButton raceMaxAbilitiesButton;
	private javax.swing.JButton raceMinAbilitiesButton;
	private javax.swing.JLabel raceNameLabel;
	private javax.swing.JTextField raceNameTextField;
	private javax.swing.JButton raceThiefAbilitiesButton;
	private javax.swing.JPanel raceThiefAbilitiesPanel;
	// End of variables declaration//GEN-END:variables
	private RaceClass currentRace;
}