/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class CanCompleteCircuit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasRemain, start = 0;
		boolean succ = false;
		for (int i = 0 ; i < gas.length; i ++) 
		{
			gasRemain = 0;
			start = i;
			int passedTime = 0;
			int index = start;
			while (true) 
			{
				if (index == start)
					passedTime ++;
				if (passedTime == 2) {
					succ = true;
					break;
				}
				gasRemain += gas[index] - cost[index];
				if (gasRemain < 0)
					break;
				if (index < gas.length - 1)
					index ++;
				else
					index = 0;
			}
			if (succ)
				break;
		}
		if (succ)
			return start;
		return -1;
		
	}

}
