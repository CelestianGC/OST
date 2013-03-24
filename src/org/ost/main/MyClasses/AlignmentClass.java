package org.ost.main.MyClasses;

import static org.ost.main.MyClasses.MyStatics.*;
import java.util.ArrayList;

public class AlignmentClass {
	public String name;
	public String abbreviation;
	public String description;
	
	
	public AlignmentClass(String name, String description, String abbreviation) {
		this.name = name;
		this.description = description;
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
	

	public static ArrayList<AlignmentClass> getAlignmentList() {
		ArrayList<AlignmentClass> aList = new ArrayList<AlignmentClass>();
		for (int i=0;i<MAX_ALIGNMENT;i++) {
			AlignmentClass oA = new AlignmentClass(ALIGNMENTS[i],
													ALIGNMENTS[i],
													ALIGNMENTS_ABBREV[i]);
			aList.add(oA);
		}
		
		return aList;
	}
}
