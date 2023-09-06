package main.java.SDESheet.DynamicProgramming.Stocks;

public class BuyAndSellStock_IV {

    public int dp3MaxProfitSol(int k, int[] prices){
        int[][] dp = new int[k+1][prices.length];

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int currMax = dp[i][j-1];
                for (int m=0; m<j; m++){
                    currMax = Math.max(currMax, dp[i-1][m] + prices[j] - prices[m]);
                }
                dp[i][j] = currMax;
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        return dp[dp.length-1][dp[0].length-1];
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k+1][prices.length];


        for (int i=1; i<dp.length; i++){
            int currMax = Integer.MIN_VALUE;
            for (int j=1; j<dp[0].length; j++){
                currMax = Math.max(currMax, dp[i-1][j-1]-prices[j-1]);
                dp[i][j] = Math.max(currMax + prices[j], dp[i][j-1]);
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        BuyAndSellStock_IV sol = new BuyAndSellStock_IV();
        //int[] prices = {3,2,6,5,0,3};
        //int[] prices = {2,4,1};
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        sol.maxProfit(4, prices);

    }
}
