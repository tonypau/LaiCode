// bucket sort method
// bucket[i] represents the number of i number of citations.

/*
  3,0,6,1,5
  
  5  2    2 means there are two paper whose citation is larger than 5
  4  0
  3  1    1 means there are one paper whose citation is 3
  2  0
  1  0
  0  0

*/
class Solution {
  public int hIndex(int[] citations) {
    int[] bucket = new int[citations.length + 1];
    for (int i = 0; i < citations.length; i++) {
      if (citations[i] > citations.length) {
        bucket[bucket.length - 1]++;
      } else {
        bucket[citations[i]]++;  
      }
    }
    int count = 0;
    for (int i = bucket.length - 1; i >= 0; i--) {
      count += bucket[i];
      
      // when we encounter i <= bucket[n - 1] + bucket[n - 2]... + bucket[i + 1] + bucket[i]
      // then i is the h-index
      if (count >= i) return i;
    }
    return -1;
  }
}
