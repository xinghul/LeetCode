/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class PowXN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(34.00515, -3));
	}
	
	public static double pow(double x, int n) {
		if (n == 0 || x == 1)
			return 1;
		if (x == -1)
		    return n % 2 == 1 ? -1 : 1;
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		double result = 1;
		System.out.println(x);
		while (n -- > 0)
		{
			result *= x;
			if (result == 0)
			    return 0;
		}
		return result;
	}

}
