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
	/*
	 * 3 cases:
	 * 		case 1 : z's left child is nil, replace z with z's right child
	 * 		case 2 : z's right child is nil, replace z with z's left child
	 * 		case 3 : both z's left and right child are not nil, 
	 * 				 replace z with z's successor, 
	 * 				 which is z's left-most child in z's right branch
	 * 			case 3.1 : if y is z's child, nothing to be done
	 * 			case 3.2 : otherwise, replace y with y's right child,
	 * 					   (note that y's left child is nil)
	 * 					   and replace z with y
	 */
	public void Delete(TreeNode z) {
		TreeNode y = z, x;
		boolean originColorY = y.color;
		if (z.left == nil) {
			//case 1
			x = z.right;
			Transplant(z, z.right);
		}
		else if (z.right == nil) {
			//case 2
			x = z.left;
			Transplant(z, z.left);
		}
		else {
			//case 3
			y = TreeMinimum(z.right);
			originColorY = y.color;
			x = y.right;
			if (y.parent == z)
				//case 3.1
				x.parent = y;
			else {
				//case 3.2
				Transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			Transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if (originColorY == BLACK)
			DeleteFixup(x);
	}
	
	/*
	 *            |                                |
	 *            y   <-------RotateLeft(x)------  x
	 *           / \  --------RotateRight(x)----> / \
	 *          x   r                            a   y
	 *         / \                                  / \
	 *        a   b                                b   r
	 */
	private void RotateLeft(TreeNode x) {
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
	
	private void RotateRight(TreeNode y) {
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
	
	/*
	 * Things got complicated now.
	 * 6 cases in total:
	 * 		case 1 : z's parent is a left child
	 * 			case 1.1 : z's uncle y is red
	 * 			case 1.2 : z's uncle y is black and z is a right child
	 * 			case 1.3 : z's uncle y is black and z is a left child
	 * 		case 2 : z's parent is a right child
	 * 			case 2.1 : ...
	 * 			case 2.2 : ...
	 * 			case 2.3 : ...
	 */
	private void InsertFixup(TreeNode z) {
		TreeNode y;
		while (z.parent.color == RED)
		{
			if (z.parent == z.parent.parent.left) {
				//case 1
				y = z.parent.parent.right;
				if (y.color == RED) {
					//case 1.1
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.right) {
						//case 1.2
						z = z.parent;
						RotateLeft(z);
					}
					//case 1.3
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					RotateRight(z.parent.parent);
				}
			}
			else {
				//case 2
				y = z.parent.parent.left;
				if (y.color == RED) {
					//case 2.1
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.left) {
						//case 2.2
						z = z.parent;
						RotateRight(z);
					}
					//case 2.3
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					RotateLeft(z.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}
	
	private void DeleteFixup(TreeNode x) {
		TreeNode w;
		while (x != root && x.color == BLACK)
		{
			if (x == x.parent.left) {
				w = x.parent.right;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					RotateLeft(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				}
				else {
					if (w.right.color == BLACK) {
						w.left.color = BLACK;
						w.color = RED;
						RotateRight(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.right.color = BLACK;
					RotateLeft(x.parent);
					x = root;
				}
				
			}
			else {
				w = x.parent.left;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					RotateRight(x.parent);
					w = x.parent.left;
				}
				if (w.right.color == BLACK && w.left.color == BLACK) {
					w.color = RED;
					x = x.parent;
				}
				else {
					if (w.left.color == BLACK) {
						w.right.color = BLACK;
						w.color = RED;
						RotateLeft(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.left.color = BLACK;
					RotateRight(x.parent);
					x = root;
				}
				
			}
		}
		x.color = BLACK;
	}
	
	private void Transplant(TreeNode u, TreeNode v) {
		if (u.parent == nil)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		v.parent = u.parent;
	}
	
	private TreeNode TreeMinimum(TreeNode x) {
		while (x.left != nil)
			x = x.left;
		return x;
	}
}
