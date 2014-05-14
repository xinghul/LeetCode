import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 2));
	}
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		generate(n, k, new ArrayList<Integer>());
		return result;
	}
	@SuppressWarnings("unchecked")
	private static void generate(int n, int k, ArrayList<Integer> subset) {
		if (subset.size() == k) {
			result.add((ArrayList<Integer>)subset.clone());
			return;
		}
		int start = subset.size() == 0 ? 1 : subset.get(subset.size() - 1) + 1;
		if (subset.size() + n - start + 1 < k)
			return;
		for (int i = start; i <= n; i ++)
		{
			subset.add(i);
			generate(n, k, subset);
			subset.remove(subset.size() - 1);
		}
	}
}
