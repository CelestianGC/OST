/*
 * DM_Screen.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.ost.main.MyClasses.ChartClass;
import org.ost.main.MyClasses.ChartColumn;
import org.ost.main.MyClasses.TableClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
public class DM_Screen extends javax.swing.JFrame {

	/** Creates new form DM_Screen */
	public DM_Screen(MainClass ost) {
		this.ost = ost;
		initComponents();
		// set start location to middle of screen
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(700, 650));
		setSize(getPreferredSize());
		UIManager.put("TabbedPane.selected", Color.WHITE);
		//SwingUtilities.updateComponentTreeUI(dmScreenTabbedPane);

		// set colors on the tree
		chartsCell = (DefaultTreeCellRenderer) chartsTree.getCellRenderer();
		chartsCell.setTextSelectionColor(new Color(51, 255, 0));
		chartsCell.setTextNonSelectionColor(new Color(255, 255, 255));
		chartsCell.setBackgroundNonSelectionColor(Color.BLACK);
		chartsCell.setBackgroundSelectionColor(Color.BLACK);

		// load all charts at start up
		loadAll(false);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		dmScreenWindowScrollPane = new javax.swing.JScrollPane();
		dmScreenTabbedPane = new javax.swing.JTabbedPane();
		dmScreenChartsSplitPane = new javax.swing.JSplitPane();
		chartsTreeScrollPane = new javax.swing.JScrollPane();
		chartsRootNode = new DefaultMutableTreeNode("Charts");
		//chartsTreeModel = new DefaultTreeModel(dungeonsRootNode);
		chartsTreeModel = new DefaultTreeModel(chartsRootNode);
		chartsTree = new javax.swing.JTree();
		chartsTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		chartsTablePanel = new javax.swing.JPanel();
		dmScreenTablesTabbedPane = new javax.swing.JTabbedPane();
		screenMenuBar = new javax.swing.JMenuBar();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		screenLoadChartsMenuItem = new javax.swing.JMenuItem();
		screenRemoveAllChartsMenuItem = new javax.swing.JMenuItem();

		setTitle("DM Screen");
		setMinimumSize(new java.awt.Dimension(400, 250));

		dmScreenTabbedPane.setBackground(new java.awt.Color(224, 224, 224));
		dmScreenTabbedPane.setMinimumSize(new java.awt.Dimension(600, 450));
		dmScreenTabbedPane.setPreferredSize(new java.awt.Dimension(600, 450));

		dmScreenChartsSplitPane.setDividerLocation(200);

		chartsTree.setBackground(new java.awt.Color(0, 0, 0));
		chartsTree.setToolTipText("Left click on a chart to view it.");
		chartsTree.setCellRenderer(new chartsCellRendererTree());
		chartsTree.setModel(chartsTreeModel);
		chartsTree.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				chartsTreeMousePressed(evt);
			}
		});
		chartsTreeScrollPane.setViewportView(chartsTree);

		dmScreenChartsSplitPane.setLeftComponent(chartsTreeScrollPane);

		chartsTablePanel.setBackground(new java.awt.Color(153, 153, 153));
		chartsTablePanel.setLayout(new java.awt.BorderLayout());
		dmScreenChartsSplitPane.setRightComponent(chartsTablePanel);

		dmScreenTabbedPane.addTab("Charts", new javax.swing.ImageIcon(
				getClass().getResource("/images/16X-Compass-icon.png")),
				dmScreenChartsSplitPane, "Charts in tree form."); // NOI18N

		dmScreenTablesTabbedPane
				.setBackground(new java.awt.Color(183, 183, 183));
		dmScreenTabbedPane.addTab("Tables", new javax.swing.ImageIcon(
				getClass().getResource("/images/16X-d8-icon.png")),
				dmScreenTablesTabbedPane); // NOI18N

		dmScreenWindowScrollPane.setViewportView(dmScreenTabbedPane);

		getContentPane().add(dmScreenWindowScrollPane,
				java.awt.BorderLayout.CENTER);

		jMenu2.setText("File");

		jMenuItem1.setText("Close");
		jMenuItem1.setToolTipText("Close DM Screen.");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem1);

		screenMenuBar.add(jMenu2);

		jMenu1.setText("Screen");
		jMenu1.setToolTipText("Charts and tables.");

		screenLoadChartsMenuItem.setText("Load");
		screenLoadChartsMenuItem
				.setToolTipText("Load all Charts and Tables to DM screen. Useful if you've changed or added a table/chart.");
		screenLoadChartsMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						screenLoadChartsMenuItemActionPerformed(evt);
					}
				});
		jMenu1.add(screenLoadChartsMenuItem);

		screenRemoveAllChartsMenuItem.setText("Remove");
		screenRemoveAllChartsMenuItem
				.setToolTipText("Remove ALL charts from screen.");
		screenRemoveAllChartsMenuItem.setEnabled(false);
		screenRemoveAllChartsMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						screenRemoveAllChartsMenuItemActionPerformed(evt);
					}
				});
		jMenu1.add(screenRemoveAllChartsMenuItem);

		screenMenuBar.add(jMenu1);

		setJMenuBar(screenMenuBar);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * user clicked on a chart and selected it, load it to the table pane
	 * @param evt
	 */
	private void chartsTreeMousePressed(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON1) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) chartsTree
					.getLastSelectedPathComponent();

			if (node != null && node.isLeaf()) {
				if (node.getUserObject() instanceof ChartClass) {
					ChartClass oC = (ChartClass) node.getUserObject();
					addSelectedChartToPanel(oC);
				}
			}
		}
	}

	/**
	 * put the selected chart from tree into the displayTable
	 * @param oC
	 */
	private void addSelectedChartToPanel(ChartClass oC) {
		chartsTablePanel.removeAll();
		Chart_Panel cPanel = new Chart_Panel(oC);
		chartsTablePanel.add(cPanel);
		// make this table so that nothing can be edited and has
		// rotating colours on rows
		JTable newChartTable = new JTable(new DefaultTableModel()) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		JTableHeader newChartHeader = newChartTable.getTableHeader();
		newChartHeader.setDefaultRenderer(new MyHeaderRenderer());
		newChartHeader.setPreferredSize(new Dimension(10, 60));
		newChartTable.setRowHeight(30);

		cPanel.chartLayoutPanel.add(newChartTable);
		cPanel.chartLayoutPanel.setViewportView(newChartTable);
		//newChartTable.setShowVerticalLines(false);
		newChartTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		newChartTable.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel newChartTableModel = (DefaultTableModel) newChartTable
				.getModel();

		// add the columns
		for (ChartColumn cC : oC.getColumn())
			newChartTableModel.addColumn(cC.getName(), cC.getRow().toArray());

		// then set prefered width, can't do it while adding columns
		int i = 0;
		for (ChartColumn cC : oC.getColumn()) {
			TableColumn col = (TableColumn) newChartTable.getColumnModel()
					.getColumn(i);
			// for some reason first row is double high, this fixes.
			if (i == 0)
				newChartTable.setRowHeight(
						i,
						(newChartTable.getRowHeight() / 2)
								+ (newChartTable.getRowMargin() * 2));

			col.setCellRenderer(new TextAreaRenderer());
			//			col.setCellEditor(new TextAreaEditor());

			col.setPreferredWidth(cC.getWidth());
			i++;
		} // end getColumn for
		chartsTablePanel.revalidate();
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void screenRemoveAllChartsMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		dmScreenTablesTabbedPane.removeAll();
	}

	private void screenLoadChartsMenuItemActionPerformed(
			java.awt.event.ActionEvent evt) {
		ost.showProgress(this, "Placing tables and charts onto DM Screen...");
		dmScreenTablesTabbedPane.removeAll();
		loadAll(true);
		ost.dmConfigTab.tabConfiguration.tabOptions.tablesConfig.updateAllGeneratorTableListComboBoxes();
		ost.showProgressDone();
	}

	private void loadAll(boolean showScreen) {
		// disabled for now, tryin out tree style
		//loadAllCharts(showScreen); 

		loadAllTables(showScreen);
		loadAllChartsTree(chartsTreeModel, chartsRootNode);
		// finally add the Treasure Tables
		this.dmScreenTablesTabbedPane.addTab(
				"Treasure Chest",
				new javax.swing.ImageIcon(getClass().getResource(
						"/images/16X-treasure-chest-icon.png")),
				ost.tabTreasure, "Generate Treasure");
	}

	//	private void loadAllCharts(boolean showScreen) {
	//		ArrayList<String> typeList = new ArrayList<String>();
	//		// build list of types
	//		for (ChartClass oC : ost.chartList)
	//			if (!typeList.contains(oC.getType().toUpperCase()))
	//				typeList.add(oC.getType().toUpperCase());
	//		// sort typeList alpha
	//		Collections.sort(typeList);
	//		// now flip through the typeList for each chartList and add it so its
	//		// in alphabetical order.
	//		for (String type : typeList) {
	//			for (ChartClass oC : ost.chartList) {
	//				if (type.equalsIgnoreCase(oC.getType()))
	//					ost.dmConfigTab.tabCharts.addChartToDMScreen(this, oC,
	//							showScreen);
	//			}
	//		}
	//	}

	private void loadAllTables(boolean showScreen) {
		ArrayList<String> typeList = new ArrayList<String>();
		// build list of types excluding treasure & none
		for (TableClass oC : ost.tableList.getContent())
			if (!typeList.contains(oC.getType().toUpperCase())
					&& !oC.type.equalsIgnoreCase("TREASURE")
					&& !oC.type.equalsIgnoreCase("NONE"))
				typeList.add(oC.getType().toUpperCase());
		// sort typeList alpha
		Collections.sort(typeList);
		// build tabs for each type
		for (String tT : typeList) {
			ost.dmConfigTab.tabConfiguration.tabOptions.tablesConfig.addTableToDMScreen(this,
					new Table_Generator(ost, tT), showScreen);
		}
	}

	private void loadAllChartsTree(DefaultTreeModel myModel,
			DefaultMutableTreeNode myRootNode) {
		myRootNode.removeAllChildren();
		for (ChartClass oC : ost.chartList.getContent()) {
			DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(oC);
			DefaultMutableTreeNode oNode = findTypeNode(oC.getType(), myModel);
			//			DefaultMutableTreeNode oNode = null;
			if (oNode == null) {
				// type of chart not found, add node
				oNode = new DefaultMutableTreeNode(oC.getType());
				myModel.insertNodeInto(oNode, myRootNode,
						myRootNode.getChildCount());
			}
			// add chart to node found on tree
			myModel.insertNodeInto(newChild, oNode, oNode.getChildCount());
		}// end for
		myModel.reload(myRootNode);
	}

	/**
	 * Find a non-leaf node with nodeName and return it
	 * @param nodeName
	 * @param myModel
	 * @return
	 */
	private DefaultMutableTreeNode findTypeNode(String nodeName,
			DefaultTreeModel myModel) {
		DefaultMutableTreeNode oNode = null;
		DefaultMutableTreeNode myRoot = (DefaultMutableTreeNode) myModel
				.getRoot();
		DefaultMutableTreeNode oN = myRoot.getNextNode();
		if (oN != null)
			do {
				if (oN != null
						&& oN.getUserObject() instanceof String
						&& oN.getUserObject().toString()
								.equalsIgnoreCase(nodeName))
					oNode = oN;
				oN = oN.getNextNode();
			} while (oN != null && oNode == null);

		return oNode;
	}

	public class chartsCellRendererTree extends DefaultTreeCellRenderer {

		/**
		 * constructor 
		 */
		public chartsCellRendererTree() {
		}

		/**
		 * 
		 */
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			if (value instanceof DefaultMutableTreeNode) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

				if (node.getUserObject() instanceof String) {
					setToolTipText("Left click on a chart name to view it.");
					setText((String) node.getUserObject());
				} else if (node.getUserObject() instanceof ChartClass) {
					ChartClass oQ = (ChartClass) node.getUserObject();
					setToolTipText(oQ.getDescription());
					setText(oQ.getName());
				}

				if (selected) {
					// background doesnt set for some reason
					setBackground(getBackgroundSelectionColor());
					setForeground(getTextSelectionColor());
				} else {
					// background doesnt set for some reason
					setBackground(getBackgroundNonSelectionColor());
					setForeground(getTextNonSelectionColor());
				}
			}
			return this;
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
			//area.setToolTipText("left click to edit");
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

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel chartsTablePanel;
	public javax.swing.JTree chartsTree;
	private javax.swing.JScrollPane chartsTreeScrollPane;
	private javax.swing.JSplitPane dmScreenChartsSplitPane;
	public javax.swing.JTabbedPane dmScreenTabbedPane;
	public javax.swing.JTabbedPane dmScreenTablesTabbedPane;
	private javax.swing.JScrollPane dmScreenWindowScrollPane;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem screenLoadChartsMenuItem;
	private javax.swing.JMenuBar screenMenuBar;
	private javax.swing.JMenuItem screenRemoveAllChartsMenuItem;
	// End of variables declaration//GEN-END:variables
	private MainClass ost;
	private DefaultMutableTreeNode chartsRootNode;
	private DefaultTreeModel chartsTreeModel;
	private DefaultTreeCellRenderer chartsCell;

}