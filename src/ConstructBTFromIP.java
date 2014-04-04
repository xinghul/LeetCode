import java.util.ArrayList;

/**
 * 
 */

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
		ArrayList<Integer> inArray = new ArrayList<Integer>();
		for (int i = 0; i < inorder.length; i ++)
			inArray.add(inorder[i]);
		ArrayList<Integer> postArray = new ArrayList<Integer>();
		for (int i = 0; i < postorder.length; i ++)
			postArray.add(postorder[i]);
		return getRoot(inArray, postArray, 0, inorder.length - 1);
	}
	
	private static TreeNode getRoot(ArrayList<Integer> inArray, ArrayList<Integer> postArray, int start, int end) {
		if (start > end)
			return null;
		ArrayList<Integer> newInArray = new ArrayList<Integer>(inArray);
		ArrayList<Integer> newPostArray = new ArrayList<Integer>(postArray);
		int val = postArray.get(end);

		int index = newInArray.indexOf(val);
		TreeNode root = new TreeNode(val);
		newInArray.remove(index);
		newPostArray.remove(end);
		
		root.left = getRoot(newInArray, newPostArray, start, index - 1);
		root.right = getRoot(newInArray, newPostArray, index, end - 1);
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
