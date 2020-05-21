/************************************************************************
  * File: Exercise.java
  * When: Dec.18th
  * Who: Han Qiao
  * What: Exercise object with name, reps, time, image, caloreis.
  ***********************************************************************/

public class Exercise{
  public String name;
  public int reps;
  public int time; //in seconds
  public int calories; //150lb per hour
  public String imageFile;
  
  /* constructor1
   * @param n name of the exercise
   * @param r number of reps
   * @param t time of the exercise
   * @param c calorie burn
   */
  public Exercise(String n, int r, int t, int c){
    name = n;
    reps = r;
    time = t;
    calories = c;
    imageFile = "No Image Yet."; //need a default image for image not set
  }
  
  /* constructor2
   * @param n name of the exercise
   * @param r number of reps
   * @param t time of the exercise
   * @param c calorie burn
   * @param i imageFile
   */
  public Exercise(String n, int r, int t, int c, String i){
    name = n;
    reps = r;
    time = t;
    calories = c;
    imageFile = i; //need a default image for image not set
  }
  
  /* getName
   * @return name
   */
  public String getName(){
    return name;
  }
  
  /* setName
   * @param s new name
   */
  private void setName(String s){
    name = s;
  }
  
  /* getReps
   * @return reps
   */
  public int getReps(){
    return reps;
  }
  
  /* setName
   * @param s new name
   */
  private void setReps(int i){
    reps = i;
  }
  
  /* getTime
   * @return reps
   */
  public int getTime(){
    return time;
  }
  
  /* setTime
   * @param t new time
   */
  private void setTime(int t){
    time = t;
  }
  
  /* getCalorie
   * @return calorie
   */
  public int getCalories(){
    return calories;
  }
  
  /* setCalorie
   * @param c new calorie
   */
  private void setCalories(int c){
    calories = c;
  }
  
  /* getImage
   * @return imageFile
   */
  public String getImage(){
    return imageFile;
  }
  
  /* setImage
   * @param f new imageFile
   */
  private void setImage(String f){
    imageFile = f;
  }
  
  /*calculate Calories
   * @param weight
   * @return userCalories
   */
  public double calculateCalories(int weight){
    //information found in fitclick
    //convert from 150lb per hour to users weight
    double wh = calories*weight/150; //convert weight
    double userCalories = wh *time/3600; //convert time
    return userCalories;
  }
  
  public String toString(){
    String s = "Exercise Name: " + name + "\nReps: " + reps + "\nTime: " + time +
      "\nCalories: " + calories + "\nImage File: " + imageFile;
    return s;
  }
  
  public static void main(String args[]){
    //test
    Exercise plank = new Exercise("plank", 1, 60, 221);
    System.out.println(plank);
    System.out.println("A 120lb user does 1 set of plank: " + plank.calculateCalories(120));
    
    Exercise squats = new Exercise("Squats", 15, 60, 306);
    System.out.println(squats);
    System.out.println("A 200lb user does 1 set of plank: " + squats.calculateCalories(200));
  }
  
}