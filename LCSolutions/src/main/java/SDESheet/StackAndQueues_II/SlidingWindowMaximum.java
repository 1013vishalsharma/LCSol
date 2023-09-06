package SDESheet.StackAndQueues_II;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res= new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int j = k, m = 0-k+1;
        for (int i=0; i< nums.length; i++){
            if(dq.isEmpty()){
                dq.addFirst(i);
            } else {
                while (!dq.isEmpty() && dq.peek() < m){
                    dq.removeFirst();
                }
                while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            j--;
            m++;
            if(j <= 0){
                res.add(dq.peek());
            }
        }

        int[] arr = new int[res.size()];
        //res.toArray(arr);
        System.out.println();
        for (int i =0 ;i<res.size(); i++){
            arr[i] = nums[res.get(i)];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        //int[] nums = {1};
        int[] nums = {20,25};
        //int[] nums = {4,0,-1,3,5,3,6,8};
        maxSlidingWindow(nums, 2);
    }
}
