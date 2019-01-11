/*
[394]
Given an integer array, what is the minimum number of operations to convert it to an ascending array.

One operation you can move one element of the array to another position.

Examples:

{1, 3, 2, 4}, the least moves needed is 1, move 2 to the middle of 1 and 3.
*/

// after some try, i find this problem is to find the longest ascending sequence 
public class Solution {
  public int leastMoves(int[] array) {
    if (array == null || array.length == 0) return 0;
    return array.length - helper(array);
  }
  
  // find the longest ascending sequence
  // O(n^2). to be optimized to O(nlogn)
  private int helper(int[] array) {
    int[] inc = new int[array.length];
    int max = 0;
    for (int i = 0; i < inc.length; i++) {
      inc[i] = 1;
    }
    for (int i = 1; i < inc.length; i++) {
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j]) {
          inc[i] = Math.max(inc[i], inc[j] + 1);
        }
        max = Math.max(max, inc[i]);
      }
    }
    return max;
  }
}

