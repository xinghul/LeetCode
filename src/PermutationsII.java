import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 1};
		permuteUnique(num);
		System.out.println(result);
	}
	
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> solution = new ArrayList<Integer>();
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		boolean[] picked = new boolean[num.length];
		pick(num, picked, 0);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static void pick(int[] num, boolean[] picked, int index) {
		if (index == num.length) {
			ArrayList<Integer> tmp = (ArrayList<Integer>)solution.clone();
			result.add(tmp);
			return;
		}
		ArrayList<Integer> tried = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i ++)
		{
			if (!picked[i] && !tried.contains(num[i])) {
				tried.add(num[i]);
				
				solution.add(num[i]);
				picked[i] = true;
				pick(num, picked, index + 1);
				picked[i] = false;
				solution.remove(index);
			}
		}
	}

}
