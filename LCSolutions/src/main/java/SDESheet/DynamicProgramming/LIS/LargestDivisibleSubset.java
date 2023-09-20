package main.java.SDESheet.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        List<Integer> res = new ArrayList<>();
        int finalMax = dp[0];
        int finalIdx = 0;
        for (int i = 1; i < dp.length; i++){
            int max = 1;
            int prevIdx = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && dp[j]+1 > max){
                    max = dp[j] + 1;
                    prevIdx = j;
                }
            }
            dp[i] = max;
            if(prevIdx != Integer.MAX_VALUE)
                res.add(nums[prevIdx]);

            if(max > finalMax){
                finalMax = max;
                finalIdx = i;
            }

        }
        res.add(nums[finalIdx]);

        Arrays.stream(dp).forEach(x -> System.out.print(x + " "));

        //res.add(nums[0]);
        /*int x = dp[0];
        x++;
        for (int i=1; i<dp.length; i++){
            if(dp[i] == x){
                if(x == 2){
                    res.add(nums[i-1]);
                }
                res.add(nums[i]);
                x++;
            }
        }*/
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset sol = new LargestDivisibleSubset();
        //int[] arr = {3,4,16,8};
        //int[] arr = {2,3,4,8};
        //int[] arr = {1};
        //int[] arr = {7,7,7,7};
        int[] arr = {1,2,3};
        sol.largestDivisibleSubset(arr);
    }
}
