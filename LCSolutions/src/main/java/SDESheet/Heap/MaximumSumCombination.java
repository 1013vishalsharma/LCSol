package SDESheet.Heap;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Element {
    int sum;
    int ele1;
    int ele2;

    public Element(int sum, int ele1, int ele2) {
        this.sum = sum;
        this.ele1 = ele1;
        this.ele2 = ele2;
    }

    public int getSum() {
        return sum;
    }
}
public class MaximumSumCombination {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1}; // 5, 4, 2, 1
        int[] b = {8, 0, 3, 5}; // 8, 5, 3, 0

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Element> heap = new PriorityQueue<>(3, Comparator.comparingInt(Element::getSum).reversed()); //(o1, o2) -> Integer.compare(o2.sum, o1.sum));

        heap.add(new Element(a[a.length-1] + b[b.length-1], a[a.length-1], b[b.length-1]));

        for (int i= a.length-2; i>=0; i--){
            heap.add(new Element(a[i] + b[i+1], a[i], b[i+1]));
            heap.add(new Element(a[i+1] + b[i], a[i+1], b[i]));
        }

        for (int i = 0; i<3; i++){
            System.out.println(heap.poll().sum);
        }



    }
}
