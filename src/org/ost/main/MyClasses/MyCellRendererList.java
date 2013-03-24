package org.ost.main.MyClasses;

import java.awt.*;
import static org.ost.main.MyClasses.MyStatics.*;
import javax.swing.*;


/**
 * @author uce_mike@yahoo.com
 * @version 1.0
 * generic combobox cell in pulldown
 */

public class MyCellRendererList extends DefaultListCellRenderer {

	/**
	 * constructor 
	 */
	public MyCellRendererList() {
	}

	/**
	 * 
	 */
	public Component getListCellRendererComponent(JList list, Object value,
			int nIndex, boolean bisSelected, boolean bHasFocus) {
		boolean bChangeFont = true;

			if (value instanceof CreatureClass) {
			CreatureClass oO = (CreatureClass) value;
			setText(oO.getName());
		} else
			if (value instanceof PlayerClass) {
				PlayerClass oO = (PlayerClass) value;
			setText(oO.getName());
		}
			else if (value instanceof CharacterClass) {
				CharacterClass oO = (CharacterClass) value;
				setText(oO.getName());
			}
			else if (value instanceof ExtraAbilitiesClass) {
				ExtraAbilitiesClass oO = (ExtraAbilitiesClass) value;
				String name = String.format("[%s]%s",
									EXTRA_ABILITY_NAMES[oO.getType()],
									oO.getName());
			setText(name);
			}
			else if (value instanceof EquipmentClass) {
				EquipmentClass oO = (EquipmentClass) value;
				String name = String.format("[%s]%s",
									GEAR_NAMES[oO.getType()],
									oO.getName());
			setText(name);
			}
			else if (value instanceof RaceClass) {
				RaceClass oO = (RaceClass) value;
			setText(oO.getName());
			}
			
			else if (value instanceof StatesClass) {
			StatesClass oO = (StatesClass) value;
			setText(oO.getName());
			//
			setToolTipText(String.format("%d rounds left: %s", 
					oO.getCounter(),oO.getDescription()));
			// this is to be a small object font in the list
			if (oO.isbSmallFont()) {
				bChangeFont = false;
				setFont(new Font("Dialog", Font.PLAIN, 8));
				if (oO.getCounter() < 9 && oO.getCounter() > 3)
					setForeground(Color.blue);
				else if (oO.getCounter() <= 3)
					setForeground(Color.red);
				else
					setForeground(Color.black);
				if (bisSelected) {
					setBackground(Color.BLACK);
					setForeground(Color.YELLOW);
				} else {
				setBackground(new Color(204,204,204));
				}
			}
		}
		else if (value instanceof TableClass) {
			TableClass oO = (TableClass) value;
			setText(oO.getName());
		}
		else if (value instanceof TreasureTableClass) {
			TreasureTableClass oO = (TreasureTableClass) value;
			setText(oO.getName());
		}
		else if (value instanceof ChartClass) {
			ChartClass oO = (ChartClass) value;
			setText(oO.getName());
		}
		else if (value instanceof NonWeaponProfClass) {
			NonWeaponProfClass oO = (NonWeaponProfClass) value;
			setText(oO.getName());
		}
		else if (value instanceof WeaponProfClass) {
			WeaponProfClass oO = (WeaponProfClass) value;
			setText(oO.getName());
		}
		else { // just string, not a creature, probably NO-TARGET
			setText((String) value);
		}

		if (bChangeFont) {
			// setFont(new Font("Dialog", Font.PLAIN, 10));
			setBackground(bisSelected ? Color.BLACK : Color.lightGray);
			setForeground(bisSelected ? Color.YELLOW : Color.black);
		}
		return this;
	}

}
