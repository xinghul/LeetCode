/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -123;
		System.out.println(reverse(x));
	}
	
	public static int reverse(int x) {
		String s = Integer.toString(x);
		boolean isNegative = false;
		if (s.startsWith("-")) {
			isNegative = true;
			s = s.substring(1);
		}
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length / 2; i ++)
		{
			char tmp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = tmp;
		}
		String reversedS = new String(c);
		int result = Integer.parseInt(reversedS);
		if (isNegative)
			return -result;
		return result;
	}

}
