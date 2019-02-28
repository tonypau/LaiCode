// m[i][j]: the longest common sub-sequence between a[0..i-1] and b[0..j-1] 
// m[i][j] = m[i-1][j-1] + 1 when ==
//         = max(m[i-1][j], m[i][j-1]) when !=
           
// tc: O(mn)
// sc: O(mn)

public class Solution {
  public int longest(String source, String target) {
    int[][] m = new int[source.length() + 1][target.length() + 1];
    for (int i = 1; i < m.length; i++) {
      for (int j = 1; j < m[0].length; j++) {
        if (source.charAt(i - 1) == target.charAt(j - 1)) {
          m[i][j] = m[i - 1][j - 1] + 1;
        } else {
          m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]);
        }
      }
    }
    return m[source.length()][target.length()];
  }
}
