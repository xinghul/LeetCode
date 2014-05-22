/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(A));
	}
	
	public static int maxSubArray(int[] A) {
		int sum = A[0], max = A[0];
		int sumMin = sum > 0 ? 0 : sum;
		
		for (int i = 1; i < A.length; i ++)
		{
			sum += A[i];
			if (max < sum - sumMin)
				max = sum - sumMin;
			if (sum < sumMin)
				sumMin = sum;
		}
		return max;
	}
	
	public static int maxSubArrayN2(int[] A) {
		int sum, max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i ++)
		{
			sum = 0;
			for (int j = i; j < A.length; j ++)
			{
				sum += A[j];
				if (sum < 0) 
					break;
				if (sum > max)
					max = sum;
			}
		}
		return max;
	}

}
