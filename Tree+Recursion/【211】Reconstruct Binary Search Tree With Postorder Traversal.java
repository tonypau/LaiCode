// postorder traversal = {1, 4, 3, 11, 8, 5}
//                                        x

// Method1: O(n) in each recursion to find the first larger node, can be optimized
public class Solution {
  public TreeNode reconstruct(int[] post) {
    return reconstruct(post, 0, post.length - 1);
  }
  
  private TreeNode reconstruct(int[] post, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode root = new TreeNode(post[right]);
    int i = left;
    while (i < right) {
      if (post[i] > post[right]) {
        break;
      }
      i++;
    }
    root.left = reconstruct(post, left, i - 1);
    root.right = reconstruct(post, i, right - 1);
    return root;
  }
}


// Method2: 
// we can pass the current min to next level, we maintain a global pointer representing current node in post order
// in each recursion we move backward it one step
public class Solution {
  public TreeNode reconstruct(int[] post) {
    int[] index = new int[] {post.length - 1};
    return reconstruct(post, index, Integer.MIN_VALUE);
  }
  
  private TreeNode reconstruct(int[] post, int[] index, int min) {
    if (index[0] < 0 || post[index[0]] < min) {
      return null;
    }
    TreeNode root = new TreeNode(post[index[0]--]);
    root.right = reconstruct(post, index, root.key);    // must be right first then left. because we traverse postorder from back to front
    root.left = reconstruct(post, index, min);
    return root;
  }  
}
