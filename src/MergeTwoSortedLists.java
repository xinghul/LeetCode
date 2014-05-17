/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newNode = new ListNode(0);
		ListNode tmp = newNode;
		while (l1 != null || l2 != null)
		{
			if (l1 == null) {
				tmp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			else if (l2 == null) {
				tmp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				if (l1.val >= l2.val) {
					tmp.next = new ListNode(l2.val);
					l2 = l2.next;
				}
				else {
					tmp.next = new ListNode(l1.val);
					l1 = l1.next;
				}
			}
			tmp = tmp.next;
		}
		return newNode.next;
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
