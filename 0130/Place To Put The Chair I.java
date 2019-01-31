// 4联通情况，bfs1即可，因为边长一致
public class Solution {
  private static final char EQUIP = 'E';
  private static final char OB = 'O';
  public List<Integer> putChair(char[][] gym) {
    int[][] cost = new int[gym.length][gym[0].length];
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (gym[i][j] == EQUIP) {
          if (!addCost(cost, gym, i, j)) {
            return Arrays.asList(-1, -1);
          }
        }
      }
    }
    List<Integer> res = Arrays.asList(-1, -1);
    for (int i = 0; i < cost.length; i++) {
      for (int j = 0; j < cost[0].length; j++) {
        if (gym[i][j] != OB && gym[i][j] != EQUIP) {
          if (res.get(0) == -1 && res.get(1) == -1) {
            res = Arrays.asList(i, j); 
          } else if (cost[i][j] < cost[res.get(0)][res.get(1)]) {
            res.set(0, i);
            res.set(1, j);
          }
        }
      }
    }
    return res;
  }
  
  private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(i, j));
    visited[i][j] = true;
    int pathCost = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int index = 0; index < size; index++) {
        Pair cur = queue.poll();  
        for (Pair nei : getNeis(cur, gym)) {
          if (!visited[nei.x][nei.y]) {
            cost[nei.x][nei.y] += pathCost;
            visited[nei.x][nei.y] = true;
            queue.offer(nei);
          }
        }
      }
      pathCost++;
    }
    
    for (int l = 0; l < cost.length; l++) {
      for (int m = 0; m < cost[0].length; m++) {
        if (gym[l][m] == EQUIP && !visited[l][m]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private List<Pair> getNeis(Pair cur, char[][] gym) {
    List<Pair> res = new ArrayList<>();
    int M = gym.length;
    int N = gym[0].length;
    if (cur.x + 1 < M && gym[cur.x + 1][cur.y] != OB) {
      res.add(new Pair(cur.x + 1, cur.y));
    }
    if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != OB) {
      res.add(new Pair(cur.x - 1, cur.y));
    }
    if (cur.y + 1 < N && gym[cur.x][cur.y + 1] != OB) {
      res.add(new Pair(cur.x, cur.y + 1));
    }
    if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != OB) {
      res.add(new Pair(cur.x, cur.y - 1));
    }
    return res;
  }
  
  static class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}


// 8联通情况，要用bfs2，因为边长不一致
private static final char EQUIP = 'E';
  private static final char OB = 'O';
  public List<Integer> putChair(char[][] gym) {
    double[][] cost = new double[gym.length][gym[0].length];
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (gym[i][j] == EQUIP) {
          if (!addCost(cost, gym, i, j)) {
            return Arrays.asList(-1, -1);
          }
        }
      }
    }
    List<Integer> res = Arrays.asList(-1, -1);
    for (int i = 0; i < cost.length; i++) {
      for (int j = 0; j < cost[0].length; j++) {
        if (gym[i][j] != OB && gym[i][j] != EQUIP) {
          if (res.get(0) == -1 && res.get(1) == -1) {
            res = Arrays.asList(i, j); 
          } else if (cost[i][j] < cost[res.get(0)][res.get(1)]) {
            res.set(0, i);
            res.set(1, j);
          }
        }
      }
    }
    return res;
  }
  
  private boolean addCost(double[][] cost, char[][] gym, int i, int j) {
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    visited[i][j] = true;
    PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.dis == p2.dis) {
          return 0;
        }
        return p1.dis < p2.dis ? -1 : 1;
      }
    });
    queue.offer(new Pair(i, j, 0));
    while (!queue.isEmpty()) {
      Pair cur = queue.poll();
      for (Pair nei : getNeis(cur, gym)) {
        if (!visited[nei.x][nei.y]) {
          cost[nei.x][nei.y] += nei.dis + cur.dis;
          visited[nei.x][nei.y] = true;
          queue.offer(new Pair(nei.x, nei.y, nei.dis + cur.dis));
        }
      }
    }
    
    for (int l = 0; l < cost.length; l++) {
      for (int m = 0; m < cost[0].length; m++) {
        if (gym[l][m] == EQUIP && !visited[l][m]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private List<Pair> getNeis(Pair cur, char[][] gym) {
    List<Pair> res = new ArrayList<>();
    int M = gym.length;
    int N = gym[0].length;
    if (cur.x + 1 < M && gym[cur.x + 1][cur.y] != OB) {
      res.add(new Pair(cur.x + 1, cur.y, 1));
    }
    if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != OB) {
      res.add(new Pair(cur.x - 1, cur.y, 1));
    }
    if (cur.y + 1 < N && gym[cur.x][cur.y + 1] != OB) {
      res.add(new Pair(cur.x, cur.y + 1, 1));
    }
    if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != OB) {
      res.add(new Pair(cur.x, cur.y - 1, 1));
    }
    if (cur.x + 1 < M && cur.y + 1 < N && gym[cur.x + 1][cur.y + 1] != OB) {
      res.add(new Pair(cur.x + 1, cur.y + 1, 1.414));
    }
    if (cur.x - 1 >= 0 && cur.y - 1 >= 0 && gym[cur.x - 1][cur.y - 1] != OB) {
      res.add(new Pair(cur.x - 1, cur.y - 1, 1.414));
    }
    if (cur.y + 1 < N && cur.x - 1 >= 0 && gym[cur.x - 1][cur.y + 1] != OB) {
      res.add(new Pair(cur.x - 1, cur.y + 1, 1.414));
    }
    if (cur.y - 1 >= 0 && cur.x + 1 < N && gym[cur.x + 1][cur.y - 1] != OB) {
      res.add(new Pair(cur.x + 1, cur.y - 1, 1.414));
    }
    return res;
  }
  
  static class Pair {
    int x;
    int y;
    double dis;
    
    Pair(int x, int y, double dis) {
      this.x = x;
      this.y = y;
      this.dis = dis;
    }
  }
