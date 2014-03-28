import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
	Map<RandomListNode, RandomListNode> nodes;
	public RandomListNode copyRandomList(RandomListNode head) {
		nodes = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(0);
		RandomListNode tmp1 = head, tmp2 = newHead;
		while (tmp1 != null) {
			RandomListNode newNode = new RandomListNode(tmp1.label);
			
			tmp2.next = newNode;
			nodes.put(tmp1, newNode);
			
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		tmp2 = newHead.next;
		tmp1 = head;	
		while (tmp2 != null) {
			tmp2.random = nodes.get(tmp1.random);
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		return newHead.next;
	}
	class RandomListNode {
		int label;
		RandomListNode next, random;
		public RandomListNode(int x) {
			this.label = x;
		}
	}
}