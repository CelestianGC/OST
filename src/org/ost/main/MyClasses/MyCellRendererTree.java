package org.ost.main.MyClasses;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;


/**
 * <p>Title: HackSACK</p>
 * <p>Description: HackMaster GM Tool</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Mike Wilson</p>
 * @author uce_mike@yahoo.com
 * @version 1.0
 */

public class MyCellRendererTree extends DefaultTreeCellRenderer {
  
	/**
	 * constructor 
	 */
	public MyCellRendererTree() {
	}

	/**
	 * 
	 */
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		if (value instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			if (node.getUserObject() instanceof String) {
				setText((String) node.getUserObject());
			}
//			 else if (node.getUserObject() instanceof AbilityStatClass) {
//				AbilityStatClass oQ = (AbilityStatClass) node.getUserObject();
//				setText(String.format("%s: %d/%d%%",oQ.getAbilityName(),
//						oQ.getAbilityScore(),oQ.getAbilityPercentile()));

//			} else if (node.getUserObject() instanceof RaceClass) {
//				RaceClass oQ = (RaceClass) node.getUserObject();
//				setText(oQ.getRaceName());
//			} 
			else if (node.getUserObject() instanceof StatesClass) {
				StatesClass oQ = (StatesClass) node.getUserObject();
				setText(oQ.getName());
			}	
//			 else if (node.getUserObject() instanceof ClassClass) {
//				ClassClass oQ = (ClassClass) node.getUserObject();
//				setText(oQ.getClassName());

//			} else if (node.getUserObject() instanceof RaceFeaturesClass) {
//				RaceFeaturesClass oQ = (RaceFeaturesClass) node.getUserObject();
//				setText(oQ.getFeatureDescription());
//			}
			 if (selected) {
			 setBackground(getBackgroundSelectionColor()); // background dont			 set for some reason
			 setForeground(getTextSelectionColor());
			 }
			 else {
			 setBackground(getBackgroundNonSelectionColor()); // background	 dont set for some reason
			 setForeground(getTextNonSelectionColor());
			 }
		}
		return this;
	}
}
