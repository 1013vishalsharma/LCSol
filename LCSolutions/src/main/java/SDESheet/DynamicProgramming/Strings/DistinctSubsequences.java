package main.java.SDESheet.DynamicProgramming.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctSubsequences {

    static int count = 0;
    public int recursiveNumDistinct(String s, String t) {
        count = 0;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (int i=0; i<arr1.length; i++){
        List<Character> li = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
            li.add(arr1[i]);
            index.add(i);
            recur(arr1, arr2, i, li, index);
        }
        System.out.println(count);
        return count;
    }

    private void recur(char[] s, char[] t, int idx, List<Character> li, List<Integer> index){
        if (li.size() == t.length && idx == s.length-1){
            for (int i=0; i<li.size(); i++){
                if(li.get(i) != t[i]){
                    return;
                }
            }
            System.out.println(li + " , " + index);
            count++;
        }
        if(idx == s.length-1 || li.size() > t.length){
            return;
        }
        li.add(s[idx+1]);
        index.add(idx+1);
        recur(s, t, idx+1, li, index);
        li.remove(li.size()-1);
        index.remove(index.size()-1);
        recur(s, t, idx+1, li, index);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];

        for (int i=0; i<dp[0].length; i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        DistinctSubsequences sol = new DistinctSubsequences();
        //sol.recursiveNumDistinct("rabbbit", "rabbit");
        //sol.recursiveNumDistinct("babgbag", "bag");
        sol.numDistinct("babgbag", "bag");

    }
}
