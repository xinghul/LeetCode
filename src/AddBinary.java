/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
	}
	
	public static String addBinary(String a, String b) {
		int lengthA = a.length(), lengthB = b.length();
		int index = 1;
		String result = "";
		int carry = 0;
		while ((lengthA - index) >= 0 || (lengthB - index) >= 0)
		{
			int cA = 0, cB = 0;
			if ((lengthA - index) >= 0)
				cA = a.charAt(lengthA - index) - 48;
			if ((lengthB - index) >= 0)
				cB = b.charAt(lengthB - index) - 48;
			
			int sum = cA + cB + carry;
			carry = sum >= 2 ? 1 : 0;
			
			result = sum % 2 + result;
			
			index ++;
		}
		if (carry == 1)
			result = carry + result;
		return result;
	}

}
