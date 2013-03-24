package org.ost.main;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import org.ost.main.MyClasses.CreatureAttackClass;
import org.ost.main.MyClasses.CreatureClass;
import org.ost.main.MyClasses.PlayerClass;
import org.ost.main.MyUtils.MyParse;
import org.ost.main.MyUtils.MyRandomClass;
import org.ost.main.MyUtils.SimpleDialog;

/**
 * 
 * @author Celestian
 *
 */
public class EncounterCreatureAttack extends javax.swing.JPanel {

	/** Creates new form EncounterCreatureAttack */
	public EncounterCreatureAttack(MainClass ost, CreatureClass oI,
			CreatureAttackClass aA) {
		this.ost = ost;
		this.oC = oI;
		//		this.oA = new CreatureAttackClass(damageDice,
		//				MyParse.isInteger(atkName) ? Integer.parseInt(atkName) : 0);
		this.oA = aA;

		initComponents();

		updateAttackDisplays("Rolling.", "READY!");
		updateDamageDisplays("Ready!", oA.getDamageDice());
		attackTitleBorder = (TitledBorder) this.getBorder();
		attackTitleBorder.setTitle(String.format("#%s", oA.getAttackName()));
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		atkEditPopupMenu = new javax.swing.JPopupMenu();
		atkNameMenuItem = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		atkRedoMenuItem = new javax.swing.JMenuItem();
		enterRollMenuItem = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JSeparator();
		atkEditMenuItem = new javax.swing.JMenuItem();
		atkClearMenuItem = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JSeparator();
		atkCancelMenuItem = new javax.swing.JMenuItem();
		dmgEditPopupMenu = new javax.swing.JPopupMenu();
		dmgNameMenuItem = new javax.swing.JMenuItem();
		jSeparator4 = new javax.swing.JSeparator();
		dmgRedoMenuItem = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JSeparator();
		dmgEditMenuItem = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JSeparator();
		dmgCancelMenuItem = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		attackReadyLabel = new javax.swing.JLabel();
		attackIcon = new javax.swing.JLabel();
		attackRollLabel = new javax.swing.JLabel();
		removeAttackIcon = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		damageDoneLabel = new javax.swing.JLabel();
		damageIcon = new javax.swing.JLabel();
		damageTextLabel = new javax.swing.JLabel();

		atkNameMenuItem.setText("Item");
		atkNameMenuItem.setEnabled(false);
		atkEditPopupMenu.add(atkNameMenuItem);
		atkEditPopupMenu.add(jSeparator1);

		atkRedoMenuItem.setText("Item");
		atkRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				atkRedoMenuItemActionPerformed(evt);
			}
		});
		atkEditPopupMenu.add(atkRedoMenuItem);

		enterRollMenuItem.setText("Enter Attack Roll");
		enterRollMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						enterRollMenuItemActionPerformed(evt);
					}
				});
		atkEditPopupMenu.add(enterRollMenuItem);
		atkEditPopupMenu.add(jSeparator3);

		atkEditMenuItem.setText("Edit attack modifier");
		atkEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				atkEditMenuItemActionPerformed(evt);
			}
		});
		atkEditPopupMenu.add(atkEditMenuItem);

		atkClearMenuItem.setText("Clear attack modifier");
		atkClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				atkClearMenuItemActionPerformed(evt);
			}
		});
		atkEditPopupMenu.add(atkClearMenuItem);
		atkEditPopupMenu.add(jSeparator2);

		atkCancelMenuItem.setText("Cancel");
		atkEditPopupMenu.add(atkCancelMenuItem);

		dmgNameMenuItem.setText("Item");
		dmgNameMenuItem.setEnabled(false);
		dmgEditPopupMenu.add(dmgNameMenuItem);
		dmgEditPopupMenu.add(jSeparator4);

		dmgRedoMenuItem.setText("Re-roll your damage roll (1d6+10*2)");
		dmgRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dmgRedoMenuItemActionPerformed(evt);
			}
		});
		dmgEditPopupMenu.add(dmgRedoMenuItem);
		dmgEditPopupMenu.add(jSeparator5);

		dmgEditMenuItem.setText("Edit damage roll");
		dmgEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dmgEditMenuItemActionPerformed(evt);
			}
		});
		dmgEditPopupMenu.add(dmgEditMenuItem);
		dmgEditPopupMenu.add(jSeparator6);

		dmgCancelMenuItem.setText("Cancel");
		dmgEditPopupMenu.add(dmgCancelMenuItem);

		setBackground(new java.awt.Color(153, 153, 153));
		setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0),
						1, true), "#"));
		setRequestFocusEnabled(false);
		setLayout(new java.awt.GridBagLayout());

		jPanel1.setBackground(new java.awt.Color(153, 153, 153));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory
						.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Attack",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		attackReadyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		attackReadyLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		attackReadyLabel.setText("Ready!");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(attackReadyLabel, gridBagConstraints);

		attackIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		attackIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/32-sword-icon.png"))); // NOI18N
		attackIcon
				.setToolTipText("Roll attack. Left click for one attack, right click to re-roll the attack.");
		attackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				attackIconMousePressed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(attackIcon, gridBagConstraints);

		attackRollLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		attackRollLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		attackRollLabel.setText("Rolled 0");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(attackRollLabel, gridBagConstraints);

		add(jPanel1, new java.awt.GridBagConstraints());

		removeAttackIcon.setBackground(new java.awt.Color(153, 153, 153));
		removeAttackIcon.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/cancel-icon.png"))); // NOI18N
		removeAttackIcon.setToolTipText("Delete this attack.");
		removeAttackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				removeAttackIconMouseClicked(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		add(removeAttackIcon, gridBagConstraints);

		jPanel3.setBackground(new java.awt.Color(153, 153, 153));
		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory
						.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Damage",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 8)));
		jPanel3.setLayout(new java.awt.GridBagLayout());

		damageDoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		damageDoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		damageDoneLabel.setText("Ready!");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel3.add(damageDoneLabel, gridBagConstraints);

		damageIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		damageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/32-Button-Blank-Red-icon.png"))); // NOI18N
		damageIcon
				.setToolTipText("Roll damage. Left click to roll damage, right click to re-roll damage.");
		damageIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				damageIconMousePressed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel3.add(damageIcon, gridBagConstraints);

		damageTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		damageTextLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		damageTextLabel.setText("1d6");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel3.add(damageTextLabel, gridBagConstraints);

		add(jPanel3, new java.awt.GridBagConstraints());
	}// </editor-fold>
	//GEN-END:initComponents

	private void removeAttackIconMouseClicked(java.awt.event.MouseEvent evt) {
		if (SimpleDialog.AskYN(removeAttackIcon,
				"Do you really want to delete this attack?")) {
			oC.getAttackList().remove(oA);
			oC.Encountered.attacksPanel.remove(this);
			oC.Encountered.attacksPanel.revalidate();
		}
	}

	void dmgEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String newDmgMod = "";
		while (!MyParse.isInteger(MyParse.parseDice(newDmgMod))) {
			newDmgMod = SimpleDialog.showQuestion(atkEditPopupMenu,
					"Enter new damage roll.", "Damage Roll", "1d6");
		}
		oA.setDamageDice(newDmgMod);
		//oA.setDamageMod((Integer.parseInt(newDmgMod)));
		damageIcon.setToolTipText(String.format("Damage roll of %s",
				oA.getDamageDice()));

	}

	void dmgRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		doDamage(null);
	}

	private void enterRollMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String diceRoll = "";
		while (!MyParse.isInteger(diceRoll)) {
			diceRoll = SimpleDialog.showQuestion(atkEditPopupMenu,
					"Enter attack roll", "Attack Roll", "1");
		}
		doAttack(Integer.parseInt(diceRoll), null);
	}

	private void atkRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		doAttack(-1, null);
	}

	private void atkClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		SimpleDialog.showDone("Cleared attack roll modifier.");
		oA.setAttackMod(0);
		attackIcon.setToolTipText("Roll attack of 1d20.");
	}

	private void atkEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String newAtkMod = "";
		while (!MyParse.isInteger(newAtkMod)) {
			newAtkMod = SimpleDialog.showQuestion(atkEditPopupMenu,
					"Enter attack roll modification.", "Attack Roll Mod", "1");
			newAtkMod = newAtkMod.replaceAll(Pattern.quote("+"), "");
		}
		oA.setAttackMod(Integer.parseInt(newAtkMod));
		attackIcon.setToolTipText(String.format("Roll attack of 1d20%s%d",
				oA.getAttackMod() > 0 ? "+" : "", oA.getAttackMod()));

	}

	private void damageIconMousePressed(java.awt.event.MouseEvent evt) {
		// allow only 1 left click to work, if they want to do it 
		// again they need to right click or "next round"
		if (!oA.isDamageDone() && (evt.getButton() == MouseEvent.BUTTON1)) {
			if (oC.getFightingList().isEmpty()) {
				doDamage(null);
			} else {
				JPopupMenu damagePopUp = new JPopupMenu("Damage!");
				JMenuItem stubItem = new JMenuItem("Damage!");
				stubItem.setEnabled(false);
				damagePopUp.add(stubItem);
				JMenuItem defaultDamage = new JMenuItem("Standard");
				defaultDamage
						.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(
									java.awt.event.ActionEvent evt) {
								doDamage(null);
							}
						});
				defaultDamage
						.setToolTipText("Roll damage and subtrack from player.");
				damagePopUp.add(defaultDamage);
				damagePopUp.add(new JSeparator());

				for (PlayerClass oP : oC.getFightingList()) {
					DamageMenuItem anotherMenuItem = new DamageMenuItem(
							"Direct:" + oP.getName(), oP);
					damagePopUp.add(anotherMenuItem);
				} // end for
				damagePopUp.add(new JSeparator());
				damagePopUp.add(new JMenuItem("Cancel"));
				damagePopUp.show(this, evt.getX(), evt.getY());

			}
		} else if (evt.getButton() == MouseEvent.BUTTON3) {
			dmgEditPopupMenu.show(this, evt.getX(), evt.getY());
			dmgNameMenuItem.setText(String.format("Damage %s",
					oA.getDamageDice()));
			dmgRedoMenuItem.setText(String.format("Re-roll damage! (%s)",
					oA.getDamageDice()));
			dmgEditMenuItem.setText("Edit damage roll");
		}

	}

	class DamageMenuItem extends JMenuItem {
		private PlayerClass oP;

		public DamageMenuItem(String itemName, PlayerClass incOP) {
			oP = incOP;
			setName(itemName);
			setText(itemName);
			addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					doDamage(oP);
				}
			});
			setToolTipText("Damage " + oP.getName() + " and adjust health.");
		}
	}

	/**
	 * do damage roll
	 */
	private void doDamage(PlayerClass myTarget) {
		int damage = Integer.parseInt(MyParse.parseDice(oA.getDamageDice()));
		String sDamageResult = String.format("%d", damage);
		if (myTarget != null) {
			int currentHealth = myTarget.getEncountered().hitpointSlider
					.getValue();
			int newHealth = currentHealth - damage;
			damageDoneLabel.setToolTipText(myTarget.getName() + " took "
					+ sDamageResult + " damage.");
			sDamageResult = String.format("%s -%s", myTarget.getName(),sDamageResult);
			myTarget.getEncountered().hitpointSlider.setValue(newHealth);
			myTarget.getEncountered().hitpointSliderMouseReleased(null);
		} else {
			damageDoneLabel.setToolTipText(sDamageResult);
		}
		updateDamageDisplays(sDamageResult, oA.getDamageDice());
		oA.setDamageDone(true);
	}

	private void attackIconMousePressed(java.awt.event.MouseEvent evt) {
		// allow only 1 left click to work, if they want to do it 
		// again they need to right click or "next round"
		if (!oA.isAttackDone() && (evt.getButton() == MouseEvent.BUTTON1)) {
			if (oC.getFightingList().isEmpty()) {
				doAttack(-1, null);
			} else {
				JPopupMenu attackPopUp = new JPopupMenu("Attack!");
				JMenuItem stubAtk = new JMenuItem("Attack!");
				stubAtk.setEnabled(false);
				attackPopUp.add(stubAtk);
				JMenuItem defaultAtk = new JMenuItem("Standard");
				defaultAtk
						.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(
									java.awt.event.ActionEvent evt) {
								doAttack(-1, null);
							}
						});
				defaultAtk
						.setToolTipText("Perform normal attack and display Armor Class hit.");
				attackPopUp.add(defaultAtk);
				attackPopUp.add(new JSeparator());

				for (PlayerClass oP : oC.getFightingList()) {
					AttackMenuItem anotherMenuItem = new AttackMenuItem(
							"Direct:" + oP.getName(), oP);
					attackPopUp.add(anotherMenuItem);
				} // end for
				attackPopUp.add(new JSeparator());
				attackPopUp.add(new JMenuItem("Cancel"));
				attackPopUp.show(this, evt.getX(), evt.getY());
			} // end attacking multiple pcs

		} else if (evt.getButton() == MouseEvent.BUTTON3) {
			String atkModString = oA.getAttackMod() != 0 ? String.format("%d",
					oA.getAttackMod()) : "";
			atkEditPopupMenu.show(this, evt.getX(), evt.getY());
			atkNameMenuItem.setText(String.format("Attack #%d",
					oA.getAttackNumber()));
			atkRedoMenuItem.setText(String.format("Re-roll Attack! (1d20%s%s)",
					oA.getAttackMod() > 0 ? "+" : "", atkModString));
			atkEditMenuItem.setText("Edit attack modifier");
			atkClearMenuItem.setText("Clear attack modifier");
		}
	}

	class AttackMenuItem extends JMenuItem {
		private PlayerClass oP;

		public AttackMenuItem(String itemName, PlayerClass incOP) {
			oP = incOP;
			setName(itemName);
			setText(itemName);
			addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					doAttack(-1, oP);
				}
			});
			setToolTipText("Attack " + oP.getName()
					+ " and display hit status.");
		}
	}

	/**
	 * negative manualRoll if you want it to determine the attack roll
	 * 
	 * @param manualRoll
	 */
	private void doAttack(int manualRoll, PlayerClass oP) {
		int attackRoll;
		boolean used20 = ost.mainFrame.d20ModeRadioButton.isSelected();
		int d20ACHit = 0;
		boolean useTHACO = ost.mainFrame.thacoModeRadioButton.isSelected();
		int thacoACHit = 10;

		if (manualRoll <= 0) {
			MyRandomClass oR = new MyRandomClass(1, 20);
			oR.setShowDebug(true);
			oR.setDiceMod(oA.getAttackMod());
			attackRoll = oR.rollRandomDice();
			ost.dprint(String.format("Attack:%s\n", oA.getAttackName()));
		} else {
			attackRoll = manualRoll;
			ost.dprint(String.format("Attack [Manual]:%d\n", manualRoll));
		}
		int acHit = oC.getACHit(attackRoll, ost.chartList.getContent());

		String rolled = String.format("Rolled a %d", attackRoll);
		String acResult = String.format("AC %d", acHit);
		if (used20) {
			d20ACHit = (attackRoll + oC.getBab(ost.chartList.getContent()));
			acResult = String.format("AC %d", d20ACHit);
		} else if (useTHACO) {
			thacoACHit = oC.Encountered.myThaco - attackRoll;
			acResult = String.format("AC %d", thacoACHit);
		} else {
			// default will do...
		}

		// targeting a Player
		if (oP != null) {
			String targetAC = oP.getArmorRatings().get(0);
			if (!MyParse.isInteger(targetAC)) {
				Matcher acTargetMatch = Pattern.compile(".*?(\\-?\\d+).*?")
						.matcher(targetAC);
				if (acTargetMatch.matches()) {
					if (acTargetMatch.group(1) != null) {
						targetAC = acTargetMatch.group(1);
					}
				} else {
					SimpleDialog.showError(oP.getName() + " has unknown AC:"
							+ targetAC);
					// we use acResult calculated above instead
				}

			}
			if (MyParse.isInteger(targetAC)) {
				int iTargetAC = Integer.parseInt(targetAC);
				if (used20) {
					// fiddle with the AC to make it look like D20 style
					String sTargetAC = MyParse.displayArmorClass(used20,
							String.format("%d", iTargetAC));
					iTargetAC = Integer.parseInt(sTargetAC);
					if (iTargetAC <= d20ACHit)
						acResult = String.format("HIT!(%d)", d20ACHit);
					else
						acResult = String.format("MISSED!(%d)", d20ACHit);

				} else if (useTHACO) {
					if (thacoACHit <= iTargetAC)
						acResult = String.format("HIT!(%d)", thacoACHit);
					else
						acResult = String.format("MISSED!(%d)", thacoACHit);
				} else {
					if (acHit <= iTargetAC)
						acResult = String.format("HIT!(%d)", acHit);
					else
						acResult = String.format("MISSED!(%d)", acHit);
				}

			}

		} // end oP

		updateAttackDisplays(rolled, acResult);
		oA.setAttackDone(true);

		ost.dprint(String.format("%s: Rolled %d, result: %s %s\n",
				oC.getName(), attackRoll, acResult, (oP != null) ? oP.getName()
						: ""));
	}

	/**
	 * 
	 * @param damageDone
	 */
	public void updateDamageDisplays(String damageDone, String damageString) {
		damageTextLabel.setText(damageString);
		damageDoneLabel.setText(damageDone);
	}

	/**
	 * 
	 * @param rollDone
	 * @param acHit
	 */
	public void updateAttackDisplays(String rollDone, String acHit) {
		// if Dungeon loaded and had attackDone it would show as ready
		if (acHit.contains("READY") && oA.isAttackDone())
			acHit = "wiff!";

		attackRollLabel.setText(rollDone);
		attackReadyLabel.setText(acHit);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem atkCancelMenuItem;
	private javax.swing.JMenuItem atkClearMenuItem;
	private javax.swing.JMenuItem atkEditMenuItem;
	private javax.swing.JPopupMenu atkEditPopupMenu;
	private javax.swing.JMenuItem atkNameMenuItem;
	private javax.swing.JMenuItem atkRedoMenuItem;
	private javax.swing.JLabel attackIcon;
	public javax.swing.JLabel attackReadyLabel;
	public javax.swing.JLabel attackRollLabel;
	public javax.swing.JLabel damageDoneLabel;
	private javax.swing.JLabel damageIcon;
	public javax.swing.JLabel damageTextLabel;
	private javax.swing.JMenuItem dmgCancelMenuItem;
	private javax.swing.JMenuItem dmgEditMenuItem;
	private javax.swing.JPopupMenu dmgEditPopupMenu;
	private javax.swing.JMenuItem dmgNameMenuItem;
	private javax.swing.JMenuItem dmgRedoMenuItem;
	private javax.swing.JMenuItem enterRollMenuItem;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JLabel removeAttackIcon;
	// End of variables declaration//GEN-END:variables
	private MainClass ost;
	public TitledBorder attackTitleBorder;
	private CreatureClass oC;
	public CreatureAttackClass oA;

}