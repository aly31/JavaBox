/* * * * * * * * * * * * * * * * *
	Albert Yang
	Eric Dong
	Jessica Reyes
	Albert Du
* * * * * * * * * * * * * * * * */

import javax.sound.midi.*;
import javax.swing.*;
import java.util.logging.*;
import java.util.*;

public class Playlist{
	private static final int[] notes = new int[]{36,37,38,39,40,41,42,43,44,45,46,47,
48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,
76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,
103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119};

	public Playlist(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to AEJA Playlist!");
	//	System.out.println("Welcome to YDRD Playlist!");
		System.out.println();

		displayMenu();
		int choice;
		do{
			choice = sc.nextInt(); sc.nextLine();
		} while(choice < 0 || choice > 5);	
				
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open(); // opens synthesizer
			
			Instrument[] band = synth.getAvailableInstruments(); // get all instruments
			MidiChannel[] channel = synth.getChannels(); // get all channels
// PIANO 1			
			Instrument piano1 = band[0];
			setChannel(synth, channel, piano1, 11);
// ACOUSTIC BASS			
			Instrument acousticBass = band[32];
			setChannel(synth, channel, acousticBass, 0);
// FINGERED BASS				
			Instrument fingeredBass = band[33];
			setChannel(synth, channel, fingeredBass, 1);
// PICKED BASS				
			Instrument pickedBass = band[34];
			setChannel(synth, channel, pickedBass, 2);
// WHISTLE				
			Instrument whistle = band[78];
			setChannel(synth, channel, whistle, 8);
// ECHOPAN				
			Instrument echoPan = band[114];
			setChannel(synth, channel, echoPan, 0);
// SYNTH DRUM				
			Instrument synthDrum = band[118];
			setChannel(synth, channel, synthDrum, 3);
// REVERSE CYMB			
			Instrument reverseCymb = band[119];
			setChannel(synth, channel, reverseCymb, 4);
// PUNCH				
			Instrument punch = band[156];
			setChannel(synth, channel, punch, 5);
// FUNKGT				
			Instrument funkGt = band[186];
			setChannel(synth, channel, funkGt, 6);
// MANDOLIN			
			Instrument mandolin = band[215];
			setChannel(synth, channel, mandolin, 10);
// FUNKGT2			
			Instrument funkGt2 = band[216];
			setChannel(synth, channel, funkGt2, 7);
		
			if(choice == 1){
				try{
				//	playNote(synth,channel,9,38,1000);
					new Thread(() -> Harmony(synth,channel)).start();
					new Thread(() -> Melody(synth,channel)).start();
					
					Thread.sleep(2500);	
				}catch(Exception e){
				
				}	
			}
		
			else if(choice == 2){
	
		            try{
			        Synthesizer syn = MidiSystem.getSynthesizer();
				syn.open();
				Instrument[] b = syn.getAvailableInstruments();
				Instrument ins = b[0];//type of instrument
				syn.loadInstrument(ins);
				MidiChannel[] ch = syn.getChannels();
				Patch patch = ins.getPatch();
				ch[0].programChange(patch.getBank(), patch.getProgram());
				ch[1].programChange(patch.getBank(), patch.getProgram());
 				ch[2].programChange(patch.getBank(), patch.getProgram());
				ch[3].programChange(patch.getBank(), patch.getProgram());

			//LOG.info(String.format("Configured synth with %s", ins.getName()));
		        	int note = 0;
				/* FADED - ALAN WALKER */
				while(note <= 45){ 
				/* INTRO */
				if (note == 0) {
				    new Thread(() -> playChord(syn,ch,0,60,550,100)).start(); //C5
                  		    new Thread(() -> playChord(syn,ch,0,52,550, 100)).start();//E4 
           			    new Thread(() -> playChord(syn,ch,2,57,550,75)).start();//A4 
				} else if (note == 2 || note == 4) {
				    new Thread(() -> playChord(syn,ch,0,60,550,100)).start();//C5 
 				    new Thread(() -> playChord(syn,ch,1,69,550,100)).start();//A5 
				} else if (note == 6 || note == 17 || note == 19) {
 				    new Thread(() -> playChord(syn,ch,0,60,550,100)).start();//C5
				    new Thread(() -> playChord(syn,ch,1,64,550,100)).start();//E5 
				}
				else if (note == 1 || note == 3 || note == 5 || note == 7) {
	 			    new Thread(() -> playChord(syn,ch,0,52,550, 100)).start();//E4
				} else if (note == 8) {
				    new Thread(() -> playChord(syn,ch,0,81,550,100)).start();//A6
				    new Thread(() -> playChord(syn,ch,1,65,550,100)).start();//F5
           			    new Thread(() -> playChord(syn,ch,2,53,550,100)).start();//F4  
				} else if (note == 9 || note == 11) { 
				    new Thread(() -> playChord(syn,ch,0,65,550,100)).start();//F5 
				} else if (note == 10 || note == 12) {	
				    new Thread(() -> playChord(syn,ch,0,81,550,100)).start();//A6
				    new Thread(() -> playChord(syn,ch,1,65,550,100)).start();//F5	
				} else if (note == 13) {
				    new Thread(() -> playChord(syn,ch,1,65,550,100)).start();//F5 
				} else if (note == 14) {
				    new Thread(() -> playChord(syn,ch,1,79,800,100)).start();//G6
           			    new Thread(() -> playChord(syn,ch,2,67,800,100)).start();//G5
				    try {
 				        Thread.sleep(550);
				    }
				    catch(InterruptedException e){
					//break;
				    }
		  		    finally{
			                ch[1].noteOff(2, 100);
					ch[2].noteOff(2, 100);
		                    }
				} else if (note == 15) {   
				    new Thread(() -> playChord(syn,ch,0,69,550,100)).start();//A5
				    new Thread(() -> playChord(syn,ch,1,64,550,100)).start();//E5
           			    new Thread(() -> playChord(syn,ch,2,48,550,100)).start();//C4
				   
				} else if (note == 16 || note == 18 || note == 20 || note == 22) { 
				    new Thread(() -> playChord(syn,ch,0,67,550,100)).start();//G5 
				} else if (note == 21) {
                                    new Thread(() -> playChord(syn,ch,1,67,550,100)).start();//G5
           			    new Thread(() -> playChord(syn,ch,2,62,550,100)).start();//D2
				} else if (note == 20 || note == 22) { 
				    new Thread(() -> playChord(syn,ch,0,67,550,100)).start();//G5
				} else if (note == 23) {
				    new Thread(() -> playChord(syn,ch,0,71,550,100)).start();//B5
                                    new Thread(() -> playChord(syn,ch,0,67,550,100)).start();//G5
                                    new Thread(() -> playChord(syn,ch,0,55,550,75)).start();//G4
				} else if ( note == 24 || note == 26 || note == 28 || note == 30) {
				    new Thread(() -> playChord(syn,ch,0,50,550,50)).start();//D4
				} else if (note == 25 || note == 27) { 
				    new Thread(() -> playChord(syn,ch,0,71,550,100)).start();//B5
                                    new Thread(() -> playChord(syn,ch,0,67,550,75)).start();//G5
				} else if (note == 29) { 
				    new Thread(() -> playChord(syn,ch,0,69,550,100)).start();//A5
                                    new Thread(() -> playChord(syn,ch,0,50,550,75)).start();//D4
				}
				/* VERSE */
				else if (note == 31) {
				   new Thread(() -> playChord(syn,ch,0,57,250,100)).start();//A4	
				} else if (note == 32) {
			           new Thread(() -> playChord(syn,ch,0,52,250,100)).start();//E4
				} else if (note == 33 || note == 35 || note == 37 || note == 41 || note == 42) {
			           new Thread(() -> playChord(syn,ch,0,60,250,75)).start();//C5	
				} else if (note == 34 || note == 36 || note == 40) {
      				   new Thread(() -> playChord(syn,ch,0,69,250,75)).start();//A5
				} else if (note == 38) {
 				   new Thread(() -> playChord(syn,ch,0,62,250,100)).start();//D5
				} else if (note == 39) { 
 			           new Thread(() -> playChord(syn,ch,0,64,250,100)).start();//E5
				   new Thread(() -> playChord(syn,ch,0,53,250,100)).start();//F4
				} else if (note == 43) {
				   new Thread(() -> playChord(syn,ch,0,67,250,100)).start();//G5
				   //new Thread(() -> playChord(syn,ch,0,50,550,100)).start();//D
				} else if (note == 44 || note == 45) {
				   new Thread(() -> playChord(syn,ch,0,64,1000,100)).start();//E5
				} 
				note++; // increment note to play next one
				try{
			            Thread.sleep(550);
				}
				catch (InterruptedException e) {
				}
				finally {
				    ch[0].noteOff(2, 100);
				}
			}
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
		}

		
			}
		
			else if(choice == 3){
		
			}
		
			else if(choice == 4){
		
			}
		
			else if(choice == 5){
				System.exit(0);
			}
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
		}
	}
	
	// sets channel
	public void setChannel(Synthesizer synth, MidiChannel[] channel, Instrument instr, int chanNum){
		synth.loadInstrument(instr);
		Patch patch = instr.getPatch();
		channel[chanNum].programChange(patch.getBank(), patch.getProgram());
		
	//	LOG.info(String.format("Configured synth with %s", instr.getName()));
	}
		
	// plays individual notes
	public void playNote(Synthesizer synth, MidiChannel[] channel, int chanNum, int note, int rest){
		channel[chanNum].noteOn(notes[note], 100);//type of note, volume
		try{
			Thread.sleep(rest);//rest
		}
		catch(InterruptedException e){
			//break;
		}
		finally{
			channel[chanNum].noteOff(note, 100);
		}
	}

// GOOD ENOUGH - ALBERT YANG	
	public void Melody(Synthesizer synth, MidiChannel[] channel){
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,28,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,42,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
	    try {
			Thread.sleep(2900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //big pause
	    new Thread(() -> playNote(synth,channel,10,14,1000)).start();
		new Thread(() -> playNote(synth,channel,11,14,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,11,1000)).start();
		new Thread(() -> playNote(synth,channel,11,11,1000)).start();
		try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,9,1000)).start();
		new Thread(() -> playNote(synth,channel,11,9,1000)).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,11,1000)).start();
		new Thread(() -> playNote(synth,channel,11,11,1000)).start();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//medium pause
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(225);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(112);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,35,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,23,1000)).start();
		try {
			Thread.sleep(225);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,33,1000)).start();
		new Thread(() -> playNote(synth,channel,11,21,1000)).start();
		try {
			Thread.sleep(112);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(225);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(112);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,35,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,23,1000)).start();
		try {
			Thread.sleep(225);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,33,1000)).start();
		new Thread(() -> playNote(synth,channel,11,21,1000)).start();
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//part2 halfway
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,28,1000)).start();
		try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,42,1000)).start();
	    new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
		new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
		//new Thread(() -> playNote(synth,channel,11,30,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,45,1000)).start();
		new Thread(() -> playNote(synth,channel,11,33,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,47,1000)).start();
		new Thread(() -> playNote(synth,channel,11,35,1000)).start();
		//new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
		new Thread(() -> playNote(synth,channel,11,28,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
		new Thread(() -> playNote(synth,channel,11,28,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,42,1000)).start();
		new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block g
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,43,1000)).start();
		new Thread(() -> playNote(synth,channel,11,31,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,42,1000)).start();
		new Thread(() -> playNote(synth,channel,11,30,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,40,1000)).start();
		new Thread(() -> playNote(synth,channel,11,28,1000)).start();
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,1000)).start();
		new Thread(() -> playNote(synth,channel,11,26,1000)).start();
		try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> playNote(synth,channel,10,38,3000)).start();
		new Thread(() -> playNote(synth,channel,11,26,3000)).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
// GOOD ENOUGH - ALBERT YANG	
	public void Harmony(Synthesizer synth, MidiChannel[] channel){
		new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,21,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part2
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,7,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    //new Thread(() -> playNote(synth,channel,4,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part3
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,21,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part4
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,19,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,16,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,7,1000)).start();
	    //new Thread(() -> playNote(synth,channel,4,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  //Part5
		new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,21,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part6
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,7,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    new Thread(() -> playNote(synth,channel,4,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part7
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,21,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //part8
	    new Thread(() -> playNote(synth,channel,3,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,19,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,18,1000)).start();
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,16,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,10,1000)).start();
	    //new Thread(() -> playNote(synth,channel,4,14,1000)).start();
	    try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    playNote(synth,channel,5,9,250);
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(() -> playNote(synth,channel,3,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,9,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,9,1000)).start();
	    try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,3,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,11,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,11,1000)).start();
	    try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //new Thread(() -> playNote(synth,channel,5,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,6,14,1000)).start();
	    new Thread(() -> playNote(synth,channel,7,14,1000)).start();
	    try {
			Thread.sleep(375);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void playChord(Synthesizer synth, MidiChannel[] channel, int chanNum, int note, int rest, int volume) {
	        channel[chanNum].noteOn(note+12, volume);//type of note, volume
		try{
		Thread.sleep(rest);//rest
		}
		catch(InterruptedException e){
			//break;
		}
		finally{
			channel[chanNum].noteOff(2, 100);
		}  
	}
		
	public void displayMenu(){
		System.out.println("Choose which song piece to play: ");
		System.out.println("\t 1) Good Enough"); //by Bobby Brown
		System.out.println("\t 2) Faded"); //by Alan Walker
		System.out.println("\t 3) Go the Distance"); //from Disney's Hercules
		System.out.println("\t 4) Kawaranai Mono"); //by Hanako Oku
		System.out.println("\t 5) Exit"); //by Hanako Oku
	}
	public static void main(String[] args){
		new Playlist();
	}
}
