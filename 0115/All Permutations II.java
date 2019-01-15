public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null || set.length() == 0) return res;
    char[] arr = set.toCharArray();
    helper(res, arr, 0);
    return res;
  }
  
  private void helper(List<String> res, char[] arr, int index) {
    if (index == arr.length) {
      res.add(new String(arr));
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i < arr.length; i++) {
      if (set.contains(arr[i])) {
        continue;
      }
      set.add(arr[i]);
      swap(arr, index, i);
      helper(res, arr, index + 1);
      swap(arr, index, i);
    }
  }
  
  private void swap(char[] nums, int i, int j) {
    char tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

