// [leetcode776]

private TreeNode[] splitBST(TreeNode root, int v) {
  TreeNode[] res = new TreeNode[2]; // res[0] is left, res[1] is right
  if (root == null) return res;
  if (root.key == v) {
    res[1] = root.right;
    root.right = null;
    res[0] = root;
  } else if (root.key < v) {
    TreeNode[] nodes = splitBST(root.right, v);
    root.right = nodes[0];
    res[0] = root;
    res[1] = nodes[1];
  } else {
    TreeNode[] nodes = splitBST(root.left, v);
    root.left = nodes[1];
    res[0] = nodes[0];
    res[1] = root;
  }
  return res;
}  
