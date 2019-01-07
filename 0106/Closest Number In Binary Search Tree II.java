/*
【504】
In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
*/

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

// inorder traversal
// for every node, we find its diff between target
// use a maxHeap to maintain k nodes which are the k closest to the target
public class Solution {
  static class Cell {
    double diff;
    int key;
    Cell(double diff, int key) {
      this.diff = diff;
      this.key = key;
    }
  }
  
  public int[] closestKValues(TreeNode root, double target, int k) {
    PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.diff == c2.diff) {
          return 0;
        }
        return c1.diff < c2.diff ? 1 : -1;
      }
    });
    helper(root, target, k, maxHeap);
    int[] res = new int[maxHeap.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = maxHeap.poll().key;
    }
    Arrays.sort(res);
    return res;
  }
  
  private void helper(TreeNode root, double target, int k, PriorityQueue<Cell> maxHeap) {
    if (root == null) return;
    helper(root.left, target, k, maxHeap);
    maxHeap.offer(new Cell(Math.abs(((double)root.key) - target), root.key));
    if (maxHeap.size() > k) maxHeap.poll();  // poll the top node which has the largest diff so far
    helper(root.right, target, k, maxHeap);
  }
}

