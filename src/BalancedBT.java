/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BalancedBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		TreeNode n11 = new TreeNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;
		n2.right = n11;
		System.out.println(isBalanced(n1));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return isSubBalanced(root);
	}
	
	private static boolean isSubBalanced(TreeNode node) {
		if (node == null)
			return true;
		if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) {
			return false;
		}
		return isSubBalanced(node.left) && isSubBalanced(node.right);
	}
	private static int getDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}

}
