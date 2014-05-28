/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("geeks", "g?eks"));
	}
	
	public static boolean isMatch(String s, String p) {
		int startS = 0, startP = 0;
		boolean star = false;
		int i, j;
		for (i = startS, j = startP; i < s.length(); i ++, j ++)
		{
			if (j < p.length())
				switch (p.charAt(j)) 
				{
				case '?' :
					break;
				case '*' :
					star = true;
					startS = i;
					startP = j;
					while (startP < p.length() && p.charAt(startP) == '*')
						startP ++;
					if (startP == p.length())
						return true;
					i = startS - 1;
					j = startP - 1;
					break;
				default : 
					if (s.charAt(i) != p.charAt(j)) {
						if (!star)
							return false;
						startS ++;
						i = startS - 1;
						j = startP - 1;
					}
				}
			else {
				if (!star)
					return false;
				startS ++;
				i = startS - 1;
				j = startP - 1;
			}
		}
		
		while (j < p.length() && p.charAt(j) == '*')
			j ++;
		return j == p.length();
	}
	
	public static boolean isMatchRecursive(String s, String p) {
		if ((s.length() == 0 && p.length() != 0) || (s.length() != 0 && p.length() == 0))
			return false;
		return matchChar(s, 0, p, 0);
	}
	
	public static boolean matchChar(String s, int i, String p, int j) {
		
		if (i == s.length() && j == p.length())
			return true;
		else if (i == s.length() || j == p.length())
			return false;
		if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
			return matchChar(s, i + 1, p, j + 1);
		if (p.charAt(j) == '*') 
			return matchChar(s, i + 1, p, j) || 
				   matchChar(s, i, p, j + 1) || 
				   matchChar(s, i + 1, p, j + 1);
		return false;
	}

}
