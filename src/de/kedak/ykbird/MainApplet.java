package de.kedak.ykbird;

import java.applet.Applet;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class MainApplet extends Applet {

	
	public void paint (Graphics g)
	   {
	      //g.drawString ("Hello World", 25, 50);
	      g.draw
	      SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	                UIManager.put("swing.boldMetal", Boolean.FALSE);
	                createAndShowGUI();
	            }
	        });
	      
	      
	   }
	
	
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("FileChooserDemo2");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Add content to the window.
	        frame.add(new FileChooserDemo2());

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
}
