import java.io.*;
import java.util.*;
/**
 * Tester class for the course statistics.
 * @author Yves Semana Gisubizo
 @ @version 1.0
 */

public class CourseStatisticsTester{

  public static void main(String args[]){
    List <Course> courses = new ArrayList<>();
    CourseStatistics stats = new CourseStatistics();


    if(args.length != 1) {
      System.out.println("Error: You need to provide a file name."); System.exit(1);
    }
    try {
      FileReader inFile = new FileReader(args[0]);
      BufferedReader in = new BufferedReader(inFile);
      String line = in.readLine();
        while(line != null){
            String name = line;
            line = in.readLine();
            String title = line;
            line = in.readLine();
            int students = Integer.parseInt(line);
            line = in.readLine();
            int votes = Integer.parseInt(line);
            line = in.readLine();
          stats.addCourse(new Course(name, title, students, votes));
        }

    } catch(FileNotFoundException e) {
      System.out.println("Error: File " + args[0] + " not found.");
      System.exit(1);
    } catch(IOException e) {
      System.out.println(e);
      System.exit(1); }

    System.out.println("*** Displaying courses and their full descriptions...");
    System.out.println("Displaying " + stats.getTotal() + " courses.");
    stats.displayAll();
    System.out.println();

    System.out.println("*** Displaying courses sorted by their recommendation rates...");
    stats.displayStats();
    System.out.println();

    Scanner sc =  new Scanner(System.in);

    System.out.println("*** Looking up courses...");
    String search = "";
    do {
      System.out.print("Enter a course ID to look up statistics. Enter ’s’ to stop.\nCourse ID: ");
      search = sc.nextLine().toUpperCase();
      if(search.equals("S")) break;  //to not print "No such course!Try again." at termination
      if (stats.getCourse(search) == null) continue; //to not print null
      else
        System.out.println(stats.getCourse(search).description());
    } while(!search.equals("S"));
    System.out.println();

    System.out.println("*** Comparing courses...");
    String compareCourse = "";
    System.out.println("Enter course IDs to compare. Enter ’s’ to stop.");
    do {
      System.out.print("Course ID: ");
      compareCourse = sc.nextLine().toUpperCase();
      if(compareCourse.equals("S")) break;  //to not print "No such course!Try again." at termination
      if (stats.getCourse(compareCourse) == null) continue; //to not print null
      else
          courses.add(stats.getCourse(compareCourse));
    } while(!compareCourse.equals("S"));
    stats.findBest(courses);

  }

}
