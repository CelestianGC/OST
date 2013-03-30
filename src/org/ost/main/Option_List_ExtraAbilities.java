/*
 * Option_List_Races.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;

import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyClasses.RaceClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
@SuppressWarnings("serial")
public class Option_List_ExtraAbilities extends javax.swing.JDialog {
	MainClass ost;
	DefaultListModel<ExtraAbilitiesClass> extraListModel;

	/** Creates new form Option_List_ExtraAbilities */
	public Option_List_ExtraAbilities(java.awt.Frame parent, boolean modal,
			MainClass ost) {
		super(parent, modal);
		this.ost = ost;
		initComponents();

		extraListModel = new DefaultListModel<>();
		mainList.setCellRenderer(new MyCellRendererList());
		mainList.setModel(extraListModel);
		updateextraList();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = parent.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);
		setSize(300, 500);
		setLocationRelativeTo(parent);

	}

	@SuppressWarnings("unchecked")
	private void updateextraList() {
		// TODO Auto-generated method stub
		Object oSelected = mainList.getSelectedValue();
		extraListModel.removeAllElements();
		Collections.sort(ost.extraAbilitiesList.getContent());
		for (ExtraAbilitiesClass oR : ost.extraAbilitiesList.getContent()) {
			ost.dprint("Added new extra-ability>" + oR.getName() + "\n");
			extraListModel.addElement(oR);
		}
		if (oSelected != null)
			mainList.setSelectedValue(oSelected, true);
		else
			mainList.setSelectedValue(extraListModel.getElementAt(0), true);
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
		jScrollPane6 = new javax.swing.JScrollPane();
		mainList = new javax.swing.JList();
		buttonsPanel = new javax.swing.JPanel();
		mainCreateButton = new javax.swing.JButton();
		mainEditButton = new javax.swing.JButton();
		mainDeleteButton = new javax.swing.JButton();
		mainDoneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Abilities",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.BorderLayout());

		mainList.setFont(new java.awt.Font("Segoe UI", 0, 12));
		mainList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane6.setViewportView(mainList);

		mainPanel.add(jScrollPane6, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonsPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		mainCreateButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		mainCreateButton.setText("new");
		mainCreateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainCreateButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(mainCreateButton);

		mainEditButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		mainEditButton.setText("edit");
		mainEditButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainEditButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(mainEditButton);

		mainDeleteButton.setBackground(new java.awt.Color(204, 0, 0));
		mainDeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		mainDeleteButton.setText("delete");
		mainDeleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainDeleteButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(mainDeleteButton);

		mainDoneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		mainDoneButton.setText("done");
		mainDoneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainDoneButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(mainDoneButton);

		mainPanel.add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-END:initComponents

	private void mainDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//		Object oSelected = mainList.getSelectedValue();
		//		if (oSelected != null) {
		//			ExtraAbilitiesClass o = (ExtraAbilitiesClass) oSelected;
		//			if (SimpleDialog.AskYN(this, "Delete " + o.getName() + "?")) {
		//				ost.extraAbilitiesList.getContent().remove(o);
		//				extraListModel.removeElement(o);
		//			}
		//		}
		List oSelect = mainList.getSelectedValuesList();
		boolean bDelete = false;
		if (!oSelect.isEmpty()) {
			for (Object oSelected : oSelect)
				if (oSelected != null) {
					ExtraAbilitiesClass o = (ExtraAbilitiesClass) oSelected;
					String sRem = oSelect.size() > 1 ? "all selected" : o
							.getName();
					if (bDelete
							|| SimpleDialog.AskYN(this, "Remove " + sRem + "?")) {
						bDelete = true;
						ost.raceList.getContent().remove(o);
						extraListModel.removeElement(o);
					}
				}
		}
	}

	private void mainEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Object oSelected = mainList.getSelectedValue();
		if (oSelected != null && oSelected instanceof ExtraAbilitiesClass) {
			ExtraAbilitiesClass o = (ExtraAbilitiesClass) oSelected;

			Option_AskFor_ExtraAbilities dDialog = new Option_AskFor_ExtraAbilities(
					ost.mainFrame, true, ost, o);

			dDialog.setVisible(true);

			updateextraList();

			mainList.repaint();
		}
	}

	private void mainCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ExtraAbilitiesClass oNew = new ExtraAbilitiesClass("extra-new",
				"Enter Description of this new ability.");
		ost.extraAbilitiesList.add(oNew);

		Option_AskFor_ExtraAbilities dDialog = new Option_AskFor_ExtraAbilities(
				ost.mainFrame, true, ost, oNew);

		dDialog.setVisible(true);

		// update list with new ablity
		updateextraList();
		// set selected on new ability
		mainList.setSelectedValue(oNew, true);

		mainList.repaint();
	}

	private void mainDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		formWindowClosed(null);
		setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JButton mainCreateButton;
	private javax.swing.JButton mainDeleteButton;
	private javax.swing.JButton mainDoneButton;
	private javax.swing.JButton mainEditButton;
	private javax.swing.JList mainList;
	private javax.swing.JPanel mainPanel;
	// End of variables declaration//GEN-END:variables

}