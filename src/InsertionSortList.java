public class InsertionSortList {
	public static void main(String[] args) {
		int[] array = {4,19,14,5,-3,1,8,5,11,15};
		ListNode head = InitList(array);
		
		ListNode newHead = insertionSortList(head);
		PrintList(newHead);
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
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(head.val);
		ListNode curr, prev, tmp;
		head = head.next;
		
		while (head != null) {
			tmp = head;
			curr = newHead;
			prev = newHead;
			while (curr != null && curr.val < tmp.val) {
				prev = curr;
				curr = curr.next;
			}
			if (curr == newHead) {
				ListNode newNode = new ListNode(tmp.val);
				newNode.next = newHead;
				newHead = newNode;
			} else {
				prev.next = new ListNode(tmp.val);
				prev.next.next = curr;
			}
			head = head.next;
		}
		
		return newHead;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}