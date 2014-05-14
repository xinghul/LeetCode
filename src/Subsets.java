import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1, 2, 3};
		System.out.println(subsets(S));
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S.length == 0)
			return result;
		Arrays.sort(S);
		int max = (int)Math.pow(2, S.length);
		
		for (int i = 0; i < max; i ++)
		{
			ArrayList<Integer> subset = new ArrayList<Integer>();
			
			for (int j = 0; j < S.length; j ++)
			{
				if (((1 << j) & i) > 0)
					subset.add(S[j]);
			}
			if (!result.contains(subset))
				result.add(subset);
		}
		return result;
	}

}
