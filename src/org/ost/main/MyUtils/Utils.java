package org.ost.main.MyUtils;

import java.awt.Component;
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
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

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
	
	
	
	
} // end Utils
