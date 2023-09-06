package SDESheet.Heap;

import java.util.*;

class Pair {
    int x;
    int count;

    public Pair(int x, int count){
        this.x = x;
        this.count = count;
    }
}
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        //Map.Entry.comparingByValue(Comparator.reverseOrder());
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())); //new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> li = List.of(1,2,3,4);
        Comparator.comparingInt(li::get);
        //Comparator.comparingInt(pq.peek).reversed();

        for (int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        pq.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i< res.length; i++){
            res[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        topKFrequent(nums, 1);
    }
}
