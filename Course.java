
/**
 * Class that represents an individual course.
 * @author Yves Semana Gisubizo
 * @version 1.0
 */

public class Course{

  //instance variables
  private String name;  //storing course name
  private String title;  //storing course title
  private int students;  //storing total number of students who have taken the course
  private int votes;   //storing total number of positive recommendation votes of the course

 /** Default contrcutor */
  public Course(){}

 /** Parametrized constructor */
  public Course(String name, String title, int students, int votes){
    this.name = name;
    this.title = title;
    this.students = students;
    this.votes = votes;
  }
 /** Returns the name of the course
   * @return name
   * Time Complexity: O(1)
   */
  public String getName(){ return name; }

  /** Returns the title of the course
    * @return title
    * Time Complexity: O(1)
    */
  public String getTitle(){ return title; }

  /** Returns the number of students who took the course
    * @return students number
    * Time Complexity: O(1)
    */
  public int getStudents(){ return students; }

  /** Returns the number of yes votes for recommendation
    * @return votes for yes
    * Time Complexity: O(1)
    */
  public int getVotes(){ return votes; }

  /** Updates the name of the course
    * @param new name
    * Time Complexity: O(1)
    */
   public void setName(String name){this.name = name; }

   /** Updates the title of the course
     * @param new title
     * Time Complexity: O(1)
     */
   public void setTitle(String title){ this.title = title; }

   /** Updates the number of students who took the course
     * @param new students number
     */
   public void setStudents(int students){ this.students = students; }

   /** Updates the number of yes votes for recommendation
     * @param votes for new recommendations
     * Time Complexity: O(1)
     */
   public void setVotes(int votes){ this.votes = votes; }

   /** Returns the percentage of the students who recommend this course
     * @return
     * Time Complexity: O(1)
     */
   public double getScore(){
     double score = ((votes*1.0)/students)*100; //changing the votes first into doube so the quotient becomes a double value
     return (int) score;
   }

   /** Returns the String representation of a full course description.
     * @return
     * Time Complexity: O(1)
     */
   public String description(){
     return name + ": " + title + " has been taken by " + students + " students and has a " + (int) getScore() + "% recommendation score.";
   }

   /** Returns the String representation consisting of the course name and the recommendation score
     * @return
     * Time Complexity: O(1)
     */
   public String toString(){
     return name + ": " + (int) getScore() + "%";
   }

}
