/*
【499】
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

*/

public class Solution {
  public boolean canPermutePalindrome(String input) {
    if (input == null) return true;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
    }
    if (set.size() > 1) {
      return false;
    }
    return true;
  }
}

