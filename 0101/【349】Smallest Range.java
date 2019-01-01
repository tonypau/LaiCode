/*
Given k sorted integer arrays, pick k elements (one element from each of sorted arrays), what is the smallest range.

Assumptions:

k >= 2
None of the k arrays is null or empty
Examples:

{ { 1, 4, 6 },

  { 2, 5 },

  { 8, 10, 15} }

pick one element from each of 3 arrays, the smallest range is {5, 8} (pick 6 from the first array, 
          pick 5 from the second array and pick 8 from the third array).
*/

// sol1:
// similar to window minimum substring
public class Solution {
  // custom class, record element value and group
  static class Pair {
    int num;
    int group;
    Pair(int num, int group) {
      this.num = num;
      this.group = group;
    }
  }
  
  public int[] smallestRange(int[][] arrays) {
    List<Pair> list = new ArrayList<>();
    // put all elements into one list
    for (int i = 0; i < arrays.length; i++) {
      for (int j = 0; j < arrays[i].length; j++) {
        list.add(new Pair(arrays[i][j], i));
      }
    }
    // sort with element value
    Collections.sort(list, new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.num == p2.num) return 0;
        return p1.num < p2.num ? -1 : 1;
      }
    });
    // find the minimum difference of the value of left and right bound element
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arrays.length; i++) {
	    map.put(i, 1); 
	  }
    int left = 0;
    int diff = Integer.MAX_VALUE;
    int count = 0;
    int[] res = new int[2];
    for (int i = 0; i < list.size(); i++) {
      if (map.get(list.get(i).group) > 0) {
        count++;
      }
      map.put(list.get(i).group, map.get(list.get(i).group) - 1);
      // move bound
      while (count == arrays.length) {
          // update
	        if (diff > list.get(i).num - list.get(left).num) {
	          diff = list.get(i).num - list.get(left).num;
	          res[0] = list.get(left).num;
	          res[1] = list.get(i).num;
	        }
	        if (left >= list.size()) break;
	        if (map.get(list.get(left).group) + 1 > 0) {
	          count--;
	        }
	        map.put(list.get(left).group, map.get(list.get(left).group) + 1);
	        left++;
	      }
    }
    return res;
  }
}

// sol2:
// heap:
