/*
 * Construct Binary Tree from Inorder and Postorder Traversal 
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	private TreeNode buildSubTree(int[] inorder, int iLow, int iHigh,
			int[] postorder, int pLow, int pHigh) {
		TreeNode node = new TreeNode(postorder[pHigh]);
		if(pLow == pHigh) {
			return node;
		}
		int i;
		for(i=iLow; i<iHigh ; i++) {
			if(inorder[i] == postorder[pHigh]) break;
		}
		int rightSubTreeSize = iHigh - i;
		if(rightSubTreeSize > 0) {
			node.right = buildSubTree(inorder, i+1, iHigh, 
					postorder, pHigh-rightSubTreeSize, pHigh-1);
		}
		if(i > iLow) {
			node.left = buildSubTree(inorder, iLow, i-1, 
					postorder, pLow, pHigh-rightSubTreeSize-1);
		}
		return node;
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length <= 0 || inorder.length != postorder.length) return null;
    	int len = inorder.length;
    	return buildSubTree(inorder, 0, len-1, postorder, 0, len-1);
    }
    
    public static void main(String[] args) {
    	//int[] preorder = {2,3,1,5,4,7,8};
    	//int[] inorder  = {1,3,5,2,7,4,8};
    	int[] inorder    = {3,5,2,7,4};
    	int[] postorder  = {5,3,7,4,2};
    	ConstructBinaryTreeFromInorderAndPostorderTraversal c = 
    			new ConstructBinaryTreeFromInorderAndPostorderTraversal();
    	TreeNode root = c.buildTree(inorder, postorder);
    	System.out.println(root.toStringPreOrder());
    	System.out.println(root);
    	System.out.println(root.toStringPostOrder());
    }
}
