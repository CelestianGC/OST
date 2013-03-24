package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.UUID;

public class WeaponProfClass  implements Comparable{
	public String myID;
	public String name;
	public String description;
	public int cost;
	
	public ArrayList<String> allowedClass;
	public ArrayList<String> allowedRace;
	public ArrayList<String> allowedWeapons; // which weapons does this match in gear list
	
	public int attackAdjustment;
	public int damageAdjustment;
	public int speedAdjustment;

	public ArrayList<String> preReqWeaponProfs; // must have these weapon profs before can get this one

	public WeaponProfClass() {
		this("need-name","need-description");
	}
	
	public WeaponProfClass(String name, String description) {
		this(name,description,
				1,new ArrayList<String>()
				,new ArrayList<String>(),new ArrayList<String>(),
				0,0,0,
				new ArrayList<String>());
	}
	
	public WeaponProfClass(String name, String description,
			int cost, ArrayList<String> allowedClass,
			ArrayList<String> allowedRace, ArrayList<String> allowedWeapons,
			int attackAdjustment, int damageAdjustment, int speedAdjustment,
			ArrayList<String> preReqsWeapon) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.allowedClass = allowedClass;
		this.allowedRace = allowedRace;
		this.allowedWeapons = allowedWeapons;
		this.attackAdjustment = attackAdjustment;
		this.damageAdjustment = damageAdjustment;
		this.speedAdjustment = speedAdjustment;
		this.preReqWeaponProfs = preReqsWeapon;
		this.setMyID(UUID.randomUUID().toString());
	}

	/**
	 * @return the preReqWeaponProfs
	 */
	public ArrayList<String> getPreReqWeaponProfs() {
		return preReqWeaponProfs;
	}

	/**
	 * @param preReqWeaponProfs the preReqWeaponProfs to set
	 */
	public void setPreReqWeaponProfs(ArrayList<String> preReqWeaponProfs) {
		this.preReqWeaponProfs = preReqWeaponProfs;
	}

	/**
	 * @return the attackAdjustment
	 */
	public int getAttackAdjustment() {
		return attackAdjustment;
	}

	/**
	 * @param attackAdjustment the attackAdjustment to set
	 */
	public void setAttackAdjustment(int attackAdjustment) {
		this.attackAdjustment = attackAdjustment;
	}

	/**
	 * @return the damageAdjustment
	 */
	public int getDamageAdjustment() {
		return damageAdjustment;
	}

	/**
	 * @param damageAdjustment the damageAdjustment to set
	 */
	public void setDamageAdjustment(int damageAdjustment) {
		this.damageAdjustment = damageAdjustment;
	}

	/**
	 * @return the speedAdjustment
	 */
	public int getSpeedAdjustment() {
		return speedAdjustment;
	}

	/**
	 * @param speedAdjustment the speedAdjustment to set
	 */
	public void setSpeedAdjustment(int speedAdjustment) {
		this.speedAdjustment = speedAdjustment;
	}

	/**
	 * @return the allowedWeapons
	 */
	public ArrayList<String> getAllowedWeapons() {
		return allowedWeapons;
	}

	/**
	 * @param allowedWeapons the allowedWeapons to set
	 */
	public void setAllowedWeapons(ArrayList<String> allowedWeapons) {
		this.allowedWeapons = allowedWeapons;
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
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	/**
	 * @return the abilityBase
	 */
	/**
	 * @return the allowedClass
	 */
	public ArrayList<String> getAllowedClass() {
		return allowedClass;
	}
	/**
	 * @param allowedClass the allowedClass to set
	 */
	public void setAllowedClass(ArrayList<String> allowedClass) {
		this.allowedClass = allowedClass;
	}
	/**
	 * @return the allowedRace
	 */
	public ArrayList<String> getAllowedRace() {
		return allowedRace;
	}
	/**
	 * @param allowedRace the allowedRace to set
	 */
	public void setAllowedRace(ArrayList<String> allowedRace) {
		this.allowedRace = allowedRace;
	}

	@Override
	public int compareTo(Object o) {
	     return name.toUpperCase().compareTo(((WeaponProfClass)o).name.toUpperCase());		
	}

	
	/**
	 * return an array of objects allowed from allowedList 
	 * 
	 * @param allowedList
	 * @param lList
	 * @return
	 */
	public static ArrayList<WeaponProfClass> getAllowed(ArrayList<String> allowedList, 
			WeaponProfList lList) {
		ArrayList<WeaponProfClass> aList = new ArrayList<WeaponProfClass>();

		for(WeaponProfClass o: lList.getContent()) 
			for (String idName: allowedList) {
				if (o.getMyID().equalsIgnoreCase(idName))
					aList.add(o);
			}

		return(aList);
	}

	/**
	 * return arrayList of objects myIDs.
	 * 
	 * @param allowedObject
	 * @return
	 */
	public static ArrayList<String> getAllowedAsString(ArrayList<WeaponProfClass> allowedObject) {
		ArrayList<String> aList = new ArrayList<String>();

		for (WeaponProfClass o: allowedObject)
			aList.add(o.getMyID());

		return aList;
	}

	
}
