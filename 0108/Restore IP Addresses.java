/*
【147】
Given a string containing only digits, restore it by retiring all possible valid IP address combinations.

Input:  ”25525511135”

Output: [“255.255.11.135”, “255.255.111.35”]
*/


public class Solution {  
  public List<String> Restore(String ip) {
    List<String> res = new ArrayList<>();
    if (ip == null) return res;    
    char[] arr = ip.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(res, arr, sb, 0, 0);
    return res;
  }
	  
  private void helper(List<String> res, char[] arr, StringBuilder sb, int index, int count) {
    if (count == 4) {
      if (sb.length() == arr.length + 3) {
        res.add(sb.toString());
      } 
      return;
    }
    for (int i = index; i < arr.length; i += 3) {
      for (int j = i; j < i + 3 && j < arr.length; j++) {
        if (isValid(arr, i, j)) {
          if (count == 3) {
            sb.append(arr, i, j - i + 1);
          } else {
            sb.append(arr, i, j - i + 1).append('.');
          }
          helper(res, arr, sb, j + 1, count + 1);
          removeLastPart(sb);
        }
      }
    }
  }
	  
  private boolean isValid(char[] arr, int i, int j) {
    if (arr[i] == '0' && j != i) return false;
    Integer num = Integer.valueOf(new String(arr, i, j - i + 1));
    if (num >= 0 && num < 256) return true;
      return false;
  }
	  
  private void removeLastPart(StringBuilder sb) {
    if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
    int i = sb.length() - 1;
    while (i >= 0 && sb.charAt(i) != '.') {
      sb.deleteCharAt(i);
      i--;
    }
  }
}
