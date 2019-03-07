// tc: O(mlogm + m)
// sc: O(m)
// 特征值法

// 特征值是：一共同时存在多少个interval
// start point对特征值的影响：+1
// end point对特征值的影响：-1

public class Solution {
  public int minMeetingRooms(int[][] intervals) { // m * 2
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];
    int j = 0;
    // O(m*2)
    for (int[] interval : intervals) {
      start[j] = interval[0];
      end[j] = interval[1];
      j++;
    }
    Arrays.sort(start);// O(mlogm)
    Arrays.sort(end);
    int rooms = 0;
    int endsItr = 0;
    for (int i = 0; i < start.length; i++) {
      if (start[i] < end[endsItr]) {
        rooms++;
      } else {
        endsItr++;
      }
    }
    return rooms;
  }
}

