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
import org.ost.main.MainClass;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;
import static org.ost.main.MyClasses.MyStatics.*;

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
	public String weaponProfType; //longsword, shortsword, longbow, dagger
	public String weaponGroupType; // blades, clubs, 
	public String weaponTightGroupType; // longblade, shortblade, longbows, shortbows
	public String damageSmall; // 1d6+1
	public String damageMedium;
	public String damageLarge;
	public int[] range;
	public int speedFactor;
	public int[] attacksPerRound;
	
	//TODO ------------ Armors/shield
	// armor specific
	public String armorType; //leather, chainmail, platemail, fieldplate
	public int armorBulkType; // none, non-bulky, fairly-bulky, bulky/etc
	public int ac;
	public int acBase;
	
	// magic
	public int magicAdjustmentPrimary;
	public int magicAdjustmentSecondary;
	
	public ArrayList<String> features; //uuid of the feature
	
	public int[] value; 
	
	public int experience;
	public String source;
	
	//-------------------------------------------------------------
	
	public EquipmentClass() {
		this("name","description",0);
	}

	public EquipmentClass(String newName, String newDescription) {
		this(newName,newDescription,-1);
	}

	public EquipmentClass(String newName, String newDescription, int newCount) {
		this(newName, newDescription,newCount,-1,
				false,-1,-1,false,
				new ArrayList<EquipmentClass>(),0,0,
				"","",
				"","1d4",
				"1d4","1d4",
				"",0,0,10,
				0,0,
				new ArrayList<String>(), new int[MAX_COIN],0,0,
				new int[MAX_RANGES],"",new int[2]);
	}

	public EquipmentClass(String name, String description, int count, int type,
			boolean magic, int charges, int chargesMax, boolean equipped,
			ArrayList<EquipmentClass> contains, float weight, int weaponType,
			String weaponProfType, String weaponGroupType,
			String weaponTightGroupType, String damageSmall,
			String damageMedium, String damageLarge,
			String armorType, int armorBulkType, int ac, int acBase,
			int magicAdjustmentPrimary, int magicAdjustmentSecondary,
			ArrayList<String> features, int[] value, int exp, int speedFactor,
			int[] range, String source, int[] attacksPerRound) {
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
		this.weaponProfType = weaponProfType;
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
		this.features = features;
		this.value = value;
		this.experience = exp;
		this.speedFactor = speedFactor;
		this.range = range;
		this.source = source;
		this.attacksPerRound = attacksPerRound;
		this.attacksPerRound[0] = 1;
		this.attacksPerRound[1] = 1;
		
		this.setMyID(UUID.randomUUID().toString());
	}

	
	/**
	 * @return the attacksPerRound
	 */
	public int[] getAttacksPerRound() {
		return attacksPerRound;
	}

	/**
	 * @param attacksPerRound the attacksPerRound to set
	 */
	public void setAttacksPerRound(int[] attacksPerRound) {
		this.attacksPerRound = attacksPerRound;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the range
	 */
	public int[] getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int[] range) {
		this.range = range;
	}

	/**
	 * @return the speedFactor
	 */
	public int getSpeedFactor() {
		return speedFactor;
	}

	/**
	 * @param speedFactor the speedFactor to set
	 */
	public void setSpeedFactor(int speedFactor) {
		this.speedFactor = speedFactor;
	}


	/**
	 * @return the armorType
	 */
	public String getArmorType() {
		return armorType;
	}

	/**
	 * @param armorType the armorType to set
	 */
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}

	/**
	 * @return the weaponProfType
	 */
	public String getWeaponProfType() {
		return weaponProfType;
	}

	/**
	 * @param weaponProfType the weaponProfType to set
	 */
	public void setWeaponProfType(String weaponProfType) {
		this.weaponProfType = weaponProfType;
	}

	/**
	 * @return the weaponGroupType
	 */
	public String getWeaponGroupType() {
		return weaponGroupType;
	}

	/**
	 * @param weaponGroupType the weaponGroupType to set
	 */
	public void setWeaponGroupType(String weaponGroupType) {
		this.weaponGroupType = weaponGroupType;
	}

	/**
	 * @return the weaponTightGroupType
	 */
	public String getWeaponTightGroupType() {
		return weaponTightGroupType;
	}

	/**
	 * @param weaponTightGroupType the weaponTightGroupType to set
	 */
	public void setWeaponTightGroupType(String weaponTightGroupType) {
		this.weaponTightGroupType = weaponTightGroupType;
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the value
	 */
	public int[] getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int[] value) {
		this.value = value;
	}

	/**
	 * @return the features
	 */
	public ArrayList<String> getFeatures() {
		return features;
	}

	/**
	 * @param features the features to set
	 */
	public void setFeatures(ArrayList<String> features) {
		this.features = features;
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
	public EquipmentClass clone() {
		EquipmentClass oNew = new EquipmentClass();
		//TODO
		
		oNew.name = name;
		oNew.description = description;
		oNew.count = count;
		oNew.type = type;
		oNew.magic = magic;
		oNew.charges = charges;
		oNew.chargesMax = chargesMax;
		oNew.equipped = equipped;
		oNew.contains = contains;
		oNew.weight = weight;
		oNew.weaponType = weaponType;
		oNew.weaponGroupType = weaponGroupType;
		oNew.weaponTightGroupType = weaponTightGroupType;
		oNew.weaponProfType = weaponProfType;
		oNew.damageSmall = damageSmall;
		oNew.damageMedium = damageMedium;
		oNew.damageLarge = damageLarge;
		oNew.armorType = armorType;
		oNew.armorBulkType = armorBulkType;
		oNew.ac = ac;
		oNew.acBase = acBase;
		oNew.magicAdjustmentPrimary = magicAdjustmentPrimary;
		oNew.magicAdjustmentSecondary = magicAdjustmentSecondary;
		oNew.experience = experience;
		oNew.speedFactor = speedFactor;

		for(int i=0;i<MAX_COIN;i++)
			oNew.getValue()[i] = getValue()[i];
		
		if (range == null)
			range = new int[MAX_RANGES];
		for(int i=0;i<MAX_RANGES;i++)
			oNew.getRange()[i] = getRange()[i];

		for(String sType : getFeatures())
			oNew.getFeatures().add(sType);
		
		//oNew.setContains(new ArrayList<EquipmentClass>());
		if (getContains()!= null)
		for (EquipmentClass oS: getContains())
			oNew.getContains().add(oS.clone());
		
		if (attacksPerRound == null)
			attacksPerRound = new int[2];
		oNew.attacksPerRound[0] = getAttacksPerRound()[0];
		oNew.attacksPerRound[1] = getAttacksPerRound()[1];
		
		oNew.source = source;
		
		oNew.setMyID(getMyID());
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
	
	/**
	 * is weapon ranged?
	 * 
	 * @return
	 */
	public boolean isRangedWeapon() {
		boolean isRanged = false;
		if (getType() == GEAR_TYPE_WEAPON) {
		for(Integer i: getRange())
			if (i>0) {
				isRanged = true;
				break;
			}
		}
		return isRanged;
	}

	/** 
	 * return attacks per round in String format for display
	 * 
	 * @return
	 */
	public String getRoF() {
		int rof1 = getAttacksPerRound()[0];
		int rof2 = getAttacksPerRound()[1];
		if (rof2 <= 0)
			rof2 = 1;
		String sRoF = String.format("%d/%d", rof1,rof2);
		float rof = rof1/rof2;
		if (Math.rint(rof)== rof)
			sRoF = String.format("%d",(int)rof);
		
		//TODO need to get attacks per round from class
		//and/or specializations
		//** class overrides weapon, specialization overrides class
		
		return sRoF;
	}

	/**
	 * get EquipementClass object from ID
	 * @param myID
	 * @param eList
	 * @return
	 */
	public static EquipmentClass getEquipmentByID(String myID,EquipmentList eList) {
		EquipmentClass oFound = null;
		
		for(EquipmentClass o: eList.getContent()) 
			if (o.getMyID().equalsIgnoreCase(myID)) {
				oFound = o;
				break;
			}

		return(oFound);
	}

	
} // end EquipmentClass
