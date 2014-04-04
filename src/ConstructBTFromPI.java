/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class ConstructBTFromPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return generateSubRoot(preorder, inorder, 0, inorder.length - 1, 0);
	}
	
	public static TreeNode generateSubRoot(int[] preorder, int[] inorder, int start, int end, int rootIndex){
	    if (start > end)  
	    	return null;

	    int index = start;
	    while (inorder[index] != preorder[rootIndex])
	    	index ++;
	    
	    int leftNum = index - start;

	    TreeNode root = new TreeNode(preorder[rootIndex]);

	    root.left = generateSubRoot(preorder, inorder, start, index - 1, rootIndex + 1);
	    root.right = generateSubRoot(preorder, inorder, index + 1, end, rootIndex + leftNum + 1);

	    return root;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
}
