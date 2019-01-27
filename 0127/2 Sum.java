public class Solution {
  public boolean existSum(int[] array, int target) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      if (set.contains(target - array[i])) return true;
      set.add(array[i]);
    }
    return 
  }
}

/*
assumptions:
1) sorted/not sorted
2) return what? boolean or index or value?
3) all solutions?
4) optimized for space or time?
5) data size? what if the data cannot fit in memory
6) duplicate or no duplicate
*/
