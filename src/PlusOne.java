/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0 ; i --) {
			if (carry == 0)
				break;
			digits[i] += carry;
			if (digits[i] == 10) {
				digits[i] = 0;
				carry = 1;
			}
			else
				carry = 0;
		}
		if (carry == 1) {
			int[] newDigits = new int[digits.length + 1];
			for (int i = 0; i < digits.length; i ++)
				newDigits[i + 1] = digits[i];
			newDigits[0] = 1;
			return newDigits;
		}
		return digits;
	}

}
