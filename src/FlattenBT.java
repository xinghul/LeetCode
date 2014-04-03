/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class FlattenBT {

	/**
	 * @param args
	 */
	static TreeNode newRoot, tail;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode tmp = new TreeNode(2);
		root.left = tmp;
		flatten(root);
		while (root != null)
		{
			System.out.println(root.val);
			root = root.right;
		}
	}
	
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		traverse(root);
		root.right = newRoot.right;
		root.left = null;
	}
	
	private static void traverse(TreeNode node) {
		if (node == null)
			return;
		insert(node.val);
		traverse(node.left);
		traverse(node.right);
	}
	
	private static void insert(int val) {
		TreeNode newNode = new TreeNode(val);
		if (newRoot == null) {
			newRoot = newNode;
			tail = newNode;
		}
		else {
			tail.right = newNode;
			tail = tail.right;
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	

}
