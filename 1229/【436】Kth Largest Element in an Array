/*
  1) maxHeap
    a. heapify all elements --- O(n)
    b. pop k times --- O(klogn)
    
    Time: O(n + klogn)
*/ 
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return -1;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        if (i1.equals(i2)) {
          return 0;
        }
        return i1 < i2 ? 1 : -1;
      }
    });
    for (int i = 0; i < nums.length; i++) {
      maxHeap.offer(nums[i]);
    }
    for (int j = 0; j < k - 1; j++) {
      maxHeap.poll();
    }
    return maxHeap.poll();
  }
}


/*
  2) minHeap
    a. construct a size k minHeap with the first k elements. --- O(k)
    b. loop the remaining elements     
      if nums[i] < top, ignore
      if nums[i] > top, pop the top and then insert the nums[i].  --- O((n-k)logn)
      
    Time: O(k + (n - k)logn)
*/

public class Solution {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return -1;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }
    for (int j = k; j < nums.length; j++) {
      if (nums[j] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[j]);
      }
    }
    return minHeap.peek();
  }
}

/*
  3) quickSelect
  the idea is: partition a half in a run
  time: O(n/2) + O(n/4) + O(n/8) +...+ O(1) = O(n)
  worst time: O(n^2)
*/

public class Solution {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return -1;
    quickSelect(nums, 0, nums.length - 1, k - 1);
    return nums[k - 1];
  }
  
  private void quickSelect(int[] nums, int left, int right, int target) {
    int mid = partition(nums, left, right);
    if (mid == target) {
      return;
    } else if (mid > target) {
      quickSelect(nums, left, mid - 1, target);
    } else {
      quickSelect(nums, mid + 1, right, target);
    }
  }
  
  private int partition(int[] nums, int left, int right) {
    int pivot = nums[right];
    int s = left;
    int e = right - 1;
    while (s <= e) {
      if (nums[s] >= pivot) {
        s++;
      } else if (nums[e] < pivot) {
        e--;
      } else {
        swap(nums, s++, e--);
      }
    }
    swap(nums, right, s);
    return s;
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

