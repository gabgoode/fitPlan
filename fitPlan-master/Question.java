/***********************************************************************************
  * File: Question.java
  * When: Dec.15th
  * Who: Gab Liu
  * What: Class that creates a question object
  *********************************************************************************/

import javafoundations.*;

public class Question{
  
  //instance vars
  String question;
  
  /*constructor
   *construct a question object
   */ 
  public Question(){
    question = "";
  }
  
  /*constructor2
   *construct a question object with the actual question
   */ 
  public Question(String q){
    question = q;
  }
  
  /*toString
   *@return a String represenaton of the Question object
   */ 
  public String toString(){
    return question;
  }
  
  /*setQuestion
   *@param q
   */ 
  public void setQuestion(String q){
    question = q;
  }
  
  public static void main(String args[]){
    Question level0 = new Question("Do you want to workout and stretch,or just stretch?");
    System.out.println(level0);
    System.out.println("");
    
    Question level1l = new Question("Do you want to workout Upper or Lower body?");
    System.out.println(level1l);
    System.out.println("");
    
    Question level1r = new Question("Do you want to stretch Upper or Lower body?");
    System.out.println(level1r);
    System.out.println("");
    
    Question level21 = new Question("Do you have any upper body pain?");
    System.out.println(level21);
    System.out.println("");
    
    Question level22 = new Question("Do you have any lower body pain?");
    System.out.println(level22);
    System.out.println("");
  
  }
 
}