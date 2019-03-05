// HashSet: record every ele appeared in input array
// for each ele in input, loop check if ele-1 and ele+1 are in set, if so, count++ and remove it from set avoid O(n^2)

// tc: O(n)
// sc: O(n)
public class Solution {
  public int longestConsecutive(int[] array) {
    if (array == null || array.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    int max = 1;
    for (int i : array) set.add(i);
    for (int i : array) {
      int left = i - 1;
      int right = i + 1;
      int count = 1;
      while (set.contains(left)) {
        count++;
        set.remove(left);
        left--;
      }
      while (set.contains(right)) {
        count++;
        set.remove(right);
        right++;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
