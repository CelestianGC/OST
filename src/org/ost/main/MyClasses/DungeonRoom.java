package org.ost.main.MyClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.ost.main.EncounterDungeon;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

public class DungeonRoom {
	public int ID;
	public String name;
	public String descriptionGM;
	public String descriptionPC;
	public ArrayList<CreatureClass> mobs;
	public ArrayList<DungeonRoom> rooms;
	public EncounterDungeon	Encountered;
	
	/**
	 * 
	 */
	public DungeonRoom() {
		this("new-room");
	}
	/**
	 * 
	 * @param nName
	 */
	public DungeonRoom(String nName) {
		this.setName(nName);
		this.setDescriptionGM("gm-description");
		this.setDescriptionPC("pc-description");
		this.setMobs(new ArrayList<CreatureClass>());
		this.setRooms(new ArrayList<DungeonRoom>());
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the encountered
	 */
	public EncounterDungeon getEncountered() {
		return Encountered;
	}
	/**
	 * @param encountered the encountered to set
	 */
	public void setEncountered(EncounterDungeon encountered) {
		Encountered = encountered;
	}
	/**
	 * @return the descriptionPC
	 */
	public String getDescriptionPC() {
		return descriptionPC;
	}

	/**
	 * @param descriptionPC the descriptionPC to set
	 */
	public void setDescriptionPC(String descriptionPC) {
		this.descriptionPC = descriptionPC;
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
	 * @return the descriptionGM
	 */
	public String getDescriptionGM() {
		return descriptionGM;
	}

	/**
	 * @param descriptionGM the descriptionGM to set
	 */
	public void setDescriptionGM(String descriptionGM) {
		this.descriptionGM = descriptionGM;
	}

	/**
	 * @return the rooms
	 */
	public ArrayList<DungeonRoom> getRooms() {
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(ArrayList<DungeonRoom> rooms) {
		this.rooms = rooms;
	}
	/**
	 * @return the mobs
	 */
	public ArrayList<CreatureClass> getMobs() {
		return mobs;
	}

	/**
	 * @param mobs the mobs to set
	 */
	public void setMobs(ArrayList<CreatureClass> mobs) {
		this.mobs = mobs;
	}

	public static DungeonRoom getDungeonRoomFromNode (){
		DungeonRoom oD = new DungeonRoom("getDungeonRoomFromNode(");
		
		return(oD);
	}// end getDungeonRoomFromNode
	//-------------------------------------------------------------------
	/**
	 * returns item as Element for XML output
	 * @return
	 */
//	public Element getAsElement(){
//		Element e = new Element("DungeonRoom");
//		try {
//			// strings
//			e.addContent(new Element("Name").setText(XMLControl.escapeChars(name)));	
//			e.addContent(new Element("GMDescription").setText(XMLControl.escapeChars(descriptionGM)));
//			e.addContent(new Element("PCDescription").setText(XMLControl.escapeChars(descriptionPC)));
//		    
//			/**
//			 * Insert Creature block
//			 */
//			if (getMobs().size() > 0) {
//				Element eF = new Element("Mobs");
//				// add all the TT entries
//				for (CreatureClass oT : getMobs()) 
//					eF.addContent(oT.getAsElement());
//				// now add them to dungeon room xml
//				e.addContent(eF);
//			}// if
//
//
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save Dungeon Rooms.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return e;
//	}
//
//	/**
//	 * returns the entire Class listing as a Document
//	 * so it can be output to XML file.
//	 * 
//	 * @param lList
//	 * @param sRootName
//	 * @return
//	 */
//	public static Document xmlBuildDocFromList(ArrayList<DungeonRoom> lList,String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			DungeonRoom oO = lList.get(i);
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
	public static ArrayList<DungeonRoom> getListFromDoc(Document doc) {
		ArrayList<DungeonRoom> lList = new ArrayList<DungeonRoom>();

		try {
			Element eRoot = doc.getRootElement();

			java.util.List lItems = eRoot.getChildren("DungeonRoom");

			Iterator in = lItems.iterator();
			while (in.hasNext()) {
				Element eItem = (Element) in.next();
				DungeonRoom oO = DungeonRoom.getFromElements(eItem);

				lList.add(oO);
			}

		} catch (NullPointerException err) {
//			SimpleDialog
//					.showError("NullpointerException:"
//							+ err.getLocalizedMessage()
//							+ "\n"
//							+ "Error occured while trying to load Dungeon Rooms from XML.");
		}

		return lList;
	}

	/**
	 * return Class from element list pulled from XMl file.
	 * @param eItem
	 * @return
	 */
	public static DungeonRoom getFromElements(Element eItem) {
		DungeonRoom oO = new DungeonRoom("");

	    // text
		try {		
			oO.setName(XMLControl.unEscapeChars(eItem.getChild("Name").getText()));		
		} catch (NullPointerException err) {
			oO.setName("Unknown name in XML");
		}

		try {		
		oO.setDescriptionGM(XMLControl.unEscapeChars(eItem.getChild("GMDescription").getText()));		
		} catch (NullPointerException err) {
			oO.setDescriptionGM("No GM description in XML.");
		}
		try {		
		oO.setDescriptionPC(XMLControl.unEscapeChars(eItem.getChild("PCDescription").getText()));		
		} catch (NullPointerException err) {
			oO.setDescriptionPC("No PC description in XML.");
		}

		try {
			oO.getMobs().clear();
			Element eTT = (Element) eItem.getChild("Mobs");
			java.util.List lTT = eTT.getChildren("Creature");
			Iterator inTTs = lTT.iterator();
			while (inTTs.hasNext()) {
				Element oE = (Element) inTTs.next();
				oO.getMobs().add(CreatureClass.getFromElements(oE));
			}
		} catch (NullPointerException err) {
			oO.getMobs().clear();
			// empty room
			//oO.getMobs().add(new CreatureClass("Missing-FromXML"));
		}			    
			
	    return oO;
		
		
	}
	/**
	 * load xml sFilename and return the arraylist of Class
	 * @param sFileName
	 * @return
	 */
	public static ArrayList<DungeonRoom> loadFromXML(String sFileName) {
		ArrayList<DungeonRoom> lList = new ArrayList<DungeonRoom>();
		Document doc = XMLControl.loadDoc(sFileName);
		lList = DungeonRoom.getListFromDoc(doc);
		return lList;
	}
	//---------------------------------------------

	

} // end DungeonRoom class
