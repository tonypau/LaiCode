// tc: O(n^2)
// sc: O(1)
public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(array);  // O(nlogn)
    for (int i = 0; i < array.length; i++) {     // O(n^2)
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        if (array[left] + array[right] + array[i] == target) {
          res.add(Arrays.asList(array[i], array[left], array[right]));
          left++;
          while (left < array.length && array[left] == array[left - 1]) {
            left++;
          }
        } else if (array[left] + array[right] < target - array[i]) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
