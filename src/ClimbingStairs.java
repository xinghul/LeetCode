import java.util.HashMap;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(38));
	}
	static HashMap<Integer, Integer> ways = new HashMap<Integer, Integer>();
	public static int climbStairs(int n) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		if (ways.containsKey(n))
			return ways.get(n);
		int count = climbStairs(n - 1) + climbStairs(n - 2);
		ways.put(n, count);
		return count;
	}

}
