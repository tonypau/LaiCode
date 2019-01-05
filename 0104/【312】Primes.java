/*
Return the primes less than or equals to target in ascending order.

Assumptions:

The given target is >= 2.
Examples:

target = 3,  return [2, 3]
target = 10, return [2, 3, 5, 7]
*/

// dp.
public class Solution {
  public List<Integer> primes(int target) {
    List<Integer> res = new ArrayList<>();
    boolean[] m = new boolean[target + 1];
    for (int i = 2; i <= target; i++) {
      m[i] = true;
    }
    for (int i = 2; i <= target; i++) {
      if (m[i]) {
        // elements that can be divided by a prime is not a prime
        for (int j = i + i; j <= target; j += i) {
          m[j] = false;
        }
      }
    }
    for (int i = 0; i <= target; i++) {
      if (m[i]) res.add(i);
    }
    return res;
  }
}

/*

18 [2,3,5,7,11,13,17]
*/
