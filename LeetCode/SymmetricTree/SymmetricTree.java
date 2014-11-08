/*
 * Symmetric Tree 
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 *  
 * But the following is not:
 * 
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		printTree(this, sb);
		return sb.toString();
	}
	
	static void printTree(TreeNode root, StringBuilder sb) {
		if(root.left != null) printTree(root.left, sb);
		sb.append(root.val + " ");
		if(root.right != null) printTree(root.right, sb);
	}
	
	static TreeNode readNode(String str) {
		if(str == null || str.isEmpty()) return null;
		str = str.substring(1, str.length()-1);
		String[] nodes = str.split(",");
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		queue.add(root);
		for(int i=1; i<nodes.length ; i+=2) {
			TreeNode node = queue.remove();
			if(nodes[i].equals("#")) {
				node.left = null;
			} else {
				node.left = new TreeNode(Integer.parseInt(nodes[i]));
				queue.add(node.left);
			}
			if((i+1) >= nodes.length || nodes[i+1].equals("#")) {
				node.right = null;
			} else {
				node.right = new TreeNode(Integer.parseInt(nodes[i+1]));
				queue.add(node.right);
			}
		}
		TreeNode node = queue.poll();
		while(node != null) {
			node.left = null;
			node.right = null;
			node = queue.poll();
		}
		return root;
	}
}

public class SymmetricTree {
	private Random random = new Random();
	
	private boolean onlyOneNull(TreeNode node1, TreeNode node2) {
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)) return true;
		else return false;
	}
	
	/* 
	 * Iteratively 
	 */
	private boolean isSymmetric2(TreeNode root) {
		if(root == null) return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		Queue<TreeNode> leftQueue = new LinkedList<>();
		Queue<TreeNode> rightQueue = new LinkedList<>();
		while(left != null && right != null) {
			if(left.val != right.val) return false;
			if(onlyOneNull(left.left, right.right)) return false;
			if(onlyOneNull(left.right, right.left)) return false;
			if(left.left != null) {
				leftQueue.add(left.left);
				rightQueue.add(right.right);
			}
			if(left.right != null) {
				leftQueue.add(left.right);
				rightQueue.add(right.left);
			}
			left = leftQueue.poll();
			right = rightQueue.poll();
		}
		if(left == null && right == null) return true;
		return false;
	}
	
	private boolean compare(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		return (compare(left.left, right.right) && compare(left.right, right.left));
	}
	
	/*
	 * Recursively
	 */
	private boolean isSymmetric1(TreeNode root) {
		if(root == null) return true;
		return compare(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(random.nextInt()%2 == 0) {
			return isSymmetric1(root);
		} else {
			return isSymmetric2(root);
		}
	}
	
	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();
		//String tree = "{1,2,3,#,#,4,#,#,5}";
		//String tree = "{1,#,2,3}";
		String tree = "{1,2,2,3,4,4,3}";
		//String tree = "{1,2}";
		//String tree = "{1,2,2,#,3,#,3}";
		//String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		System.out.println(s.isSymmetric(root));
	}
}
