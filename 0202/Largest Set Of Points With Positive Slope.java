/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int largest(Point[] points) {
    // Write your solution here.
    Arrays.sort(points, new MyComparator());
    int[] arr = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      arr[i] = points[i].y;
    } 
    return findLongestAscendingSubsequence(arr);
  }
  
  public class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
      if (p1.x < p2.x) {
        return -1;
      } else if (p1.x > p2.x) {
        return 1;
      }
      return 0;
    }
  }
  
  private int findLongestAscendingSubsequence(int[] array) {
    if (array == null || array.length == 0) return 0;
    int[] refine = new int[array.length + 1];
    refine[1] = array[0];
    int rightMost = 1;
    for (int i = 1; i < array.length; i++) {
      int index = helper(refine, 1, rightMost, array[i]);
      if (index == rightMost) refine[++rightMost] = array[i];
      else refine[index + 1] = array[i]; 
    }
    return rightMost == 1 ? 0 : rightMost;
  }
  
  private int helper(int[] refine, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (refine[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}

