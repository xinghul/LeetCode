/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head = rotateRight(head, 1);
	}
	
	public static ListNode rotateRight(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;
		int length = 0;
		ListNode tmp = head;
		while (tmp != null)
		{
			length ++;
			tmp = tmp.next;
		}

		n = n % length;
		int offset = length - n;
		if (offset == length)
			return head;
		
		ListNode right = head, left = head;
		while (offset > 0)
		{
			left = right;
			right = right.next;
			offset --;
		}
		
		left.next = null;
		tmp = right;
		while (tmp.next != null)
			tmp = tmp.next;
		tmp.next = head;
		
		return right;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
