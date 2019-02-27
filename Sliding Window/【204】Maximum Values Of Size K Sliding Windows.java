// Deque: record potential candidates. guarantee the first one is the current maximum result
// for each step:
//      case1: when an element that is larger than (or equal with) last one in deque, 
//                that means the last one cannot be added into result any more, we remove it
//      case2: when an element that is smaller than last one in deque,
//                we also have to keep this smaller one because it can be maximum in next window.
//      Also, we have to check if the elements in deque are in the valid range, if not, remove it.
//      Do not forget add into result when i >= k-1


// tc: O(n), the action of pollLast() is O(1) amortized
// sc: O(k)
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      while (!dq.isEmpty() && array[i] >= array[dq.peekLast()]) {
        dq.pollLast();
      }
      if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }
      dq.offerLast(i);
      if (i >= k - 1) {
        res.add(array[dq.peekFirst()]);
      }
    }
    return res;
  }
}
