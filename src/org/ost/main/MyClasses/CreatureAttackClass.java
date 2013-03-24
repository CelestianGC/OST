package org.ost.main.MyClasses;

import java.io.Serializable;

import org.jdom.Element;
import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;


public class CreatureAttackClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int attackNumber;
	public String attackName;
	public String damageDice;
	public int attackMod;
	public int damageMod;
	public boolean attackDone;
	public boolean damageDone;
	
	/**
	 * 
	 */
	public CreatureAttackClass() {
		this("1d6",0);
	}

	/**
	 * 
	 * @param dDice
	 * @param atkNum
	 */
	public CreatureAttackClass(String dDice, int atkNum) {
		this.setAttackDone(false);
		this.setDamageDone(false);
		this.setDamageDice(dDice);
		this.setAttackNumber(atkNum);
		this.setAttackName(String.format("%d",this.getAttackNumber()));
		this.setDamageMod(0);
		this.setAttackMod(0);
	} // end constructor

	
	/**
	 * @return the attackName
	 */
	public String getAttackName() {
		return attackName;
	}

	/**
	 * @param attackName the attackName to set
	 */
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	/**
	 * @return the attackMod
	 */
	public int getAttackMod() {
		return attackMod;
	}

	/**
	 * @param attackMod the attackMod to set
	 */
	public void setAttackMod(int attackMod) {
		this.attackMod = attackMod;
	}

	/**
	 * @return the damageMod
	 */
	public int getDamageMod() {
		return damageMod;
	}

	/**
	 * @param damageMod the damageMod to set
	 */
	public void setDamageMod(int damageMod) {
		this.damageMod = damageMod;
	}

	/**
	 * @return the attackNumber
	 */
	public int getAttackNumber() {
		return attackNumber;
	}
	/**
	 * @param attackNumber the attackNumber to set
	 */
	public void setAttackNumber(int attackNumber) {
		this.attackNumber = attackNumber;
	}
	/**
	 * @return the damageDice
	 */
	public String getDamageDice() {
		return damageDice;
	}

	/**
	 * @param damageDice the damageDice to set
	 */
	public void setDamageDice(String damageDice) {
		this.damageDice = damageDice;
	}

	/**
	 * @return the attackDone
	 */
	public boolean isAttackDone() {
		return attackDone;
	}

	/**
	 * @param attackDone the attackDone to set
	 */
	public void setAttackDone(boolean attackDone) {
		this.attackDone = attackDone;
	}

	/**
	 * @return the damageDone
	 */
	public boolean isDamageDone() {
		return damageDone;
	}

	/**
	 * @param damageDone the damageDone to set
	 */
	public void setDamageDone(boolean damageDone) {
		this.damageDone = damageDone;
	}

	//-------------------------------------------------------------------
		/**
		 * returns item as Element for XML output
		 * @return
		 */
		public Element getAsElement(){
			Element eE = new Element("Attack");
			try {
				// strings
				eE.addContent(new Element("attackName").setText(XMLControl.escapeChars(attackName)));	
				eE.addContent(new Element("damageDice").setText(XMLControl.escapeChars(damageDice)));

				// ints
				eE.addContent(new Element("attackNumber").setText(String.format("%d",attackNumber)));
				eE.addContent(new Element("attackMod").setText(String.format("%d",attackMod)));
				eE.addContent(new Element("damageMod").setText(String.format("%d",damageMod)));
				
				// booleans
				eE.addContent(new Element("attackDone").setText(String.format("%s",attackDone?"TRUE":"FALSE")));
				eE.addContent(new Element("damageDone").setText(String.format("%s",damageDone?"TRUE":"FALSE")));
				
			}
		    catch (java.lang.OutOfMemoryError err) {
		      SimpleDialog.showError("Out of memory error while trying to save CreatureAttackClass-Attack.\nError:" +
		                        err.getLocalizedMessage());
		    }
			return eE;
		}

		/**
		 * return Class from element list pulled from XMl file.
		 * @param eItem
		 * @return
		 */
		public static CreatureAttackClass getFromElements(Element eItem) {
			CreatureAttackClass oO = new CreatureAttackClass();

		    // text
			try {		
				oO.setAttackName(XMLControl.unEscapeChars(eItem.getChild("attackName").getText()));		
			} catch (NullPointerException err) {
				oO.setAttackName("Unknown atk-name in XML");
			}
			try {		
				oO.setDamageDice(XMLControl.unEscapeChars(eItem.getChild("damageDice").getText()));		
			} catch (NullPointerException err) {
				oO.setDamageDice("Unknown atk-dmg in XML");
			}

			// numbers
			try {
				oO.setAttackNumber(Integer.parseInt(eItem.getChild("attackNumber").getText()));
			} catch (NullPointerException err) {
				oO.setAttackNumber(0);
			}

			try {
				oO.setAttackMod(Integer.parseInt(eItem.getChild("attackMod")
						.getText()));
			} catch (NullPointerException err) {
				oO.setAttackMod(0);
			}

			try {
				oO.setDamageMod(Integer.parseInt(eItem.getChild("damageMod").getText()));
			} catch (NullPointerException err) {
				oO.setDamageMod(0);
			}

			// booleans
			try {
				oO.setAttackDone(eItem.getChild("attackDone").getText().equalsIgnoreCase("TRUE"));
			} catch (NullPointerException err) {
				oO.setAttackDone(false);
			}
				
			try {
				oO.setDamageDone(eItem.getChild("damageDone").getText().equalsIgnoreCase("TRUE"));
			} catch (NullPointerException err) {
				oO.setDamageDone(false);
			}
		    return oO;
		}
		
		//TODO make sure this works
		/**
		 * return a cloned copy of this CreatureAttackClass
		 * @return
		 */
		public CreatureAttackClass cloneMe() {
			CreatureAttackClass oA = new CreatureAttackClass();
			oA.setAttackDone(attackDone);
			oA.setDamageDone(damageDone);
			oA.setDamageDice(getDamageDice());
			oA.setAttackNumber(getAttackNumber());
			oA.setAttackName(getAttackName());
			oA.setDamageMod(getDamageMod());
			oA.setAttackMod(getAttackMod());
			
			return(oA);
		}
}// end CreatureAttackClass


