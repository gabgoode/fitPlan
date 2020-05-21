/***********************************************************************************
  * File: WelcomePanel.java
  * When: Dec.18th
  * Who: Angela Wang
  * What: Starting panel for the GUI with description of FitPlan! and start button
  *********************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;


public class WelcomePanel extends JPanel{

    // Instantiate components of WelcomePanel
    private JLabel welcome, blurb;
    private JButton startButton;
    private JPanel titlePanel, blurbPanel, buttonPanel;
    
    /* WelcomePanel constructor with no parameters
     */
    public WelcomePanel(){
      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); //Box Layout used for WelcomePanel
      Color background = new Color(224, 255, 254); //Light blue color as background
      setBackground(background); // Set the background
      
      // Instantiate titlePanel, set its background and add its respective components
      titlePanel = new JPanel();
      titlePanel.setBackground(background);
      welcome = new JLabel("<html><p></p><b><font size=6> Welcome to FitPlan!</font></b></html>");
      titlePanel.add(welcome);
      
      // Instantiate blurbPanel, set its background and add its respective components
      blurbPanel = new JPanel();
      blurbPanel.setBackground(background);
      blurb = new JLabel("<html><font size = 5>After you answer some <br>questions, our program<br> will lead you through<br> a suitable series of<br> exercises that can help <br>you quickly de-stress!</font><br> </html>");
      blurbPanel.add(blurb);
      
      // Instantiate titlePanel, set its background and add its respective components
      buttonPanel = new JPanel();
      buttonPanel.setBackground(background);
      startButton = new JButton("<html><font size =5>Start</font></html>");
      startButton.setPreferredSize(new Dimension(100, 40));
      buttonPanel.add(startButton);
      
      // Add JPanels to the WelcomePanel
      add(titlePanel);
      add(blurbPanel);
      add(buttonPanel);
      
      //testing music
      /*
      musicListener mu = new musicListener();
      startButton.addActionListener(mu);
      */
    }

    /* setWelcomeButtonListener
     * listener for the startButton 
     * and this listener is actually defined in the FitPlanGui class
     * @param listener of type ActionListener
     */

    public void setWelcomeButtonListener(ActionListener listener){
        startButton.addActionListener(listener);
    }
    
    /* Trying to write music listener
    public static class musicListener implements ActionListener{
      public final void actionPerformed(ActionEvent e){
        music();
      }
    }
    
    public static void music() {       
      AudioPlayer MGP = AudioPlayer.player;
      AudioStream BGM;
      AudioData MD;
      
      ContinuousAudioDataStream loop = null;
      
      try
      {
        InputStream test = new FileInputStream("1.mp3");
        BGM = new AudioStream(test);
        AudioPlayer.player.start(BGM);
        MD = BGM.getData();
        loop = new ContinuousAudioDataStream(MD);
      }
      catch(FileNotFoundException e){
        System.out.print(e.toString());
      }
      catch(IOException error)
      {
        System.out.print(error.toString());
      }
      MGP.start(loop);
    }
    */

}