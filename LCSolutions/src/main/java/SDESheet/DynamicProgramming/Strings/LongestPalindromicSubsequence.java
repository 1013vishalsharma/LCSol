package main.java.SDESheet.DynamicProgramming.Strings;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubsequence {

    static int size = Integer.MIN_VALUE;
    public int recursiveLongestPalindromeSubseq(String s) {
        for (int i=0; i<s.length(); i++){
            List<Character> pal = new ArrayList<>();
            pal.add(s.charAt(i));
            recur(s, i, pal);
        }
        return size;
    }

    private void recur(String s, int pos, List<Character> pal){
        if(isPalindrome(pal)){
            if(pal.size() > size){
                size = pal.size();
                System.out.println("size: " + size + " ele: " + pal);
            }
        }
        if(pos >= s.length()-1){
            return;
        }
        pal.add(s.charAt(pos+1));
        recur(s, pos+1, pal);
        pal.remove(pal.size()-1);
        recur(s, pos+1, pal);
    }

    public int dpLongestPalindromeSubseq(String s) {
        char[] orig = s.toCharArray();
        char[] rev = new char[orig.length];

        for (int i=s.length()-1,j=0; i>=0; i--,j++){
            rev[j] = orig[i];
        }

        int[][] dp = new int[orig.length+1][rev.length+1];
        for (int i=dp.length-2; i>=0; i--){
            for (int j=dp[0].length-2; j>=0; j--){
                if(orig[i] == rev[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[0][0]);

        return 0;
    }

    private boolean isPalindrome(List<Character> pal){
        if (pal.size() == 1){
            return true;
        }
        if(pal.isEmpty()){
            return false;
        }
        for (int i=0, j=pal.size()-1; i<pal.size()/2; i++, j-- ){
            if(!pal.get(i).equals(pal.get(j))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
        String str = "bbabcbcab";
        //sol.recursiveLongestPalindromeSubseq(str);
        sol.dpLongestPalindromeSubseq(str);
    }
}
