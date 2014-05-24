/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 3, 5, 6};
		System.out.println(searchInsert(A, 5));
	}
	
	public static int searchInsert(int[] A, int target) {
		if (A.length == 0)
			return 0;
		int index = 0;
		while (index < A.length && A[index ++] < target);
		if (index < A.length)
			return index - 1;
		else if (A[index - 1] < target)
			return index;
		return index - 1;
	}

}
