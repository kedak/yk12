package de.kedak.ykbird;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainApplet extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;
	static private String newline = "\n";
    private JTextArea log;
    private JFileChooser fc;
	    
    
    
	@Override
	public void init() {
		
		log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        JButton sendButton = new JButton("Choose a file...");
        sendButton.addActionListener(this);

        add(sendButton, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Set up the file chooser.
        if (fc == null) {
            fc = new JFileChooser();

		    //Add a custom file filter and disable the default
		    //(Accept All) file filter.
	        //fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(true);

            //Add custom icons for file types.
            //fc.setFileView(new ImageFileView());

            //Add the preview pane.
            //fc.setAccessory(new ImagePreview(fc));
        }

        //Show it.
        int returnVal = fc.showDialog(this,
                                      "Process");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            log.append("Processing file: " + file.getAbsolutePath()
                       + "..." + newline);
        } else {
            log.append("Process is cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);
        log.append("======================================" + newline+ newline);
	}
}
