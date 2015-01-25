/*
 * Minimum Depth of Binary Tree 
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 */
public class MinimumDepthOfBinaryTree {

	/*
	 * (node.left == null && node.right == null) is called a leaf
	 */
    public int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) return 1;
    	if(root.left == null) {
    		return minDepth(root.right) + 1;
    	} else if (root.right == null) {
    		return minDepth(root.left) + 1;
    	} else {
			int leftDepth = minDepth(root.left);
			int rightDepth = minDepth(root.right);
			return (leftDepth < rightDepth) ? (leftDepth + 1)
					: (rightDepth + 1);
    	}
    }
    
    public static void main(String[] args) {
		// String tree = "{1,2,3,#,#,4,#,#,5}";
		// String tree = "{1,#,2,3}";
		//String tree = "{1,2,2,3,4,4,3,5}";
		//String tree = "{1,2}";
		// String tree = "{1,2,2,#,3,#,3}";
		// String tree = "{1,2,3,3,#,2,#}";
		String tree = "{1,2,#,3,#,4,#,5}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
		System.out.println(m.minDepth(root));
    }
}
