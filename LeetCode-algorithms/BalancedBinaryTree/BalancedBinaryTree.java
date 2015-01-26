/*
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which 
 * the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	
	private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        if(leftDepth < 0) return -1;
        int rightDepth = maxDepth(root.right);
        if(rightDepth < 0) return -1;
        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
	}
	
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(maxDepth(root) < 0) return false;
        else return true;
    }
   
    public static void main(String[] args) {
		String tree = "{1,2,3,#,#,4,#,#,5}";
		// String tree = "{1,#,2,3}";
		// String tree = "{1,2,2,3,4,4,3,5}";
		// String tree = "{1,2}";
		// String tree = "{1,2,2,#,3,#,3}";
		// String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.println(b.isBalanced(root));
    }
}
