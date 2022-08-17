import java.io.*;
import java.util.*;
/**
 * Class that maintains the course statistics.
 * @author Yves Semana Gisubizo
 @ @version 1.0
 */

public class CourseStatistics extends CourseComparator{

// instance variables
Map<String, Course> map;    //map for storing the course entries
PriorityQueue<Course> pq;   //priority queue for getting organised data
private int total;          //total number of courses

/** Default constructor */
public CourseStatistics(){
  map = new HashMap<String, Course>();              //instantiating the map
  pq = new PriorityQueue<>(new CourseComparator()); //instantiating the priority queue to follow the CourseComparator comparison logic
  total = 0;
}
/** Returns the total numbe rof the courses
  * @return
  * Time Complexity: O(1)
  */
public int getTotal(){ return total;}

/**
  * Adds a course to the storage if it doens't exist already or updates its totals if already exists
  * @param c the new course to be added
  * Time Complexity: O(1)
  */
public void addCourse(Course c){
  Course temp = map.get(c.getName());
  if(temp == null){
    map.put(c.getName(), c);      //adding new course to the map
    total++;
  }
  else{
    temp.setStudents(temp.getStudents()+c.getStudents());  //updating the exisiting students of this object by adding the new Course object's number of students
    temp.setVotes(temp.getVotes()+c.getVotes());           //updating the votes
    map.replace(temp.getName(),temp);                      //replacing the updated object with the old one
  }
}

/**
  * Returns the course given its name ex: CPSC215
  * @param name the name of the course to return
  * @return course if found or else null
  * Time Complexity: O(1)
  */
public Course getCourse(String name){
  if(!map.containsKey(name)){
    System.out.println("No such course! Try again.");
    return null;
  }
  return map.get(name);
}

/**
  * To find and display the best course to take based on its recommendation score.
  * This method uses a PriorityQueue to pick one of the courses provided in the list courses.
  * @param courses the list of the courses from which to pick one
  * Time Complexity: O(n)
  */
public void findBest(List<Course> courses){
   pq.clear();           //clearing the priority queue before use to make sure it starts empty
   for (Course c : courses){
     pq.add(c);
   }
   System.out.println("Best course to take: " + pq.peek().description() );
}

/**
  * To display all course names and their recommendation scores sorted by the scores.
  * Time Complexity: O(n)
  */
public void displayStats(){
  pq.clear();     //clearing the priority queue before use to make sure it starts empty
  for (Course c : map.values()){
    pq.add(c);
  }
  while(!pq.isEmpty()){
    Course c = pq.poll();
    System.out.println(c.toString());
  }
}

/**
  * To display all courses and their descriptions provided by description().
  * Time Complexity: O(n)
  */
public void displayAll(){
  for (Course c : map.values()){
    System.out.println(c.description());
  }
}
}
