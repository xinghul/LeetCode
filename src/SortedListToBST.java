import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SortedListToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		while (head != null)
		{
			values.add(head.val);
			head = head.next;
		}
		TreeNode root = generateNode(values, 0, values.size() - 1);
		return root;
	}
	
	private TreeNode generateNode(ArrayList<Integer> values, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode newNode = new TreeNode(values.get(mid));
		newNode.left = generateNode(values, start, mid - 1);
		newNode.right = generateNode(values, mid + 1, end);
		return newNode;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
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
