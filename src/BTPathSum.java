/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTPathSum {

	/**
	 * @param args
	 */
	static int targetSum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n2.right = n3;
		n3.right = n4;
		n4.right = n5;
		System.out.println(hasPathSum(n1, 6));
		
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		targetSum = sum;
		return subRouteSum(root, 0);
	}
	
	private static boolean subRouteSum(TreeNode node, int sum) {
		if (node == null)
			return false;
		sum += node.val;
		if (node.left == null && node.right == null) {
			if (sum == targetSum)
				return true;
			return false;
		}
		return subRouteSum(node.left, sum) | subRouteSum(node.right, sum);
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
