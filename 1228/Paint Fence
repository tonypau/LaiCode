/* 

f(n) = (k - 1) * (f(n - 1) + f(n - 2))
  suppose n = 3,
  1) the first two are the same color, the third one has k-1 options.   k(k - 1)
  2) the first two are not the same color, k(k - 1), then the third one has k options.      k(k - 1)k
  so there are k(k-1) + k(k-1)k = (k-1)(k+k^2) ways, in another way, f(3) = (k-1)(f(1) + f(2)).
  
*/

public class Solution {
  // cuz f(n) is only related with f(n-1) and f(n-2), so set a limited size of dp array.
  public int numWays(int n, int k) {
    int[] m = {0, k, k * k, 0};
    if (n <= 2) return m[n]; 
    for (int i = 2; i < n; i++) {
      m[3] = (k - 1) * (m[1] + m[2]);
      m[1] = m[2];
      m[2] = m[3];
    }
    return m[3];
  }
}
