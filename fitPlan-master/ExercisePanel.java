/**********************************************************************************************************
  * File: ExercisePanel.java
  * When: Dec.18th
  * Who: Angela Wang, Han Qiao
  * What: Panel after PreferencePanel which displays each exercise with the timer and the userSummary page
  ********************************************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ExercisePanel extends JPanel{

    // Instance variables for all the exercise components
    private JButton startExercise, skipExercise;
    private JLabel currentLabel, currentExercise, nextLabel, nextExercise, timerLabel, imageLabel;
    private JLabel message; //Jlabel for the summary page message!
    private ImageIcon image; // ImageIcon component
    private int x = 225; // x location for exercise image
    private int y = 50; // y location for exercise image
    private Timer timer; // Timer component
    private int counter = 30;// The starting time for counter
    
    // Define instance of workout and exercise here as GUI links to backend
    private Workout w; 
    private Exercise currentEx;
    private String currentName;
    private int currentReps;
    private String nextName; 
    private int nextReps; 

    /* ExercisePanel constructor 
     * @param w instance of Workout class
     */
    public ExercisePanel(Workout w){
      this.w = w;
      Color background = new Color(224, 255, 254);
      setBackground(background);
      setLayout (new BoxLayout (this, BoxLayout.LINE_AXIS)); // BoxLayout sets all in a vertical column
      
      // Get exercise information from backend
      currentEx =  w.getExerList().getFirst();
      currentName = w.getExerList().getFirst().getName();
      currentReps = w.getExerList().getFirst().getReps();
      nextName = w.getNextExercise(currentEx).getName();
      nextReps = w.getNextExercise(currentEx).getReps();
      
      // Making components
      currentLabel = new JLabel("<html><b>Current: </b></html>");
      currentExercise = new JLabel(currentReps + " " + currentName);
      nextLabel= new JLabel("<html><b>Next: </b></html>");
      nextExercise= new JLabel(nextReps + " " + nextName);
      image = new ImageIcon(currentEx.getImage());
      startExercise = new JButton("Start Timer");
      skipExercise = new JButton("Skip Exercise");
      timerLabel = new JLabel("<html><p><b>Time Left: 30</b></p></html>");
      message = new JLabel("");
      imageLabel = new JLabel();
      
      
      // BOXLAYOUT TESTING: Add components to panel
      add(message);
      add(imageLabel);
      add(currentLabel);
      add(currentExercise);
      add(nextLabel);
      add(nextExercise);
      add(timerLabel);
      add(startExercise);
      add(skipExercise);
      
      //put imageIcon (image) into a imageLabel (imageLabel)
      imageLabel.setIcon(image);
      
      
      //add listener to the startExercise Button
      startExercise.addActionListener(new startExerciseListener());
      skipExercise.addActionListener(new skipExerciseListener());
    }
    
    // action listener for Go button: start timer
    private class startExerciseListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        System.out.println("Start Timer Clicked.");
        skipExercise.setEnabled(false);
        TimerClass tc = new TimerClass(31); //set each exercise to 30 seconds
        timer = new Timer(1000, tc);
        timer.start();
      }
    }
    
    // action listener for Skip button: skip Exercise
    private class skipExerciseListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        System.out.println("Skip Exercise Clicked.");
        Exercise nextEx = w.getNextExercise(currentEx);
        currentEx = nextEx;
        
        if(nextEx != null){
          currentExercise.setText(nextEx.getReps() + " " + nextEx.getName());
          //set current to next
          currentEx = nextEx;
          image = new ImageIcon(currentEx.getImage());
          imageLabel.setIcon(image);
          if(w.getNextExercise(nextEx) != null){
            nextExercise.setText(w.getNextExercise(nextEx).getReps() + " " + w.getNextExercise(nextEx).getName());
          }else{
            nextExercise.setText(" No More :)");
          }
        }else{
          //display user summary page
          message.setText("<html><b><font size = 7>You Made it!</font></b></html>");
          //make other buttons and labels disappear
          startExercise.setVisible(false);
          currentLabel.setVisible(false);
          currentExercise.setVisible(false);
          nextLabel.setVisible(false);
          nextExercise.setVisible(false);
          timerLabel.setVisible(false);
          skipExercise.setVisible(false);
          image = new ImageIcon("images/youmadeit.gif"); //change image from exercise to congrates
          imageLabel.setIcon(image);
          
        }
      }
    }
    
    
    public class TimerClass implements ActionListener{
      int counter;
      
      public TimerClass(int counter){
        this.counter = counter;
      }
      
      public void actionPerformed(ActionEvent tc){
        counter--;
        if(counter >= 0){
          timerLabel.setText("<html><b>Time left: " + counter + "</b></html>");
        } else {
          timer.stop();
          //reset counter
          counter = 30;
          timerLabel.setText("<html><b>Time left: " + counter + "</b></html>");
          //get information of the next exercise
          Exercise nextEx = w.getNextExercise(currentEx);
          skipExercise.setEnabled(true); //resume skip button
   
          if(nextEx != null){
            currentExercise.setText( nextEx.getReps() + " " + nextEx.getName());
            //set current to next
            currentEx = nextEx;
            image = new ImageIcon(currentEx.getImage());
            imageLabel.setIcon(image);
            if(w.getNextExercise(nextEx) != null){
              nextExercise.setText(w.getNextExercise(nextEx).getReps() + " " + w.getNextExercise(nextEx).getName());
            }else{
              nextExercise.setText(" No More :)");
            }
            System.out.println("Timer stopped.");
          }else{
            //display user summary page
            message.setText("<html><b><font size = 7>You Made it!</font></b></html>");
            //make other buttons and labels disappear
            startExercise.setVisible(false);
            currentLabel.setVisible(false);
            currentExercise.setVisible(false);
            nextLabel.setVisible(false);
            nextExercise.setVisible(false);
            timerLabel.setVisible(false);
            skipExercise.setVisible(false);
            image = new ImageIcon("images/youmadeit.gif"); //change image from exercise to congrates
            imageLabel.setIcon(image);
          }
        }
      }
      
    }
}