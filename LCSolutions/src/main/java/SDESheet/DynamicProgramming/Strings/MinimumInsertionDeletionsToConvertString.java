package main.java.SDESheet.DynamicProgramming.Strings;

public class MinimumInsertionDeletionsToConvertString {

    public static int canYouMake(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        //dp[dp.length-1][dp[0].length-1] = 1;

        for (int i=dp.length-2; i>=0; i--){
            for (int j=dp[0].length-2; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
        int res = s1.length() - dp[0][0] + s2.length() - dp[0][0];
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        //s1 = "vjks";
        //s2 = "rfvmkos";
        s1 = "edl";
        s2 = "xcqja";
        MinimumInsertionDeletionsToConvertString.canYouMake(s1, s2);
    }
}
