/*
 * Convert Sorted Array to Binary Search Tree 
 * 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
	
	private TreeNode buildSubTree(int[] num, int from, int to) {
		if(from > to || from >= num.length) return null;
		int middle = (from + to) / 2;
		TreeNode node = new TreeNode(num[middle]);
		node.left = buildSubTree(num, from, middle-1);
		node.right = buildSubTree(num, middle+1, to);
		return node;
	}

    public TreeNode sortedArrayToBST(int[] num) {
        return buildSubTree(num, 0, num.length-1);
    }
    
    public static void main(String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8,9};
    	ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
    	TreeNode root = c.sortedArrayToBST(num);
    	System.out.println(root.toStringPreOrder());
    	System.out.println(root);
    	System.out.println(root.toStringPostOrder());
    	
    }
}
