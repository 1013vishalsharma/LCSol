package SDESheet.Arrays_II;

public class FindDuplicateInArrayOfIntegers {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        System.out.println(slow);
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        findDuplicate(arr);
    }
}
