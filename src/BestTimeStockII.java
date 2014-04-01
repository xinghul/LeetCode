/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BestTimeStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = 0;
		int stockInHand = Integer.MAX_VALUE;
		int subMax = 0;
		
		for (int i = 0; i < prices.length; i ++)
		{
			if (prices[i] < stockInHand)
				stockInHand = prices[i];
			if (prices[i] - stockInHand > subMax)
				subMax = prices[i] - stockInHand;
			else {
				max += subMax;
				subMax = 0;
				stockInHand = prices[i];
			}
		}
		if (subMax > 0)
			max += subMax;
		
		return max;
	}

}
