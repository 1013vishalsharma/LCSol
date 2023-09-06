package main.java.SDESheet.DynamicProgramming.Subsequences;

public class MinimumCoins {

    static int min = Integer.MAX_VALUE;
    public int recursiveCoinChange(int[] coins, int amount) {
        for (int i=0; i<coins.length; i++){
            recur(coins, i, 1, coins[i], amount);
        }
        System.out.println(min);
        return min;
    }

    private void recur(int[] coins, int pos, int count, int curr, int amount){
        if(curr == amount){
            if(count < min){
                System.out.println("count: "+count);
                min = count;
            }
            return;
        }
        if(curr > amount || pos >= coins.length-1){
            return;
        }

        for(int i=amount/coins[pos]; i >= 1; i--) {
            recur(coins, pos, count + 1, curr + coins[pos], amount);
        }
        recur(coins, pos+1, count, curr, amount);
    }

    public static void main(String[] args) {
        MinimumCoins sol = new MinimumCoins();
        int[] arr = {1,2,5};
        sol.recursiveCoinChange(arr, 11);
    }
}
