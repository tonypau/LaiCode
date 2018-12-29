/*
|| Given an unsorted integer array, each element is at most k step from its position after the array is sorted.

|| Can you sort this array with time complexity better than O(nlogn)?

|| Assumptions:

||  The given array is not null and length is n, k < n and k >= 0
  
  idea:
    use a minheap of size k+1. first offer the first k+1 elements.   O(k)
    then pop the top and insert the new element from the remaining elements.   O((n-k)logk)
    so overall complexity will be O(k) + O((n-k)*logK).
*/

public class Solution {
  public int[] ksort(int[] array, int k) {
    int[] res = new int[array.length];
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
    for (int i = 0; i < k + 1; i++) {
      minHeap.offer(array[i]);
    }
    int index = 0;
    for (int i = k + 1; i < array.length; i++) {
      res[index++] = minHeap.peek();
      minHeap.poll();
      minHeap.offer(array[i]);
    }
    while (!minHeap.isEmpty()) {
      res[index++] = minHeap.poll();
    }
    return res;
  }
}
