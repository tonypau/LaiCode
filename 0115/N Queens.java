public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, n, 0);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int n, int level) {
    if (level == n) {
      res.add(new ArrayList<Integer>(list));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (isValid(list, n, i)) {
        list.add(i);
        helper(res, list, n, level + 1);
        list.remove(list.size() - 1);
      }
    }
  }
  
  private boolean isValid(List<Integer> list, int n, int index) {
    int row = list.size();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == index || Math.abs(row - i) == Math.abs(index - list.get(i))) {
        return false;      
      }
    }
    return true;
  }
}

