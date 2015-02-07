/*
 * Path Sum 
 * 
 * I.
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
 * that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * 
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * II.
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum 
 * equals the given sum.
 * 
 * For example:
 * 
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 */
import java.util.ArrayList;
import java.util.List;

public class PathSum {
	private boolean subSum(int current, TreeNode node, int sum) {
		if(node.left == null && node.right == null) {
			// this is a leaf
			if((current + node.val) == sum) return true;
			else return false;
		}
		if(node.left == null) {
			return subSum(current+node.val, node.right, sum);
		} else if (node.right == null) {
			return subSum(current+node.val, node.left, sum);
		} else {
			if(subSum(current+node.val, node.left, sum) || 
			   subSum(current+node.val, node.right, sum))
				return true;
			else 
				return false;
		}
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	return subSum(0, root, sum);
    }
    
    private void subSumII(List<List<Integer>> results, int current, List<Integer> path, 
    		TreeNode node, int sum) {
    	List<Integer> newPath = new ArrayList<>(path);
    	newPath.add(node.val);
    	if(node.left == null && node.right == null) {
    		// this is a leaf
    		if((current + node.val) == sum) {
    			results.add(newPath);
    		} 
    	} else if (node.left == null) {
    		subSumII(results, current+node.val, newPath, node.right, sum);
    	} else if (node.right == null) {
    		subSumII(results, current+node.val, newPath, node.left, sum);
    	} else {
    		subSumII(results, current+node.val, newPath, node.right, sum);
    		subSumII(results, current+node.val, newPath, node.left, sum);
    	}
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(root == null) return results;
    	List<Integer> path = new ArrayList<>();
    	subSumII(results, 0, path, root, sum);
    	return results;
    }
    
    public static void main(String[] args) {
		//String tree = "{5,4,8,11,#,13,4,7,2,#,#,5,1}";
    	String tree = "{22}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
		PathSum p = new PathSum();
		System.out.println(p.hasPathSum(root, 22));
		System.out.println(p.pathSum(root, 22));
		
		/*List<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(2);
		List<Integer> b = new ArrayList<>(a);
		b.add(1);
		System.out.println(a);
		System.out.println(b);*/
    }
}
