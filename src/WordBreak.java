import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	static ArrayList<String> result;
	static ArrayList<String> tmp;
	static Set<String> letters, tmpLetters;
	public static void main(String[] args) {
		String s = "ab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");

		wordBreak(s, dict);
	}
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		letters = new HashSet<String>();
		tmpLetters = new HashSet<String>();
		result = new ArrayList<String>();
		tmp = new ArrayList<String>();
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
			return result;

		
		Test(s, dict);
		return result;
	}
	private static void Test(String remain, Set<String> dict) {
		if (remain.equals("")) {
			result.add(ConnectTokens());
			return;
		}
		for (String token : dict) {
			if (remain.startsWith(token)) {
				tmp.add(token);
				
				remain = remain.substring(token.length());
				Test(remain, dict);
				remain = token + remain;
				
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	private static String ConnectTokens() {
		String str = "";
		int index = 0;
		for (String token : tmp) {
			str += token;
			index ++;
			if (index < tmp.size())
				str += " ";
		}
		return str;
	}
}