/* * * * * * * * * * * * * * * * *
	Albert Yang
	Eric Dong
	Jessica Reyes
	Albert Du
* * * * * * * * * * * * * * * * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoundPanel {
	private JFrame jf;
	private JPanel jp;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	
/*	
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4; 
	NOT CURRENTLY USING 
*/
	
	public SoundPanel(){
		gui();
	}
	
	public void gui(){
		jf = new JFrame("JAVABOX");
		jf.setVisible(true);
		jf.setSize(200, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(4,1));
		

		
// REPLACE W/ SONG1		
		b1 = new JButton("Good Enough");
		//l1 = new JLabel("This is the audio visualizer.");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Not yet implemented");\
				SampleSoundPlus ssp = new SampleSoundPlus();
				try {
					ssp.main(null);
				} catch (InterruptedException e) {
					// FIXME Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

// REPLACE W/ SONG2		
		b2 = new JButton("Faded By Alan Walker");
		//l2 = new JLabel("Play or Pause the song");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    SampleSoundEric eric = new SampleSoundEric();
			    eric.main(null);
				
			}
		});

// REPLACE W/ SONG3		
		b3 = new JButton("Go the Distance");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				GoDistance gd = new GoDistance();
				gd.main(null);
			}
		});
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
	}
	
	public static void main(String[] args){
		new SoundPanel();
	}
}
