/*
Given an array with integers, determine whether the array contains a valid postorder traversal sequence a BST.

Assumptions:

The given postorder traversal array is not null.
Examples:

{ 3, 5, 4 }  is valid
{ 3,  6,  2,  5,  4} is not valid
*/

// O(nlogn)
// worst case, O(n^2)...when the inpupt array is consistently increasing.
public class Solution {
  public boolean validPostOrder(int[] post) {
    if (post == null && post.length == 0) return true;
    // three parameters: array, start index, end index.
    // check if this subarray is valid
    return helper(post, 0, post.length - 1);
  }
  
  private boolean helper(int[] post, int s, int e) {
    if (e <= s) return true;
    int i = e - 1;
    // start from the end, loop until find an element smaller than the last one
    while (i >= s && post[i] > post[e]) {
      i--;
    }
    int temp = i;
    i--;
    // if valid, all of the former elements before the temp should be smaller than the last one
    while (i >= s && post[i] < post[e]) {
      i--;
    }
    if (i >= s) return false;  // if a larger one found, return false
    // recursion
    else return helper(post, s, temp) && helper(post, temp + 1, e - 1);
  }
}
