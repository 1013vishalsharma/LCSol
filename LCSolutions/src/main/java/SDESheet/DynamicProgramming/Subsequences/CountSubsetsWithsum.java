package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountSubsetsWithsum {

    static int count = 0;
    public void recursiveCountSubsetsWithSum(int[] arr, int k){
        for (int i=0; i<arr.length; i++){
            List<Integer> li = new ArrayList<>();
            li.add(i);
            recur(arr, 0, i+1, k, arr[i], li);
        }
        System.out.println("count: " + count);
    }

    private void recur(int[] arr, int idx, int pos, int k, int sum, List<Integer> li){
        if(sum == k && pos == arr.length){
            System.out.println(li);
            count++;
        }
        if(pos >= arr.length){
            return;
        }
        li.add(pos);
        recur(arr, idx, pos+1, k, sum + arr[pos], li);
        li.remove(li.size()-1);
        recur(arr, idx, pos+1, k, sum, li);
    }

    public void dpCountSubsetsWithSum(int[] arr, int k){
        boolean[][] dp = new boolean[arr.length+1][k+1];

        for (int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }
        for (int i=0; i<dp[0].length; i++){
            if(i==0){
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }
        }

        for(int i=1;i<dp.length;i++){
            for (int j=1; j<dp[0].length; j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                if(j==k){
                    if(dp[i-1][j-arr[i-1]]){
                        count++;
                    }
                }
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        CountSubsetsWithsum sol = new CountSubsetsWithsum();
        //int[] arr = {1,2,2,3};

        //int[] arr = {2,3,5,6,8,10};
        //int[] arr = {1,4,4,5};
        int[] arr = {0,0,1};
        //int[] arr = {3,2,2,5,1};
        //sol.dpCountSubsetsWithSum(arr, 1);
        sol.recursiveCountSubsetsWithSum(arr, 1);
    }
}
