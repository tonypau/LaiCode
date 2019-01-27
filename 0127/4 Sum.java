// i1 < j1 < i2 < j2
public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    // 之所以两个for-loop的顺序如此，是因为要保证存进map的pairSum的j1是第一次出现的。
    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; j++) {
        int pairSum = array[i] + array[j];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < i) {
          return true;
        }
        if (!map.containsKey(pairSum)) {
          map.put(pairSum, new Pair(i, j));
        }
      }
    }
    return false;
  }
  
  static class Pair {
    int left;
    int right;
    Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
}
