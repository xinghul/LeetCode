import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class WordLadder {

	/**
	 * @param args
	 */
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		System.out.println(ladderLength("hit", "cog", dict));
	}
	
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict.size() == 0)
			return 0;
		
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		
		wordQueue.add(start);
		distanceQueue.add(1);
		
		while (!wordQueue.isEmpty())
		{
			String word = wordQueue.pop();
			Integer distance = distanceQueue.pop();
			if (word.equals(end))
				return distance;
			
			for (int i = 0; i < word.length(); i ++)
			{
				char[] chars = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c ++)
				{
					chars[i] = c;
					String newWord = new String(chars);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(distance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		return 0;
 	}
	

}
