/**
 * class Interval {
 *   public int start;
 *   public int end;
 *   public Interval(int start, int end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

// 先sort，再遍历
class Solution {
  public int length(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) return 0;
    int res = 0;
    intervals.sort(new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        if (i1.start == i2.start) return 0;
        return i1.start < i2.start ? -1 : 1;
      }
    });
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    for (Interval interval : intervals) {
      if (interval.start <= end) {
        end = Math.max(end, interval.end);
      } else {
        res += end - start;
        start = interval.start;
        end = interval.end;
      }
    }
    return res + end - start;
  }
}

// merge sort
