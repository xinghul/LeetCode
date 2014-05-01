import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class RemoveDuplicatesSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 1, 2, 2, 3};
		System.out.println(removeDuplicates(A));
	}
	
	public static int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		Map<Integer, Boolean> showTwice = new HashMap<Integer, Boolean>();
		int index = 0;
		for (int i = 0; i < A.length; i ++)
		{
			if (showTwice.containsKey(A[i])) {
				if (!showTwice.get(A[i])) {
					showTwice.put(A[i], true);
					A[index ++] = A[i];
				}
			}
			else {
				showTwice.put(A[i], false);
				A[index ++] = A[i];
			}
		}
		return index;
	}

}
