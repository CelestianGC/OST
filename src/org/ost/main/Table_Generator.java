/*
 * Table_Generator.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.TableClass;
import org.ost.main.MyClasses.TableRewardClass;
import org.ost.main.MyClasses.TreasureTableClass;
import org.ost.main.MyUtils.MyRandomClass;

/**
 *
 * @author  __USER__
 */
public class Table_Generator extends javax.swing.JPanel {

	/** Creates new form Table_Generator */
	public Table_Generator(MainClass ost, String sGeneratorType) {
		this.ost = ost;
		initComponents();
		myType = sGeneratorType.toUpperCase();
		myTitleBorder = (TitledBorder) mainPanel.getBorder();
		myTitleBorder.setTitle(String.format("%s", sGeneratorType));
		ost.generatorList.add(this);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		descriptionTextArea = new javax.swing.JTextArea();
		jSplitPane1 = new javax.swing.JSplitPane();
		tableDescriptionScrollPanel = new javax.swing.JScrollPane();
		tableDescriptionPanel = new javax.swing.JPanel();
		generatedOutputScrollPane = new javax.swing.JScrollPane();
		generatedOutputTextArea = new javax.swing.JTextArea();
		jPanel1 = new javax.swing.JPanel();
		tableGenerateButton = new javax.swing.JButton();
		tableGenerateCountSpinner = new javax.swing.JSpinner();
		tableSelectComboBox = new javax.swing.JComboBox();
		tableAppendCheckBox = new javax.swing.JCheckBox();
		tableClearButton = new javax.swing.JButton();

		setFont(new java.awt.Font("Segoe UI", 0, 10));

		mainPanel.setBackground(new java.awt.Color(204, 204, 204));
		mainPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						javax.swing.BorderFactory
								.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
						"Generator Table"));
		mainPanel.setLayout(new java.awt.BorderLayout());

		jPanel2.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.setLayout(new java.awt.BorderLayout());

		jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
		jScrollPane1.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		descriptionTextArea.setBackground(new java.awt.Color(204, 204, 204));
		descriptionTextArea.setColumns(20);
		descriptionTextArea.setEditable(false);
		descriptionTextArea.setFont(new java.awt.Font("Segoe UI", 0, 10));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setRows(5);
		descriptionTextArea.setWrapStyleWord(true);
		jScrollPane1.setViewportView(descriptionTextArea);

		jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		mainPanel.add(jPanel2, java.awt.BorderLayout.PAGE_END);

		jSplitPane1.setDividerLocation(150);
		jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		jSplitPane1.setContinuousLayout(true);
		jSplitPane1.setOneTouchExpandable(true);

		tableDescriptionScrollPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Details",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));

		tableDescriptionPanel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tableDescriptionPanel.setLayout(new java.awt.GridLayout(0, 1));
		tableDescriptionScrollPanel.setViewportView(tableDescriptionPanel);

		jSplitPane1.setLeftComponent(tableDescriptionScrollPanel);

		generatedOutputScrollPane.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Results",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));

		generatedOutputTextArea
				.setBackground(new java.awt.Color(240, 240, 240));
		generatedOutputTextArea.setColumns(20);
		generatedOutputTextArea.setEditable(false);
		generatedOutputTextArea.setLineWrap(true);
		generatedOutputTextArea.setRows(5);
		generatedOutputTextArea.setWrapStyleWord(true);
		generatedOutputScrollPane.setViewportView(generatedOutputTextArea);

		jSplitPane1.setRightComponent(generatedOutputScrollPane);

		mainPanel.add(jSplitPane1, java.awt.BorderLayout.CENTER);

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));
		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		tableGenerateButton.setBackground(new java.awt.Color(204, 204, 204));
		tableGenerateButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tableGenerateButton.setText("generate");
		tableGenerateButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						tableGenerateButtonActionPerformed(evt);
					}
				});
		jPanel1.add(tableGenerateButton);

		tableGenerateCountSpinner.setModel(new javax.swing.SpinnerNumberModel(
				1, 1, 100, 1));
		jPanel1.add(tableGenerateCountSpinner);

		tableSelectComboBox.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tableSelectComboBox.setModel(getTableListForComboBox());
		tableSelectComboBox.setMinimumSize(new java.awt.Dimension(150, 25));
		tableSelectComboBox.setPreferredSize(new java.awt.Dimension(300, 27));
		tableSelectComboBox.setRenderer(new MyCellRendererList());
		tableSelectComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						tableSelectComboBoxActionPerformed(evt);
					}
				});
		jPanel1.add(tableSelectComboBox);
		if (tableSelectComboBox.getItemCount() > 0)
			tableSelectComboBox.setSelectedIndex(0);

		tableAppendCheckBox.setBackground(new java.awt.Color(204, 204, 204));
		tableAppendCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 8));
		tableAppendCheckBox.setText("append");
		tableAppendCheckBox.setToolTipText("Append all generated results.");
		jPanel1.add(tableAppendCheckBox);

		tableClearButton.setBackground(new java.awt.Color(204, 204, 204));
		tableClearButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tableClearButton.setText("clear");
		tableClearButton.setToolTipText("Clear details panel.");
		tableClearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tableClearButtonActionPerformed(evt);
			}
		});
		jPanel1.add(tableClearButton);

		mainPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(mainPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addGap(0, 0, 0)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void tableClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		generatedOutputTextArea.setText("");
	}

	private void tableGenerateButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int iCount = Integer.parseInt(tableGenerateCountSpinner.getValue()
				.toString().trim());
		currentTable = (TableClass) tableSelectComboBox.getSelectedItem();
		MyRandomClass oR = new MyRandomClass(1, currentTable.getHighestRoll());
		for (int i = 0; i < iCount; i++)
			currentTable.getAllRewards(ost.rewardList, ost.tableList.getContent(),
					oR.rollRandomDice(), null, false);
		if (!tableAppendCheckBox.isSelected())
			generatedOutputTextArea.setText("");
		String generatedResult = String.format("Result:\n%s\n",
				TableRewardClass.getRewardOutput(ost.rewardList));
		generatedOutputTextArea.append(generatedResult);
	}

	private void tableSelectComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tableDescriptionPanel.removeAll();
		boolean changeColor = true;
		TableClass oT = (TableClass) tableSelectComboBox.getSelectedItem();
		if (oT != null)
			for (TreasureTableClass tT : oT.getTreasureEntry()) {
				Table_Generator_Details tDets = new Table_Generator_Details();
				String sDice = String.format("%d-%d", tT.getLowDice(),
						tT.getHighDice());
				changeColor = (!changeColor);
				if (changeColor) {
					tDets.setBackground(new Color(153, 153, 153));
					tDets.subPanel.setBackground(new Color(153, 153, 153));
				}
				tDets.diceLabel.setText(sDice);
				tDets.nameLabel.setText(tT.getName());
				descriptionTextArea.setText(oT.getDescription());
				descriptionTextArea.setToolTipText(oT.getDescription());
				String sRef = tT.getReferToTable().isEmpty() ? "" : "["
						+ tT.getReferToTable() + "]";
				tDets.referToLabel.setText(sRef);
				tableDescriptionPanel.add(tDets);
			}// end for
		tableDescriptionPanel.revalidate();

	}

	/**
	 * return model for tablelist combobox
	 * 
	 * @return
	 */
	DefaultComboBoxModel getTableListForComboBox() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		Collections.sort(ost.tableList.getContent());
		for (TableClass oT : ost.tableList.getContent())
			if (oT.getType().equalsIgnoreCase(myType))
				model.addElement(oT);

		//tableSelectComboBox.setSelectedIndex(0);
		currentTable = (TableClass) tableSelectComboBox.getSelectedItem();
		return (model);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea descriptionTextArea;
	private javax.swing.JScrollPane generatedOutputScrollPane;
	private javax.swing.JTextArea generatedOutputTextArea;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JCheckBox tableAppendCheckBox;
	private javax.swing.JButton tableClearButton;
	private javax.swing.JPanel tableDescriptionPanel;
	private javax.swing.JScrollPane tableDescriptionScrollPanel;
	private javax.swing.JButton tableGenerateButton;
	private javax.swing.JSpinner tableGenerateCountSpinner;
	public javax.swing.JComboBox tableSelectComboBox;
	// End of variables declaration//GEN-END:variables
	private MainClass ost;
	private TableClass currentTable;
	private TitledBorder myTitleBorder;
	public String myType;
}