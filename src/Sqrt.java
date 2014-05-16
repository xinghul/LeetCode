/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(1));
	}
	
	public static int sqrt(int x) {
		if (x == 0)
			return 0;
		double prev = 0;
		double curr = 1;
		while (prev != curr) {
			prev = curr;
			curr = (curr + x / curr) / 2;
		}
		return (int)curr;
	}

}
