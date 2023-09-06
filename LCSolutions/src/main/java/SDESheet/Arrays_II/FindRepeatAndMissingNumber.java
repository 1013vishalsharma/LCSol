package SDESheet.Arrays_II;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatAndMissingNumber {

    public static void findRepeatAndMissingNumber(int[] arr){
        int xor = 0;
        for (int i = 0; i < arr.length; i++){
            xor ^= arr[i] ^ (i+1);
        }

        int rmsb = xor & -xor;
        int zeroXor = 0;
        int oneXor = 0;

        for (int i=1; i<=arr.length; i++){
            if((i & rmsb) == 0){
               zeroXor ^= i;
            } else {
                oneXor ^= i;
            }

            if((arr[i-1] & rmsb) == 0){
                zeroXor ^= arr[i-1];
            } else {
                oneXor ^= arr[i-1];
            }
        }

        boolean repeatFound = false;
        for (int i=0; i<arr.length; i++){
            if(arr[i] == zeroXor){
                repeatFound = true;
            }
        }

        int repeat = repeatFound ? zeroXor : oneXor;
        int missing = repeatFound ? oneXor: zeroXor;

        System.out.println("Repeat num: " + repeat + ", Missing num: " + missing);

        System.out.println(xor);
    }

    public static void main(String[] args) {
        //int[] arr = {4,3,6,2,1,1};
        int[] arr = {3,1,2,5,3};
        findRepeatAndMissingNumber(arr);
    }
}
