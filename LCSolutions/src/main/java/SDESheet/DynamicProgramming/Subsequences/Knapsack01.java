package main.java.SDESheet.DynamicProgramming.Subsequences;

public class Knapsack01 {

    static int max = Integer.MIN_VALUE;
    public void recursiveKnapsack(int[] wt, int[] val, int w){
        for (int i=0; i<wt.length; i++){
            recur(wt, val, i, val[i], wt[i], w);
        }

        System.out.println(max);
    }

    private void recur(int[] wt, int[] val, int pos, int currV, int currW, int w){
        if(currW > w){
            return;
        } else {
            if(currV > max){
                max = currV;
            }
            if ( pos >= wt.length-1){
                return;
            }
        }
        recur(wt, val, pos+1, currV + val[pos+1], currW + wt[pos+1], w);
        recur(wt, val, pos+1, currV, currW, w);
    }

    public void dpKnapsack(int[] wt, int[] val, int w){
        int[][] dp = new int[val.length+1][w+1];

        int max = Integer.MIN_VALUE;
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){

                int secVal = wt[i-1] > j ? dp[i-1][j] : val[i-1] + dp[i-1][j-wt[i-1]];
                dp[i][j] = Math.max(dp[i-1][j], secVal);
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }

    public static void main(String[] args) {
        Knapsack01 sol = new Knapsack01();
        /*int[] wt = {1,2,4,5};
        int[] val = {5,4,8,6};*/

        /*int[] wt = {3,2,5};
        int[] val = {30,40,60};*/

        int[] wt = {7};
        int[] val = {1};
        //sol.recursiveKnapsack(wt, val, 1);
        sol.dpKnapsack(wt, val, 1);
    }
}
