/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int oneL = getLength(one);
    int twoL = getLength(two);
    while (oneL > twoL) {
      one = one.parent;   
      oneL--;
    }
    while (oneL < twoL) {
      two = two.parent;
      twoL--;
    }
    while (oneL > 0) {
      if (one == two) return one;
      one = one.parent;
      two = two.parent;
      oneL--;
    }
    return null;
  }
  
  private int getLength(TreeNodeP node) {
    int len = 0;
    while (node != null) {
      len++;
      node = node.parent;
    }
    return len;
  }
}

