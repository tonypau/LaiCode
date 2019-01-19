// [274]
public class Solution {
  public List<List<Integer>> factors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> factors = getFactors(n);
    List<Integer> cur = new ArrayList<>();
    helper(res, cur, factors, 0, 1, n);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, List<Integer> factors, int index, int cur, int target) {
    if (cur == target) {
      res.add(new ArrayList<Integer>(list));
      return;
    }
    for (int i = index; i < factors.size(); i++) {
      if (cur * factors.get(i) > target) {
        return;
      }
      list.add(factors.get(i));
      helper(res, list, factors, i, cur * factors.get(i), target);
      list.remove(list.size() - 1);
    }
  }
  
  private List<Integer> getFactors(int n) {
    List<Integer> res = new ArrayList<>();
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        res.add(i);
      }
    }
    res.add(n);
    return res;
  }
}

