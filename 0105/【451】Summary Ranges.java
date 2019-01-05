/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
  public String[] summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();
    int index = 0;
    int i = 0;
    while (i < nums.length) {
      int j = i + 1;
      String cur = "";
      while (j < nums.length && nums[j] == nums[j - 1] + 1) {
        j++;
      }
      if (j - i == 1) {
        cur += nums[i];
      } else {
        cur += nums[i] + "->" + nums[j - 1];
      }
      list.add(cur);
      i = j;
    }
    String[] res = new String[list.size()];
    for (int k = 0; k < list.size(); k++) {
      res[k] = list.get(k);
    } 
    return res;
  }
}

/*
0 1 2 4 5 7
            i 
            j
*/
