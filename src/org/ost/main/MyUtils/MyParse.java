package org.ost.main.MyUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import static org.ost.main.MyClasses.MyStatics.*;
import java.util.List;
import java.util.regex.*;

import org.ost.main.DM_Config_Tab_Log;
import org.ost.main.MainClass;
import org.ost.main.MyClasses.TableClass;
import org.ost.main.MyClasses.TableRewardClass;
import org.ost.main.MyClasses.TreasureTableClass;

public class MyParse {
	public String	dice;
	//1d6 1d6+1 1d6+1*10 1d6-1 1d6-1*10 6+1d4 6+1d6*10
	static String diceParseRegEx =
		"((\\d+)[dD](\\d+))?((\\d+)\\-(\\d+))?((\\d+)\\+(\\d+))?((\\d+)\\*(\\d+))?"; 

	
	/**
	 * constructor
	 */
	public MyParse () {
		
	} // end constructor


	/**
	 * return true if we can find a valid dice roll somewhere in the string
	 * @param sDamage
	 * @return
	 */
	static boolean hasValidDamageDice(String sDamage) {
		Pattern checkRegex = Pattern.compile("\\d+d\\d+((\\+|\\-){1}\\d+)?", Pattern.CASE_INSENSITIVE);
		Matcher regexMatcher = checkRegex.matcher(sDamage);
		return(regexMatcher.find()); 
	}
	/**
	 * Does the string passed = xDx or xDx+x or xDx-x where x=number
	 * Does the string passed = x-x or x-x+x or x-x-x where x=number
	 * @param sDice
	 * @return
	 */
	static boolean isValidSingleDice(String sDice) {
		Pattern checkRegex = Pattern.compile("\\A\\d+[dD\\-]\\d+(([\\+\\-]){1}\\d+([\\-\\+dD]\\d+)?)?\\Z", 
				Pattern.CASE_INSENSITIVE);
		Matcher regexMatcher = checkRegex.matcher(sDice);
		int findCount = 0;
		
		while(regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) {
				findCount++;
//				SimpleDialog.showDone(String.format("group %d %s.", findCount, regexMatcher.group()));
			}
		}
		return(findCount == 1);
	} // end isValidDice
	
	/**
	 * 
	 * @param hdCalc
	 * @return
	 */
	public static int calculateMaxHitpoints(String hdCalc,MainClass ost) {
		return(calculateMaxHitpoints(hdCalc,8,ost));
	}
	/**
	 * generate hitpoints for hdCalc string
	 * 
	 * @param hdCalc
	 * @param hdSize
	 * @return
	 */
	public static int calculateMaxHitpoints(String hdCalc, int hdSize, MainClass ost) {
		int maxHP = 1;
		int numDice = 1;
		int numFaces = 1;
		int numAdjustment = 0;
		int numHitpoints = -1;
		char cAdj = '+';
		String regEX = 
			"\\A(\\d+)(([\\+\\-])(\\d+))?(([d\\-])(\\d+))?((\\+|\\-){1}?(\\d+)?)?(\\s?(hp|hit points))?\\Z";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher rMatch = checkRegex.matcher(hdCalc);
		
		if (rMatch.matches()) {
			if (rMatch.group(1) != null && //x 
				rMatch.group(12)!=null) {// hp or hit points
				// number is x hp or hit points
				numHitpoints = Integer.parseInt(rMatch.group(1));
				numDice = 0;
				numFaces = 0;
				cAdj = '+';
				numAdjustment = 0;
			}

			else if (rMatch.group(1) != null && //x 
					rMatch.group(3)!= null && //+ or -
					rMatch.group(4)!= null && //X
					rMatch.group(9)!=null && //+ or -
					rMatch.group(10)!=null) {// x
				// number is x-x + or - x
				numDice = Integer.parseInt(rMatch.group(1));
				numFaces = Integer.parseInt(rMatch.group(4));
				cAdj = rMatch.group(9).charAt(0);
				numAdjustment = Integer.parseInt(rMatch.group(10));
			}

			else if (rMatch.group(1) != null && //x 
					rMatch.group(6)!= null && //d or D
					rMatch.group(7)!= null && //x
					rMatch.group(9)!= null && //+ or -
					rMatch.group(10)!=null) {// x
				// number is xdx + or - x
				numDice = Integer.parseInt(rMatch.group(1));
				numFaces = Integer.parseInt(rMatch.group(7));
				cAdj = rMatch.group(9).charAt(0);
				numAdjustment = Integer.parseInt(rMatch.group(10));
			}

			else if (rMatch.group(1) != null && //x 
					rMatch.group(6)!= null && //d or D
					rMatch.group(7)!=null) {// x
				// number is xdx
				numDice = Integer.parseInt(rMatch.group(1));
				numFaces = Integer.parseInt(rMatch.group(7));
				cAdj = '+';
				numAdjustment = 0;
			}
			
			else if (rMatch.group(1) != null && //x 
					rMatch.group(3)!= null && //+ or -
					rMatch.group(4)!=null) {// x
				// number is x + or - x, this would be HD-X sorta thing
				// so we want xD(hdSize) + or - adjustment
				numDice = Integer.parseInt(rMatch.group(1));
				cAdj = rMatch.group(3).charAt(0);
				numAdjustment = Integer.parseInt(rMatch.group(4));
				numFaces = hdSize;
			}
			
			else if (rMatch.group(1)!=null) {// x
				// number is x
				numDice = Integer.parseInt(rMatch.group(1));
				numFaces = hdSize;
				cAdj = '+';
				numAdjustment = 0;
			} else {
				SimpleDialog.showError(String.format("Unknown HD format: (%s)", hdCalc));
				return(0);
			}
			
		} else {
			SimpleDialog.showError(String.format("Unknown HD type: (%s)", hdCalc));
			return(0);
		}
		
		if (numHitpoints > 0) {
			maxHP = numHitpoints;
		} else {
			// roll health, max, 80%, average or normally
			switch (ost.creatureHPType) {
			case GENERATION_HP_80:
				maxHP = (int) (numDice*numFaces*0.8);
				break;
			case GENERATION_HP_AVG: {	// figure out average, 4.5 but calc 
				int nData = 0;				// incase we allow hd size change later
				for(int i=1;i<=numFaces;i++)
					nData += i;
				int nAverage = nData/numFaces;
				maxHP = nAverage*numDice;
			} break;
			case GENERATION_HP_MAX:
				maxHP = numDice*numFaces;
				break;
			default:
				maxHP = MyRandomClass.rollDice(numDice, numFaces);				
				break;
			}
//			if (ost.creatureHPMax)
//				maxHP = numDice*numFaces;
//			else if (ost.creatureHP80)
//				maxHP = (int) (numDice*numFaces*0.8);
//			else if (ost.creatureHPAvg) {	// figure out average, 4.5 but calc 
//				int nData = 0;				// incase we allow hd size change later
//				for(int i=1;i<=numFaces;i++)
//					nData += i;
//				int nAverage = nData/numFaces;
//				maxHP = nAverage*numDice;
//			} else {
//				maxHP = MyRandomClass.rollDice(numDice, numFaces);
//			}
			
//			// if use max just calc max health otherwise roll
//			maxHP = useMax?numDice*numFaces : MyRandomClass.rollDice(numDice, numFaces);
			
			// now apply adjustments
			if (cAdj == '+')
				maxHP += numAdjustment;
			else
				maxHP -= numAdjustment;
		}
		
		if (maxHP < 1)
			maxHP = 1;
		
		DM_Config_Tab_Log.logit(String.format("Rolling Hitpoints %dD%d (%c%d)\nHP=%d\n",
				numDice,numFaces,cAdj,numAdjustment,maxHP));

		return(maxHP);
	}
	
	
	/**
	 * send string, return array of strings, each one a single valid damage dice roll
	 * 
	 * TODO need to rework this to use better string matching, not happy with it
	 * 
	 * @param damageDiceString
	 * @return
	 */
	public static ArrayList<String> getDamageDice(String damageDiceString) {
		ArrayList<String> diceList = (new ArrayList<String>());
		String splitters = "[/,]";
		// remove or by weapon text
		damageDiceString = damageDiceString.toLowerCase().replaceAll("\\s?or by weapon","");
		// replace "or" with / and just add all the attacks.
		damageDiceString = damageDiceString.toLowerCase().replaceAll("\\s+?or\\s+?","/");
		String[] diceSplit = damageDiceString.split(splitters);
		
		// regex to match (x2) on a string of 1d5(x2) or similar
		String multiRegex = "(\\(?x(\\d+)\\)?)";
		Pattern multiPattern = Pattern.compile(multiRegex,Pattern.CASE_INSENSITIVE);
		Matcher matchDamage;

		for (int i = 0; i < diceSplit.length; i++) {
			matchDamage = multiPattern.matcher(diceSplit[i]);
//diceList.add("1:"+i+":"+diceSplit[i]);		
			if (isValidSingleDice(diceSplit[i])) {
				diceList.add(diceSplit[i]);
DM_Config_Tab_Log.logit(String.format("Adding attack:%s\n",diceSplit[i]));
			} // end if isValidSingle
			else if (matchDamage.find()) {
				// pull out the multiplier string
				String singleAttack = diceSplit[i].toLowerCase().replaceAll(Pattern.quote(matchDamage.group(1)),"");
				if (isValidSingleDice(singleAttack)) {
				diceList.add(singleAttack);
DM_Config_Tab_Log.logit(String.format("Adding attack:%s\n",singleAttack));
					int numAttacks = Integer.parseInt(matchDamage.group(2).trim());
					for (int ii = 1;ii < numAttacks;ii++) {
						// add an attack for each number in the 1d6X2 string
DM_Config_Tab_Log.logit(String.format("Adding attack:%s\n",singleAttack));
						diceList.add(singleAttack);
					} // end for
				
			  } else {// end if isValidSingleDice(singleAttack)
DM_Config_Tab_Log.logit(String.format("No attacks matched in a:(%s)\n",diceSplit[i]));
			  }
			} else { // end if matches
DM_Config_Tab_Log.logit(String.format("No attacks matched in b:(%s)\n",diceSplit[i]));
			} // end else !matches
			
		} // end for
		
		return(diceList);
	}

	/**
	  * return regex first (group) found in sText ignoring case
	 * @param regEX
	 * @param sText
	 * @return
	 */
	public static String getString(String regEX, String sText) {
		return(getString(regEX,sText,1,true,Pattern.CASE_INSENSITIVE));
	}
	/**
	 * 
	 * @param regEX
	 * @param sText
	 * @param captureThis (grouping)
	 * @return
	 */
	public static String getString(String regEX, String sText,int captureThis) {
		return(getString(regEX,sText,captureThis,true,Pattern.CASE_INSENSITIVE));
	}

	/**
	 * 
	 * @param regEX
	 * @param sText
	 * @param captureThis
	 * @param reportError
	 * @param patternWise
	 * @return
	 */
	public static String getString(String regEX, String sText,int captureThis, boolean reportError, int patternWise) {
		String foundText = null;
//		Pattern checkPattern = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Pattern checkPattern = Pattern.compile(regEX, patternWise);
		Matcher checkMatcher = checkPattern.matcher(sText);
/*
		if (checkMatcher.matches()) {
			SimpleDialog.showDone(String.format("found group %s.", checkMatcher.group(0).trim()));
			foundText = checkMatcher.group(1).trim();
		} else {
			SimpleDialog.showDone(String.format("not found group"));
		}
		//String foundText = $1;
*/
		
		while(checkMatcher.find()) {
			if (checkMatcher.group().length() != 0) {
				foundText = checkMatcher.group(captureThis).trim();
//				SimpleDialog.showDone(String.format("group %s.", foundText));
				break;
			}
		}
		if (foundText==null && reportError) {
			SimpleDialog.showDone(String.format("No match using %s.", Pattern.quote(regEX)));
		}
		return(foundText);
	} // end isValidDice

	/**
	 * returns true if string is a number, false if not
	 * @param input
	 * @return
	 */
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e)
	   {
	      return false;
	   }
	}

	/**
	 * 
	 * @param dice
	 * @return
	 */
	static MyRandomClass getDice(String dice) {
		MyRandomClass oR = new MyRandomClass(1, 1);
//DM_Config_Tab_Log.logit(String.format("getDice:(%s) to (%s)\n",dice,fixDiceCalculations(dice)));
//		dice = fixDiceCalculations(dice); // don't need this, just set isRangedDice to true now

		String regEX = 
			"\\A(\\d+)([d\\-])(\\d+)(([\\+\\-])(\\d+))?\\Z";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher rMatch = checkRegex.matcher(dice);
		
		if (rMatch.matches()) {
			if (rMatch.group(1) != null && //x 
					rMatch.group(2)!= null && //D or -
					rMatch.group(3)!= null && //x
					rMatch.group(5)!= null && //- or +
					rMatch.group(6)!=null) {// d
					// number is x[d or -]x + or - x
				oR.setDiceNumber(Integer.parseInt(rMatch.group(1)));
				oR.setRangeDice(rMatch.group(2).equals("-"));
				oR.setDiceFaces(Integer.parseInt(rMatch.group(3)));
				// put +3 or -3 together
				if (rMatch.group(5).equalsIgnoreCase("+")) {
					oR.setDiceMod(Integer.parseInt(rMatch.group(6)));
				} else {
					//diceMod = String.format("%s%s",rMatch.group(5),rMatch.group(5));
					oR.setDiceMod(Integer.parseInt(rMatch.group(4)));
				}
				
				}

			else if (rMatch.group(1) != null && //x 
						rMatch.group(2)!= null && //D or -
						rMatch.group(3)!=null) {// x
					// number is x[d or -]x
				oR.setDiceNumber(Integer.parseInt(rMatch.group(1)));
				oR.setRangeDice(rMatch.group(2).equals("-"));
				oR.setDiceFaces(Integer.parseInt(rMatch.group(3)));
			} else {
				SimpleDialog.showError(String.format("Damage string format invalid.\n(%s)", dice));
			}

		}  else {// end if rMatch.matches
			SimpleDialog.showError(String.format("Damage string format type.\n(%s)", dice));
		}

		return(oR);
	} // end getDice
	

	/**
	 * 
	 * @param sText
	 * @return
	 */
	public static String parseDice(String sText) {
		return(parseDice(sText,true));
	}
	/**
	 * 
	 * @param sText
	 * @param debugMode
	 * @return
	 */
	public static String parseDice(String sText,boolean debugMode) {
//		String sTextOriginal = sText;

		sText = MyParse.parseDiceRangeRolls(sText,debugMode);
		sText = MyParse.parseDiceRolls(sText,debugMode);
		sText = MyParse.parseDiceAddition(sText,debugMode);
		sText = MyParse.parseDiceSubtraction(sText,debugMode);
		sText = MyParse.parseDiceMultiplication(sText,debugMode);
		
		// if we changed the string we need to run it again
		// this is because the string gets changed (3d6 is now 1 number)
//		if (!sTextOriginal.equals(sText))
//			sText = MyParse.parseDice(sText);
		
		return(sText);
	}
	
	/**
	 * 
	 * @param sText
	 * @return
	 */
	public static String parseDiceRolls(String sText, boolean debugMode) {
//		String sTextOriginal = sText;
		String regEX = "((\\d+)[dD](\\d+))";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(sText);

		while (m.find()) {
			String sReplacing = m.group(0);
			int diceNumber = 1;
			int diceFaces = 1;
			int diceRolled = 0;

			if (m.group(1) != null // \d+ D \d+
					&& m.group(2) != null // \d+
					&& m.group(3) != null // \d+
			) { // 3d10
				MyRandomClass oR = new MyRandomClass(1, 1);
				diceNumber = Integer.parseInt(m.group(2).trim());
				diceFaces = Integer.parseInt(m.group(3).trim());

				oR.setDiceNumber(diceNumber);
				oR.setRangeDice(false);
				oR.setDiceFaces(diceFaces);
				diceRolled = oR.rollRandomDice();
				if (debugMode)
				MainClass.ddprint(String.format(
						"parseDiceRolls(%s):xDx(%s) [%d]\n", sText, m.group(1),
						diceRolled));
			} else if (sReplacing.length() < 1) {
				// do nothing... we're done.
			} else {
				SimpleDialog
						.showError(String
								.format(
										"MyParse.parseDiceRolls() string format error.\nText =(%s)\nReplacing [%s]",
										sText, sReplacing));
			} // found nothing...

			if (sReplacing.length() > 0)
				sText = sText.replaceFirst(Pattern.quote(sReplacing), String
						.format("%d", diceRolled));
		} // end while (m.find()

		// if we changed the string we need to run it again
		// this is because the string gets changed (3d6 is now 1 number)
//		if (!sTextOriginal.equals(sText))
//			sText = MyParse.parseDiceRolls(sText);

		return (sText);
	}

	/**
	 * find "^x-x" | " x-x" dice rolls
	 * @param sText
	 * @return
	 */
	public static String parseDiceRangeRolls(String sText, boolean debugMode) {
//		String regEX = "((\\d+)\\-(\\d+))";
		String regEX = "(\\b)((\\d+)\\-(\\d+))(\\b)";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(sText);

		while (m.find()) {
			String sReplacing = m.group(2);
			String sDiceNumber = m.group(3);
			String sDiceFaces = m.group(4);
			String newValue = sReplacing;
			int diceNumber = 1;
			int diceFaces = 1;
			int diceRolled = 0;

			if (sReplacing != null // \d+ - \d+
					&& sDiceNumber != null // \d+
					&& sDiceFaces != null // \d+
			) { // 3-18
				MyRandomClass oR = new MyRandomClass(1, 1);
				diceNumber = Integer.parseInt(sDiceNumber);
				diceFaces = Integer.parseInt(sDiceFaces);

				// low end range can't exceed high end range
				if (diceNumber < diceFaces) {
				oR.setDiceNumber(diceNumber);
				oR.setRangeDice(true);
				oR.setDiceFaces(diceFaces);
				diceRolled = oR.rollRandomDice();
				newValue = String.format("%d", diceRolled);
				} else {
					if (debugMode)
						MainClass.ddprint(String.format(
						"parseDiceRangeRolls(%s):start range (%d) > end range (%d)\n", sText,diceNumber,diceFaces));
				}
				
				if (debugMode)
						MainClass.ddprint(String.format(
						"parseDiceRangeRolls(%s):x-x(%s) [%s]\n", sText, sReplacing,
						newValue));
			} else if (sReplacing.length() < 1) {
				if (debugMode)
					MainClass.ddprint(String.format(
					"parseDiceRangeRolls(%s):sReplacing.length() < 1\n", sText));
				// do nothing... we're done.
			} else {
				SimpleDialog
						.showError(String
								.format(
										"MyParse.parseDiceRangeRolls() string format error.\nText =(%s)\nReplacing [%s]",
										sText, sReplacing));
			} // found nothing...

			if (sReplacing.length() > 0)
				sText = sText.replaceFirst(Pattern.quote(sReplacing), newValue);
		} // end while (m.find()

		// if we changed the string we need to run it again
		// this is because the string gets changed (3d6 is now 1 number)
//		if (!sTextOriginal.equals(sText))
//			sText = MyParse.parseDiceRolls(sText);

		return (sText);
	}
	
	/**
	 * 
	 * @param sText
	 * @return
	 */
	public static String parseDiceAddition(String sText, boolean debugMode) {
		String sTextOriginal = sText;
		String regEX = "((\\d+)\\+(\\d+))";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(sText);
		
		while (m.find()) {
			String sReplacing = m.group(0);
			int diceNumber =1;
			int diceFaces =1;
			int diceRolled = 0;

			if (m.group(1) != null // \d+ + \d+
					&& m.group(2) != null // \d+
					&& m.group(3) != null // \d+
			) { // 5+3
				diceNumber = Integer.parseInt(m.group(2).trim());
				diceFaces = Integer.parseInt(m.group(3).trim());
				diceRolled = diceNumber + diceFaces;
				if (debugMode)
					MainClass.ddprint(String.format("parseDiceAddition(%s):x+x(%s) [%d]\n",
							sText,m.group(1),diceRolled));				
			}
			else if (sReplacing.length() < 1) {
				// do nothing... we're done.
			}
			else {
				SimpleDialog.showError(String.format("MyParse.parseDice() string format error.\nText =(%s)\nReplacing [%s]", 
						sText, sReplacing));
			} // found nothing...

			if (sReplacing.length() > 0)
			sText = sText.replaceFirst(Pattern.quote(sReplacing), String
					.format("%d", diceRolled));
		} // end while (m.find()
		
//		// if we changed the string we need to run it again
//		// this is because the string gets changed (3d6 is now 1 number)
//		if (!sTextOriginal.equals(sText))
//			sText = MyParse.parseDiceAddition(sText);
		
		return(sText);
	}

	public static String parseDiceSubtraction(String sText, boolean debugMode) {
		String sTextOriginal = sText;
		String regEX = "((\\d+)\\-(\\d+))";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(sText);
		
		while (m.find()) {
			String sReplacing = m.group(0);
			int diceNumber =1;
			int diceFaces =1;
			int diceRolled = 0;

			if (m.group(1) != null // \d+ - \d+
					&& m.group(2) != null // \d+
					&& m.group(3) != null // \d+
			) { // 10-10
				diceNumber = Integer.parseInt(m.group(2).trim());
				diceFaces = Integer.parseInt(m.group(3).trim());
				diceRolled = diceNumber - diceFaces;
				if (debugMode)
					MainClass.ddprint(String.format("parseDiceSubtraction(%s):x-x(%s) [%d]\n",
							sText,m.group(1),diceRolled));				
			} 
			else if (sReplacing.length() < 1) {
				// do nothing... we're done.
			}
			else {
				SimpleDialog.showError(String.format("MyParse.parseDice() string format error.\nText =(%s)\nReplacing [%s]", 
						sText, sReplacing));
			} // found nothing...

			if (sReplacing.length() > 0)
			sText = sText.replaceFirst(Pattern.quote(sReplacing), String
					.format("%d", diceRolled));
		} // end while (m.find()
		
		// if we changed the string we need to run it again
		// this is because the string gets changed (3d6 is now 1 number)
		if (!sTextOriginal.equals(sText))
			sText = MyParse.parseDiceSubtraction(sText,debugMode);
		
		return(sText);
	}

	public static String parseDiceMultiplication(String sText, boolean debugMode) {
//		String sTextOriginal = sText;
		String regEX = "((\\d+)\\*(\\d+))";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(sText);
		
		while (m.find()) {
			String sReplacing = m.group(0);
			int diceNumber =1;
			int diceFaces =1;
			int diceRolled = 0;

			if (m.group(1) != null // \d+ * \d+
					&& m.group(2) != null // \d+
					&& m.group(3) != null // \d+
			) { // 4*2
				diceNumber = Integer.parseInt(m.group(2).trim());
				diceFaces = Integer.parseInt(m.group(3).trim());
				diceRolled = diceNumber * diceFaces;
				if (debugMode)
					MainClass.ddprint(String.format("parseDiceMultiplication(%s):x*x(%s) [%d]\n",
							sText,m.group(1),diceRolled));				
			} 
			else if (sReplacing.length() < 1) {
				// do nothing... we're done.
			}
			else {
				SimpleDialog.showError(String.format("MyParse.parseDice() string format error.\nText =(%s)\nReplacing [%s]", 
						sText, sReplacing));
			} // found nothing...

			if (sReplacing.length() > 0)
			sText = sText.replaceFirst(Pattern.quote(sReplacing), String
					.format("%d", diceRolled));
		} // end while (m.find()
		
//		// if we changed the string we need to run it again
//		// this is because the string gets changed (3d6 is now 1 number)
//		if (!sTextOriginal.equals(sText))
//			sText = MyParse.parseDiceMultiplication(sText);
		
		return(sText);
	}


	/**
	 * parse the {ref:TableNameHere:maxroll:specificroll:numberofroll(:true)}
	 * 
	 * @param reward
	 * @return
	 */
	public static TableRewardClass parseTableReward(ArrayList<TableRewardClass> rewardList, 
						List<TableClass> tableList, TableRewardClass oR) {
		String regEX = "(\\{ref:([\\w\\d0-9\\-_\\+\\s\\\\/\\.\\,]+):(\\d+):(\\d+):(\\d+)(:(\\w+))?\\})";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(oR.getName());
MainClass.ddprint("---start parseTableReward of ("+oR.getName()+")---\n");
		while (m.find()) {
			String sReplacing = m.group(0);
			//String rewardData = "";
			String tableString = "";
			boolean ignoreRefs = true;
			int diceCap =0;
			int diceRolled =0;
			int runCount = 0;

			if (m.group(2) != null // TableName
					&& m.group(3) != null // \d+ highest roll
					&& m.group(4) != null // \d+ specified roll
					&& m.group(5) != null // \d+ number of times to run this ref
			) { // {ref:TableName:diceCap:diceRolled:runCount}
				tableString = m.group(2).trim();
				diceCap = Integer.parseInt(m.group(3).trim());
				diceRolled = Integer.parseInt(m.group(4).trim());
				runCount = Integer.parseInt(m.group(5).trim());
				if (m.group(7) != null)
					ignoreRefs = !m.group(7).trim().equalsIgnoreCase("true");
				
MainClass.ddprint(String.format("parseTableReward(%s):(%s)high(%d) spec[%d] count(%d) ignoreRefs(%s)\n",
				oR.getName(), tableString, diceCap,diceRolled,runCount,ignoreRefs?"TRUE":"FALSE"));	

			TableClass oT = TableClass.findTableClass(tableString, tableList);
			if (oT != null) {
			MyRandomClass oRand = new MyRandomClass(1, diceCap);

			if (diceCap == 0) // diceCap of 0 means use the tables cap
				oRand.setDiceFaces(oT.getHighestRoll());
			
			int diceFinalRoll = oRand.rollRandomDice();
			
			if (diceRolled != 0) // dice roll is specified, not random
				diceFinalRoll = diceRolled;

					// get the reward runCount times, have to have re-roll in
					// here if we have count > 1
					for (int i = 0; i < runCount; i++) {
MainClass.ddprint(String.format("---runcount count (%d)---\n",i));
						TreasureTableClass oTT = oT.getOneReward(tableList,
								diceFinalRoll, null, ignoreRefs);
						if (oTT != null) {
							// ArrayList<TableRewardClass> oRewards =
							// oT.getAllRewards(tableList, diceFinalRoll, null,
							// ignoreRefs);
							// ignore refs mean we're doing an inplace add so we
							// don't want to add
							// another rewardTable record, just update this one
							if (ignoreRefs) {
								if (oTT.getGoldvalue() != 0
										|| oTT.getExp() != 0) {
									String nameParsed = MyParse.parseDice(oTT
											.getName());
									String newName = String.format("%s%s",
											oR.getName(),
											oR.getName().length() > 0 ? ", "
													+ nameParsed : nameParsed);

									int iExp = oTT.getExp() < 0 ? 0 : oTT
											.getExp();
									int iGold = oTT.getGoldvalue() < 0 ? 0
											: oTT.getGoldvalue();
									oR.setName(newName);
									oR.setExpValue(oR.getExpValue() + iExp);
									oR.setGoldValue((oR.getGoldValue() + iGold));
									oR.appendDebugLog(String
											.format("debug>parseTableReward() Table(%s) INPLACE Reward (%s)\n",
													oT.getName(), oTT.getName()));
MainClass.ddprint(String.format("---adding (%s)---\n",oTT.getName()));									
								}
							} else {
								oT.getAllRewards(rewardList, tableList,
										diceFinalRoll, null, ignoreRefs);
							}
							diceFinalRoll = oRand.rollRandomDice();
						} // if oTT == null
						else {
							SimpleDialog
									.showError(String
											.format("MyParse.parseTableReward(%s) reward not found [%s] roll (%d)",
													oR.getName(), tableString,
													diceFinalRoll));
						}
					} // end runcount
					MainClass.ddprint("---replacing("
							+ Pattern.quote(sReplacing) + ", ) in ["
							+ oR.getName() + "]\n");
					// remove the {} block
					oR.setName(oR.getName().replaceFirst(
							Pattern.quote(sReplacing), ""));

			} else { // table not found
				SimpleDialog.showError(String.format("MyParse.parseTableReward(%s) table not found [%s]",oR.getName(),tableString ));
			}
			
			} 
			else if (sReplacing.length() < 1) {
				// do nothing... we're done.
			}
			else {
				SimpleDialog.showError(String.format("MyParse.parseTableReward() string format error.\nText =(%s)\nReplacing [%s]", 
						oR.getName(), sReplacing));
			} // found nothing...

		} // end while (m.find()
		
MainClass.ddprint("---END parseTableReward---\n");
		//return reward;
		return(oR);
	}

	/**
	 * return a gp value if found in string
	 * example: "trophy worth 16gp in poor condition" would return 16
	 * 
	 * @param sG1
	 * @return
	 */
	public static int findGPValuesInText(String sG1) {
		int iFound = -1;
		Matcher gpMatch = Pattern.compile(
				".*?((\\d+)(\\sgp|gp)).*?").matcher(sG1);
		if (gpMatch.matches()) {
			if (gpMatch.group(2) != null) {
				iFound = (Integer.parseInt(gpMatch.group(2).trim()));
			}
		}
		return(iFound);
	}
	
/**
 * display either decending or ascending AC depending on setting
 * 
 * @param ost
 * @param text
 * @return
 */
	public static String displayArmorClass(boolean d20Mode, String text) {
		String regEX = "([-]?\\d+)";
		Pattern checkRegex = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE);
		Matcher m = checkRegex.matcher(text);
		
		while (m.find()) {
			String sReplacing = m.group(1);
			if (MyParse.isInteger(sReplacing)) {
				int cAC = Integer.parseInt(sReplacing);
				if (d20Mode) {
					// convert Descending AC to Ascending
					if (cAC < 10)
						cAC = 20-(cAC);
				} else {
					// convert Ascending AC to decending
					if (cAC > 10)
						cAC = 20-(cAC);
				}
				text = text.replaceFirst(Pattern.quote(sReplacing), 
					String.format("%d", cAC));
			}

		} // end while find
		
		return(text);
	}
	
	

	/**
	 * parse integers with commas 
	 * 
	 * @param str
	 * @return
	 */
	public static int formattedIntegerParse(String str) {
			int nParsed = 0;
			NumberFormat nF = NumberFormat.getIntegerInstance(); 
			Number n = null;
			
			try {
				n = nF.parse(str);
			} catch (ParseException e1) {
				nParsed = 0;
				//e1.printStackTrace();
			}
			
			nParsed = n.intValue();

			return nParsed;
	}
	

} // end MyParse
