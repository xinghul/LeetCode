/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTMaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDepth(TreeNode root) {
		return subDepth(root);
	}
	
	private int subDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(subDepth(node.left), subDepth(node.right));
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

}
