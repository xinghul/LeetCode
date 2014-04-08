import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		
		TreeNode curr = root, prev;
		while (curr != null)
		{
			if (curr.left == null) {
				result.add(curr.val);
				curr = curr.right;
			}
			else {
				prev = curr.left;
				while (prev.right != null && prev.right != curr)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}
				else {
					result.add(curr.val);
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		return result;
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
