import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(15213);
		values.add(15213);
		System.out.println(isPalindrome(values));
	}
	
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new Queue<TreeNode>();
		queue.enqueue(root);
		
		while (!queue.isEmpty())
		{
			int length = queue.size();
			ArrayList<Integer> values = new ArrayList<Integer>();
			while (length > 0)
			{
				TreeNode tmp = queue.dequeue();
				values.add(tmp.left == null ? Integer.MAX_VALUE : tmp.left.val);
				values.add(tmp.right == null ? Integer.MAX_VALUE : tmp.right.val);
				queue.enqueue(tmp.left);
				queue.enqueue(tmp.right);
				length --;
			}
			if (!isPalindrome(values))
				return false;
		}
		return true;
	}
	
	private static boolean isPalindrome(ArrayList<Integer> values) {
		int i = 0;
		int j = values.size() - 1;
		while (i < j) 
		{
			if (values.get(i).intValue() != values.get(j).intValue())
				return false;
			i ++;
			j --;
		}
		return true;
	}
	
	public class Queue<T> implements Iterable<T> {
		private Node head, tail;
		private int size = 0;
		public Iterator<T> iterator() {
			return new MyQueueIterator();
		}
		
		public synchronized void enqueue(T item) {
			enqueue(item, false);
		}
		
		public synchronized void enqueue(T item, boolean fromHead) {
			if (item == null)
				return;
			Node newNode = new Node(item);
			if (isEmpty()) {
				head = newNode;
				tail = head;
			} 
			else {
				if (!fromHead) {
					tail.next = newNode;
					tail = tail.next;
				}
				else {
					newNode.next = head;
					head = newNode;
				}
			}
			notifyAll();
			size ++;
		}
		
		public synchronized T dequeue() {
			return dequeue(true);
		}
		
		public synchronized T dequeue(boolean fromHead) {
			if (isEmpty())
				return null;
			
			T item;
			
			if (fromHead) {
				item = head.item;
				head = head.next;
			}
			else {
				if (head == tail) {
					item = tail.item;
					head = null;
					tail = null;
				}
				else {
					Node tmp = head;
					while (tmp.next != tail)
						tmp = tmp.next;
					item = tail.item;
					tmp.next = null;
					tail = tmp;
				}
				
			}
			
			if (isEmpty()) {
				head = null;
				tail = null;
			}
				
			size --;
			notifyAll();
			return item;
		}
		
		public synchronized int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return head == null;
		}
		
		private class Node {
			T item;
			Node next;
			public Node(T item) {
				this.item = item;
			}
		}
		private class MyQueueIterator implements Iterator<T> {
			private Node curr = head;
			
			public boolean hasNext() {
				return curr != null;
			}
			
			public T next() {
				if (curr == null)
					return null;
				T item = curr.item;
				curr = curr.next;
				return item;
			}
			@Override
			public void remove() {
				curr = head;
			}
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}

}
