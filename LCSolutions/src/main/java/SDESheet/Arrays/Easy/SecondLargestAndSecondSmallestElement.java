package main.java.SDESheet.Arrays.Easy;

public class SecondLargestAndSecondSmallestElement {

    public static void main(String[] args) {
        int[] arr = {1,2};
        int max = Integer.MIN_VALUE; int secMax = -1;
        int min = Integer.MAX_VALUE; int secMin = -1;
        for (int i: arr){
            if(i > max){
                secMax = max;
                max = i;
            } else if (i < max && i > secMax) {
                secMax = i;
            }
            if(i < min){
                secMin = min;
                min = i;
            } else if (i > min && i < secMin) {
                secMin = i;
            }
        }
        System.out.println("second max: " + secMax);
        System.out.println("second min: " + secMin);
    }
}
