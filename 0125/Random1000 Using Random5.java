public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int r = 3001;
    while (r > 3000) {
      r = 0;
      for (int i = 0; i < 5; i++) {
        r = r * 5 + RandomFive.random5(); 
      }
    }
    return r % 1000;
  }
}

