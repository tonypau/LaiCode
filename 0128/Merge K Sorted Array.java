public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>() {
      @Override
      public int compare(Entry e1, Entry e2) {
        if (e1.value == e2.value) {
          return 0;
        }
        return e1.value < e2.value ? -1 : 1;
      }
    });
    int length = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] row = arrayOfArrays[i];
      length += row.length;
      if (row.length != 0) {
        pq.offer(new Entry(row[0], i, 0));
      }
    }
    int[] res = new int[length];
    int count = 0;
    while (!pq.isEmpty()) {
      Entry cur = pq.poll();
      res[count++] = cur.value;
      if (cur.y + 1 < arrayOfArrays[cur.x].length) {
        pq.offer(new Entry(arrayOfArrays[cur.x][cur.y + 1], cur.x, cur.y + 1));
      }
    }
    return res;
  }
  
  static class Entry {
    int value;
    int x;
    int y;
    Entry(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
    }
  }
}

