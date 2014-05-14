/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sortColors(int[] A) {
		int r = -1, w = -1, b = -1;
		for (int i = 0; i < A.length; i ++)
		{
			if (A[i] == 0) {
				A[++ b] = 2;
				A[++ w] = 1;
				A[++ r] = 0;
			}
			else if (A[i] == 1) {
				A[++ b] = 2;
				A[++ w] = 1;
			}
			else 
				A[++ b] = 2;
		}
	}

}
