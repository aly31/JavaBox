import javax.sound.midi.*;
import javax.swing.*;
import java.util.logging.*;

public class GoDistance {
	private static final Logger LOG = Logger.getLogger(SampleSound.class.getName());	
	private static final int MIDI_CHANNEL = 0;
	private static int[] hercules = new int[]{ 66, 67, 69, 62, 64, 66, 64, 66, 67, 66, 64,
	 	66, 67, 69, 62, 64, 66, 64, 66, 67, 64,
	 	66, 67, 69, 62, 59, 62, 64, 66, 57, 55,
	 	66, 69, 71, 69, 66, 69, 74, 78, 78, 79, 76, 74, 74 };
/*
	i will find my way, i can go the distance
	i'll be there someday, if i can be strong
	i know every mile will be worth my while
	if i can go the distance i'll be right where i belong
*/	 		 	

	public static void right(Synthesizer synth, MidiChannel[] channel){
		new Thread(() -> ping(synth, channel, 0, 0, 500)).start(); //i
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 1, 500)).start();	//will
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 2, 1000)).start(); //find
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 3, 500)).start(); //my
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 4, 500)).start(); //way
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 5, 500)).start();	//i
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 6, 250)).start(); //can
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 7, 500)).start(); //go
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 8, 250)).start(); //the
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 9, 500)).start();	//dist-
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 10, 250)).start(); //ance
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 11, 500)).start(); //i'll
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 12, 500)).start(); //be
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 13, 1000)).start();	//there
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 14, 500)).start(); //some
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 15, 1000)).start();	//day
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 16, 250)).start(); //if
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 17, 250)).start();	//i
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 18, 500)).start(); //can
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 19, 500)).start(); //be
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 20, 1000)).start(); //strong
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 21, 500)).start();	//i
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 22, 500)).start(); //know
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 23, 500)).start(); //ev-
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 24, 1000)).start(); //ery
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 25, 500)).start();	//mile
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 26, 500)).start(); //will
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 27, 500)).start(); //be
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 28, 1000)).start(); //worth
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		new Thread(() -> ping(synth, channel, 0, 29, 500)).start();	//my
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 30, 1000)).start(); //while
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 31, 500)).start(); //if
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 32, 500)).start(); //i
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 33, 1000)).start();	//go
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 34, 1000)).start(); //the
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 35, 250)).start(); //dist-
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 36, 250)).start(); //ance
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 37, 250)).start();	//i'll
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 38, 250)).start(); //be
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 39, 1000)).start(); //right
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 40, 500)).start(); //where
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 41, 250)).start();	//i
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 42, 500)).start(); //be-
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> ping(synth, channel, 0, 43, 1000)).start(); //long
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void ping(Synthesizer synth, MidiChannel[] channel, int chanNum, int note, int rest){
		channel[chanNum].noteOn(hercules[note], 100);//type of note, volume
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
	public static void main(String[] args){
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open(); // opens synthesizer
		
			Instrument[] band = synth.getAvailableInstruments(); // get instruments
			Instrument piano = band[1]; // type of instrument
			synth.loadInstrument(piano); // load the instrument
		
			MidiChannel[] channel = synth.getChannels();
			Patch patch = piano.getPatch(); 
			channel[0].programChange(patch.getBank(), patch.getProgram());
			
			try{
				new Thread(() -> right(synth,channel)).start();
			}catch(Exception e){
				
			}
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
		}
	}
}