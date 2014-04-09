import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4, 1, 0};
		System.out.println(subsetsWithDup(num));
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return result;
		Arrays.sort(num);
		int max = (int)Math.pow(2, num.length);
		for (int i = 0; i < max; i ++)
		{
			ArrayList<Integer> subset = new ArrayList<Integer>();
			for (int j = 0; j < num.length; j ++)
			{
				if ((i & (int)Math.pow(2, j) ) > 0) {
					subset.add(num[j]);
				}
			}
			if (!result.contains(subset))
				result.add(subset);
		}
		return result;
	}

}
