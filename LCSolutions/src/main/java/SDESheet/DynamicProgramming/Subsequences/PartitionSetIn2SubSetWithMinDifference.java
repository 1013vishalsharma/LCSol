package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class PartitionSetIn2SubSetWithMinDifference {

    static int min = Integer.MAX_VALUE;
    public int recursiveMinimumDifference(int[] nums) {
        if(nums.length == 2){
            return Math.abs(nums[0]-nums[1]);
        }
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i<nums.length; i++) {
            recur(nums, i, nums[i], total,1);
        }
        System.out.println(min);
        return min;
    }

    private void recur(int[] nums, int pos, int curr, int total, int count){
        int diff = total - curr;
        if(Math.abs(diff - curr) < min && count == nums.length/2){
            min = Math.abs(diff - curr);
        }
        if(pos >= nums.length-1){
            return;
        }
        recur(nums, pos+1, curr + nums[pos+1], total, count+1);
        recur(nums, pos+1, curr, total, count);
    }

    public void dpMinimumDifference(int[] nums){
        int total = Arrays.stream(nums).sum();

        boolean[][] dp = new boolean[nums.length+1][total+1];
        for (int i=0;i<dp.length; i++){
            dp[i][0] = true;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (nums[i-1] > j){
                    continue;
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<dp[0].length;i++){
            if(dp[dp.length-1-nums.length/2][i]){
                int s1 = i;
                int s2 = Math.abs(total-i);
                if(Math.abs(s1-s2) < min){
                    min = Math.abs(s1-s2);
                }
            }
        }
        System.out.println(min);
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    public static void main(String[] args) {
        PartitionSetIn2SubSetWithMinDifference sol = new PartitionSetIn2SubSetWithMinDifference();
        //int[] nums = {3,9,7,3};
        //int[] nums = {-36, 36};
        //int[] nums = {2,-1,0,4,-2,-9};
        int[] nums = {76,8,45,20,74,84,28,1};
        //sol.recursiveMinimumDifference(nums);
        sol.dpMinimumDifference(nums);
    }
}
