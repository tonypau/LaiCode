//要注意corner cases
public class Solution {
  public List<String> findMissingRanges(int[] num, int lower, int upper) {
    List<String> res = new ArrayList<>();
    if (num == null || num.length == 0) {
      res.add(Integer.toString(lower) + "->" + Integer.toString(upper));
      return res;
    }
    if (lower < num[0]) {
      if (lower == num[0] - 1) res.add(Integer.toString(lower));
      else res.add(Integer.toString(lower) + "->" + Integer.toString(num[0] - 1));
    }
    int prev = num[0];
    int i = 1;
    while (i < num.length) {
      int cur = num[i];
      if (prev < cur - 2){
        res.add(Integer.toString(prev + 1) + "->" + Integer.toString(cur - 1));
      } else if (prev == cur - 2) {
        res.add(Integer.toString(cur - 1));
      }
      i++;
      prev = cur;
    }
    if (prev < upper) {
      if (upper == prev + 1) res.add(Integer.toString(upper));
      else res.add(Integer.toString(prev + 1) + "->" + Integer.toString(upper));
    }
    return res;
  }
}

