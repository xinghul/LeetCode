/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 2, 3, 5, 1, 2, 3};
		System.out.println(removeElement(A, 1));
	}
	
	public static int removeElement(int[] A, int elem) {
		int count = 0;
		for (int i = 0; i < A.length && i <= A.length - 1 - count; i ++)
		{
			if (A[i] == elem) {
				while (A.length - 1 - count >= i && A[A.length - 1 - count] == elem)
					count ++;
				if (A.length - 1 - count <= i)
					break;
				A[i] = A[A.length - 1 - count];
				count ++;
			}
		}
		
		for (int i = 0; i < A.length - count; i ++)
			System.out.print(A[i] + " ");
		System.out.println();
		return A.length - count;
	}

}
