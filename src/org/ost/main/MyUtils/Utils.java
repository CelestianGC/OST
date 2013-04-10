package org.ost.main.MyUtils;

import static org.ost.main.MyClasses.MyStatics.DEFAULT_FONT;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.ost.main.MainClass;
import org.ost.main.MyClasses.ChartClass;
import org.ost.main.MyClasses.ChartColumn;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.DungeonRoom;
import org.ost.main.MyClasses.EquipmentClass;
import org.ost.main.MyClasses.PlayerClass;

public class Utils {

	/**
	 * return the node associated with this object
	 * 
	 * @param tModel
	 * @param oMaster
	 * @param oFind
	 * @return
	 */
	public static DefaultMutableTreeNode getMyNodeByObject(DefaultTreeModel tModel,
			DefaultMutableTreeNode oMaster, Object oFind) {
		DefaultMutableTreeNode oN = null;
		for (int i = 0; i < oMaster.getChildCount(); i++) {
			DefaultMutableTreeNode oNode = (DefaultMutableTreeNode) oMaster
					.getChildAt(i);
			if (oNode.getUserObject() == oFind) {
				oN = oNode;
				break;
			}
		}
		return (oN);
	}


	/**
	 * expand jtree path at node
	 * 
	 * @param tree
	 * @param oNode
	 */
	public static void expandPathOnNode(JTree tree, DefaultMutableTreeNode oNode) {
		tree.expandPath(new TreePath(oNode.getPath()));
	}
	public static void askToDeleteSelectedRows(JTable table, Component comp) {
		int nSelected = table.getSelectedRowCount();
		if (nSelected != 0) {
			if (SimpleDialog
					.AskYN(comp,
							String.format(
									"%s",
									nSelected == 1 ? "Are you sure you want to delete the selected row?"
											: "Are you sure you want to delete the selected ROWS?")))
				Utils.deleteSelectedRow(table);
		}
	}
	/**
	 * delete selected row(s) in a table
	 * @param table
	 */
	public static void deleteSelectedRow(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//int deleteRowAt = table.getSelectedRow();
		int deleteRows[] = table.getSelectedRows();
		if (deleteRows.length > 0)
			model.removeRow(deleteRows[0]);
		if (deleteRows.length > 1)
			deleteSelectedRow(table); // keep running till it removes all selected rows.
	}

	/**
	 * put aString into clipboard
	 * 
	 * @param aString
	 */
	public static void setClipboardContents(String aString) {
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection,stringSelection );
	}


	/**
	 * get aString from clipboard
	 * 
	 * @param frame
	 * @return
	 */
	public static String getClipboardContents(JFrame frame) {
		String inClipboard = null;
		final Clipboard clipboard =
		          frame.getToolkit().getSystemClipboard();
		 Transferable clipData = clipboard.getContents(clipboard);
		   if (clipData != null) {
		     try {
		       if (clipData.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		         inClipboard = 
		        		 (String)(clipData.getTransferData(DataFlavor.stringFlavor));
		       }
		     } catch (UnsupportedFlavorException ufe) {
		       SimpleDialog.showError("Flavor unsupported: " + ufe);
		     } catch (IOException ioe) {
		    	 SimpleDialog.showError("Data not available: " + ioe);
		     }
		   }		
		   return inClipboard;
	}
	/**
	 * return true if object is PC object
	 * 
	 * @param oB
	 * @return
	 */
	public static boolean isPC(Object oB) {
		return(oB instanceof PlayerClass);
	}
	
	/**
	 * returns true if object is EquipmentClass
	 * 
	 * @param oB
	 * @return
	 */
	public static boolean isEquipment(Object oB) {
		return (oB instanceof EquipmentClass);
	}
	/**
	 * return true if object is DungeonRoom object
	 * @param oB
	 * @return
	 */
	public static boolean isDungeon(Object oB) {
		return(oB instanceof DungeonRoom);
	}

	/**
	 * return true if Object is CreatureClass
	 * 
	 * @param oB
	 * @return
	 */
	public static boolean isNPC (Object oB) {
		return (oB instanceof CreatureClass);
	}
	/**
	 * find value from chart position using row match from labelColumn
	 *  example: HD of 12 = labelMatch, it will find what is in valueColumn for where we
	 *  find the labelMatch in labelColumn.
	 *  
	 * @param chartName
	 * @param lableMatch
	 * @param labelColumn
	 * @param valueColumn
	 * @param chartList
	 * @return
	 */
	public static int getChartColumnValue(String chartName, String lableMatch, 
									int labelColumn, int valueColumn,
									List<ChartClass> chartList) {
		int foundValue = 0;
		ChartClass oC = ChartClass.getChartByName(chartName, chartList);
		if (oC != null) {
			ChartColumn colLabel = (ChartColumn) oC.getColumn().toArray()[labelColumn];
			ChartColumn colValue = (ChartColumn) oC.getColumn().toArray()[valueColumn];

			for (int i=0;i<colLabel.row.size();i++) {
				//	this row is our level, find matching spot in saves column.
				if (lableMatch.equalsIgnoreCase(colLabel.getRowValue(i))) {
					foundValue = Integer.parseInt(colValue.getRowValue(i));
					break; // kill for loop
				}

			}
		} else {
			SimpleDialog.showError("Unable to find chart:"+chartName+"");
		}

		return foundValue;
	}
	
	/**
	 * find value from chart position using row match from labelColumn
	 *  example: HD of 12 = labelMatch, returns all values on row matching 12 hd
	 *  find the labelMatch in labelColumn.
	 *  
	 * @param chartName
	 * @param lableMatch
	 * @param chartList
	 * @return
	 */
	public static ArrayList<String> getChartRow(String chartName, String lableMatch, 
									List<ChartClass> chartList) {
		ArrayList<String> foundList = new ArrayList<String>();
		int row = -1;
		ChartClass oChart = ChartClass.getChartByName(chartName, chartList);
		if (oChart != null) {
			ChartColumn colLabel = (ChartColumn) oChart.getColumn().toArray()[0];

			// find the label row
			for (int i=0;i<colLabel.row.size();i++) {
				//	this row is our level, find matching spot in saves column.
				if (lableMatch.equalsIgnoreCase(colLabel.getRowValue(i))) {
					row = i;
					break;
				}
			}
			// now add the values to array using row location skipping col0 (labels)
			for (int i=1;i<oChart.getColumn().size();i++) {
				ChartColumn oCol = (ChartColumn) oChart.getColumn().toArray()[i];
				foundList.add(oCol.getRowValue(row));
			}
		} else {
			SimpleDialog.showError("Unable to find chart:"+chartName+"");
		}

		return foundList;
	}

	
	
	/**
	 * return true if this node's parent is a "I am fighting this" node
	 * 
	 * @param testNode
	 * @return
	 */
	public static boolean isFightingNode(DefaultMutableTreeNode testNode) {
		TreeNode[] paths = testNode.getPath();
		for (int i=0;i<paths.length;i++) {
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) paths[i];
		// flip through all previous paths and if a fighting node return true
			if (parentNode.getUserObject().toString().equalsIgnoreCase("Fighting")) 
				return true;
		}
		
		return false;
	}

	/**
	 * return true if the filename exists;
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean fileExists(String fileName) {
		File file=new File(fileName);
		return file.exists();
	}
	/**
	 * rename fileName to newFileName
	 * 
	 * @param fileName
	 * @param newFileName
	 */
	public static void renameFile(String fileName, String newFileName) {
		 File f = new File(fileName);
		 if (f.exists()) {
			 try {
				 f.renameTo(new File(newFileName));
			} catch (Exception e) {
				SimpleDialog.showError(e.getLocalizedMessage()+": error in renameFile()");
			}
		 }
	}
	
	
	public static void updateMatrixPanelPC(JPanel attackMatrixPanel, 
											PlayerClass pc,
											MainClass ost) {
		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		int attackList[] = pc.getMatrix(ost);
		Color aColor = new Color(255, 204, 105);
		Color bColor = new Color(255, 153, 51);
		Color thacoColor = new Color(255, 102, 102);

		boolean bFlip = false;

		JLabel target = new JLabel(String.format("AC"));
		JPanel pTarget = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pTarget.setBackground(new Color(204, 204, 204));
		target.setToolTipText("Target Armor Class");
		target.setFont(fFont);
		pTarget.add(target);
		attackMatrixPanel.add(pTarget);

		for (int i = 0; i < attackList.length; i++) {
			int acNumber = (10 - i);
			JLabel n = new JLabel(String.format("AC%d", (acNumber)));
			n.setFont(fFont);
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
			if (i == 10)
				p.setBackground(thacoColor);
			else {
				p.setBackground(bFlip ? bColor : aColor);
				bFlip = !bFlip;
			}
			n.setToolTipText("Armor Class " + acNumber);
			p.setToolTipText(n.getToolTipText());
			p.add(n);
			attackMatrixPanel.add(p);
		}

		bFlip = false;
		JLabel roll = new JLabel(String.format("Roll"));
		JPanel pRoll = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pRoll.setBackground(new Color(204, 204, 204));
		roll.setToolTipText("Attack Roll Made");
		roll.setFont(fFont);
		pRoll.add(roll);
		attackMatrixPanel.add(pRoll);

		for (int i = 0; i < attackList.length; i++) {
			JLabel n = new JLabel(String.format("%d", attackList[i]));
			n.setFont(fFont);
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
			if (i == 10)
				p.setBackground(thacoColor);
			else {
				p.setBackground(bFlip ? bColor : aColor);
				bFlip = !bFlip;
			}
			n.setToolTipText("Attack roll needed " + attackList[i]);
			p.setToolTipText(n.getToolTipText());
			p.add(n);
			attackMatrixPanel.add(p);
		}
		
	}
	
	public static JTable getMatrixTable(int attackList[]) {
		JTable attackChartTable;
		Object[][] rowData = new Object[1][attackList.length];
		Object[] columnNames = new Object[attackList.length];
		
		for (int i = 0; i < attackList.length; i++) {
			int acNumber = (10 - i);
			//String.format("AC%d", (acNumber));
			//attackChartTable.setValueAt(String.format("AC%d", (acNumber)), 0, i);
			int atkRollNeeded = attackList[i];
			columnNames[i] = String.format("AC%d", (acNumber));
			rowData[0][i] = atkRollNeeded;
			//attackChartTable.setValueAt(atkRollNeeded, 0, i);
		}
		
		attackChartTable = new JTable(rowData,columnNames);
		Utils util = new Utils();
		
		for (int i = 0; i < attackChartTable.getColumnCount(); i++) {
			TableColumn thacoCol = attackChartTable.getColumnModel().getColumn(
					i);
			if (i == 10)
				thacoCol.setCellRenderer(util.new ColorColumnRenderer(Color.red,
						Color.black));
			else
				thacoCol.setCellRenderer(util.new ColorColumnRenderer(Color.ORANGE,
						Color.black));
		}

		Font fFont = new Font(DEFAULT_FONT, Font.PLAIN, 10);
		attackChartTable.getTableHeader().setFont(fFont);
		attackChartTable.getTableHeader().setBackground(Color.yellow);

		// this is to make the headers align left to match the numbers
		TableCellRenderer rendererFromHeader = attackChartTable
				.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.LEFT);
		
		return attackChartTable;
	}
	/**
	 * color class for JTable
	 * 
	 * @author Celestian
	 *
	 */
	public class ColorColumnRenderer extends DefaultTableCellRenderer {
		Color bkgndColor, fgndColor;

		public ColorColumnRenderer(Color bkgnd, Color foregnd) {
			super();
			bkgndColor = bkgnd;
			fgndColor = foregnd;
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component cell = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);

			cell.setBackground(bkgndColor);
			cell.setForeground(fgndColor);

			return cell;
		}
	}
	
	
} // end Utils
