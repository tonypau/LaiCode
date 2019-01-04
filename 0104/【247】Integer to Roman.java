/*
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    Map<Integer, Character> map = getMap();
    int counter = 1000;
    while (num > 0) {
      int n = num / counter;
      if (n > 0 && n < 4) {
        while (n > 0 && n < 4) {
          n--;
          sb.append(map.get(counter));
        }
      } else if (n == 4) {
        sb.append(map.get(counter));
        sb.append(map.get(counter * 5));
      } else if (n >= 5 && n < 9) {
        sb.append(map.get(counter * 5));
        n--;
        while (n >= 5 && n < 9) {
          n--;
          sb.append(map.get(counter));
        }
      } else if (n == 9) {
        sb.append(map.get(counter));
        sb.append(map.get(counter * 10));
      }
      num = num % counter;
      counter /= 10;
    }
    return sb.toString();
  }
  
  private Map<Integer, Character> getMap() {
    Map<Integer, Character> map = new HashMap<>();
    map.put(1, 'I');
    map.put(5, 'V');
    map.put(10, 'X');
    map.put(50, 'L');
    map.put(100, 'C');
    map.put(500, 'D');
    map.put(1000, 'M');
    return map;
  }
}
/*
99

MMMCM
*/
