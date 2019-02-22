// each level represents the matched char letter, the level count is word length
// for each node, we have four branches which represents four directions
// also, we need a boolean array to de-duplication

// time: O(4^(len^2)))
// space: O(n^2)
public class Solution {
  static final int[] row = {-1, 0, 1, 0};
  static final int[] col = {0, -1, 0, 1};
  public boolean isWord(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0) return false;
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if ((word.charAt(0) == board[i][j]) && search(word, visited, board, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean search(String word, boolean[][] visited, char[][] board, int i, int j, int index) {
    if (index == word.length()) {
      return true;  
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
      return false;
    }
    visited[i][j] = true;
    boolean canNext = false;
    for (int k = 0; k < 4; k++) {
      canNext = canNext || search(word, visited, board, i + row[k], j + col[k], index + 1);
    }
    if (canNext) return true;
    visited[i][j] = false;
    return false;
  }
}

