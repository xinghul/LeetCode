import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreakT {
	ArrayList<String> result;
	Set<String> letters;
	Set<String> tmpLetters;
	public boolean wordBreak(String s, Set<String> dict) {
	    letters = new HashSet<String>();
		tmpLetters = new HashSet<String>();
		result = new ArrayList<String>();

		for (int i = 0; i < s.length(); i ++) {
			letters.add(Character.toString(s.charAt(i)));
			tmpLetters.add(Character.toString(s.charAt(i)));
		}

		for (String token : dict) {
			for (String letter : letters) {
				if (token.contains(letter)) {
					tmpLetters.remove(letter);
				}
			}
			if (tmpLetters.isEmpty())
				break;
		}
		if (!tmpLetters.isEmpty())
			return false;
		
		return Test(s, dict);
	}
	private boolean Test(String remain, Set<String> dict) {
		if (remain.equals("")) {
			return true;
		}
		for (String token : dict) {
			if (remain.startsWith(token)) {
				remain = remain.substring(token.length());
				boolean possible = Test(remain, dict);
				if (possible)
					return true;
				remain = token + remain;
			}
		}
		return false;
	}
}