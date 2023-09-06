package SDESheet.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    static List<Integer> li = new ArrayList<>();
    private static void merge(int[] nums, int low, int mid, int high){
        int ll = low, hh = high;

        int ml = mid + 1;
        while(low <= mid && ml <= high){
            if(nums[low] <= nums[ml]){
                li.add(nums[low]);
                low++;
            } else {
                li.add(nums[ml]);
                ml++;
            }
        }

        while( low <= mid){
            li.add(nums[low]);
            low++;
        }

        while(ml <= high){
            li.add(nums[ml]);
            ml++;
        }

        int size = 0;
        for(int i = ll; i<=hh; i++) {
            nums[i] = li.get(size);
            size++;
        }
        li.clear();
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        sortArray(nums);
    }
}
