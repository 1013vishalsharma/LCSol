package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution443 {

    public int compress(char[] chars) {
        int count = 1;
        StringBuilder s = new StringBuilder();
        if(chars.length == 1){
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<chars.length; i++){
            if(i==0){
                map.put(chars[i], 1);
            } else {
                if(map.containsKey(chars[i])){
                    map.put(chars[i], map.get(chars[i]) + 1);
                } else {
                    int val = map.remove(chars[i-1]);
                    if(val == 1){
                        s.append(chars[i - 1]);
                    } else {
                        s.append(chars[i - 1]).append(val);
                    }
                    map.put(chars[i], 1);
                }
            }
        }
        if(!map.isEmpty()) {
            int val = map.remove(chars[chars.length - 1]);
            if (val == 1) {
                s.append(chars[chars.length - 1]);
            } else {
                s.append(chars[chars.length - 1]).append(val);
            }
        }
        System.out.println(s.length());
        System.out.println(s);
        return s.length();
    }

    public static void main(String[] args) {
        Solution443 sol = new Solution443();
        char[] arr = {'a','a','b','b','c','c','c'};
        char[] arr1 = {'a'};
        char[] arr2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        sol.compress(arr2);
    }
}
