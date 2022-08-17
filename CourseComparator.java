
import java.io.*;
import java.util.*;
/**
 * Comparator based on the compareTo method of a Comparable element type.
 * @author Yves Semana Gisubizo
 * @version 1.0
 */

public class CourseComparator implements Comparator<Course> {

  /**
   * Compares two course scores.
   * @param Course a, Course b the courses to be compared
   * @return a negative integer if b is less than a,
   * zero if b equals a, or a positive integer if
   * b is greater than a
   * @throws ClassCastException if the course is of an inappropriate type
   * Time Complexity: O(1)
   */

  @SuppressWarnings({"unchecked"})
  public int compare(Course a, Course b) throws ClassCastException {
    return  Double.valueOf(b.getScore()).compareTo(Double.valueOf(a.getScore()));
  }

}
