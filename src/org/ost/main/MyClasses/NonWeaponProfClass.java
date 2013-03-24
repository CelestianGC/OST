package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.UUID;

public class NonWeaponProfClass  implements Comparable{
	public String myID;
	public String name;
	public String description;
	public int cost;
	public int abilityBase; // what ability score is checked against this NWP 0..MAX_ABILITIES
	public int baseAdjustment; // base line ability adjustment -6 for non-rangers/etc
	public int perAdjustment; // bonus per rank of NWP
	
	public ArrayList<String> allowedClass;
	public ArrayList<String> allowedRace;
	
	public NonWeaponProfClass() {
		this("need-name","need-description");
	}
	
	public NonWeaponProfClass(String name, String description) {
		this(name,description,
				1,0,0,1,
				new ArrayList<String>(), new ArrayList<String>());
	}
	public NonWeaponProfClass(String name, String description, int cost, int abilityBase,
			int baseAdjustment, int perAdjustment,
			ArrayList<String> allowedClass, ArrayList<String> allowedRace) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.abilityBase = abilityBase;
		this.baseAdjustment = baseAdjustment;
		this.perAdjustment = perAdjustment;
		this.allowedClass = allowedClass;
		this.allowedRace = allowedRace;
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
	public int getAbilityBase() {
		return abilityBase;
	}
	/**
	 * @param abilityBase the abilityBase to set
	 */
	public void setAbilityBase(int abilityBase) {
		this.abilityBase = abilityBase;
	}
	/**
	 * @return the baseAdjustment
	 */
	public int getBaseAdjustment() {
		return baseAdjustment;
	}
	/**
	 * @param baseAdjustment the baseAdjustment to set
	 */
	public void setBaseAdjustment(int baseAdjustment) {
		this.baseAdjustment = baseAdjustment;
	}
	/**
	 * @return the perAdjustment
	 */
	public int getPerAdjustment() {
		return perAdjustment;
	}
	/**
	 * @param perAdjustment the perAdjustment to set
	 */
	public void setPerAdjustment(int perAdjustment) {
		this.perAdjustment = perAdjustment;
	}
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
	     return name.toUpperCase().compareTo(((NonWeaponProfClass)o).name.toUpperCase());		
	}

	
}
