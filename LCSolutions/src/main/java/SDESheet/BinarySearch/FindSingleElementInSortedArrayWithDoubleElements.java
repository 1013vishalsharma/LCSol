package SDESheet.BinarySearch;

public class FindSingleElementInSortedArrayWithDoubleElements {

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int i = binarySearch(nums, 0, nums.length-1, -1);
        System.out.println(i);
        return i;
    }

    private static int binarySearch(int[] nums, int low, int high, int ans){
        if(low <= high){
            int mid = (low + high)/2;

            if(mid == 0){
                if(nums[mid] != nums[mid + 1]){
                    ans = nums[mid];
                    return ans;
                }
            } else if (mid == nums.length-1){
                if(nums[mid] != nums[mid-1]){
                    ans = nums[mid];
                    return ans;
                }
            } else if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid + 1]){
                ans = nums[mid];
                return ans;
            } else if((nums[mid] == nums[mid-1] || nums[mid] == nums[mid + 1])){
                ans = ans != -1 ? ans : binarySearch(nums, low, mid-1, ans);
                ans = ans != -1 ? ans : binarySearch(nums, mid + 1, high, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] nums = {3,3,7,7,10,11,11};
        //int[] nums = {1,2,2,3,3,4,4,8,8};
        int[] nums = {1};
        singleNonDuplicate(nums);
    }
}
