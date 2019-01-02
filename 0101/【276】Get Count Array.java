/*
Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].

Assumptions:

The given array A is not null.
Examples:

A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
Requirement:

time complexity = O(nlogn).
*/

public class Solution {
  static class TreeNode {
    int val;
    // count: if val >= root.val, there will be count number of smaller elements on the right
    int count = 1;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
      this.val = val;
    }
  }
  public int[] countArray(int[] array) {
    int[] res = new int[array.length];
    if (array == null || array.length == 0) return res;
    TreeNode root = new TreeNode(array[array.length - 1]);
    res[array.length - 1] = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      int count = insertNode(root, array[i]);
      res[i] = count;
    }
    return res;
  }
  
  private int insertNode(TreeNode root, int val) {
    // thisCount: the number of elements smaller than val
    int thisCount = 0;
    while (true) {
      if (val <= root.val) {
        root.count++;
        if (root.left == null) {
          root.left = new TreeNode(val);
          break;
        } else {
          root = root.left;
        }
      } else {
        // add to the right subtree, outside right subtree, 
        // there are root.count number smaller than val
        thisCount += root.count;
        if (root.right == null) {
          root.right = new TreeNode(val);
          break;
        } else {
          root = root.right;
        }
      }
    }
    return thisCount;
  }
}

