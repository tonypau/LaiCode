// max heap
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array == null || array.length == 0) return array;
    if (k == 0) return new int[0];
    if (array.length < k) {
      Arrays.sort(array);
      return array;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer e1, Integer e2) {
        if (e1.equals(e2)) {
          return 0;
        }
        return e1 < e2 ? 1 : -1;
      }
    });
    for (int i = 0; i < k; i++) {
      pq.offer(array[i]);
    }
    for (int i = k; i < array.length; i++) {
      if (pq.peek() > array[i]) {
        pq.poll();
        pq.offer(array[i]);
      }
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }
    Arrays.sort(res);
    return res;
  }
}

// quickselect
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array == null || array.length == 0 || k == 0) return new int[0];
    int[] res = new int[k];
    helper(res, array, 0, array.length - 1, k - 1);
    res = Arrays.copyOf(array, k);
    Arrays.sort(res);
    return res;
  }
  
  private void helper(int[] res, int[] array, int left, int right, int k) {
    int index = partition(array, left, right);
    if (index == k) {
      return;
    } else if (index < k) {
      helper(res, array, index + 1, right, k);
    } else {
      helper(res, array, left, index - 1, k);
    }
  }
  
  private int partition(int[] array, int left, int right) {
    int pivot = (int) (Math.random() * (right - left)) + left;
    int pivotValue = array[pivot];
    swap(array, pivot, right);
    int leftBound = left;
    int rightBound = right - 1;
    while (leftBound <= rightBound) {
      if (array[leftBound] <= pivotValue) {
        leftBound++;
      } else if (array[rightBound] >= pivotValue) {
        rightBound--;
      } else {
        swap(array, leftBound++, rightBound--);
      }
    }
    swap(array, right, leftBound);
    return leftBound;
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

