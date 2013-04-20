/*
 * Option_AskFor_AbilityScores.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import static org.ost.main.MyClasses.MyStatics.*;

/**
 *
 * @author  __USER__
 */
public class Option_AskFor_Description extends javax.swing.JDialog {
	MainClass ost;

	/** Creates new form Option_AskFor_AbilityScores */
	public Option_AskFor_Description(java.awt.Frame parent, boolean modal,
			MainClass ost, String sTitle, String newDescription) {
		super(parent, modal);
		this.ost = ost;
		initComponents();

		setTitle(sTitle);
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), sTitle,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));

		//setSize(400, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Dimension windowSize = mainPanel.getSize();
		//int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//setLocation(windowX, windowY);
		setSize(screenSize.width/2, screenSize.height /2);
		setLocationRelativeTo(parent);

		updatePanel(newDescription);

		//pack();
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
		jScrollPane1 = new javax.swing.JScrollPane();
		mainTextArea = new javax.swing.JTextArea();
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

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "TitleGoesHere",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.BorderLayout());

		mainTextArea.setColumns(20);
		mainTextArea.setLineWrap(true);
		mainTextArea.setRows(5);
		mainTextArea.setWrapStyleWord(true);
		jScrollPane1.setViewportView(mainTextArea);

		mainPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
		updateValuesFromTextArea();
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
	private String updateValuesFromTextArea() {
		currentDescription = mainTextArea.getText();
		return (currentDescription);
	}

	private void updatePanel(String description) {
		currentDescription = description;
		mainTextArea.setText(description);
	}

	public String getDescription() {
		return (mainTextArea.getText());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton doneButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel mainPanel;
	public javax.swing.JTextArea mainTextArea;
	// End of variables declaration//GEN-END:variables
	public String currentDescription;

}