import java.util.ArrayList;

public class PostOrderTraversal {
	ArrayList<Integer> result;
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		result = new ArrayList<Integer>();
		Visit(root);
		return result;
	}
	
	public void Visit(TreeNode node) {
		if (node == null)
			return;
		Visit(node.left);
		Visit(node.right);
		result.add(node.val);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
}