/*
【232】
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order.

The solution set must not contain duplicate combinations.

Example

          given candidate set 2,3,6,7 and target 7,

    A solution set is:

     [7]

     [2, 2, 3]

*/

public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) return res;
    List<Integer> list = new ArrayList<>();
    
    // need sort before
    Arrays.sort(candidates);
    helper(res, list, candidates, 0, target);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int target) {
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      // when remaining target smaller than cur element, it means we cannot add up cur element any more
      // then we return, remove last element in list, and enter next loop, i move foreward to add up next element in candidates
      if (target < candidates[i]) {
        return;
      }
      list.add(candidates[i]);
      helper(res, list, candidates, i, target - candidates[i]);
      list.remove(list.size() - 1);
    }
  }
}

