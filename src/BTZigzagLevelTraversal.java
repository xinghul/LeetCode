import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTZigzagLevelTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println(zigzagLevelOrder(n1));
	}
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new Queue<TreeNode>();
		
		queue.enqueue(root);
		boolean reverse = false;
		while (!queue.isEmpty())
		{
			ArrayList<Integer> values = new ArrayList<Integer>();
			int length = queue.size();
			while (length > 0) {
				TreeNode tmp = queue.dequeue();
				values.add(tmp.val);
				queue.enqueue(tmp.left);
				queue.enqueue(tmp.right);
				length --;
			}
			if (!reverse) {
				reverse = true;
				result.add(values);
			}
			else {
				reverse = false;
				ArrayList<Integer> reversedValues = new ArrayList<Integer>();
				for (int i = values.size() - 1; i >= 0; i --)
					reversedValues.add(values.get(i));
				result.add(reversedValues);
			}
		}
		return result;
	}
	
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	static class Queue<T> implements Iterable<T> {
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

}
