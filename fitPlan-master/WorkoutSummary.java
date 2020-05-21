/******************************************************************************************************
  * File: WorkoutSummary.java
  * When: Dec.18th
  * Who: Angela Wang, Han Qiao
  * What: Interface that displays the workout generated for the user before the exercises are performed
  ******************************************************************************************************/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WorkoutSummary extends JPanel{

    // Instance variables
    private JLabel title, workoutPlan;
    private JButton startButton;
    private JPanel titlePanel, planPanel, buttonPanel;
    private Workout w;
    private String summary = "";

    /* WorkoutSummary constructor 
     * @param w instance of Workout class
     */
    public WorkoutSummary(Workout w){
      this.w = w;
      LinkedList<Exercise> exerList = w.getExerList();
      //setLayout(new BorderLayout()); // Set BorderLayot  
      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
      Color background = new Color(224, 255, 254);
      setBackground(background);
      //setLayout(new FlowLayout());
      
     // TitlePanel
      titlePanel = new JPanel();
      title = new JLabel("<html><p><b><font size = 5>Your Customized Workout!</font></b></p> </html>");
      titlePanel.add(title);
      
      // planPanel
      planPanel =  new JPanel();
      // List the exercises in the workout plan!
      for(int i=0; i<exerList.size(); i++){
        String exerciseName = exerList.get(i).getName();
        int exerciseReps = exerList.get(i).getReps();
        //summary += "<html><p>" + exerciseName + ": " + String.valueOf(exerciseReps) + "</p></html>";
        summary += exerciseName + ": " + String.valueOf(exerciseReps) + "\n";
        //summary += "<html><p></p></html>";
      }
      workoutPlan = new JLabel(summary);
      planPanel.add(workoutPlan);
      
      // buttonPanel --> to be added later
      //buttonPanel = new JPanel();
      //startButton = new JButton("<html><font size =4>Start Workout!</font></html>");
      //startButton.setPreferredSize(new Dimension(150, 40));
      //buttonPanel.add(startButton);
      
      add(titlePanel);
      add(planPanel);
      //add(buttonPanel);
    }
 
    //Idea: http://stackoverflow.com/questions/19104014/add-an-actionlis tener-to-a-jbutton-from-another-class
    public void setStartWorkoutListener(ActionListener listener){
        startButton.addActionListener(listener);
    }
    
}