package main.java.SDESheet.DynamicProgramming.Strings;

public class LongestCommonSubsequence {

    public int recursiveLongestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int len = recur(text1, len1-1, text2, len2-1);
        System.out.println(len);
        return len;
    }

    private int recur(String text1, int len1, String text2, int len2){
        if(len1 < 0 || len2 < 0){
            return 0;
        }
        if(text1.charAt(len1) == text2.charAt(len2)){
            return 1 + recur(text1, len1-1, text2, len2-1);
        } else if(text1.charAt(len1) != text2.charAt(len2)){
            return Math.max(recur(text1, len1-1, text2, len2), recur(text1, len1, text2, len2-1));
        }
        return 0;
    }

    public void dpLongestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length()+1][ text2.length()+1];

        for (int i = text1.length()-1; i>=0 ;i--){
            for (int j = text2.length()-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else if (text1.charAt(i) != text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);
        printLCS(text1, text2, dp);
    }

    private void printLCS(String text1, String text2, int[][] dp){
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        while(i<text1.length() && j < text2.length()){
            if(text1.charAt(i) == text2.charAt(j)){
                sb.append(text1.charAt(i));
                i++;
                j++;
            } else {
                if(dp[i+1][j] < dp[i][j+1]){
                    j++;
                } else {
                    i++;
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        //sol.recursiveLongestCommonSubsequence("abcd", "efgh");
        sol.dpLongestCommonSubsequence("abcde", "bdgek");
        //sol//.dpLongestCommonSubsequence();

    }
}
