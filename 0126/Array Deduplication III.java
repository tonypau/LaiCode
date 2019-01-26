public class Solution {
  public int[] dedup(int[] array) {
    if (array.length <= 1) return array;
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
    // NOTICE: slow < 0 do not forget
    // when the first element is duplicate, slow will < 0, then in next loop, array[slow] will out of bound
      if (slow < 0 || array[fast] != array[slow]) {
        array[++slow] = array[fast++];
      } else {
        while (fast < array.length && array[fast] == array[slow]) {
          fast++;
        }
        slow--;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}


