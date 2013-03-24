/*
 * DM_Config_Tab_Charts.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.jdom.Document;
import org.ost.main.MyClasses.ChartClass;
import org.ost.main.MyClasses.ChartColumn;
import org.ost.main.MyClasses.ChartList;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.XMLControl;

/**
 *
 * @author  __USER__
 */
public class DM_Config_Tab_Charts extends javax.swing.JPanel {
	private final int CHART_MARGIN = 5;

	/** Creates new form DM_Config_Tab_Charts */
	public DM_Config_Tab_Charts(MainClass ost) {
		this.ost = ost;
		currentChart = null;
		initComponents();
		chartModel = (DefaultTableModel) chartTable.getModel();
		chartListModel = (DefaultComboBoxModel) chartListComboBox.getModel();
		JTableHeader chartHeader = chartTable.getTableHeader();
		chartHeader.setDefaultRenderer(new MyHeaderRenderer());
		//chartHeader.setDefaultRenderer(new TextAreaRenderer());
		chartHeader.setPreferredSize(new Dimension(10, 60));
		chartTable.setRowHeight(30);

		// testing...
		updateChartListComboBox(null);

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		importDialog = new javax.swing.JDialog();
		jScrollPane1 = new javax.swing.JScrollPane();
		importTextArea = new javax.swing.JTextArea();
		jPanel5 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		importOSTRadioButton = new javax.swing.JRadioButton();
		importTXTRadioButton = new javax.swing.JRadioButton();
		importCopyFromClipBoardButton = new javax.swing.JButton();
		importButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		importButtonGroup = new javax.swing.ButtonGroup();
		importButtonGroup.add(importOSTRadioButton);
		importButtonGroup.add(importTXTRadioButton);

		exportChartExportDialog = new javax.swing.JDialog();
		jPanel12 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jPanel10 = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		chartExportTextArea = new javax.swing.JTextArea();
		jPanel11 = new javax.swing.JPanel();
		chartExportCopyToClipboardButton = new javax.swing.JButton();
		chartExportDoneButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		chartListComboBox = new javax.swing.JComboBox();
		chartDeleteButton = new javax.swing.JButton();
		chartNewButton = new javax.swing.JButton();
		chartImportButton = new javax.swing.JButton();
		chartExportButton = new javax.swing.JButton();
		chartSaveButton = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		chartDescriptionLabel = new javax.swing.JLabel();
		chartNameLabel = new javax.swing.JLabel();
		chartNameTextField = new javax.swing.JTextField();
		chartDescriptionTextField = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		chartTypeTextField = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		chartAddRowButton = new javax.swing.JButton();
		chartInsertRowButton = new javax.swing.JButton();
		chartDeleteRowsButton = new javax.swing.JButton();
		chartAddColumnButton = new javax.swing.JButton();
		chartDeleteColumnsButton = new javax.swing.JButton();
		chartClearEmptyButton = new javax.swing.JButton();
		chartClearAllButton = new javax.swing.JButton();
		chartAutoSizeButton = new javax.swing.JButton();
		chartTestButton = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		chartTableScrollPane = new javax.swing.JScrollPane();
		chartTable = new javax.swing.JTable();
		chartHeader = chartTable.getTableHeader();
		chartHeader.addMouseListener(new ColumnListener(chartTable));

		importDialog.setTitle("Import Chart");
		importDialog.setMinimumSize(new java.awt.Dimension(560, 430));

		importTextArea.setColumns(20);
		importTextArea.setLineWrap(true);
		importTextArea.setRows(5);
		importTextArea.setWrapStyleWord(true);
		jScrollPane1.setViewportView(importTextArea);

		importDialog.getContentPane().add(jScrollPane1,
				java.awt.BorderLayout.CENTER);

		jPanel5.setBackground(new java.awt.Color(204, 204, 204));
		jPanel5.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15));
		jLabel1.setText("Import OST or Text Charts");
		jPanel5.add(jLabel1);

		importDialog.getContentPane().add(jPanel5,
				java.awt.BorderLayout.PAGE_START);

		jPanel6.setBackground(new java.awt.Color(204, 204, 204));
		jPanel6.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		importOSTRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		importOSTRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importOSTRadioButton.setSelected(true);
		importOSTRadioButton.setText("OST");
		importOSTRadioButton.setToolTipText("Import charts exported from OST.");
		importOSTRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						importOSTRadioButtonActionPerformed(evt);
					}
				});
		jPanel6.add(importOSTRadioButton);

		importTXTRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		importTXTRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importTXTRadioButton.setText("Text");
		importTXTRadioButton
				.setToolTipText("Import copy/paste charts from books or spreadsheets. Must be tables separated by TAB.");
		importTXTRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						importTXTRadioButtonActionPerformed(evt);
					}
				});
		jPanel6.add(importTXTRadioButton);

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
		jPanel6.add(importCopyFromClipBoardButton);

		importButton.setBackground(new java.awt.Color(204, 204, 204));
		importButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		importButton.setText("import");
		importButton
				.setToolTipText("Import the text using the selected type as the format.");
		importButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				importButtonActionPerformed(evt);
			}
		});
		jPanel6.add(importButton);

		cancelButton.setBackground(new java.awt.Color(204, 204, 204));
		cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		cancelButton.setText("cancel");
		cancelButton.setToolTipText("Cancel import.");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		jPanel6.add(cancelButton);

		importDialog.getContentPane().add(jPanel6,
				java.awt.BorderLayout.PAGE_END);

		exportChartExportDialog.setTitle("Export Table");
		exportChartExportDialog
				.setMinimumSize(new java.awt.Dimension(445, 345));

		jPanel12.setBackground(new java.awt.Color(204, 204, 204));
		jPanel12.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15));
		jLabel4.setText("Copy the text below to export chart.");
		jPanel12.add(jLabel4);

		exportChartExportDialog.getContentPane().add(jPanel12,
				java.awt.BorderLayout.PAGE_START);

		jPanel10.setBackground(new java.awt.Color(204, 204, 204));
		jPanel10.setLayout(new java.awt.BorderLayout());

		chartExportTextArea.setColumns(20);
		chartExportTextArea.setEditable(false);
		chartExportTextArea.setLineWrap(true);
		chartExportTextArea.setRows(5);
		chartExportTextArea
				.setToolTipText("Copy and paste for others to import this table.");
		chartExportTextArea.setWrapStyleWord(true);
		jScrollPane4.setViewportView(chartExportTextArea);

		jPanel10.add(jScrollPane4, java.awt.BorderLayout.CENTER);

		exportChartExportDialog.getContentPane().add(jPanel10,
				java.awt.BorderLayout.CENTER);

		jPanel11.setBackground(new java.awt.Color(204, 204, 204));
		jPanel11.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		chartExportCopyToClipboardButton.setBackground(new java.awt.Color(204,
				204, 204));
		chartExportCopyToClipboardButton.setFont(new java.awt.Font("Segoe UI",
				0, 10));
		chartExportCopyToClipboardButton.setText("copy to clipboard");
		chartExportCopyToClipboardButton
				.setToolTipText("Copy all contents of the export window to clipboard.");
		chartExportCopyToClipboardButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartExportCopyToClipboardButtonActionPerformed(evt);
					}
				});
		jPanel11.add(chartExportCopyToClipboardButton);

		chartExportDoneButton.setBackground(new java.awt.Color(204, 204, 204));
		chartExportDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartExportDoneButton.setText("done");
		chartExportDoneButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartExportDoneButtonActionPerformed(evt);
					}
				});
		jPanel11.add(chartExportDoneButton);

		exportChartExportDialog.getContentPane().add(jPanel11,
				java.awt.BorderLayout.PAGE_END);

		setBackground(new java.awt.Color(204, 204, 204));
		setPreferredSize(new java.awt.Dimension(600, 500));

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));
		jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1,
				1));

		chartListComboBox.setModel(new DefaultComboBoxModel());
		chartListComboBox.setPreferredSize(new java.awt.Dimension(200, 27));
		chartListComboBox.setRenderer(new MyCellRendererList());
		chartListComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartListComboBoxActionPerformed(evt);
					}
				});
		jPanel3.add(chartListComboBox);

		chartDeleteButton.setBackground(new java.awt.Color(204, 204, 204));
		chartDeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartDeleteButton.setForeground(new java.awt.Color(204, 0, 0));
		chartDeleteButton.setText("delete");
		chartDeleteButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartDeleteButtonActionPerformed(evt);
					}
				});
		jPanel3.add(chartDeleteButton);

		chartNewButton.setBackground(new java.awt.Color(204, 204, 204));
		chartNewButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartNewButton.setText("new");
		chartNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chartNewButtonActionPerformed(evt);
			}
		});
		jPanel3.add(chartNewButton);

		chartImportButton.setBackground(new java.awt.Color(204, 204, 204));
		chartImportButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartImportButton.setText("import");
		chartImportButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartImportButtonActionPerformed(evt);
					}
				});
		jPanel3.add(chartImportButton);

		chartExportButton.setBackground(new java.awt.Color(204, 204, 204));
		chartExportButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartExportButton.setText("export");
		chartExportButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartExportButtonActionPerformed(evt);
					}
				});
		jPanel3.add(chartExportButton);

		chartSaveButton.setBackground(new java.awt.Color(204, 204, 204));
		chartSaveButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartSaveButton.setText("save");
		chartSaveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chartSaveButtonActionPerformed(evt);
			}
		});
		jPanel3.add(chartSaveButton);

		jPanel2.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.setPreferredSize(new java.awt.Dimension(620, 40));

		chartDescriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartDescriptionLabel.setText("Description");
		chartDescriptionLabel
				.setToolTipText("Description for the chart, displayed on screen for added information.");

		chartNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartNameLabel.setText("Name");
		chartNameLabel.setToolTipText("Name of Chart.");

		chartNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartNameTextField.setText("New Chart");

		chartDescriptionTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartDescriptionTextField.setText("An amazing chart of newness.");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel2.setText("Type");
		jLabel2.setToolTipText("Type of chart this is. Used for grouping on DM Screen.");

		chartTypeTextField.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartTypeTextField.setText("GENERAL");
		chartTypeTextField.setPreferredSize(new java.awt.Dimension(100, 20));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				chartNameLabel)
																		.addGap(26,
																				26,
																				26)
																		.addComponent(
																				chartNameTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				251,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(31,
																				31,
																				31)
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				24,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				chartTypeTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				258,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				chartDescriptionLabel)
																		.addGap(3,
																				3,
																				3)
																		.addComponent(
																				chartDescriptionTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				564,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(22, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(3,
																				3,
																				3)
																		.addComponent(
																				chartNameLabel))
														.addComponent(
																chartNameTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(3,
																				3,
																				3)
																		.addComponent(
																				jLabel2))
														.addComponent(
																chartTypeTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(3,
																				3,
																				3)
																		.addComponent(
																				chartDescriptionLabel))
														.addComponent(
																chartDescriptionTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));
		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1,
				1));

		chartAddRowButton.setBackground(new java.awt.Color(204, 204, 204));
		chartAddRowButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartAddRowButton.setText("add row");
		chartAddRowButton.setToolTipText("Append a row to the table.");
		chartAddRowButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartAddRowButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartAddRowButton);

		chartInsertRowButton.setBackground(new java.awt.Color(204, 204, 204));
		chartInsertRowButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartInsertRowButton.setText("insert row");
		chartInsertRowButton
				.setToolTipText("Insert row at the currently selected position on the table");
		chartInsertRowButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartInsertRowButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartInsertRowButton);

		chartDeleteRowsButton.setBackground(new java.awt.Color(204, 204, 204));
		chartDeleteRowsButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartDeleteRowsButton.setForeground(new java.awt.Color(204, 0, 51));
		chartDeleteRowsButton.setText("delete row(s)");
		chartDeleteRowsButton.setToolTipText("Delete selected rows.");
		chartDeleteRowsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartDeleteRowsButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartDeleteRowsButton);

		chartAddColumnButton.setBackground(new java.awt.Color(204, 204, 204));
		chartAddColumnButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartAddColumnButton.setText("add column");
		chartAddColumnButton.setToolTipText("Add a new column to the table.");
		chartAddColumnButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartAddColumnButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartAddColumnButton);

		chartDeleteColumnsButton
				.setBackground(new java.awt.Color(204, 204, 204));
		chartDeleteColumnsButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartDeleteColumnsButton.setForeground(new java.awt.Color(204, 0, 51));
		chartDeleteColumnsButton.setText("delete column");
		chartDeleteColumnsButton.setToolTipText("Delete select column.");
		chartDeleteColumnsButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartDeleteColumnsButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartDeleteColumnsButton);

		chartClearEmptyButton.setBackground(new java.awt.Color(204, 204, 204));
		chartClearEmptyButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartClearEmptyButton.setForeground(new java.awt.Color(204, 0, 0));
		chartClearEmptyButton.setText("clear empty");
		chartClearEmptyButton.setToolTipText("Clear all empty rows.");
		chartClearEmptyButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartClearEmptyButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartClearEmptyButton);

		chartClearAllButton.setBackground(new java.awt.Color(204, 204, 204));
		chartClearAllButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartClearAllButton.setForeground(new java.awt.Color(204, 0, 0));
		chartClearAllButton.setText("clear");
		chartClearAllButton
				.setToolTipText("Clear the entire table of all values.");
		chartClearAllButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartClearAllButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartClearAllButton);

		chartAutoSizeButton.setBackground(new java.awt.Color(204, 204, 204));
		chartAutoSizeButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartAutoSizeButton.setText("autosize");
		chartAutoSizeButton
				.setToolTipText("Try to resize columns setting widths to what is needed to display all cells.");
		chartAutoSizeButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						chartAutoSizeButtonActionPerformed(evt);
					}
				});
		jPanel1.add(chartAutoSizeButton);

		chartTestButton.setBackground(new java.awt.Color(204, 204, 204));
		chartTestButton.setFont(new java.awt.Font("Segoe UI", 0, 10));
		chartTestButton.setText("test");
		chartTestButton
				.setToolTipText("Test adding the chart to the DM screen.");
		chartTestButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chartTestButtonActionPerformed(evt);
			}
		});
		jPanel1.add(chartTestButton);

		jPanel4.setBackground(new java.awt.Color(204, 204, 204));
		jPanel4.setLayout(new java.awt.BorderLayout());

		chartTableScrollPane.setBackground(new java.awt.Color(204, 204, 204));

		chartTable.setModel(new MyDefaultTableModel());
		chartTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		chartTable.setColumnSelectionAllowed(true);
		chartTable.setMaximumSize(new java.awt.Dimension(10000, 10000));
		chartTableScrollPane.setViewportView(chartTable);

		jPanel4.add(chartTableScrollPane, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
						710, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jPanel2,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														638, Short.MAX_VALUE)
												.addComponent(
														jPanel3,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														638, Short.MAX_VALUE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														638, Short.MAX_VALUE))
								.addGap(72, 72, 72)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel4,
								javax.swing.GroupLayout.DEFAULT_SIZE, 382,
								Short.MAX_VALUE).addGap(47, 47, 47)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void chartDeleteColumnsButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		int nSelected = chartTable.getSelectedColumnCount();
		if (nSelected != 0) {
			if (SimpleDialog.AskYN(chartDeleteButton, String.format("%s",
					"Are you sure you want to delete the selected column?"))) {
				int nDelete = chartTable.getSelectedColumn();
				ost.dprint(String.format("Removing col (%d)\n", nDelete));
				removeColumnAndData(chartTable, nDelete);
				packColumns(chartTable, CHART_MARGIN);
			}
		}

	}

	private void chartDeleteRowsButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Utils.askToDeleteSelectedRows(chartTable, chartDeleteButton);
	}

	private void importCopyFromClipBoardButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		String importString = Utils.getClipboardContents(ost.mainFrame);
		if (importString != null) {
			importTextArea.setText(importString);
		}
	}

	private void importTXTRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		importTextArea.setWrapStyleWord(false);
		importTextArea.setLineWrap(false);
	}

	private void importOSTRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		importTextArea.setWrapStyleWord(true);
		importTextArea.setLineWrap(true);
	}

	private void chartExportCopyToClipboardButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		Utils.setClipboardContents(chartExportTextArea.getText());
		SimpleDialog.showDone("Export data in clipboard.");
	}

	private void chartExportDoneButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		exportChartExportDialog.setVisible(false);
	}

	private void chartAutoSizeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		packColumns(chartTable, CHART_MARGIN);
	}

	private void chartExportButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//TODO testing new xml import/export
		ChartClass oT = new ChartClass();
		oT = getCurrentChart(oT);
		ChartList aList = new ChartList(null);
		aList.getContent().add(oT);
		chartExportTextArea.setText(aList.xm.serializeToXML());
		exportChartExportDialog.setLocation(chartExportButton.getLocation());
		exportChartExportDialog.setVisible(true);

	}

	private void chartInsertRowButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		insertRowInTable(chartTable, false);
	}

	private void chartClearEmptyButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		clearEmptyLinesFromTable(chartTable);
	}

	/**
	 * clear empty rows that have empty slots
	 * 
	 * @param table
	 */
	public static void clearEmptyLinesFromTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int cCount = model.getColumnCount();
		int rCount = model.getRowCount();

		boolean emptyRow[] = new boolean[rCount];
		// set them all to true
		for (int i = 0; i < rCount; i++)
			emptyRow[i] = true;

		for (int column = 0; column < cCount; column++) {
			//boolean everyBoxEmpty = true;
			for (int row = 0; row < rCount; row++) {
				String testString = null;
				try {
					testString = (String) model.getValueAt(row, column);
				} catch (ClassCastException err) {
					// if it's anything but string assume it's empty
					// so leave emptyRow[row] true
				}
				//				MainClass.ddprint(
				//						String.format("clearEmptyLinesFromTable() col(%d) row(%d) value(%s)\n", 
				//								column,row, testString));
				if (testString != null && !testString.isEmpty()
						&& emptyRow[row])
					emptyRow[row] = false;
			} // end for row
		} // end for column

		for (int i = 0; i < emptyRow.length; i++)
			if (emptyRow[i]) {
				// removing row, changed up sizes so have to start over
				model.removeRow(i);
				clearEmptyLinesFromTable(table);
				break;
			}
	}

	private void chartDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (SimpleDialog.AskYN(chartDeleteButton, "Delete this chart?")) {
			ost.chartList.getContent().remove(currentChart);
			updateChartListComboBox(null);
		}
	}

	private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ChartClass oC = null;
		if (importTXTRadioButton.isSelected()) {
			oC = importTXT();
		} else if (importOSTRadioButton.isSelected()) {
			oC = importOST();
		}

		importDialog.setVisible(false);
		importTextArea.setText("");
		if (oC != null) {
			addNewChart(); // add new chart 
			loadChart(oC); // then fill it in
			currentChart = oC;
			SimpleDialog
					.showDone("Chart imported, SAVE if you want to keep it.");
		} else {
			SimpleDialog.showError("Import failed.");
		}
	}

	/**
	 * import OST export style text
	 * 
	 * @return
	 */
	private ChartClass importOST() {
		//TODO testing with new xstream xml
		ChartList aList = new ChartList(null);
		aList.xm.deserializeFromXML(importTextArea.getText());
		ChartClass oC = aList.getContent().get(0);
		return (oC);
	}

	/**
	 * import a "text" style chart from the text area
	 * and create a table with it
	 * 
	 * @return
	 */
	private ChartClass importTXT() {
		ChartClass oC = new ChartClass("IMPORT-NAME", "IMPORT-DESC");

		//int cCount = 0;
		int rCount = 0;

		String parseText = importTextArea.getText();
		String parseLineRegex = "(.+)\n";
		//		String parseValuesRegex = "[a-zA-Z/,'’ \\-\\+0-9\\(\\)%\\.;:<>\"*&`\\?†½¼#“”]+";
		String parseValuesRegex = "[ \\S]+";
		// - and + are considered barriers so can't use \\b for front and keep -2 numbers.
		String parseRegex = "(\\A|\\t)?(" + parseValuesRegex + ")(\\t|\\n)";

		Pattern checkLinePattern = Pattern.compile(parseLineRegex,
				Pattern.CASE_INSENSITIVE);
		Pattern checkPattern = Pattern.compile(parseRegex,
				Pattern.CASE_INSENSITIVE);

		Matcher checkLineMatcher = checkLinePattern.matcher(parseText);

		String thisLine;
		Matcher checkMatcher;
		boolean newValidLine = true;
		boolean firstLineAsHeaders = false;
		// flip through each line
		while (checkLineMatcher.find()) {
			int colCount = 0;
			thisLine = checkLineMatcher.group();
			ost.dprint("importButtonTXT()-line-(" + Pattern.quote(thisLine) + ")---\n");
			checkMatcher = checkPattern.matcher(thisLine);
			while (checkMatcher.find()) {
				ost.dprint("importButtonTXT()-parseLine-("
						+ Pattern.quote(checkMatcher.group().trim()) + ")---\n");
				if (checkMatcher.group(2) == null) {
					SimpleDialog
							.showError("Error processing data, strange characters or invalid format.");
					return (null);
				}
				String sG1 = checkMatcher.group(2).trim();
				if (sG1.isEmpty())
					continue;
				if (newValidLine) {
ost.dprint("rcount++\n");
					rCount++; // we don't inc rCount unless we get matches
					newValidLine = false;
				}
				ost.dprint(String.format("importButtonTXT() row[%d]=(%s) col(%d)\n",
						rCount, Pattern.quote(sG1),colCount));
				// first time through we set the values as headers
				if (rCount == 1) {
					if (colCount == 0) // only ask once
						firstLineAsHeaders = SimpleDialog.AskYN(importButton,
								"Use these values as headers?\n" + thisLine);
					if (firstLineAsHeaders)
						oC.getColumn().add(
								new ChartColumn(String.format("%s", sG1)));
					else
						oC.getColumn().add(
								new ChartColumn(String.format(
										"#%d Header, Left Click to Set",
										colCount)));
				}
				if (rCount != 1 || !firstLineAsHeaders) {
					try {
						ChartColumn column = oC.getColumn().get(colCount);
						// String sG0 = checkMatcher.group(0).trim();
						column.getRow().add(sG1);
					} catch (IndexOutOfBoundsException err) {
						SimpleDialog
								.showError("Index error (rows not all same size?)\n"
										+ err.getLocalizedMessage());
						return (null);
					}
				} // !first line or !use first line as headers
				colCount++;
			} // end find of checkPattern
				// rCount++;
			ost.dprint("newValidLine++\n");
			newValidLine = true;
		} // end checkLineMatcher find()

		return (oC);
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		importTextArea.setText("");
		importDialog.setVisible(false);
	}

	private void chartImportButtonActionPerformed(java.awt.event.ActionEvent evt) {
		importDialog.setLocation((int) chartImportButton.getLocation().getX(),
				(int) chartImportButton.getLocation().getY());
		importDialog.setVisible(true);
	}

	private void chartTestButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//addChartToDMScreen(ost.dmScreen, currentChart, true);
	}

	/**
	 * add a chart to the DM Screen tab
	 * 
	 * @param dmScreen
	 * @param oC
	 */
//	public void addChartToDMScreen(DM_Screen dmScreen, ChartClass oC,
//			boolean showScreen) {
//
//		JTabbedPane tabParentPane = dmScreen.dmScreenChartsTabbedPane;
//		JTabbedPane tabPane = null;
//		// we want to create "type" tabs in the parent panel and then
//		// add the actual chart tab to those. Search for matching tab
//		// and if not one add it otherwise use it.
//		int tabCount = tabParentPane.getTabCount();
//		for (int i = 0; i < tabCount; i++) {
//			if (tabParentPane.getTitleAt(i).equalsIgnoreCase(oC.getType())) {
//				tabPane = (JTabbedPane) tabParentPane.getComponentAt(i);
//				break;
//				//				ost.ddprint(String.format(
//				//						"addChartToDMScreen() adding chart to tab [%s]\n",
//				//						tabParentPane.getTitleAt(i)));
//			}
//		}
//		if (tabPane == null) {
//			tabPane = new JTabbedPane();
//			tabPane.setBackground(new Color(153, 153, 153));
//			tabPane.setForeground(new Color(0, 0, 0));
//			tabParentPane.addTab(oC.getType(), null, tabPane, "");
//			//			ost.ddprint(String.format(
//			//					"addChartToDMScreen() creating tab [%s] for charts.\n",
//			//					oC.getType()));
//		}
//
//		//		ost.dmScreen.dmScreenTabbedPane.addTab(
//		//				currentChart.getName(), null, cPanel, currentChart.getName());
//		Chart_Panel cPanel = new Chart_Panel(oC);
//		tabPane.add(oC.getName(), cPanel);
//		tabPane.setTabComponentAt((tabPane.getTabCount() - 1),
//				cPanel.new ButtonTabComponent(tabPane));
//
//		// make this table so that nothing can be edited and has
//		// rotating colours on rows
//		JTable newChartTable = new JTable(new DefaultTableModel()) {
//			//
//
//			public boolean isCellEditable(int rowIndex, int mColIndex) {
//				return false;
//			}
//		};
//		JTableHeader newChartHeader = newChartTable.getTableHeader();
//		newChartHeader.setDefaultRenderer(new MyHeaderRenderer());
//		newChartHeader.setPreferredSize(new Dimension(10, 60));
//		newChartTable.setRowHeight(30);
//
//		cPanel.chartLayoutPanel.add(newChartTable);
//		cPanel.chartLayoutPanel.setViewportView(newChartTable);
//		//newChartTable.setShowVerticalLines(false);
//		newChartTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//		newChartTable.getTableHeader().setReorderingAllowed(false);
//		DefaultTableModel newChartTableModel = (DefaultTableModel) newChartTable
//				.getModel();
//
//		// add the columns
//		for (ChartColumn cC : oC.getColumn())
//			newChartTableModel.addColumn(cC.getName(), cC.getRow().toArray());
//
//		// then set prefered width, can't do it while adding columns
//		int i = 0;
//		for (ChartColumn cC : oC.getColumn()) {
//			TableColumn col = (TableColumn) newChartTable.getColumnModel()
//					.getColumn(i);
//			// for some reason first row is double high, this fixes.
//			if (i == 0)
//				newChartTable.setRowHeight(
//						i,
//						(newChartTable.getRowHeight() / 2)
//								+ (newChartTable.getRowMargin() * 2));
//
//			col.setCellRenderer(new TextAreaRenderer());
//			col.setCellEditor(new TextAreaEditor());
//
//			col.setPreferredWidth(cC.getWidth());
//			i++;
//		} // end getColumn for
//
//		//		cPanel.chartLayoutPanel.add(newChartTable, java.awt.BorderLayout.CENTER);
//		if (!dmScreen.isVisible() && showScreen)
//			dmScreen.setVisible(true);
//	}

	private void chartNewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		addNewChart();
	}

	private void addNewChart() {
		ChartClass oC = new ChartClass("New Chart", "Need description.");
		ost.chartList.add(oC);
		updateChartListComboBox(oC);
		//		SimpleDialog.showDone("Added new blank chart.");
	}

	private void chartClearAllButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (SimpleDialog.AskYN(this, "Clear chart table completely?"))
			clearChart();
	}

	private void chartListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		currentChart = (ChartClass) chartListComboBox.getSelectedItem();
		if (currentChart == null) {
			//chartNewButtonActionPerformed(evt);
		} else
			loadChart(currentChart);
	}

	/**
	 * load the chart class into the displayed panel
	 * 
	 * @param oC
	 */
	private void loadChart(ChartClass oC) {
		chartNameTextField.setText(oC.getName());
		chartDescriptionTextField.setText(oC.getDescription());
		chartTypeTextField.setText(oC.getType());
		clearChart();

		for (ChartColumn cC : oC.getColumn())
			chartModel.addColumn(cC.getName(), cC.getRow().toArray());

		// can't set width/renders while adding columns, have to do it when done
		int i = 0;
		for (ChartColumn cC : oC.getColumn()) {
			TableColumn col = (TableColumn) chartTable.getColumnModel()
					.getColumn(i);

			// for some reason the first row is double high
			if (i == 0)
				chartTable.setRowHeight(i, (chartTable.getRowHeight() / 2)
						+ (chartTable.getRowMargin() * 2));

			col.setPreferredWidth(cC.getWidth());
			col.setCellRenderer(new TextAreaRenderer());
			col.setCellEditor(new TextAreaEditor());
			i++;
		} // end getColumn for
		ost.dprint(String.format("loadChart() added cols (%d)\n", i));

	}

	/**
	 * remove all columns/rows from chart
	 * 
	 */
	private void clearChart() {
		for (int row = chartTable.getRowCount(); row > 0; row--) {
			chartModel.removeRow(row - 1);
		} // end for row

		for (int col = chartTable.getColumnCount(); col > 0; col--)
			removeColumnAndData(chartTable, col - 1);

		chartTable.removeAll();
	}

	private void chartSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		currentChart = getCurrentChart(currentChart);
//		Document doc = ChartClass.xmlBuildDocFromList(ost.chartList,
//				"ChartList");
//		XMLControl.saveDoc(doc, ost.sChartFile);
		ost.chartList.xm.serializeToXMLFile();
		SimpleDialog.showDone("Saved charts to file.");
	}

	/**
	 * refresh the chart list combo box (added/removed something)
	 * 
	 * @param incChart
	 */
	private void updateChartListComboBox(ChartClass incChart) {
		currentChart = (ChartClass) chartListComboBox.getSelectedItem();
		chartListModel.removeAllElements();
		Collections.sort(ost.chartList.getContent());

		for (ChartClass oC : ost.chartList.getContent())
			chartListModel.addElement(oC);

		if (incChart != null)
			chartListComboBox.setSelectedItem(incChart);
		else if (currentChart != null)
			chartListComboBox.setSelectedItem(currentChart);
		else
			chartListComboBox
					.setSelectedIndex(chartListComboBox.getItemCount() - 1);
	}

	/**
	 * get the current chart being displayed into chart class var
	 * 
	 * @param cC
	 * @return
	 */
	private ChartClass getCurrentChart(ChartClass cC) {

		if (chartTable.getCellEditor() != null)
			chartTable.getCellEditor().stopCellEditing();

		cC = (ChartClass) chartListComboBox.getSelectedItem();
		cC.setName(chartNameTextField.getText().trim());
		cC.setDescription(chartDescriptionTextField.getText().trim());
		cC.setType(chartTypeTextField.getText().toUpperCase().trim());
		cC.getColumn().clear();
		int cCount = chartModel.getColumnCount();
		int rCount = chartModel.getRowCount();

		for (int column = 0; column < cCount; column++) {
			TableColumn tCol = chartTable.getColumnModel().getColumn(column);
			ChartColumn col = new ChartColumn(tCol.getHeaderValue().toString());
			col.setWidth(chartTable.getColumnModel().getColumn(column)
					.getWidth());
			for (int row = 0; row < rCount; row++) {
				col.getRow().add((String) chartModel.getValueAt(row, column));
			} // end for row
			cC.getColumn().add(col);
		} // end for column
		return (cC);
	}

	private void chartAddColumnButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		chartModel.addColumn(SimpleDialog.showQuestion(this, "Name of Column?",
				"New Column Name", "ColX"));
	}

	private void chartAddRowButtonActionPerformed(java.awt.event.ActionEvent evt) {
		insertRowInTable(chartTable, true);
	}

	/**
	 * insert (at selection) or append a row into a table
	 * 
	 * @param table
	 * @param appendRow
	 */
	public static void insertRowInTable(JTable table, boolean appendRow) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int cCount = model.getColumnCount();
		if (cCount > 0) {
			ArrayList<String> aList = new ArrayList<String>();
			for (int i = 0; i < cCount; i++)
				aList.add(new String(""));
			int insertRowAt = table.getSelectedRow();
			if (insertRowAt < 0 || appendRow)
				insertRowAt = table.getRowCount();
			model.insertRow(insertRowAt, aList.toArray());
		} else {
			SimpleDialog.showError("Need to have at least 1 column first.");
		}
	}

	/**
	 * Removes the specified column from the table and the associated
	 * call data from the table model.
	 * 
	 * @param table
	 * @param vColIndex
	 */
	public void removeColumnAndData(JTable table, int vColIndex) {
		MyDefaultTableModel model = (MyDefaultTableModel) table.getModel();
		//		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableColumn col = table.getColumnModel().getColumn(vColIndex);
		int columnModelIndex = col.getModelIndex();
		Vector data = model.getDataVector();
		Vector colIds = model.getColumnIdentifiers();

		// Remove the column from the table
		table.removeColumn(col);

		// Remove the column header from the table model
		colIds.removeElementAt(columnModelIndex);

		// Remove the column data
		for (int r = 0; r < data.size(); r++) {
			Vector row = (Vector) data.get(r);
			row.removeElementAt(columnModelIndex);
		}
		model.setDataVector(data, colIds);

		// Correct the model indices in the TableColumn objects
		// by decrementing those indices that follow the deleted column
		Enumeration<TableColumn> enumm = table.getColumnModel().getColumns();
		for (; enumm.hasMoreElements();) {
			TableColumn c = (TableColumn) enumm.nextElement();
			if (c.getModelIndex() >= columnModelIndex) {
				c.setModelIndex(c.getModelIndex() - 1);
			}
		}
		model.fireTableStructureChanged();
	}

	/**
	 * This subclass adds a method to retrieve the columnIdentifiers
	 * which is needed to implement the removal of
	 * column data from the table model
	 * 
	 * @author Celestian
	 *
	 */
	class MyDefaultTableModel extends DefaultTableModel {
		public Vector getColumnIdentifiers() {
			return columnIdentifiers;
		}
	}

	//	class MyTableHeaderRenderer extends JLabel implements TableCellRenderer {
	//		public Component getTableCellRendererComponent(JTable table,
	//				Object value, boolean isSelected, boolean hasFocus,
	//				int rowIndex, int vColIndex) {
	//			setText(value.toString());
	//			setToolTipText((String) value);
	//			return this;
	//		}
	//	}

	/**
	 * listener for table headers to get mouse clicks
	 * and edit the header
	 * 
	 * @author Celestian
	 *
	 */
	class ColumnListener extends MouseAdapter {
		protected JTable table;

		public ColumnListener(JTable t) {
			table = t;
		}

		public void mouseClicked(MouseEvent e) {
			TableColumnModel colModel = table.getColumnModel();
			int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
			//			int modelIndex = colModel.getColumn(columnModelIndex)
			//					.getModelIndex();
			if (columnModelIndex >= 0) {
				TableColumn tCol = table.getColumnModel().getColumn(
						columnModelIndex);
				String savedHeaderTitle = tCol.getHeaderValue().toString();
				String newHeaderTitle = SimpleDialog.showQuestion(table,
						"Enter new header value", "Change Header", tCol
								.getHeaderValue().toString());
				if (newHeaderTitle.isEmpty())
					newHeaderTitle = savedHeaderTitle;
				tCol.setHeaderValue(newHeaderTitle);
				JTableHeader header = table.getTableHeader();
				header.repaint();
			}

		}
	}

	/**
	 * renderer followed by an editor
	 * 
	 * @author Celestian
	 *
	 */
	public class TextAreaRenderer extends JTextArea implements
			TableCellRenderer {

		private final DefaultTableCellRenderer adaptee = new DefaultTableCellRenderer();
		/** map from table to map of rows to map of column heights */
		private final Map cellSizes = new HashMap();

		public TextAreaRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		public Component getTableCellRendererComponent(
				//
				JTable table, Object obj, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// set the colours, etc. using the standard for that platform
			adaptee.getTableCellRendererComponent(table, obj, isSelected,
					hasFocus, row, column);
			setForeground(adaptee.getForeground());
			setBackground(adaptee.getBackground());
			setBorder(adaptee.getBorder());
			setFont(adaptee.getFont());
			setText(adaptee.getText());

			// This line was very important to get it working with JDK1.4
			TableColumnModel columnModel = table.getColumnModel();
			setSize(columnModel.getColumn(column).getWidth(), 100000);
			int height_wanted = (int) getPreferredSize().getHeight();
			addSize(table, row, column, height_wanted);
			height_wanted = findTotalMaximumRowSize(table, row);
			if (height_wanted != table.getRowHeight(row) && row > 0) {
				table.setRowHeight(row, height_wanted);
			}

			// set alternating color on rows to yellow
			if (row % 2 == 0 && !isSelected) {
				//				setBackground(Color.yellow);
				setBackground(new Color(190, 190, 190));
			} else {
				// If not shaded, match the table's background
				setBackground(adaptee.getBackground());
			}
			return this;
		}

		private void addSize(JTable table, int row, int column, int height) {
			Map rows = (Map) cellSizes.get(table);
			if (rows == null) {
				cellSizes.put(table, rows = new HashMap());
			}
			Map rowheights = (Map) rows.get(new Integer(row));
			if (rowheights == null) {
				rows.put(new Integer(row), rowheights = new HashMap());
			}
			rowheights.put(new Integer(column), new Integer(height));
		}

		/**
		 * Look through all columns and get the renderer. If it is also a
		 * TextAreaRenderer, we look at the maximum height in its hash table for
		 * this row.
		 */
		private int findTotalMaximumRowSize(JTable table, int row) {
			int maximum_height = 0;
			Enumeration columns = table.getColumnModel().getColumns();
			while (columns.hasMoreElements()) {
				TableColumn tc = (TableColumn) columns.nextElement();
				TableCellRenderer cellRenderer = tc.getCellRenderer();
				if (cellRenderer instanceof TextAreaRenderer) {
					TextAreaRenderer tar = (TextAreaRenderer) cellRenderer;
					maximum_height = Math.max(maximum_height,
							tar.findMaximumRowSize(table, row));
				}
			}
			return maximum_height;
		}

		private int findMaximumRowSize(JTable table, int row) {
			Map rows = (Map) cellSizes.get(table);
			if (rows == null)
				return 0;
			Map rowheights = (Map) rows.get(new Integer(row));
			if (rowheights == null)
				return 0;
			int maximum_height = 0;
			for (Iterator it = rowheights.entrySet().iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				int cellHeight = ((Integer) entry.getValue()).intValue();
				maximum_height = Math.max(maximum_height, cellHeight);
			}
			return maximum_height;
		}
	}

	/**
	 * editor
	 * 
	 * @author Celestian
	 * 
	 */
	public class TextAreaEditor extends DefaultCellEditor {
		public TextAreaEditor() {
			super(new JTextField());
			final JTextArea textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setBorder(null);
			editorComponent = scrollPane;

			delegate = new DefaultCellEditor.EditorDelegate() {
				public void setValue(Object value) {
					textArea.setText((value != null) ? value.toString() : "");
				}

				public Object getCellEditorValue() {
					return textArea.getText();
				}
			};
		}
	}

	/**
	 * header renderer for tables to wrap 
	 * @author Celestian
	 *
	 */

	public class MyHeaderRenderer extends DefaultTableCellRenderer {
		private final DefaultTableCellRenderer adaptee = new DefaultTableCellRenderer();

		//		private final DefaultTableCellHeaderRenderer adaptee = new DefaultTableCellHeaderRenderer();
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int col) {

			JTextArea area = new JTextArea();
			area.setToolTipText("left click to edit");
			area.setEditable(false);
			area.setWrapStyleWord(true);
			area.setLineWrap(true);
			area.setText(value.toString());

			adaptee.getTableCellRendererComponent(table, value, isSelected,
					hasFocus, row, col);
			area.setForeground(adaptee.getForeground());
			//area.setBackground(adaptee.getBackground());
			//area.setBorder(adaptee.getBorder());
			//			area.setBorder(new javax.swing.border.LineBorder(
			//					new java.awt.Color(0, 0, 0), 1, true));
			area.setBackground(new Color(220, 220, 220));
			area.setBorder(new javax.swing.border.BevelBorder(
					BevelBorder.RAISED));
			area.setFont(adaptee.getFont());

			return area;
		}
	}

	/**
	 * pack columns using margin 
	 * 
	 * @param table
	 * @param margin
	 */
	public void packColumns(JTable table, int margin) {
		for (int c = 0; c < table.getColumnCount(); c++) {
			packColumn(table, c, margin);
		}
	}

	/**
	 * set width of column to reasonable value
	 * 
	 * @param table
	 * @param vColIndex
	 * @param margin
	 */
	public void packColumn(JTable table, int vColIndex, int margin) {
		DefaultTableColumnModel colModel = (DefaultTableColumnModel) table
				.getColumnModel();
		TableColumn col = colModel.getColumn(vColIndex);

		String hv = col.getHeaderValue().toString();
		JTableHeader th = table.getTableHeader();
		FontMetrics fm = th.getFontMetrics(th.getFont());
		col.setPreferredWidth(fm.stringWidth(hv) + (margin * 4));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton chartAddColumnButton;
	private javax.swing.JButton chartAddRowButton;
	private javax.swing.JButton chartAutoSizeButton;
	private javax.swing.JButton chartClearAllButton;
	private javax.swing.JButton chartClearEmptyButton;
	private javax.swing.JButton chartDeleteButton;
	private javax.swing.JButton chartDeleteColumnsButton;
	private javax.swing.JButton chartDeleteRowsButton;
	private javax.swing.JLabel chartDescriptionLabel;
	private javax.swing.JTextField chartDescriptionTextField;
	private javax.swing.JButton chartExportButton;
	private javax.swing.JButton chartExportCopyToClipboardButton;
	private javax.swing.JButton chartExportDoneButton;
	private javax.swing.JTextArea chartExportTextArea;
	private javax.swing.JButton chartImportButton;
	private javax.swing.JButton chartInsertRowButton;
	private javax.swing.JComboBox chartListComboBox;
	private javax.swing.JLabel chartNameLabel;
	private javax.swing.JTextField chartNameTextField;
	private javax.swing.JButton chartNewButton;
	private javax.swing.JButton chartSaveButton;
	private javax.swing.JTable chartTable;
	private javax.swing.JScrollPane chartTableScrollPane;
	private javax.swing.JButton chartTestButton;
	private javax.swing.JTextField chartTypeTextField;
	private javax.swing.JDialog exportChartExportDialog;
	private javax.swing.JButton importButton;
	private javax.swing.ButtonGroup importButtonGroup;
	private javax.swing.JButton importCopyFromClipBoardButton;
	private javax.swing.JDialog importDialog;
	private javax.swing.JRadioButton importOSTRadioButton;
	private javax.swing.JRadioButton importTXTRadioButton;
	private javax.swing.JTextArea importTextArea;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane4;
	// End of variables declaration//GEN-END:variables

	private MainClass ost;
	private DefaultTableModel chartModel;
	private DefaultComboBoxModel chartListModel;
	private ChartClass currentChart;
	private JTableHeader chartHeader;
}