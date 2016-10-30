
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeannine
 */
public class DiceWindow extends JFrame {
    
    private JPanel imagePanel;          //to hold JPanel
    private JLabel imageLabel;          //to hold JLabel
    
    /* This method creates a window to display animated die image */
    public DiceWindow() {
        
        //Set title of window
        setTitle("Rolling Dice");
        
        //Set action for exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set layout
        setLayout(new BorderLayout());
        
        //Create JPanel
        imagePanel = new JPanel();
        
        //Find and set location of animated dice image
        java.net.URL imgURL = getClass().getResource("rollingDice.gif");
        ImageIcon diceImage = new ImageIcon(imgURL);
                
        //Create JLabel to hold image
        imageLabel = new JLabel();
        
        //Set image in panel
        imagePanel.add(imageLabel);
        
        //Set dice image to image in panel
        imageLabel.setIcon(diceImage);
        
        //Add image panel to frame and center it
        add(imagePanel, BorderLayout.CENTER);
        
        //Adjust size of window to fit image
        pack();      
    }
}


