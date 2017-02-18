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
	private boolean clicked;
	
	
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
		clicked = false;

		// initalize buttons	
	        b1 = new JButton("Good Enough");
		b2 = new JButton("Faded By Alan Walker");	
		b3 = new JButton("Go the Distance");

		// add to j frame
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);

               

		if (clicked == true) {
			disableAllButtons();
		} else {
			enableAllButtons();
		}
		
// REPLACE W/ SONG1		
	        	
		b1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Not yet implemented");
				//disableAllButtons();
				//jf.setVisible(true);
				
				SampleSoundPlus ssp = new SampleSoundPlus();
				try {
					clicked = true;
					ssp.main(null);
				;
				} catch (InterruptedException e) {
					// FIXME Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

// REPLACE W/ SONG2		
		//l2 = new JLabel("Play or Pause the song");
		b2.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent arg0) {
			    //disableAllButtons();
			    //jf.setVisible(true);
			    SampleSoundEric eric = new SampleSoundEric();
			    clicked = true;
			    eric.main(null);
			    
			    

				
			}
		});

// REPLACE W/ SONG3		
		b3.addActionListener(new ActionListener(){
			//disableAllButtons();
			public void actionPerformed(ActionEvent arg0) {
				//disableAllButtons();
				//jf.setVisible(true);
				GoDistance gd = new GoDistance();
				clicked = true;	
				gd.main(null);
				
			}
		});
		clicked = false;        
	}
	public void disableAllButtons() {
  	   b1.setEnabled(false);
	   b2.setEnabled(false);
	   b3.setEnabled(false);
	}
	public void enableAllButtons() {
	   b1.setEnabled(true);
	   b2.setEnabled(true);
	   b3.setEnabled(true);
	}
	
	public static void main(String[] args){
		new SoundPanel();
		
	}
}
