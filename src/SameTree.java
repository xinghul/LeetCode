/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSameNode(p, q);
	}
	
	private boolean isSameNode(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		else if (node1 == null || node2 == null)
			return false;
		else if (node1.val != node2.val)
			return false;
		return isSameNode(node1.left, node2.left) && isSameNode(node1.right, node2.right);
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
