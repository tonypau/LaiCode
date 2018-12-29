/*

Iterate through all n values as root.
for ith root, there are 1~i-1 values in the left subtree (x possiblities of bsts) 
  and i+1 ~ N in the right subtree (y possiblities of bsts).
so there are x * y possiblities for ith root.

for example, suppose count[] represents the number of bsts that stores 1...N,
count[4] = count[0] * count[3]      // 1 as root 
          + count[1] * count[2]      // 2 as root
          + count[2] * count[1]      // 3 as root
          + count[4] * count[0]      // 4 as root
          
*/

class Solution {
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        // loop through all values to complete the array
        for (int i = 2; i <= n; i++) {
            // by checking the array using dp, iterate each root
            for (int j = 0; j <= i - 1; j++) {
                count[i] = count[i] + count[j] * count[i - j - 1];   
            }
        }
        return count[n];
    }
}

// there is a harder similar problem: laicode 145
