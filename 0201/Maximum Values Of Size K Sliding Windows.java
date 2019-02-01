// index: 0  1  2  3  4  5  6  7  8           
// val:  {1, 3, 2, 5, 8, 9, 4, 7, 3}

// O((n-k)*logn)
// each sliding costs O(logn), which is used on offer() new element and poll() old one
// maxHeap, lazy deletion
public class Solution {
  static class Element {
    int index;
    int val;
    Element(int val, int index) {
      this.val = val;
      this.index = index;
    }
  }
  
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>() {
      @Override
      public int compare(Element e1, Element e2) {
        if (e1.val == e2.val) return 0;
        return e1.val < e2.val ? 1 : -1;
      }
    });
    int left = 0;
    for (int i = 0; i < array.length; i++) {
      maxHeap.offer(new Element(array[i], i));
      if (i >= k) {
        left++;
      }
      if (i >= k - 1) {
        if (maxHeap.peek().index < left) maxHeap.poll();
        res.add(maxHeap.peek().val);
      }
    }
    return res;
  }
}

// O(n)
// deque
// 又大又新法则
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      // 如果新来的比deque的尾巴那个大，满足又大又新，那么舍弃尾巴
      while (!dq.isEmpty() && array[dq.peekLast()] <= array[i]) {
        dq.pollLast();
      }
      
      // 如果deque里的旧老大已经过时了，也就是已经不在目前的window里，那么舍弃掉
      if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }
      
      // 新来的肯定是要纳入考虑范围，即使比不过旧老大，但不妨碍它有可能是下一个window的老大
      dq.offerLast(i);
      
      // 加进结果里
      if (i >= k - 1) {
        res.add(array[dq.peekFirst()]);
      }
    }
    return res;
  }
}
