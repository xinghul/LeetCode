public class ReorderList {
	
	public static void main(String[] args) {
	}
	
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) 
			return;
	    ListNode fast = head;
	    ListNode slow = head;
	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    ListNode reverseHead = slow.next;          
	    slow.next = null;                       
	    reverseHead = reverse(reverseHead);       
	    ListNode curr = head, tmp;        
	    while(reverseHead != null) {         
	        tmp = reverseHead.next;
	        reverseHead.next = curr.next;
	        curr.next = reverseHead;
	        curr = curr.next.next;
	        reverseHead = tmp;
	    }
		
	}
	
	private static ListNode reverse(ListNode head) {
	    if (head == null || head.next == null) 
	    	return head;
	    ListNode prev = new ListNode(0);
	    prev.next = head;
	    head = prev;
	    ListNode curr = prev.next, post;
	    while(curr.next != null) {
	        post = curr.next;
	        curr.next = post.next;
	        post.next = prev.next;
	        prev.next = post;
	    }
	    return prev.next;
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