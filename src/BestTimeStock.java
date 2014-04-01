/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class BestTimeStock {

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
		int min_price = prices[0];
		for (int i = 0; i < prices.length; i ++)
		{
			if (prices[i] < min_price)
				min_price = prices[i];
			if (prices[i] - min_price > max)
				max = prices[i] - min_price;
		}
		return max;
	}

}
