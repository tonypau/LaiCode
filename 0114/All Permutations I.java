// O(n!)
public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] arr = set.toCharArray();
    helper(res, arr, 0);
    return res;
  }
  
  private void helper(List<String> res, char[] arr, int level) {
    if (level == arr.length) {
      res.add(new String(arr));
      return;
    }
    for (int i = level; i < arr.length; i++) {
      swap(arr, i, level);
      helper(res, arr, level + 1);
      swap(arr, i, level);
    }
  }
  
  private void swap(char[] nums, int i, int j) {
    char tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

