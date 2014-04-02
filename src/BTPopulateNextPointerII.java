import java.util.Iterator;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTPopulateNextPointerII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode n0 = new TreeLinkNode(0);
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n6 = new TreeLinkNode(6);
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n6;
		connect(n0);
		while (n0 != null)
		{
			TreeLinkNode tmp = n0;
			while (tmp != null)
			{
				System.out.print(tmp.val + " ");
				tmp = tmp.next;
			}
			System.out.println();
			n0 = n0.left;
		}
	}
	
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		MyQueue<TreeLinkNode> queue = new MyQueue<TreeLinkNode>();
		queue.enqueue(root);
		
		while (!queue.isEmpty())
		{
			Iterator<TreeLinkNode> it = queue.iterator();
			TreeLinkNode curr = it.next();
			while (curr != null) {
				TreeLinkNode next = it.next();
				curr.next = next;
				curr = curr.next;
			}
			int length = queue.size;
			while (length > 0)
			{
				length --;
				TreeLinkNode tmp = queue.dequeue();
				queue.enqueue(tmp.left);
				queue.enqueue(tmp.right);
			}
		}
	}
	
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	static class MyQueue<T> implements Iterable<T> {
		private Node first, last;
		private int size = 0;
		public Iterator<T> iterator() {
			return new MyQueueIterator();
		}
		
		public synchronized void enqueue(T item) {
			if (item == null)
				return;
			Node newNode = new Node(item);
			if (isEmpty()) {
				first = newNode;
				last = first;
			} 
			else {
				last.next = newNode;
				last = last.next;
			}
			notifyAll();
			size ++;
		}
		
		public synchronized T dequeue() {
			if (isEmpty())
				return null;
			
			T item = first.item;
			first = first.next;
			if (isEmpty())
				last = null;
			size --;
			notifyAll();
			return item;
		}
		
		public synchronized int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return first == null;
		}
		
		private class Node {
			T item;
			Node next;
			public Node(T item) {
				this.item = item;
			}
		}
		private class MyQueueIterator implements Iterator<T> {
			private Node curr = first;
			
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
				curr = first;
			}
		}
	}
}
