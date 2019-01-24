public class Solution {
  public void shuffle(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int num = (int)(Math.random() * (array.length - i));
      if (num != 0) {
        swap(array, i, num + i);
      }
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
