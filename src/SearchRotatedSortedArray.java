/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SearchRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] A, int target) {
		for (int i = 0; i < A.length; i ++)
			if (A[i] == target)
				return i;
		return -1;
	}

}
