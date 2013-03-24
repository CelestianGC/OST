/*
 * Dice_Tab.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import javax.swing.text.NumberFormatter;

import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;

/**
 *
 * @author  __USER__
 */
public class Dice_Tab extends javax.swing.JPanel {

	/** Creates new form Dice_Tab */
	public Dice_Tab(MainClass ost) {
		initComponents();
		this.ost = ost;
		diceReset(new MyRandomClass(1, 6));
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		diceTextArea = new javax.swing.JTextArea();
		jPanel6 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		diceD20Icon = new javax.swing.JLabel();
		diceD12Icon = new javax.swing.JLabel();
		diceD10Icon = new javax.swing.JLabel();
		diceD8Icon = new javax.swing.JLabel();
		diceD6Icon = new javax.swing.JLabel();
		diceD4Icon = new javax.swing.JLabel();
		diceD2Icon = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		numberFormat = new NumberFormatter();
		numberFormat.setMinimum(new Integer(1));
		numberFormat.setAllowsInvalid(false);

		diceCountFormattedTextField = new javax.swing.JFormattedTextField(
				numberFormat);
		jLabel1 = new javax.swing.JLabel();
		diceFacesFormattedTextField = new javax.swing.JFormattedTextField(
				numberFormat);
		jLabel2 = new javax.swing.JLabel();
		diceModFormattedTextField = new javax.swing.JFormattedTextField();
		dicePerDiceModCheckBox = new javax.swing.JCheckBox();
		diceExplodingDiceCheckBox = new javax.swing.JCheckBox();
		diceVerboseCheckBox = new javax.swing.JCheckBox();
		appendCheckBox = new javax.swing.JCheckBox();
		jPanel5 = new javax.swing.JPanel();
		diceRollButton = new javax.swing.JButton();
		diceResetButton = new javax.swing.JButton();
		clearDiceButton = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		diceStringLabel = new javax.swing.JLabel();
		diceParseTextField = new javax.swing.JTextField();
		processButton = new javax.swing.JButton();

		setLayout(new java.awt.BorderLayout());

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						3, true), "Dice"));
		jPanel1.setLayout(new java.awt.BorderLayout());

		diceTextArea.setBackground(new java.awt.Color(153, 153, 153));
		diceTextArea.setColumns(20);
		diceTextArea.setLineWrap(true);
		diceTextArea.setRows(5);
		jScrollPane1.setViewportView(diceTextArea);

		jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jPanel6.setBackground(new java.awt.Color(204, 204, 204));
		jPanel6.setLayout(new java.awt.GridBagLayout());

		jPanel2.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,
				20, 5));

		diceD20Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d20-icon.png"))); // NOI18N
		diceD20Icon.setToolTipText("Roll d20.");
		diceD20Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD20IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD20Icon);

		diceD12Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d12-icon.png"))); // NOI18N
		diceD12Icon.setToolTipText("Roll d12.");
		diceD12Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD12IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD12Icon);

		diceD10Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d10-icon.png"))); // NOI18N
		diceD10Icon.setToolTipText("Roll d10.");
		diceD10Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD10IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD10Icon);

		diceD8Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d8-icon.png"))); // NOI18N
		diceD8Icon.setToolTipText("Roll d8.");
		diceD8Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD8IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD8Icon);

		diceD6Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d6-icon.png"))); // NOI18N
		diceD6Icon.setToolTipText("Roll d6.");
		diceD6Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD6IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD6Icon);

		diceD4Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/d4-icon.png"))); // NOI18N
		diceD4Icon.setToolTipText("Roll d4.");
		diceD4Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD4IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD4Icon);

		diceD2Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Coin-icon.png"))); // NOI18N
		diceD2Icon.setToolTipText("Flip a coin, 2 sided dice.");
		diceD2Icon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				diceD2IconMousePressed(evt);
			}
		});
		jPanel2.add(diceD2Icon);

		jPanel6.add(jPanel2, new java.awt.GridBagConstraints());

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel3.setText("Customize");
		jLabel3.setToolTipText("Customize dice rolls. d1000? No problem.");
		jPanel3.add(jLabel3);

		diceCountFormattedTextField.setText("1");
		diceCountFormattedTextField.setToolTipText("Number of dice to roll.");
		diceCountFormattedTextField.setMinimumSize(new java.awt.Dimension(35,
				22));
		diceCountFormattedTextField.setPreferredSize(new java.awt.Dimension(35,
				22));
		jPanel3.add(diceCountFormattedTextField);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel1.setText("D");
		jPanel3.add(jLabel1);

		diceFacesFormattedTextField.setText("6");
		diceFacesFormattedTextField
				.setToolTipText("Number of dice faces. Such as on a d12 the number of faces is 12.");
		diceFacesFormattedTextField.setMinimumSize(new java.awt.Dimension(35,
				22));
		diceFacesFormattedTextField.setPreferredSize(new java.awt.Dimension(35,
				22));
		jPanel3.add(diceFacesFormattedTextField);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel2.setText("+/-");
		jLabel2.setToolTipText("Modification ro dice roll. Such as +3 or -2.");
		jPanel3.add(jLabel2);

		diceModFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								java.text.NumberFormat.getIntegerInstance())));
		diceModFormattedTextField.setText("0");
		diceModFormattedTextField
				.setToolTipText("Modification to dice roll. Such as +3 or -2");
		diceModFormattedTextField
				.setMinimumSize(new java.awt.Dimension(35, 22));
		diceModFormattedTextField.setPreferredSize(new java.awt.Dimension(35,
				22));
		jPanel3.add(diceModFormattedTextField);

		dicePerDiceModCheckBox.setBackground(new java.awt.Color(204, 204, 204));
		dicePerDiceModCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dicePerDiceModCheckBox.setText("Per-Dice");
		dicePerDiceModCheckBox.setToolTipText("Modifier is per dice rolled.");
		jPanel3.add(dicePerDiceModCheckBox);

		diceExplodingDiceCheckBox.setBackground(new java.awt.Color(204, 204,
				204));
		diceExplodingDiceCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceExplodingDiceCheckBox.setText("Exploding");
		diceExplodingDiceCheckBox
				.setToolTipText("When max dice rolled, re-roll dice and add another to roll.");
		jPanel3.add(diceExplodingDiceCheckBox);

		diceVerboseCheckBox.setBackground(new java.awt.Color(204, 204, 204));
		diceVerboseCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceVerboseCheckBox.setText("Verbose");
		diceVerboseCheckBox
				.setToolTipText("Output more details on dice rolls.");
		jPanel3.add(diceVerboseCheckBox);

		appendCheckBox.setBackground(new java.awt.Color(204, 204, 204));
		appendCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 10));
		appendCheckBox.setSelected(true);
		appendCheckBox.setText("Continuous");
		appendCheckBox.setToolTipText("Append dice rolls to panel.");
		jPanel3.add(appendCheckBox);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		jPanel6.add(jPanel3, gridBagConstraints);

		jPanel5.setBackground(new java.awt.Color(204, 204, 204));

		diceRollButton.setBackground(new java.awt.Color(204, 204, 204));
		diceRollButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceRollButton.setText("Roll!");
		diceRollButton.setToolTipText("Roll the dice option currently set.");
		diceRollButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diceRollButtonActionPerformed(evt);
			}
		});
		jPanel5.add(diceRollButton);

		diceResetButton.setBackground(new java.awt.Color(204, 204, 204));
		diceResetButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceResetButton.setText("Reset");
		diceResetButton.setToolTipText("Reset dice customizations to default.");
		diceResetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diceResetButtonActionPerformed(evt);
			}
		});
		jPanel5.add(diceResetButton);

		clearDiceButton.setBackground(new java.awt.Color(204, 204, 204));
		clearDiceButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		clearDiceButton.setText("Clear");
		clearDiceButton.setToolTipText("Scrub the dice output.");
		clearDiceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearDiceButtonActionPerformed(evt);
			}
		});
		jPanel5.add(clearDiceButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		jPanel6.add(jPanel5, gridBagConstraints);

		jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_START);

		add(jPanel1, java.awt.BorderLayout.CENTER);

		jPanel4.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4,
				javax.swing.BoxLayout.LINE_AXIS));

		diceStringLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceStringLabel.setText("Dice String ");
		diceStringLabel.setToolTipText("Parsed rolls in whatever you type.");
		jPanel4.add(diceStringLabel);

		diceParseTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		diceParseTextField.setText("Attack roll 1d20 and 1d6+3 damage.");
		diceParseTextField.setPreferredSize(new java.awt.Dimension(60, 27));
		diceParseTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						diceParseTextFieldActionPerformed(evt);
					}
				});
		jPanel4.add(diceParseTextField);

		processButton.setBackground(new java.awt.Color(204, 204, 204));
		processButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		processButton.setText("process");
		processButton.setToolTipText("Process the dice string");
		processButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				processButtonActionPerformed(evt);
			}
		});
		jPanel4.add(processButton);

		add(jPanel4, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>
	//GEN-END:initComponents

	private void clearDiceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		diceTextArea.setText("");
	}

	private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		doDiceParseTextLine();
	}

	private void diceParseTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		doDiceParseTextLine();
	}

	private void doDiceParseTextLine() {
		String sParsedTXT = MyParse.parseDice(diceParseTextField.getText());
		if (!appendCheckBox.isSelected())
			diceTextArea.setText("");
		diceTextArea.append(sParsedTXT + "\n");

	}

	private void diceResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		diceResetToDefault();
	}

	/**
	 * reset dice/checks/etc to default
	 */
	private void diceResetToDefault() {
		MyRandomClass oRand = new MyRandomClass(1, 6);
		diceReset(oRand);
	}

	/**
	 * set dice fields to current value
	 * 
	 * @param oR
	 */
	private void diceReset(MyRandomClass oR) {
		diceCountFormattedTextField.setValue(oR.getDiceNumber());
		diceFacesFormattedTextField.setValue(oR.getDiceFaces());
		diceModFormattedTextField.setValue(oR.getDiceMod());
		//		diceExplodingDiceCheckBox.setSelected(false);
		//		dicePerDiceModCheckBox.setSelected(false);
		//		diceVerboseCheckBox.setSelected(false);
	}

	private void diceD2IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(2);
		rollDemBones(oRand);
	}

	private void diceD4IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(4);
		rollDemBones(oRand);
	}

	private void diceD6IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(6);
		rollDemBones(oRand);
	}

	private void diceD8IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(8);
		rollDemBones(oRand);
	}

	private void diceD10IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(10);
		rollDemBones(oRand);
	}

	private void diceD12IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(12);
		rollDemBones(oRand);
	}

	private void diceRollButtonActionPerformed(java.awt.event.ActionEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(Integer.parseInt(diceCountFormattedTextField
				.getValue().toString().trim()));
		oRand.setDiceFaces(Integer.parseInt(diceFacesFormattedTextField
				.getValue().toString().trim()));
		oRand.setDiceMod(Integer.parseInt(diceModFormattedTextField.getValue()
				.toString().trim()));
		rollDemBones(oRand);

	}

	private void diceD20IconMousePressed(java.awt.event.MouseEvent evt) {
		MyRandomClass oRand = new MyRandomClass(1, 1);
		oRand.setDiceNumber(1);
		oRand.setDiceFaces(20);
		rollDemBones(oRand);
	}

	/**
	 * Roll the dice selected.
	 * 
	 * @param oR
	 */
	private void rollDemBones(MyRandomClass oR) {
		oR.setExplodeDice(diceExplodingDiceCheckBox.isSelected());
		oR.setPerDice(dicePerDiceModCheckBox.isSelected());
		oR.setDiceMod(Integer.parseInt(diceModFormattedTextField.getValue()
				.toString().trim()));

		int diceResult = oR.rollRandomDice();
		String str = String
				.format("Rolled %dd%d:%s%d", oR.getDiceNumber(), oR
						.getDiceFaces(), diceVerboseCheckBox.isSelected() ? "("
						+ oR.getLog() + ")" : "", diceResult);

		diceReset(oR);

		diceTextArea.append(str + "\n");

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JCheckBox appendCheckBox;
	private javax.swing.JButton clearDiceButton;
	private javax.swing.JFormattedTextField diceCountFormattedTextField;
	private javax.swing.JLabel diceD10Icon;
	private javax.swing.JLabel diceD12Icon;
	private javax.swing.JLabel diceD20Icon;
	private javax.swing.JLabel diceD2Icon;
	private javax.swing.JLabel diceD4Icon;
	private javax.swing.JLabel diceD6Icon;
	private javax.swing.JLabel diceD8Icon;
	private javax.swing.JCheckBox diceExplodingDiceCheckBox;
	private javax.swing.JFormattedTextField diceFacesFormattedTextField;
	private javax.swing.JFormattedTextField diceModFormattedTextField;
	private javax.swing.JTextField diceParseTextField;
	private javax.swing.JCheckBox dicePerDiceModCheckBox;
	private javax.swing.JButton diceResetButton;
	private javax.swing.JButton diceRollButton;
	private javax.swing.JLabel diceStringLabel;
	private javax.swing.JTextArea diceTextArea;
	private javax.swing.JCheckBox diceVerboseCheckBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton processButton;
	// End of variables declaration//GEN-END:variables

	private MainClass ost;
	private NumberFormatter numberFormat;

}