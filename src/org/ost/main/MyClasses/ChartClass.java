package org.ost.main.MyClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class ChartClass implements Comparable{
	public String myID;
	public String name;
	public String description;
	public ArrayList<ChartColumn> column;
	public String type;
	
	/**
	 * 
	 */
	public ChartClass() {
		this("New Name","New Description");
	}
	/**
	 * 
	 * @param nName
	 * @param desc
	 */
	public ChartClass(String nName, String desc) {
		this.setName(nName);
		this.setDescription(desc);
		this.setColumn(new ArrayList<ChartColumn>());
		this.setType("GENERAL");
		this.setMyID(UUID.randomUUID().toString());
	}

	/**
	 * @return the myID
	 */
	public String getMyID() {
		return myID;
	}
	/**
	 * @param myID the myID to set
	 */
	public void setMyID(String myID) {
		this.myID = myID;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((ChartClass)o).name.toUpperCase());		
	}

	//-------------------------------------------------------------------
	/**
	 * @return the column
	 */
	public ArrayList<ChartColumn> getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(ArrayList<ChartColumn> column) {
		this.column = column;
	}

	/**
	 * returns item as Element for XML output
	 * @return
	 */
//	public Element getAsElement(){
//		Element eTable = new Element("Chart");
//		try {
//			// strings
//			eTable.addContent(new Element("Name").setText(XMLControl.escapeChars(name)));	
//			eTable.addContent(new Element("Description").setText(XMLControl.escapeChars(description)));
//			eTable.addContent(new Element("Type").setText(XMLControl.escapeChars(type)));
//		    
//
//			/**
//			 * Insert TreatureTable entries block
//			 */
//			if (getColumn().size() > 0) {
//				Element eF = new Element("ColumnList");
//				// add all the TT entries
//				for (ChartColumn oS : getColumn()) {
//					eF.addContent(oS.getAsElement());
//				}
//				// now add them to Tables xml
//				eTable.addContent(eF);
//			}// if
//
//
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save Chart.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return eTable;
//	}

//	/**
//	 * returns the entire Class listing as a Document
//	 * so it can be output to XML file.
//	 * 
//	 * @param lList
//	 * @param sRootName
//	 * @return
//	 */
//	public static Document xmlBuildDocFromList(ArrayList<ChartClass> lList,String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			ChartClass oO = lList.get(i);
//			eRoot.addContent(oO.getAsElement());
//		}
//
//		return doc;
//	} // end buildDoc	
	
	/**
	 * build list of Class from XML Document
	 * @param doc
	 * @return
	 */
	public static ArrayList<ChartClass> getListFromDoc(Document doc) {
		ArrayList<ChartClass> lList = new ArrayList<ChartClass>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("Chart");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				ChartClass oO = ChartClass.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
			SimpleDialog
					.showError("NullpointerException:"
							+ err.getLocalizedMessage()
							+ "\n"
							+ "Error occured while trying to load Charts from XML.");
		}

		return lList;
	}

	/**
	 * return Class from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static ChartClass getFromElements(Element eItem) {
		ChartClass oO = new ChartClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown name in XML");
		}

		try {		
		oO.setDescription(XMLControl.unEscapeChars(eItem.getChild("Description").getText()));		
		} catch (NullPointerException err) {
			oO.setDescription("No table description in XML.");
		}

		try {		
		oO.setType(XMLControl.unEscapeChars(eItem.getChild("Type").getText()));		
		} catch (NullPointerException err) {
			oO.setType("DEFAULT");
		}
		try {
			oO.getColumn().clear();
			Element eTT = (Element) eItem.getChild("ColumnList");
			java.util.List lTT = eTT.getChildren("Column");
			Iterator inTTs = lTT.iterator();
			while (inTTs.hasNext()) {
				Element oE = (Element) inTTs.next();
				oO.getColumn().add(ChartColumn.getFromElements(oE));
			}
		} catch (NullPointerException err) {
			oO.getColumn().clear();
			oO.getColumn().add(new ChartColumn("XML-UNKNOWN"));
		}			    
			
	    return oO;
		
		
	}
	/**
	 * load xml sFilename and return the arraylist of Class
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<ChartClass> loadFromXML(String sFileName) {
		ArrayList<ChartClass> lList = new ArrayList<ChartClass>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = ChartClass.getListFromDoc(doc);
		return lList;
	}
	//---------------------------------------------
	/**
	 * return chart if found in array list
	 * 
	 * @param chartName
	 * @param chartList
	 * @return
	 */
	public static ChartClass getChartByName(String chartName, List<ChartClass> chartList) {
		ChartClass oChart = null;
		for (ChartClass oC: chartList) {
			if (chartName.equalsIgnoreCase(oC.getName())) {
				oChart = oC;
				break;
			}
		}
		return (oChart);
	}


} // end ChartClass
