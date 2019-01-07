/*
【155】
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

E.g.    Input: n = 4, k = 2

    Output: [

                     [2,4],

                     [3,4],

                     [2,3],

                     [1,2],

                     [1,3],

                     [1,4]

        ]
*/

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (k < 0 || n <= 0) return res;
    List<Integer> list = new ArrayList<>();
    helper(res, list, 1, n, k);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int index, int n, int k) {
    if (list.size() == k) {
      res.add(new ArrayList<>(list));
      return;
    }
    // for loop traverses every element to be the first one.
    for (int i = index; i <= n; i++) {
      list.add(i);
      helper(res, list, i + 1, n, k);
      list.remove(list.size() - 1);
    }
  }
}

