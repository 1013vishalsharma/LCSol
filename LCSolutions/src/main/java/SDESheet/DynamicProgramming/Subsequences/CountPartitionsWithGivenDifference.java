package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPartitionsWithGivenDifference {

    static int count = 0;
    public void recursiveCountPartitions(int[] arr, int k){
        int sum = Arrays.stream(arr).sum();
        for (int i=0; i< arr.length; i++){
            List<Integer> li = new ArrayList<>();
            li.add(i);
            recur(arr, i+1, k, sum, arr[i], li);
        }
        System.out.println(count);
    }

    private void recur(int[] arr, int pos, int k, int sum, int diff, List<Integer> li){
        if(diff - (sum - diff) == k && pos == arr.length){
            count++;
            System.out.println(li);
        }
        if(pos >= arr.length){
            return;
        }
        li.add(pos);
        recur(arr, pos+1, k, sum, diff+arr[pos], li);
        li.remove(li.size()-1);
        recur(arr, pos+1, k, sum, diff, li);
    }

    public void dpCountPartitions(int[] arr, int k){
        int total = Arrays.stream(arr).sum();
        int n = (total-k)/2;

        boolean[][] dp = new boolean[arr.length+1][n+1];
         for (int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        int count = 0;
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                boolean secValue = arr[i-1] > j ? false : dp[i-1][j-arr[i-1]];
                dp[i][j] = dp[i-1][j] || secValue;
                if(j == dp[0].length-1 && dp[i-1][j-arr[i-1]]){
                    count++;
                }
            }
        }
        System.out.println("dp ans: " + count);
    }

    public static void main(String[] args) {
        //int[] arr = {5,2,6,4};
        CountPartitionsWithGivenDifference sol = new CountPartitionsWithGivenDifference();
        //int[] arr = {1,1,1,1};
        //int[] arr = {4,6,3};
        //int[] arr = {3,1,1,2,1};
        int[] arr = {3,2,2,5,1};
        sol.recursiveCountPartitions(arr, 1);
        sol.dpCountPartitions(arr, 1);
    }
}
