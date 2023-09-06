package SDESheet.Arrays_II;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1 = {1,4,8,10};
        int[] arr2 = {2,3,9};

        for (int i = 0; i < arr1.length; i++){
            if(arr1[i] > arr2[0]){
                swap(arr1, arr2, i, 0);
                Arrays.sort(arr2);
            }
        }
        System.out.println(Arrays.toString(arr1) + "----" + Arrays.toString(arr2));
    }

    private static void swap(int[] arr1, int[] arr2, int idx1, int idx2){
        int temp = arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
    }
}
