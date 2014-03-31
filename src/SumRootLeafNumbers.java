/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class SumRootLeafNumbers {
	/**
	 * @param args
	 */
	int sum;

	public int sumNumbers(TreeNode root) {
		sum = 0;
		if (root != null)
			subSum(root, "");
		return sum;
	}
	
	private void subSum(TreeNode node, String s) {
		if (node.left == null && node.right == null) {
			s += Integer.toString(node.val);
			sum += Integer.parseInt(s);
		}
		if (node.left != null)
			subSum(node.left, s.concat(Integer.toString(node.val)));
		if (node.right != null)
			subSum(node.right, s.concat(Integer.toString(node.val)));
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

}
