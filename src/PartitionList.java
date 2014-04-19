/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode newNode = partition(n1, 3);
		while (newNode != null)
		{
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}
	
	public static ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		while (head != null) {
			if (head.val < x)
				append(left, head.val);
			else
				append(right, head.val);
			head = head.next;
		}
		ListNode tmp = left;
		while (tmp.next != null)
			tmp = tmp.next;
		tmp.next = right.next;
		return left.next;
	}
	
	private static void append(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		while (head.next != null)
			head = head.next;
		head.next = newNode;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
