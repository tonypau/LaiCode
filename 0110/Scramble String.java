/*
[150]
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

            great

             /    \

           gr    eat

          / \      /  \

         g   r  e   at

                      / \

                    a   t

To scramble the string, we may choose any non-leaf node and swap its two children. For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".    

                  rgeat

                   /    \

                rg    eat

               / \      /  \

             r   g   e   at

                     / \

                   a   t

  We say that "rgeat" is a scrambled string of "great". Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

              rgtae

              /    \

            rg    tae

           / \    /  \

          r   g  ta  e

                  / \

                 t   a

We say that "rgtae" is a scrambled string of "great". Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

// 3d dp
// res[i][j][len] means if the two substrings of len which start from index i of s1 and index j of s2 respectively are scrambled.
public class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }  
    if (s1.length() == 0) {
      return true;
    }
    boolean[][][] res = new boolean[s1.length()][s1.length()][s1.length() + 1];
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        res[i][j][1] = s1.charAt(i) == s2.charAt(j);
      }
    }
    for (int len = 2; len <= s1.length(); len++) {
      for (int i = 0; i < s1.length() - len + 1; i++) {
        for (int j = 0; j < s2.length() - len + 1; j++) {
          for (int k = 1; k < len; k++) {
            // there are two ways that whese two substrings are scrambled.
            // 1) s1[i...i+k-1] is scrambled with s2[j...j+k-1] and s1[k..len-1] is scrambled with s2[k][len-1]
            // 2) s1[i...i+k-1] is scrambled with s2[j+len-k... len-1] and s1[k...len-1] is scrambled with s2[j..j+k-1]
            
            // simplified explanation:
            //    xxxxxxxyyyy is scrambled with xxxxxxxyyyy.  x and y are wildcard
            // or xxxxxxxyyyy is scrambled with yyyyxxxxxxx.
            res[i][j][len] |= (res[i][j][k] && res[i + k][j + k][len - k]) || (res[i][j + len - k][k] && res[i + k][j][len - k]);  
          }
        }
      }
    }
    return res[0][0][s1.length()];
  }
}

