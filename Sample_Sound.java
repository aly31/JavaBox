import javax.sound.midi.*;
public class Sample_Sound {
    public static void main(String [] args) {
      int [] notes = new int[] {43,50 , 60 , 73, 34};
      try {
        Synthesizer syynth = MidiSystem.getSyntheizer();
        synth.open();
        MidiChannel channel = synth.getChannels()[0];

        for (int note = 0; note < notes.length; note ++) {
          channel.noteOn(note, 50);
          try {
            Thread.sleep(200);
          }
          catch (Exception e) {
            break;
          }
          finally {
            channel.noteOff(note);
          }
        }
      }
      catch(MidiUnavailable Exception e) {
        e.printStackTrace();
      }
    }

}
