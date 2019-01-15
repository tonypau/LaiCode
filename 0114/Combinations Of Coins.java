public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, target, coins, 0);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int target, int[] coins, int index) {
    if (index == coins.length - 1) {
      if (target % coins[index] == 0) {
        list.add(target / coins[index]);
        res.add(new ArrayList<Integer>(list));
        list.remove(list.size() - 1);
      } 
      return;
    }
    int max = target / coins[index];
    for (int i = 0; i <= max; i++) {
      list.add(i);
      helper(res, list, target - i * coins[index], coins, index + 1);
      list.remove(list.size() - 1);
    }
  }
}

