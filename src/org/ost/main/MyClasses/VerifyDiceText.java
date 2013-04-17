package org.ost.main.MyClasses;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import org.ost.main.MyUtils.MyParse;

public class VerifyDiceText extends InputVerifier implements ActionListener { 

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComponent source = (JComponent) arg0.getSource();
			shouldYieldFocus(source); //ignore return value
		}

		@Override
		public boolean shouldYieldFocus(JComponent input) {
			boolean inputOK = verify(input);
			if (inputOK) {
				return true;
			} else {
				Toolkit.getDefaultToolkit().beep();
				return false;
			}
		}

		@Override
		public boolean verify(JComponent testThis) {
			boolean verified = false;
			JTextComponent textComponent = (JTextComponent) testThis;
			int n;
			
			try {
				n = Integer.parseInt(
						MyParse.parseDice(textComponent.getText()));
				verified = true;
			} catch (Exception e) {
				verified = false;
			}

			return verified;
		}

}
