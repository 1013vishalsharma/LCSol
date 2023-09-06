package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum {

    static int count = 0;
    public void recursiveTargetSum(int[] arr, int k){
        List<Integer> li = new ArrayList<>();
        li.add(arr[0]);
        recur(arr, 0, arr[0], k, li);
        li.remove(li.size()-1);
        li.add(-arr[0]);
        recur(arr, 0, -arr[0], k, li);
        li.remove(li.size()-1);
        System.out.println(count);
    }

    private void recur(int[] arr, int pos, int curr, int k, List<Integer> li){
        if(curr == k && pos == arr.length-1){
            count++;
            System.out.println(li);
            return;
        }
        if(pos >= arr.length-1){
            return;
        }

        li.add(arr[pos+1]);
        recur(arr, pos+1, curr + arr[pos+1], k, li);
        li.remove(li.size()-1);
        li.add(-arr[pos+1]);
        recur(arr, pos+1, curr - arr[pos+1], k, li);
        li.remove(li.size()-1);
    }

    public void dpTargetSum(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int find = (total-target)/2;
        int[][] dp = new int[nums.length+1][find+1];

        for (int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    public static void main(String[] args) {
        TargetSum sol = new TargetSum();
        //int[] arr = {1,2,3,1};
        //int[] arr = {1,1,1,1,1};
        int[] arr = {1};
        //sol.recursiveTargetSum(arr, 1);
        sol.dpTargetSum(arr, 1);

    }
}
