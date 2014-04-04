import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		MyQueue<TreeNode> queue = new MyQueue<TreeNode>();
		queue.enqueue(root);
		
		while (!queue.isEmpty())
		{
			int length = queue.size;
			ArrayList<Integer> levelValues = new ArrayList<Integer>();
			while (length > 0)
			{
				TreeNode tmp = queue.dequeue();
				levelValues.add(tmp.val);
				queue.enqueue(tmp.left);
				queue.enqueue(tmp.right);
				length --;
			}
			result.add(levelValues);
		}
		
		return result;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
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
