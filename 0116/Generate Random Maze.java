// we can also use a enum class which contains four base direction (1, 0),(-1,0), (0,1), (0,-1) and times steps
// that code looks so beatiuful
public class Solution {
  static class Cell {
    int row;
    int col;
    Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public int[][] maze(int n) {
    if (n == 1) {
      int[][] res = new int[1][1];
      res[0][0] = 0;
      return res;
    }
    int[][] maze = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maze[i][j] = 1;
      }
    }
    maze[0][0] = 0;
    int targetNumberOfOne = (n + 1) / 2 * (n + 1) / 2 - 1;
    helper(maze, targetNumberOfOne, 0, 0, 0);
    return maze;
  }

  private void helper(int[][] maze, int target, int row, int col, int curNum) {
    if (curNum == target) {
      return;
    }
    Cell[] available = getAvailable(maze, row, col);
    shuffle(available);  // shuffle first, then for loop which is genius
    // i used two repeated parts of code at first which is bad
    for (Cell next : available) {
      if (maze[next.row][next.col] != 1) {
        return;
      }
      maze[next.row][next.col] = 0;
      if (row == next.row) {
        if (col < next.col) maze[row][col + 1] = 0;
        else maze[row][col - 1] = 0;
      }
      if (col == next.col) {
        if (row < next.row) maze[row + 1][col] = 0;
        else maze[row - 1][col] = 0;
      }
      helper(maze, target, next.row, next.col, curNum + 1);
    }
  } 

  private void shuffle(Cell[] dirs) {
    for (int i = 0; i < dirs.length; i++) {
      int index = (int) (Math.random() * (dirs.length - i));
      Cell tmp = dirs[i];
      dirs[i] = dirs[i + index];
      dirs[i + index] = tmp;
    }
  }
  
  // here we got hardcode
  private Cell[] getAvailable(int[][] maze, int row, int col) {
    List<Cell> list = new ArrayList<>();
    int n = maze.length;
    if (row + 2 < n && maze[row + 2][col] == 1) 
      list.add(new Cell(row + 2, col));
    if (row - 2 >= 0 && maze[row - 2][col] == 1) 
      list.add(new Cell(row - 2, col));
    if (col + 2 < n && maze[row][col + 2] == 1) 
      list.add(new Cell(row, col + 2));
    if (col - 2 >= 0 && maze[row][col - 2] == 1) 
      list.add(new Cell(row, col - 2));
    Cell[] res = new Cell[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
