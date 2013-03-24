/*
 * MainWindow.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.jdom.Document;
import org.ost.main.MyClasses.AbilityStatClass;
import org.ost.main.MyClasses.AlignmentClass;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.EquipmentList;
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.NonWeaponProfClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyClasses.StatesClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.Utils;
import org.ost.main.MyUtils.XMLControl;

/**
 *
 * @author  __USER__
 */
public class MainWindow extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	/** Creates new form MainWindow */
	public MainWindow(MainClass ost) {
		this.ost = ost;
		initComponents();
		currentStatesAddObject = null;
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		aboutPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		aboutTextArea = new javax.swing.JTextArea();
		jPanel1 = new javax.swing.JPanel();
		aboutEmailLabel = new javax.swing.JLabel();
		aboutUrlLabel = new javax.swing.JLabel();
		jPanel10 = new javax.swing.JPanel();
		aboutIconLabel = new javax.swing.JLabel();
		mainProgressFrame = new javax.swing.JFrame();
		mainProgressBar = new javax.swing.JProgressBar();
		mainProgressBar.setIndeterminate(true);
		settingsDialog = new javax.swing.JDialog();
		bannerPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		detailsPanel = new javax.swing.JPanel();
		initPanel = new javax.swing.JPanel();
		initDiceFormattedTextField = new javax.swing.JFormattedTextField();
		initDiceLabel = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		initAscendingRadioButton = new javax.swing.JRadioButton();
		initDescendingRadioButton = new javax.swing.JRadioButton();
		initAscendLabel = new javax.swing.JLabel();
		initGroupRadioButton = new javax.swing.JRadioButton();
		initGroupLabel = new javax.swing.JLabel();
		matrixSettingsPanel = new javax.swing.JPanel();
		d20ModeRadioButton = new javax.swing.JRadioButton();
		d20ModeLabel = new javax.swing.JLabel();
		thacoModeRadioButton = new javax.swing.JRadioButton();
		thacoModeLabel = new javax.swing.JLabel();
		buttonPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();
		initTypebuttonGroup = new javax.swing.ButtonGroup();
		statesAddDialog = new javax.swing.JDialog();
		jPanel7 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		statesDescriptionTextArea = new javax.swing.JTextArea();
		jLabel4 = new javax.swing.JLabel();
		stateNameTextField = new javax.swing.JTextField();
		jPanel8 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		statesListModel = new DefaultListModel();
		statesJList = new javax.swing.JList(statesListModel);
		statesJList.setCellRenderer(new MyCellRendererList());
		jPanel9 = new javax.swing.JPanel();
		deleteStatesButton = new javax.swing.JButton();
		newStatesButton = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		finishedStatesButton = new javax.swing.JButton();
		addStatesButton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		stateAddSpinner = new javax.swing.JSpinner();
		mainWindowScrollPane = new javax.swing.JScrollPane();
		mainTabbedPane = new javax.swing.JTabbedPane();
		mainMenuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		settingsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		testMenuItem = new javax.swing.JMenuItem();
		optionsMenu = new javax.swing.JMenu();
		mainShowEncounterMenuItem = new javax.swing.JMenuItem();
		mainShowDMScreenMenuItem = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JSeparator();
		aboutMenu = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();

		aboutPanel.setBackground(new java.awt.Color(204, 204, 204));
		aboutPanel.setLayout(new java.awt.BorderLayout());

		jScrollPane1.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));

		aboutTextArea.setBackground(new java.awt.Color(204, 204, 204));
		aboutTextArea.setColumns(20);
		aboutTextArea.setEditable(false);
		aboutTextArea.setLineWrap(true);
		aboutTextArea.setRows(5);
		aboutTextArea.setWrapStyleWord(true);
		jScrollPane1.setViewportView(aboutTextArea);

		aboutPanel.add(jScrollPane1, java.awt.BorderLayout.EAST);

		jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
				0, 0, 0), 1, true));

		aboutEmailLabel.setText("Email@address.com");
		aboutEmailLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				aboutEmailLabelMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				aboutEmailLabelMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				aboutEmailLabelMousePressed(evt);
			}
		});

		aboutUrlLabel.setText("url:");
		aboutUrlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				aboutUrlLabelMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				aboutUrlLabelMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				aboutUrlLabelMousePressed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																aboutEmailLabel)
														.addComponent(
																aboutUrlLabel))
										.addContainerGap(283, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(aboutEmailLabel)
						.addComponent(aboutUrlLabel).addContainerGap()));

		aboutPanel.add(jPanel1, java.awt.BorderLayout.PAGE_END);

		jPanel10.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));

		aboutIconLabel.setBackground(new java.awt.Color(153, 153, 153));
		aboutIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		aboutIconLabel.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/ostgraphic.png"))); // NOI18N

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 254, Short.MAX_VALUE)
						.addGroup(
								jPanel10Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel10Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addComponent(
																aboutIconLabel)
														.addGap(0, 0,
																Short.MAX_VALUE))));
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 329, Short.MAX_VALUE)
						.addGroup(
								jPanel10Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel10Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addComponent(
																aboutIconLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																307,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0,
																Short.MAX_VALUE))));

		aboutPanel.add(jPanel10, java.awt.BorderLayout.WEST);

		mainProgressFrame.setAlwaysOnTop(true);
		mainProgressFrame.setUndecorated(true);
		mainProgressFrame.getContentPane().setLayout(
				new javax.swing.BoxLayout(mainProgressFrame.getContentPane(),
						javax.swing.BoxLayout.LINE_AXIS));

		mainProgressBar.setForeground(new java.awt.Color(204, 0, 51));
		mainProgressBar.setIndeterminate(true);
		mainProgressBar.setMinimumSize(new java.awt.Dimension(400, 20));
		mainProgressBar.setPreferredSize(new java.awt.Dimension(400, 20));
		mainProgressBar.setStringPainted(true);
		mainProgressFrame.getContentPane().add(mainProgressBar);

		settingsDialog.setTitle("Settings");
		settingsDialog.setAlwaysOnTop(true);
		settingsDialog.setMinimumSize(new java.awt.Dimension(510, 380));

		bannerPanel.setBackground(new java.awt.Color(204, 204, 204));
		bannerPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15));
		jLabel1.setText("OST Configuration");
		bannerPanel.add(jLabel1);

		settingsDialog.getContentPane().add(bannerPanel,
				java.awt.BorderLayout.PAGE_START);

		detailsPanel.setBackground(new java.awt.Color(255, 255, 255));
		detailsPanel
				.setBorder(javax.swing.BorderFactory.createTitledBorder(
						javax.swing.BorderFactory
								.createBevelBorder(javax.swing.border.BevelBorder.LOWERED),
						"Options"));
		detailsPanel.setLayout(new java.awt.GridBagLayout());

		initPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Initiative Settings",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		initPanel.setLayout(new java.awt.GridBagLayout());

		initDiceFormattedTextField.setBackground(new java.awt.Color(204, 204,
				204));
		initDiceFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));
		initDiceFormattedTextField
				.setFont(new java.awt.Font("Segoe UI", 0, 15));
		initDiceFormattedTextField
				.setMinimumSize(new java.awt.Dimension(46, 27));
		initDiceFormattedTextField.setPreferredSize(new java.awt.Dimension(46,
				27));
		initDiceFormattedTextField.setValue(new Integer(ost.initDice));
		initDiceFormattedTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						initDiceFormattedTextFieldPropertyChange(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
		initPanel.add(initDiceFormattedTextField, gridBagConstraints);

		initDiceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		initDiceLabel.setText("- Initiative dice size.");
		initDiceLabel
				.setToolTipText("The size of dice to use when rolling initiative.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		initPanel.add(initDiceLabel, gridBagConstraints);

		jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0,
				5));

		initTypebuttonGroup.add(initAscendingRadioButton);
		initAscendingRadioButton.setSelected(true);
		initAscendingRadioButton.setText("Ascend");
		initAscendingRadioButton
				.setToolTipText("Set to use ascending initiative (1,2,3,4...)");
		initAscendingRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						initAscendingRadioButtonActionPerformed(evt);
					}
				});
		jPanel5.add(initAscendingRadioButton);

		initTypebuttonGroup.add(initDescendingRadioButton);
		initDescendingRadioButton.setText("Descend");
		initDescendingRadioButton
				.setToolTipText("Set to use descending initiative (10,9,8,7...)");
		initDescendingRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						initDescendingRadioButtonActionPerformed(evt);
					}
				});
		jPanel5.add(initDescendingRadioButton);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		initPanel.add(jPanel5, gridBagConstraints);

		initAscendLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		initAscendLabel
				.setText("- Set ascending or descending initiative order.");
		initAscendLabel
				.setToolTipText("Set ascending or descending initiative order.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		initPanel.add(initAscendLabel, gridBagConstraints);

		initGroupRadioButton.setText("Group Initiative");
		initGroupRadioButton
				.setToolTipText("When rolling initiative, do once for all Players and once for all NPCs.");
		initGroupRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						initGroupRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		initPanel.add(initGroupRadioButton, gridBagConstraints);

		initGroupLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		initGroupLabel
				.setText("- Players and Monsters have one initiative roll.");
		initGroupLabel
				.setToolTipText("When rolling initiative, do once for all Players and once for all NPCs.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		initPanel.add(initGroupLabel, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		detailsPanel.add(initPanel, gridBagConstraints);

		matrixSettingsPanel.setBackground(new java.awt.Color(204, 204, 204));
		matrixSettingsPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 1, true),
						"Matrix Settings",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Segoe UI", 0, 10)));
		matrixSettingsPanel.setLayout(new java.awt.GridBagLayout());

		d20ModeRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		d20ModeRadioButton.setText("D20 Mode (optional)");
		d20ModeRadioButton
				.setToolTipText("Use Ascending AC and Base Attack Bonus (calculated from decending AC and THACO values).");
		d20ModeRadioButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		d20ModeRadioButton
				.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
		d20ModeRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						d20ModeRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		matrixSettingsPanel.add(d20ModeRadioButton, gridBagConstraints);

		d20ModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		d20ModeLabel.setText("- Use Ascending AC and Base Attack Bonus.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 10.0;
		matrixSettingsPanel.add(d20ModeLabel, gridBagConstraints);

		thacoModeRadioButton.setBackground(new java.awt.Color(204, 204, 204));
		thacoModeRadioButton.setText("THACO Mode (optional)");
		thacoModeRadioButton.setToolTipText("Use THACO mode, 2e game style.");
		thacoModeRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thacoModeRadioButtonActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		matrixSettingsPanel.add(thacoModeRadioButton, gridBagConstraints);

		thacoModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		thacoModeLabel.setText("- Use v2 THACO for attack rolls.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 10.0;
		matrixSettingsPanel.add(thacoModeLabel, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		detailsPanel.add(matrixSettingsPanel, gridBagConstraints);

		settingsDialog.getContentPane().add(detailsPanel,
				java.awt.BorderLayout.CENTER);

		buttonPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		doneButton.setBackground(new java.awt.Color(204, 204, 204));
		doneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		doneButton.setText("close");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(doneButton);

		settingsDialog.getContentPane().add(buttonPanel,
				java.awt.BorderLayout.PAGE_END);

		statesAddDialog.setTitle("Add State to Creature/Player");
		statesAddDialog.setAlwaysOnTop(true);
		statesAddDialog.setMinimumSize(new java.awt.Dimension(357, 410));

		jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Add State",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));
		jPanel7.setPreferredSize(new java.awt.Dimension(300, 200));

		jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));
		jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Description",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 10)));

		statesDescriptionTextArea.setBackground(new java.awt.Color(204, 204,
				204));
		statesDescriptionTextArea.setColumns(20);
		statesDescriptionTextArea.setLineWrap(true);
		statesDescriptionTextArea.setRows(5);
		statesDescriptionTextArea.setWrapStyleWord(true);
		jScrollPane2.setViewportView(statesDescriptionTextArea);

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14));
		jLabel4.setText("Name");

		stateNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
		stateNameTextField.setText("state name");
		stateNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				stateNameTextFieldKeyReleased(evt);
			}
		});

		jPanel8.setBackground(new java.awt.Color(204, 204, 204));
		jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "States"));
		jPanel8.setLayout(new java.awt.BorderLayout());

		statesJList.setBackground(new java.awt.Color(204, 204, 204));
		statesJList.setModel(statesListModel);
		statesJList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						statesJListValueChanged(evt);
					}
				});
		jScrollPane3.setViewportView(statesJList);

		jPanel8.add(jScrollPane3, java.awt.BorderLayout.CENTER);

		jPanel9.setBackground(new java.awt.Color(204, 204, 204));

		deleteStatesButton.setFont(new java.awt.Font("Segoe UI", 0, 9));
		deleteStatesButton.setText("delete");
		deleteStatesButton.setToolTipText("Delete state from list.");
		deleteStatesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteStatesButtonActionPerformed(evt);
					}
				});
		jPanel9.add(deleteStatesButton);

		newStatesButton.setFont(new java.awt.Font("Segoe UI", 0, 9));
		newStatesButton.setText("new");
		newStatesButton.setToolTipText("Create new state.");
		newStatesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newStatesButtonActionPerformed(evt);
			}
		});
		jPanel9.add(newStatesButton);

		jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_END);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(53, 53, 53)
										.addComponent(
												jPanel8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				stateNameTextField,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				45,
																				Short.MAX_VALUE))
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																87,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(17, 17, 17)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jPanel8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																242,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								stateNameTextField,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane2)))
										.addContainerGap()));

		statesAddDialog.getContentPane().add(jPanel7,
				java.awt.BorderLayout.CENTER);

		jPanel6.setBackground(new java.awt.Color(204, 204, 204));
		jPanel6.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		finishedStatesButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
		finishedStatesButton.setText("finished");
		finishedStatesButton.setToolTipText("Close window.");
		finishedStatesButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						finishedStatesButtonActionPerformed(evt);
					}
				});
		jPanel6.add(finishedStatesButton);

		addStatesButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
		addStatesButton.setText("add");
		addStatesButton
				.setToolTipText("Add state effect to player or creature.");
		addStatesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStatesButtonActionPerformed(evt);
			}
		});
		jPanel6.add(addStatesButton);

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10));
		jLabel3.setText("Duration");
		jLabel3.setToolTipText("Duration, in rounds, for this state to last.");
		jPanel6.add(jLabel3);

		stateAddSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100,
				1));
		jPanel6.add(stateAddSpinner);

		statesAddDialog.getContentPane().add(jPanel6,
				java.awt.BorderLayout.PAGE_END);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Old School Tool");
		setBackground(new java.awt.Color(204, 204, 204));
		setBounds(new java.awt.Rectangle(0, 0, 1050, 800));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		mainWindowScrollPane.setViewportView(mainTabbedPane);

		getContentPane()
				.add(mainWindowScrollPane, java.awt.BorderLayout.CENTER);

		fileMenu.setText("File");

		settingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.ALT_MASK));
		settingsMenuItem.setText("Settings");
		settingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				settingsMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(settingsMenuItem);

		exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.ALT_MASK));
		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);
		fileMenu.add(jSeparator1);

		testMenuItem.setText("Test");
		testMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				testMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(testMenuItem);

		mainMenuBar.add(fileMenu);

		optionsMenu.setText("Windows");

		mainShowEncounterMenuItem.setAccelerator(javax.swing.KeyStroke
				.getKeyStroke(java.awt.event.KeyEvent.VK_E,
						java.awt.event.InputEvent.ALT_MASK));
		mainShowEncounterMenuItem.setText("Encounter Panel");
		mainShowEncounterMenuItem
				.setToolTipText("Open encounter panel if not already opened.");
		mainShowEncounterMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainShowEncounterMenuItemActionPerformed(evt);
					}
				});
		optionsMenu.add(mainShowEncounterMenuItem);

		mainShowDMScreenMenuItem.setAccelerator(javax.swing.KeyStroke
				.getKeyStroke(java.awt.event.KeyEvent.VK_H,
						java.awt.event.InputEvent.ALT_MASK));
		mainShowDMScreenMenuItem.setText("DM Screen");
		mainShowDMScreenMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainShowDMScreenMenuItemActionPerformed(evt);
					}
				});
		optionsMenu.add(mainShowDMScreenMenuItem);
		optionsMenu.add(jSeparator2);

		mainMenuBar.add(optionsMenu);

		aboutMenu.setText("Help");

		aboutMenuItem.setText("About");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		aboutMenu.add(aboutMenuItem);

		mainMenuBar.add(aboutMenu);

		setJMenuBar(mainMenuBar);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void testMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code h
		for (AbilityStatClass oA : ost.abilityStatList.getContent()) {
			//			AbilityStatClass oA = (AbilityStatClass) oO;
			ost.dprint(oA.strength.name + " " + oA.strength.score + "\n");
			ost.dprint(oA.strength.name + " " + oA.strength.numDiceOpenDoor
					+ "\n");
			ost.dprint(oA.strength.name + " " + oA.strength.sizeDiceOpenDoor
					+ "\n");

			ost.dprint(oA.charisma.name + " " + oA.charisma.score + "\n");
			ost.dprint(oA.consitution.name + " " + oA.consitution.score + "\n");
			ost.dprint(oA.dexterity.name + " " + oA.dexterity.score + "\n");
			ost.dprint(oA.intelligence.name + " " + oA.intelligence.score
					+ "\n");
			ost.dprint(oA.wisdom.name + " " + oA.wisdom.score + "\n");
		}

		//		for (AlignmentClass oA: ost.alignments) {
		//			ost.dprint("Alignment:"+oA.getName()+"["+oA.getAbbreviation()+"]\n");
		//		}

		for (EquipmentClass oE : ost.equipmentList.getContent()) {
			ost.dprint("Gear:" + oE.getName() + "\n");
		}

		for (NonWeaponProfClass oN : ost.nonWeaponProfList.getContent()) {
			ost.dprint("NWP:" + oN.getName() + "\n");
		}

		String sTest = ost.creatureList.xm.getSerialXML(ost.creatureList
				.getContent().get(1));
		ost.dprint("Creature 1, XML:" + sTest + "\n");
	}

	private void stateNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
		updateCurrentStateFields();
	}

	private void initGroupRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (initGroupRadioButton.isSelected())
			ost.initGroup = true;
		else
			ost.initGroup = false;
	}

	private void deleteStatesButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		StatesClass oS = (StatesClass) statesJList.getSelectedValue();
		if (oS != null) {
			statesListModel.removeElement(oS);
			ost.statesList.getContent().remove(oS);
		}
	}

	private void statesJListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {
		StatesClass oS = (StatesClass) statesJList.getSelectedValue();
		if (oS != null && previousState != null) {
			previousState.setName(stateNameTextField.getText());
			previousState.setDescription(statesDescriptionTextArea.getText());
		}
		if (oS != null) {
			stateNameTextField.setText(oS.getName());
			statesDescriptionTextArea.setText(oS.getDescription());
			previousState = oS;
		}
	}

	private void newStatesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		StatesClass oNew = new StatesClass("New", "Enter state description");
		ost.statesList.add(oNew);
		updateStatesList();
		statesJList.setSelectedValue(oNew, true);
	}

	/** 
	 * add states to pc or npc object
	 * 
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void addStatesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (currentStatesAddObject != null) {
			int nCounter = Integer.parseInt(stateAddSpinner.getValue()
					.toString());
			StatesClass oS = (StatesClass) statesJList.getSelectedValue();
			StatesClass oN = new StatesClass(oS.getName(), oS.getDescription(),
					nCounter, -1);
			// is it a player?
			if (Utils.isPC(currentStatesAddObject)) {
				PlayerClass oP = (PlayerClass) currentStatesAddObject;
				oP.getStates().add(oN);
				// remove existing, we're replacing.
				oP.Encountered.modelStatesListForCombatPanel
						.removeAllElements();
				Collections.sort(oP.getStates());
				for (StatesClass oE : oP.getStates()) {
					oE.setbSmallFont(true); // set this to true so small font is used.
					oP.Encountered.modelStatesListForCombatPanel.addElement(oE);
				} // end for
			} else // this is creature 
			if (Utils.isNPC(currentStatesAddObject)) {
				CreatureClass oP = (CreatureClass) currentStatesAddObject;
				oP.getStates().add(oN);
				// remove existing, we're replacing.
				oP.Encountered.modelStatesListForCombatPanel
						.removeAllElements();
				Collections.sort(oP.getStates());
				for (StatesClass oE : oP.getStates()) {
					oE.setbSmallFont(true); // set this to true so small font is used.
					oP.Encountered.modelStatesListForCombatPanel.addElement(oE);
				} // end for
			}
		}
		currentStatesAddObject = null;
		statesAddDialog.setVisible(false);
	}

	/**
	 * 
	 */
	public void updateStatesList() {
		statesListModel.removeAllElements();
		Collections.sort(ost.statesList.getContent(), new StateSortByName());
		for (StatesClass oC : ost.statesList.getContent()) {
			statesListModel.addElement(oC);
		} // end for
	}

	void finishedStatesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		statesAddDialog.setVisible(false);
		updateCurrentStateFields();
		//saveStatesToFile();
	}

	private void updateCurrentStateFields() {
		StatesClass oS = (StatesClass) statesJList.getSelectedValue();
		if (oS != null) {
			oS.setName(stateNameTextField.getText());
			oS.setDescription(statesDescriptionTextArea.getText());
		}
		statesJList.repaint();
	}

	//	private void saveStatesToFile() {
	//		Document doc = StatesClass.xmlBuildDocFromList(ost.statesList,
	//				"StatesList");
	//		XMLControl.saveDoc(doc, ost.sStatesListFile);
	//	}

	private void initDescendingRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		ost.initAscending = initAscendingRadioButton.isSelected();
	}

	private void initAscendingRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		ost.initAscending = initAscendingRadioButton.isSelected();
	}

	private void initDiceFormattedTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		if (settingsDialog.isVisible()) {
			int initDiceSize = Integer.parseInt(initDiceFormattedTextField
					.getValue().toString());
			if (initDiceSize > 0) {
				ost.initDice = initDiceSize;
				SimpleDialog.showDone("Initiative dice size set to 1d"
						+ ost.initDice);
			} else {
				initDiceFormattedTextField.setValue(ost.initDice);
			}
		}
	}

	private void thacoModeRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (thacoModeRadioButton.isSelected())
			d20ModeRadioButton.setSelected(false);
	}

	private void d20ModeRadioButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (d20ModeRadioButton.isSelected())
			thacoModeRadioButton.setSelected(false);
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		settingsDialog.setVisible(false);
	}

	public void formWindowClosing(java.awt.event.WindowEvent evt) {
		//TODO save all files on exit
		ost.saveSettings();
		ost.dmConfigTab.tabCreatureConfig.saveCreaturesToFile();
		ost.dmConfigTab.tabPlayers.savePlayersToFile();
		ost.abilityStatList.xm.serializeToXMLFile();
		ost.raceList.xm.serializeToXMLFile();
		ost.nonWeaponProfList.xm.serializeToXMLFile();
		ost.WeaponProfList.xm.serializeToXMLFile();
		ost.equipmentList.xm.serializeToXMLFile();
		ost.statesList.xm.serializeToXMLFile();
		ost.chartList.xm.serializeToXMLFile();
		ost.tableList.xm.serializeToXMLFile();
		ost.extraAbilitiesList.xm.serializeToXMLFile();
		ost.characterClassList.xm.serializeToXMLFile();
	}

	private void settingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		settingsDialog.setLocationRelativeTo(null);
		settingsDialog.setVisible(true);
	}

	private void mainShowDMScreenMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (!ost.dmScreen.isVisible())
			ost.dmScreen.setVisible(true);
	}

	private void mainShowEncounterMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		if (!ost.encounterFrame.isVisible())
			ost.encounterFrame.setVisible(true);
	}

	private void aboutEmailLabelMousePressed(java.awt.event.MouseEvent evt) {
		String email = "mailto:" + ost.aboutEmail;
		try {
			java.awt.Desktop.getDesktop().mail(java.net.URI.create(email));
		} catch (IOException e) {
			SimpleDialog.showError(e.getLocalizedMessage());
		}

	}

	private void aboutEmailLabelMouseExited(java.awt.event.MouseEvent evt) {
		aboutEmailLabel.setForeground(Color.black);
	}

	private void aboutEmailLabelMouseEntered(java.awt.event.MouseEvent evt) {
		aboutEmailLabel.setForeground(Color.blue);
	}

	private void aboutUrlLabelMouseExited(java.awt.event.MouseEvent evt) {
		aboutUrlLabel.setForeground(Color.black);
	}

	private void aboutUrlLabelMouseEntered(java.awt.event.MouseEvent evt) {
		aboutUrlLabel.setForeground(Color.BLUE);
	}

	private void aboutUrlLabelMousePressed(java.awt.event.MouseEvent evt) {
		String url = ost.aboutURL;
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException e) {
			SimpleDialog.showError(e.getLocalizedMessage());
		}
	}

	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		aboutEmailLabel.setText("Email: " + ost.aboutEmail);
		aboutUrlLabel.setText(ost.aboutURL);
		String sAbout = String
				.format("OST v%s, %s\n"
						+ "\nI've enjoyed all my years playing RPGs. "
						+ "Thank you Gary, Dave and everyone who throughout "
						+ "the years made the game what it is and those like "
						+ "" + "OSRIC who have reinvigorated it."
						+ "\n\nDungeons & Dragons TM, Advanced Dungeons & Dragons TM, D&D TM and AD&D TM are owned by Wizards of the Coast and their use here is not intended as a challenge to their ownership of that copyright.\n", 
						ost.version,
						ost.dateName);
		aboutTextArea.setText(sAbout);

		JOptionPane.showMessageDialog(null, aboutPanel, "About - OST",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		ost.mainFrame.formWindowClosing(null);
		System.exit(0);
	}

	/**
	 * sort StatesClass by name
	 * 
	 */
	static class StateSortByName implements Comparator<StatesClass> {
		public int compare(StatesClass o1, StatesClass o2) {
			return o1.name.toUpperCase().compareTo((o2).name.toUpperCase());
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel aboutEmailLabel;
	private javax.swing.JLabel aboutIconLabel;
	private javax.swing.JMenu aboutMenu;
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JPanel aboutPanel;
	private javax.swing.JTextArea aboutTextArea;
	private javax.swing.JLabel aboutUrlLabel;
	private javax.swing.JButton addStatesButton;
	private javax.swing.JPanel bannerPanel;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JLabel d20ModeLabel;
	public javax.swing.JRadioButton d20ModeRadioButton;
	private javax.swing.JButton deleteStatesButton;
	private javax.swing.JPanel detailsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JButton finishedStatesButton;
	private javax.swing.JLabel initAscendLabel;
	public javax.swing.JRadioButton initAscendingRadioButton;
	public javax.swing.JRadioButton initDescendingRadioButton;
	public javax.swing.JFormattedTextField initDiceFormattedTextField;
	private javax.swing.JLabel initDiceLabel;
	private javax.swing.JLabel initGroupLabel;
	public javax.swing.JRadioButton initGroupRadioButton;
	private javax.swing.JPanel initPanel;
	private javax.swing.ButtonGroup initTypebuttonGroup;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JMenuBar mainMenuBar;
	public javax.swing.JProgressBar mainProgressBar;
	public javax.swing.JFrame mainProgressFrame;
	private javax.swing.JMenuItem mainShowDMScreenMenuItem;
	private javax.swing.JMenuItem mainShowEncounterMenuItem;
	public javax.swing.JTabbedPane mainTabbedPane;
	private javax.swing.JScrollPane mainWindowScrollPane;
	private javax.swing.JPanel matrixSettingsPanel;
	private javax.swing.JButton newStatesButton;
	private javax.swing.JMenu optionsMenu;
	private javax.swing.JDialog settingsDialog;
	private javax.swing.JMenuItem settingsMenuItem;
	private javax.swing.JSpinner stateAddSpinner;
	private javax.swing.JTextField stateNameTextField;
	public javax.swing.JDialog statesAddDialog;
	private javax.swing.JTextArea statesDescriptionTextArea;
	public javax.swing.JList statesJList;
	private javax.swing.JMenuItem testMenuItem;
	private javax.swing.JLabel thacoModeLabel;
	public javax.swing.JRadioButton thacoModeRadioButton;
	// End of variables declaration//GEN-END:variables
	private MainClass ost;
	public DefaultListModel statesListModel;
	public Object currentStatesAddObject;
	private StatesClass previousState;

}