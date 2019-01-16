// the good use of map and match variable (match: the number of matched letter)
public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    List<Integer> res = new ArrayList<>();
    if (lo.length() == 0 || sh.length() > lo.length()) return res;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < sh.length(); i++) {
      Integer num = map.get(sh.charAt(i));
      if (num == null) {
        map.put(sh.charAt(i), 1);
      } else {
        map.put(sh.charAt(i), num + 1);
      }
    }
    int match = 0;
    for (int i = 0; i < lo.length(); i++) {
      char rightmost = lo.charAt(i);
      Integer num = map.get(rightmost);
      if (num != null) {
        if (num == 1) {
          match++;
        }
        map.put(rightmost, num - 1);
      }
      if (i >= sh.length()) {
        char leftmost = lo.charAt(i - sh.length());
        Integer n = map.get(leftmost);
        if (n != null) {
          if (n == 0) {
            match--;
          } 
          map.put(leftmost, n + 1);
        }
      }
      if (map.size() == match) {
        res.add(i - sh.length() + 1);
      }
    }
    return res;
  }
}

