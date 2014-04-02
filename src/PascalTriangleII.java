import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class PascalTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));
	}
	public static ArrayList<Integer> getRow(int rowIndex) {
		rowIndex ++;
		ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < rowIndex; i ++)
		{
			ArrayList<Integer> row = new ArrayList<Integer>();
			if (i == 0)
				row.add(1);
			else {
				ArrayList<Integer> prev = pascal.get(i - 1);
				for (int k = 0; k <= prev.size(); k ++)
				{
					if (k == 0)
						row.add(prev.get(0));
					else if (k == prev.size())
						row.add(prev.get(prev.size() - 1));
					else
						row.add(prev.get(k) + prev.get(k - 1));
				}
			}
			pascal.add(row);
		}
		
		return pascal.get(rowIndex - 1);
	}

}
