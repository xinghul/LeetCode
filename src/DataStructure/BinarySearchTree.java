/**
 * 
 */
package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xinghul
 *
 */
@SuppressWarnings("rawtypes")
class BinarySearchTree implements Iterable {
	public static void main(String[]args) {
		insert(2);
		insert(1);
		insert(-1);
		insert(3);
		System.out.println(MyIterator.inorderTraversal3());
	}
	private static Node root;
	@Override
	public Iterator iterator() {
		return new MyIterator();
	}
	public static synchronized void insert(int val) {
		Node newNode = new Node(val);
		if (root == null) {
			root = newNode;
			return;
		}
		Node tmp = root;
		while (true) 
		{
			if (tmp.val < newNode.val) {
				if (tmp.right == null) {
					tmp.right = newNode;
					return;
				}
				else
					tmp = tmp.right;
			}
			else {
				if (tmp.left == null) {
					tmp.left = newNode;
					return;
				}
				else
					tmp = tmp.left;
			}
		}
	}
	
	private static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	
	
	private static class MyIterator implements Iterator {
		private Node curr = root;
		
		public boolean hasNext() {
			return curr != null;
		}
		
		public Node next() {
			if (curr == null)
				return null;
			return null;
		}
		//inorder traversal without recursion and without stack
		public static ArrayList<Integer> inorderTraversal3() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Node curr, prev;
			if (root == null)
				return result;
			
			curr = root;
			while (curr != null)
			{
				if (curr.left == null) {
					result.add(curr.val);
					curr = curr.right;
				}
				else {
					prev = curr.left;
					while (prev.right != null && prev.right != curr)
						prev = prev.right;
					
					if (prev.right == null) {
						prev.right = curr;
						curr = curr.left;
					}
					//prev.right == curr
					else {
						prev.right = null;
						result.add(curr.val);
						curr = curr.right;
					}
				}
			}
			return result;
		}
		@Override
		public void remove() {
			curr = root;
		}
	}
}
