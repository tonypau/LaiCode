/*
[146]
Find the number of different Binary Search Trees generated from 1-n.

Example:

Input: 3, Return: 5
*/

// for every number, m[i] = Sum(m[j] * m[i-j-1])
// O(n^2)
public class Solution {
  public int numOfTrees(int n) {
    if (n == 0) {
      return 1;
    }
    int[] m = new int[n + 1];
    m[0] = 1;
    m[1] = 1;
    for (int i = 2; i <= n; i++) {
      int res = 0;
      for (int j = 0; j < i; j++) {
        res += m[j] * m[i - j - 1];
      }
      m[i] = res;
    }
    return m[n];
  }
}

// O(n!)
public class Solution {
  public int numOfTrees(int n) {
    if (n == 0) return 1;
    return helper(1, n);
  }
  
  private int helper(int start, int end) {
    int res = 0;
    if (end < start) {
      return 0;
    }
    if (end == start) {
      return 1;      
    }
    for (int i = start; i <= end; i++) {
      int left = helper(start, i - 1);
      int right = helper(i + 1, end);
      res += left != 0 && right != 0 ? left * right : (left == 0 ? right : left);
    }
    return res;
  }
}

