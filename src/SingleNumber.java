public class SingleNumber {
	public int singleNumber(int[] A) {
		int num = 0;
		for (int i = 0; i < A.length; i ++)
			num ^= A[i];
		return num;
	}
}