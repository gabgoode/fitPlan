/***********************************************************************************
  * File: InfoPanel.java
  * When: Dec.18th
  * Who: Angela Wang
  * Modified: Gab Liu
  * What: Second panel after the WelcomePanel which asks for user's name and weight
  *********************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class InfoPanel extends JPanel{
    
    // Instantiate InfoPanel components
    private JButton letsGo;
    private JLabel enterName, enterWeight, optional;
    private JTextField nameInput, weightInput;
    private JPanel namePanel, weightPanel, optionalPanel, buttonPanel;
    private Font nameFont, weightFont;  
    private User user;

    /* InfoPanel constructor with no parameters
     */
    public InfoPanel(){
      //create an empty user
      user = new User();
      
      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); //Give InfoPanel a BoxLayout
      Color background = new Color(224, 255, 254); //Light blue color as background
      setBackground(background); // Sets light blue color as background
      
      // Instantiate namePanel, set its background and add its respective components
      namePanel = new JPanel();
      namePanel.setBackground(background);
      enterName = new JLabel("<html><p><b><font size = 5>Name:</font></b></p></html>");
      nameFont = new Font("SansSerif", Font.PLAIN,15);
      nameInput = new JTextField(11);
      nameInput.setFont(nameFont);
      nameInput.addActionListener(new NameListener());//Gab Modified
      namePanel.add(enterName);
      namePanel.add(nameInput);

      // Instantiate weightPanel, set its background and add its respective components
      weightPanel = new JPanel();
      enterWeight = new JLabel("Weight");
      enterWeight.setText("<html><b><font size = 5>Weight:</font></b></html>");
      weightFont = new Font("SansSerif", Font.PLAIN, 15);
      weightInput = new JTextField(10); 
      weightInput.setFont(weightFont);
      weightPanel.add(enterWeight);
      weightInput.addActionListener(new WeightListener());//Weight Modified
      weightPanel.add(weightInput);
      weightPanel.setBackground(background);
      
      // Instantiate optionalPanel, set its background and add its respective components
      optionalPanel = new JPanel();
      optional = new JLabel("<html><font size = 5>If you want a workout<br> summary at the end, <br>enter your info above! <br> If not, just click the <br>'Let's Go' button<br> to get started! :)<br></font></html>");
      optionalPanel.add(optional);
      optionalPanel.setBackground(background);
      
     // Instantiate buttonPanel, set its background and add its respective components
      buttonPanel = new JPanel();
      letsGo = new JButton("<html><font size =5>Let's Go!</font></html>");
      letsGo.setPreferredSize(new Dimension(150, 40));
      buttonPanel.add(letsGo);
      buttonPanel.setBackground(background);
      
      // Add JPanels to InfoPanel
      add(namePanel);
      add(weightPanel);
      add(optionalPanel);
      add(buttonPanel);
      
    }
    


    /* setInfoButtonListener
     * listener for the letsGo button which is defined in the FitPlanGui class
     * @param listener of type ActionListener
     */
    public void setInfoButtonListener(ActionListener listener){
        letsGo.addActionListener(listener);
    }
    
    
    //Note: the following is Gab's attempt to create a User Object based on user inputs
    //*****************************************************************
    //  Represents an action listener for the name input field.
    //*****************************************************************
     private class NameListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Performs the conversion when the enter key is pressed in
      //  the text field.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         if(event.getSource() == nameInput){
           String name = nameInput.getText();
           user.setName(name);
           //System.out.println("name in actionPerformed: "+name);
         }
         
      }
     }
     
     //*****************************************************************
     //  Represents a weight listener for the name input field.
     //*****************************************************************
     private class WeightListener implements ActionListener
     {
       public void actionPerformed (ActionEvent event)
       {
         if(event.getSource() == weightInput){
           String weighttext = weightInput.getText();
           int weight = Integer.parseInt(weighttext);
           user.setWeight(weight);
           //System.out.println("weight in actionPerformed: "+weight);
         }
       }
     }
     
     public User getUser(){
       return user;
     };
   }
