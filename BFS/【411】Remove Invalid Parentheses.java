public class Solution {
  public List<String> removeInvalidParentheses(String input) {
    List<String> res = new ArrayList<>();
    if (input == null) return res;
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(input);
    boolean found = false;
    while (!queue.isEmpty() && !found) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String s = queue.poll();
        if (isValid(s)) {
          res.add(s);
          found = true;
        } 
        if (!found) {
          for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != '(' && s.charAt(j) != ')') continue;
            String str = s.substring(0, j) + s.substring(j + 1);
            if (visited.add(str)) {
              queue.offer(str);
            }
          } 
        }
      }
    }
    return res;
  }
  
  private boolean isValid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
        if (count < 0) return false;
      }
    }
    return count == 0;
  }
}

