/*
 * Option_AskFor_Alignment.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import static org.ost.main.MyClasses.MyStatics.*;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Alignment extends javax.swing.JDialog {
	private MainClass ost;
	private java.awt.Frame parent;
	private String[] aNames;
	private String[] aAbbrevs;
	private ArrayList<JCheckBox> alignBoxes;
	private boolean[] currentAlignment;

	public Option_AskFor_Alignment(java.awt.Frame parent, boolean modal,
			MainClass ost, String sTitle, boolean[] alignments, String[] names,
			String[] abbrevs) {
		super(parent, modal);
		this.parent = parent;
		this.ost = ost;
		this.aNames = names;
		this.aAbbrevs = abbrevs;
		this.currentAlignment = alignments;
		initComponents();

		setTitle(sTitle);
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), sTitle,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		alignBoxes = new ArrayList<JCheckBox>();

		updatePanel(currentAlignment);

		setLocationRelativeTo(parent);
		setSize(400, 220);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		buttonsPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "TitleGoesHere",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.GridLayout(0, 3));
		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonsPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(doneButton);

		getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		updateValuesFromCheckBox();
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		setVisible(false);
		formWindowClosed(null);
	}

	/**
	 * put the spinner values into the abilities array
	 * 
	 * @return
	 */
	public boolean[] updateValuesFromCheckBox() {
		int i = 0;
		for (JCheckBox bBoo : alignBoxes) {
			currentAlignment[i] = bBoo.isSelected();
			i++;
		}
		return (currentAlignment);
	}

	/**
	 * load thief alignBoxes onto panel and activate only those marked "active"
	 * or all of active is null
	 * 
	 * second parameter is an array of boolean that can be used to make 
	 * certain thief skills not avaliable such as a monk or assassin that 
	 * does not get the full array of thief skills.
	 * 
	 * @param alignBoxes
	 * @param active
	 */
	void updatePanel(boolean[] bAligns) {
		//		int i = MAX_ABILITIES;
		Font fFont = new Font("Segoe UI", 0, 12);
		FlowLayout lFlow = new FlowLayout(FlowLayout.LEFT, 0, 1);
		GridLayout gLayout = new GridLayout(0, 3, 5, 5);

		currentAlignment = bAligns;

		alignBoxes.clear();
		mainPanel.removeAll();
		int i = 0;
		for (Boolean iE : bAligns) {
			JPanel pPanel = new JPanel(lFlow);
			pPanel.setToolTipText(aNames[i]);
			pPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
					new javax.swing.border.LineBorder(new java.awt.Color(0, 0,
							0), 1, true), "",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.ABOVE_BOTTOM, fFont));
			JCheckBox oJ = new JCheckBox(aNames[i]);
			oJ.setFont(fFont);
			//			if (bActive != null)
			//				oJ.setEnabled(bActive[i]);
			oJ.setSelected(iE);
			alignBoxes.add(oJ);
			pPanel.add(oJ);
			mainPanel.add(pPanel);
			i++;
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JPanel mainPanel;
	// End of variables declaration//GEN-END:variables
}