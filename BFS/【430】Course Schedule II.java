public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
      return new int[0];
    }
    int[] preNums = new int[numCourses];
    Map<Integer, List<Integer>> map = getMap(prerequisites, numCourses, preNums);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (preNums[i] == 0) {
        queue.offer(i);
      }
    }
    int count = numCourses;
    int[] order = new int[numCourses];
    int i = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      order[i] = cur;
      for (int post : map.get(cur)) {
        if (--preNums[post] == 0) {
          queue.offer(post);
        }
      }
      count--;
      i++;
    }
    return count == 0 ? order : new int[0];
  }
  
  private Map<Integer, List<Integer>> getMap(int[][] prerequisites, int n, int[] preNums) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      map.put(i, list);
    }
    for (int[] arr : prerequisites) {
      map.get(arr[1]).add(arr[0]);
      preNums[arr[0]]++;
    }
    return map;
  }
}

