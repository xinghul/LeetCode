/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber(" -."));
	}
	
	public static boolean isNumber(String s) {
		if (s.length() == 0)
			return false;
		int left = 0, right = s.length() - 1;
		while (s.charAt(left) == ' ') 
		{
			left ++;
			if (left >= s.length())
				return false;
		}
		while (s.charAt(right) == ' ')
			right --;
		s = s.substring(left, right + 1);
		if (s.endsWith("e"))
			return false;
		String[] tokens = s.split("e");

		if (tokens.length == 1)
			return isDigit(s, false);
		else if (tokens.length == 2) 
			return isDigit(tokens[0], false) && isDigit(tokens[1], true);
		return false;
	}
	
	private static boolean isDigit(String s, boolean isE) {
		if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
			s = s.substring(1);
		if (s.length() == 0 || s.equals("."))
			return false;
		if (isE && s.indexOf('.') != -1)
			return false;
		
		boolean dotExist = isE;
		for (int i = 0; i < s.length(); i ++) 
		{
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			else if (c == '.') {
				if (!dotExist) {
					dotExist = true;
					continue;
				}
				else if (i == s.length() - 1 && isE)
					continue;
				return false;
			}
			return false;
		}
		return true;
	}

}
