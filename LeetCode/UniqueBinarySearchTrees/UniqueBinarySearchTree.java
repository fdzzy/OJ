/*
 * Unique Binary Search Trees
 * 
 * I.
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * II.
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {

	public int numTrees(int n) {
		if (n < 0)
			return 0;
		List<Integer> results = new ArrayList<>();
		results.add(1); // set f(0) to 1
		results.add(1); // f(1) = 1
		results.add(2); // f(2) = 2

		for (int i = 3; i <= n; i++) {
			int f_i = 0; // f(i)
			for (int j = 0; j <= i - 1; j++) {
				f_i += results.get(j) * results.get(i - 1 - j);
			}
			results.add(f_i);
		}
		return results.get(n);
	}

	private TreeNode copyTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode newRoot = new TreeNode(root.val);
		TreeNode left = copyTree(root.left);
		TreeNode right = copyTree(root.right);
		newRoot.left = left;
		newRoot.right = right;
		return newRoot;
	}

	private List<TreeNode> generatePartialTrees(int n, int from) {
		if (n < 0)
			return null;
		List<TreeNode> trees = new ArrayList<>();
		if (n == 0) {
			trees.add(null);
			return trees;
		} else if (n == 1) {
			trees.add(new TreeNode(from));
			return trees;
		}

		for (int i = 0; i < n; i++) {
			List<TreeNode> leftSubTrees = generatePartialTrees(i, from);
			List<TreeNode> rightSubTrees = generatePartialTrees(n - 1 - i, from + i + 1);
			for (TreeNode left : leftSubTrees) {
				for (TreeNode right : rightSubTrees) {
					TreeNode root = new TreeNode(from + i);
					root.left = copyTree(left);
					root.right = copyTree(right);
					trees.add(root);
				}
			}
		}

		return trees;
	}

	public List<TreeNode> generateTrees(int n) {
		return generatePartialTrees(n, 1);
	}

	public static void main(String[] args) {
		UniqueBinarySearchTree u = new UniqueBinarySearchTree();
		/*for (int i = 0; i < 10; i++) {
			System.out.printf("%d: %d\n", i, u.numTrees(i));
		}*/
		List<TreeNode> trees = u.generateTrees(4);
		System.out.println(trees.size());
		for(TreeNode tree : trees) {
			System.out.printf("%s, %s, %s\n", tree.toStringPreOrder(), tree, tree.toStringPostOrder());
		}
	}

}
