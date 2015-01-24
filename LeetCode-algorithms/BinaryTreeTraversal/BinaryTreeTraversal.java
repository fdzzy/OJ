/*
 * Iterative traversal of binary tree
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
	
	private void dumbPreorderTraversal(TreeNode root, List<Integer> result) {
		result.add(root.getVal());
		if(root.getLeft() != null) dumbPreorderTraversal(root.getLeft(), result);
		if(root.getRight() != null) dumbPreorderTraversal(root.getRight(), result);
	}

    public List<Integer> dumbPreorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	dumbPreorderTraversal(root, result);
    	return result;
    }
    
	private void dumbPostorderTraversal(TreeNode root, List<Integer> result) {
		if(root.getLeft() != null) dumbPostorderTraversal(root.getLeft(), result);
		if(root.getRight() != null) dumbPostorderTraversal(root.getRight(), result);
		result.add(root.getVal());
	}

    public List<Integer> dumbPostorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	dumbPostorderTraversal(root, result);
    	return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> stack = new Stack<>();
    	
    	stack.add(root);
    	while(!stack.empty()) {
    		TreeNode node = stack.pop();
    		result.add(node.val);
    		if(node.right != null) stack.add(node.right);
    		if(node.left != null) stack.add(node.left);
    	}
    	
    	return result;
    }
    
    private int leftChildCount(TreeNode node) {
    	if(node == null) return 0;
    	int count = 0;
    	if(node.left != null) count++;
    	return count;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> nodeStack = new Stack<>();
    	Stack<Integer> countStack = new Stack<>();
    	
    	nodeStack.push(root);
    	countStack.push(leftChildCount(root));
    	while(!nodeStack.empty() && !countStack.empty()) {
    		TreeNode node = nodeStack.pop();
    		int count = countStack.pop(); 
    		if(count == 0) {
    			result.add(node.val);
    			if(node.right != null) {
    				nodeStack.push(node.right);
    				countStack.push(leftChildCount(node.right));
    			}
    		} else {
    			if(node.left != null) {
    				// push parent node back
    				nodeStack.push(node);
    				// decrement count of parent node
    				countStack.push(--count);
    				// handling of left node
    				nodeStack.push(node.left);
    				countStack.push(leftChildCount(node.left));
    			}
    		}
    	}
    	
    	return result;
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
    
    private int childCount(TreeNode node) {
    	if(node == null) return 0;
    	int count = 0;
    	if(node.left != null) count++;
    	if(node.right != null) count++;
    	return count;
    }
    
    public List<Integer> postOrderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> nodeStack = new Stack<>();
    	Stack<Integer> countStack = new Stack<>();
    	
    	nodeStack.push(root);
    	countStack.push(childCount(root));
    	while(!nodeStack.empty() && !countStack.empty()) {
    		TreeNode node = nodeStack.peek();
    		int count = countStack.pop(); 
    		if (count == 2) {
   				// decrement count of parent node
    			countStack.push(--count);
    			// if count is 2, push left
    			nodeStack.push(node.left);
    			countStack.push(childCount(node.left));
    		} else if (count == 1) {
    			// whatsoever, decrement count
    			countStack.push(--count);
    			if (childCount(node) == 2) {
    				// obviously, left has been printed, push right
    				nodeStack.push(node.right);
    				countStack.push(childCount(node.right));
    			} else { // must be (childCount(node) == 1)
    				if (node.left != null) {
    					nodeStack.push(node.left);
    					countStack.push(childCount(node.left));
    				} else {
    					nodeStack.push(node.right);
    					countStack.push(childCount(node.right));
    				}
    				
    			}
    		} else {
    			result.add(node.val);
    			nodeStack.pop();
    		}
    	}
    	
    	return result;
    }

    public List<Integer> postOrderTraversalEtraBuf(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> stack = new Stack<>();
    	
    	stack.push(root);
    	while(!stack.empty()) {
    		TreeNode node = stack.pop();
    		if (node.left != null) {
    			// make a copy of node that null'ed left
    			TreeNode copy = new TreeNode(node.val);
    			copy.right = node.right;
    			stack.push(copy);
    			stack.push(node.left);
    		} else if (node.right != null) {
    			// make a copy of node the null'ed right
    			TreeNode copy = new TreeNode(node.val);
    			stack.push(copy);
    			stack.push(node.right);
    		} else {
    			result.add(node.val);
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		//String tree = "{1,2,3,#,#,4,#,#,5}";
		//String tree = "{1,#,2,3}";
		//String tree = "{1,2,2,3,4,4,3}";
		//String tree = "{1,2}";
		String tree = "{1,2,2,#,3,#,3}";
		//String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		BinaryTreeTraversal b = new BinaryTreeTraversal();
		List<Integer> result1 = b.dumbPreorderTraversal(root);
		List<Integer> result2 = b.preorderTraversal(root);
		System.out.println(result1);
		System.out.println(result2);
		List<Integer> result3 = b.inorderTraversal(root);
		List<Integer> result4 = b.inorderTraversalEtraBuf(root);
		System.out.println(result3);
		System.out.println(result4);
		List<Integer> result5 = b.dumbPostorderTraversal(root);
		List<Integer> result6 = b.postOrderTraversalEtraBuf(root);
		List<Integer> result7 = b.postOrderTraversal(root);
		System.out.println(result5);
		System.out.println(result6);
		System.out.println(result7);
    }

}
