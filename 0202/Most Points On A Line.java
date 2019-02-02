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
  public int most(Point[] points) {
    int res = 0;
    for (int i = 0; i < points.length; i++) {
      Point p1 = points[i];
      // Note we need to record the count of same points
      int same = 1;
      int most = 0;
      // Note new a hashtable in each loop
      // we cannot record Pair of k, b
      // because when retrieving pair in map, even k and b are the same, what recorded in map are different objects.
      Map<Double, Integer> map = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        Point p2 = points[j];
        if (p1.x == p2.x && p1.y == p2.y) {
          same++;
          continue;
        }
        double slope = getSlope(p1, p2);
        if (!map.containsKey(slope)) {
          map.put(slope, 1);
        } else {
          map.put(slope, map.get(slope) + 1);
        }
        most = Math.max(most, map.get(slope));
      }
      most = most + same;
      // after looping for each seed point, update result.
      res = Math.max(res, most);
    }
    return res;
  }

  private double getSlope(Point p1, Point p2) {
    // Note when the line is vertical
    if (p1.x == p2.x) return Double.MAX_VALUE;
    return (p2.y - p1.y + 0.0) / (p2.x - p1.x);
  }
}

