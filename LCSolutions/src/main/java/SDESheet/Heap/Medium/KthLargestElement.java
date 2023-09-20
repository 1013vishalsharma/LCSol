package main.java.SDESheet.Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i: nums){
            queue.add(i);
            if(queue.size() > k){
                queue.remove();
            }
        }

        System.out.println(queue.peek());
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElement sol = new KthLargestElement();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        sol.findKthLargest(nums, 4);
    }
}
