// refine[i]: It represents for all longest increasing sequence of length (i + 1). what is the smallest possible value 
//            for the last element in this sequence with length (i + 1)

public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int[] refine = new int[4];
    refine[1] = nums[0];
    int max = 1;
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > refine[index]) {
        max++;
        if (max == 3) {
          return true;
        } else {
          refine[max] = nums[i];
          index++;
        }
      } else {
        if (nums[i] < refine[1]) {
          refine[1] = nums[i];
        } else {
          refine[max] = nums[i];
        }
      }
    }
    return false;
  }
}

