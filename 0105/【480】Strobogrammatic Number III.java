/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.
*/

public class Solution {
  public int strobogrammaticInRange(String low, String high) {
    int[] res = new int[1];
    find(low, high, "", res);
    find(low, high, "0", res);
    find(low, high, "1", res);
    find(low, high, "8", res);
    return res[0];
  }
  
  private void find(String low, String high, String path, int[] res) {
    if (path.length() >= low.length() && path.length() <= high.length()) {
      if (path.length() == high.length() && Long.valueOf(path) > Long.valueOf(high)) {
        return;
      }
      if (!(path.length() > 1 && path.charAt(0) == '0') 
        && !(path.length() == low.length() && Long.valueOf(path) < Long.valueOf(low))) {
        res[0]++;
      }   
    }
    if (path.length() + 2 > high.length()) return;
    find(low, high, "0" + path + "0", res);
    find(low, high, "1" + path + "1", res);
    find(low, high, "8" + path + "8", res);
    find(low, high, "6" + path + "9", res);
    find(low, high, "9" + path + "6", res); 
  }
}
