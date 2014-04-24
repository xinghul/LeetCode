import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class LinkedListRemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1 = deleteDuplicates(n1);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		Set<Integer> number = new HashSet<Integer>();
		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode curr = head;
		while (curr != null) 
		{
			if (number.contains(curr.val)) {
				prev.next = curr.next;
			}
			else {
				number.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
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
