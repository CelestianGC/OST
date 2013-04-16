/**
 * 
 */
package org.ost.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;

import javax.swing.UIManager;

import org.ost.main.MyClasses.*;
import org.ost.main.MyUtils.*;
import static org.ost.main.MyUtils.Utils.*;
import static org.ost.main.MyClasses.MyStatics.*;


/**
 * @author uce_mike@yahoo.com
 * @project OST, old school tool for Old School RPGs, ala OSRIC style.
 * @2012.03.20
 */

public class MainClass implements Serializable {
	private static final long serialVersionUID = 1L;
	public String version = "13.04.15(alpha)";
	public String dateName = "by Mike Wilson";
	public String aboutURL = "https://sourceforge.net/projects/oldschooltool/";
	public String aboutEmail = "uce_mike@yahoo.com";

	public String log;
	
	public boolean initAscending = true;
	public boolean initGroup = false;
	public int initDice = 10;
	
	public int creatureHPType = GENERATION_HP_NORMAL;
	
	public Properties settings = new Properties();
	static String settings_file = ".ost";
	
	static String dir_dungeon = "dungeon.dir";
	
	public ArrayList<CreatureClass> fightingCreatureList; // list of creatures on the encounter panel
	public ArrayList<String> fightingKilledList; // list of names we killed, so we don't use same name on panel
	public ArrayList<PlayerClass> fightingPlayerList; // list of players on the encounter panel

	public ArrayList<Table_Generator> generatorList; // list of generator panels
	public ArrayList<TreasureTypePanel> treasureTypeList; // list of treasure type panels
	public ArrayList<TableRewardClass> rewardList; // the last entire list of items created.
	
	public ArrayList<CreatureClass> creatureListOLD;
	public String sCreatureListFileOLD;

	public ArrayList<PlayerClass> playerListOLDY;
	public String sPlayerListFileOLD;

	public ArrayList<StatesClass> statesListOLD; // list of states
	public String sStatesListFileOLD;
	
	public ArrayList<TableClass> tableListOLD; // list of Tables
	public String sTableFileOLD;

	public ArrayList<ChartClass> chartListOLD; // list of Charts
	public String sChartFileOLD;

	public AbilityStatList abilityStatList;
	public String sAbilityScores;
	
	public RaceList raceList;
	public String sRaces;

	public NonWeaponProfList nonWeaponProfList;
	public String sNonWeaponProfs;

	public WeaponProfList WeaponProfList;
	public String sWeaponProfs;

	public EquipmentList equipmentList;
	public String sEquipment;
	
	public PlayerList playerList;
	public String sPlayerList;

	public StatesList statesList;
	public String sStatesList;

	public CreatureList creatureList;
	public String sCreatureList;

	public ChartList chartList;
	public String sChartList;

	public TableList tableList;
	public String sTableList;

	public ExtraAbilitiesList extraAbilitiesList;
	public String sExtraAbilitiesList;

	public ArrayList<AlignmentClass> alignments;

	public CharacterClassList characterClassList;
	public String sCharacterClassList;
	// ---
	public MainWindow mainFrame;
	public Dice_Tab diceTab;
	public DM_Config_Main dmConfigTab;
	public Encounter_Frame encounterFrame;
	public DM_Config_Tab_TreasureChest tabTreasure;
	public DM_Screen dmScreen;
	
	public String curDir;	// where ost is run from
	public String workingDir; // where files are saved

	/**
	 * constructor for MainClass
	 */
	public MainClass() {
		curDir = System.getProperty("user.dir");
		String myPath = curDir+File.separatorChar;
		
		sCreatureListFileOLD 	= myPath+"creatures.xml";
		sPlayerListFileOLD 	= myPath+"players.xml";
		sStatesListFileOLD 	= myPath+"states.xml";
		sTableFileOLD		= myPath+"tables.xml";
		sChartFileOLD		= myPath+"charts.xml";
		sAbilityScores 		= myPath+"AbilityScores.xml";
		sRaces 				= myPath+"Races.xml";
		sNonWeaponProfs 	= myPath+"NonWeaponProfs.xml";
		sWeaponProfs 		= myPath+"WeaponProfs.xml";
		sEquipment 			= myPath+"Gear.xml";
		sPlayerList			= myPath+"PartyMembers.xml";
		sStatesList			= myPath+"StatesList.xml";
		sCreatureList	 	= myPath+"CreatureList.xml";
		sChartList			= myPath+"ChartList.xml";
		sTableList			= myPath+"TableList.xml";
		sExtraAbilitiesList	= myPath+"ExtraAbilitiesList.xml";
		sCharacterClassList	= myPath+"CharacterClassList.xml";
		
		characterClassList = new CharacterClassList(sCharacterClassList);

		extraAbilitiesList = new ExtraAbilitiesList(sExtraAbilitiesList);

		tableList = new TableList(sTableList);
		
		chartList = new ChartList(sChartList);

		creatureList = new CreatureList(sCreatureList);
		
		abilityStatList = new AbilityStatList(sAbilityScores);
		
		raceList = new RaceList(sRaces);
		
		nonWeaponProfList = new NonWeaponProfList(sNonWeaponProfs);

		WeaponProfList = new WeaponProfList(sWeaponProfs);

		equipmentList = new EquipmentList(sEquipment);
		
		playerList = new PlayerList(sPlayerList);
		
		statesList = new StatesList(sStatesList);
		
		alignments = new ArrayList<AlignmentClass>();
		
		generatorList = new ArrayList<Table_Generator>();
		rewardList = new ArrayList<TableRewardClass>();

		treasureTypeList = new ArrayList<TreasureTypePanel>();
		
		statesListOLD = new ArrayList<StatesClass>();
		creatureListOLD = new ArrayList<CreatureClass>();
		playerListOLDY = new ArrayList<PlayerClass>();
		fightingCreatureList = new ArrayList<CreatureClass>();
		fightingPlayerList = new ArrayList<PlayerClass>();
		fightingKilledList = new ArrayList<String>();
		tableListOLD = new ArrayList<TableClass>();
		chartListOLD = new ArrayList<ChartClass>();

	} // end MainClass() constructor
	
	/**
	 * Main()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MainClass ost = new MainClass();

		// set the handles on jtree to these 2 images depending on state
		UIManager.put("Tree.expandedIcon",
				new javax.swing.ImageIcon(ost.getClass().getResource("/images/treeMinus.gif")));
		UIManager.put("Tree.collapsedIcon",
				new javax.swing.ImageIcon(ost.getClass().getResource("/images/treePlus.gif")));
		
		ost.mainFrame = new MainWindow(ost);
		
		ost.showProgress(null, "Loading files.");

		ost.showProgress(ost.mainFrame, "Loading states...");
		ost.statesList.xm.deserializeFromXMLFile();
		//TODO remove this someday after done with import
		if (fileExists(ost.sStatesListFileOLD)) {
			SimpleDialog.showDone("Importing previous states data to new format.");
			ost.statesListOLD = StatesClass.loadFromXML(ost.sStatesListFileOLD);
			if (ost.statesListOLD.size()>0) {
				ost.statesList.clear();
				for (StatesClass oS: ost.statesListOLD)
					ost.statesList.add(oS);
			}
			renameFile(ost.sStatesListFileOLD, ost.sStatesListFileOLD+".OLD");
		}
		// ---
		if (ost.statesList.getContent().isEmpty()) 
			ost.statesList.generate();
		ost.mainFrame.updateStatesList();

		ost.showProgress(ost.mainFrame, "Loading tables...");
		ost.tableList.xm.deserializeFromXMLFile();
		//TODO remove this someday after done with import
		if (fileExists(ost.sTableFileOLD)) {
			SimpleDialog.showDone("Importing previous tables data to new format.");
			ost.tableListOLD = TableClass.loadFromXML(ost.sTableFileOLD);
			if (ost.tableListOLD.size()>0) {
				ost.tableList.clear();
				for (TableClass oT: ost.tableListOLD)
					ost.tableList.add(oT);
			}
			renameFile(ost.sTableFileOLD, ost.sTableFileOLD+".OLD");
		}
		// ---
		if (ost.tableList.getContent().isEmpty())
			ost.tableList.generate();
		
		

		ost.showProgress(ost.mainFrame, "Loading Creatures...");
		ost.creatureList.xm.deserializeFromXMLFile();
		//TODO remove this someday after done with import
		if (fileExists(ost.sCreatureListFileOLD)) {
			SimpleDialog.showDone("Importing previous creatures data to new format.");
			ost.creatureListOLD = CreatureClass.loadFromXML(ost.sCreatureListFileOLD);
			if (ost.creatureListOLD.size()>0) {
				ost.creatureList.clear();
				for (CreatureClass oC: ost.creatureListOLD)
					ost.creatureList.add(oC);
			}
			renameFile(ost.sCreatureListFileOLD, ost.sCreatureListFileOLD+".OLD");
		}
		// ---
		if (ost.creatureList.getContent().isEmpty())
			ost.creatureList.generate();
		
		ost.showProgress(ost.mainFrame, "Loading EquipmentList...");
		ost.equipmentList.xm.deserializeFromXMLFile();
		if (ost.equipmentList.getContent().isEmpty())
			ost.equipmentList.generateEquipment();
		
		ost.showProgress(ost.mainFrame, "Loading ability scores...");
		ost.abilityStatList.xm.deserializeFromXMLFile();
		if (ost.abilityStatList.getContent().isEmpty()) 
			ost.abilityStatList.generateAllScores();

		ost.showProgress(ost.mainFrame, "Loading non-weapon proficiencies...");
		ost.nonWeaponProfList.xm.deserializeFromXMLFile();
		if (ost.nonWeaponProfList.getContent().isEmpty()) 
			ost.nonWeaponProfList.generateNonWeaponProfs();
	
		ost.showProgress(ost.mainFrame, "Loading weapon proficiencies...");
		ost.WeaponProfList.xm.deserializeFromXMLFile();
		if (ost.WeaponProfList.getContent().isEmpty()) 
			ost.WeaponProfList.generate();

		ost.showProgress(ost.mainFrame, "Loading races...");
		ost.raceList.xm.deserializeFromXMLFile();
		if (ost.raceList.getContent().isEmpty()) 
			ost.raceList.generateRaces();

		ost.showProgress(ost.mainFrame, "Loading classes...");
		ost.characterClassList.xm.deserializeFromXMLFile();
		if (ost.characterClassList.getContent().isEmpty()) 
			ost.characterClassList.generate();

		ost.showProgress(ost.mainFrame, "Loading abilities...");
		ost.extraAbilitiesList.xm.deserializeFromXMLFile();
		if (ost.extraAbilitiesList.getContent().isEmpty()) 
			ost.extraAbilitiesList.generate();

		ost.showProgress(ost.mainFrame, "Loading alignments...");
		ost.alignments = AlignmentClass.getAlignmentList();

		
		ost.showProgress(ost.mainFrame, "Loading players...");
		ost.playerList.xm.deserializeFromXMLFile();
		//TODO remove this someday after done with import
		if (fileExists(ost.sPlayerListFileOLD)) {
			SimpleDialog.showDone("Importing previous players data to new format.");
			ost.playerListOLDY = PlayerClass.loadFromXML(ost.sPlayerListFileOLD);
			if (ost.playerListOLDY.size()>0) {
				ost.playerList.clear();
				for (PlayerClass oP: ost.playerListOLDY)
					ost.playerList.add(oP);
			}
			renameFile(ost.sPlayerListFileOLD, ost.sPlayerListFileOLD+".OLD");
		}
		// ---
		if (ost.playerList.getContent().isEmpty())  
			ost.playerList.generate();

		
		ost.showProgress(ost.mainFrame, "Loading charts...");
		ost.chartList.xm.deserializeFromXMLFile();
		//TODO remove this someday after done with import
		if (fileExists(ost.sChartFileOLD)) {
			SimpleDialog.showDone("Importing previous charts data to new format.");
			ost.chartListOLD = ChartClass.loadFromXML(ost.sChartFileOLD);
			if (ost.chartListOLD.size()>0) {
				ost.chartList.clear();
				for (ChartClass otC: ost.chartListOLD)
					ost.chartList.add(otC);
			}
			renameFile(ost.sChartFileOLD, ost.sChartFileOLD+".OLD");
		}
		// ---
		if (ost.chartList.getContent().isEmpty())
			ost.chartList.generate();
	
		
		ost.showProgress(ost.mainFrame, "Loading tabs and panels...");
		ost.diceTab = new Dice_Tab(ost);
		ost.dmConfigTab = new DM_Config_Main(ost);
		ost.encounterFrame = new Encounter_Frame(ost);
		ost.mainFrame.mainTabbedPane.addTab("Dungeon Mastering", null, ost.dmConfigTab,"DM configuration options");
		ost.encounterFrame.encountersTabbedPane.addTab("Dice Bag", null, ost.diceTab,"Roll dem Bones");
		ost.tabTreasure = new DM_Config_Tab_TreasureChest(ost);
		ost.showProgress(ost.mainFrame, "Loading charts and tables onto DM screen...");
		ost.dmScreen = new DM_Screen(ost);

		// we do this after everything is done because we need to load all the 
		// files/tables/panels first then update the combo
		ost.dmConfigTab.tabConfiguration.tabOptions.tablesConfig.updateAllGeneratorTableListComboBoxes();

		ost.mainFrame.pack();
		//ost.mainFrame.setSize(960, 740);
		ost.mainFrame.setVisible(true);
		ost.dmScreen.setVisible(true);
		ost.mainFrame.mainTabbedPane.setVisible(true);
		ost.mainFrame.setVisible(true);

		ost.loadSettings();
		
		ost.showProgressDone();
	}
	
	/**
	 * 
	 */
	public void loadSettings() {
		try {
		    settings.load(new FileInputStream(settings_file));

		    if (settings.getProperty("initDice")!= null &&
		    		MyParse.isInteger(settings.getProperty("initDice")) &&
		    		Integer.parseInt(settings.getProperty("initDice"))>0) {
		    	initDice = Integer.parseInt(settings.getProperty("initDice"));
		    	mainFrame.initDiceFormattedTextField.setValue(initDice);
		    }
		    
		    if (settings.getProperty("creatureHPType")!= null) {
		    	try {
			    	creatureHPType = Integer.parseInt(settings.getProperty("creatureHPType"));
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	switch (creatureHPType) {
				case GENERATION_HP_80:
		    		dmConfigTab.tabCreatureConfig.creatureHPGen80PercentRadioButton.setSelected(true);
					break;
				case GENERATION_HP_AVG:
		    		dmConfigTab.tabCreatureConfig.creatureHPGenAverageRadioButton.setSelected(true);
					break;
				case GENERATION_HP_MAX:
		    		dmConfigTab.tabCreatureConfig.creatureHPGenMAXRadioButton.setSelected(true);
					break;
				default:
		    		dmConfigTab.tabCreatureConfig.creatureHPGenNormalRadioButton.setSelected(true);
					break;
				}
		    }

		    
		    if (settings.getProperty("initAscend")!= null) { 
		    	if (settings.getProperty("initAscend").equalsIgnoreCase("ENABLED")) {
		    		initAscending = true;
		    		mainFrame.initAscendingRadioButton.setSelected(true);
		    	}
		    	else { 
		    		mainFrame.initDescendingRadioButton.setSelected(true);
		    		initAscending = false;
		    	}
		    }
		    if (settings.getProperty("initGroup")!= null) { 
		    	if (settings.getProperty("initGroup").equalsIgnoreCase("ENABLED")) {
		    		initGroup = true;
		    		mainFrame.initGroupRadioButton.setSelected(true);
		    	}
		    	else { 
		    		mainFrame.initGroupRadioButton.setSelected(false);
		    		initGroup = false;
		    	}
		    }
		    
		    if (settings.getProperty("d20Mode")!= null && 
		    		settings.getProperty("d20Mode").equalsIgnoreCase("ENABLED"))
		    	mainFrame.d20ModeRadioButton.setSelected(true);
		    
		    if (settings.getProperty("thacoMode")!= null && 
		    		settings.getProperty("thacoMode").equalsIgnoreCase("ENABLED"))
		    	mainFrame.thacoModeRadioButton.setSelected(true);
		    
		    if (settings.getProperty("dir_dungeon")!= null) {
		    	System.setProperty("dungeon.dir", settings.getProperty("dir_dungeon"));
		    }
		    
		    
		} catch (IOException e) {
			//SimpleDialog.showError(e.getLocalizedMessage());
		}		
	}
	
	/**
	 * save settings to file
	 * 
	 */
	public void saveSettings() {
		// save creature hp generation mode
		settings.setProperty("creatureHPType",
					String.format("%d", creatureHPType));
		
		// save initiative mode
		if (initAscending)
		settings.setProperty("initAscend","ENABLED");
		else
			settings.remove("initAscend");
		
		// save initiative mode GROUP
		if (initGroup)
		settings.setProperty("initGroup","ENABLED");
		else
			settings.remove("initGroup");
		
		// save initDice
		settings.setProperty("initDice", String.format("%d", initDice));

		// save d20 Mode setting
		settings.setProperty("d20Mode",
				mainFrame.d20ModeRadioButton.isSelected()?"ENABLED":"DISABLED");
		// save thacoMode setting
		settings.setProperty("thacoMode",
				mainFrame.thacoModeRadioButton.isSelected()?"ENABLED":"DISABLED");

		// save previous dungeon load/save directory
		if (System.getProperty("dungeon.dir")!= null)
			settings.setProperty("dir_dungeon",System.getProperty("dungeon.dir"));
		try {
			settings.store(new FileOutputStream(settings_file), null);
		} catch (IOException e) {
			SimpleDialog.showError(e.getLocalizedMessage());
		}		
	}
	/**
	 * 
	 * @param sDebugLog
	 */
	public void dprint(String sDebugLog) {
		if (dmConfigTab != null && dmConfigTab.tabLogConfig != null)
		dmConfigTab.tabLogConfig.debugIt(sDebugLog);
	} // end dprint
	/**
	 * 
	 * @param sDebugLog
	 */
	public static void ddprint(String sDebugLog) {
		DM_Config_Tab_Log.ostLogTextArea.append(sDebugLog);
	} // end dprint
	
	/**
	 * Component is where we place the window, 
	 * process is what we're doing
	 * 
	 * @param oC
	 * @param sProcess
	 */
	void showProgress(Component oC,String sProcess) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.mainFrame.mainProgressFrame.getSize();

		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height+220 - windowSize.height) / 2);

		this.mainFrame.mainProgressFrame.setLocation(windowX, windowY);
//		if (oC != null) {
//			Point oP = oC.getLocation();
//			this.mainFrame.mainProgressFrame.setLocation(oP.getLocation().x/2, oP.getLocation().y/2);
//		} else
//			this.mainFrame.mainProgressFrame.setLocationRelativeTo(oC);

		this.mainFrame.mainProgressFrame.pack();
		this.mainFrame.mainProgressFrame.setVisible(true);
		this.mainFrame.mainProgressBar.setStringPainted(true);
		this.mainFrame.mainProgressBar.setIndeterminate(true);
		this.mainFrame.mainProgressBar.setValue(0);
		this.mainFrame.mainProgressBar.setString(sProcess);
	}

	/**
	 * close progress bar
	 */
	void showProgressDone() {
		this.mainFrame.mainProgressBar.setIndeterminate(false);
		this.mainFrame.mainProgressBar.setValue(100);
		this.mainFrame.mainProgressBar.setString(null);
		this.mainFrame.mainProgressFrame.setVisible(false);
	}
	
} // end main
