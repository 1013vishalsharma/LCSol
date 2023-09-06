package main.java.SDESheet.DynamicProgramming.TwoD;

import java.util.Arrays;

public class UniquePaths {

    static int count = 0;
    public void recursiveUniquePaths(int m, int n){
        int[][] matrix = new int[m][n];
        countPaths(0, 0, matrix);
        System.out.println(count);
    }

    private void countPaths(int m, int n, int[][] matrix){
        if(m >= matrix.length || m <0 || n >= matrix[0].length || n < 0){
            return;
        }
        if (m == matrix.length-1 && n == matrix[0].length-1){
            count++;
            return;
        }
        countPaths(m, n+1, matrix);
        countPaths(m+1, n, matrix);
    }

    public void dpUniquePaths(int m, int n){
        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for (int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int[] arr: dp){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(dp[m-1][n-1]);
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();
        sol.dpUniquePaths(3,7);
    }
}
