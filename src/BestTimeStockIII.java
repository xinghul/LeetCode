/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BestTimeStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		
		int[] maxFromLeft = new int[prices.length];
		int[] maxFromRight = new int[prices.length];
		
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i ++)
		{
			if (minPrice > prices[i])
				minPrice = prices[i];
			if (prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
			maxFromLeft[i] = maxProfit;
		}
		
		int maxPrice = Integer.MIN_VALUE;
		maxProfit = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i >= 0; i --)
		{
			if (maxPrice < prices[i])
				maxPrice = prices[i];
			if (maxProfit < maxPrice - prices[i])
				maxProfit = maxPrice - prices[i];
			maxFromRight[i] = maxProfit;
		}
		
		maxProfit = Integer.MIN_VALUE;
		
		for (int i = 0; i < prices.length - 1; i ++)
		{
			int sum = maxFromLeft[i] + maxFromRight[i + 1];
			if (sum > maxProfit)
				maxProfit = sum;
		}
		
		if (maxProfit < maxFromRight[0])
			maxProfit = maxFromRight[0];
		return maxProfit;
			
	}
	
}
