package SDESheet.Arrays_IV;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if (!li.contains(target - nums[i])){
                li.add(nums[i]);
            } else {
                System.out.println("found");
                return new int[]{li.indexOf(target - nums[i]), i};
            }
        }
        System.out.println("not found");
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
