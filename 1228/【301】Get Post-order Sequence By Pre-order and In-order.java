// the submission of this problem has some bug in laicode system 

public class Solution {
  // record the index order of result insertion 
  static int postIndex = 0;
  
	public int[] postOrder(int[] pre, int[] in) {
    // reduce time 
	  Map<Integer, Integer> map = new HashMap<>();
	  for (int i = 0; i < in.length; i++) {
	    map.put(in[i], i);
	  }
	  int[] res = new int[pre.length];
	  helper(res, map, pre, in, 0, pre.length - 1, 0, in.length - 1);
	  return res;
	}
	  
	private void helper(int[] res, Map<Integer, Integer> map, int[] pre, int[] in, int ps, int pe, int is, int ie) {
	  if (is > ie) {
	    return;
	  }
    // find the index of the pre element in inorder array
	  int inIndex = map.get(pre[ps]);
	  helper(res, map, pre, in, ps + 1, ps + inIndex - is, is, inIndex - 1);
	  helper(res, map, pre, in, ps + inIndex - is + 1, pe, inIndex + 1, ie);
    // add into array with order
	  res[postIndex++] = pre[ps];   
	}
}


