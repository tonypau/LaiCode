/*
Each positive integer larger than 1 is the production of several prime numbers. Return the list of prime factors in ascending order.

Assumptions:

The given number is >= 2.
Examples:

12 = 2 * 2 * 3, return [2, 2, 3]
5 = 5, return [5]
*/

public class Solution {
  public List<Integer> factors(int target) {
    List<Integer> res = new ArrayList<>();
    int factor = 2;
    while (factor <= target) {
      if (target / factor * factor == target) {
        res.add(factor);
        target = target / factor;
      } else {
        factor++;
      }
    }
    return res;
  }
}

