- Install
 Run the jar installer file.

 To use the application run ost.jar.

- What is OST/Old School Tool?
I wrote this program to help make my DM sessions a little easier
on my brain. I wanted to focus on the adventure itself and not get
distracted with tiny things like flipping through charts to
determine if a PC hit a NPC or lose track of how much health the
bad guy had left.

This is a list of key things I wanted to make sure I had:

* Easy method of creating/tracking npc stats.
* Quick and simple way to load a baddie to combat.
* Track health of npcs and party members easily.
* Easily determine AC the npc hit.
* Easily find out if the NPC saved. Such as from the wizards fireball
  spell or dragon breath.
* Store encounters ahead of time.
* Store and view tables and charts and have a method to easily
  import them from multiple sources.
* Generate treasure quickly and easily and allow a moderate
  amount of flexibility with the charts for generating it.
* Moderate amout of configurability such as ascending AC and
  THACO modes.
* Simple dice tools.


- CHARTS
 Charts are "tables" that you do not need dice rolls for.
Such as saving throws table for Fighter or Cleric. Similarly
charts such as the Thief attack matrix or weapon damage
charts. I've added an import method that will allow you
to copy a chart (make certain to use the copy as table!)
from say the OSRIC PDF and then paste it into a window
then import. It works "Fairly" well but sometimes the
copy will not be accurate but it saves loads of work
even if you have to correct the last line. I'll create
a video that shows me doing it but it should be easy to
figure out.

Charts are loaded into the DM screen grouped by the TYPE
you set for them. For example the Fighter, Thief and Magic-user
saving throw tables are the type SAVES so will all be under
the "SAVES" tab on the DM Screen.

- TABLES
Import/Export, you can now export/import tables to one
another using the text blocks created when you use the
"export" button while viewing a chart.

* Due to the nature of Treasure Types I had to link
specifically to some of them. While you can edit the
tables as you wish it's best to NOT rename the included
magic item tables unless you really know what you are
doing. You can do anything else you like just make sure
to not rename them or the Treasure Type generation will
more than likely generate errors. 

* I've added a "macro" option to deal with some of the
"odd" ways the old school games handle some tables. For
example when the table result says "roll 2 times on
this table and ignore 93 to 100". Here is the macro
format that is used in the "reward" field of the table.

{ref:TableNameHere:maxroll:specificroll:numberofroll:dorefs}

{}		= required, used to parse text.
ref		= required, name of this macro (more might come later)
TableNameHere	= required, the name of the table to grab another reward block from
maxroll		= required, the max dice roll for this reward, "ignore 93-100" you'd
			set it to 92 OR set to 0 if there is max limit (will
			automatically figure it out based on table size)
specificroll	= required, set to 0 if you do not want to specify a roll.
			Specify the resulting line on the table you want.
numberofroll	= required, This needs to be at least 1, it's the number of
			times it will run the macro, sometimes you might want
			to get the result 2 or more times.
dorefs		= NOT-required, if you need to utilize refer to tables then set the value to "true"

Example from the "Sword, Unusual Sword Primary Abilities" table 93-98 result:
{ref:Sword, Unusual Sword Primary Abilities:92:0:2:false}

This will cause the macro to get 2 rewards from the Primary
Abilities table and cap the roll at 92. Note the ":false"
on the end is NOT needed but won't hurt. If I had wanted to
use the refers from that table also I would have set it to
":true". This can cause duplication if you don't know what
you are doing so be aware.

- IMPORT
Three methods of importing exist into the Beastiary. One
allows you to copy/paste creatures from the OSRIC document
another is importing a block of creatures someone else
"exported" from OST. Lastly the other is a
30 field<tab> separated line. 

Here are the fields that are required. SBLaxman has done
a great list of creatures on Dragonsfoot.org that you can grab.
------------------------------
Name	Type	Climate	Terrain	Frequency	Organization	Activity Cycle	Diet	Intelligence	% in Lair	Treasure	Alignment	No. Appearing	AC	Movement	HD	Thac0	No. Attacks	Damage	Special Attack	Special Defence	MR	Size	Morale	Psionic Ability	A/D Modes	Level	XP	Source	Edition
------------------------------


* Encounter Window options
 * Turn Tracking
   Turn tracking is a way to manually track turns. It does nothing but update the counter.
 * Round Tracking
   Round tracking is a way to manually track combat rounds. If you click "next round" it 
   will also automatically initiate a roll initiative for that round.
 * Initiative Tracking
   Initiative defaults to use a 1d10 dice roll for each creature with lowest rolls going
   first. You can configure ascending/descending and dice size in options.
   Clicking Roll initiative also initiated a "next round" which increments the round counter,
   it will sort the npcs in order of diced initiative rolls. Clicking "Next init" will 
   increase the initiative counter and select the first creature with the current initiative.
   

* SPECIFIC CHARTS UTILIZED BY OST
These charts are used by OST and as such changes to them are not recommended unless you know
exactly how OST uses them. Altering the existing values in the cells is ok (except for the
first column), adding new columns or rows (or changing the first column values) is not ok.

Monster Saves
Monster BaB Matrix
Monster Attack Matrix
Monster THACO Matrix


* If you have questions please feel free to email
me directly (uce_mike@yahoo.com) or ask on the
dragonsfoot.org AD&D 1e forums (handle Celestian).

--- NEW ---
* Damage direct to "fighting" target.
* Player/Creature name in tree will show as "down" if health less than 1.
* Group initiative option added to settings. Set this to roll once for all creatures and
  once for all PCs.

*Targeting
NPCs and PCs can "target" a enemy. Drag the creature on top a player and that creature will
have a "Fighting" tree below it. When that creature's attack button is pressed it will then
prompt you if you want to directly attack the PC's AC and if you do will tell you if you hit
them or not. -- Future versions might auto-damage targets.

*Dungeon details
You can now save/load/view gm/player text info (like text boxes in modules) on any dungeon room.

* Players
Begun works on having players information to track during a session. For now the key
goal is to be able to have a useful amount of information about the player and be able
to manage their health like you do for npcs. This information is limited to what I
need as a DM. Eventually I will have a full sheet like a character would but for now
this is just to help make my DMing job easier.

* States.txt is gone. Replaced with states.xml and you can add/delete new ones in
the OST tool itself. When adding a state to a creature or player you have the
options to create new ones or delete the selected one or just add it to track.
