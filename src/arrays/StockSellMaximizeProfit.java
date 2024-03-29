package arrays;

/**
 * @author amrit
 * Question:
 * The cost of a stock on each day is given in an array, find the max profit that you can make
 * by buying and selling in those days. For example, if the given array is
 * {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0,
 * selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted
 * in decreasing order, then profit cannot be earned at all.
 * 
 * Link: https://www.geeksforgeeks.org/stock-buy-sell/
 */

public class StockSellMaximizeProfit {
	public static void main(String[] args)
	{
		// stock prices on consecutive days
		int price[] = {2, 4, 2, 4, 2, 4};
			//{ 2, 30, 15, 10, 8, 25, 80 };
			//{ 100, 180, 260, 310, 40, 535, 695 };
		
		System.out.println(maxProfit(price));
	}

	private static int maxProfit(int[] price) {
		int maxProfit = 0;

		for (int i = 1; i < price.length; i++) {
			if (price[i] > price[i-1]) {
				maxProfit += price[i] - price[i-1];
			}
		}
		return maxProfit;
	}
}
