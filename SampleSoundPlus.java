import java.util.logging.Logger;
import javax.sound.midi.*;
//import javax.swing.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
public class SampleSoundPlus {
	public static int run = 0;
	private static final Logger LOG = Logger.getLogger(SampleSoundPlus.class.getName());
	//private static final int MIDI_CHANNEL = 0;
	private static final int[] notes = new int[]{36,37,38,39,40,41,42,43,44,45,46,47,
48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,
76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,
103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119};
	public static void main(String[] args) throws InterruptedException{
		run = 1;
		//60 is middle c
		//62D 64E 65F 67G 69A 71B 72C
		//26 is lite guitar
		//32,33,34 all bass
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			Instrument[] band = synth.getAvailableInstruments();
			MidiChannel[] channel = synth.getChannels();
			Instrument acousticBass = band[32];
			setChannel(synth, channel, acousticBass, 0);
			Instrument fingeredBass = band[33];
			setChannel(synth, channel, fingeredBass, 1);
			Instrument pickedBass = band[34];//type of instrument
			setChannel(synth, channel, pickedBass, 2);
			Instrument synthDrum = band[118];
			setChannel(synth, channel, synthDrum, 3);
			Instrument reverseCymb = band[119];
			setChannel(synth, channel, reverseCymb, 4);
			Instrument punch = band[156];
			setChannel(synth, channel, punch, 5);
			Instrument funkGt = band[186];
			setChannel(synth, channel, funkGt, 6);
			Instrument funkGt2 = band[216];
			setChannel(synth, channel, funkGt2, 7);
			
			Instrument whistle = band[78];
			setChannel(synth, channel, whistle, 8);
			
			//PERCUSSION FOR CHANNEL 9 very unstable
			Instrument abDrum = band[2];
			setChannel(synth, channel, abDrum, 9);
			
			Instrument mandolin = band[215];
			setChannel(synth, channel, mandolin, 10);
			
			Instrument piano1 = band[0];
			setChannel(synth, channel, piano1, 11);
			
			//Instrument starship = band[217];
			//setChannel(synth, channel, starship, 12);
			
			//Harmony(synth,channel); uncomment this later and use with Melody
			try{
				//playNote(synth,channel,9,38,1000);
				new Thread(() -> Harmony(synth,channel)).start();
			    new Thread(() -> Melody(synth,channel)).start();
			}catch(Exception e){
				
			}
			
			
			
		    Thread.sleep(2500);
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
		}
	}
	public static void setChannel(Synthesizer synth, MidiChannel[] channel, Instrument instr, int chanNum){
		synth.loadInstrument(instr);
		Patch patch = instr.getPatch();
		channel[chanNum].programChange(patch.getBank(), patch.getProgram());
		LOG.info(String.format("Configured synth with %s", instr.getName()));

	}
	public static void playNote(Synthesizer synth, MidiChannel[] channel, int chanNum, int note, int rest){
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
	public static void Melody(Synthesizer synth, MidiChannel[] channel){
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
	public static void Harmony(Synthesizer synth, MidiChannel[] channel){
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
}
