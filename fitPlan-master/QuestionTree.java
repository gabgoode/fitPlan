/***********************************************************************************
  * File: QuestionTree.java
  * When: Dec.16th
  * Who: Gab Liu
  * What: Class that creates a question object
  *********************************************************************************/

import javafoundations.*;
import java.util.Scanner;

public class QuestionTree{
  
  //instanve variables
  private LinkedBinaryTree<BTNode> tree;
  private LinkedBinaryTree<BTNode> current;
  private BTNode answer;
  
  //-----------------------------------------------------------------
  //  Sets up the question tree
  //-----------------------------------------------------------------
  public QuestionTree(){
    //construting questions
    Question q1 = new Question("<html><p></p><p></p><b><font size = 5>Workout and stretch, or just stretch?</font></b></html>");
    Question q2 = new Question("<html><p></p><p></p><b><font size = 5>Click 'Yes' to work out upper body<br> and 'No' for lower body </font></b></html>");
    Question q3 = new Question("<html><p></p><p></p><b><font size = 5>Click 'Yes' to stretch upper body <br>and 'No' for lower body</font></b></html>");
    Question q4 = new Question("<html><p></p><p></p><b><font size = 5>Any upper body pain?</font></b></html>");
    Question q5 = new Question("<html><p></p><p></p><b><font size = 5>Any lower body pain?</font></b></html>");
    
    //constucting exercises
    
    //upperbody workouts
    Exercise situps0 = new Exercise("Easy Situps",16,30,300,"images/situps.gif");
    Exercise situps1 = new Exercise("Hard Situps",20,30,340,"images/situps.gif");
    Exercise bsc0 = new Exercise("Easy Bicep Curls",8, 30,290,"images/biceps.gif");
    Exercise bsc1 = new Exercise("Hard Bicep Curls",10, 30,323,"images/bicepshard.gif");
    Exercise plank0 = new Exercise("Easy Plank", 1, 30, 200,"images/plankEasy.gif");
    Exercise plank1 = new Exercise("Hard Plank", 1, 30, 221,"images/plankHard.gif"); //with arms extended
    Exercise pushups0 = new Exercise("Easy Pushups",6,30,260,"images/pushupsKnee.gif");
    Exercise pushups1 = new Exercise("Easy Pushups",10,30,340,"images/pushups.gif");
    
    //lowerbody workouts
    Exercise squats0 = new Exercise("Easy Squats", 10, 30, 250,"images/squats.gif");
    Exercise squats1 = new Exercise("Hard Squats", 15, 30, 306,"images/squatsJump.gif"); 
    Exercise lunges0 = new Exercise("Easy Front Lunges", 6, 30, 268,"images/frontlunges.gif");
    Exercise lunges1 = new Exercise("Hard Front Lunges", 10, 30, 408,"images/frontlungeshard.gif"); 
    Exercise side0 = new Exercise("Easy Side Lunges", 10, 30, 240,"images/sideLunges.gif");
    Exercise side1 = new Exercise("Hard Side lunges", 15, 30, 289,"images/sideLungesHard.gif"); 
    Exercise calf0 = new Exercise("Easy Calf Raise", 10, 30, 180,"images/calfraiseseasy.gif");
    Exercise calf1 = new Exercise("Hard Calf Raise", 15, 30, 204,"images/calfraises.gif"); 
   
   
    //upper body stretch workouts
    Exercise overarm = new Exercise("Over Arm Stretch", 1, 30, 1,"images/overheadstretch.gif");
    Exercise upperarm = new Exercise("Upper Arm Stretch", 1, 30, 1,"images/armstretch.gif"); 
    Exercise backcurl = new Exercise("Back Curl", 1, 30, 1,"images/backcurl.gif");
    Exercise neck = new Exercise("Neck Exercises", 1, 30, 1,"images/neckstretch.gif"); 
    
    //lower body stretch
    Exercise touchtoes = new Exercise("Touch Toes", 1, 30, 1,"images/touchtoes1.gif");
    Exercise calfstretch = new Exercise("Calf Stretches", 1, 30, 1,"images/calfstretch2.gif"); 
    Exercise hipstretch = new Exercise("Hip Stretches", 1, 30, 1,"images/hipstretch.gif");
    Exercise kneesretch = new Exercise("Knee Stretches", 1, 30, 1,"images/kneestretch.gif"); 
    
    //constructing workouts
    
    Workout wk6 = new Workout(); //upperbody with pain
    wk6.addExercise(situps0);
    wk6.addExercise(bsc0);
    wk6.addExercise(plank0);
    wk6.addExercise(pushups0);
    
    Workout wk7 = new Workout(); //upperbody normal
    wk7.addExercise(situps1);
    wk7.addExercise(bsc1);
    wk7.addExercise(plank1);
    wk7.addExercise(pushups1);
    
    Workout wk8 = new Workout(); //upperbody with pain
    wk8.addExercise(squats0);
    wk8.addExercise(lunges0);
    wk8.addExercise(side0);
    wk8.addExercise(calf0);
    
    Workout wk9 = new Workout(); //upperbody normal
    wk9.addExercise(squats1);
    wk9.addExercise(lunges1);
    wk9.addExercise(side1);
    wk9.addExercise(calf1);
    
    Workout wk10 = new Workout(); //stretch upper body
    wk10.addExercise(overarm);
    wk10.addExercise(upperarm);
    wk10.addExercise(backcurl);
    wk10.addExercise(neck);
    
    Workout wk11 = new Workout(); //stretch lower body
    wk11.addExercise(touchtoes);
    wk11.addExercise(calfstretch);
    wk11.addExercise(hipstretch);
    wk11.addExercise(kneesretch);
    
    //creating BTNodes
   
    //questions
    BTNode node1=new BTNode(q1);
    //System.out.println("printout node1: "+node1.getElement());
    BTNode node2=new BTNode(q2);
    BTNode node3=new BTNode(q3);
    BTNode node4=new BTNode(q4);
    BTNode node5=new BTNode(q5);
    
    //workouts
    BTNode node6=new BTNode(wk6);
    BTNode node7=new BTNode(wk7);
    BTNode node8=new BTNode(wk8);
    BTNode node9=new BTNode(wk9);
    BTNode node10=new BTNode(wk10);
    BTNode node11=new BTNode(wk11); 
    
    LinkedBinaryTree<BTNode> n2,n3,n4,n5,n6,n7,n8,n9,n10,n11;
    
    n6 = new LinkedBinaryTree<BTNode>(node6);
    n7 = new LinkedBinaryTree<BTNode>(node7);
    n4 = new LinkedBinaryTree<BTNode>(node4, n6, n7);
    
    n8 = new LinkedBinaryTree<BTNode>(node8);
    n9 = new LinkedBinaryTree<BTNode>(node9);
    n5 = new LinkedBinaryTree<BTNode>(node5, n8, n9);
    
    n10 = new LinkedBinaryTree<BTNode>(node10);
    n11 = new LinkedBinaryTree<BTNode>(node11);
    n3 = new LinkedBinaryTree<BTNode>(node3, n10, n11);
    
    n2 = new LinkedBinaryTree<BTNode>(node2, n4, n5);
    tree = new LinkedBinaryTree<BTNode>(node1, n2, n3);
    
    //answer = null; //default has no workout plan
    current=tree;
  }
  
  /*
  /*askQuestion
   *Follows the question tree based on user responses
   */
  public void askQuestion(){
    Scanner scan = new Scanner (System.in);
    LinkedBinaryTree<BTNode> current = tree;
    
    while(current.size()>1){
      System.out.println(current.getRootElement());
      
      if (scan.nextLine().equalsIgnoreCase("Y")){ //change scanner
        current = current.getLeft();
      }
      else{
        current = current.getRight();
      }
    }
    answer = current.getRootElement(); //get the workout plan
  }

  

  /*getAnswer
   *@return the workout plan that the user chosed
   */ 
  public BTNode getAnswer(){
    return answer;
  }
  
  /*getLeft
   *@return the leftchild
   */
  public void getLeft(){
    current = current.getLeft();
  }
  
    
  /*getRight
   *@return the leftchild
   */
  public void getRight(){
    current = current.getRight();
  }
  
  /*getCurrentNode
   *@return the current Node
   */ 
  public BTNode getCurrentNode(){
    return current.getRootElement();
  } 
  
  /*currentIsLeaf
   *@return a boolean: true if isLeaf;false otherwise
   */ 
  public boolean currentIsLeaf(){
    return current.size()==1;
  } 
  

  public static void main(String args[]){
    QuestionTree test =  new QuestionTree();
    test.getLeft();
    System.out.println(test.getCurrentNode());
    //System.out.println(test.getAnswer());
  }
  
  
}