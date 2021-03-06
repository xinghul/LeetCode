public class DetectCircle {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}
		if (fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
}