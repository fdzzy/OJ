/*
 * Sum Root to Leaf Numbers 
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 *   
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	if(root == null) return 0;
    	int sum = 0;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.remove();
    		if(node.left == null && node.right == null) {
    			// leaf node
    			sum += node.val;
    			continue;
    		}
    		if(node.left != null) {
    			node.left.val = node.val * 10 + node.left.val;
    			queue.add(node.left);
    		}
    		if(node.right != null) {
    			node.right.val = node.val * 10 + node.right.val;
    			queue.add(node.right);
    		}
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
		// String tree = "{1,2,3,#,#,4,#,#,5}";
		// String tree = "{1,#,2,3}";
		//String tree = "{1,2,2,3,4,4,3,5}";
		//String tree = "{1,2}";
		// String tree = "{1,2,2,#,3,#,3}";
		// String tree = "{1,2,3,3,#,2,#}";
		//String tree = "{1,2,#,3,#,4,#,5}";
		//String tree = "{1,2,3}";
		String tree = "{1,2}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		System.out.println(s.sumNumbers(root));
    }
}
