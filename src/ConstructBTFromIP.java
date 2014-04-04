/**
 * @author xinghul
 *
 */
public class ConstructBTFromIP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {2,1,3};
		int[] postorder = {2,3,1};
		buildTree(inorder, postorder);
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return generateSubRoot(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
	}
	
	public static TreeNode generateSubRoot(int[] inorder, int[] postorder, int start, int end, int rootIndex){
	    if (start > end)  
	    	return null;

	    int index = start;
	    while (inorder[index] != postorder[rootIndex])
	    	index ++;
	    
	    int rightNum = end - index;

	    TreeNode root = new TreeNode(postorder[rootIndex]);

	    root.left = generateSubRoot(inorder, postorder, start, index - 1, rootIndex - rightNum - 1);
	    root.right = generateSubRoot(inorder, postorder, index + 1, end, rootIndex - 1);

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
