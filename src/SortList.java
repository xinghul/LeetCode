

public class SortList {
	public static void main(String[] args) {
		int[] array = {1, 3, 2, 4};
		ListNode head = InitList(array);
		

		ListNode newHead = sortList(head);
		PrintList(newHead);
	}
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode preSlow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			preSlow = slow;
			slow = slow.next;
		}
		
		preSlow.next = null;
		
		ListNode first = sortList(head);
		ListNode second = sortList(slow);
		ListNode dummy = new ListNode(-1);
		ListNode dummyCur = dummy;
		while (first != null && second != null) {
			if (first.val < second.val) {
				dummyCur.next = first;
				first = first.next;
			} else if (second.val<=first.val) {
				dummyCur.next = second;
				second = second.next;
			}
			dummyCur = dummyCur.next;
		}
		
		while (first != null) {
			dummyCur.next = first;
			first = first.next;
			dummyCur = dummyCur.next;
		}
		
		while(second != null){
			dummyCur.next = second;
			second = second.next;
			dummyCur = dummyCur.next;
		}
		
		return dummy.next;
    }
	
	public static ListNode InitList(int[] array) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 0; i < array.length; i ++) {
			curr.next = new ListNode(array[i]);
			curr = curr.next;
		}
		return head.next;
	}
	public static void PrintList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
}