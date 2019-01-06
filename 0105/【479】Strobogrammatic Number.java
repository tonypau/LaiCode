/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
  private static Map<Character, Character> map = createMap();
  private static Map<Character, Character> createMap() {
    Map<Character, Character> map = new HashMap<>();
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');
    map.put('6', '9');
    map.put('9', '6');
    return map;
  }
  
  public boolean isStrobogrammatic(String num) {
    int i = 0;
    int j = num.length() - 1;
    while (i <= j) {
      char c1 = num.charAt(i);
      char c2 = num.charAt(j);
      if (!map.containsKey(c1)) {
        return false;
      } else if (map.get(c1) != c2){
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }
}

