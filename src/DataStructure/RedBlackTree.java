/**
 * 
 */
package DataStructure;

/**
 * @author Xinghu
 *
 */
public class RedBlackTree<K extends Comparable<K>, V> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private TreeNode root, nil;
	private static boolean RED = true;
	private static boolean BLACK = false;
	
	public RedBlackTree() {
		root = null;
		nil = null;
	}
	
	private class TreeNode {
		private K key;
		private V value;
		private TreeNode parent, left, right;
		private boolean color;
		
		public TreeNode(K key, V value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
			parent = null;
			left = null;
			right = null;
		}
	}
	
	/*
	 *            |                                |
	 *            y   <-------RotateLeft(x)------  x
	 *           / \  --------RotateRight(x)----> / \
	 *          x   r                            a   y
	 *         / \                                  / \
	 *        a   b                                b   r
	 */
	public void RotateLeft(TreeNode x) {
		TreeNode y = x.right;
		assert y != nil;
		x.right = y.left;
		if (y.left != nil)
			y.left.parent = x;
		
		y.parent = x.parent;
		if (y.parent == nil)
			root = y;
		else if (y.parent.left == x)
			y.parent.left = y;
		else
			y.parent.right = y;
		y.left = x;
		x.parent = y;
	}
	
	public void RotateRight(TreeNode y) {
		TreeNode x = y.left;
		assert x != nil;
		y.left = x.right;
		if (x.right != nil)
			x.right.parent = y;
		
		x.parent = y.parent;
		if (x.parent == nil)
			root = x;
		else if (x.parent.left == y)
			x.parent.left = x;
		else
			x.parent.right = x;
		x.right = y;
		y.parent = x;
	}
	
	public void Insert(TreeNode z) {
		TreeNode y = nil;
		TreeNode x = root;
		
		while (x != nil)
		{
			y = x;
			if (z.key.compareTo(x.key) == -1)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;
		if (y == nil)
			root = z;
		else if (z.key.compareTo(y.key) == -1)
			y.left = z;
		else
			y.right = z;
		z.left = nil;
		z.right = nil;
		z.color = RED;
		InsertFixup(z);
	}
	
	private void InsertFixup(TreeNode z) {
		
	}
}