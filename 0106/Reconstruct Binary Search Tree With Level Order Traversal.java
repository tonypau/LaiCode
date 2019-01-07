/*
【212】
Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

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
 
public class Solution {
  // record max and min range
  // insert TreeNode into Node
  static class Node {
    TreeNode node;
    int max;
    int min;
    Node(TreeNode node, int max, int min) {
      this.node = node;
      this.max = max;
      this.min = min;
    }
  }
  
  public TreeNode reconstruct(int[] level) {
    if (level == null || level.length == 0) {
        return null;
    }
    Queue<Node> queue = new LinkedList<>();
    Node root = new Node(new TreeNode(level[0]), Integer.MAX_VALUE, Integer.MIN_VALUE);
    queue.offer(root);
    
    int i = 1;
    // check next two element every loop
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      if (i < level.length && level[i] < temp.node.key && level[i] > temp.min) {
        // take new TreeNode as parameter into Node
        // it is a small trick
        TreeNode newNode = new TreeNode(level[i++]);
        temp.node.left = newNode;
        queue.offer(new Node(newNode, temp.node.key, temp.min));
      } 
      if (i < level.length && level[i] > temp.node.key && level[i] < temp.max) {
        TreeNode newNode = new TreeNode(level[i++]);
        temp.node.right = newNode;
        queue.offer(new Node(newNode, temp.max, temp.node.key));
      }
    }
    return root.node;
  }
}
