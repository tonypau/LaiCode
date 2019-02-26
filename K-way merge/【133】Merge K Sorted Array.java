// Method1: heap
// Data structure: minHeap of size k, Entry
// Init: put the first element of every row into minHeap     O(k * logk)
// For each step:
//      expand the smallest element and generate its next one in its row until minHeap is empty
          
// k is the number of rows
// TC: O(logk * kn)
// SC: O(k)
public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(new Comparator<Entry>() {
      @Override
      public int compare(Entry e1, Entry e2) {
        if (e1.val == e2.val) {
          return 0;
        }
        return e1.val < e2.val ? -1 : 1;
      }
    });
    int length = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] row = arrayOfArrays[i];
      length += row.length;
      if (row.length != 0) {
        minHeap.offer(new Entry(i, 0, row[0]));
      }
    }
    int[] res = new int[length];
    int index = 0;
    while (!minHeap.isEmpty()) {
      Entry cur = minHeap.poll();    // O(logk)
      res[index++] = cur.val;
      if (cur.y + 1 < arrayOfArrays[cur.x].length) {
        minHeap.offer(new Entry(cur.x, cur.y + 1, arrayOfArrays[cur.x][cur.y + 1]));   // O(logk)
      }
    }
    return res;
  }
  
  static class Entry {
    int x;
    int y;
    int val;
    
    Entry(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
}

// Method2: Binary Reduction
A1
A2   --> A12
A3             --> A14
A4   --> A34
A5                       --> A18
A6   --> A56
A7             --> A58
A8   --> A78
        O(8n)     O(8n)     O(8n)
        
// TC: O(logk * kn)
// SC: O(kn) if we run it layer by layer
/* Compare with *Method1*, the TC is the same, but space is worse than *Method1*.
  However, if the array sizes are big, and we need to get file read and write involved. Method1 only needs to read and write each element
  once and only once. *Method2* needs to read and write each element log(k) times which is the bottleneck of the system.
*/

// Method3: Iterative Reduction
A1 A2 --> A12                                      O(2n)
          A3   --> A13                             O(3n)
                   A4   -->  A14                   O(4n)
                                                    ...
                             ....      A1k         O(kn)
// TC: O(2+3+4+...+k) * n = O(k^2 * n)
// SC: O(kn)
