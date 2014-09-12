/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 3, 1, 1, 4};
		System.out.println(jump(A));
	}
	
	public static int jump(int[] A) {
		if (A.length <= 1)
			return 0;
		int[] minNum = new int[A.length];
		int count = 0;
		minNum[A.length - 1] = 0;
		for (int i = 0; i < A.length - 1; i ++)
		{
			minNum[i] = -1;
		}
		boolean found = false;
		for (int i = A.length - 1; i >= 0; i --)
		{
			if (minNum[i] == count) {
				for (int j = 0; j < i; j ++)
				{
					if (minNum[j] == -1 && i - j <= A[j]) {
						minNum[j] = count + 1;
						if (j == 0) {
							found = true;
							break;
						}
					}
				}
			}
			if (found)
				break;
			else if (i == 0) {
				count ++;
				i = A.length;
			}
		}
		
		return minNum[0];
	}

}
