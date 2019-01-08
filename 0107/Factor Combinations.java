/*
【404】
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
*/

public class Solution {
  public List<List<Integer>> combinations(int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (target <= 1) return res;
    List<Integer> list = new ArrayList<>();
    List<Integer> factors = getFactors(target);
    helper(res, list, factors, 0, 1, target);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, List<Integer> factors, int index, int cur, int target) {
    if (target == cur) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < factors.size(); i++) {
      if (target < cur * factors.get(i)) {
        return;
      }
      list.add(factors.get(i));
      helper(res, list, factors, i, cur * factors.get(i), target);
      list.remove(list.size() - 1);
    }    
  }
  
  private List<Integer> getFactors(int target) {
    List<Integer> res = new ArrayList<>();
    for (int i = 2; i <= target / 2; i++) {
      if (target % i == 0) {
        res.add(i);
      }
    }
    return res;
  }
}

