/**
 *  SimpleDialog boxes for common output.
 *  
 */
package org.ost.main.MyUtils;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Celestian
 *
 */
public class SimpleDialog {
	
	/**
	 * constructor
	 */
	public SimpleDialog(){
	}
	
	  // Show Done/Details with dialog
	public static void showDone(String sShow) {
	    JOptionPane.showMessageDialog(new JFrame(), sShow, "Done",JOptionPane.CLOSED_OPTION);
	  }

	  // Show Errors with dialog
	  public static void showError(String sShow) {
	    JOptionPane.showMessageDialog(new JFrame(),sShow, "Error",
	                                  JOptionPane.ERROR_MESSAGE);
	  }

	  /**
	   * 
	   * @param thisFrame
	   * @param question
	   * @param title
	   * @param defaultValue
	   * @return
	   */
	  public static String showQuestion(Component thisFrame, String question, String title, String defaultValue) {
		return showQuestion(thisFrame, question, title, defaultValue,null);  
	  }

	  /**
	   * 
	   * @param thisFrame
	   * @param question
	   * @param title
	   * @param defaultValue
	   * @param oList
	   * @return
	   */
	  public static String showQuestion(Component thisFrame, String question, String title, String defaultValue, Object[] oList) {
		  
		  String s = (String)JOptionPane.showInputDialog(
		                      thisFrame,
		                      question,
		                      title,
		                      JOptionPane.PLAIN_MESSAGE,
		                      null, // icon
		                      oList,
		                      defaultValue);

		  //If a string was returned, say so.
		  if ((s != null) && (s.length() > 0)) {
		      return(s);
		  } else {
			  return("");
		  }
	  } // end showQuestion
	  

	  // ASK A YES NO QUESTION
	  public static boolean AskYN(Component oFrame, String sQuestion) {
	    boolean bReturn = true;
	    int nYN = JOptionPane.showConfirmDialog(oFrame, sQuestion, "",
	                                            JOptionPane.YES_NO_OPTION);
	    if (nYN > 0) {
	      bReturn = false;

	    }
	    oFrame.repaint();
	    return bReturn;
	  }

	  /**
	   * 
	   * @param oComp
	   * @param savingWhatTitle
	   * @param propertyName lastdungeon.dir/etc
	   * @return
	   */
	  public static String askWhereToSave(Component oComp, String savingWhatTitle,
			String propertyName) {
		String fileToSave = null;
		JFileChooser fChooser = new JFileChooser();
		fChooser.setApproveButtonText("Save");
		fChooser.setDialogTitle(savingWhatTitle);
		if (System.getProperty(propertyName) != null) {
			fChooser.setCurrentDirectory(new File(System.getProperty(propertyName)));
		} else {
			fChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		}
		int returnVal = fChooser.showSaveDialog(oComp);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileToSave = fChooser.getSelectedFile().getAbsolutePath();
//			fileToSave = "file://"+fChooser.getSelectedFile().getAbsolutePath();

			System.setProperty(propertyName, fChooser.getCurrentDirectory()
					.getAbsolutePath());

		} else {
			// save cancelled
			fileToSave = null;
		}
		return fileToSave;
	} // end AskWhereToSave	  
	  
	/**
	 * 
	 * @param oComp
	 * @param loadWhatTitle
	 * @param propertyName 
	 * @return
	 */
	  public static String askWhatFileToLoad(Component oComp, String loadWhatTitle,
			String propertyName) {
		String sFilename = null;
		JFileChooser fChooser = new JFileChooser();
		fChooser.setApproveButtonText("Load");
		fChooser.setDialogTitle(loadWhatTitle);
		if (System.getProperty(propertyName) != null)
			fChooser.setCurrentDirectory(new File(System
					.getProperty(propertyName)));
		else
			fChooser.setCurrentDirectory(new File(System
					.getProperty("user.dir")));
		int returnVal = fChooser.showOpenDialog(oComp);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			sFilename = fChooser.getSelectedFile().getAbsolutePath();
//			sFilename = "file://"+fChooser.getSelectedFile().getAbsolutePath();
			//String sFile = fChooser.getSelectedFile().getName();

			if (!fChooser.getSelectedFile().exists()) {
				// does not exist
				sFilename = null;
			} else {
				System.setProperty(propertyName, 
						fChooser.getCurrentDirectory().getAbsolutePath());
			}
		} else {
			// Load cancelled.
			sFilename = null;
		}
		return sFilename;
	}
	
	  
} // end SimpleDialog
