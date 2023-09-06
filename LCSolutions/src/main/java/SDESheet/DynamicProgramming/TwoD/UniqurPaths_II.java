package main.java.SDESheet.DynamicProgramming.TwoD;

import java.util.Arrays;

public class UniqurPaths_II {

    static int maxPaths = 0;
    public void recursiveUniquePaths(int[][] grid){
        uniquePaths(0,0,grid);
        System.out.println(maxPaths);
    }

    public void uniquePaths(int m, int n, int[][] grid){
        if(m >= grid.length || m < 0 || n >= grid[0].length || n < 0 || grid[m][n] == 1){
            return;
        }
        if(m == grid.length-1 && n == grid[0].length-1){
            maxPaths++;
            return;
        }
        uniquePaths(m, n+1, grid);
        uniquePaths(m+1, n, grid);
    }

    public void dpUniquePaths(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1){
            return;
        }

        dp[0][0] = 1;
        for (int i=1; i<obstacleGrid.length; i++){
            if(obstacleGrid[i][0] == 1 || dp[i-1][0] == 0){
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i=1; i<obstacleGrid[0].length; i++){
            if(obstacleGrid[0][i] == 1 || dp[0][i-1] == 0){
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i=1; i< obstacleGrid.length; i++){
            for (int j=1; j<obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        for (int[] arr: dp){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    public static void main(String[] args) {
        UniqurPaths_II sol = new UniqurPaths_II();
        int[][] grid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
                /*{0,1},
                {0,0}*/
        };
        //sol.recursiveUniquePaths(grid);
        sol.dpUniquePaths(grid);
    }
}
