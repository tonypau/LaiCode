public class Solution {
  public int[] dedup(int[] array) {
    if (array.length <= 2) return array;
    int slow = 1;
    for (int i = 2; i < array.length; i++) {
      if (array[i] != array[slow - 1]) {
        array[++slow] = array[i];
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
