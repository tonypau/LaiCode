/*
  Given three sorted integer arrays, pick one element from each of them, what is the min value of |x - y| + |y - z| + |z - x|.

Assumptions:

The given three arrays are not null or empty.
Examples:

a = {1, 2, 3}

b = {4, 5}

c = {3, 4}

The minimum value is |3 - 4| + |4 - 4| + |4 - 3| = 2
*/

// three pointers. record the max and min among the three elements. compare the diff (max - min)
// when diff is the least, then the result will be the least.
// O(n)
public class Solution {
  public int minDistance(int[] a, int[] b, int[] c) {
    int i = 0;
    int j = 0;
    int k = 0;
    int res = 0;
    int diff = Integer.MAX_VALUE;
    while (i < a.length && j < b.length && k < c.length) {
      int max = Math.max(a[i], Math.max(b[j], c[k]));
      int min = Math.min(a[i], Math.min(b[j], c[k]));
      if (diff > max - min) {
        diff = max - min;
        res = Math.abs(a[i] - b[j]) + Math.abs(a[i] - c[k]) + Math.abs(c[k] - b[j]);
      }
      if (a[i] == min) {
        i++;
      } else if (b[j] == min) {
        j++;
      } else {
        k++;
      }
    }
    return res;
  }
}

/*
  a = {1, 2, 3, 6}
                i
  b = {4, 5}
             j
  c = {3, 5}
          z
*/
