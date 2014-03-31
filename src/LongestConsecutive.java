import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class LongestConsecutive {

	/**
	 * @param args
	 */
	public int longestConsecutive(int[] num) {
		Set<Integer> numbers = new HashSet<Integer>();
		int longest = 0;
		
		for (int i = 0; i < num.length; i ++) 
		{
			numbers.add(num[i]);
		}
		
		for (int i = 0; i < num.length; i ++)
		{
			int length = 0;
			if (numbers.contains(num[i])) {
				int smaller = num[i] - 1, bigger = num[i] + 1;
				
				while (numbers.contains(smaller))
				{
					numbers.remove(smaller);
					length ++;
					smaller --;
				}
				while (numbers.contains(bigger))
				{
					numbers.remove(bigger);
					length ++;
					bigger ++;
				}
				numbers.remove(num[i]);
				length ++;
				if (length > longest)
					longest = length;
			}
		}
		
		return longest;
	}

}
