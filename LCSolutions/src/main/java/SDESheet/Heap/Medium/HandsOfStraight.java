package main.java.SDESheet.Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HandsOfStraight {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length % groupSize !=0) || (hand.length == 1 && groupSize !=1)){
            return false;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(groupSize);
        for (int i: hand){
            queue.add(i);
        }


        return true;
    }

    public static void main(String[] args) {
        HandsOfStraight sol = new HandsOfStraight();
        //int[] arr = {1,7,4,2,5,3,6,8};
        int[] arr = {1,2,3,6,2,3,4,7,8};
        System.out.println(sol.isNStraightHand(arr, 3));
    }
}
