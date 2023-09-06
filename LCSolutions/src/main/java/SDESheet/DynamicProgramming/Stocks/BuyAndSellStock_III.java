package main.java.SDESheet.DynamicProgramming.Stocks;

public class BuyAndSellStock_III {

    public int dp3dmaxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];

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

    public int maxProfit(int[] prices){
        int[][] dp = new int[3][prices.length];

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
        BuyAndSellStock_III sol = new BuyAndSellStock_III();
        int[] arr = {3,3,5,0,0,3,1,4};
        //int[] arr = {1,2,3,4,5};
        //int[] arr = {7,6,4,3,1};
        sol.maxProfit(arr);
    }
}
