package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.*;

import java.util.UUID;

/**
 * 
 * @author Celestian
 *
 * skills, thieves in theory, possibly others later.
 *
 */
public class SkillsClass {
	public String name;
	public String abbrev;
	public int score;
	public int min;
	public int max;
	public boolean allowed;
//	public String myID;
	
	
	public SkillsClass(String name, String abbrev, int score) {
		this(name,abbrev,score,-200,200,true,"");
	}
	
	public SkillsClass(String name, String abbrev, int score, int min, int max,
			boolean allowed, String myID) {
		super();
		this.name = name;
		this.abbrev = abbrev;
		this.score = score;
		this.min = min;
		this.max = max;
		this.allowed = allowed;
	
		//this.myID = myID;
//		this.setMyID(UUID.randomUUID().toString());
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
	 * @return the abbrev
	 */
	public String getAbbrev() {
		return abbrev;
	}
	/**
	 * @param abbrev the abbrev to set
	 */
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	/**
	 * @return the allowed
	 */
	public boolean isAllowed() {
		return allowed;
	}
	/**
	 * @param allowed the allowed to set
	 */
	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
	/**
	 * @return the myID
	 */

	/**
	 * return a clone/new version of this object
	 * 
	 * @return
	 */
	public SkillsClass cloneMe() {
		SkillsClass newMe = 
				new SkillsClass(name, abbrev, score, min, max, allowed, "");
		
		return newMe;
	}

	
}
