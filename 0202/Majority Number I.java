// t:O(n)
// s:O(1)
// 打擂台，黑帮火并法
public class Solution {
  public int majority(int[] array) {
    int count = 1;
    int candidate = array[0];
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        candidate = array[i];
        count++;
      } else if (array[i] != candidate) {
        count--;
      } else {
        count++;
      }
    }
    return candidate;
  }
}
