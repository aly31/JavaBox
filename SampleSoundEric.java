
import java.util.logging.Logger;

import javax.sound.midi.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SampleSoundEric {
	private static final Logger LOG = Logger.getLogger(SampleSoundEric.class.getName());
	private static final int MIDI_CHANNEL = 0;
	//private static final int[] notes = new int[]{0,52, 0,52, 0, 52, 0, 52, 0};
	private static final int[] metronome = new int[] {56};
	 
	public static void main(String[] args){
		//60 is middle c
		//62D 64E 65F 67G 69A 71B 72C
		
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			Instrument[] band = synth.getAvailableInstruments();
			Instrument ins = band[0];//type of instrument
			synth.loadInstrument(ins);
			MidiChannel[] channel = synth.getChannels();
			Patch patch = ins.getPatch();
			channel[0].programChange(patch.getBank(), patch.getProgram());
			channel[1].programChange(patch.getBank(), patch.getProgram());
 			channel[2].programChange(patch.getBank(), patch.getProgram());
			channel[3].programChange(patch.getBank(), patch.getProgram());

			LOG.info(String.format("Configured synth with %s", ins.getName()));
		        int note = 0;
			/* FADED - ALAN WALKER */
			while(note <= 45){ 
				/* INTRO */
				if (note == 0) {
				    new Thread(() -> playChord(synth,channel,0,60,550,100)).start(); //C5
                  		    new Thread(() -> playChord(synth,channel,0,52,550, 100)).start();//E4 
           			    new Thread(() -> playChord(synth,channel,2,57,550,75)).start();//A4 
				} else if (note == 2 || note == 4) {
				    new Thread(() -> playChord(synth,channel,0,60,550,100)).start();//C5 
 				    new Thread(() -> playChord(synth,channel,1,69,550,100)).start();//A5 
				} else if (note == 6 || note == 17 || note == 19) {
 				    new Thread(() -> playChord(synth,channel,0,60,550,100)).start();//C5
				    new Thread(() -> playChord(synth,channel,1,64,550,100)).start();//E5 
				}
				else if (note == 1 || note == 3 || note == 5 || note == 7) {
	 			    new Thread(() -> playChord(synth,channel,0,52,550, 100)).start();//E4
				} else if (note == 8) {
				    new Thread(() -> playChord(synth,channel,0,81,550,100)).start();//A6
				    new Thread(() -> playChord(synth,channel,1,65,550,100)).start();//F5
           			    new Thread(() -> playChord(synth,channel,2,53,550,100)).start();//F4  
				} else if (note == 9 || note == 11) { 
				    new Thread(() -> playChord(synth,channel,0,65,550,100)).start();//F5 
				} else if (note == 10 || note == 12) {	
				    new Thread(() -> playChord(synth,channel,0,81,550,100)).start();//A6
				    new Thread(() -> playChord(synth,channel,1,65,550,100)).start();//F5	
				} else if (note == 13) {
				    new Thread(() -> playChord(synth,channel,1,65,550,100)).start();//F5 
				} else if (note == 14) {
				    new Thread(() -> playChord(synth,channel,1,79,800,100)).start();//G6
           			    new Thread(() -> playChord(synth,channel,2,67,800,100)).start();//G5
				    try {
 				        Thread.sleep(550);
				    }
				    catch(InterruptedException e){
					//break;
				    }
		  		    finally{
			                channel[1].noteOff(2, 100);
					channel[2].noteOff(2, 100);
		                    }
				} else if (note == 15) {   
				    new Thread(() -> playChord(synth,channel,0,69,550,100)).start();//A5
				    new Thread(() -> playChord(synth,channel,1,64,550,100)).start();//E5
           			    new Thread(() -> playChord(synth,channel,2,48,550,100)).start();//C4
				   
				} else if (note == 16 || note == 18 || note == 20 || note == 22) { 
				    new Thread(() -> playChord(synth,channel,0,67,550,100)).start();//G5 
				} else if (note == 21) {
                                    new Thread(() -> playChord(synth,channel,1,67,550,100)).start();//G5
           			    new Thread(() -> playChord(synth,channel,2,62,550,100)).start();//D2
				} else if (note == 20 || note == 22) { 
				    new Thread(() -> playChord(synth,channel,0,67,550,100)).start();//G5
				} else if (note == 23) {
				    new Thread(() -> playChord(synth,channel,0,71,550,100)).start();//B5
                                    new Thread(() -> playChord(synth,channel,0,67,550,100)).start();//G5
                                    new Thread(() -> playChord(synth,channel,0,55,550,75)).start();//G4
				} else if ( note == 24 || note == 26 || note == 28 || note == 30) {
				    new Thread(() -> playChord(synth,channel,0,50,550,50)).start();//D4
				} else if (note == 25 || note == 27) { 
				    new Thread(() -> playChord(synth,channel,0,71,550,100)).start();//B5
                                    new Thread(() -> playChord(synth,channel,0,67,550,75)).start();//G5
				} else if (note == 29) { 
				    new Thread(() -> playChord(synth,channel,0,69,550,100)).start();//A5
                                    new Thread(() -> playChord(synth,channel,0,50,550,75)).start();//D4
				}
				/* VERSE */
				else if (note == 31) {
				   new Thread(() -> playChord(synth,channel,0,57,250,100)).start();//A4	
				} else if (note == 32) {
			           new Thread(() -> playChord(synth,channel,0,52,250,100)).start();//E4
				} else if (note == 33 || note == 35 || note == 37 || note == 41 || note == 42) {
			           new Thread(() -> playChord(synth,channel,0,60,250,75)).start();//C5	
				} else if (note == 34 || note == 36 || note == 40) {
      				   new Thread(() -> playChord(synth,channel,0,69,250,75)).start();//A5
				} else if (note == 38) {
 				   new Thread(() -> playChord(synth,channel,0,62,250,100)).start();//D5
				} else if (note == 39) { 
 			           new Thread(() -> playChord(synth,channel,0,64,250,100)).start();//E5
				   new Thread(() -> playChord(synth,channel,0,53,250,100)).start();//F4
				} else if (note == 43) {
				   new Thread(() -> playChord(synth,channel,0,67,250,100)).start();//G5
				   //new Thread(() -> playChord(synth,channel,0,50,550,100)).start();//D
				} else if (note == 44 || note == 45) {
				   new Thread(() -> playChord(synth,channel,0,64,1000,100)).start();//E5
				} 
				note++; // increment note to play next one
				try{
			            Thread.sleep(550);
				}
				catch (InterruptedException e) {
				}
				finally {
				    channel[0].noteOff(2, 100);
				}
			}
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
		}
	}
	public static void playChord(Synthesizer synth, MidiChannel[] channel, int chanNum, int note, int rest, int volume) {
	        channel[chanNum].noteOn(note, volume);//type of note, volume
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
}
