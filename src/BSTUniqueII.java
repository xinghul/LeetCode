import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BSTUniqueII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0)
			return generateSubTrees(1, 0);
		return generateSubTrees(1, n);
	}
	
	private ArrayList<TreeNode> generateSubTrees(int start, int end) {
		ArrayList<TreeNode> subTrees = new ArrayList<TreeNode>();
		if (start > end) {
			subTrees.add(null);
			return subTrees;
		}
		
		for (int i = start; i <= end; i ++) 
		{
			ArrayList<TreeNode> leftTrees = generateSubTrees(start, i - 1);
			ArrayList<TreeNode> rightTrees = generateSubTrees(i + 1, end);
			for (int j = 0; j < leftTrees.size(); j ++)
				for (int k = 0; k < rightTrees.size(); k ++)
				{
					TreeNode root = new TreeNode(i);
					root.left = leftTrees.get(j);
					root.right = rightTrees.get(k);
					subTrees.add(root);
				}
		}
		return subTrees;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

}
