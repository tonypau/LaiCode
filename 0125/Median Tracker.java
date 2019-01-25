public class Solution {
  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;
  Double median;
  int count;
  
  public Solution() {
    this.maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
    this.minHeap = new PriorityQueue<Integer>();
    this.median = null;
    this.count = 0;
  }
  
  public void read(int value) {
    count++;
    if (maxHeap.isEmpty() || value < maxHeap.peek()) {
      maxHeap.offer(value);
    } else {
      minHeap.offer(value);
    }
    if (minHeap.size() > maxHeap.size()) {
      maxHeap.offer(minHeap.poll());
    } else if (maxHeap.size() - minHeap.size() >= 2) {
      minHeap.offer(maxHeap.poll());
    }
    if (count % 2 == 1) median = 1.0 * maxHeap.peek();
    else {
      median = (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }
  
  public Double median() {
    return median;
  }
}

