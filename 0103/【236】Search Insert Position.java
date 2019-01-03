/*
Given a sorted array and a target value, return the index where it would be if it were inserted in order. 

Assumptions
If there are multiple elements with value same as target, we should insert the target before the first existing element.

Examples

[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,3,3,5,6], 3 → 1

[1,3,5,6], 0 → 0
*/

public class Solution {
  public int searchInsert(int[] input, int target) {
    if (input == null || input.length == 0) return 0;
    if (target > input[input.length - 1]) return input.length;
    int left = 0;
    int right = input.length - 1;
    // why left < right?
    // because when there are only two elements left, L R, 
    // next step must jump outside the loop:
    // 1) right = mid --> L
                          M
                          R
    // 2) left = mid + 1      --->   R
                                   M
                                     L
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (input[mid] >= target) {
        // under this condition, the mid position also maybe the last answer
        right = mid;
      } else {
        // under this one, the mid position cannot be the last answer
        left = mid + 1;
      }
    }
    return left;
  }
}

