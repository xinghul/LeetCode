
/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class LinkedListReverseII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode newNode = reverseBetween(n1, 1, 4);
		while (newNode != null) 
		{
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode start = head, end = head, prev = newHead;
		while (m > 1) 
		{
			start = start.next;
			prev = prev.next;
			m --;
		}
		while (n > 1)
		{
			end = end.next;
			n --;
		}
		ListNode next = start.next, tmp;
		while (prev.next != end) 
		{
			tmp = prev.next;
			prev.next = next;
			start.next = next.next;
			next.next = tmp; 

			next = start.next;
		}
		return newHead.next;
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
