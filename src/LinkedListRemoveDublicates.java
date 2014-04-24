import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class LinkedListRemoveDublicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);

		n1 = deleteDublicates(n1);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
	
	public static ListNode deleteDublicates(ListNode head) {
		Map<Integer, Boolean> dubNumber = new HashMap<Integer, Boolean>();
		ListNode curr = head;
		while (curr != null) 
		{
			if (!dubNumber.containsKey(curr.val))
				dubNumber.put(curr.val, false);
			else
				dubNumber.put(curr.val, true);
			curr = curr.next;
		}
		ListNode newHead = new ListNode(0), prev;
		newHead.next = head;
		curr = head;
		prev = newHead;
		while (curr != null)
		{
			if (dubNumber.get(curr.val)) {
				prev.next = curr.next;
			}
			else {
				prev = curr;
			}
			curr = curr.next;
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
