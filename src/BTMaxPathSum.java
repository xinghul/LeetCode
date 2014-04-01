import java.util.HashMap;
import java.util.Map;

public class BTMaxPathSum {
	static int maxSum;
	static Map<TreeNode, Integer> subSums;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(-1);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(-4);
		TreeNode n5 = new TreeNode(-5);
		TreeNode n6 = new TreeNode(-6);
		TreeNode n7 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		System.out.println(maxPathSum(n1));
	}
	public static int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		subSums = new HashMap<TreeNode, Integer>();
		traverseNodes(root);
		return maxSum;
	}
	
	private static void traverseNodes(TreeNode node) {
		if (node == null)
			return;
		int tmpLeft = subSum(node.left);
		int tmpRight = subSum(node.right);
		int tmpSum = node.val + tmpLeft + tmpRight;
		
		if (tmpSum > maxSum)
			maxSum = tmpSum;
		traverseNodes(node.left);
		traverseNodes(node.right);
	}
	
	private static int subSum(TreeNode node) {
		if (node == null)
			return 0;
		if (subSums.containsKey(node))
			return subSums.get(node);
		int val = Math.max(node.val + Math.max(Math.max(subSum(node.left), subSum(node.right)), 0), 0);
		subSums.put(node, val);
		return val;
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