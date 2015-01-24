/*
 * Validate Binary Search Tree 
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
    	if (root.left != null) {
    		TreeNode left = root.left;
    		while (left.right != null) left = left.right;
    		if (root.val <= left.val) return false;
    	}
    	if (root.right != null) {
    		TreeNode right = root.right;
    		while (right.left != null) right = right.left;
    		if (root.val >= right.val) return false;
    	}
    	if (isValidBST(root.left) && isValidBST(root.right)) return true;
    	else return false;
    }
    
    public List<Integer> inorderTraversalEtraBuf(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> stack = new Stack<>();
    	
    	stack.push(root);
    	while(!stack.empty()) {
    		TreeNode node = stack.pop();
    		if(node.left != null) {
    			// make a copy of node that null'ed left
    			TreeNode copy = new TreeNode(node.val);
    			copy.right = node.right;
    			stack.push(copy);
    			stack.push(node.left);
    		} else {
    			result.add(node.val);
    			if(node.right != null) {
    				stack.push(node.right);
    			}
    		}
    	}
    	
    	return result;
    }

    public boolean isValidBST2(TreeNode root) {
    	List<Integer> result = inorderTraversalEtraBuf(root);
    	for(int i=0; i<result.size()-1 ; i++) {
    		if(result.get(i) >= result.get(i+1)) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		//String tree = "{1,2,3,#,#,4,#,#,5}";
		//String tree = "{1,#,2,3}";
		//String tree = "{1,2,2,3,4,4,3}";
		//String tree = "{1,2}";
		String tree = "{2,1,3}";
    	//String tree = "{1,1}";
		//String tree = "{1,2,2,#,3,#,3}";
		//String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		System.out.println(v.isValidBST(root));
		System.out.println(v.isValidBST2(root));
    }
	
}
