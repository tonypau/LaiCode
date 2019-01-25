public class Solution {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int r = 21;
    while (r > 20) {
      r = RandomFive.random5() * 5 + RandomFive.random5();
    }
    return r % 7;
  }
}

