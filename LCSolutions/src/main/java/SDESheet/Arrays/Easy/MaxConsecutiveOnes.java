package main.java.SDESheet.Arrays.Easy;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i: nums){
            if(i == 1){
                count++;
            } else {
                if(count > max){
                    max = count;
                }
                count = 0;
            }
        }
        if(count > max){
            max = count;
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
        sol.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
    }
}
