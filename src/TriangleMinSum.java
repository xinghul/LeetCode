import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class TriangleMinSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Map<Integer, Integer> minSums;
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		minSums = new HashMap<Integer, Integer>();
		initMinSums(triangle);
		return minSums.get(0);
	}
	private void initMinSums(ArrayList<ArrayList<Integer>> triangle) {
		for (int i = triangle.size() - 1; i >= 0; i --)
		{
			for (int j = 0; j < triangle.get(i).size(); j ++)
			{
				int index = i * (i + 1) / 2 + j;
				if (i == triangle.size() - 1)
					minSums.put(index, triangle.get(i).get(j));
				else {
					int min = Math.min(minSums.get(index + i + 1), minSums.get(index + i + 2));
					minSums.put(index, triangle.get(i).get(j) + min);
				}
			}
		}
	}

}
