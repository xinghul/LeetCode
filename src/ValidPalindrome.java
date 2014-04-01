public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println((int)'0');
	}
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		if (s.isEmpty())
			return true;
		int i = 0;
		int j = s.length() - 1;
		while (i < j)
		{
			while (i < s.length() && !isAlphaNum(s.charAt(i)))
				i ++;
			while (j >= 0 && !isAlphaNum(s.charAt(j)))
				j --;
			if (i < j && s.charAt(i) != s.charAt(j))
				return false;
			i ++;
			j --;
		}
		return true;
	}
	private boolean isAlphaNum(char c) {
		int asc = (int)c;
		return (asc >= 97 && asc <= 122) || (asc >= 48 && asc <= 57);
	}
}