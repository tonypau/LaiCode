public class Solution {
  public int longest(String input) {
  // the distinct set contains all distinct characters
  // in the sliding window of (slow, fast).
    Set<Character> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    int slow = 0;
    int fast = 0;
    while (fast < input.length()) {
      if (!set.contains(input.charAt(fast))) {
        // if there is no duplicate chracter, we can slide fast pointer
        // and we have a new sliding window of (slow, fast) containing 
        // all distinct characters.
        set.add(input.charAt(fast++));
        max = Math.max(max, fast - slow);
      } else {
        // if there is duplicate character, we need to move
        // the slow pointer.
        set.remove(input.charAt(slow++));
      }
    }
    return max;
  }
}

