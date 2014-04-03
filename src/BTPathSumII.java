import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTPathSumII {

	/**
	 * @param args
	 */
	static int targetSum;
	static ArrayList<ArrayList<Integer>> result;
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
		pathSum(n1, 22);
		System.out.println(result);
	}
	
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		targetSum = sum;
		subPathSum(root, 0, new ArrayList<Integer>());
		return result;
	}
	
	private static void subPathSum(TreeNode node, int sum, ArrayList<Integer> path) {
		if (node == null)
			return;
		sum += node.val;
		path.add(node.val);
		if (node.left == null && node.right == null) {
			if (sum == targetSum) {
				result.add(path);
				return;
			}
		}
		ArrayList<Integer> path1 = new ArrayList<Integer>(path);
		ArrayList<Integer> path2 = new ArrayList<Integer>(path);
		subPathSum(node.left, sum, path1);
		subPathSum(node.right, sum, path2);
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}

}
