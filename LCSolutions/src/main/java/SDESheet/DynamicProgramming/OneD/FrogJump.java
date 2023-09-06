package main.java.SDESheet.DynamicProgramming.OneD;

public class FrogJump {

    public int recursiveFrogJump(int n, int[] arr){
        jump(arr, 0, 0, 0);
        System.out.println("ans is: " + minCount);
        return minCount;
    }

    static int minCount = Integer.MAX_VALUE;
    public void jump(int[] arr, int curr, int next, int count){
        if(next == arr.length-1){
            count = count + Math.abs(arr[curr] - arr[next]);
            System.out.println(count);
            if(count < minCount){
                minCount = count;
            }
            return;
        } else if(next > arr.length-1){
            return;
        } else {
            count = count + Math.abs(arr[curr] - arr[next]);
            curr = next;
        }
        jump(arr, curr, curr+1, count);
        jump(arr, curr, curr+2, count);
    }

    public int dpFrogJump(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < arr.length; i++){
            dp[i] = Math.min(Math.abs(arr[i] + dp[i-1]), Math.abs(arr[i] + dp[i-2]));
        }
        System.out.println(dp[arr.length-1]);
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        FrogJump jump = new FrogJump();
        //jump.recursiveFrogJump(4, new int[]{10,20,30,10});
        //jump.recursiveFrogJump(4, new int[]{30,10, 60, 10, 60, 50});
        jump.dpFrogJump(new int[]{30,10, 60, 10, 60, 50});
        //jump.dpFrogJump(new int[]{10,20,30,10});

    }
}
