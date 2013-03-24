package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.TableColumn;

import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class ChartColumn {
	public String name;
	public int width;
	public ArrayList<String> row;
	public TableColumn column;
	
	public ChartColumn() {
		this("New Column");
	}
	public ChartColumn(String nName) {
		this.setName(nName);
		this.setRow(new ArrayList<String>());
		this.setWidth(75);
		this.setColumn(null);
	}

	/**
	 * @return the column
	 */
	public TableColumn getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(TableColumn column) {
		this.column = column;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the row
	 */
	public ArrayList<String> getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(ArrayList<String> row) {
		this.row = row;
	}

	/**
	 * return contents of row X
	 * @param whichRow
	 * @return
	 */
	public String getRowValue(int whichRow) {
		return (String) row.toArray()[whichRow];
	}
	//-------------------------------------------------------------------
	/**
	 * returns item as Element for XML output
	 * @return
	 */
	public Element getAsElement(){
		Element eE = new Element("Column");
		try {
			// strings
			eE.addContent(new Element("Name").setText(XMLControl.escapeChars(name)));	
			eE.addContent(new Element("Width").setText(String.format("%d", getWidth())));

		// list
			if (getRow().size() > 0) {
				Element eF = new Element("RowList");
				// add all the TT entries
				for (String oS : getRow()) 
					eF.addContent(new Element("Row").setText(XMLControl.escapeChars(oS)));
				// now add them to Tables xml
				eE.addContent(eF);
			}// if
			
			
		}
	    catch (java.lang.OutOfMemoryError err) {
	      SimpleDialog.showError("Out of memory error while trying to save Chart-Column.\nError:" +
	                        err.getLocalizedMessage());
	    }
		return eE;
	}

	/**
	 * return Class from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static ChartColumn getFromElements(Element eItem) {
		ChartColumn oO = new ChartColumn();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown tt-name in XML");
		}
		// int
		try {		
		oO.setWidth(Integer.parseInt(eItem.getChild("Width").getText().trim()));		
		} catch (NullPointerException err) {
			oO.setWidth(10);
		}
		
		try {
			oO.getRow().clear();
			Element eTT = (Element) eItem.getChild("RowList");
			java.util.List lTT = eTT.getChildren("Row");
			Iterator inTTs = lTT.iterator();
			while (inTTs.hasNext()) {
				Element oE = (Element) inTTs.next();
				oO.getRow().add(XMLControl.unEscapeChars(oE.getText()));
			}
		} catch (NullPointerException err) {
			oO.getRow().clear();
			oO.getRow().add(new String("XML-UNKNOWN-ROW"));
		}			    
			
	    return oO;
	}
	
	

}
