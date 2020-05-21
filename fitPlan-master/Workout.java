/************************************************************************
  * File: Workout.java
  * When: Dec.18th
  * Who: Han Qiao
  * What: Workout object is a linkedList that holds exercise objects
  ***********************************************************************/
import java.util.*;
import javafoundations.*;

public class Workout{
  public LinkedList exerciseList;
  private int count; //keep track of current exercise
  public int skipped;
  public int totalCalories;
  
  /* Constructor
   * @param s name of the workout
   */
  public Workout(){
    exerciseList = new LinkedList<Exercise>();
    count = 1;
    skipped = 0;
    totalCalories = 0;
  }
  
  /* aadExercise
   * @param Exercise e
   */
  public void addExercise(Exercise e){
    exerciseList.add(e);
  }
  
  /* removeExercise
   * @param Exercise e
   */
  private void removeExercise(Exercise e){
    exerciseList.remove(e);
  }
  
  /* getTotalCalories
   * @return totalCalories
   */
  public int getTotalCalories(){
    return totalCalories;
  }
  
  /* getNextExercise
   * @return e next exercise
   */
  public Exercise getNextExercise(Exercise current){ //passing in user
    int currentIndex = exerciseList.indexOf(current);
    Exercise next;
    if (currentIndex + 1 < exerciseList.size()){
      next = (Exercise) exerciseList.get(currentIndex+1);
    }else{
      next = null;
    }
    return next;
  }
  
  /* getCurrentExercise
   * @return e next exercise
   */
  public Exercise getCurrentExercise(){//Gab modified
    Exercise current = (Exercise) exerciseList.get(count);
    return current;
  }
  
  /* getExerList
   * @return exerList
   */
  public LinkedList<Exercise> getExerList(){ //passing in user
    return exerciseList;
  }
  
  public String toString(){
    String s = "Workout:\n " + exerciseList + "\n\nSkipped: " + skipped + "\nTotal Calories: " + totalCalories;
    return s;
  }
  
  public static void main(String[] args){
    
    //create exercises
    Exercise plank = new Exercise("plank", 1, 60, 221);
    Exercise squats = new Exercise("Squats", 15, 60, 306);
    Exercise b = new Exercise("Break", 1, 15, 0);
    
    //create workout and add plank and squats
    Workout ShoulderPainWorkout = new Workout();
    ShoulderPainWorkout.addExercise(plank);
    ShoulderPainWorkout.addExercise(squats);
    ShoulderPainWorkout.addExercise(b);
    
    System.out.println(ShoulderPainWorkout);
    
    //starts exercise
    System.out.println("\nGetting the next workout: " + ShoulderPainWorkout.getNextExercise(plank));
    
    
  }
  

}