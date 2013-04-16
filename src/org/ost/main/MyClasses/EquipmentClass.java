package org.ost.main.MyClasses;

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

public class EquipmentClass {
	public String myID;
	public String name;
	public String description;
	public int count;
	public int type; // equipmentList, weapon, armor, treasure, container
	public boolean magic;
	public int charges;
	public int chargesMax;
	
	public boolean equipped;
	// bags contain things...
	public ArrayList<EquipmentClass> contains;
	public float weight;
	
	//TODO ---------- Weapons
	// weapon specific
	public int weaponType; //slash, pierce, bludgeon, other
	//what base weapon type this object is, i.e. what a prof a person needs to use it
	public ArrayList<String> weaponUseType; //longsword, shortsword, longbow, dagger
	public ArrayList<String> weaponGroupType; // blades, clubs, 
	public ArrayList<String> weaponTightGroupType; // longblade, shortblade, longbows, shortbows
	public String damageSmall; // 1d6+1
	public String damageMedium;
	public String damageLarge;
	
	//TODO ------------ Armors/shield
	// armor specific
	public ArrayList<String> armorType; //leather, chainmail, platemail, fieldplate
	public int armorBulkType; // none, non-bulky, fairly-bulky, bulky/etc
	public int ac;
	public int acBase;
	
	// magic
	public int magicAdjustmentPrimary;
	public int magicAdjustmentSecondary;
	
	public EquipmentClass() {
		this("name","description",0);
	}

	public EquipmentClass(String newName, String newDescription) {
		this(newName,newDescription,0);
	}

	public EquipmentClass(String newName, String newDescription, int newCount) {
		this(newName, newDescription,newCount,0,
				false,0,0,false,
				new ArrayList<EquipmentClass>(),0,0,
				new ArrayList<String>(),new ArrayList<String>(),
				new ArrayList<String>(),"1d4",
				"1d4","1d4",
				new ArrayList<String>(),0,0,10,
				0,0);
	}
	
	
//	public EquipmentClass(String name, String description, int count, int type,
//			boolean magic, int charges, int weaponType, int armorType,
//			boolean equipped) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.count = count;
//		this.type = type;
//		this.magic = magic;
//		this.charges = charges;
//		this.chargesMax = 0;
//		this.weaponType = weaponType;
//		this.equipped = equipped;
//		this.setContains(new ArrayList<EquipmentClass>());
//		this.weight = 0;
//		this.setMyID(UUID.randomUUID().toString());
//	}


	public EquipmentClass(String name, String description, int count, int type,
			boolean magic, int charges, int chargesMax, boolean equipped,
			ArrayList<EquipmentClass> contains, float weight, int weaponType,
			ArrayList<String> weaponUseType, ArrayList<String> weaponGroupType,
			ArrayList<String> weaponTightGroupType, String damageSmall,
			String damageMedium, String damageLarge,
			ArrayList<String> armorType, int armorBulkType, int ac, int acBase,
			int magicAdjustmentPrimary, int magicAdjustmentSecondary) {
		super();
		this.name = name;
		this.description = description;
		this.count = count;
		this.type = type;
		this.magic = magic;
		this.charges = charges;
		this.chargesMax = chargesMax;
		this.equipped = equipped;
		this.contains = contains;
		this.weight = weight;
		this.weaponType = weaponType;
		this.weaponUseType = weaponUseType;
		this.weaponGroupType = weaponGroupType;
		this.weaponTightGroupType = weaponTightGroupType;
		this.damageSmall = damageSmall;
		this.damageMedium = damageMedium;
		this.damageLarge = damageLarge;
		this.armorType = armorType;
		this.armorBulkType = armorBulkType;
		this.ac = ac;
		this.acBase = acBase;
		this.magicAdjustmentPrimary = magicAdjustmentPrimary;
		this.magicAdjustmentSecondary = magicAdjustmentSecondary;
		this.setMyID(UUID.randomUUID().toString());
	}

	/**
	 * @return the weaponUseType
	 */
	public ArrayList<String> getWeaponUseType() {
		return weaponUseType;
	}

	/**
	 * @param weaponUseType the weaponUseType to set
	 */
	public void setWeaponUseType(ArrayList<String> weaponUseType) {
		this.weaponUseType = weaponUseType;
	}

	/**
	 * @return the weaponGroupType
	 */
	public ArrayList<String> getWeaponGroupType() {
		return weaponGroupType;
	}

	/**
	 * @param weaponGroupType the weaponGroupType to set
	 */
	public void setWeaponGroupType(ArrayList<String> weaponGroupType) {
		this.weaponGroupType = weaponGroupType;
	}

	/**
	 * @return the weaponTightGroupType
	 */
	public ArrayList<String> getWeaponTightGroupType() {
		return weaponTightGroupType;
	}

	/**
	 * @param weaponTightGroupType the weaponTightGroupType to set
	 */
	public void setWeaponTightGroupType(ArrayList<String> weaponTightGroupType) {
		this.weaponTightGroupType = weaponTightGroupType;
	}

	/**
	 * @return the damageSmall
	 */
	public String getDamageSmall() {
		return damageSmall;
	}

	/**
	 * @param damageSmall the damageSmall to set
	 */
	public void setDamageSmall(String damageSmall) {
		this.damageSmall = damageSmall;
	}

	/**
	 * @return the damageMedium
	 */
	public String getDamageMedium() {
		return damageMedium;
	}

	/**
	 * @param damageMedium the damageMedium to set
	 */
	public void setDamageMedium(String damageMedium) {
		this.damageMedium = damageMedium;
	}

	/**
	 * @return the damageLarge
	 */
	public String getDamageLarge() {
		return damageLarge;
	}

	/**
	 * @param damageLarge the damageLarge to set
	 */
	public void setDamageLarge(String damageLarge) {
		this.damageLarge = damageLarge;
	}

	/**
	 * @return the armorType
	 */
	public ArrayList<String> getArmorType() {
		return armorType;
	}

	/**
	 * @param armorType the armorType to set
	 */
	public void setArmorType(ArrayList<String> armorType) {
		this.armorType = armorType;
	}

	/**
	 * @return the armorBulkType
	 */
	public int getArmorBulkType() {
		return armorBulkType;
	}

	/**
	 * @param armorBulkType the armorBulkType to set
	 */
	public void setArmorBulkType(int armorBulkType) {
		this.armorBulkType = armorBulkType;
	}

	/**
	 * @return the ac
	 */
	public int getAc() {
		return ac;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(int ac) {
		this.ac = ac;
	}

	/**
	 * @return the acBase
	 */
	public int getAcBase() {
		return acBase;
	}

	/**
	 * @param acBase the acBase to set
	 */
	public void setAcBase(int acBase) {
		this.acBase = acBase;
	}

	/**
	 * @return the magicAdjustmentPrimary
	 */
	public int getMagicAdjustmentPrimary() {
		return magicAdjustmentPrimary;
	}

	/**
	 * @param magicAdjustmentPrimary the magicAdjustmentPrimary to set
	 */
	public void setMagicAdjustmentPrimary(int magicAdjustmentPrimary) {
		this.magicAdjustmentPrimary = magicAdjustmentPrimary;
	}

	/**
	 * @return the magicAdjustmentSecondary
	 */
	public int getMagicAdjustmentSecondary() {
		return magicAdjustmentSecondary;
	}

	/**
	 * @param magicAdjustmentSecondary the magicAdjustmentSecondary to set
	 */
	public void setMagicAdjustmentSecondary(int magicAdjustmentSecondary) {
		this.magicAdjustmentSecondary = magicAdjustmentSecondary;
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
	 * returns a brand new copy of itself
	 * @return
	 */
	public EquipmentClass getCopy() {
		EquipmentClass oNew = new EquipmentClass();
		oNew.name = name;
		oNew.description = description;
		oNew.count = count;
		oNew.type = type;
		oNew.magic = magic;
		oNew.charges = charges;
		oNew.chargesMax = chargesMax;
		oNew.weaponType = weaponType;
		oNew.armorType = armorType;
		oNew.equipped = equipped;
		oNew.weight = weight;
		oNew.setContains(new ArrayList<EquipmentClass>());
		for (EquipmentClass oS: getContains())
			oNew.getContains().add(oS.getCopy());
		
		return(oNew);
	}
	

	/**
	 * @return the chargesMax
	 */
	public int getChargesMax() {
		return chargesMax;
	}

	/**
	 * @param chargesMax the chargesMax to set
	 */
	public void setChargesMax(int chargesMax) {
		this.chargesMax = chargesMax;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the contains
	 */
	public ArrayList<EquipmentClass> getContains() {
		return contains;
	}

	/**
	 * @param contains the contains to set
	 */
	public void setContains(ArrayList<EquipmentClass> contains) {
		this.contains = contains;
	}

	/**
	 * @return the equipped
	 */
	public boolean isEquipped() {
		return equipped;
	}

	/**
	 * @param equipped the equipped to set
	 */
	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
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
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the magic
	 */
	public boolean isMagic() {
		return magic;
	}
	/**
	 * @param magic the magic to set
	 */
	public void setMagic(boolean magic) {
		this.magic = magic;
	}
	/**
	 * @return the charges
	 */
	public int getCharges() {
		return charges;
	}
	/**
	 * @param charges the charges to set
	 */
	public void setCharges(int charges) {
		this.charges = charges;
	}
	/**
	 * @return the weaponType
	 */
	public int getWeaponType() {
		return weaponType;
	}
	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(int weaponType) {
		this.weaponType = weaponType;
	}
	
//	//TODO add xml exports for player save to file
//	/**
//	 * returns item as Element for XML output
//	 * @return
//	 */
//	public Element getAsElement(){
//		Element eQ = new Element("EquipmentList");
//		try {
//			// strings
//			eQ.addContent(new Element("name").setText(XMLControl.escapeChars(name)));	
//			eQ.addContent(new Element("description").setText(XMLControl.escapeChars(description)));			
//
//			// numbers
//			eQ.addContent(new Element("count").setText(String.format("%d",count)));
//			eQ.addContent(new Element("type").setText(String.format("%d",type)));
//			eQ.addContent(new Element("charges").setText(String.format("%d",charges)));
//			eQ.addContent(new Element("chargesMax").setText(String.format("%d",chargesMax)));
//			eQ.addContent(new Element("weaponType").setText(String.format("%d",weaponType)));
//			eQ.addContent(new Element("armorType").setText(String.format("%d",armorType)));
//			// float
//			eQ.addContent(new Element("weight").setText(String.format("%f",weight)));
//
//			// boolean
//			eQ.addContent(new Element("magic").setText(isMagic()?"TRUE":"FALSE"));			
//			eQ.addContent(new Element("equipped").setText(isEquipped()?"TRUE":"FALSE"));			
//
//			
//			/**
//			 * bags with items in it
//			 */
//			if (getContains().size() > 0) {
//				Element eF = new Element("contents");
//				for (EquipmentClass oE : getContains())
//					eF.addContent(oE.getAsElement());
//
//				eQ.addContent(eF);
//			}
//
//
//		}
//	    catch (java.lang.OutOfMemoryError err) {
//	      SimpleDialog.showError("Out of memory error while trying to save gear.\nError:" +
//	                        err.getLocalizedMessage());
//	    }
//		return eQ;
//	}
//
//	/**
//	 * return class from element list pulled from XMl file.
//	 * @param eItem
//	 * @return
//	 */
//	public static EquipmentClass getFromElements(Element eItem) {
//		EquipmentClass oO = new EquipmentClass();
//
//	    // text
//		try {		
//			oO.setName(XMLControl.unEscapeChars(eItem.getChild("name").getText()));		
//		} catch (NullPointerException err) {
//			oO.setName("Unknown");
//		}
//		try {		
//			oO.setDescription(XMLControl.unEscapeChars(eItem.getChild("description").getText()));		
//		} catch (NullPointerException err) {
//			oO.setDescription("Unknown description");
//		}
//		
//		// ---------- boolean
//		try {		
//			oO.setMagic(eItem.getChild("magic").getText().equalsIgnoreCase("TRUE")?true:false);		
//		} catch (NullPointerException err) {
//			oO.setMagic(false);
//		}
//		try {		
//			oO.setEquipped(eItem.getChild("equipped").getText().equalsIgnoreCase("TRUE")?true:false);		
//		} catch (NullPointerException err) {
//			oO.setEquipped(false);
//		}
//
//		// ------------ ints
//		try {		
//	    oO.setCount(Integer.parseInt(eItem.getChild("count").getText()));		
//		} catch (NullPointerException err) {
//			oO.setCount(0);
//		}
//		try {		
//		oO.setType(Integer.parseInt(eItem.getChild("type").getText()));		
//		} catch (NullPointerException err) {
//			oO.setType(0);
//		}
//		try {		
//		oO.setCharges(Integer.parseInt(eItem.getChild("charges").getText()));		
//		} catch (NullPointerException err) {
//			oO.setCharges(0);
//		}
//		try {		
//		oO.setChargesMax(Integer.parseInt(eItem.getChild("chargesMax").getText()));		
//		} catch (NullPointerException err) {
//			oO.setChargesMax(0);
//		}
//
//		try {		
//		oO.setWeaponType(Integer.parseInt(eItem.getChild("weaponType").getText()));		
//		} catch (NullPointerException err) {
//			oO.setWeaponType(0);
//		}
//
//		// float
//		try {		
//		oO.setWeight(Float.parseFloat(eItem.getChild("weight").getText()));		
//		} catch (NullPointerException err) {
//			oO.setWeight(0);
//		}
//
//
//		try {
//			oO.getContains().clear();
//			java.util.List lContents = eItem.getChildren("contents");
//			Iterator inContents = lContents.iterator();
//			while (inContents.hasNext()) {
//				Element oE = (Element) inContents.next();
//				oO.getContains().add(EquipmentClass.getFromElements(oE));				
//			}
//		} catch (NullPointerException err) {
//			oO.getContains().clear();
//		}			    
//			
//	    return oO;
//	}
//
//	/**
//	 * returns the entire equipmentList listing as a Document
//	 * so it can be output to XML file.
//	 * 
//	 * @param lList
//	 * @param sRootName
//	 * @return
//	 */
//	public static Document xmlBuildDocFromList(ArrayList<EquipmentClass> lList,String sRootName) {
//		Element eRoot = new Element(sRootName);
//		eRoot.setAttribute(new Attribute("JDOM", "1.1.1"));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		eRoot.addContent(new Element("Created").setText(dateFormat.format(new Date())));
//		Document doc = new Document(eRoot);
//
//		for (int i = 0; i < lList.size(); i++) {
//			EquipmentClass oO = lList.get(i);
//			eRoot.addContent(oO.getAsElement());
//		}
//
//		return doc;
//	} // end buildDoc	
//	
//	/**
//	 * build list of Players from XML Document
//	 * @param doc
//	 * @return
//	 */
//	public static ArrayList<EquipmentClass> getListFromDoc(Document doc) {
//		ArrayList<EquipmentClass> lList = new ArrayList<EquipmentClass>();
//
//		try {
//			Element eRoot = doc.getRootElement();
//
//			java.util.List lItems = eRoot.getChildren("EquipmentList");
//
//			Iterator in = lItems.iterator();
//			while (in.hasNext()) {
//				Element eItem = (Element) in.next();
//				EquipmentClass oO = EquipmentClass.getFromElements(eItem);
//
//				lList.add(oO);
//			}
//
//		} catch (NullPointerException err) {
//			SimpleDialog
//					.showError("NullpointerException:"
//							+ err.getLocalizedMessage()
//							+ "\n"
//							+ "Error occured while trying to load equipmentList from XML.");
//		}
//
//		return lList;
//	}
//
//	
//	/**
//	 * load xml sFilename and return the arraylist of Creatures
//	 * @param sFileName
//	 * @return
//	 */
//	public static ArrayList<EquipmentClass> loadFromXML(String sFileName) {
//		ArrayList<EquipmentClass> lList = new ArrayList<EquipmentClass>();
//		Document doc = XMLControl.loadDoc(sFileName);
//		lList = EquipmentClass.getListFromDoc(doc);
//		return lList;
//	}
	
}
