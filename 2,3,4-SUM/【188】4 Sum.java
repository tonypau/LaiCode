// Method 1: O(n^2)
// i1 < j1 < i2 < j2 
public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int j1 = 0; j1 < array.length; j1++) {
      for (int i1 = 0; i1 < j1; i1++) {
        int pairSum = array[i1] + array[j1];
        if (!map.containsKey(pairSum)) {
          map.put(pairSum, new Pair(i1, j1));
        }
      }
    }
    for (int i2 = 0; i2 < array.length; i2++) {
      for (int j2 = i2 + 1; j2 < array.length; j2++) {
        int pairSum = array[i2] + array[j2];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).second < i2) {
          return true;
        }
      }
    }
    return false;
  }
  
  static class Pair {
    int first;
    int second;
    
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}

// Method2: O(n^2) fused into one loop
public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; i++) {
        int pairSum = array[i] + array[j];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).second < i) {
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
    int first;
    int second;
    
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
