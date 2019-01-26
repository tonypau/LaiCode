public class Solution {
  public int[] dedup(int[] array) {
    if (array.length <= 1) return array;
    int slow = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] != array[slow]) {
        array[++slow] = array[i];
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}

