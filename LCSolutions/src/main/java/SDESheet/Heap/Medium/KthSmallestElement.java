package main.java.SDESheet.Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());

        for (int i: nums){
            queue.add(i);
            if(queue.size() > k){
                queue.poll();
            }
        }

        System.out.println(queue.peek());
        return queue.peek();
    }
    public static void main(String[] args) {
        KthSmallestElement sol = new KthSmallestElement();
        int[] nums = {1,2,6,4,5};
        sol.findKthLargest(nums, 3);
    }
}
