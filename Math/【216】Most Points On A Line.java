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
// O(n^2)
// O(n^2)
public class Solution {
  public int most(Point[] points) {
    int res = 0;  
    for (int i = 0; i < points.length; i++) {
      Point p1 = points[i];
      int same = 1;  // record the count of points has the same <x,y>
      int most = 0;  // record the maximum number of points that on the same line crossing p1 (seed point)

      // store all possible slopes
      Map<Double, Integer> map = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        Point p2 = points[j];
        if (p1.x == p2.x && p1.y == p2.y) {
          same++;
          continue;
        }
        double slope = getSlope(p1, p2);
        Integer count = map.get(slope);
        if (count == null) {
          map.put(slope, 1);
        } else {
          map.put(slope, count + 1);
        }
        most = Math.max(most, map.get(slope));
      }
      most = most + same;
      res = Math.max(res, most);
    }
    return res;
  }
  
  private double getSlope(Point p1, Point p2) {
    if (p1.x == p2.x) return Double.MAX_VALUE;
    return (p2.y - p1.y) * 1.0 / (p2.x - p1.x);
  }
}
