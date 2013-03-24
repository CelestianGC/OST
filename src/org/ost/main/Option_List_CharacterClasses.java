/*
 * Option_List_CharacterClasses.java
 *
 * Created on __DATE__, __TIME__
 */

package org.ost.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;

import org.ost.main.MyClasses.ExtraAbilitiesClass;
import org.ost.main.MyClasses.MyCellRendererList;
import org.ost.main.MyClasses.CharacterClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 *
 * @author  __USER__
 */
@SuppressWarnings("serial")
public class Option_List_CharacterClasses extends javax.swing.JDialog {
	private MainClass ost;
	private DefaultListModel<CharacterClass> listModel;

	/** Creates new form Option_List_Races */
	public Option_List_CharacterClasses(java.awt.Frame parent, boolean modal,
			MainClass ost) {
		super(parent, modal);
		this.ost = ost;
		initComponents();

		listModel = new DefaultListModel<>();
		characterClassList.setCellRenderer(new MyCellRendererList());
		characterClassList.setModel(listModel);
		updateList();

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//		Dimension windowSize = parent.getSize();
		//		int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
		//		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		//		setLocation(windowX, windowY);
		//		setSize(windowSize.width - 2, windowSize.height - 2);
		//		setSize(300,500);
		setLocationRelativeTo(parent);

	}

	@SuppressWarnings("unchecked")
	private void updateList() {
		// TODO Auto-generated method stub
		Object oSelected = characterClassList.getSelectedValue();
		listModel.removeAllElements();
		Collections.sort(ost.characterClassList.getContent());
		for (CharacterClass o : ost.characterClassList.getContent()) {
			ost.dprint("Added class>" + o.getName()+"\n");
			listModel.addElement(o);
		}
		if (oSelected != null)
			characterClassList.setSelectedValue(oSelected, true);
		else
			characterClassList.setSelectedValue(listModel.getElementAt(0),
					true);
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
		characterClassList = new javax.swing.JList();
		buttonsPanel = new javax.swing.JPanel();
		createButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		doneButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		mainPanel.setBackground(new java.awt.Color(153, 153, 153));
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "Classes",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12)));
		mainPanel.setLayout(new java.awt.BorderLayout());

		characterClassList.setFont(new java.awt.Font("Segoe UI", 0, 12));
		characterClassList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane6.setViewportView(characterClassList);

		mainPanel.add(jScrollPane6, java.awt.BorderLayout.CENTER);

		buttonsPanel.setBackground(new java.awt.Color(204, 204, 204));
		buttonsPanel.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		createButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		createButton.setText("new");
		createButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(createButton);

		editButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		editButton.setText("edit");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(editButton);

		deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		deleteButton.setText("delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(deleteButton);

		doneButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
		doneButton.setText("done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});
		buttonsPanel.add(doneButton);

		mainPanel.add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
//		Object oSelected = characterClassList.getSelectedValue();
//		if (oSelected != null) {
//			CharacterClass o = (CharacterClass) oSelected;
//			if (SimpleDialog.AskYN(this, "Delete " + o.getName() + "?")) {
//				ost.characterClassList.getContent().remove(o);
//				listModel.removeElement(o);
//			}
//		}
		List oSelect = characterClassList.getSelectedValuesList();
		boolean bDelete = false;
		if (!oSelect.isEmpty()) {
			for (Object oSelected : oSelect)
				if (oSelected != null) {
					CharacterClass o = (CharacterClass) oSelected;
					String sRem = oSelect.size() > 1 ? "all selected" : o
							.getName();
					if (bDelete
							|| SimpleDialog.AskYN(this, "Remove " + sRem + "?")) {
						bDelete = true;
						ost.characterClassList.getContent().remove(o);
						listModel.removeElement(o);
					}
				}
		}	

	}

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Object oSelected = characterClassList.getSelectedValue();
		if (oSelected != null && oSelected instanceof CharacterClass) {
			CharacterClass o = (CharacterClass) oSelected;

			Option_AskFor_CharacterClass dDialog = new Option_AskFor_CharacterClass(
					ost.mainFrame, true, ost, o);

			dDialog.setVisible(true);

			updateList();

			characterClassList.repaint();
		}
	}

	private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		CharacterClass oNew = new CharacterClass("newClass",
				"Enter Description of this new class.","New");
		ost.characterClassList.add(oNew);

		Option_AskFor_CharacterClass dDialog = new Option_AskFor_CharacterClass(ost.mainFrame,
				true, ost, oNew);

		dDialog.setVisible(true);

		// update list with new 
		updateList();
		// set selected on new 
		characterClassList.setSelectedValue(oNew, true);

		characterClassList.repaint();
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
	private javax.swing.JList characterClassList;
	private javax.swing.JButton createButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton editButton;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JPanel mainPanel;
	// End of variables declaration//GEN-END:variables

}