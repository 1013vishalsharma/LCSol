package com.example.Reactordemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2348 {

    public long zeroFilledSubarray(int[] nums) {
        if(nums.length ==0){
            return 0;
        } else {
            Map<Long, Long> map = new HashMap<>();
            long currLen = 0;
            for (int i= 0; i<nums.length; i++){
                if(nums[i] == 0){
                    currLen++;
                    long k = currLen;
                    while (k != 0){
                        map.put(k, map.getOrDefault(k, 0L) + 1);
                        k--;
                    }
                } else {
                    currLen =0;
                }
            }

            long l = map.values()
                    .stream()
                    .mapToLong(Long::longValue)
                    .sum();
            System.out.println(l);
            return l;
        }
    }

    public static void main(String[] args) {
        Solution2348 sol = new Solution2348();
        sol.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4});
    }
}
