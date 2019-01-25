// Time complexity: O(n)
// bucket sort
public class Solution {
  public int percentile95(List<Integer> lengths) {
    int[] bucket = new int[4097];
    for (int i : lengths) bucket[i]++;
    int sum = 0;
    for (int i = bucket.length - 1; i >= 1; i--) {
      sum += bucket[i];
      if (sum > 0.05 * lengths.size()) {
        return i;
      }
    }
    return;
  }
}
