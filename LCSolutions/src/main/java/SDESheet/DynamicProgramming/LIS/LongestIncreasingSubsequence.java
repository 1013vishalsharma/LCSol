package main.java.SDESheet.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int totalMax = dp[0];
        for (int i=1; i<nums.length; i++){
            int max = 1;
            for (int j = i-1; j>=0; j--){
                if(nums[i] > nums[j] && dp[j]+1 > max){
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
            if(dp[i]>totalMax){
                totalMax = dp[i];
            }
        }
        System.out.println(totalMax);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(dp).forEach(x -> System.out.print(x + " "));
        return totalMax;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        //int[] arr = {10,9,2,5,3,7,101,18};
        //int[] arr = {4,10,4,3,8,9};
        int[] arr = {5,6,3,4,7,6};
        sol.lengthOfLIS(arr);
    }
}
