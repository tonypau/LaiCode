/*
【500】
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
*/

public class Solution {
  public List<String> generatePalindromes(String input) {
    List<String> res = new ArrayList<>();
    if (input == null || input.length() == 0) return res;
    int[] map = new int[95];
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (map[c - '!'] % 2 == 0) count++;
      else count--;
      map[c - '!']++;
    }
    // when there are more than one element with odd count. then we cannot form a palindrome.
    if (count > 1) return res;    
    char singleOne = ' ';
    // find the only one element with odd count
    for (int i = 0; i < map.length; i++) {
      if (map[i] % 2 == 1) {
        singleOne = (char)('!' + i);
        map[i]--;
        break;
      } 
    }

    if (singleOne != ' ') {
      // if there is only one element with odd count
      String single = "";
      single += singleOne;
      helper(res, single, map, 0, input.length());
    } else {
      // no elements with odd count
      String string = "";
      helper(res, string, map, 0, input.length());
    }
    return res;
  }
  
  private void helper(List<String> res, String s, int[] map, int index, int length) {
    if (s.length() == length) {
      res.add(new String(s));
      return;
    }
    for (int i = 0; i < map.length; i++) {
      if (map[i] != 0) {
        char cur = (char)('!' + i);
        map[i] -= 2;
        // add from the center
        helper(res, cur + s + cur, map, i, length);
        map[i] += 2;
      }
    }
  }
}
