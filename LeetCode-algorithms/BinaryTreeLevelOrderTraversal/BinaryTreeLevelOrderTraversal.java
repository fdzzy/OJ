/*
 * Binary Tree Level Order Traversal 
 * 
 * I.
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  
 * return its level order traversal as:
 * 
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 
 * II.
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  
 * return its bottom-up level order traversal as:[
 * 
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(root == null) return results;
    	
    	Queue<TreeNode> nodeQueue = new LinkedList<>();
    	Queue<Integer> levelQueue = new LinkedList<>();
    	nodeQueue.add(root);
    	levelQueue.add(1);
    	int currentLevel = 1;
    	List<Integer> result = new ArrayList<>();
    	
    	while(!nodeQueue.isEmpty()) {
    		TreeNode node = nodeQueue.remove();
    		int level = levelQueue.remove();
    		if(level != currentLevel) {
    			results.add(result);
    			currentLevel++;
    			result = new ArrayList<>();
    		}
    		result.add(node.val);
    		if(node.left != null) {
    			nodeQueue.add(node.left);
    			levelQueue.add(level + 1);
    		}
    		if(node.right != null) {
    			nodeQueue.add(node.right);
    			levelQueue.add(level + 1);
    		}
    	}
    	if(!result.isEmpty()) results.add(result);
       
    	return results;
    }

    public List<List<Integer>> levelOrderReverse(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(root == null) return results;
    	
    	Queue<TreeNode> nodeQueue = new LinkedList<>();
    	Queue<Integer> levelQueue = new LinkedList<>();
    	nodeQueue.add(root);
    	levelQueue.add(1);
    	Stack<TreeNode> nodeStack = new Stack<>();
    	Stack<Integer> levelStack = new Stack<>();
    	
    	while(!nodeQueue.isEmpty()) {
    		TreeNode node = nodeQueue.remove();
    		int level = levelQueue.remove();
    		nodeStack.push(node);
    		levelStack.push(level);
    		// right first
    		if(node.right != null) {
    			nodeQueue.add(node.right);
    			levelQueue.add(level + 1);
    		}
    		if(node.left != null) {
    			nodeQueue.add(node.left);
    			levelQueue.add(level + 1);
    		}
    	}
    	
    	int currentLevel = levelStack.peek();
    	List<Integer> result = new ArrayList<>();
    	while(!nodeStack.isEmpty()) {
    		TreeNode node = nodeStack.pop();
    		int level = levelStack.pop();
    		if(level != currentLevel) {
    			results.add(result);
    			result = new ArrayList<>();
    			currentLevel--;
    		}
    		result.add(node.val);
    	}
    	if(!result.isEmpty()) results.add(result);
       
    	return results;
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
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		System.out.println(b.levelOrder(root));
		System.out.println(b.levelOrderReverse(root));
    }
}
