package SDESheet.Arrays_III;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int cnt = 0, ele = -1;
        for (int i = 0; i < nums.length; i++){
            if(cnt == 0){
                ele = nums[i];
                cnt++;
            } else if(ele != nums[i]){
                cnt--;
            } else if(ele == nums[i]){
                cnt++;
            }
        }

        if(cnt > 1){
            System.out.println(ele);
            return ele;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        majorityElement(nums);
    }
}
