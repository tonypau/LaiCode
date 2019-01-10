/*
[308]
Insert the least number of characters to a string in order to make the new string a palindrome. 
Return the least number of characters should be inserted.

Assumptions:

The given string is not null.
*/


// c[i][j] means the least insertions to form a palindrome with S[i...j]
// c[i][j] = c[i + 1][j - 1]                  if s[i] == s[j]
             min(c[i + 1][j], c[i][j - 1])    if s[i] != s[j] 
public class Solution {
  public int leastInsertion(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }  
    int len = input.length();
    int[][] m = new int[len][len];
    // NOTICE: we fill in the table in diagonal direction
    // first loop : c[0][1], c[1][2], c[2][3]...
    // second loop: c[0][2], c[1][3]....
    // third loop: c[0][3]...
    for (int k = 1; k < len; k++) {
      for (int i = 0, j = k; j < len; i++, j++) {
        if (input.charAt(i) == input.charAt(j)) {
          m[i][j] = m[i + 1][j - 1];
        } else {
          m[i][j] = Math.min(m[i + 1][j], m[i][j - 1]) + 1;
        }
      }
    }
    return m[0][input.length() - 1];
  }
}

