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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> map = getMap(inOrder);
    return helper(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1, map);
  }
  
  private TreeNode helper(int[] inOrder, int[] preOrder, int sIn, int eIn, int sPre, int ePre, Map<Integer, Integer> map) {
    if (sIn > eIn) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[sPre]);
    int index = map.get(preOrder[sPre]);
    root.left = helper(inOrder, preOrder, sIn, index - 1, sPre + 1, sPre + index - sIn, map);
    root.right = helper(inOrder, preOrder, index + 1, eIn, sPre + index - sIn + 1, ePre, map);
    return root;
  }
  
  private Map<Integer, Integer> getMap(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }
}

