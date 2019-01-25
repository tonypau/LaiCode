public class Solution {
  private Integer value;
  private int count;
  public Solution() {
    this.count = 0;
  }
  
  public void read(int value) {
    count++;
    if ((int)(Math.random() * count) == 0) {
      this.value = value;
    }
  }
  
  public Integer sample() {
    return value;
  }
}

