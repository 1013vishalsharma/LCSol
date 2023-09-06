package main.java.SDESheet.DynamicProgramming.Subsequences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSumEqualsTarget {

    static int count = 0;
    static boolean found = false;
    public void recursiveSubsetSumEqualsTarget(int[] arr, int k){
        for (int i=0; i<arr.length; i++){
            List<Integer> li = new ArrayList<>();
            li.add(arr[i]);
            subsetSum(arr, i, k, li);
        }
        System.out.println("count: " + count + " found: " + found);
    }

    private void subsetSum(int[] arr, int pos, int k, List<Integer> li){
        if(pos == arr.length-1){
            li.forEach(x -> System.out.print(x + " "));
            System.out.println();
            int sum = li.stream().mapToInt(x -> x).sum();
            if(sum == k){
                System.out.println("found");
                count++;
                found = true;
            }
            return;
        }
        li.add(arr[pos+1]);
        subsetSum(arr, pos+1, k, li);
        li.remove(li.size()-1);
        subsetSum(arr, pos+1, k, li);
    }

    public static void main(String[] args) {
        SubsetSumEqualsTarget sol = new SubsetSumEqualsTarget();
        int[] arr = {1,2,3,4};
        sol.recursiveSubsetSumEqualsTarget(arr, 4);
    }
}
