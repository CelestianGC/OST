/*
 * Option_AbilityScores.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.AbilityStatClass.Strength;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class Option_AbilityScores extends javax.swing.JDialog {
	MainClass ost;

	/** Creates new form Option_AbilityScores */
	public Option_AbilityScores(java.awt.Frame parent, boolean modal,
			MainClass ost) {
		super(parent, modal);
		this.ost = ost;
		initComponents();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = mainPanel.getSize();
		//
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 4, windowSize.height - 4);
		//optionAbilityScores.setLocationRelativeTo(null);

		setLocationRelativeTo(parent);

		strengthPercentComboBox.setModel(new DefaultComboBoxModel<>(
				STRENGTH_PERCENTILE));

		buildAbilityTables();
		// force first time to load things up
		strengthRadioButtonActionPerformed(null);

		pack();
}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		abilitySelectbuttonGroup = new javax.swing.ButtonGroup();
		strengthPanel = new javax.swing.JPanel();
		strengthScoreSpinner = new javax.swing.JSpinner();
		strengthHitBonusLabel = new javax.swing.JLabel();
		strengthHitBonusSpinner = new javax.swing.JSpinner();
		strengthDamageAdjLabel = new javax.swing.JLabel();
		strengthDamageAdjSpinner = new javax.swing.JSpinner();
		strengthWeightAllowanceLabel = new javax.swing.JLabel();
		strengthWeightAllowanceSpinner = new javax.swing.JSpinner();
		strengthMinOpenDoorLabel = new javax.swing.JLabel();
		strengthMinOpenDoor = new javax.swing.JSpinner();
		strengthBendBarsLabel = new javax.swing.JLabel();
		strengthBendBarsSpinner = new javax.swing.JSpinner();
		strengthNumDiceOpenLabelSpinner = new javax.swing.JSpinner();
		jPanel3 = new javax.swing.JPanel();
		strengthSizeDiceOpenSpinner = new javax.swing.JSpinner();
		strengthSizeDiceOpenLabel = new javax.swing.JLabel();
		strengthNumDiceOpenLabel = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		strengthScoreLabel = new javax.swing.JLabel();
		strengthPercentComboBox = new javax.swing.JComboBox();
		intelligencePanel = new javax.swing.JPanel();
		intelligenceScoreLabel = new javax.swing.JLabel();
		intelligenceScoreSpinner = new javax.swing.JSpinner();
		intelligenceKnowSpellLabel = new javax.swing.JLabel();
		intelligenceKnowSpellSpinner1 = new javax.swing.JSpinner();
		intelligenceMinSpellsLabel1 = new javax.swing.JLabel();
		intelligenceMinSpellsSpinner1 = new javax.swing.JSpinner();
		intelligenceMaxSpellsLabel1 = new javax.swing.JLabel();
		intelligenceMaxSpellsSpinner1 = new javax.swing.JSpinner();
		intelligenceLanguagesLabel1 = new javax.swing.JLabel();
		intelligenceLanguagesSpinner = new javax.swing.JSpinner();
		jPanel5 = new javax.swing.JPanel();
		intSpellBonus1Panel = new javax.swing.JPanel();
		intSpellBonusLevel1Spinner = new javax.swing.JSpinner();
		intSpellBonus1Panel1 = new javax.swing.JPanel();
		intSpellBonusLevel2Spinner1 = new javax.swing.JSpinner();
		intSpellBonus1Panel2 = new javax.swing.JPanel();
		intSpellBonusLevel3Spinner2 = new javax.swing.JSpinner();
		intSpellBonus1Panel3 = new javax.swing.JPanel();
		intSpellBonusLevel4Spinner3 = new javax.swing.JSpinner();
		intSpellBonus1Panel4 = new javax.swing.JPanel();
		intSpellBonusLevel5Spinner4 = new javax.swing.JSpinner();
		intSpellBonus1Panel5 = new javax.swing.JPanel();
		intSpellBonusLevel6Spinner5 = new javax.swing.JSpinner();
		intSpellBonus1Panel6 = new javax.swing.JPanel();
		intSpellBonusLevel7Spinner6 = new javax.swing.JSpinner();
		intSpellBonus1Panel7 = new javax.swing.JPanel();
		intSpellBonusLevel8Spinner7 = new javax.swing.JSpinner();
		intSpellBonus1Panel8 = new javax.swing.JPanel();
		intSpellBonusLevel9Spinner8 = new javax.swing.JSpinner();
		wisdomPanel = new javax.swing.JPanel();
		wisdomScoreLabel1 = new javax.swing.JLabel();
		wisdomScoreSpinner1 = new javax.swing.JSpinner();
		wisdomMagicAdjLabel = new javax.swing.JLabel();
		wisdomMagicAdjustSpinner = new javax.swing.JSpinner();
		wisdomSpellFailureLabel = new javax.swing.JLabel();
		wisdomSpellFailureSpinner = new javax.swing.JSpinner();
		jPanel7 = new javax.swing.JPanel();
		intSpellBonus1Panel9 = new javax.swing.JPanel();
		wisSpellBonusLevel1Spinner1 = new javax.swing.JSpinner();
		intSpellBonus1Panel10 = new javax.swing.JPanel();
		wisSpellBonusLevel2Spinner2 = new javax.swing.JSpinner();
		intSpellBonus1Panel11 = new javax.swing.JPanel();
		wisSpellBonusLevel3Spinner3 = new javax.swing.JSpinner();
		intSpellBonus1Panel12 = new javax.swing.JPanel();
		wisSpellBonusLevel4Spinner4 = new javax.swing.JSpinner();
		intSpellBonus1Panel13 = new javax.swing.JPanel();
		wisSpellBonusLevel5Spinner5 = new javax.swing.JSpinner();
		intSpellBonus1Panel14 = new javax.swing.JPanel();
		wisSpellBonusLevel6Spinner6 = new javax.swing.JSpinner();
		intSpellBonus1Panel15 = new javax.swing.JPanel();
		wisSpellBonusLevel7Spinner7 = new javax.swing.JSpinner();
		dexterityPanel = new javax.swing.JPanel();
		dexterityScoreLabel = new javax.swing.JLabel();
		dexterityScoreSpinner = new javax.swing.JSpinner();
		dexterityAttackAdjustmenLabel = new javax.swing.JLabel();
		dexterityAttackAdjustmentSpinner = new javax.swing.JSpinner();
		dexterityDefensiveAdjustmentLabel = new javax.swing.JLabel();
		dexterityDefensiveAdjustmentSpinner = new javax.swing.JSpinner();
		dexterityReactionAdjustmentLabel = new javax.swing.JLabel();
		dexterityreactionAdjustmentSpinner = new javax.swing.JSpinner();
		jPanel9 = new javax.swing.JPanel();
		dexPP1Panel16 = new javax.swing.JPanel();
		dexPPSpinner = new javax.swing.JSpinner();
		dexOLPanel17 = new javax.swing.JPanel();
		dexOLSpinner = new javax.swing.JSpinner();
		dexFRTPanel18 = new javax.swing.JPanel();
		dexFRTSpinner = new javax.swing.JSpinner();
		dexMSPanel19 = new javax.swing.JPanel();
		dexMSSpinner = new javax.swing.JSpinner();
		dexHSPanel20 = new javax.swing.JPanel();
		dexHSSpinner = new javax.swing.JSpinner();
		dexHNPanel21 = new javax.swing.JPanel();
		dexHNSpinner = new javax.swing.JSpinner();
		dexCWPanel22 = new javax.swing.JPanel();
		dexCWSpinner = new javax.swing.JSpinner();
		dexRLPanel23 = new javax.swing.JPanel();
		dexRLSpinner = new javax.swing.JSpinner();
		dexterityDefAdjBarbSpinner = new javax.swing.JSpinner();
		dexterityDefAdjBarbLabel = new javax.swing.JLabel();
		constitutionPanel = new javax.swing.JPanel();
		constitutionScoreLabel = new javax.swing.JLabel();
		constitutionScoreSpinner = new javax.swing.JSpinner();
		constitutionHitpointAdjustmentFighterLabel = new javax.swing.JLabel();
		constitutionHitPointAdjustmentFighterSpinner = new javax.swing.JSpinner();
		constitutionHitPointAdjustmentLabel = new javax.swing.JLabel();
		constitutionHitPointAdjustmentSpinner = new javax.swing.JSpinner();
		constitutionSystemShockLabel = new javax.swing.JLabel();
		constitutionSystemShockSpinner = new javax.swing.JSpinner();
		constitutionResurrectionSurvivelLabel = new javax.swing.JLabel();
		constitutionResurrectionSurvivelSpinner = new javax.swing.JSpinner();
		constitutionHitPointAdjustmentBarbarianSpinner1 = new javax.swing.JSpinner();
		constitutionHitpointAdjustmentBarbarianLabel = new javax.swing.JLabel();
		constitutionIronSpinner = new javax.swing.JSpinner();
		constitutionIronLabel = new javax.swing.JLabel();
		constitutionResistanceSpinner = new javax.swing.JSpinner();
		constitutionResistanceLabel = new javax.swing.JLabel();
		charismaPanel = new javax.swing.JPanel();
		charismaScoreLabel = new javax.swing.JLabel();
		charismaScoreSpinner = new javax.swing.JSpinner();
		charismaMaxHenchLabel = new javax.swing.JLabel();
		charismaMaxHenchSpinner = new javax.swing.JSpinner();
		charismaLoyaltyBaseLabel = new javax.swing.JLabel();
		charismaLoyaltyBaseSpinner = new javax.swing.JSpinner();
		charismaReactionAdjLabel = new javax.swing.JLabel();
		charismaReactionAdjSpinner = new javax.swing.JSpinner();
		mainPanel = new javax.swing.JPanel();
		selectPanel = new javax.swing.JPanel();
		strengthRadioButton = new javax.swing.JRadioButton();
		intelligenceRadioButton = new javax.swing.JRadioButton();
		wisdomRadioButton = new javax.swing.JRadioButton();
		dexterityRadioButton = new javax.swing.JRadioButton();
		constitutionRadioButton = new javax.swing.JRadioButton();
		charismaRadioButton = new javax.swing.JRadioButton();
		abilityPanel = new javax.swing.JPanel();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		strengthPanel.setBackground(new java.awt.Color(204, 204, 204));
		strengthPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Strength",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		strengthScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				25, 1));
		strengthScoreSpinner.setPreferredSize(new java.awt.Dimension(56, 22));
		strengthScoreSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						strengthScoreSpinnerStateChanged(evt);
					}
				});

		strengthHitBonusLabel.setText("to-hit adjustment");

		strengthHitBonusSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				-99, 99, 1));

		strengthDamageAdjLabel.setText("damage adjustment");

		strengthDamageAdjSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				-99, 99, 1));

		strengthWeightAllowanceLabel.setText("weight allowance");

		strengthWeightAllowanceSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99000, 1));
		strengthWeightAllowanceSpinner.setPreferredSize(new java.awt.Dimension(
				56, 22));

		strengthMinOpenDoorLabel.setText("open door");
		strengthMinOpenDoorLabel.setToolTipText("Minimum roll to open a door.");

		strengthMinOpenDoor.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				100, 1));

		strengthBendBarsLabel.setText("bend bars");

		strengthBendBarsSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				0, 100, 1));

		strengthNumDiceOpenLabelSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
		strengthNumDiceOpenLabelSpinner
				.setPreferredSize(new java.awt.Dimension(56, 22));

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));
		jPanel3.setLayout(new java.awt.GridBagLayout());

		strengthSizeDiceOpenSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		jPanel3.add(strengthSizeDiceOpenSpinner, gridBagConstraints);

		strengthSizeDiceOpenLabel.setText("d");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
		jPanel3.add(strengthSizeDiceOpenLabel, gridBagConstraints);

		strengthNumDiceOpenLabel
				.setBackground(new java.awt.Color(153, 153, 153));
		strengthNumDiceOpenLabel.setText("open door roll");
		strengthNumDiceOpenLabel
				.setToolTipText("Open door dice roll number and size of dice.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel3.add(strengthNumDiceOpenLabel, gridBagConstraints);

		jPanel4.setBackground(new java.awt.Color(204, 204, 204));
		jPanel4.setLayout(new java.awt.GridBagLayout());

		strengthScoreLabel.setText("ability score");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
		jPanel4.add(strengthScoreLabel, gridBagConstraints);

		strengthPercentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		strengthPercentComboBox
				.setToolTipText("Percentile Strength, for 18 only.");
		strengthPercentComboBox.setEnabled(false);
		strengthPercentComboBox
				.setPreferredSize(new java.awt.Dimension(55, 21));
		strengthPercentComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						strengthPercentComboBoxActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanel4.add(strengthPercentComboBox, gridBagConstraints);

		javax.swing.GroupLayout strengthPanelLayout = new javax.swing.GroupLayout(
				strengthPanel);
		strengthPanel.setLayout(strengthPanelLayout);
		strengthPanelLayout
				.setHorizontalGroup(strengthPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								strengthPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthScoreSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthHitBonusSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				strengthHitBonusLabel))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthDamageAdjSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				strengthDamageAdjLabel))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthBendBarsSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				strengthBendBarsLabel))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthWeightAllowanceSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				strengthWeightAllowanceLabel))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthMinOpenDoor,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				strengthMinOpenDoorLabel))
														.addGroup(
																strengthPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				strengthNumDiceOpenLabelSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jPanel3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(155, Short.MAX_VALUE)));

		strengthPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { strengthBendBarsSpinner,
						strengthDamageAdjSpinner, strengthHitBonusSpinner,
						strengthMinOpenDoor, strengthNumDiceOpenLabelSpinner,
						strengthScoreSpinner, strengthWeightAllowanceSpinner });

		strengthPanelLayout
				.setVerticalGroup(strengthPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								strengthPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthHitBonusSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																strengthHitBonusLabel))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthDamageAdjSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																strengthDamageAdjLabel))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthBendBarsSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																strengthBendBarsLabel))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthWeightAllowanceSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																strengthWeightAllowanceLabel))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthMinOpenDoor,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																strengthMinOpenDoorLabel))
										.addGroup(
												strengthPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																strengthNumDiceOpenLabelSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(103, Short.MAX_VALUE)));

		strengthPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { strengthBendBarsSpinner,
						strengthDamageAdjSpinner, strengthHitBonusSpinner,
						strengthMinOpenDoor, strengthNumDiceOpenLabelSpinner,
						strengthScoreSpinner, strengthWeightAllowanceSpinner });

		intelligencePanel.setBackground(new java.awt.Color(204, 204, 204));
		intelligencePanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Intelligence",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		intelligenceScoreLabel.setText("ability score");

		intelligenceScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				0, 25, 1));
		intelligenceScoreSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						intelligenceScoreSpinnerStateChanged(evt);
					}
				});

		intelligenceKnowSpellLabel.setText("know spell");

		intelligenceKnowSpellSpinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

		intelligenceMinSpellsLabel1.setText("minimum spells");

		intelligenceMinSpellsSpinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

		intelligenceMaxSpellsLabel1.setText("maximum spells");

		intelligenceMaxSpellsSpinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

		intelligenceLanguagesLabel1.setText("number of languages");
		intelligenceLanguagesLabel1
				.setToolTipText("Minimum roll to open a door.");

		intelligenceLanguagesSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

		jPanel5.setBackground(new java.awt.Color(204, 204, 204));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Bonus Spells",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));
		jPanel5.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonus1Panel.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 1",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel1Spinner.setModel(new javax.swing.SpinnerNumberModel(
				0, 0, 99, 1));
		intSpellBonus1Panel.add(intSpellBonusLevel1Spinner);

		jPanel5.add(intSpellBonus1Panel);

		intSpellBonus1Panel1.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 2",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel1.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel2Spinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel1.add(intSpellBonusLevel2Spinner1);

		jPanel5.add(intSpellBonus1Panel1);

		intSpellBonus1Panel2.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 3",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel2.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel3Spinner2
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel2.add(intSpellBonusLevel3Spinner2);

		jPanel5.add(intSpellBonus1Panel2);

		intSpellBonus1Panel3.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel3.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 4",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel3.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel4Spinner3
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel3.add(intSpellBonusLevel4Spinner3);

		jPanel5.add(intSpellBonus1Panel3);

		intSpellBonus1Panel4.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel4.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 5",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel4.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel5Spinner4
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel4.add(intSpellBonusLevel5Spinner4);

		jPanel5.add(intSpellBonus1Panel4);

		intSpellBonus1Panel5.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel5.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 6",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel5.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel6Spinner5
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel5.add(intSpellBonusLevel6Spinner5);

		jPanel5.add(intSpellBonus1Panel5);

		intSpellBonus1Panel6.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel6.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 7",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel6.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel7Spinner6
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel6.add(intSpellBonusLevel7Spinner6);

		jPanel5.add(intSpellBonus1Panel6);

		intSpellBonus1Panel7.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel7.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 8",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel7.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel8Spinner7
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel7.add(intSpellBonusLevel8Spinner7);

		jPanel5.add(intSpellBonus1Panel7);

		intSpellBonus1Panel8.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel8.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 9",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel8.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonusLevel9Spinner8
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel8.add(intSpellBonusLevel9Spinner8);

		jPanel5.add(intSpellBonus1Panel8);

		javax.swing.GroupLayout intelligencePanelLayout = new javax.swing.GroupLayout(
				intelligencePanel);
		intelligencePanel.setLayout(intelligencePanelLayout);
		intelligencePanelLayout
				.setHorizontalGroup(intelligencePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								intelligencePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																intelligencePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				intelligenceKnowSpellSpinner1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				intelligenceKnowSpellLabel))
														.addGroup(
																intelligencePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				intelligenceScoreSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				intelligenceScoreLabel))
														.addGroup(
																intelligencePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				intelligenceLanguagesSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				intelligenceLanguagesLabel1))
														.addGroup(
																intelligencePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				intelligenceMaxSpellsSpinner1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				intelligenceMaxSpellsLabel1))
														.addGroup(
																intelligencePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				intelligenceMinSpellsSpinner1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				intelligenceMinSpellsLabel1)))
										.addContainerGap(174, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								intelligencePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												390,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		intelligencePanelLayout
				.linkSize(javax.swing.SwingConstants.HORIZONTAL,
						new java.awt.Component[] {
								intelligenceKnowSpellSpinner1,
								intelligenceLanguagesSpinner,
								intelligenceMaxSpellsSpinner1,
								intelligenceMinSpellsSpinner1,
								intelligenceScoreSpinner });

		intelligencePanelLayout
				.setVerticalGroup(intelligencePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								intelligencePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																intelligenceScoreLabel)
														.addComponent(
																intelligenceScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																intelligenceLanguagesSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																intelligenceLanguagesLabel1))
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																intelligenceKnowSpellSpinner1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																intelligenceKnowSpellLabel))
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																intelligenceMinSpellsSpinner1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																intelligenceMinSpellsLabel1))
										.addGroup(
												intelligencePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																intelligenceMaxSpellsLabel1)
														.addComponent(
																intelligenceMaxSpellsSpinner1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		intelligencePanelLayout
				.linkSize(javax.swing.SwingConstants.VERTICAL,
						new java.awt.Component[] {
								intelligenceKnowSpellSpinner1,
								intelligenceLanguagesSpinner,
								intelligenceMaxSpellsSpinner1,
								intelligenceMinSpellsSpinner1,
								intelligenceScoreSpinner });

		wisdomPanel.setBackground(new java.awt.Color(204, 204, 204));
		wisdomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Wisdom",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		wisdomScoreLabel1.setText("ability score");

		wisdomScoreSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				25, 1));
		wisdomScoreSpinner1
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						wisdomScoreSpinner1StateChanged(evt);
					}
				});

		wisdomMagicAdjLabel.setText("magical adjustment");

		wisdomMagicAdjustSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				-99, 99, 1));

		wisdomSpellFailureLabel.setText("spell failure");

		wisdomSpellFailureSpinner.setModel(new javax.swing.SpinnerNumberModel(
				0, 0, 100, 1));

		jPanel7.setBackground(new java.awt.Color(204, 204, 204));
		jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Bonus Spells",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));
		jPanel7.setLayout(new java.awt.GridLayout(1, 9));

		intSpellBonus1Panel9.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel9.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 1",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel9.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel1Spinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel9.add(wisSpellBonusLevel1Spinner1);

		jPanel7.add(intSpellBonus1Panel9);

		intSpellBonus1Panel10.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel10.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 2",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel10.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel2Spinner2
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel10.add(wisSpellBonusLevel2Spinner2);

		jPanel7.add(intSpellBonus1Panel10);

		intSpellBonus1Panel11.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel11.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 3",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel11.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel3Spinner3
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel11.add(wisSpellBonusLevel3Spinner3);

		jPanel7.add(intSpellBonus1Panel11);

		intSpellBonus1Panel12.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel12.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 4",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel12.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel4Spinner4
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel12.add(wisSpellBonusLevel4Spinner4);

		jPanel7.add(intSpellBonus1Panel12);

		intSpellBonus1Panel13.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel13.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 5",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel13.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel5Spinner5
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel13.add(wisSpellBonusLevel5Spinner5);

		jPanel7.add(intSpellBonus1Panel13);

		intSpellBonus1Panel14.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel14.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 6",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel14.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel6Spinner6
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel14.add(wisSpellBonusLevel6Spinner6);

		jPanel7.add(intSpellBonus1Panel14);

		intSpellBonus1Panel15.setBackground(new java.awt.Color(204, 204, 204));
		intSpellBonus1Panel15.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Level 7",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.ABOVE_BOTTOM,
						new java.awt.Font("Segoe UI", 0, 10)));
		intSpellBonus1Panel15.setLayout(new java.awt.GridLayout(1, 9));

		wisSpellBonusLevel7Spinner7
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
		intSpellBonus1Panel15.add(wisSpellBonusLevel7Spinner7);

		jPanel7.add(intSpellBonus1Panel15);

		javax.swing.GroupLayout wisdomPanelLayout = new javax.swing.GroupLayout(
				wisdomPanel);
		wisdomPanel.setLayout(wisdomPanelLayout);
		wisdomPanelLayout
				.setHorizontalGroup(wisdomPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								wisdomPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												wisdomPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																wisdomPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				wisdomMagicAdjustSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				wisdomMagicAdjLabel))
														.addGroup(
																wisdomPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				wisdomSpellFailureSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				wisdomSpellFailureLabel))
														.addComponent(
																jPanel7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																390,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																wisdomPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				wisdomScoreSpinner1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				wisdomScoreLabel1)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		wisdomPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { wisdomMagicAdjustSpinner,
						wisdomScoreSpinner1, wisdomSpellFailureSpinner });

		wisdomPanelLayout
				.setVerticalGroup(wisdomPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								wisdomPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												wisdomPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																wisdomScoreSpinner1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																wisdomScoreLabel1))
										.addGap(0, 0, 0)
										.addGroup(
												wisdomPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																wisdomMagicAdjustSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																wisdomMagicAdjLabel))
										.addGroup(
												wisdomPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																wisdomSpellFailureSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																wisdomSpellFailureLabel))
										.addComponent(
												jPanel7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		wisdomPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { wisdomMagicAdjustSpinner,
						wisdomScoreSpinner1, wisdomSpellFailureSpinner });

		dexterityPanel.setBackground(new java.awt.Color(204, 204, 204));
		dexterityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Dexterity",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		dexterityScoreLabel.setText("ability score");

		dexterityScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				25, 1));
		dexterityScoreSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						dexterityScoreSpinnerStateChanged(evt);
					}
				});

		dexterityAttackAdjustmenLabel.setText("attack adjustment");

		dexterityAttackAdjustmentSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));

		dexterityDefensiveAdjustmentLabel.setText("defensive adjustment");

		dexterityDefensiveAdjustmentSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));

		dexterityReactionAdjustmentLabel.setText("reaction adjustment");
		dexterityReactionAdjustmentLabel
				.setToolTipText("Minimum roll to open a door.");

		dexterityreactionAdjustmentSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));

		jPanel9.setBackground(new java.awt.Color(204, 204, 204));
		jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Dexterity Skill Adjustments",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));
		jPanel9.setLayout(new java.awt.GridLayout(1, 9));

		dexPP1Panel16.setBackground(new java.awt.Color(204, 204, 204));
		dexPP1Panel16.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "PP",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexPP1Panel16.setToolTipText("Pick Pocket");
		dexPP1Panel16.setLayout(new java.awt.GridLayout(1, 9));

		dexPPSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexPP1Panel16.add(dexPPSpinner);

		jPanel9.add(dexPP1Panel16);

		dexOLPanel17.setBackground(new java.awt.Color(204, 204, 204));
		dexOLPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "OL",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexOLPanel17.setToolTipText("Open Locks");
		dexOLPanel17.setLayout(new java.awt.GridLayout(1, 9));

		dexOLSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexOLPanel17.add(dexOLSpinner);

		jPanel9.add(dexOLPanel17);

		dexFRTPanel18.setBackground(new java.awt.Color(204, 204, 204));
		dexFRTPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "F/R T",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexFRTPanel18.setToolTipText("Find/Remove Traps");
		dexFRTPanel18.setLayout(new java.awt.GridLayout(1, 9));

		dexFRTSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexFRTPanel18.add(dexFRTSpinner);

		jPanel9.add(dexFRTPanel18);

		dexMSPanel19.setBackground(new java.awt.Color(204, 204, 204));
		dexMSPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "MS",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexMSPanel19.setToolTipText("Move Silently");
		dexMSPanel19.setLayout(new java.awt.GridLayout(1, 9));

		dexMSSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexMSPanel19.add(dexMSSpinner);

		jPanel9.add(dexMSPanel19);

		dexHSPanel20.setBackground(new java.awt.Color(204, 204, 204));
		dexHSPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "HS",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexHSPanel20.setToolTipText("Hide in Shadows");
		dexHSPanel20.setLayout(new java.awt.GridLayout(1, 9));

		dexHSSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexHSPanel20.add(dexHSSpinner);

		jPanel9.add(dexHSPanel20);

		dexHNPanel21.setBackground(new java.awt.Color(204, 204, 204));
		dexHNPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "HN",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexHNPanel21.setToolTipText("Hear Noise");
		dexHNPanel21.setLayout(new java.awt.GridLayout(1, 9));

		dexHNSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexHNPanel21.add(dexHNSpinner);

		jPanel9.add(dexHNPanel21);

		dexCWPanel22.setBackground(new java.awt.Color(204, 204, 204));
		dexCWPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "CW",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexCWPanel22.setToolTipText("Climb Walls");
		dexCWPanel22.setLayout(new java.awt.GridLayout(1, 9));

		dexCWSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexCWPanel22.add(dexCWSpinner);

		jPanel9.add(dexCWPanel22);

		dexRLPanel23.setBackground(new java.awt.Color(204, 204, 204));
		dexRLPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "RL",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.ABOVE_BOTTOM,
				new java.awt.Font("Segoe UI", 0, 10)));
		dexRLPanel23.setToolTipText("Read Languages");
		dexRLPanel23.setLayout(new java.awt.GridLayout(1, 9));

		dexRLSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -200, 200,
				1));
		dexRLPanel23.add(dexRLSpinner);

		jPanel9.add(dexRLPanel23);

		dexterityDefAdjBarbSpinner.setModel(new javax.swing.SpinnerNumberModel(
				0, -99, 99, 1));

		dexterityDefAdjBarbLabel.setText("defensive adjustment for barbarian");
		dexterityDefAdjBarbLabel
				.setToolTipText("Barbarian style defense adjustment while in light armor.");

		javax.swing.GroupLayout dexterityPanelLayout = new javax.swing.GroupLayout(
				dexterityPanel);
		dexterityPanel.setLayout(dexterityPanelLayout);
		dexterityPanelLayout
				.setHorizontalGroup(dexterityPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								dexterityPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																dexterityPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				dexterityPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								dexterityDefAdjBarbSpinner,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								dexterityDefensiveAdjustmentSpinner,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								dexterityAttackAdjustmentSpinner,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								dexterityreactionAdjustmentSpinner,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								dexterityScoreSpinner,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				dexterityPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								dexterityPanelLayout
																										.createSequentialGroup()
																										.addGap(16,
																												16,
																												16)
																										.addComponent(
																												dexterityScoreLabel))
																						.addGroup(
																								dexterityPanelLayout
																										.createSequentialGroup()
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												dexterityReactionAdjustmentLabel))
																						.addGroup(
																								dexterityPanelLayout
																										.createSequentialGroup()
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												dexterityAttackAdjustmenLabel))
																						.addGroup(
																								dexterityPanelLayout
																										.createSequentialGroup()
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												dexterityDefensiveAdjustmentLabel))
																						.addGroup(
																								dexterityPanelLayout
																										.createSequentialGroup()
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												dexterityDefAdjBarbLabel))))
														.addComponent(
																jPanel9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																390,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(18, Short.MAX_VALUE)));

		dexterityPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { dexterityAttackAdjustmentSpinner,
						dexterityDefAdjBarbSpinner,
						dexterityDefensiveAdjustmentSpinner,
						dexterityScoreSpinner,
						dexterityreactionAdjustmentSpinner });

		dexterityPanelLayout
				.setVerticalGroup(dexterityPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								dexterityPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dexterityScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dexterityScoreLabel))
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dexterityreactionAdjustmentSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dexterityReactionAdjustmentLabel))
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dexterityAttackAdjustmentSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dexterityAttackAdjustmenLabel))
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dexterityDefensiveAdjustmentSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dexterityDefensiveAdjustmentLabel))
										.addGroup(
												dexterityPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																dexterityDefAdjBarbSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dexterityDefAdjBarbLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		dexterityPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { dexterityAttackAdjustmentSpinner,
						dexterityDefAdjBarbSpinner,
						dexterityDefensiveAdjustmentSpinner,
						dexterityScoreSpinner,
						dexterityreactionAdjustmentSpinner });

		constitutionPanel.setBackground(new java.awt.Color(204, 204, 204));
		constitutionPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Constitution",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 12)));

		constitutionScoreLabel.setText("ability score");

		constitutionScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				0, 25, 1));
		constitutionScoreSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						constitutionScoreSpinnerStateChanged(evt);
					}
				});

		constitutionHitpointAdjustmentFighterLabel
				.setText("hitpoint adjustment *fighters*");
		constitutionHitpointAdjustmentFighterLabel
				.setToolTipText("Fighter type classes hitpoint adjustment.");

		constitutionHitPointAdjustmentFighterSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 100, 1));

		constitutionHitPointAdjustmentLabel.setText("hitpoint adjustment");
		constitutionHitPointAdjustmentLabel
				.setToolTipText("Non-fighter hitpoint adjustments.");

		constitutionHitPointAdjustmentSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 99, 1));

		constitutionSystemShockLabel.setText("system shock");

		constitutionSystemShockSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

		constitutionResurrectionSurvivelLabel.setText("resurrection survival");

		constitutionResurrectionSurvivelSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

		constitutionHitPointAdjustmentBarbarianSpinner1
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 100, 1));

		constitutionHitpointAdjustmentBarbarianLabel
				.setText("hitpoint adjustment *barbarians*");
		constitutionHitpointAdjustmentBarbarianLabel
				.setToolTipText("Fighter type classes hitpoint adjustment.");

		constitutionIronSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				-99, 100, 1));

		constitutionIronLabel.setText("iron constitution *+save vrs poison*");
		constitutionIronLabel
				.setToolTipText("Fighter type classes hitpoint adjustment.");

		constitutionResistanceSpinner
				.setModel(new javax.swing.SpinnerNumberModel(0, -99, 100, 1));

		constitutionResistanceLabel
				.setText("resistance *spells, rod/staff/wand*");
		constitutionResistanceLabel
				.setToolTipText("Fighter type classes hitpoint adjustment.");

		javax.swing.GroupLayout constitutionPanelLayout = new javax.swing.GroupLayout(
				constitutionPanel);
		constitutionPanel.setLayout(constitutionPanelLayout);
		constitutionPanelLayout
				.setHorizontalGroup(constitutionPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								constitutionPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionHitPointAdjustmentFighterSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionHitpointAdjustmentFighterLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionHitPointAdjustmentBarbarianSpinner1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionHitpointAdjustmentBarbarianLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionSystemShockSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionSystemShockLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionResistanceSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionResistanceLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionResurrectionSurvivelSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionResurrectionSurvivelLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionIronSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionIronLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionScoreSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionScoreLabel))
														.addGroup(
																constitutionPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				constitutionHitPointAdjustmentSpinner,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				constitutionHitPointAdjustmentLabel)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		constitutionPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] {
						constitutionHitPointAdjustmentBarbarianSpinner1,
						constitutionHitPointAdjustmentFighterSpinner,
						constitutionHitPointAdjustmentSpinner,
						constitutionIronSpinner, constitutionResistanceSpinner,
						constitutionResurrectionSurvivelSpinner,
						constitutionScoreSpinner,
						constitutionSystemShockSpinner });

		constitutionPanelLayout
				.setVerticalGroup(constitutionPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								constitutionPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionScoreLabel)
														.addComponent(
																constitutionScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionHitPointAdjustmentSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionHitPointAdjustmentLabel))
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionHitPointAdjustmentFighterSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionHitpointAdjustmentFighterLabel))
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionHitPointAdjustmentBarbarianSpinner1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionHitpointAdjustmentBarbarianLabel))
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionSystemShockSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionSystemShockLabel))
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionResurrectionSurvivelLabel)
														.addComponent(
																constitutionResurrectionSurvivelSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionIronSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionIronLabel))
										.addGroup(
												constitutionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																constitutionResistanceSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																constitutionResistanceLabel))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		constitutionPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] {
						constitutionHitPointAdjustmentBarbarianSpinner1,
						constitutionHitPointAdjustmentFighterSpinner,
						constitutionHitPointAdjustmentSpinner,
						constitutionIronSpinner, constitutionResistanceSpinner,
						constitutionResurrectionSurvivelSpinner,
						constitutionScoreSpinner,
						constitutionSystemShockSpinner });

		charismaPanel.setBackground(new java.awt.Color(204, 204, 204));
		charismaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Charisma",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		charismaScoreLabel.setText("ability score");

		charismaScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0,
				25, 1));
		charismaScoreSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						charismaScoreSpinnerStateChanged(evt);
					}
				});

		charismaMaxHenchLabel.setText("maximum henchmen");

		charismaMaxHenchSpinner.setModel(new javax.swing.SpinnerNumberModel(0,
				0, 100, 1));

		charismaLoyaltyBaseLabel.setText("loyalty base");

		charismaLoyaltyBaseSpinner.setModel(new javax.swing.SpinnerNumberModel(
				0, -100, 100, 1));

		charismaReactionAdjLabel.setText("reaction adjustment");

		charismaReactionAdjSpinner.setModel(new javax.swing.SpinnerNumberModel(
				0, -100, 100, 1));

		javax.swing.GroupLayout charismaPanelLayout = new javax.swing.GroupLayout(
				charismaPanel);
		charismaPanel.setLayout(charismaPanelLayout);
		charismaPanelLayout
				.setHorizontalGroup(charismaPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								charismaPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																charismaScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																56,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																charismaMaxHenchSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																charismaLoyaltyBaseSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																53,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																charismaReactionAdjSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																53,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																charismaPanelLayout
																		.createSequentialGroup()
																		.addGap(8,
																				8,
																				8)
																		.addComponent(
																				charismaLoyaltyBaseLabel))
														.addGroup(
																charismaPanelLayout
																		.createSequentialGroup()
																		.addGap(8,
																				8,
																				8)
																		.addComponent(
																				charismaReactionAdjLabel))
														.addGroup(
																charismaPanelLayout
																		.createSequentialGroup()
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				charismaScoreLabel))
														.addGroup(
																charismaPanelLayout
																		.createSequentialGroup()
																		.addGap(5,
																				5,
																				5)
																		.addComponent(
																				charismaMaxHenchLabel)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		charismaPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { charismaLoyaltyBaseSpinner,
						charismaMaxHenchSpinner, charismaReactionAdjSpinner,
						charismaScoreSpinner });

		charismaPanelLayout
				.setVerticalGroup(charismaPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								charismaPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																charismaScoreLabel)
														.addComponent(
																charismaScoreSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																charismaMaxHenchSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																charismaMaxHenchLabel))
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																charismaLoyaltyBaseLabel)
														.addComponent(
																charismaLoyaltyBaseSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)
										.addGroup(
												charismaPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																charismaReactionAdjLabel)
														.addComponent(
																charismaReactionAdjSpinner,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		charismaPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { charismaLoyaltyBaseSpinner,
						charismaMaxHenchSpinner, charismaReactionAdjSpinner,
						charismaScoreSpinner });

		setTitle("Ability Scores");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setLayout(new java.awt.BorderLayout());

		abilitySelectbuttonGroup.add(strengthRadioButton);
		strengthRadioButton.setSelected(true);
		strengthRadioButton.setText("Strength");
		strengthRadioButton.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				strengthRadioButtonItemStateChanged(evt);
			}
		});
		strengthRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						strengthRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(strengthRadioButton);

		abilitySelectbuttonGroup.add(intelligenceRadioButton);
		intelligenceRadioButton.setText("Intelligence");
		intelligenceRadioButton
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						intelligenceRadioButtonItemStateChanged(evt);
					}
				});
		intelligenceRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						intelligenceRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(intelligenceRadioButton);

		abilitySelectbuttonGroup.add(wisdomRadioButton);
		wisdomRadioButton.setText("Wisdom");
		wisdomRadioButton.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				wisdomRadioButtonItemStateChanged(evt);
			}
		});
		wisdomRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						wisdomRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(wisdomRadioButton);

		abilitySelectbuttonGroup.add(dexterityRadioButton);
		dexterityRadioButton.setText("Dexterity");
		dexterityRadioButton.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				dexterityRadioButtonItemStateChanged(evt);
			}
		});
		dexterityRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						dexterityRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(dexterityRadioButton);

		abilitySelectbuttonGroup.add(constitutionRadioButton);
		constitutionRadioButton.setText("Constitution");
		constitutionRadioButton
				.addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						constitutionRadioButtonItemStateChanged(evt);
					}
				});
		constitutionRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						constitutionRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(constitutionRadioButton);

		abilitySelectbuttonGroup.add(charismaRadioButton);
		charismaRadioButton.setText("Charisma");
		charismaRadioButton.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				charismaRadioButtonItemStateChanged(evt);
			}
		});
		charismaRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						charismaRadioButtonActionPerformed(evt);
					}
				});
		selectPanel.add(charismaRadioButton);

		mainPanel.add(selectPanel, java.awt.BorderLayout.PAGE_START);

		abilityPanel.setBackground(new java.awt.Color(153, 153, 153));
		abilityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Ability Score",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		abilityPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(abilityPanel, java.awt.BorderLayout.CENTER);

		buttonPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(doneButton);

		mainPanel.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// make sure to save the last entry to memory when they close up shop
		if (strengthRadioButton.isSelected()) {
			strengthUpdateStored((int) strengthScoreSpinner.getValue(), null);
		} else if (intelligenceRadioButton.isSelected()) {
			intelligenceUpdateStored((int) intelligenceScoreSpinner.getValue());
		} else if (dexterityRadioButton.isSelected()) {
			dexterityUpdateStored((int) dexterityScoreSpinner.getValue());
		} else if (constitutionRadioButton.isSelected()) {
			constitutionUpdateStored((int) constitutionScoreSpinner.getValue());
		} else if (wisdomRadioButton.isSelected()) {
			wisdomUpdateStored((int) wisdomScoreSpinner1.getValue());
		} else if (charismaRadioButton.isSelected()) {
			charismaUpdateStored((int) charismaScoreSpinner.getValue());
		}

	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void charismaUpdatePanel(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oB = ost.abilityStatList.getContent().get(nScore);
			charismaScoreSpinner.setValue(oB.getCharisma().score);
			charismaMaxHenchSpinner
					.setValue(oB.getCharisma().maxNumberHenchmen);
			charismaLoyaltyBaseSpinner.setValue(oB.getCharisma().loyaltyBase);
			charismaReactionAdjSpinner
					.setValue(oB.getCharisma().reactionAdjustment);

			nPreviousCharisma = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void charismaUpdateStored(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oA = ost.abilityStatList.getContent().get(nScore);
			oA.getCharisma().score = nScore;
			oA.getCharisma().maxNumberHenchmen = (int) charismaMaxHenchSpinner
					.getValue();
			oA.getCharisma().loyaltyBase = (int) charismaLoyaltyBaseSpinner
					.getValue();
			oA.getCharisma().reactionAdjustment = (int) charismaReactionAdjSpinner
					.getValue();
		}
	}

	private void charismaRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (!charismaRadioButton.isSelected())
			charismaUpdateStored((int) charismaScoreSpinner.getValue());
	}

	private void charismaScoreSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		int nScore = (int) charismaScoreSpinner.getValue();
		charismaUpdateStored(nPreviousCharisma);
		charismaUpdatePanel(nScore);

	}

	private void charismaRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (charismaRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(charismaPanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void constitutionUpdatePanel(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oB = ost.abilityStatList.getContent().get(nScore);
			constitutionScoreSpinner.setValue(oB.getConsitution().score);
			constitutionHitPointAdjustmentSpinner
					.setValue(oB.getConsitution().hitpointAdjustment);
			constitutionHitPointAdjustmentFighterSpinner.setValue(oB
					.getConsitution().hitpointAdjustmentFighter);
			constitutionHitPointAdjustmentBarbarianSpinner1.setValue(oB
					.getConsitution().hitpointAdjustmentBarbarian);
			constitutionSystemShockSpinner
					.setValue(oB.getConsitution().systemShock);
			constitutionResurrectionSurvivelSpinner.setValue(oB
					.getConsitution().resurrectionSurvival);
			constitutionIronSpinner.setValue(oB.getConsitution().conIron);
			constitutionResistanceSpinner
					.setValue(oB.getConsitution().conResistance);
			nPreviousConstitution = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void constitutionUpdateStored(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oA = ost.abilityStatList.getContent().get(nScore);
			oA.getConsitution().score = nScore;
			oA.getConsitution().hitpointAdjustment = (int) constitutionHitPointAdjustmentSpinner
					.getValue();
			oA.getConsitution().hitpointAdjustmentFighter = (int) constitutionHitPointAdjustmentFighterSpinner
					.getValue();
			oA.getConsitution().hitpointAdjustmentBarbarian = (int) constitutionHitPointAdjustmentBarbarianSpinner1
					.getValue();
			oA.getConsitution().systemShock = (int) constitutionSystemShockSpinner
					.getValue();
			oA.getConsitution().resurrectionSurvival = (int) constitutionResurrectionSurvivelSpinner
					.getValue();
			oA.getConsitution().conIron = (int) constitutionIronSpinner
					.getValue();
			oA.getConsitution().conResistance = (int) constitutionResistanceSpinner
					.getValue();
		}
	}

	private void constitutionRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (!constitutionRadioButton.isSelected())
			constitutionUpdateStored((int) constitutionScoreSpinner.getValue());
	}

	private void constitutionScoreSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		int nScore = (int) constitutionScoreSpinner.getValue();
		constitutionUpdateStored(nPreviousConstitution);
		constitutionUpdatePanel(nScore);
	}

	private void constitutionRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (constitutionRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(constitutionPanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void dexterityUpdatePanel(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oB = ost.abilityStatList.getContent().get(nScore);
			dexterityScoreSpinner.setValue(oB.getDexterity().score);
			dexterityreactionAdjustmentSpinner
					.setValue(oB.getDexterity().reactionAdjustment);
			dexterityAttackAdjustmentSpinner
					.setValue(oB.getDexterity().attackAdjustment);
			dexterityDefensiveAdjustmentSpinner
					.setValue(oB.getDexterity().defensiveAdjustment);
			dexterityDefAdjBarbSpinner
					.setValue(oB.getDexterity().defensiveAdjustmentBarbarian);

			dexPPSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(0).score);
			dexOLSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(1).score);
			dexFRTSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(2).score);
			dexMSSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(3).score);
			dexHSSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(4).score);
			dexHNSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(5).score);
			dexCWSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(6).score);
			dexRLSpinner
					.setValue(oB.getDexterity().skillsAdjustments.get(7).score);

			nPreviousDexterity = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void dexterityUpdateStored(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oA = ost.abilityStatList.getContent().get(nScore);
			oA.getDexterity().score = nScore;

			oA.getDexterity().reactionAdjustment = (int) dexterityreactionAdjustmentSpinner
					.getValue();
			oA.getDexterity().attackAdjustment = (int) dexterityAttackAdjustmentSpinner
					.getValue();
			oA.getDexterity().defensiveAdjustment = (int) dexterityDefensiveAdjustmentSpinner
					.getValue();
			oA.getDexterity().defensiveAdjustmentBarbarian = (int) dexterityDefAdjBarbSpinner
					.getValue();

			oA.getDexterity().skillsAdjustments.get(0).score = (int) dexPPSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(1).score = (int) dexOLSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(2).score = (int) dexFRTSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(3).score = (int) dexMSSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(4).score = (int) dexHSSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(5).score = (int) dexHNSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(6).score = (int) dexCWSpinner
					.getValue();
			oA.getDexterity().skillsAdjustments.get(7).score = (int) dexRLSpinner
					.getValue();
		}
	}

	private void dexterityRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (!dexterityRadioButton.isSelected())
			dexterityUpdateStored((int) dexterityScoreSpinner.getValue());
	}

	private void dexterityScoreSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		int nScore = (int) dexterityScoreSpinner.getValue();
		dexterityUpdateStored(nPreviousDexterity);
		dexterityUpdatePanel(nScore);

	}

	private void dexterityRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (dexterityRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(dexterityPanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void wisdomUpdatePanel(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oB = ost.abilityStatList.getContent().get(nScore);
			wisdomScoreSpinner1.setValue(oB.getWisdom().score);
			wisdomMagicAdjustSpinner.setValue(oB.getWisdom().magicalAdjustment);
			wisdomSpellFailureSpinner.setValue(oB.getWisdom().spellFailure);

			wisSpellBonusLevel1Spinner1.setValue(oB.getWisdom().bonusSpells[0]);
			wisSpellBonusLevel2Spinner2.setValue(oB.getWisdom().bonusSpells[1]);
			wisSpellBonusLevel3Spinner3.setValue(oB.getWisdom().bonusSpells[2]);
			wisSpellBonusLevel4Spinner4.setValue(oB.getWisdom().bonusSpells[3]);
			wisSpellBonusLevel5Spinner5.setValue(oB.getWisdom().bonusSpells[4]);
			wisSpellBonusLevel6Spinner6.setValue(oB.getWisdom().bonusSpells[5]);
			wisSpellBonusLevel7Spinner7.setValue(oB.getWisdom().bonusSpells[6]);

			nPreviousWisdom = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void wisdomUpdateStored(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oA = ost.abilityStatList.getContent().get(nScore);
			oA.getWisdom().score = nScore;
			oA.getWisdom().magicalAdjustment = (int) wisdomMagicAdjustSpinner
					.getValue();
			oA.getWisdom().spellFailure = (int) wisdomSpellFailureSpinner
					.getValue();

			oA.getWisdom().bonusSpells[0] = (int) wisSpellBonusLevel1Spinner1
					.getValue();
			oA.getWisdom().bonusSpells[1] = (int) wisSpellBonusLevel2Spinner2
					.getValue();
			oA.getWisdom().bonusSpells[2] = (int) wisSpellBonusLevel3Spinner3
					.getValue();
			oA.getWisdom().bonusSpells[3] = (int) wisSpellBonusLevel4Spinner4
					.getValue();
			oA.getWisdom().bonusSpells[4] = (int) wisSpellBonusLevel5Spinner5
					.getValue();
			oA.getWisdom().bonusSpells[5] = (int) wisSpellBonusLevel6Spinner6
					.getValue();
			oA.getWisdom().bonusSpells[6] = (int) wisSpellBonusLevel7Spinner7
					.getValue();
		}
	}

	private void wisdomRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		if (!wisdomRadioButton.isSelected())
			wisdomUpdateStored((int) wisdomScoreSpinner1.getValue());

	}

	private void wisdomScoreSpinner1StateChanged(
			javax.swing.event.ChangeEvent evt) {
		int nScore = (int) wisdomScoreSpinner1.getValue();
		wisdomUpdateStored(nPreviousWisdom);
		wisdomUpdatePanel(nScore);

	}

	private void wisdomRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (wisdomRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(wisdomPanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	private void intelligenceRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// deselected this button
		if (!intelligenceRadioButton.isSelected()) {
			intelligenceUpdateStored((int) intelligenceScoreSpinner.getValue());
		}
	}

	private void intelligenceScoreSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		int nScore = (int) intelligenceScoreSpinner.getValue();
		intelligenceUpdateStored(nPreviousIntelligence);
		intelligenceUpdatePanel(nScore);
	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void intelligenceUpdatePanel(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oB = ost.abilityStatList.getContent().get(nScore);
			intelligenceScoreSpinner.setValue(oB.getIntelligence().score);
			intelligenceKnowSpellSpinner1
					.setValue(oB.getIntelligence().knowSpell);
			intelligenceMinSpellsSpinner1
					.setValue(oB.getIntelligence().minSpells);
			intelligenceMaxSpellsSpinner1
					.setValue(oB.getIntelligence().maxSpells);
			intelligenceLanguagesSpinner
					.setValue(oB.getIntelligence().languages);

			intSpellBonusLevel1Spinner
					.setValue(oB.getIntelligence().bonusSpells[0]);
			intSpellBonusLevel2Spinner1
					.setValue(oB.getIntelligence().bonusSpells[1]);
			intSpellBonusLevel3Spinner2
					.setValue(oB.getIntelligence().bonusSpells[2]);
			intSpellBonusLevel4Spinner3
					.setValue(oB.getIntelligence().bonusSpells[3]);
			intSpellBonusLevel5Spinner4
					.setValue(oB.getIntelligence().bonusSpells[4]);
			intSpellBonusLevel6Spinner5
					.setValue(oB.getIntelligence().bonusSpells[5]);
			intSpellBonusLevel7Spinner6
					.setValue(oB.getIntelligence().bonusSpells[6]);
			intSpellBonusLevel8Spinner7
					.setValue(oB.getIntelligence().bonusSpells[7]);
			intSpellBonusLevel9Spinner8
					.setValue(oB.getIntelligence().bonusSpells[8]);

			nPreviousIntelligence = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void intelligenceUpdateStored(int nScore) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oA = ost.abilityStatList.getContent().get(nScore);
			oA.getIntelligence().score = nScore;
			oA.getIntelligence().knowSpell = (int) intelligenceKnowSpellSpinner1
					.getValue();
			oA.getIntelligence().minSpells = (int) intelligenceMinSpellsSpinner1
					.getValue();
			oA.getIntelligence().maxSpells = (int) intelligenceMaxSpellsSpinner1
					.getValue();
			oA.getIntelligence().languages = (int) intelligenceLanguagesSpinner
					.getValue();

			oA.getIntelligence().bonusSpells[0] = (int) intSpellBonusLevel1Spinner
					.getValue();
			oA.getIntelligence().bonusSpells[1] = (int) intSpellBonusLevel2Spinner1
					.getValue();
			oA.getIntelligence().bonusSpells[2] = (int) intSpellBonusLevel3Spinner2
					.getValue();
			oA.getIntelligence().bonusSpells[3] = (int) intSpellBonusLevel4Spinner3
					.getValue();
			oA.getIntelligence().bonusSpells[4] = (int) intSpellBonusLevel5Spinner4
					.getValue();
			oA.getIntelligence().bonusSpells[5] = (int) intSpellBonusLevel6Spinner5
					.getValue();
			oA.getIntelligence().bonusSpells[6] = (int) intSpellBonusLevel7Spinner6
					.getValue();
			oA.getIntelligence().bonusSpells[7] = (int) intSpellBonusLevel8Spinner7
					.getValue();
			oA.getIntelligence().bonusSpells[8] = (int) intSpellBonusLevel9Spinner8
					.getValue();
		}
	}

	private void intelligenceRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (intelligenceRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(intelligencePanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	private void strengthScoreSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {

		int nScore = (int) strengthScoreSpinner.getValue();
		if (strengthPercentComboBox.isEnabled()) {
			strengthPercentComboBoxActionPerformed(null);
		} else
			strengthUpdateStored(nPreviousStrength, null);
		strengthUpdatePanel(nScore, null);
	}

	/**
	 * load the selected values into the panel spinners
	 * 
	 * @param nScore
	 */
	private void strengthUpdatePanel(int nScore, Strength oSI) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oG = ost.abilityStatList.getContent().get(nScore);
			Strength oS = oG.getStrength();
			if (oSI != null) { // percentile strength
				oS = oSI;
			} else
				strengthScoreSpinner.setValue(oS.score);

			strengthHitBonusSpinner.setValue(oS.hitProbability);
			strengthDamageAdjSpinner.setValue(oS.damageAdjustment);
			strengthWeightAllowanceSpinner.setValue(oS.weightAllowance);
			strengthMinOpenDoor.setValue(oS.minOpenDoor);
			strengthNumDiceOpenLabelSpinner.setValue(oS.numDiceOpenDoor);
			strengthSizeDiceOpenSpinner.setValue(oS.sizeDiceOpenDoor);
			strengthBendBarsSpinner.setValue(oS.bendBars);

			if (nScore == 18) {
				//strengthPercentComboBoxActionPerformed(null);
				strengthPercentComboBox.setEnabled(true);
			} else {
				nPreviousStrengthPercentile = 0;
				strengthPercentComboBox.setEnabled(false);
				strengthPercentComboBox.setSelectedIndex(0);
			}

			nPreviousStrength = nScore;
		}
	}

	/**
	 * get the values last entered and store them
	 * 
	 * @param nScore
	 */
	private void strengthUpdateStored(int nScore, Strength oSI) {
		if (nScore >= 0 && nScore <= MAX_ABILITY_SCORE) {
			AbilityStatClass oG = ost.abilityStatList.getContent().get(nScore);
			Strength oS = oG.getStrength();
			if (oSI != null) { // percentile strength
				oS = oSI;
			} else
				oS.score = nScore;

			oS.hitProbability = (int) strengthHitBonusSpinner.getValue();
			oS.damageAdjustment = (int) strengthDamageAdjSpinner.getValue();
			oS.weightAllowance = (int) strengthWeightAllowanceSpinner
					.getValue();
			oS.minOpenDoor = (int) strengthMinOpenDoor.getValue();
			oS.numDiceOpenDoor = (int) strengthNumDiceOpenLabelSpinner
					.getValue();
			oS.sizeDiceOpenDoor = (int) strengthSizeDiceOpenSpinner.getValue();
			oS.bendBars = (int) strengthBendBarsSpinner.getValue();
		}
	}

	private void strengthPercentComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (strengthPercentComboBox.isEnabled()) {
			int nRange = strengthPercentComboBox.getSelectedIndex();
			strengthUpdateStored(18,
					strengthGetPercentile(nPreviousStrengthPercentile));
			strengthUpdatePanel(18, strengthGetPercentile(nRange));
			nPreviousStrengthPercentile = nRange;
		}
	}

	/**
	 * get the percentile strength object for the selected dropdown index
	 * 
	 * @param nRange
	 * @return
	 * 
	 * ugly but could not come up with a better way to deal with percentile strength
	 * 
	 */
	private Strength strengthGetPercentile(int nRange) {
		Strength oS = null;
		switch (nRange) {
		case 0: // 0 == 18/0%
			oS = ost.abilityStatList.getContent().get(18).strength;
			break;
		case 1: // 1-50
			oS = ost.abilityStatList.getContent().get(18).strength.percentile
					.get(0);
			break;

		case 2: // 52-75
			oS = ost.abilityStatList.getContent().get(18).strength.percentile
					.get(1);
			break;

		case 3: // 76-90
			oS = ost.abilityStatList.getContent().get(18).strength.percentile
					.get(2);
			break;

		case 4: // 91-99
			oS = ost.abilityStatList.getContent().get(18).strength.percentile
					.get(3);

			break;
		case 5: // 100
			oS = ost.abilityStatList.getContent().get(18).strength.percentile
					.get(4);

			break;

		default:
			break;
		}

		return (oS);
	}

	private void strengthRadioButtonItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// deselected this button
		if (!strengthRadioButton.isSelected()) {
			strengthUpdateStored((int) strengthScoreSpinner.getValue(), null);
		}
	}

	private void strengthRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (strengthRadioButton.isSelected()) {
			abilityPanel.removeAll();

			abilityPanel.add(strengthPanel);
			abilityPanel.validate();
			abilityPanel.repaint();
		}
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formWindowClosed(null);
		setVisible(false);
	}

	private void buildAbilityTables() {
		strengthUpdatePanel(0, null);
		intelligenceUpdatePanel(0);

		nPreviousStrength = 0;
		nPreviousIntelligence = 0;
		nPreviousWisdom = 0;
		nPreviousConstitution = 0;
		nPreviousDexterity = 0;
		nPreviousCharisma = 0;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel abilityPanel;
	private javax.swing.ButtonGroup abilitySelectbuttonGroup;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JLabel charismaLoyaltyBaseLabel;
	private javax.swing.JSpinner charismaLoyaltyBaseSpinner;
	private javax.swing.JLabel charismaMaxHenchLabel;
	private javax.swing.JSpinner charismaMaxHenchSpinner;
	private javax.swing.JPanel charismaPanel;
	private javax.swing.JRadioButton charismaRadioButton;
	private javax.swing.JLabel charismaReactionAdjLabel;
	private javax.swing.JSpinner charismaReactionAdjSpinner;
	private javax.swing.JLabel charismaScoreLabel;
	private javax.swing.JSpinner charismaScoreSpinner;
	private javax.swing.JSpinner constitutionHitPointAdjustmentBarbarianSpinner1;
	private javax.swing.JSpinner constitutionHitPointAdjustmentFighterSpinner;
	private javax.swing.JLabel constitutionHitPointAdjustmentLabel;
	private javax.swing.JSpinner constitutionHitPointAdjustmentSpinner;
	private javax.swing.JLabel constitutionHitpointAdjustmentBarbarianLabel;
	private javax.swing.JLabel constitutionHitpointAdjustmentFighterLabel;
	private javax.swing.JLabel constitutionIronLabel;
	private javax.swing.JSpinner constitutionIronSpinner;
	private javax.swing.JPanel constitutionPanel;
	private javax.swing.JRadioButton constitutionRadioButton;
	private javax.swing.JLabel constitutionResistanceLabel;
	private javax.swing.JSpinner constitutionResistanceSpinner;
	private javax.swing.JLabel constitutionResurrectionSurvivelLabel;
	private javax.swing.JSpinner constitutionResurrectionSurvivelSpinner;
	private javax.swing.JLabel constitutionScoreLabel;
	private javax.swing.JSpinner constitutionScoreSpinner;
	private javax.swing.JLabel constitutionSystemShockLabel;
	private javax.swing.JSpinner constitutionSystemShockSpinner;
	private javax.swing.JPanel dexCWPanel22;
	private javax.swing.JSpinner dexCWSpinner;
	private javax.swing.JPanel dexFRTPanel18;
	private javax.swing.JSpinner dexFRTSpinner;
	private javax.swing.JPanel dexHNPanel21;
	private javax.swing.JSpinner dexHNSpinner;
	private javax.swing.JPanel dexHSPanel20;
	private javax.swing.JSpinner dexHSSpinner;
	private javax.swing.JPanel dexMSPanel19;
	private javax.swing.JSpinner dexMSSpinner;
	private javax.swing.JPanel dexOLPanel17;
	private javax.swing.JSpinner dexOLSpinner;
	private javax.swing.JPanel dexPP1Panel16;
	private javax.swing.JSpinner dexPPSpinner;
	private javax.swing.JPanel dexRLPanel23;
	private javax.swing.JSpinner dexRLSpinner;
	private javax.swing.JLabel dexterityAttackAdjustmenLabel;
	private javax.swing.JSpinner dexterityAttackAdjustmentSpinner;
	private javax.swing.JLabel dexterityDefAdjBarbLabel;
	private javax.swing.JSpinner dexterityDefAdjBarbSpinner;
	private javax.swing.JLabel dexterityDefensiveAdjustmentLabel;
	private javax.swing.JSpinner dexterityDefensiveAdjustmentSpinner;
	private javax.swing.JPanel dexterityPanel;
	private javax.swing.JRadioButton dexterityRadioButton;
	private javax.swing.JLabel dexterityReactionAdjustmentLabel;
	private javax.swing.JLabel dexterityScoreLabel;
	private javax.swing.JSpinner dexterityScoreSpinner;
	private javax.swing.JSpinner dexterityreactionAdjustmentSpinner;
	private javax.swing.JButton doneButton;
	private javax.swing.JPanel intSpellBonus1Panel;
	private javax.swing.JPanel intSpellBonus1Panel1;
	private javax.swing.JPanel intSpellBonus1Panel10;
	private javax.swing.JPanel intSpellBonus1Panel11;
	private javax.swing.JPanel intSpellBonus1Panel12;
	private javax.swing.JPanel intSpellBonus1Panel13;
	private javax.swing.JPanel intSpellBonus1Panel14;
	private javax.swing.JPanel intSpellBonus1Panel15;
	private javax.swing.JPanel intSpellBonus1Panel2;
	private javax.swing.JPanel intSpellBonus1Panel3;
	private javax.swing.JPanel intSpellBonus1Panel4;
	private javax.swing.JPanel intSpellBonus1Panel5;
	private javax.swing.JPanel intSpellBonus1Panel6;
	private javax.swing.JPanel intSpellBonus1Panel7;
	private javax.swing.JPanel intSpellBonus1Panel8;
	private javax.swing.JPanel intSpellBonus1Panel9;
	private javax.swing.JSpinner intSpellBonusLevel1Spinner;
	private javax.swing.JSpinner intSpellBonusLevel2Spinner1;
	private javax.swing.JSpinner intSpellBonusLevel3Spinner2;
	private javax.swing.JSpinner intSpellBonusLevel4Spinner3;
	private javax.swing.JSpinner intSpellBonusLevel5Spinner4;
	private javax.swing.JSpinner intSpellBonusLevel6Spinner5;
	private javax.swing.JSpinner intSpellBonusLevel7Spinner6;
	private javax.swing.JSpinner intSpellBonusLevel8Spinner7;
	private javax.swing.JSpinner intSpellBonusLevel9Spinner8;
	private javax.swing.JLabel intelligenceKnowSpellLabel;
	private javax.swing.JSpinner intelligenceKnowSpellSpinner1;
	private javax.swing.JLabel intelligenceLanguagesLabel1;
	private javax.swing.JSpinner intelligenceLanguagesSpinner;
	private javax.swing.JLabel intelligenceMaxSpellsLabel1;
	private javax.swing.JSpinner intelligenceMaxSpellsSpinner1;
	private javax.swing.JLabel intelligenceMinSpellsLabel1;
	private javax.swing.JSpinner intelligenceMinSpellsSpinner1;
	private javax.swing.JPanel intelligencePanel;
	private javax.swing.JRadioButton intelligenceRadioButton;
	private javax.swing.JLabel intelligenceScoreLabel;
	private javax.swing.JSpinner intelligenceScoreSpinner;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel selectPanel;
	private javax.swing.JLabel strengthBendBarsLabel;
	private javax.swing.JSpinner strengthBendBarsSpinner;
	private javax.swing.JLabel strengthDamageAdjLabel;
	private javax.swing.JSpinner strengthDamageAdjSpinner;
	private javax.swing.JLabel strengthHitBonusLabel;
	private javax.swing.JSpinner strengthHitBonusSpinner;
	private javax.swing.JSpinner strengthMinOpenDoor;
	private javax.swing.JLabel strengthMinOpenDoorLabel;
	private javax.swing.JLabel strengthNumDiceOpenLabel;
	private javax.swing.JSpinner strengthNumDiceOpenLabelSpinner;
	private javax.swing.JPanel strengthPanel;
	private javax.swing.JComboBox strengthPercentComboBox;
	private javax.swing.JRadioButton strengthRadioButton;
	private javax.swing.JLabel strengthScoreLabel;
	private javax.swing.JSpinner strengthScoreSpinner;
	private javax.swing.JLabel strengthSizeDiceOpenLabel;
	private javax.swing.JSpinner strengthSizeDiceOpenSpinner;
	private javax.swing.JLabel strengthWeightAllowanceLabel;
	private javax.swing.JSpinner strengthWeightAllowanceSpinner;
	private javax.swing.JSpinner wisSpellBonusLevel1Spinner1;
	private javax.swing.JSpinner wisSpellBonusLevel2Spinner2;
	private javax.swing.JSpinner wisSpellBonusLevel3Spinner3;
	private javax.swing.JSpinner wisSpellBonusLevel4Spinner4;
	private javax.swing.JSpinner wisSpellBonusLevel5Spinner5;
	private javax.swing.JSpinner wisSpellBonusLevel6Spinner6;
	private javax.swing.JSpinner wisSpellBonusLevel7Spinner7;
	private javax.swing.JLabel wisdomMagicAdjLabel;
	private javax.swing.JSpinner wisdomMagicAdjustSpinner;
	private javax.swing.JPanel wisdomPanel;
	private javax.swing.JRadioButton wisdomRadioButton;
	private javax.swing.JLabel wisdomScoreLabel1;
	private javax.swing.JSpinner wisdomScoreSpinner1;
	private javax.swing.JLabel wisdomSpellFailureLabel;
	private javax.swing.JSpinner wisdomSpellFailureSpinner;
	// End of variables declaration//GEN-END:variables

	private int nPreviousStrength;
	private int nPreviousStrengthPercentile;
	private int nPreviousIntelligence;
	private int nPreviousWisdom;
	private int nPreviousConstitution;
	private int nPreviousDexterity;
	private int nPreviousCharisma;

}