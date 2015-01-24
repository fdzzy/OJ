import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public int getVal() {
		return val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		printTreeInOrder(this, sb);
		return sb.toString();
	}
	
	public String toStringPreOrder() {
		StringBuilder sb = new StringBuilder();
		printTreePreOrder(this, sb);
		return sb.toString();
	}
	
	public String toStringPostOrder() {
		StringBuilder sb = new StringBuilder();
		printTreePostOrder(this, sb);
		return sb.toString();
	}
	
	public static void printTreeInOrder(TreeNode root, StringBuilder sb) {
		if(root.left != null) printTreeInOrder(root.left, sb);
		sb.append(root.val + " ");
		if(root.right != null) printTreeInOrder(root.right, sb);
	}
	
	public static void printTreePreOrder(TreeNode root, StringBuilder sb) {
		sb.append(root.val + " ");
		if(root.left != null) printTreePreOrder(root.left, sb);
		if(root.right != null) printTreePreOrder(root.right, sb);
	}
	
	public static void printTreePostOrder(TreeNode root, StringBuilder sb) {
		if(root.left != null) printTreePostOrder(root.left, sb);
		if(root.right != null) printTreePostOrder(root.right, sb);
		sb.append(root.val + " ");
	}
	
	public static TreeNode readNode(String str) {
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

	public static void main(String[] args) {
		//String tree = "{1,2,3,#,#,4,#,#,5}";
		//String tree = "{1,#,2,3}";
		String tree = "{1,2,2,3,4,4,3}";
		//String tree = "{1,2}";
		//String tree = "{1,2,2,#,3,#,3}";
		//String tree = "{1,2,3,3,#,2,#}";
		TreeNode root = TreeNode.readNode(tree);
		System.out.println(root);
	}

}
