
/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BSTValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
		return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isValidNode(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		if (node.val > max || node.val < min)
			return false;
		return isValidNode(node.left, min, node.val - 1) && isValidNode(node.right, node.val + 1, max);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}

}
