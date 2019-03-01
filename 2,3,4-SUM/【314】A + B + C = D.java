// tc O(n^2)
// sc O(n)
public class Solution {
  public boolean exist(int[] array) {
    Arrays.sort(array);
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        int pairSum = array[i] + array[j];
        if (!map.containsKey(pairSum)) {
          map.put(pairSum, new Pair(j, i));
        }
      }
    }
    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (map.containsKey(array[i] - array[j]) && map.get(array[i] - array[j]).second < j) {
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
