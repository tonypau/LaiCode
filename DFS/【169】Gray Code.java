package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs. 2^n levels. n branches each level.
public class GrayCode {
  public static void main(String[] args) {
    GrayCode grayCode = new GrayCode();
    System.out.println(grayCode.graycode(4));
  }
  
  public List<Integer> graycode(int n) {
    List<Integer> res = new ArrayList<>();
    if (n <= 0) return res;
    Set<Integer> visited = new HashSet<>();
    int count = (int) Math.pow(2, n);
    res.add(0);
    visited.add(0);
    dfs(res, visited, 0, count, n);
    return res;
  }
  
  private boolean dfs(List<Integer> res, Set<Integer> visited, int cur, int count, int n) {
    if (visited.size() == count) {
      return true;
    }
    for (int i = 0; i < n; i++) {
      int next = toggle(cur, i);
      if (visited.add(next)) {
        res.add(next);
        if (dfs(res, visited, next, count, n)) return true;
        res.remove(next);
        visited.remove(next);
      }
    }
    return false;
  }
  
  private int toggle(int num, int i) {
    if (((num >> i) & 1) == 1) {
      num &= ~(1 << i);
    } else {
      num |= (1 << i);
    }
    return num;
  }
}
