public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // corner case 以防下面两函数进不去for loop导致结果出现最值
    if (array.length == 1) return new int[]{array[0], array[0]};
    for (int i = 0; i < array.length / 2; i++) {
      if (array[i] > array[array.length - i - 1]) {
        swap(array, i, array.length - i - 1);
      }
    }
    // NOTICE 边界取值。中间的element两个函数都要带上比较
    return new int[]{largest(array, array.length / 2, array.length - 1), smallest(array, 0, array.length / 2)};
  }
  
  private int smallest(int[] array, int l, int r) {
    int res = Integer.MAX_VALUE;
    for (int i = l; i <= r; i++) {
      res = Math.min(res, array[i]);
    }
    return res;
  }
  
  private int largest(int[] array, int l, int r) {
    int res = Integer.MIN_VALUE;
    for (int i = l; i <= r; i++) {
      res = Math.max(res, array[i]);
    }
    return res;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

