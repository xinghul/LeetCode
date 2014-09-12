/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		System.out.println(firstMissingPositive(A));
	}
	
	public static int firstMissingPositive(int[] A) {
		int length = A.length;
		for (int i = 0; i < A.length; i ++)
			if (A[i] > length)
				length = A[i];
		boolean[] exist = new boolean[length];
		for (int i = 0; i < A.length; i ++)
		{
			int index = A[i] - 1;
			if (index < 0)
				continue;
			exist[index] = true;
		}
		for (int i = 0; i < A.length; i ++)
			if (!exist[i])
				return i + 1;
		return A.length + 1;
	}

}
