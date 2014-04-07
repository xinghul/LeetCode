/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BSTRecover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void recoverTree(TreeNode root) {
		TreeNode f1 = null, f2 = null;
		TreeNode curr, prev, parent = null;
		if (root == null)
			return;
		boolean found = false;
		curr = root;
		
		while (curr != null)
		{
			if (curr.left == null) {
				if (parent != null && parent.val > curr.val) {
					if (!found) {
						f1 = parent;
						found = true;
					}
					f2 = curr;
				}
				parent = curr;
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
					prev.right = null;
					if (parent.val > curr.val) {
						if (!found) {
							f1 = parent;
							found = true;
						}
						f2 = curr;
					}
					parent = curr;
					curr = curr.right;
				}
			}
		}
		if (f1 != null && f2 != null) {
			int tmp = f1.val;
			f1.val = f2.val;
			f2.val = tmp;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int x) {
			val = x;
		}
	}

}
