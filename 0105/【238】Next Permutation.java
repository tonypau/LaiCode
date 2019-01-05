/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.  
*/

public class Solution {
  public int[] nextPermutation(int[] num) {
    if (num == null || num.length < 2) return num;
    int i = num.length - 2;
    // loop from right to left, find the first element that smaller than the element next
    while (i >= 0 && num[i] >= num[i + 1]) {
      i--;
    }
    if (i < 0) {
      reverse(num, 0, num.length - 1);
      return num;
    }
    
    // loop from right to left, find the first element that larger than the pivot element found before
    int j = num.length - 1;
    while (j > i && num[j] <= num[i]) {
      j--;
    }
    
    swap(num, i, j);
    // reverse element after pivot cuz these elements are decreasing, so directly reverse
    reverse(num, i + 1, num.length - 1);
    return num;
  }
  
  private void reverse(int[] nums, int left, int right){
    while(left<right){
      int temp = nums[left];
      nums[left]=nums[right];
      nums[right]=temp;
      left++;
      right--;
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}
