/*
【231】
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. Each number in C may only be used once in the combination.

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order.

The solution set must not contain duplicate combinations.

Example

          given candidate set 10,1,2,7,6,1,5 and target 8,

          A solution set is:

          [1, 7]

          [1, 2, 5]

          [2, 6]

          [1, 1, 6]
*/

public class Solution {
  public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (num == null || num.length == 0) return res;
    List<Integer> list = new ArrayList<>();
    Arrays.sort(num);
    helper(res, list, 0, num, target);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int index, int[] num, int target) {
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    int i = index;
    while (i < num.length) {
      if (target < num[i]) {
        return;
      }
      list.add(num[i]);
      helper(res, list, i + 1, num, target - num[i]);
      list.remove(list.size() - 1);
      i++;
      while (i < num.length && num[i] == num[i - 1]) i++;   // ignore repeated element
    }
  }
}
