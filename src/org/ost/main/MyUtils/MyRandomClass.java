package org.ost.main.MyUtils;

import java.util.Random;
/**
 * 
 * @author Celestian
 *	random dice roll methods
 */
public class MyRandomClass {
	public int diceNumber;
	public int diceFaces;
	public int diceMod;
	public String log;
	public boolean isRangeDice; // dice is 1-5 4-19 not 3d6
	public boolean showDebug;	// debug
	public boolean perDice;		// add mod per dice?
	public boolean explodeDice; // explode dice on max roll
	private boolean exploding;  // we are dicing an exploded die.

	

	/**
	 * 
	 * @param num, number of dice to roll
	 * @param faces, number of faces on the dice (6 for a d6, 20 for a d20)
	 */
	public MyRandomClass(int num, int faces){
		this(num,faces,false);
	}
	/**
	 * 
	 * @param num
	 * @param faces
	 * @param bDebug
	 */
	public MyRandomClass(int num, int faces,boolean bDebug){
		setDiceNumber(num);
		setDiceFaces(faces);
		setDiceMod(0);
		setLog("");
		setShowDebug(bDebug);
		setExplodeDice(false);
		setPerDice(false);
		setRangeDice(false);
	}

	

	/**
	 * @return the exploding
	 */
	public boolean isExploding() {
		return exploding;
	}

	/**
	 * @param exploding the exploding to set
	 */
	public void setExploding(boolean exploding) {
		this.exploding = exploding;
	}

	/**
	 * @return the diceMod
	 */
	public int getDiceMod() {
		return diceMod;
	}


	/**
	 * @param diceMod the diceMod to set
	 */
	public void setDiceMod(int diceMod) {
		this.diceMod = diceMod;
	}


	/**
	 * @return the perDice
	 */
	public boolean isPerDice() {
		return perDice;
	}


	/**
	 * @param perDice the perDice to set
	 */
	public void setPerDice(boolean bPerDice) {
		this.perDice = bPerDice;
	}


	/**
	 * @return the explodeDice
	 */
	public boolean isExplodeDice() {
		return explodeDice;
	}


	/**
	 * @param explodeDice the explodeDice to set
	 */
	public void setExplodeDice(boolean explodeDice) {
		this.explodeDice = explodeDice;
	}


	/**
	 * @return the showDebug
	 */
	public boolean isShowDebug() {
		return showDebug;
	}


	/**
	 * @param showDebug the showDebug to set
	 */
	public void setShowDebug(boolean showDebug) {
		this.showDebug = showDebug;
	}

	/**
	 * @return the isRangeDice
	 */
	public boolean isRangeDice() {
		return isRangeDice;
	}

	/**
	 * @param isRangeDice the isRangeDice to set
	 */
	public void setRangeDice(boolean isRangeDice) {
		this.isRangeDice = isRangeDice;
	}

	/**
	 * Simple dice roll
	 *  
	 * @param numDice number of dice to roll
	 * @param numFaces number of faces on dice
	 * @return result of dice rolled
	 */
	public static int rollDice(int numDice, int numFaces){
		int totalRoll = 0;
		Random r = new Random();

		for(int iCount=1;iCount<=numDice;iCount++){
			totalRoll += (1 + r.nextInt(numFaces));
		}
		
		return totalRoll;	
	}
	
/**
 * 
 * @return the result of the dice rolled
 */
	public int rollRandomDice(){
		int totalRoll = 0;
		if (!isRangeDice()) { // not a range, use 3d6 style mode
			Random r = new Random();
			int diceToCount = getDiceNumber();

			// if this is an explosion, we only want to add one dice
			if (isExploding())
				diceToCount = 1;

			for (int iCount = 1; iCount <= diceToCount; iCount++) {
				int thisRoll = (1 + r.nextInt(getDiceFaces()));
				setLog(String.format("%s%s%d", getLog(), (getLog() != "" ? ","
						: ""), thisRoll));
				// roll is max then we add another roll if isExplodeDice()
				if (isExplodeDice() && thisRoll == getDiceFaces()) {
					setExploding(true);
					thisRoll += rollRandomDice();
				}
				if (isPerDice()) {
					thisRoll += getDiceMod();
					setLog(String.format("%s%s%d", getLog(),
							(getDiceMod() >= 0 ? "+" : ""), getDiceMod()));
				}
				totalRoll += thisRoll;
			}

			if (!isPerDice() && getDiceMod() != 0) {
				totalRoll += getDiceMod();
				setLog(String.format("%s%s%d", getLog(),
						(getDiceMod() >= 0 ? "+" : ""), getDiceMod()));
			}
		} else { // isRangedDice
			totalRoll = rollRandomRangeDice();
		}
		return totalRoll;
	}

	  
	/**
	 *roll a range 3-12, 8-19 not 2d6 or the like
	 *
	 *no exploding or perMod used here, it's a range
	 * 
	 * @return
	 */
	  public int rollRandomRangeDice(){
	    if ( getDiceNumber() > getDiceFaces() ) {
	      throw new IllegalArgumentException("Start dice size cannot exceed End dice size.");
	    }
	    int aStart = getDiceNumber();
	    int aEnd = getDiceFaces();
		Random r = new Random();
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * r.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);

	    setLog(String.format("%s%s%d", getLog(), (getLog() != "" ? ",": ""), randomNumber));

	    if (getDiceMod() != 0) {
		setLog(String.format("%s%s%d", getLog(),
				(getDiceMod() >= 0 ? "+" : ""), getDiceMod()));
    	randomNumber += getDiceMod();
    	}

	    return (randomNumber);
	  }

	  /**
	   * roll Range of dice 3-17 or 4-19
	   * 
	   * @param aStart
	   * @param aEnd
	   * @return
	   */
	  public static int rollRangeDice(int aStart, int aEnd){
		 return((new MyRandomClass(aStart,aEnd).rollRandomRangeDice()));
	  }
	  
	  /**
	   * return result of 1d100 roll
	   * @return
	   */
	  public static int getPercent() {
		  return((new MyRandomClass(1,100).rollRandomDice()));
	  }
	/**
	 * @return the diceNumber
	 */
	public int getDiceNumber() {
		return diceNumber;
	}

	/**
	 * @param diceNumber the diceNumber to set
	 */
	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}

	/**
	 * @return the diceFaces
	 */
	public int getDiceFaces() {
		return diceFaces;
	}

	/**
	 * @param diceFaces the diceFaces to set
	 */
	public void setDiceFaces(int diceFaces) {
		this.diceFaces = diceFaces;
	}

	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
}
