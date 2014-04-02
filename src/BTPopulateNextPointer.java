/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BTPopulateNextPointer {

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
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
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
		int length = 0;
		TreeLinkNode tmp = root;
		while (tmp != null)
		{
			length ++;
			tmp = tmp.left;
		}
		
		TreeLinkNode[] nodes = new TreeLinkNode[(int)Math.pow(2, length) - 1];
		nodes[0] = root;
		int start, end;
		for (int i = 0; i < length; i ++)
		{
			start = (int)Math.pow(2, i) - 1;
			end = 2 * start;
			System.out.println(start + "*" + end);
			for (int j = start; j <= end; j ++) 
			{
				if (j == end)
					nodes[j].next = null;
				else
					nodes[j].next = nodes[j + 1];
				if (i < length - 1) {
					nodes[2 * j + 1] = nodes[j].left;
					nodes[2 * j + 2] = nodes[j].right;
				}
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

}
