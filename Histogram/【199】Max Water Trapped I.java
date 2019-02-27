// we maintain two variables left and right recording current highest number in left and right.
// we move the lower of them once in one loop

//tc:O(n)
//sc: O(1)
public class Solution {
  public int maxTrapped(int[] array) {
    if (array.length <= 2) return 0; 
    int i = 0;
    int j = array.length - 1;
    int left = array[i];
    int right = array[j];
    int sum = 0;
    while (i < j) {
      if (left < right) {
        i++;
        left = Math.max(left, array[i]);
        sum += left - array[i];
      } else {
        j--;
        right = Math.max(right, array[j]);
        sum += right - array[j];
      }
    }
    return sum;
  }
}
