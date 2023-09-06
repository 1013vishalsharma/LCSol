package SDESheet.BinarySearch;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            } else {
                return -1;
            }
        }
        int i = binarySearch(nums, 0, nums.length-1, target);
        System.out.println(i);
        return i;
    }

    private static int binarySearch(int[] nums, int low, int high, int target){
        if(low <= high){
            int mid = (low + high) /2;

            if(nums[mid] == target){
                return mid;
            } else {
                if(nums[low] <= nums[mid]){
                    if(target >= nums[low] && target <= nums[mid]){
                        return binarySearch(nums, low, mid - 1, target);
                    } else {
                        return binarySearch(nums, mid+1, high, target);
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[high]){
                        return binarySearch(nums, mid+1, high, target);
                    } else {
                        return binarySearch(nums, low, mid-1, target);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int nums[] = {4,5,6,7,0,1,2};
        int nums[] = {1,3};
        search(nums, 3);
    }
}
