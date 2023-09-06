package main.java.SDESheet.DynamicProgramming.OneD;

public class MaximumSumOfNonAdjacentNums {

    int maxSum = Integer.MIN_VALUE;
    public int recursiveMaxSum(int[] arr){
        for (int i=0; i<arr.length; i++){
            int count = findSum(arr, i, arr[i]);
            System.out.println(count);
            if (count > maxSum) {
                maxSum = count;
            }
        }
        if(arr[arr.length-2] > maxSum){
            maxSum = arr[arr.length-2];
        }
        if(arr[arr.length-1] > maxSum){
            maxSum = arr[arr.length-1];
        }
        System.out.println("max: "+ maxSum);
        return maxSum;
    }

    private int findSum(int[] arr, int pos, int count){
        for (int i=pos+2; i<arr.length; i++){
            count = findSum(arr, i, count+arr[i]);
            System.out.println(count);
            if (count > maxSum) {
                maxSum = count;
            }
            count = count - arr[i];
        }
        return count;
    }

    public int dpMaxSum(int[] arr){
        int[] dp = new int[arr.length];
        dp[dp.length-1] = arr[arr.length-1];
        dp[dp.length-2] = Math.max(arr[arr.length-2], dp[dp.length-1]);

        for (int i=dp.length-3; i>=0; i--){
            dp[i] = Math.max(arr[i], Math.max(arr[i]+dp[i+2], dp[i+1]));
        }
        System.out.println(dp[0]);
        return dp[0];
    }

    public static void main(String[] args) {
        MaximumSumOfNonAdjacentNums sol = new MaximumSumOfNonAdjacentNums();
        //int[] arr = {2,1,4,9};
        //int[] arr = {205,5,210,100,10,205};
        int[] arr = {3, 2, 5, 10, 7};
        //int[] arr = {2,7,9,3,1};
        //int[] arr = {99,900};
        //int[] arr = {900,-1,-2,-3,-4};
        //sol.recursiveMaxSum(arr);
        sol.dpMaxSum(arr);
    }
}
