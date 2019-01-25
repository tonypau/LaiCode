public class Solution {
  private List<Integer> sample;
  private final int k;
  private int count;
  
  public Solution(int k) {
    this.k = k;
    this.count = 0;
    this.sample = new ArrayList<>();
  }
  
  public void read(int value) {
    count++;
    if (count <= k) {
      sample.add(value);
    } else {
      int r = (int)(Math.random() * count);
      if (r < k) {
        sample.set(r, value);
      }
    }
  }
  
  public List<Integer> sample() {
    return sample;
  }
}

