/***********************************************************************************
  * File: PreferencePanel.java
  * When: Dec.18th
  * Who: Angela Wang, Han Qiao
  * What: Interface that flips between three questions using the QuestionTree class
  *********************************************************************************/

import javafoundations.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PreferencePanel extends JPanel{
  
    // Instance variables for PreferencePanel components
    private JButton yesButton, noButton, homeButton;
    private JLabel question;
    private JPanel titlePanel, firstbuttonPanel, secondbuttonPanel, homePanel;
    
    // Define backend objects for GUI to link to
    private Workout wo;
    private QuestionTree qTree; 
    private LinkedBinaryTree<BTNode> current;
    private CardLayout cardL = new CardLayout(); 
    private PreferencePanel pref; 

    
    /* PreferencePanel constructor 
     * @param qTree represents a QuestionTree
     */
    public PreferencePanel(QuestionTree qTree){
      pref = this; //for the listener
      this.qTree = qTree; 
      Color background = new Color(224, 255, 254);
      setBackground(background);
      //setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); // Sets BoxLayout for PreferencePanel
      setLayout(new FlowLayout());
      
      // Instantiate titlePanel, set its background and add its respective components
      titlePanel = new JPanel();
      titlePanel.setBackground(background);
      question = new JLabel ("<html><p></p><p></p><b><font size = 5>Choose your workout preference: </font></b></html>");
      titlePanel.add(question);
      
      // Instantiate buttonPanel, set its background and add its respective components
      firstbuttonPanel = new JPanel();
      firstbuttonPanel.setBackground(background);
      yesButton = new JButton("<html><font size = 5>Workout & Stretch</font></html>");
      yesButton.setPreferredSize(new Dimension(300, 75));
      firstbuttonPanel.add(yesButton);
      
      // Instantiate second buttonPanel!
      secondbuttonPanel = new JPanel();
      secondbuttonPanel.setBackground(background);
      noButton = new JButton("<html><font size = 5>Just Stretch</font></html>");
      noButton.setPreferredSize(new Dimension(300, 75));
      secondbuttonPanel.add(noButton);
      
      // Instantiate homePanel, set its background and add its respective components
      homePanel = new JPanel();
      homePanel.setBackground(background);
      homeButton = new JButton("Home"); // Temporary button we may remove later
      //homePanel.add(homeButton); 
      
      //Add JPanels to PreferencePanel
      add(titlePanel);
      add(firstbuttonPanel);
      add(secondbuttonPanel);
      add(homePanel);
      
      //Add listener to the yesButton and noButton
      yesButton.addActionListener(new yesButtonListener());
      noButton.addActionListener(new noButtonListener());
    }
   
    
    /* yesButtonListener class that implements ActionListener 
     * and contains actionPerformed(ActionEvent event) method
     * @param event is an ActionEvent
     */
    private class yesButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        qTree.getLeft(); //Go to left node if user answers yes to question!
        
        if(!qTree.currentIsLeaf()){ // If the nodes are Question objects instead of Workout objects
          question.setText(qTree.getCurrentNode().getElement().toString());
          yesButton.setPreferredSize(new Dimension(200, 50));
          noButton.setPreferredSize(new Dimension(200, 50));
          yesButton.setText("<html><font size = 5>Yes</font></html>");
          noButton.setText("<html><font size = 5>No</font></html>");
          
        }else{ // If node is a Workout object, display the WorkoutSummary panel and ExercisePanel
          // Set PreferencePanel components to invisible when switching to WorkoutSummary and ExercisePanel interfaces
          question.setVisible(false);
          yesButton.setVisible(false);
          noButton.setVisible(false);
          
          // Switch to WorkoutSummary interface
          wo = (Workout) qTree.getCurrentNode().getElement();;
          WorkoutSummary wspanel = new WorkoutSummary(wo);
         
          add(wspanel); // add WorkoutSummary panel to PreferencePanel

          ExercisePanel exerpanel = new ExercisePanel(wo);
          add(exerpanel); // add ExercisePanel to Preference Panel
        }
      }
    }
   
    /* noButtonListener class that implements ActionListener 
     * and contains actionPerformed(ActionEvent event) method
     * @param event is an ActionEvent
     */
    private class noButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        qTree.getRight(); //Go to right node if user answers no to question! 
        
        if(!qTree.currentIsLeaf()){ // If the nodes are Question objects instead of Workout objects
          question.setText(qTree.getCurrentNode().getElement().toString());
          yesButton.setText("Yes");
          noButton.setText("No");
          
        }else{ // If node is a Workout object, display the WorkoutSummary panel and ExercisePanel
          // Set PreferencePanel components to invisible when switching to WorkoutSummary and ExercisePanel interfaces
          question.setVisible(false);
          yesButton.setVisible(false);
          noButton.setVisible(false);
          homeButton.setVisible(false);
          
          // Switch to WorkoutSummary interface
          wo = (Workout) qTree.getCurrentNode().getElement();;
          WorkoutSummary wspanel = new WorkoutSummary(wo);
          add(wspanel); // add WorkoutSummary panel to PreferencePanel
          
          ExercisePanel exerpanel = new ExercisePanel(wo);
          add(exerpanel); // add ExercisePanel to Preference Panel
        }
      }
      
    }
    
    
    /* fliptoExerciseListener class that implements ActionListener 
     * and contains actionPerformed(ActionEvent event) method
     * to add exercisePanel to preferencePanel
     * @param e is an ActionEvent
     */
    private class fliptoExerciseListener implements ActionListener{
      public void actionPerformed (ActionEvent e){
        System.out.println("Clicked Start for Summary: should show Exercise Panel");
        ExercisePanel exerpanel = new ExercisePanel(wo);
        pref.add(exerpanel);
      }
    }

    /* setWorkoutListener method
     * listener for the homeButton
     * and this listener is actually defined in the FitPlanGui class
     * @param listener of type ActionListener
     */
    public void setWorkoutListener(ActionListener listener){
      homeButton.addActionListener(listener);
    }

}