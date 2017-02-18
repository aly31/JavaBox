# JavaBox
Created by Eric Dong, Albert Yang, Jessica Reyes at SteelHacks 2017

Current Status: In Progress

JavaBox.jar is a java executable file made for Steel Hacks (Feb 2017), this version currently has some bugs

Bugs: 
  - buttons can be pressed multiple times while 1 song is being played, this causes to have songs to overlap each other.
  - pause, exit button not implemented
  
*** Please Note that during the Hackathon the goal was to show how Java can be used to transcribe/compose songs, this is why the gui
may appear to be lacking. 

Currently, new changes are being made to improve this.

*** newer changes will be made in the source codes
- compile: javac SoundPanel.java
- Dependencies: GoDistance.java, SampleSoundPlus.java, SampleSoundEric.java
- run: java SoundPanel

Bugs:
  - songs will overlap each other, even though buttons are disabled
  - Pressing the same song more than once will loop the song by the number times you have clicked it
