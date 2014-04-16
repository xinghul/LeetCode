/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 3;
		A[2] = 4;
		A[3] = 9;
		int[] B = {2, 5, 6, 7};
		merge(A, 4, B, 4);

	}
	public static void merge(int A[], int m, int B[], int n) {
		int[] C = new int[m];
		for (int k = 0; k < m; k ++)
			C[k] = A[k];
		int i = 0, j = 0;
		while ((i < m) || (j < n))
		{
			if (i == m) {
				A[i + j] = B[j];
				j ++;
			}
			else if (j == n) {
				A[i + j] = C[i];
				i ++;
			}
			else {
				if (C[i] > B[j]) {
					A[i + j] = B[j];
					j ++;
				}
				else {
					A[i + j] = C[i];
					i ++;
				}
			}
		}
	}

}
