package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.*;

import java.util.ArrayList;

import org.ost.main.MainClass;

public class AbilityScoreClass {
	public int score;
	public int percentile;
	public String name;
	public String abbrev;
	public int min;
	public int max;
	public boolean primeRequisite;
	public boolean allowExceptional;
	
	
	public AbilityScoreClass(int score, int percentile, String name,
			String abbrev) {
		this(score,percentile,name,abbrev,0,25);
	}

	public AbilityScoreClass(int score, int percentile, String name,
			String abbrev, int min, int max) {
		super();
		this.score = score;
		this.percentile = percentile;
		this.name = name;
		this.abbrev = abbrev;
		this.max = max;
		this.min = min;
	}
	
	
	/**
	 * @return the primeRequisite
	 */
	public boolean isPrimeRequisite() {
		return primeRequisite;
	}

	/**
	 * @param primeRequisite the primeRequisite to set
	 */
	public void setPrimeRequisite(boolean primeRequisite) {
		this.primeRequisite = primeRequisite;
	}

	/**
	 * @return the allowExceptional
	 */
	public boolean isAllowExceptional() {
		return allowExceptional;
	}

	/**
	 * @param allowExceptional the allowExceptional to set
	 */
	public void setAllowExceptional(boolean allowExceptional) {
		this.allowExceptional = allowExceptional;
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
	 * @return the percentile
	 */
	public int getPercentile() {
		return percentile;
	}
	/**
	 * @param percentile the percentile to set
	 */
	public void setPercentile(int percentile) {
		this.percentile = percentile;
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
	 * return a clone/new version of this object
	 * 
	 * @return
	 */
	public AbilityScoreClass cloneMe() {
		AbilityScoreClass newMe = 
				new AbilityScoreClass(score, percentile, name, abbrev, min, max);
		newMe.setAllowExceptional(allowExceptional);
		newMe.setPrimeRequisite(primeRequisite);
		return newMe;
	}
	
}
