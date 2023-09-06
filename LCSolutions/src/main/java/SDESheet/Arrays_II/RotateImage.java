package SDESheet.Arrays_II;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
                /*{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}*/
        };

        for (int i = 0; i < matrix.length; i++){
            for (int j = i ; j < matrix.length; j++){
                swap(i, j, matrix);
            }
        }

        for (int i = 0; i < matrix.length; i++){
            reverse(matrix[i], 0);
        }

        for (int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void swap(int i, int j, int[][] matrix){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr){
        int i = 0; int j = arr.length-1;
        while(i < j){
            swap(i, j, arr);
            i++;
            j--;
        }
    }

    private static void reverse(int[] arr, int i){
        if(i < (arr.length)/2){
            swap(i, arr.length-1-i, arr);
            i = i+1;
            reverse(arr, i);
        }
    }
}
