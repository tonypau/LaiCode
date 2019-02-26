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
/*
inorder traversal = {1, 3, 4, 5, 8, 11}
                              x

levelorder traversal = {5, 3, 8, 1, 4, 11}
                        x
                        
          left: 3 1 4
          right: 8 11
          
levelorder traversal = {3, 1, 4}
                        x
          left: 1
          right: 4
*/
public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    List<Integer> list = new ArrayList<>();
    for (int i : levelOrder) list.add(i);
    return reconstruct(map, list);
  }
  
  private TreeNode reconstruct(Map<Integer, Integer> map, List<Integer> levelOrder) {
    if (levelOrder.size() == 0) {
      return null;
    }
    TreeNode root = new TreeNode(levelOrder.remove(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int i : levelOrder) {
      if (map.get(i) < map.get(root.key)) {
        left.add(i);
      } else {
        right.add(i);
      }
    }
    root.left = reconstruct(map, left);
    root.right = reconstruct(map, right);
    return root;
  }
}

