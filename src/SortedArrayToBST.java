/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		TreeNode root = generateNode(num, 0, num.length - 1);
		return root;
	}
	
	private TreeNode generateNode(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode newNode = new TreeNode(num[mid]);
		newNode.left = generateNode(num, start, mid - 1);
		newNode.right = generateNode(num, mid + 1, end);
		return newNode;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

}
