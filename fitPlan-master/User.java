/***********************************************************************************
  * File: User.java
  * When: Dec.15th
  * Who: Gab Liu
  * What: Class that creates a user object
  *********************************************************************************/

public class User{
  
//instance variables
  private String name;
  private int weight;
  private Workout plan;
  private int calories; //Han modified
  
   /*constructor
    *construct a user object
    */ 
  public User(){//default values
    name = "user";
    weight = 130;
    calories = 0; //Han modified
    plan = null;
  }

  
  /*constructor 2
   *construct a user object with more specific personal information
   *@param name, weight
   */ 
  public User(String n, int w){
    name = n;
    weight = w;
    calories = 0; //Han modified
    plan=null;
  }
  
  /*constructor 3
   *construct a user object with only name
   *@param name
   */ 
  public User(String n){
    name = n;
    weight = 130;
    calories = 0; //Han modified
    plan=null;
  } 
  
  /*toString
   *@return a String represenaton of the User object
   */ 
  public String toString(){
    String s="";
    s+="name: " + name+"\n"+ "weight: " + weight;
    return s;
  }
  
  /*getName
   *@return the name of the User object
   */ 
  public String getName(){
    return name;
  }
  
  /*getWeight
   *@return the name of the User object
   */ 
  public int getWeight(){
    return weight;
  }
  
  /*getWorkout
   *@return the workout associated with this user
   */ 
  public Workout getWorkout(){
    return plan;
  }

  
  /*setWorkout
   *@param workout
   */ 
  public void setWorkout(Workout workout){
    plan = workout;
  }
  
  /*setName
   *@param n
   */ 
  public void setName(String n){
    name = n;
  }
  
  /*setWeight
   *@param n
   */ 
  public void setWeight(int w){
    weight = w;
  }
  
  /* doNextExercise call getNextExercise in workout
   */
  public void doNextExercise(){
    Exercise current = plan.getNextExercise(plan.getCurrentExercise());
    calories += current.calculateCalories(weight);
  }
  
  /*getCaloriesBurnt
   *@return colaries
   */
  public int getCaloriesBurnt(){
    return calories;
  }
  
 
  public static void main(String args[]){
    //creating a user Lucy
    User Lucy = new User();
    Lucy.setName("Lucy");
    Lucy.setWeight(120);
    System.out.println(Lucy);
    System.out.println("User name: " +Lucy.getName());
    System.out.println("User weight: " +Lucy.getWeight());
    System.out.println("*********");
    
    //create exercises
    Exercise plank = new Exercise("plank", 1, 60, 221);
    Exercise squats = new Exercise("Squats", 15, 60, 306);
    
    //create workout and add plank and squats
    Workout ShoulderPainWorkout = new Workout();
    ShoulderPainWorkout.addExercise(plank);
    ShoulderPainWorkout.addExercise(squats);
    
    //give Lucy workout
    System.out.println("Before workout Lucy's Calories Burnt:" + Lucy.getCaloriesBurnt());
    Lucy.setWorkout(ShoulderPainWorkout);
    Lucy.doNextExercise();
    System.out.println("After the first exercise Lucy's Calories Burnt:" + Lucy.getCaloriesBurnt());
    System.out.println("**********\n\n");
    
    User Lexi = new User("Lexi", 140);
    System.out.println(Lexi);
    
  }
  
}
  
