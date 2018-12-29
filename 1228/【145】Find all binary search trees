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
  public List<TreeNode> generateBSTs(int n) {
    return generateBSTs(1, n);
  }
  
  private List<TreeNode> generateBSTs(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}
    // iterate every value between start and end as root.
		for(int i = start; i <= end; i++) {
			List<TreeNode> leftSubTree = generateBSTs(start, i-1);
			List<TreeNode> rightSubTree = generateBSTs(i+1, end);
      // looping through all left and right subtrees and connecting them to ith root  below
			for(int j = 0; j < leftSubTree.size(); j++) {
				TreeNode left = leftSubTree.get(j);
				for(int k = 0; k < rightSubTree.size();k++) {
					TreeNode right = rightSubTree.get(k);
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
}


// Time ??
// Space ??

