/*
 * Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
    
    public static void main(String[] args) {
		// String tree = "{1,2,3,#,#,4,#,#,5}";
		// String tree = "{1,#,2,3}";
		String tree = "{1,2,2,3,4,4,3,5}";
		// String tree = "{1,2}";
		// String tree = "{1,2,2,#,3,#,3}";
		// String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
		System.out.println(m.maxDepth(root));
    }
}
