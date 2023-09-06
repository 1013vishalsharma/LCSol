package main.java.SDESheet.DynamicProgramming.OneD;

public class ClimbingStairs {

    static int count = 0;
    public int recursiveClimbStairs(int n) {
        climb(n);
        System.out.println(count);
        return count;
    }

    public void climb(int n){
        if(n < 0){
            return;
        } else if(n == 0){
            count++;
            return;
        }
        climb(n-1);
        climb(n-2);
    }

    public int dpClimbStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        cs.recursiveClimbStairs(3);
        cs.dpClimbStairs(4);
    }
}
