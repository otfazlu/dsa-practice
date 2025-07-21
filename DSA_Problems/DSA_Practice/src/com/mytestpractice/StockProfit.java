package com.mytestpractice;



	public class StockProfit {
	    public static int maxProfit(int[] prices) {
	        if (prices == null || prices.length < 2) return 0;

	        int minPrice = prices[0];
	        int maxProfit = 0;

	        for (int i = 1; i < prices.length; i++) {
	            // Update maxProfit if selling at current price gives more profit
	            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

	            // Update minPrice if current price is lower
	            minPrice = Math.min(minPrice, prices[i]);
	        }

	        return maxProfit;
	    }

	    public static void main(String[] args) {
	        int[] prices = {1, 2, 9, 7, 6};
	        System.out.println("Max Profit: " + maxProfit(prices));  // Output: 8
	    }
	}


