// m[i][j]: the longest common substring between a[0..i-1] and b[0..j-1] that includes a[i-1] and b[j-1]
// m[i][j] = m[i-1][j-1] + 1 when a[i-1] == b[j-1], otherwise 0

// tc: O(n^2)
// sc: O(n^2)
public class Solution {
  public String longestCommon(String source, String target) {
    int[][] m = new int[source.length() + 1][target.length() + 1];
    String res = "";
    int max = 0;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (i == 0 || j == 0) {
          m[i][j] = 0;
        } else if (source.charAt(i - 1) == target.charAt(j - 1)) {
          m[i][j] = m[i - 1][j - 1] + 1;
        }
        if (m[i][j] > max) {
          max = m[i][j];
          res = source.substring(i - max, i);
        }
      }
    }
    return res;
  }
}
