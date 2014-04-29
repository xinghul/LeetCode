/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class RemoveDuplicatesSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeDuplicates(int[] A) {
        if (A.length == 0)
			return 0;
		int lastElem = A[0];
		int index = 1;
		for (int i = 1; i < A.length; i ++)
		{
			if (A[i] != lastElem) {
				A[index ++] = A[i];
				lastElem = A[i];
			}
		}
		return index;
    }

}
