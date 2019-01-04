/*
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
  public int romanToInt(String input) {
    if (input == null || input.length() == 0) return -1;
    Map<Character, Integer> map = getMap();
    if (input.length() == 1) return map.get(input.charAt(0));
    int res = 0;
    int i = input.length() - 1;
    int j = i - 1;
    while (j >= 0) {
      char c1 = input.charAt(i);
      char c2 = input.charAt(j);
      if (c1 == c2 || map.get(c1) < map.get(c2)) {
        res = res + map.get(c1) + map.get(c2);
      } else {
        res = res + map.get(c1) - map.get(c2);
      }
      i -= 2;
      j -= 2;
    }
    if (i >= 0) return res + map.get(input.charAt(i));
    else return res;
  }
  
  private Map<Character, Integer> getMap() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    return map;
    
  }
}

/*
[M,D,C,L,X,V,I]

 MMXCIX
i
 j
3999
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
*/
