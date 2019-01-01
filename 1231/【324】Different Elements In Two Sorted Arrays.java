/*
  Given two sorted arrays a and b containing only integers, return two list of elements: the elements only in a but not in b, and the elements only in b but not in a.

Do it in one pass.

Assumptions:

The two given arrays are not null.
Examples:

a = {1, 2, 2, 3, 4, 5}

b = {2, 2, 2, 4, 4, 6}

The returned two lists are:

[

  [1, 3, 5],

  [2, 4, 6]  // there are two 2s in a, so there is one 2 in b not in a

]
*/

/*
  easy to understand.
  two pointers moving in the same direction respectively in one pass.
*/

public class Solution {
  public int[][] diff(int[] a, int[] b) {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        l1.add(a[i++]);
      } else if (a[i] > b[j]) {
        l2.add(b[j++]);
      } else {
        i++;
        j++;
      }
    }
    if (i < a.length) {
      while (i < a.length) {
        l1.add(a[i++]);
      }
    }
    if (j < b.length) {
      while (j < b.length) {
        l2.add(b[j++]);
      }
    }
    int[][] res = new int[2][];
    // java 2d array can have different lengths in different rows.
    res[0] = new int[l1.size()];
    res[1] = new int[l2.size()];
    for (int k = 0; k < l1.size(); k++) {
      res[0][k] = l1.get(k);
    }
    for (int k = 0; k < l2.size(); k++) {
      res[1][k] = l2.get(k);
    }
    return res;
  }
}

/*
a = {1, 2, 2, 3, 4, 5}
                       i
b = {2, 2, 2, 4, 4, 6}
                    j

[
  [],
  []
]

{1, 3, 5},
{2, 4, }


*/
