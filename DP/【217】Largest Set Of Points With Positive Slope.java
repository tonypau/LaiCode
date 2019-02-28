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

// tc: O(n^2) can be optimized to O(nlogn) with binary search method 
// sc: O(n)
public class Solution {
  public int largest(Point[] points) {
    // corner case
    if (points.length <= 1) return 0;
    // sort to make x is in ascending order
    Arrays.sort(points, new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
        if (p1.y < p2.y) {
          return -1;
        } else if (p1.y > p2.y) {
          return 1;
        } else if (p1.x < p2.x) {
          return -1;
        } else if (p1.x > p2.x) {
          return 1;
        }
        return 0;
      }
    });
    // find longest ascending subsequence according y
    int max = 0;
    int[] longest = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      longest[i] = 1;
      for (int j = 0; j < i; j++) {
        if (points[j].x < points[i].x && points[j].y < points[i].y) {
          longest[i] = Math.max(longest[i], longest[j] + 1);
        }
      }
      max = Math.max(max, longest[i]);
    }
    return max == 1 ? 0 : max;
  }
}
