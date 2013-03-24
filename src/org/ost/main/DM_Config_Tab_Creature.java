/*
 * DM_Config_Tab_Creature.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import static org.ost.main.MyClasses.MyStatics.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.jdom.Document;
import org.ost.main.MyClasses.ChartClass;
import org.ost.main.MyClasses.ChartColumn;
import org.ost.main.MyClasses.CreatureAttackClass;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.XMLControl;

import java.util.regex.*;

/**
 *
 * @author  __USER__
 */
public class DM_Config_Tab_Creature extends javax.swing.JPanel {
	public MainClass ost;

	/** Creates new form DM_Config_Tab_Creature */
	public DM_Config_Tab_Creature(MainClass ost) {
		initComponents();
		this.ost = ost;
		currentCreature = null;
		updateCreatureList(null);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;
		bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

		importDialog = new javax.swing.JDialog();
		jScrollPane3 = new javax.swing.JScrollPane();
		importTextArea = new javax.swing.JTextArea();
		jPanel1 = new javax.swing.JPanel();
		importOSTRadioButton = new javax.swing.JRadioButton();
		importTXTRadioButton = new javax.swing.JRadioButton();
		importOSRICRadioButton = new javax.swing.JRadioButton();
		importCopyFromClipBoardButton = new javax.swing.JButton();
		importDoneButton = new javax.swing.JButton();
		importCancelButton = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		importLogDialog = new javax.swing.JDialog();
		jScrollPane5 = new javax.swing.JScrollPane();
		importLogTextArea = new javax.swing.JTextArea();
		jPanel4 = new javax.swing.JPanel();
		importCloseLogButton = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		importButtonGroup = new javax.swing.ButtonGroup();
		importButtonGroup.add(importOSTRadioButton);
		importButtonGroup.add(importTXTRadioButton);
		importButtonGroup.add(importOSRICRadioButton);
		exportDialog = new javax.swing.JDialog();
		jPanel6 = new javax.swing.JPanel();
		jLabel20 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		exportTextArea = new javax.swing.JTextArea();
		jPanel7 = new javax.swing.JPanel();
		exportCopyToClipBoardButton = new javax.swing.JButton();
		exportDoneButton = new javax.swing.JButton();
		creatureHitpointGenerationRadioGroup = new javax.swing.ButtonGroup();
		beastarySplitPane = new javax.swing.JSplitPane();
		mainPanel = new javax.swing.JPanel();
		simpleFieldsPanel = new javax.swing.JPanel();
		nameLabel = new javax.swing.JLabel();
		nameField = new javax.swing.JTextField();
		nameLabel5 = new javax.swing.JLabel();
		frequencyField = new javax.swing.JTextField();
		nameLabel4 = new javax.swing.JLabel();
		encounterSizeField = new javax.swing.JTextField();
		nameLabel9 = new javax.swing.JLabel();
		moveField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		hdField = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		levelField = new javax.swing.JTextField();
		nameLabel15 = new javax.swing.JLabel();
		acField = new javax.swing.JTextField();
		nameLabel10 = new javax.swing.JLabel();
		sizeField = new javax.swing.JTextField();
		jLabelx6 = new javax.swing.JLabel();
		numAttacksField = new javax.swing.JTextField();
		jLabelx2 = new javax.swing.JLabel();
		damageField = new javax.swing.JTextField();
		nameLabel7 = new javax.swing.JLabel();
		intelligenceField = new javax.swing.JTextField();
		nameLabel8 = new javax.swing.JLabel();
		magicresistanceField = new javax.swing.JTextField();
		nameLabel11 = new javax.swing.JLabel();
		specialAttackField = new javax.swing.JTextField();
		nameLabel12 = new javax.swing.JLabel();
		specialDefenseField = new javax.swing.JTextField();
		nameLabel1 = new javax.swing.JLabel();
		alignmentField = new javax.swing.JTextField();
		nameLabel13 = new javax.swing.JLabel();
		treasureField = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		typeTextField = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		climateTextField = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		activityTextField = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		terrainTextField = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		dietTextField = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		inLairTextField = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		moraleTextField = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		psionicAbilityTextField = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		organizationTextField = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		psionicModesTextField = new javax.swing.JTextField();
		nameLabel2 = new javax.swing.JLabel();
		baseXPField = new javax.swing.JTextField();
		nameLabel14 = new javax.swing.JLabel();
		xpPerHPField = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		thacoTextField = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		sourceTextField = new javax.swing.JTextField();
		descriptionPanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		descriptionField = new javax.swing.JTextArea();
		buttonsPanel = new javax.swing.JPanel();
		jLabel18 = new javax.swing.JLabel();
		modelEncounterSpinner = new SpinnerNumberModel(new Integer(1),
				new Integer(1), new Integer(20), new Integer(1));
		encounterAddSpinner = new javax.swing.JSpinner(modelEncounterSpinner);
		addEncounterButton = new javax.swing.JButton();
		creatureHPGenMAXRadioButton = new javax.swing.JRadioButton();
		creatureHPGen80PercentRadioButton = new javax.swing.JRadioButton();
		creatureHPGenAverageRadioButton = new javax.swing.JRadioButton();
		creatureHPGenNormalRadioButton = new javax.swing.JRadioButton();
		listCreaturePanel = new javax.swing.JPanel();
		jPanel10 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		creatureSearchTextField = new javax.swing.JTextField();
		jPanel17 = new javax.swing.JPanel();
		newButton = new javax.swing.JButton();
		creatureCopyButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		modelListCreature = new DefaultListModel();
		listCreatureList = new javax.swing.JList(modelListCreature);
		listCreatureList.setCellRenderer(new MyCellRendererList());
		jPanel8 = new javax.swing.JPanel();
		importButton = new javax.swing.JButton();
		exportButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();

		importDialog.setTitle("Import Creature from OSRIC");
		importDialog.setMinimumSize(new java.awt.Dimension(574, 400));

		importTextArea.setColumns(20);
		importTextArea.setLineWrap(true);
		importTextArea.setRows(5);
		importTextArea.setWrapStyleWord(true);
		jScrollPane3.setViewportView(importTextArea);

		importDialog.getContentPane().add(jScrollPane3,
				java.awt.BorderLayout.CENTER);

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));
		jPanel1.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		importOSTRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		importOSTRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importOSTRadioButton.setSelected(true);
		importOSTRadioButton.setText("OST");
		importOSTRadioButton.setToolTipText("Import OST Exported creature.");
		jPanel1.add(importOSTRadioButton);

		importTXTRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		importTXTRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importTXTRadioButton.setText("EXCEL/TXT");
		importTXTRadioButton
				.setToolTipText("Import text from Excel document, 30 fields<tab> delimited.  See readme for details.");
		jPanel1.add(importTXTRadioButton);

		importOSRICRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		importOSRICRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importOSRICRadioButton.setText("OSRIC");
		importOSRICRadioButton
				.setToolTipText("Import using copied creature from OSRIC PDF (tested with 2.2).");
		jPanel1.add(importOSRICRadioButton);

		importCopyFromClipBoardButton.setBackground(new java.awt.Color(204,
				204, 204));
		importCopyFromClipBoardButton.setFont(new java.awt.Font("Segoe UI", 0,
				10));
		importCopyFromClipBoardButton.setText("paste from clipboard");
		importCopyFromClipBoardButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						importCopyFromClipBoardButtonActionPerformed(evt);
					}
				});
		jPanel1.add(importCopyFromClipBoardButton);

		importDoneButton.setBackground(new java.awt.Color(204, 204, 204));
		importDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importDoneButton.setText("import");
		importDoneButton.setToolTipText("Import data.");
		importDoneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importDoneButtonActionPerformed(evt);
			}
		});
		jPanel1.add(importDoneButton);

		importCancelButton.setBackground(new java.awt.Color(204, 204, 204));
		importCancelButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importCancelButton.setText("cancel");
		importCancelButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						importCancelButtonActionPerformed(evt);
					}
				});
		jPanel1.add(importCancelButton);

		importDialog.getContentPane().add(jPanel1,
				java.awt.BorderLayout.PAGE_END);

		jPanel2.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15));
		jLabel3.setText("Import from OSRIC PDF, EXCEL Style Text or from OST.");
		jPanel2.add(jLabel3);

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.add(jPanel3);

		importDialog.getContentPane().add(jPanel2,
				java.awt.BorderLayout.PAGE_START);

		importLogDialog.setMinimumSize(new java.awt.Dimension(600, 500));

		importLogTextArea.setColumns(20);
		importLogTextArea.setRows(5);
		importLogTextArea.setName("Text Import Log");
		jScrollPane5.setViewportView(importLogTextArea);

		importLogDialog.getContentPane().add(jScrollPane5,
				java.awt.BorderLayout.CENTER);

		jPanel4.setBackground(new java.awt.Color(204, 204, 204));

		importCloseLogButton.setBackground(new java.awt.Color(204, 204, 204));
		importCloseLogButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importCloseLogButton.setText("close");
		importCloseLogButton.setToolTipText("Close log window.");
		importCloseLogButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						importCloseLogButtonActionPerformed(evt);
					}
				});
		jPanel4.add(importCloseLogButton);

		importLogDialog.getContentPane().add(jPanel4,
				java.awt.BorderLayout.PAGE_END);

		jPanel5.setBackground(new java.awt.Color(204, 204, 204));

		jLabel5.setText("Import");
		jPanel5.add(jLabel5);

		jLabel19.setText("Log");
		jPanel5.add(jLabel19);

		importLogDialog.getContentPane().add(jPanel5,
				java.awt.BorderLayout.PAGE_START);

		org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings
				.createAutoBinding(
						org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
						importOSTRadioButton,
						org.jdesktop.beansbinding.ObjectProperty.create(),
						importButtonGroup,
						org.jdesktop.beansbinding.BeanProperty
								.create("selection"));
		bindingGroup.addBinding(binding);

		exportDialog.setTitle("Export Creature");
		exportDialog.setMinimumSize(new java.awt.Dimension(400, 300));

		jPanel6.setBackground(new java.awt.Color(204, 204, 204));
		jPanel6.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15));
		jLabel20.setText("Copy text below to export.");
		jLabel20.setToolTipText("Control-C after selecting text to copy.");
		jPanel6.add(jLabel20);

		exportDialog.getContentPane().add(jPanel6,
				java.awt.BorderLayout.PAGE_START);

		jScrollPane4.setBackground(new java.awt.Color(200, 200, 200));
		jScrollPane4.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));

		exportTextArea.setColumns(20);
		exportTextArea.setEditable(false);
		exportTextArea.setLineWrap(true);
		exportTextArea.setRows(5);
		exportTextArea.setWrapStyleWord(true);
		jScrollPane4.setViewportView(exportTextArea);

		exportDialog.getContentPane().add(jScrollPane4,
				java.awt.BorderLayout.CENTER);

		jPanel7.setBackground(new java.awt.Color(204, 204, 204));
		jPanel7.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		exportCopyToClipBoardButton.setBackground(new java.awt.Color(204, 204,
				204));
		exportCopyToClipBoardButton
				.setFont(new java.awt.Font("Segoe UI", 0, 10));
		exportCopyToClipBoardButton.setText("copy to clipboard");
		exportCopyToClipBoardButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						exportCopyToClipBoardButtonActionPerformed(evt);
					}
				});
		jPanel7.add(exportCopyToClipBoardButton);

		exportDoneButton.setBackground(new java.awt.Color(204, 204, 204));
		exportDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		exportDoneButton.setText("done");
		exportDoneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exportDoneButtonActionPerformed(evt);
			}
		});
		jPanel7.add(exportDoneButton);

		exportDialog.getContentPane().add(jPanel7,
				java.awt.BorderLayout.PAGE_END);

		setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 3, true));
		setName("Creature-Tab");
		setLayout(new java.awt.BorderLayout());

		beastarySplitPane.setDividerLocation(250);
		beastarySplitPane.setLastDividerLocation(300);

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		mainPanel.setName("Creature-Tab-Main-Panel");

		simpleFieldsPanel.setBackground(new java.awt.Color(204, 204, 204));
		simpleFieldsPanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		simpleFieldsPanel.setLayout(new java.awt.GridLayout(0, 4));

		nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel.setText("Name  ");
		simpleFieldsPanel.add(nameLabel);

		nameField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameField.setText("Critter");
		simpleFieldsPanel.add(nameField);

		nameLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel5.setText("Frequency");
		simpleFieldsPanel.add(nameLabel5);

		frequencyField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		frequencyField.setText("Common");
		simpleFieldsPanel.add(frequencyField);

		nameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel4.setText("Encounter Count");
		simpleFieldsPanel.add(nameLabel4);

		encounterSizeField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		encounterSizeField.setText("1d4");
		simpleFieldsPanel.add(encounterSizeField);

		nameLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel9.setText("Move Rate  ");
		simpleFieldsPanel.add(nameLabel9);

		moveField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		moveField.setText("9");
		simpleFieldsPanel.add(moveField);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel1.setText("HitDice(HD)");
		simpleFieldsPanel.add(jLabel1);

		hdField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		hdField.setText("1");
		simpleFieldsPanel.add(hdField);

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel7.setText("Level");
		simpleFieldsPanel.add(jLabel7);

		levelField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		levelField.setText("1");
		simpleFieldsPanel.add(levelField);

		nameLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel15.setText("Armor Class  ");
		simpleFieldsPanel.add(nameLabel15);

		acField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		acField.setText("8");
		simpleFieldsPanel.add(acField);

		nameLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel10.setText("Size  ");
		simpleFieldsPanel.add(nameLabel10);

		sizeField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		sizeField.setText("Medium");
		simpleFieldsPanel.add(sizeField);

		jLabelx6.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabelx6.setText("Attacks");
		simpleFieldsPanel.add(jLabelx6);

		numAttacksField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		numAttacksField.setText("1");
		simpleFieldsPanel.add(numAttacksField);

		jLabelx2.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabelx2.setText("Damage");
		simpleFieldsPanel.add(jLabelx2);

		damageField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		damageField.setText("1d4");
		simpleFieldsPanel.add(damageField);

		nameLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel7.setText("Intelligence");
		simpleFieldsPanel.add(nameLabel7);

		intelligenceField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		intelligenceField.setText("Low");
		simpleFieldsPanel.add(intelligenceField);

		nameLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel8.setText("Magic Resistance  ");
		simpleFieldsPanel.add(nameLabel8);

		magicresistanceField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		magicresistanceField.setText("Normal");
		simpleFieldsPanel.add(magicresistanceField);

		nameLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel11.setText("Special Attack  ");
		simpleFieldsPanel.add(nameLabel11);

		specialAttackField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialAttackField.setText("NA");
		simpleFieldsPanel.add(specialAttackField);

		nameLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel12.setText("Special Defense  ");
		simpleFieldsPanel.add(nameLabel12);

		specialDefenseField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		specialDefenseField.setText("NA");
		simpleFieldsPanel.add(specialDefenseField);

		nameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel1.setText("Alignment  ");
		simpleFieldsPanel.add(nameLabel1);

		alignmentField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		alignmentField.setText("Chaotic Evil");
		simpleFieldsPanel.add(alignmentField);

		nameLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel13.setText("Treasure  ");
		simpleFieldsPanel.add(nameLabel13);

		treasureField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		treasureField.setText("J");
		simpleFieldsPanel.add(treasureField);

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel8.setText("Type");
		simpleFieldsPanel.add(jLabel8);

		typeTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		typeTextField.setText("NA");
		simpleFieldsPanel.add(typeTextField);

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel2.setText("Climate");
		simpleFieldsPanel.add(jLabel2);

		climateTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		climateTextField.setText("NA");
		simpleFieldsPanel.add(climateTextField);

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel9.setText("Activity Cycle");
		simpleFieldsPanel.add(jLabel9);

		activityTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		activityTextField.setText("NA");
		simpleFieldsPanel.add(activityTextField);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel6.setText("Terrain");
		simpleFieldsPanel.add(jLabel6);

		terrainTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		terrainTextField.setText("NA");
		simpleFieldsPanel.add(terrainTextField);

		jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel10.setText("Diet");
		simpleFieldsPanel.add(jLabel10);

		dietTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		dietTextField.setText("NA");
		simpleFieldsPanel.add(dietTextField);

		jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel11.setText("In Lair");
		simpleFieldsPanel.add(jLabel11);

		inLairTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		inLairTextField.setText("NA");
		simpleFieldsPanel.add(inLairTextField);

		jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel12.setText("Morale");
		simpleFieldsPanel.add(jLabel12);

		moraleTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		moraleTextField.setText("NA");
		simpleFieldsPanel.add(moraleTextField);

		jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel13.setText("Psionic Ability");
		simpleFieldsPanel.add(jLabel13);

		psionicAbilityTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		psionicAbilityTextField.setText("NA");
		simpleFieldsPanel.add(psionicAbilityTextField);

		jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel14.setText("Organization");
		simpleFieldsPanel.add(jLabel14);

		organizationTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		organizationTextField.setText("NA");
		simpleFieldsPanel.add(organizationTextField);

		jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel15.setText("Psionic Modes");
		simpleFieldsPanel.add(jLabel15);

		psionicModesTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		psionicModesTextField.setText("NA");
		simpleFieldsPanel.add(psionicModesTextField);

		nameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel2.setText("BaseXP  ");
		simpleFieldsPanel.add(nameLabel2);

		baseXPField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		baseXPField.setText("20");
		simpleFieldsPanel.add(baseXPField);

		nameLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10));
		nameLabel14.setText("XP Per Hitpoint  ");
		simpleFieldsPanel.add(nameLabel14);

		xpPerHPField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		xpPerHPField.setText("1");
		simpleFieldsPanel.add(xpPerHPField);

		jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel17.setText("THACO");
		simpleFieldsPanel.add(jLabel17);

		thacoTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		thacoTextField.setText("20");
		simpleFieldsPanel.add(thacoTextField);

		jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel16.setText("Source");
		simpleFieldsPanel.add(jLabel16);

		sourceTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		sourceTextField.setText("MM");
		simpleFieldsPanel.add(sourceTextField);

		descriptionPanel.setBackground(new java.awt.Color(204, 204, 204));
		descriptionPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true), "Description"));
		descriptionPanel.setName("Description");
		descriptionPanel.setLayout(new java.awt.BorderLayout());

		descriptionField.setColumns(20);
		descriptionField.setLineWrap(true);
		descriptionField.setRows(5);
		descriptionField.setWrapStyleWord(true);
		jScrollPane2.setViewportView(descriptionField);

		descriptionPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(153, 153, 153));
		buttonsPanel.setLayout(new java.awt.GridBagLayout());

		jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel18.setText("How Many?");
		jLabel18.setToolTipText("Add how many of this creature to the encounter?");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(jLabel18, gridBagConstraints);

		encounterAddSpinner.setFont(new java.awt.Font("Tahoma", 0, 10));
		encounterAddSpinner.setPreferredSize(new java.awt.Dimension(28, 25));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(encounterAddSpinner, gridBagConstraints);

		addEncounterButton.setBackground(new java.awt.Color(255, 204, 0));
		addEncounterButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		addEncounterButton.setText("add encounter");
		addEncounterButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						addEncounterButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(addEncounterButton, gridBagConstraints);

		creatureHPGenMAXRadioButton.setBackground(new java.awt.Color(153, 153,
				153));
		creatureHitpointGenerationRadioGroup.add(creatureHPGenMAXRadioButton);
		creatureHPGenMAXRadioButton
				.setFont(new java.awt.Font("Segoe UI", 0, 10));
		creatureHPGenMAXRadioButton.setText("Max");
		creatureHPGenMAXRadioButton
				.setToolTipText("Generate maximum possible monster health.");
		creatureHPGenMAXRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureHPGenMAXRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(creatureHPGenMAXRadioButton, gridBagConstraints);

		creatureHPGen80PercentRadioButton.setBackground(new java.awt.Color(153,
				153, 153));
		creatureHitpointGenerationRadioGroup
				.add(creatureHPGen80PercentRadioButton);
		creatureHPGen80PercentRadioButton.setFont(new java.awt.Font("Segoe UI",
				0, 10));
		creatureHPGen80PercentRadioButton.setText("80%");
		creatureHPGen80PercentRadioButton
				.setToolTipText("Generate 80% of maximum possible monster health.");
		creatureHPGen80PercentRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureHPGen80PercentRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(creatureHPGen80PercentRadioButton, gridBagConstraints);

		creatureHPGenAverageRadioButton.setBackground(new java.awt.Color(153,
				153, 153));
		creatureHitpointGenerationRadioGroup
				.add(creatureHPGenAverageRadioButton);
		creatureHPGenAverageRadioButton.setFont(new java.awt.Font("Segoe UI",
				0, 10));
		creatureHPGenAverageRadioButton.setText("Average");
		creatureHPGenAverageRadioButton
				.setToolTipText("Generate average monster health.");
		creatureHPGenAverageRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureHPGenAverageRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(creatureHPGenAverageRadioButton, gridBagConstraints);

		creatureHPGenNormalRadioButton.setBackground(new java.awt.Color(153,
				153, 153));
		creatureHitpointGenerationRadioGroup
				.add(creatureHPGenNormalRadioButton);
		creatureHPGenNormalRadioButton.setFont(new java.awt.Font("Segoe UI", 0,
				10));
		creatureHPGenNormalRadioButton.setText("Normal");
		creatureHPGenNormalRadioButton
				.setToolTipText("Generate health normally for creatures.");
		creatureHPGenNormalRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureHPGenNormalRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		buttonsPanel.add(creatureHPGenNormalRadioButton, gridBagConstraints);

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																buttonsPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																mainPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				mainPanelLayout
																						.createSequentialGroup()
																						.addGap(0,
																								0,
																								0)
																						.addComponent(
																								descriptionPanel,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								578,
																								Short.MAX_VALUE))
																		.addComponent(
																				simpleFieldsPanel,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				578,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addComponent(
												simpleFieldsPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												247,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												descriptionPanel,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												106, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												buttonsPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		beastarySplitPane.setRightComponent(mainPanel);

		listCreaturePanel.setBackground(new java.awt.Color(153, 153, 153));
		listCreaturePanel.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		listCreaturePanel.setName("List-Creature-Panel");
		listCreaturePanel.setLayout(new java.awt.BorderLayout());

		jPanel10.setBackground(new java.awt.Color(204, 204, 204));

		jPanel9.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel4.setText("Search");
		jLabel4.setToolTipText("Enter text in the box to filter the creatures listed.");
		jPanel9.add(jLabel4);

		creatureSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		creatureSearchTextField
				.setToolTipText("String to search for in creature list.");
		creatureSearchTextField.setMinimumSize(new java.awt.Dimension(150, 20));
		creatureSearchTextField
				.setPreferredSize(new java.awt.Dimension(150, 20));
		creatureSearchTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureSearchTextFieldActionPerformed(evt);
					}
				});
		creatureSearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				creatureSearchTextFieldKeyReleased(evt);
			}
		});
		jPanel9.add(creatureSearchTextField);

		jPanel17.setBackground(new java.awt.Color(153, 153, 153));
		jPanel17.setLayout(new java.awt.GridLayout(1, 0));

		newButton.setBackground(new java.awt.Color(204, 204, 204));
		newButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		newButton.setText("New");
		newButton.setToolTipText("Create new blank creature.");
		newButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newButtonActionPerformed(evt);
			}
		});
		jPanel17.add(newButton);

		creatureCopyButton.setBackground(new java.awt.Color(204, 204, 204));
		creatureCopyButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		creatureCopyButton.setText("Copy");
		creatureCopyButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						creatureCopyButtonActionPerformed(evt);
					}
				});
		jPanel17.add(creatureCopyButton);

		saveButton.setBackground(new java.awt.Color(204, 204, 204));
		saveButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		saveButton.setText("Save");
		saveButton.setToolTipText("Save all creatures to file");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		jPanel17.add(saveButton);

		listCreatureList
				.setToolTipText("Select creature to load or press enter after selected.");
		listCreatureList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				listCreatureListMousePressed(evt);
			}
		});
		listCreatureList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						listCreatureListValueChanged(evt);
					}
				});
		listCreatureList.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				listCreatureListKeyTyped(evt);
			}
		});
		jScrollPane1.setViewportView(listCreatureList);

		jPanel8.setBackground(new java.awt.Color(153, 153, 153));
		jPanel8.setLayout(new java.awt.GridLayout(1, 0));

		importButton.setBackground(new java.awt.Color(204, 204, 204));
		importButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importButton.setText("Import");
		importButton.setToolTipText("Import options.");
		importButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importButtonActionPerformed(evt);
			}
		});
		jPanel8.add(importButton);

		exportButton.setBackground(new java.awt.Color(204, 204, 204));
		exportButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		exportButton.setText("Export");
		exportButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exportButtonActionPerformed(evt);
			}
		});
		jPanel8.add(exportButton);

		deleteButton.setBackground(new java.awt.Color(204, 204, 204));
		deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		deleteButton.setText("Delete");
		deleteButton.setToolTipText("Delete currently selected creature.");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});
		jPanel8.add(deleteButton);

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel9,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel10Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jPanel8,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								217,
																								Short.MAX_VALUE)
																						.addComponent(
																								jPanel17,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								217,
																								Short.MAX_VALUE)
																						.addComponent(
																								jScrollPane1,
																								0,
																								217,
																								Short.MAX_VALUE))
																		.addGap(2,
																				2,
																				2)))
										.addContainerGap()));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel10Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel9,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel17,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 318,
								Short.MAX_VALUE)
						.addGap(0, 0, 0)
						.addComponent(jPanel8,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		listCreaturePanel.add(jPanel10, java.awt.BorderLayout.CENTER);

		beastarySplitPane.setLeftComponent(listCreaturePanel);

		add(beastarySplitPane, java.awt.BorderLayout.CENTER);

		bindingGroup.bind();
	}// </editor-fold>
	//GEN-END:initComponents

	private void creatureHPGenNormalRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		setHitpointGenerationVars();
	}

	private void creatureHPGen80PercentRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		setHitpointGenerationVars();
	}

	private void creatureHPGenAverageRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		setHitpointGenerationVars();
	}

	private void creatureHPGenMAXRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		setHitpointGenerationVars();
	}

	/**
	 * set system vars for generating health, saves in settings file
	 */
	private void setHitpointGenerationVars() {
		ost.creatureHPMax = creatureHPGenMAXRadioButton.isSelected();
		ost.creatureHP80 = creatureHPGen80PercentRadioButton.isSelected();
		ost.creatureHPAvg = creatureHPGenAverageRadioButton.isSelected();
		ost.creatureHPNormal = creatureHPGenNormalRadioButton.isSelected();
	}

	private void creatureSearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
		updateCreatureList(currentCreature);
	}

	private void listCreatureListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {
		loadListSelectedCreature();
	}

	private void importCopyFromClipBoardButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		String importString = Utils.getClipboardContents(ost.mainFrame);
		if (importString != null) {
			importTextArea.setText(importString);
		}
	}

	private void exportCopyToClipBoardButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Utils.setClipboardContents(exportTextArea.getText());
		SimpleDialog.showDone("Export data in clipboard.");
	}

	private void creatureCopyButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		CreatureClass newCreature = new CreatureClass(
				currentCreature.getName(), ost.creatureList.getContent().size());
		ost.creatureList.add(newCreature);
		newCreature = getCreaturePanelFields(newCreature);
		updateCreatureList(newCreature);
		saveCreaturesToFile();
	}

	private void exportDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		exportDialog.setVisible(false);
	}

	private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Object[] aList = listCreatureList.getSelectedValues();
		ArrayList<CreatureClass> cList = new ArrayList<CreatureClass>();

		for (int i = 0; i < aList.length; i++) {
			CreatureClass oC = (CreatureClass) aList[i];
			cList.add(oC);
		}
		Document doc = CreatureClass.xmlBuildDocFromList(cList,
				"ExportCreature");
		exportTextArea.setText(XMLControl.getDocAsText(doc));
		exportDialog.setLocation(exportButton.getLocation());
		exportDialog.setVisible(true);
	}

	private void listCreatureListMousePressed(java.awt.event.MouseEvent evt) {
		loadListSelectedCreature();
	}

	private void addEncounterButtonActionPerformed(
			java.awt.event.ActionEvent evt) {

		//TODO Not done here...

		int iMaxCreatureCount = Integer.parseInt(encounterAddSpinner.getValue()
				.toString());
		encounterAddSpinner.setValue(new Integer(1)); // reset to 1
		int iCurrentCreatureCount = 1;
		// build array of proper formated hd for matrix
		ArrayList<String> oListArray = new ArrayList<String>();
		ChartClass oChart = ChartClass.getChartByName(CHART_MONSTER_MATRIX,
				ost.chartList.getContent());
		ChartColumn ocC = (ChartColumn) oChart.getColumn().toArray()[0];
		for (int i = 0; i < ocC.row.size(); i++) {
			oListArray.add(ocC.getRowValue(i));
		} // end for

		// these values will be used so they don't get prompted for every single creature
		// added, just once
		String newHD = "";
		String tmpHD = "";
		String tmpMatrixHD = "";
		String tmpHitpoints = "";
		String supAtk = "";
		// create as many critters as they asked for
		while (iMaxCreatureCount >= iCurrentCreatureCount) {

			CreatureClass oC = new CreatureClass();
			oC = getCreaturePanelFields(oC);
			String originalHD = oC.getHD();

			// AC field not start with a number, get a new one for the encounter
			while (!oC.getAC().matches("\\A([0-9\\-]+)(\\s.+)?\\Z")) {
				String newAC = SimpleDialog.showQuestion(this,
						"Need a valid AC for encounter.", "New AC Value", "10");
				oC.setAC(newAC);
				ost.dprint(String.format("New AC: %s", oC.getAC()));
			}
			acField.setText(oC.getAC()); // set the field to a valid ac so dont get asked for every critter

			// get unused name for with number
			oC.setName(CreatureClass.getUnusedCreatureName(oC.getName(), ost));

			ost.dprint(String.format("Encountering %s----------\n",
					oC.getName()));

			// set MaxHP
			do {
				oC.setMaxHP(String.format("%d", MyParse.calculateMaxHitpoints(
						tmpHitpoints.length() > 0 ? tmpHitpoints : oC.getHD(),
						ost)));

				oC.setHitPoints(oC.getMaxHP());

				if (oC.getHitPoints().matches("0")) {
					oC.setHD(SimpleDialog.showQuestion(
							mainPanel,
							String.format(
									"Bad HD format (%s)\nExpect: ##, ##-#, ## hp, #d#, #d#+#",
									oC.getHD()), String
									.format("New Hit Dice Value"), String
									.format("%d", 1)));
				} // end if
			} while (oC.getHitPoints().matches("0")); // end while
			tmpHitpoints = tmpHitpoints.length() > 0 ? tmpHitpoints : oC
					.getHD();
			ost.dprint(String.format("%s: MaxHP:(%s)\n", oC.getName(),
					oC.getMaxHP()));
			// end HP

			if (tmpHD.length() > 0)
				oC.setHD(tmpHD); // for looping and hd is set right

			// set matrix HD value since it does not always match HD once sorted to
			// valid result
			if (tmpMatrixHD.length() > 0)
				oC.setHD(tmpMatrixHD);
			Pattern patTrix = Pattern
					.compile(
							"(\\d+)([dD])?(([\\+\\-])(\\d+)?)?(\\d+)?(\\shp|\\shit points)?.*?",
							Pattern.CASE_INSENSITIVE);
			do {
				String myHD = "";
				Matcher matTrix = patTrix.matcher(oC.getHD());
				if (matTrix.matches()) {
					// 3+5
					if (matTrix.group(1) != null && // 3	
							matTrix.group(4) != null && // - or +
							matTrix.group(5) != null) { // 5
						int nAdjHD = Integer.parseInt(matTrix.group(5).trim());
						int nHD = Integer.parseInt(matTrix.group(1).trim());

						// if + to hd > 3 they get next HD rating for attack
						if (matTrix.group(4).trim().equalsIgnoreCase("+")
								&& nAdjHD > 3) {
							nHD++;
							myHD = String.format("%d", nHD);
						} else if (matTrix.group(4).trim()
								.equalsIgnoreCase("+")
								&& nHD == 1) {
							myHD = String.format("%d+", nHD);
						} else if (matTrix.group(4).trim()
								.equalsIgnoreCase("-")
								&& nHD == 1 && nAdjHD == 1) {
							myHD = String.format("%d-%d", nHD, nAdjHD);
						} else {
							// we only care about 1-1 otherwise just nHD
							myHD = String.format("%d", nHD);
						}
					}// x+
					else if (matTrix.group(1) != null && // X
							matTrix.group(3) != null && // + or -
							matTrix.group(4) != null) { // + or -
						String sAdj = matTrix.group(4);
						int nHD = Integer.parseInt(matTrix.group(1).trim());
						if (nHD == 1) // we only care about 1+
							myHD = String.format("%d%s", nHD,
									sAdj.equalsIgnoreCase("+") ? sAdj : "");
						else
							myHD = String.format("%d", nHD);
					}
					// XdX
					else if (matTrix.group(1) != null && // X
							matTrix.group(2) != null && // d or D
							matTrix.group(6) != null) { // X
						// HD was a dice roll ... just ask them what to do.
						myHD = "";
					}
					// X hp|hit points
					else if (matTrix.group(1) != null && // X
							matTrix.group(7) != null) { // hp or hit points
						// HD was a dice roll ... just ask them what to do.
						myHD = "";
					} else if (matTrix.group(1) != null
							&& // d 
							matTrix.group(2) == null
							&& matTrix.group(3) == null
							&& matTrix.group(4) == null
							&& matTrix.group(5) == null
							&& matTrix.group(6) == null
							&& matTrix.group(7) == null) {
						myHD = matTrix.group(1).trim();
					}
				} else {
					ost.dprint("HD for matrix test found no matches.\n");
				}
				if (myHD == "") {
					newHD = SimpleDialog
							.showQuestion(
									mainPanel,
									String.format(
											"Unrecognized hit-dice format (%s).\nExpect: 1-1, 1+ or X",
											oC.getHD()), "Select HD Value",
									"0", oListArray.toArray());
					oC.setMatrixHD(newHD);
				} else {
					oC.setMatrixHD(myHD);
				}
			} while (oC.getMatrixHD().length() <= 0);
			// end setting attack matrix leve/hd 
			tmpMatrixHD = tmpMatrixHD.length() > 0 ? tmpMatrixHD : oC
					.getMatrixHD();
			// set the tmpHD to current valid HD
			tmpHD = tmpHD.length() > 0 ? tmpHD : oC.getHD();
			ost.dprint(String.format("%s: MatrixHD set to (%s)\n",
					oC.getName(), oC.getMatrixHD()));
			ost.dprint(String.format("%s: HD set to (%s)\n", oC.getName(),
					oC.getHD()));
			// now that we are done with it set back to original
			// so it shows up unmodified on the encounter sheet
			if (newHD.length() > 0) {
				oC.setHD(newHD + " (" + originalHD + ")");
			} else
				oC.setHD(originalHD);

			ArrayList<String> atksList = MyParse.getDamageDice(oC.getDamage());
			for (int iC = 0; iC < atksList.size(); iC++) {
				CreatureAttackClass oA = new CreatureAttackClass(
						atksList.get(iC), iC + 1);
				oC.getAttackList().add(oA);
			} // end for

			if (atksList.size() < 1
			// decided if they wanted by weapon they can manually add it.
			//					|| oC.getDamage().toLowerCase().contains("by weapon")
			) {
				while (!MyParse.isInteger(MyParse.parseDice(supAtk))) {
					// once supAtk set it'll be used for every creature
					// in this batch
					supAtk = SimpleDialog.showQuestion(this,
							"By weapon or other damage needed",
							"Attack damage", "1d6");
				}
				CreatureAttackClass oA = new CreatureAttackClass(supAtk, -1);
				oA.setAttackName("By Weapon/Other");
				oC.getAttackList().add(oA);
			} // end if by weapon

			oC.setEncountered(new EncounterCreature(ost, oC));

			ost.fightingCreatureList.add(oC);
			//			ost.encounterFrame.creatureEncounterModel.addElement(oC);
			ost.encounterFrame.encountersTreeModel.insertNodeInto(
					new DefaultMutableTreeNode(oC), ost.encounterFrame.nodeNPC,
					ost.encounterFrame.nodeNPC.getChildCount());

			iCurrentCreatureCount++;
		} // end while (creature count)

		if (!ost.encounterFrame.isVisible()) {
			ost.encounterFrame.setVisible(true);
		} else {
			ost.encounterFrame.validate();
		}

		ost.encounterFrame.encountersTree.expandPath(new TreePath(
				ost.encounterFrame.nodeNPC.getPath()));

		// if nothing selected select one
		ost.encounterFrame.encountersTreeSetSelected();

		// should reset values back to previous since we didn't alter currentCreature
		// used incase we set AC or some other value that changes depending on critter
		updateCreaturePanel();
	}

	private void creatureSearchTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		updateCreatureList(currentCreature);
	}

	private void importCloseLogButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		importLogTextArea.setText("");
		importLogDialog.setVisible(false);
	}

	/**
	 * import using excel/txt
	 * 
	 */
	private void importTXT() {
		importLogTextArea.setText("");
		importLogDialog.setVisible(true);

		String parseText = importTextArea.getText();
		String parseLineRegex = "(.+)\n";
		String parseValuesRegex = "[ \\S]+";
		//		String parseValuesRegex = "[a-zA-Z/,' \\-\\+0-9\\(\\)%\\.;:<>\"*&`\\?]+";
		// 30 values, tab delimited
		String parseRegex = "(" + parseValuesRegex + ")\t" //1 name
				+ "(" + parseValuesRegex + ")\t" //2 type
				+ "(" + parseValuesRegex + ")\t" //3 climate
				+ "(" + parseValuesRegex + ")\t" //4 terrain
				+ "(" + parseValuesRegex + ")\t" //5 freq
				+ "(" + parseValuesRegex + ")\t" //6 organization
				+ "(" + parseValuesRegex + ")\t" //7 activity cycle
				+ "(" + parseValuesRegex + ")\t" //8 diet
				+ "(" + parseValuesRegex + ")\t" //9 intel
				+ "(" + parseValuesRegex + ")\t" //10 % in lair
				+ "(" + parseValuesRegex + ")\t" //11 treasure
				+ "(" + parseValuesRegex + ")\t" //12 alignment
				+ "(" + parseValuesRegex + ")\t" //13 # appearing
				+ "(" + parseValuesRegex + ")\t" //14 AC
				+ "(" + parseValuesRegex + ")\t" //15 move
				+ "(" + parseValuesRegex + ")\t" //16 HD
				+ "(" + parseValuesRegex + ")\t" //17 THACO
				+ "(" + parseValuesRegex + ")\t" //18 # attacks
				+ "(" + parseValuesRegex + ")\t" //19 damage
				+ "(" + parseValuesRegex + ")\t" //20 special atk
				+ "(" + parseValuesRegex + ")\t" //21 special def
				+ "(" + parseValuesRegex + ")\t" //22 magic resist
				+ "(" + parseValuesRegex + ")\t" //23 size
				+ "(" + parseValuesRegex + ")\t" //24 morale
				+ "(" + parseValuesRegex + ")\t" //25 psionic ability
				+ "(" + parseValuesRegex + ")\t" //26 psionic a/d modes
				+ "(" + parseValuesRegex + ")\t" //27 level
				+ "(" + parseValuesRegex + ")\t" //28 xp
				+ "(" + parseValuesRegex + ")\t" //29 source
				+ "(" + parseValuesRegex + ")\n"; //30 edition

		Pattern checkLinePattern = Pattern.compile(parseLineRegex,
				Pattern.CASE_INSENSITIVE);
		Pattern checkPattern = Pattern.compile(parseRegex,
				Pattern.CASE_INSENSITIVE);

		Matcher checkLineMatcher = checkLinePattern.matcher(parseText);

		String thisLine;
		Matcher checkMatcher;
		// flip through each line
		while (checkLineMatcher.find()) {
			thisLine = checkLineMatcher.group();
			checkMatcher = checkPattern.matcher(thisLine);
			// if line matches text\t then parse
			if (!checkMatcher.matches()) {
				importLogTextArea.append(String.format(
						"No matches in line (%s) matched only [%d] tabs.\n",
						thisLine, checkMatcher.groupCount()));
			} else {
				CreatureClass oC = new CreatureClass();
				try {
					oC.setName(checkMatcher.group(1).trim());
					importLogTextArea.append(String.format(
							"Attempting to add %s. ", oC.getName()));

					oC.setType(checkMatcher.group(2).trim());
					oC.setClimate(checkMatcher.group(3).trim());
					oC.setTerrain(checkMatcher.group(4).trim());
					oC.setFrequency(checkMatcher.group(5).trim());
					oC.setOrganization(checkMatcher.group(6).trim());
					oC.setActivityCycle(checkMatcher.group(7).trim());
					oC.setDiet(checkMatcher.group(8).trim());
					oC.setIntelligence(checkMatcher.group(9).trim());
					oC.setInLair(checkMatcher.group(10).trim());
					oC.setTreasure(checkMatcher.group(11).trim());
					oC.setAlignment(checkMatcher.group(12).trim());
					oC.setEncounterSize(checkMatcher.group(13).trim());
					oC.setAC(checkMatcher.group(14).trim());
					oC.setMove(checkMatcher.group(15).trim());
					oC.setHD(checkMatcher.group(16).trim());
					oC.setTHACO(checkMatcher.group(17).trim());

					if (MyParse.isInteger(checkMatcher.group(18)))
						oC.setAttacks(Integer.parseInt(checkMatcher.group(18)
								.trim()));

					oC.setDamage(checkMatcher.group(19).trim());
					oC.setSpecialAttack(checkMatcher.group(20).trim());
					oC.setSpecialDefense(checkMatcher.group(21).trim());
					oC.setMagicResistance(checkMatcher.group(22).trim());
					oC.setSize(checkMatcher.group(23).trim());
					oC.setMorale(checkMatcher.group(24).trim());
					oC.setPsionicAbility(checkMatcher.group(25).trim());
					oC.setPsionicModes(checkMatcher.group(26).trim());

					if (MyParse.isInteger(checkMatcher.group(27)))
						oC.setLevel(Integer.parseInt(checkMatcher.group(27)
								.trim()));

					if (MyParse.isInteger(checkMatcher.group(28))) {
						oC.setBaseXP(Integer.parseInt(checkMatcher.group(28)
								.trim()));
					} else {
						Pattern basePattern = Pattern.compile(
								"(\\d+)\\+(\\d+)", Pattern.CASE_INSENSITIVE);
						Matcher matchBase = basePattern.matcher(parseText);
						if (matchBase.find()) {
							oC.setBaseXP(Integer.parseInt(matchBase.group(1)
									.trim()));
							oC.setXPperHP(Integer.parseInt(matchBase.group(2)
									.trim()));
						}
					}

					oC.setSource(checkMatcher.group(29).trim());
					//oC.setEdition(checkMatcher.group(30).trim());

					// no errors, add creature
					importLogTextArea.append(String.format("Added %s\n",
							oC.getName()));
					addNewCreature(oC);
				} catch (NullPointerException err) {
					importLogTextArea.append(String.format(
							"Failed at line (%s)\n", thisLine));
				}
			} // end matches

		} // end get line

		importTextArea.setText("");
	} // end txtimportbutton

	private void importDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (importOSRICRadioButton.isSelected()) {
			importOSRIC();
		} else if (importOSTRadioButton.isSelected()) {
			importOST();
		} else if (importTXTRadioButton.isSelected()) {
			importTXT();
		} else {
			// shouldn't get here.
		}
		importDialog.setVisible(false);
	}

	private void importOST() {
		Document doc = XMLControl
				.loadDocFromXMLString(importTextArea.getText());
		ArrayList<CreatureClass> aList = CreatureClass.getListFromDoc(doc);
		for (CreatureClass oC : aList) {
			if (!oC.exists(ost.creatureList.getContent())
					|| SimpleDialog.AskYN(importButton, oC.getName()
							+ " exists, add anyway?")) {
				addNewCreature(oC);
			}
		}

	}

	/**
	 * 
	 */
	private void importOSRIC() {

		// do imports/checks
		CreatureClass oC = new CreatureClass();

		String parseCreature = importTextArea.getText();
		String sTemp = null;
		oC.setName(MyParse.getString("\\A(.+)\n", parseCreature));
		//		SimpleDialog.showDone(String.format("Found name %s.", oC.getName()));

		oC.setFrequency(MyParse.getString("\nfrequency:\\s+(.+)\n",
				parseCreature));
		//		SimpleDialog.showDone(String.format("Found freq %s.", oC.getFrequency()));

		oC.setEncounterSize(MyParse.getString("\nno. encountered:\\s+(.+)\n",
				parseCreature));
		//		SimpleDialog.showDone(String.format("Found Encounter %s.", oC.getEncounterSize()));

		oC.setSize(MyParse.getString("\nsize:\\s+(.+)\n", parseCreature));

		oC.setMove(MyParse.getString("\nmove:\\s+(.+)\n", parseCreature));

		oC.setAC(MyParse.getString("\narmour class:\\s+(.+)\n", parseCreature));

		oC.setHD(MyParse.getString("\nhit dice:\\s+(.+)\n", parseCreature));

		sTemp = MyParse.getString("\nattacks:\\s+(\\w+)\n", parseCreature);
		if (MyParse.isInteger(sTemp)) {
			oC.setAttacks(Integer.parseInt(sTemp));
		} else {
			oC.setAttacks(1);
			SimpleDialog
					.showDone("Attacks parsing failed, set to actual value.");
		} // end was valid integer

		oC.setDamage(MyParse.getString("\ndamage:\\s+(.+)\n", parseCreature));

		oC.setSpecialAttack(MyParse.getString("\nspecial attacks:\\s+(.+)\n",
				parseCreature));
		oC.setSpecialDefense(MyParse.getString("\nspecial defences:\\s+(.+)\n",
				parseCreature));

		oC.setMagicResistance(MyParse.getString(
				"\nmagic resistance:\\s+(.+)\n", parseCreature));
		oC.setIntelligence(MyParse.getString("\nintelligence:\\s+(.+)\n",
				parseCreature));
		oC.setAlignment(MyParse.getString("\nalignment:\\s+(.+)\n",
				parseCreature));

		//		Pattern checkPattern = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		//		Pattern checkPattern = Pattern.compile(regEX, patternWise);
		Pattern checkPattern = Pattern
				.compile(
						"\nlevel/xp:\\s+(variable)?((\\d+)/([0-9\\,]+)\\s?\\+\\s?(\\d+)(/hp|\\s?per hp\\.?|\\s?per hit point\\.?))?\n",
						Pattern.CASE_INSENSITIVE);
		//		Pattern checkPattern = Pattern.compile("\nlevel/xp:\\s+(\\d+)", Pattern.CASE_INSENSITIVE);
		Matcher checkMatcher = checkPattern.matcher(parseCreature);

		if (checkMatcher.find()) {
			//			SimpleDialog.showDone(String.format("0 = (%s)",checkMatcher.group(0)==null?"":checkMatcher.group(0).trim()));
			//			SimpleDialog.showDone(String.format("1 = (%s)",checkMatcher.group(1)==null?"":checkMatcher.group(1).trim()));
			//			SimpleDialog.showDone(String.format("2 = (%s)",checkMatcher.group(2)==null?"":checkMatcher.group(2).trim()));
			//			SimpleDialog.showDone(String.format("3 = (%s)",checkMatcher.group(3)==null?"":checkMatcher.group(3).trim()));
			//			SimpleDialog.showDone(String.format("4 = (%s)",checkMatcher.group(4)==null?"":checkMatcher.group(4).trim()));
			//			SimpleDialog.showDone(String.format("5 = (%s)",checkMatcher.group(5)==null?"":checkMatcher.group(5).trim()));
			//			SimpleDialog.showDone(String.format("6 = (%s)",checkMatcher.group(6)==null?"":checkMatcher.group(6).trim()));

			// level = string "Variable"
			if (checkMatcher.group(1) != null) {
				oC.setLevel(0);
				SimpleDialog
						.showDone("Level is variable, set to actual value.");
			} else if (checkMatcher.group(3) == null) {
				oC.setLevel(0);
				SimpleDialog
						.showDone("Level parsing failed, set to actual value.(not found)");
			} else // level is a actual number
			if (MyParse.isInteger(checkMatcher.group(3))) {
				oC.setLevel(Integer.parseInt(checkMatcher.group(3)));
			} else {
				oC.setLevel(0);
				SimpleDialog
						.showDone("Level parsing failed, set to actual value.");
			}

			if (checkMatcher.group(4) == null) {
				oC.setBaseXP(0);
				SimpleDialog
						.showDone("Base Experience parsing failed, set proper value.(not found)");
			}
			// baseXP is a actual number (remove commas)
			else if (MyParse.isInteger(checkMatcher.group(4)
					.replaceAll(",", ""))) {
				oC.setBaseXP(Integer.parseInt(checkMatcher.group(4)));
			} else {
				oC.setBaseXP(0);
				SimpleDialog
						.showDone("Base Experience parsing failed, set proper value.");
			}

			if (checkMatcher.group(5) == null) {
				oC.setXPperHP(0);
				SimpleDialog
						.showDone("XP Per HP parsing failed, set proper value.(not found)");
			}
			// sPerHPXP is a actual number (remove commas)
			else if (MyParse.isInteger(checkMatcher.group(5))) {
				oC.setXPperHP(Integer.parseInt(checkMatcher.group(5)));
			} else {
				oC.setXPperHP(0);
				SimpleDialog
						.showDone("XP Per HP parsing failed, set proper value.");
			}

			//			SimpleDialog.showDone(String.format("sLevel = (%s)\nsBaseXP = (%s)\nsPerHPXP = (%s).", 
			//					sLevel,sBaseXP,sPerHPXP));

		} else {
			SimpleDialog.showDone("Matcher-Failed:Level/XP!");
		}// end find()

		//		Pattern checkPattern = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		//		Pattern checkPattern = Pattern.compile(regEX, patternWise);
		checkPattern = Pattern
				.compile(
						"\nlevel/xp:\\s+(variable)?(\\d+/[0-9\\,]+\\s?\\+\\s?\\d+(/hp|\\s?per hp\\.?|\\s?per hit point\\.?))?\n(.+)treasure:(.+)",
						Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		checkMatcher = checkPattern.matcher(parseCreature);

		if (checkMatcher.find()) {

			// get description
			if (checkMatcher.group(4) == null) {
				oC.setDescription("Unknown");
				SimpleDialog
						.showDone("Description parsing failed, set proper value.(not found)");
			} else {
				oC.setDescription(checkMatcher.group(4).trim()
						.replaceAll("\n", ""));
			}

			// get treasure
			if (checkMatcher.group(5) == null) {
				oC.setTreasure("J");
				SimpleDialog
						.showDone("Treasure parsing failed, set proper value.(not found)");
			} else { // set treasure, also remove CR
				oC.setTreasure(checkMatcher.group(5).trim()
						.replaceAll("\n", ""));
			}
		} else {
			SimpleDialog.showDone("Matcher-Failed:Description/Treasure!");
		} // end find

		//		// these 2 require . to match \n or \r so we can get to end of string
		//		oC.setDescription(MyParse.getString(
		//								"\nlevel/xp:\\s+(variable)?(\\d+/[0-9\\,]+\\s?\\+\\s?\\d+(/hp|\\s?per hp\\.?|\\s?per hit point\\.?))?\n(.+)treasure:",
		//								parseCreature, 4, true,
		//								Pattern.CASE_INSENSITIVE | Pattern.DOTALL));
		//
		//		oC.setTreasure(MyParse.getString("treasure:\\s+(.+)", parseCreature, 1,
		//				true, Pattern.CASE_INSENSITIVE | Pattern.DOTALL));

		// remove all the extra CR/New lines
		//oC.setDescription(oC.getDescription().replaceAll("\n\n", ""));
		//		oC.setTreasure(oC.getTreasure().replaceAll("\n", ""));

		// append treasure to bottom of description
		oC.setDescription(String.format("%s\n\nTreasure: %s\n\n",
				oC.getDescription(), oC.getTreasure()));

		// add creature to things
		if (oC.getName() != null) // incase someone imports a load of junk
			addNewCreature(oC);

		// all done, close up
		importTextArea.setText("");
		importDialog.setVisible(false);

	}

	/**
	 * canceled out of import
	 * @param evt
	 */
	private void importCancelButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		importDialog.setVisible(false);
	}

	/*
	 * pressed the import button, load dialog
	 * 
	 */
	private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//importDialog.setLocation(importButton.getLocation());
		importDialog.setVisible(true);
		//importDialog.pack();
	}

	private void listCreatureListKeyTyped(java.awt.event.KeyEvent evt) {
		if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
			loadListSelectedCreature();
		}
	}

	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Object[] oList = listCreatureList.getSelectedValues();
		if (oList.length > 0) {
			CreatureClass oC = (CreatureClass) oList[0];
			boolean bDelete = false;

			if (oList.length > 1)
				bDelete = SimpleDialog.AskYN(deleteButton,
						"Delete ALL selected creatures?");
			else
				bDelete = SimpleDialog.AskYN(deleteButton,
						"Are you sure you want to delete " + oC.getName());

			if (bDelete) {
				for (int i = 0; i < oList.length; i++)
					ost.creatureList.getContent().remove(
							(CreatureClass) oList[i]);

				saveCreaturesToFile();
				updateCreatureList(null);
			} // bDelete
		}
	}

	private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {
		CreatureClass newCreature = new CreatureClass("New",
				(ost.creatureList.getContent().size()));
		addNewCreature(newCreature);
		saveCreaturesToFile();
	}

	/**
	 * add new creature to ArrayList and to current display and make sure to select
	 * it in the listCreature panel
	 * 
	 * @param newCreature
	 */
	private void addNewCreature(CreatureClass newCreature) {
		ost.creatureList.add(newCreature);
		// update the creature list which also updated the creature panel fields.
		updateCreatureList(newCreature);
		//SimpleDialog.showDone("Added new creature.");
	}

	/**
	 * loads the currently selected creature from (mouse double click or select/enter)
	 */
	private void loadListSelectedCreature() {
		if (currentCreature != null) {
			// make sure to get current fields before switching incase they
			// changed something
			currentCreature = getCreaturePanelFields(currentCreature);
		}
		// load selected creature now
		currentCreature = (CreatureClass) listCreatureList.getSelectedValue();
		updateCreaturePanel();
	}

	/**
	 * update creatureList and then update creaturePanel fields
	 * 
	 * @param oPreviousSelect
	 */
	public void updateCreatureList(CreatureClass oPreviousSelect) {
		String findThese = creatureSearchTextField.getText().trim();
		//creatureSearchTextField.setText("");

		modelListCreature.removeAllElements();
		Collections.sort(ost.creatureList.getContent());
		for (CreatureClass oC : ost.creatureList.getContent()) {
			//			modelListCreature.addElement(oC); // store creature name
			if (findThese == null
					|| findThese.length() < 1
					|| oC.getName().toLowerCase()
							.contains(findThese.toLowerCase())) {
				modelListCreature.addElement(oC); // add ones we're searching for...
			}// end if
		} // end for
		if (oPreviousSelect == null)
			listCreatureList.setSelectedIndex(0);
		else
			listCreatureList.setSelectedValue(oPreviousSelect, true);

		currentCreature = (CreatureClass) listCreatureList.getSelectedValue();

		// now fill in the creature panel with selected creature.
		updateCreaturePanel();
	}// end updateCreatureList

	/**
	 * updates the displayed creature from currentCreature object
	 */
	private void updateCreaturePanel() {
		// string fields
		if (currentCreature != null && currentCreature.getName() != null) {
			nameField.setText(currentCreature.getName());
			acField.setText(currentCreature.getAC());
			damageField.setText(currentCreature.getDamage());

			alignmentField.setText(currentCreature.getAlignment());
			descriptionField.setText(currentCreature.getDescription());
			encounterSizeField.setText(currentCreature.getEncounterSize());
			frequencyField.setText(currentCreature.getFrequency());
			hdField.setText(currentCreature.getHD());
			intelligenceField.setText(currentCreature.getIntelligence());
			magicresistanceField.setText(currentCreature.getMagicResistance());
			moveField.setText(currentCreature.getMove());
			sizeField.setText(currentCreature.getSize());
			specialAttackField.setText(currentCreature.getSpecialAttack());
			specialDefenseField.setText(currentCreature.getSpecialDefense());
			treasureField.setText(currentCreature.getTreasure());

			typeTextField.setText(currentCreature.getType());
			climateTextField.setText(currentCreature.getClimate());
			terrainTextField.setText(currentCreature.getTerrain());
			activityTextField.setText(currentCreature.getActivityCycle());
			dietTextField.setText(currentCreature.getDiet());
			inLairTextField.setText(currentCreature.getInLair());
			moraleTextField.setText(currentCreature.getMorale());
			psionicAbilityTextField
					.setText(currentCreature.getPsionicAbility());
			psionicModesTextField.setText(currentCreature.getPsionicModes());
			sourceTextField.setText(currentCreature.getSource());
			thacoTextField.setText(String.format("%d",
					currentCreature.getTHACO(ost.chartList.getContent())));
			organizationTextField.setText(currentCreature.getOrganization());

			// integers
			baseXPField
					.setText(String.format("%d", currentCreature.getBaseXP()));
			xpPerHPField.setText(String.format("%d",
					currentCreature.getXPperHP()));

			levelField.setText(String.format("%d", currentCreature.getLevel()));
			numAttacksField.setText(String.format("%d",
					currentCreature.getAttacks()));
		}
	}// end updateCreaturePanel

	/**
	 * 
	 * @param cC
	 * @return
	 */
	private CreatureClass getCreaturePanelFields(CreatureClass cC) {
		// strings
		//CreatureClass cC = new CreatureClass();

		cC.setName(nameField.getText());
		cC.setAC(acField.getText());
		cC.setDamage(damageField.getText());

		cC.setAlignment(alignmentField.getText());
		cC.setDescription(descriptionField.getText());
		cC.setEncounterSize(encounterSizeField.getText());
		cC.setFrequency(frequencyField.getText());
		cC.setHD(hdField.getText());
		cC.setIntelligence(intelligenceField.getText());
		cC.setMagicResistance(magicresistanceField.getText());
		cC.setMove(moveField.getText());
		cC.setSize(sizeField.getText());
		cC.setSpecialAttack(specialAttackField.getText());
		cC.setSpecialDefense(specialDefenseField.getText());
		cC.setTreasure(treasureField.getText());

		cC.setType(typeTextField.getText());
		cC.setClimate(climateTextField.getText());
		cC.setTerrain(terrainTextField.getText());
		cC.setActivityCycle(activityTextField.getText());
		cC.setDiet(dietTextField.getText());
		cC.setInLair(inLairTextField.getText());
		cC.setMorale(moraleTextField.getText());
		cC.setPsionicAbility(psionicAbilityTextField.getText());
		cC.setPsionicModes(psionicModesTextField.getText());
		cC.setSource(sourceTextField.getText());
		cC.setTHACO(thacoTextField.getText());
		cC.setOrganization(organizationTextField.getText());

		// integers
		cC.setBaseXP(Integer.parseInt(baseXPField.getText()));
		cC.setXPperHP(Integer.parseInt(xpPerHPField.getText()));

		cC.setLevel(Integer.parseInt(levelField.getText()));
		cC.setAttacks(Integer.parseInt(numAttacksField.getText()));

		return (cC);
	} // end loadCreaturePanelFields

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		saveCreaturesToFile();
		SimpleDialog.showDone("Saved creatures to file.");
	}

	/**
	 * 
	 */
	public void saveCreaturesToFile() {
		if (currentCreature != null) {
			currentCreature = getCreaturePanelFields(currentCreature);
			updateCreatureList(currentCreature);
		}

		ost.creatureList.xm.serializeToXMLFile();
		//		Document doc = CreatureClass.xmlBuildDocFromList(ost.creatureList,
		//				"CreatureList");
		//		XMLControl.saveDoc(doc, ost.sCreatureListFile);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField acField;
	private javax.swing.JTextField activityTextField;
	private javax.swing.JButton addEncounterButton;
	private javax.swing.JTextField alignmentField;
	private javax.swing.JTextField baseXPField;
	private javax.swing.JSplitPane beastarySplitPane;
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JTextField climateTextField;
	private javax.swing.JButton creatureCopyButton;
	public javax.swing.JRadioButton creatureHPGen80PercentRadioButton;
	public javax.swing.JRadioButton creatureHPGenAverageRadioButton;
	public javax.swing.JRadioButton creatureHPGenMAXRadioButton;
	public javax.swing.JRadioButton creatureHPGenNormalRadioButton;
	private javax.swing.ButtonGroup creatureHitpointGenerationRadioGroup;
	private javax.swing.JTextField creatureSearchTextField;
	private javax.swing.JTextField damageField;
	private javax.swing.JButton deleteButton;
	private javax.swing.JTextArea descriptionField;
	private javax.swing.JPanel descriptionPanel;
	private javax.swing.JTextField dietTextField;
	private javax.swing.JSpinner encounterAddSpinner;
	private javax.swing.JTextField encounterSizeField;
	private javax.swing.JButton exportButton;
	private javax.swing.JButton exportCopyToClipBoardButton;
	private javax.swing.JDialog exportDialog;
	private javax.swing.JButton exportDoneButton;
	private javax.swing.JTextArea exportTextArea;
	private javax.swing.JTextField frequencyField;
	private javax.swing.JTextField hdField;
	private javax.swing.JButton importButton;
	private javax.swing.ButtonGroup importButtonGroup;
	private javax.swing.JButton importCancelButton;
	private javax.swing.JButton importCloseLogButton;
	private javax.swing.JButton importCopyFromClipBoardButton;
	private javax.swing.JDialog importDialog;
	private javax.swing.JButton importDoneButton;
	private javax.swing.JDialog importLogDialog;
	private javax.swing.JTextArea importLogTextArea;
	private javax.swing.JRadioButton importOSRICRadioButton;
	private javax.swing.JRadioButton importOSTRadioButton;
	private javax.swing.JRadioButton importTXTRadioButton;
	private javax.swing.JTextArea importTextArea;
	private javax.swing.JTextField inLairTextField;
	private javax.swing.JTextField intelligenceField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabelx2;
	private javax.swing.JLabel jLabelx6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JTextField levelField;
	private javax.swing.JList listCreatureList;
	private javax.swing.JPanel listCreaturePanel;
	private javax.swing.JTextField magicresistanceField;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JTextField moraleTextField;
	private javax.swing.JTextField moveField;
	private javax.swing.JTextField nameField;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JLabel nameLabel1;
	private javax.swing.JLabel nameLabel10;
	private javax.swing.JLabel nameLabel11;
	private javax.swing.JLabel nameLabel12;
	private javax.swing.JLabel nameLabel13;
	private javax.swing.JLabel nameLabel14;
	private javax.swing.JLabel nameLabel15;
	private javax.swing.JLabel nameLabel2;
	private javax.swing.JLabel nameLabel4;
	private javax.swing.JLabel nameLabel5;
	private javax.swing.JLabel nameLabel7;
	private javax.swing.JLabel nameLabel8;
	private javax.swing.JLabel nameLabel9;
	private javax.swing.JButton newButton;
	private javax.swing.JTextField numAttacksField;
	private javax.swing.JTextField organizationTextField;
	private javax.swing.JTextField psionicAbilityTextField;
	private javax.swing.JTextField psionicModesTextField;
	private javax.swing.JButton saveButton;
	private javax.swing.JPanel simpleFieldsPanel;
	private javax.swing.JTextField sizeField;
	private javax.swing.JTextField sourceTextField;
	private javax.swing.JTextField specialAttackField;
	private javax.swing.JTextField specialDefenseField;
	private javax.swing.JTextField terrainTextField;
	private javax.swing.JTextField thacoTextField;
	private javax.swing.JTextField treasureField;
	private javax.swing.JTextField typeTextField;
	private javax.swing.JTextField xpPerHPField;
	private org.jdesktop.beansbinding.BindingGroup bindingGroup;
	// End of variables declaration//GEN-END:variables

	private CreatureClass currentCreature;
	private DefaultListModel modelListCreature;
	private SpinnerNumberModel modelEncounterSpinner;
}// end DM_Config_Tab_Creature