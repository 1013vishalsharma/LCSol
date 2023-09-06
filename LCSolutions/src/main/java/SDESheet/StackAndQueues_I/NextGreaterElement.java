package SDESheet.StackAndQueues_I;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length * 2 - 1;
        int[] res = new int[n+1];
        while (n >= 0){
            int i = n%nums.length;

            if(stack.isEmpty()){
                stack.push(nums[i]);
                res[n] = -1;
            } else {
                if(nums[i] < stack.peek()){
                    res[n] = stack.peek();
                    stack.push(nums[i]);
                } else {
                    while(!stack.isEmpty() && nums[i] >= stack.peek()){
                        stack.pop();
                    }
                    if (stack.isEmpty()){
                        stack.push(nums[i]);
                        res[n] = -1;
                    } else {
                        res[n] = stack.peek();
                        stack.push(nums[i]);
                    }
                }
            }
            n--;
        }

        System.out.println(Arrays.toString(res));
        return Arrays.copyOfRange(res, 0, nums.length);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,3};
        nextGreaterElements(nums);

    }
}
