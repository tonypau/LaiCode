/*
[498]
There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
*/

// same point as 【paint house I】 
// just 3 -> k colors

// costs[i][j] means the min cost ending with j-th color
public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    for (int i = 1; i < costs.length; i++) {
      for (int j = 0; j < costs[0].length; j++) {
        costs[i][j] += min(costs, i - 1, j);
      }
    }
    int m = costs.length;
    return min(costs, costs.length - 1, -1);
  }
    
  public int min(int[][] costs, int row, int col) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < costs[0].length; i++) {
      if (i == col) continue;
      min = Math.min(min, costs[row][i]);
    }
    return min;
  }
}
