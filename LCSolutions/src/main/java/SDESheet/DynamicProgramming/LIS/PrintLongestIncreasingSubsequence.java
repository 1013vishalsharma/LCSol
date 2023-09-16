package main.java.SDESheet.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintLongestIncreasingSubsequence {

    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int totalMax = dp[0];
        int idx = 0;
        for (int i=1; i<dp.length; i++){
            int max = 1;
            for (int j=i-1; j>=0 ; j--){
                if(arr[i] > arr[j] && dp[j] + 1 > max){
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
            if(dp[i] > totalMax){
                totalMax = dp[i];
                idx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(arr[idx]);
        totalMax--;
        for (int i=idx-1; i>=0; i--){
            if(dp[i] == totalMax){
                res.add(arr[i]);
                totalMax--;
            }
        }

        Collections.reverse(res);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,3,4,7,6};
        //int[] arr = {10,22,9,33,21,50,41,60,80,1};
        printingLongestIncreasingSubsequence(arr, 6);
    }
}
