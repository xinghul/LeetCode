
/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTMinDepth {

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
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;
		System.out.println(minDepth(n1));
	}
	
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return subMinDepth(root);
	}
	
	private static int subMinDepth(TreeNode node) {
		if (node.left == null && node.right == null)
			return 1;
		else if (node.left == null)
			return 1 + subMinDepth(node.right);
		else if (node.right == null)
			return 1 + subMinDepth(node.left);
		return 1 + Math.min(subMinDepth(node.left), subMinDepth(node.right));
		
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
