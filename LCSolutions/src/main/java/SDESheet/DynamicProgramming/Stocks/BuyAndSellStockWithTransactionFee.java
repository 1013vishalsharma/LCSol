package main.java.SDESheet.DynamicProgramming.Stocks;

public class BuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i<dp.length; i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0] - fee);
        }
        int res = Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        BuyAndSellStockWithTransactionFee sol = new BuyAndSellStockWithTransactionFee();
        int[] prices = {1,3,7,5,10,3};
        //int[] prices = {10,15,17,20,16,18,22,20,22,20,23,25};
        sol.maxProfit(prices, 3);
    }
}
