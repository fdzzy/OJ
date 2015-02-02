/*
 * Construct Binary Tree from Preorder and Inorder Traversal 
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	private TreeNode buildSubTree(int[] preorder, int pLow, int pHigh,
			int[] inorder, int iLow, int iHigh) {
		TreeNode node = new TreeNode(preorder[pLow]);
		if(pLow == pHigh) {
			return node;
		}
		int i;
		for(i=iLow; i<iHigh ; i++) {
			if(inorder[i] == preorder[pLow]) break;
		}
		int leftSubTreeSize = i - iLow;
		if(leftSubTreeSize > 0) {
			node.left = buildSubTree(preorder, pLow+1, pLow+leftSubTreeSize, 
					inorder, iLow, i-1);
		}
		if(i < iHigh) {
			node.right = buildSubTree(preorder, pLow+leftSubTreeSize+1, pHigh, 
					inorder, i+1, iHigh);
		}
		return node;
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length <= 0 || preorder.length != inorder.length) return null;
    	int len = preorder.length;
    	return buildSubTree(preorder, 0, len-1, inorder, 0, len-1);
    }
    
    public static void main(String[] args) {
    	//int[] preorder = {2,3,1,5,4,7,8};
    	//int[] inorder  = {1,3,5,2,7,4,8};
    	int[] preorder = {2,3,5,4,7};
    	int[] inorder  = {3,5,2,7,4};
    	ConstructBinaryTreeFromPreorderAndInorderTraversal c = 
    			new ConstructBinaryTreeFromPreorderAndInorderTraversal();
    	TreeNode root = c.buildTree(preorder, inorder);
    	System.out.println(root.toStringPreOrder());
    	System.out.println(root);
    }
}
