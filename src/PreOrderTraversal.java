import java.util.ArrayList;

public class PreOrderTraversal {
	ArrayList<Integer> result;
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		result = new ArrayList<Integer>();
		Visit(root);
		return result;
	}
	
	public void Visit(TreeNode node) {
		if (node == null)
			return;
		result.add(node.val);
		Visit(node.left);
		Visit(node.right);
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