package main.java.SDESheet.DynamicProgramming.TwoD;

import java.util.Arrays;

public class NinjaTraining {

    static int maxMerit = Integer.MIN_VALUE;
    public void recursiveMaxMeritPoints(int[][] matrix){
        for (int i=0; i<matrix[0].length; i++){
            maxMerit(matrix, i, matrix[0][i], 1);
        }
        System.out.println("Max merit: " + maxMerit);
    }

    private int maxMerit(int[][] matrix, int pos, int count, int row){
        if(row >= matrix.length){
            return count;
        } else {
            for (int i=0; i< matrix[0].length; i++){
                if(i == pos){
                    continue;
                } else {
                    count = count + matrix[row][i];
                    count = maxMerit(matrix, i, count, row+1);
                    if(count > maxMerit){
                        maxMerit = count;
                        System.out.println(maxMerit);
                    }
                    count = count - matrix[row][i];
                }
            }
        }
        return count;
    }

    public void dpMaxMerits(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i= matrix.length-1; i>=0; i--){
            for (int j= matrix[0].length-1; j>=0; j--){
                if(i == matrix.length-1){
                    dp[i][j] = matrix[i][j];
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int k=0; k< matrix[0].length; k++){
                        if(k == j){
                            continue;
                        } else {
                            //max = dp[i+1][k] + matrix[i][j];
                            max = Math.max(max, dp[i+1][k] + matrix[i][j]);
                        }
                    }
                    dp[i][j] = max;
                }
                if(dp[i][j] > maxMerit){
                    maxMerit = dp[i][j];
                }
            }
        }
        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(maxMerit);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                /*{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}*/
                /*{1,2,5},
                {3,1,1},
                {3,3,3}*/
                /*{18,11,19},
                {4,13,7},
                {1,8,13}*/
                {10,50,1},
                {5,100,11}
        };

        NinjaTraining sol = new NinjaTraining();
        //sol.recursiveMaxMeritPoints(matrix);
        sol.dpMaxMerits(matrix);
    }
}
