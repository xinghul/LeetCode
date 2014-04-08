/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class BSTUnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(7));
		System.out.println(factor(7) * factor(8));
		System.out.println(factor(14));
	}
	
	public static int numTrees(int n) {
		double result = factor(2 * n) / (factor(n + 1) * factor(n));
		return (int)result;
	}
	
	private static double factor(int n) {
		if (n <= 1)
			return 1;
		return n * factor(n - 1);
	}

}
