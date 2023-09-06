package SDESheet.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfDataStream {

    Queue<Integer> left;
    Queue<Integer> right;
    public MedianOfDataStream() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(right.isEmpty() || num < right.peek()){
            left.add(num);
        } else {
            right.add(num);
        }

        if(left.size() - right.size() > 1){
            right.add(left.poll());
        } else if (right.size() - left.size() > 1){
            left.add(right.poll());
        }
    }
    public double findMedian() {
        if (right.size() == left.size()){
            double ans = (right.peek() + left.peek()) / 2.0;
            System.out.println(ans);
            return ans;
        } else {
            double ans = right.size() > left.size() ? right.peek() : left.peek();
            System.out.println(ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        MedianOfDataStream sol = new MedianOfDataStream();
        sol.addNum(1);
        sol.addNum(2);
        sol.findMedian();
        sol.addNum(3);
        sol.findMedian();
    }
}
