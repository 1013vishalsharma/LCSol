package main.java.SDESheet.DynamicProgramming.Stocks;

public class BuyAndSellStock_II {

    static int max = Integer.MIN_VALUE;
    public int recurMaxProfit(int[] prices) {
        recur(prices, 0, true, 0);
        System.out.println(max);
        return max;
    }

    private int recur(int[] prices, int idx, boolean buy, int profit){
        if(profit > max){
            max = profit;
            System.out.println("current profit: " + max);
        }
        if(idx == prices.length){
            return 0;
        }
        if (buy){
            profit = Math.max(recur(prices, idx+1, false, profit - prices[idx]), recur(prices, idx+1, true, profit));
        } else {
            profit = Math.max(recur(prices, idx+1, true, profit + prices[idx]),
                    recur(prices, idx+1, false, profit));
        }
        return profit;
    }

    public int dpMaxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];

        int profit = 0;
        for (int i =1; i<dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][0] = profit - prices[i];
                dp[i][1] = profit;
                profit = Math.max(dp[i][0], dp[i][1]);
            }
        }
        return 0;
    }

    public int maxProfit(int[] prices) {
        int len = 1;
        int profit = 0;
        while(len < prices.length){
            profit += Math.max(prices[len] - prices[len - 1], 0);
            len++;
        }
        System.out.println(profit);
        return profit;
    }

    public static void main(String[] args) {
        BuyAndSellStock_II sol = new BuyAndSellStock_II();
        //int[] arr = {7,1,5,3,6,4};
        int[] arr = {7,6,4,3,1};
        sol.maxProfit(arr);

        //sol.recurMaxProfit(arr);
    }
}
