package main.java.SDESheet.DynamicProgramming.OneD;

public class HouseRobber {

    static int maxCount = Integer.MIN_VALUE;
    public void recursiveHouseRobber(int[] arr){
        for (int i=0; i<arr.length;i++){
            int count;
            if(i==0){
                count = houseRobber(arr, i + 2, false, arr[i]);
            } else {
                count = houseRobber(arr, i + 2, true, arr[i]);
            }
            if(arr[i] > maxCount){
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }

    private int houseRobber(int[] arr, int pos, boolean considerLast, int count){
        for (int i = pos; i<arr.length; i++){
            if(!considerLast && i == arr.length-1){
                continue;
            }
            count = houseRobber(arr, i+2, considerLast, count + arr[i]);
            if(count > maxCount){
                maxCount = count;
            }
            count = count - arr[i];
        }
        return count;
    }

    public void dpHouseRobber(int[] arr){
        int[] dp1 = new int[arr.length-1];
        int[] dp2 = new int[arr.length-1];

        dp1[dp1.length-1] = arr[arr.length-2];
        dp1[dp1.length-2] = Math.max(dp1[dp1.length-1], arr[arr.length-3]);
        for (int i=arr.length-4; i>=0; i--){
            dp1[i] = Math.max(arr[i] + dp1[i+2], dp1[i+1]);
        }

        dp2[dp2.length-1] = arr[arr.length-1];
        dp2[dp2.length-2] = Math.max(dp2[dp2.length-1], arr[arr.length-2]);
        for (int i=arr.length-3; i>0; i--){
            dp2[i-1] = Math.max(arr[i] + dp2[i+1], dp2[i]);
        }

        System.out.println(Math.max(dp1[0], dp2[0]));
    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        //int[] arr = {1,5,2,1,6};
        //int[] arr = {2,1,4,9};
        //int[] arr = {2,3,2};
        int[] arr = {100,2,3 };

        //sol.recursiveHouseRobber(arr);
        sol.dpHouseRobber(arr);
    }
}
