package org.ost.main.MyClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class StatesClass implements Serializable, Comparable{
	public String myID;
	public String name;
	public String description;
	public int iD;
	public int counter;
	public boolean bSmallFont;
	
	
	
	public StatesClass() {
		this("New State","New State Description",5,-1);
	}

	public StatesClass(String sName, String sDesc) {
		this(sName,sDesc,1,-1);
	}
	/**
	 * 
	 * @param sName
	 * @param sDesc
	 * @param nCounter
	 */
	public StatesClass(String sName, String sDesc, int nCounter, int ID) {
		setName(sName);
		setCounter(nCounter);
		setDescription(sDesc);
		setiD(ID);
		setbSmallFont(false);
		setMyID(UUID.randomUUID().toString());
		
	} // end StatesClass
	
	
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
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setiD(int iD) {
		this.iD = iD;
	}

	/**
	 * @return the bSmallFont
	 */
	public boolean isbSmallFont() {
		return bSmallFont;
	}

	/**
	 * @param bSmallFont the bSmallFont to set
	 */
	public void setbSmallFont(boolean bSmallFont) {
		this.bSmallFont = bSmallFont;
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
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * 
	 * @param counter
	 */
	public void decreaseCounter(int counter) {
		this.counter -= counter;
	}
	/**
	 * 
	 * @param counter
	 */
	public void increaseCounter(int counter) {
		this.counter += counter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	/**
	 * sort by counter
	 */
	public int compareTo(Object o) {
	     //return name.toUpperCase().compareTo(((StatesClass)o).name.toUpperCase());		
	     return this.counter - (((StatesClass)o).counter);		
	}
	
	/**
	 * returns item as Element for XML output
	 * @return
	 */
//	public Element getAsElement(){
//		Element eState = new Element("State");
//		try {
//			// strings
//			eState.addContent(new Element("name").setText(XMLControl.escapeChars(name)));	
//			eState.addContent(new Element("description").setText(XMLControl.escapeChars(description)));			
//
//			// numbers
//			eState.addContent(new Element("iD").setText(String.format("%d",iD)));
//
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save states.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return eState;
//	}

	/**
	 * return StatesClass from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static StatesClass getFromElements(Element eItem) {
		StatesClass oO = new StatesClass();

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown");
		}
		try {		
			oO.setDescription(XMLControl.unEscapeChars(eItem.getChild("description").getText()));		
		} catch (NullPointerException err) {
			oO.setDescription("Unknown Description");
		}

		
		// ------------ ints
		
		try {		
	    oO.setiD(Integer.parseInt(eItem.getChild("iD").getText()));		
		} catch (NullPointerException err) {
			oO.setiD(0);
		}
			
	    return oO;
	}
	
	/**
	 * returns the entire States listing as a Document
	 * so it can be output to XML file.
	 * 
	 * @param lList
	 * @param sRootName
	 * @return
	 */
//	public static Document xmlBuildDocFromList(ArrayList<StatesClass> lList,	String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			StatesClass oO = lList.get(i);
//			eRoot.addContent(oO.getAsElement());
//		}
//
//		return doc;
//	} // end buildDoc	
	
	/**
	 * build list of Players from XML Document
	 * @param doc
	 * @return
	 */
	public static ArrayList<StatesClass> getListFromDoc(Document doc) {
		ArrayList<StatesClass> lList = new ArrayList<StatesClass>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("State");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				StatesClass oO = StatesClass.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
			SimpleDialog
					.showError("NullpointerException:"
							+ err.getLocalizedMessage()
							+ "\n"
							+ "Error occured while trying to load states from XML.");
		}

		return lList;
	}

	
	/**
	 * load xml sFilename and return the arraylist of Creatures
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<StatesClass> loadFromXML(String sFileName) {
		ArrayList<StatesClass> lList = new ArrayList<StatesClass>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = StatesClass.getListFromDoc(doc);
		return lList;
	}


	
} // end StatesClass



