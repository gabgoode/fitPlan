/***********************************************************************************
  * File: FiPlanGui.java
  * When: Dec.18th
  * Who: Angela Wang, Han Qiao
  * What: General GUI class for the FitPlan App
  *********************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FitPlanGui {
  
  private static JFrame frame = new JFrame("FITPLAN");
  private JPanel basePanel = new JPanel();
  private Timer timer;
  private CardLayout cardL = new CardLayout(); // A cardlayout
  //private User user; // An attempt to implement user feature
  
  
  /* FitPlanGui constructor 
   * new instance is called in the main method
   */
  public FitPlanGui(){

    //This is the panel where I add the other panels for menu and game
    basePanel.setLayout(cardL);
    
    //Creating the panels I want to add. 
    WelcomePanel welcomePanel = new WelcomePanel(); 
    InfoPanel infoPanel = new InfoPanel();
    
    //create QuestionTree and pass it into the PreferencePanel
    QuestionTree qTree = new QuestionTree();
    PreferencePanel prefPanel =  new PreferencePanel(qTree);
    //user = new User();
    
    //Adding the panels to the basePanel
    basePanel.add( welcomePanel, "welcomepanel");
    basePanel.add( infoPanel, "infopanel");
    basePanel.add( prefPanel,"prefpanel");
    cardL.show(basePanel, "basepanel");   
    
    //Buttons' action listeners that are defined in the classes at the end of this file
    nextPageListener flipPage = new nextPageListener();
    welcomePanel.setWelcomeButtonListener(flipPage);
    infoPanel.setInfoButtonListener(flipPage);
    
    // An attempt to reset user info
    //user=infoPanel.getUser();
    //System.out.println("User after getting the information: "+user)
    
    //ADDING basePanel to the frame
    frame.add(basePanel);
    // create and setup window
    frame.setTitle("FITPLAN");
    frame.setSize(1200, 600); // Was formerly 350, 500
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    
    //display window
    //frame.pack();
    frame.setVisible(true);
    frame.setResizable(true); 
  }
  
  // Main method to run the GUI!
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      public void run() {
        new FitPlanGui();
      }
    });
  }
  
  // Flipping to the next panel in basePanel (next card in cardlayout)
  private class nextPageListener implements ActionListener{
    public void actionPerformed (ActionEvent e){
      cardL.next(basePanel);
    }
  }
}


   
