import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		int[] index = new int[strs.length];
		String[] sortedStrs = new String[strs.length];
		HashMap<String, Boolean> anagram = new HashMap<String, Boolean>();
		for (int i = 0; i < strs.length; i ++)
		{
			index[i] = i;
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			sortedStrs[i] = new String(c);
			if (anagram.containsKey(sortedStrs[i]))
				anagram.put(sortedStrs[i], true);
			else
				anagram.put(sortedStrs[i], false);
		}
		for (int i = 0; i < sortedStrs.length; i ++)
		{
			if (anagram.get(sortedStrs[i]))
				result.add(strs[i]);
		}
		return result;
	}
	
	public ArrayList<String> anagramsN2(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		boolean[] included = new boolean[strs.length];
		for (int i = 0; i < strs.length; i ++)
		{
			if (included[i])
				continue;
			for (int j = i + 1; j < strs.length; j ++) 
			{
				if (included[j])
					continue;
				if (isAnagram(strs[i], strs[j])) {
					result.add(strs[i]);
					result.add(strs[j]);
					included[i] = true;
					included[j] = true;
				}
			}
		}
		return result;
	}
	
	private boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] s1c = s1.toCharArray();
		Arrays.sort(s1c);
		char[] s2c = s2.toCharArray();
		Arrays.sort(s2c);
		for (int i = 0; i < s1c.length; i ++)
			if (s1c[i] != s2c[i])
				return false;
		return true;
	}

}
