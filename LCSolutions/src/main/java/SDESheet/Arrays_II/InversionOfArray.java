package SDESheet.Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class InversionOfArray {

    static int count = 0;
    public static void countInversions(int[] nums){
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    private static void mergeSort(int nums[], int low, int high){
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high){
        int start = low, end = high, m = mid+1;
        List<Integer> li = new ArrayList<>();
        int l = low;

        for(int i = l; i<= mid; i++){
            int m1 = m;
            while(m1 <= high){
                if(nums[i] > nums[m1]){
                    count++;
                    m1++;
                } else {
                    break;
                }
            }
        }

        while (low <= mid &&  m <= high){
            if(nums[low] <= nums[m]){
                li.add(nums[low]);
                low++;
            } else {
                li.add(nums[m]);
                m++;
                //count++;
            }
        }

        while(low <= mid){
            li.add(nums[low]);
            low++;
        }

        while(m <= high){
            li.add(nums[m]);
            m++;
        }
        int j = 0;
        for (int i = start; i<=end; i++){
            nums[i] = li.get(j);
            j++;
        }
        li.clear();
    }

    public static void main(String[] args) {
        //int[] nums = {5,2,3,1,4};
        //int[] nums = {5,4,3,2,1};
        //int[] nums = {5,3,2,1,4};
        int[] nums = {-1,-1};
        countInversions(nums);
    }
}
