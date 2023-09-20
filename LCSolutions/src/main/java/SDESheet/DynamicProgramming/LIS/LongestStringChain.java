package main.java.SDESheet.DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        dp[0] = 1;
        Arrays.stream(words).forEach(x -> System.out.print(x + " "));
        int totalMax = dp[0];
        for (int i=1; i<words.length; i++){
            int max = 1;
            for (int j=i-1; j>=0; j--){
                if(comapreStrings(words[j].toCharArray(), words[i].toCharArray()) && dp[j]+1 > max){
                    max = dp[j]+1;
                }
            }
            dp[i] = max;
            if(max > totalMax){
                totalMax = max;
            }
        }
        System.out.println(totalMax);
        return totalMax;
    }

    private boolean comapreStrings(char[] s, char[] t){
        int i = 0, j=0, count=0;
        while(j < t.length && i < s.length){
            if(s[i] == t[j]){
                i++;
                j++;
            } else {
                count++;
                j++;
            }
        }

        if(i < s.length){
            count = count + s.length - i;
        }
        if(j < t.length){
            count = count + t.length - j;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        LongestStringChain sol = new LongestStringChain();
        //String[] arr = {"a","b","ba","bca","bda","bdca"};
        //String[] arr = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        //String[] arr = {"abcd","dbqca"};
        String[] arr = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        //String[] arr = {"czvh", "zczvh", "zcpzvh", "zczpzvh", "zczpzvhx", "zczpzvdhx", "zczpzfvdhx"};
        sol.longestStrChain(arr);
    }
}
