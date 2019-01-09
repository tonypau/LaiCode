/*
[309]
Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order, then sorted in a descending order. How can you find the length of the longest bitonic subsequence.

Assumptions:

The given array is not null.
Corner Cases:

A subsequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
Examples:

{1, 3, 2, 1, 4, 6, 1}, the longest bitonic sub sequence is {1, 3, 4, 6, 1}, length is 5.
*/
public class Solution {
  public int longestBitonic(int[] array) {
    if (array == null || array.length == 0) return 0;
    int n = array.length;
    int[] inc = new int[n];
    int[] dec = new int[n];
    for (int i = 0; i < inc.length; i++) {
      inc[i] = 1;
      dec[i] = 1;
    }
    for (int i = 1; i < inc.length; i++) {
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j]) {
          inc[i] = Math.max(inc[i], inc[j] + 1);
        }
      }
    }
    for (int i = dec.length - 2; i >= 0; i--) {
      for (int j = dec.length - 1; j > i; j--) {
        if (array[i] > array[j]) {
          dec[i] = Math.max(dec[i], dec[j] + 1);
        }
      }
    }
    int res = 0;
    for (int i = 0; i < array.length; i++) {
      res = Math.max(inc[i] + dec[i] - 1, res);
    }
    return res;
  }
}

