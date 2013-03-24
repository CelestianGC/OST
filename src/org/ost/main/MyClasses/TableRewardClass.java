package org.ost.main.MyClasses;

import java.util.ArrayList;
import java.util.List;

import org.ost.main.MainClass;
import org.ost.main.MyUtils.MyParse;

public class TableRewardClass {
	String name;
	int count;
	int goldValue;
	int expValue;
	String debugLog;	
	
	/**
	 * 
	 * @param sName
	 */
	public TableRewardClass(String sName) {
		this(sName,1,0,0);
	}
	/**
	 * 
	 * @param sName
	 * @param iCount
	 * @param iGold
	 * @param iExp
	 */
	public TableRewardClass(String sName, int iCount, int iGold, int iExp) {
		setName(sName);
		setCount(iCount);
		setGoldValue(iGold);
		setExpValue(iExp);
		setDebugLog("");
	} // end constructor


	/**
	 * @return the debugLog
	 */
	public String getDebugLog() {
		return debugLog;
	}
	/**
	 * @param debugLog the debugLog to set
	 */
	public void setDebugLog(String debugLog) {
		this.debugLog = debugLog;
	}
	/**
	 * @param debugLog the debugLog to set
	 */
	public void appendDebugLog(String debugLog) {
		this.debugLog += debugLog;
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
	 * @return the goldValue
	 */
	public int getGoldValue() {
		return goldValue;
	}

	/**
	 * @param goldValue the goldValue to set
	 */
	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}

	/**
	 * @return the expValue
	 */
	public int getExpValue() {
		return expValue;
	}

	/**
	 * @param expValue the expValue to set
	 */
	public void setExpValue(int expValue) {
		this.expValue = expValue;
	}
	

	/**
	 * 
	 * @param rewardList
	 * @param tableList
	 */
	public void parseRewardMacros(ArrayList<TableRewardClass> rewardList, List<TableClass> tableList) {
		TableRewardClass oTmp = MyParse.parseTableReward(rewardList, tableList, this);
		setName(oTmp.getName());
		setExpValue(oTmp.getExpValue());
		setDebugLog(oTmp.getDebugLog());
	}
	/**
	 * 
	 * @param oRewards
	 * @return
	 */
	public static String getRewardOutput(ArrayList<TableRewardClass> oRewards) {
		String sOutput = "";
		//int iCount = 0;
		int iExp = 0;
		int iGold = 0;
		
		TableClass.consolidateRewards(oRewards);
		
		for (TableRewardClass oR : oRewards) {
			String sNumbers = "";
			//iCount += oR.getCount() > 0 ? oR.getCount() : 0;
			iGold += oR.getGoldValue() > 0 ? oR.getGoldValue() : 0;
			iExp += oR.getExpValue() > 0 ? oR.getExpValue() : 0;

			if (oR.getExpValue()>0 || oR.getGoldValue()>0)
			sNumbers = String.format(" (xp:%d gp:%d)", 
					oR.getExpValue(),oR.getGoldValue());
			String sCount = String.format("%d", oR.getCount());
			sOutput += String.format("%s%s%s\n", oR.getName(),
					(oR.getCount()>1?" x"+sCount:" "),
					sNumbers.length()>0?sNumbers:"");

		} // end for
		if (iExp > 0 || iGold > 0)
			sOutput += String.format("\n----Totals\nExperience:%d\nGold:%d\n", iExp,
				iGold);
		else 
			sOutput += "\n";
		
		MainClass.ddprint("----------end treasure-----------\n");
		oRewards.clear(); // now that we've displayed it remove it all

		return (sOutput);
	}

} // end TableRewardClass
