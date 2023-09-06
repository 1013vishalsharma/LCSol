package SDESheet.Arrays_I;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        /*
            1) Start traversing from back
            2) find the first point where the curr num is greater than the next num ( num[i] > num[i-1]) we will call this insertion point
            3) now find the first number in the forward direction which is greater than nums[i-1]
            4) swap both of these numbers
            5) Sort the array from insertion point till the end
            6) This is the next greater permutation
            {4,5,4,3,2,1}
         */
        boolean found = false;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                found = true;
                int insPt = i;
                int nextMax = Integer.MAX_VALUE, nextMaxIdx = -1;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < nextMax) {
                        nextMax = nums[j];
                        nextMaxIdx = j;
                    }
                }
                swap(nums, i - 1, nextMaxIdx);
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        if(!found){
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,4,3,2,1};
        nextPermutation(nums);
    }
}
