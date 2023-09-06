package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    static boolean found = false;
    public void recusrsivePartitionSubset(int[] arr){
        int total = Arrays.stream(arr).sum();
        if(total % 2 == 0){
            return;
        }
        for (int i=0; i<arr.length; i++){
            recur(arr, i, arr[i], total/2);
        }
        System.out.println(found);
    }

    private void recur(int[] arr, int pos, int curr, int sum){
        if(curr == sum){
            found = true;
        }
        if(found || pos >= arr.length-1){
            return;
        }
        recur(arr, pos+1, curr + arr[pos+1], sum);
        recur(arr, pos+1, curr, sum);
    }

    public void dpPartitionSubset(int[] arr){
        int total = Arrays.stream(arr).sum();
        if(total % 2 != 0){
            System.out.println(found);
            return;
        }

        boolean[][] dp = new boolean[arr.length+1][total/2 + 1];
        for (int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                boolean secVal = arr[i-1] > j ? false : dp[i-1][j-arr[i-1]];
                dp[i][j] = dp[i-1][j] || secVal;
                if(j == dp[0].length-1 && dp[i][j]){
                    found = true;
                }
            }
        }
        System.out.println(found);


    }

    public static void main(String[] args) {
        //int[] arr = {1,5,11,5};
        int[] arr ={2,2,3,5};
        PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
        //sol.recusrsivePartitionSubset(arr);
        sol.dpPartitionSubset(arr);
    }
}
