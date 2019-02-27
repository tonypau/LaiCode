// Binary search has two points:
// 1) must guarantee the search space is decreasing each loop
// 2) the target one cannot be eliminated

// tc: O(logk)
// sc: O(logk)
public class Solution {
  public int kth(int[] a, int[] b, int k) {
    return helper(a, 0, b, 0, k);
  }
  
  // aLeft: current head of search space of a
  // bLeft: current head of search space of b
  // k: remaining number of elements need to find
  private int helper(int[] a, int aLeft, int[] b, int bLeft, int k) {
   // base case:
    if (aLeft >= a.length) {
      return b[bLeft + k - 1];
    } else if (bLeft >= b.length) {
      return a[aLeft + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aLeft], b[bLeft]);
    }
    
    
    // when there are less than k/2 elements in a, we replace with MAX_VALUE. 
    // because the k-th smallest one cannot be in the remaining of a
    int aNum = aLeft + k / 2 - 1 < a.length ? a[aLeft + k / 2 - 1] : Integer.MAX_VALUE;
    int bNum = bLeft + k / 2 - 1 < b.length ? b[bLeft + k / 2 - 1] : Integer.MAX_VALUE;
    if (aNum < bNum) {
      return helper(a, aLeft + k / 2, b, bLeft, k - k / 2);
    } else {
      return helper(a, aLeft, b, bLeft + k / 2, k - k / 2);
    }
  }
}
