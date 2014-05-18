/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 1));
	}
	
	public static String getPermutation(int n, int k) {
		boolean[] used = new boolean[n + 1];
		String result = "";
		int count = n;
		int layer = 1;
		while (k != 0) 
		{
			layer = factor(n - 1);
			if (layer == 0)
				break;
			int index = 1;
			while (used[index]) {
				index ++;
			}
			while (k > layer)
			{
				k -= layer;
				while (used[++index]);
			}
			used[index] = true;
			result += index;
			System.out.println(k + "*" + result);
			n --;
		}
		for (int i = 1; i <= count; i ++)
			if (!used[i])
				result += i;
		return result;
	}
	
	private static int factor(int n) {
		if (n == 0)
			return 0;
		int result = 1;
		while (n > 0)
		{
			result *= n;
			n --;
		}
		return result;
	}

}
