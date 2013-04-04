/*
 * Option_AskFor_AbilityScores.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import static org.ost.main.MyClasses.MyStatics.*;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Filter extends javax.swing.JDialog {
	private MainClass ost;
	public int currentType;

	/** Creates new form Option_AskFor_AbilityScores */
	public Option_AskFor_Filter(java.awt.Frame parent, boolean modal,
			MainClass ost, String sTitle, String[] types) {
		super(parent, modal);
		this.ost = ost;
		initComponents();

		currentType = -1;

		setTitle(sTitle);
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), sTitle,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		setLocationRelativeTo(parent);

		//setSize(400, 300);

		updatePanel(types);
		
		pack();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		mainPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		typeComboBox = new javax.swing.JComboBox();
		buttonsPanel = new javax.swing.JPanel();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Description");
		setAlwaysOnTop(true);
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
		mainPanel.setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
		jLabel1.setText("select type to see");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(jLabel1, gridBagConstraints);

		typeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12));
		typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		mainPanel.add(typeComboBox, gridBagConstraints);

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
		getUpdateValues();
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		setVisible(false);
		formWindowClosed(null);
	}

	/**
	 * put the spinner values into the array
	 * 
	 * @return
	 */
	private int getUpdateValues() {
		currentType = (typeComboBox.getSelectedIndex()-1);
		return (currentType);
	}

	private void updatePanel(String[] types) {
		ArrayList<String> aList = new ArrayList<>();
		aList.add("ALL");
		for (int i=0;i<types.length;i++)
			aList.add(types[i]);
		
		DefaultComboBoxModel model = new DefaultComboBoxModel<>(aList.toArray());
		typeComboBox.setModel(model);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JComboBox typeComboBox;
	// End of variables declaration//GEN-END:variables
}