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
// The 4th level to understand recursion:
// The input argument list of each recursion function in each call-stack level must be consistent with each other
public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    Map<Integer, Integer> map = getMap(inOrder);
    List<Integer> level = new ArrayList<>();
    for (int i : levelOrder) level.add(i);
    return helper(level, map);
  }
  
  private TreeNode helper(List<Integer> level, Map<Integer, Integer> map) {
    if (level.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(level.remove(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int num : level) {
      if (map.get(num) < map.get(root.key)) {
        left.add(num);
      } else {
        right.add(num);
      }
    }
    root.left = helper(left, map);
    root.right = helper(right, map);
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

