/*
 * Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * 
 * Given the below binary tree,
 *     1
 *    / \
 *   2   3
 *   
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
	
	static class Values {
		int maxDead;
		int maxLive;
	}
	
	private Values subMaxSum(TreeNode node) {
		Values v = new Values();
		if(node == null) return v;
		if(node.left == null && node.right == null) {
			v.maxDead = v.maxLive = node.val;
			return v;
		}
		if(node.left == null) {
			Values right = subMaxSum(node.right);
			v.maxLive = Math.max(node.val, node.val + right.maxLive);
			v.maxDead = Math.max(v.maxLive, right.maxDead);
		} else if (node.right == null) {
			Values left = subMaxSum(node.left);
			v.maxLive = Math.max(node.val, node.val + left.maxLive);
			v.maxDead = Math.max(v.maxLive, left.maxDead);
		} else {
			Values left = subMaxSum(node.left);
			Values right = subMaxSum(node.right);
			v.maxLive = Math.max(node.val, node.val + left.maxLive);
			v.maxLive = Math.max(v.maxLive, node.val + right.maxLive);
			
			v.maxDead = Math.max(v.maxLive, node.val + left.maxLive + right.maxLive);
			v.maxDead = Math.max(v.maxDead, left.maxDead);
			v.maxDead = Math.max(v.maxDead, right.maxDead);
		}

		return v;
	}
	
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        Values v = subMaxSum(root);
        return v.maxDead;
    }
    
    public static void main(String[] args) {
		//String tree = "{1,2,3,#,#,4,#,#,5}";
		//String tree = "{1,#,2,3}";
		//String tree = "{1,2,2,3,4,4,3}";
		//String tree = "{1,2}";
		//String tree = "{1,2,2,#,3,#,3}";
		//String tree = "{1,2,3,3,#,2,#}";
		//String tree = "{-1,2,3}";
		//String tree = "{-3}";
		//String tree = "{-2,1}";
		String tree = "{-2,6,#,0,-6}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		System.out.println(b.maxPathSum(root));
    }
}
