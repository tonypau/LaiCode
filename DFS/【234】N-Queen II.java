// O(1) time in validate positions with another three array recording used position 
public class Solution {
  public int totalNQueens(int n) {
    if (n <= 0) return 0;
    int[] count = new int[1];
    int[] helper = new int[n];
    boolean[] usedColumns = new boolean[n];
    boolean[] usedDiagonals = new boolean[2 * n + 1];
    boolean[] usedRevDiagonals = new boolean[2 * n + 1];
    dfs(helper, count, usedColumns, usedDiagonals, usedRevDiagonals, 0, n);
    return count[0];
  }
  
  private void dfs(int[] helper, int[] count, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals, int level, int n) {
    if (level == n) {
      count[0]++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (isValid(n, level, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
        mark(usedColumns, usedDiagonals, usedRevDiagonals, level, i, n);
        helper[level] = i;
        dfs(helper, count, usedColumns, usedDiagonals, usedRevDiagonals, level + 1, n);
        unMark(usedColumns, usedDiagonals, usedRevDiagonals, level, i, n);
      }
    }
  }
  
  private boolean isValid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
    return !usedColumns[column] && !usedDiagonals[row + column] && !usedRevDiagonals[row - column + n - 1];
  }
  
  private void mark(boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals, int row, int column, int n) {
    usedColumns[column] = true;
    usedDiagonals[row + column] = true;
    usedRevDiagonals[row - column + n - 1] = true;
  }
  
  private void unMark(boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals, int row, int column, int n) {
    usedColumns[column] = false;
    usedDiagonals[row + column] = false;
    usedRevDiagonals[row - column + n - 1] = false;
  }
}

