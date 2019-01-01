/*
  Description
Given an integer array, determine how many pairs of elements, the absolute value of the difference between the two elements is the given target value.

Assumptions:

There could be elements with duplicate value in the array, and each of the elements is considered different.
The given array is not null and has length >= 2.
Examples:

array = {3, 1, 2, 1}, target = 2, there are 2 pairs { (3, 1), (3, 1) }
*/

/*
  two pointers. easy to understand
 
0 1 1 2 3 4
i 
      j

*/
public class Solution {
  public int pairs(int[] array, int target) {
    Arrays.sort(array);
    int i = array.length - 1;
    int j = i - 1;
    int res = 0;
    while (i >= 0 && j >= 0) {
      if (i != j && array[i] - array[j] == target) {
        res++;
        j--;
      } else if (array[i] - array[j] < target) {
        j--; 
      } else {
        i--;
      }
    }
    return res;
  }
}
