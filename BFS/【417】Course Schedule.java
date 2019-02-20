// 原理也很简单，在一个有向图中，每次找到一个没有前驱节点的节点（也就是入度为0的节点），然后把它指向其他节点的边都去掉，重复这个过程（BFS），
// 直到所有节点已被找到，或者没有符合条件的节点（如果图中有环存在）。
// 参考：https://blog.csdn.net/ljiabin/article/details/45846837

public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
      return true;
    }
    int[] preNums = new int[numCourses];
    // pre-course: {post-courses}
    Map<Integer, List<Integer>> map = getMap(prerequisites, numCourses, preNums);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (preNums[i] == 0) {
        queue.offer(i);
      }
    }
    int count = numCourses;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int post : map.get(cur)) {
        if (--preNums[post] == 0) {
          // 只有当一节课不需要其他没上过的pre课了，才能开始学，也就是才能generate
          // 那怎么判断还需不需要其他pre课呢？ 用preNums，记录需要学的pre课的数量，也就是入度
          queue.offer(post);
        }
      }
      count--;
    }
    return count == 0;
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

