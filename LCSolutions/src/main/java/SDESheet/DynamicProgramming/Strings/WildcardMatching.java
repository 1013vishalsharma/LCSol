package main.java.SDESheet.DynamicProgramming.Strings;

public class WildcardMatching {

    static boolean match = false;
    public boolean recursiveIsMatch(String s, String p) {
        recur(s, 0, p, 0);
        System.out.println(match);
        return match;
    }

    private void recur(String s, int idx1, String p, int idx2){
        if(idx1 <= s.length()-1 && idx2 <= p.length()-1){
            System.out.println(s.substring(idx1) + ", " + p.substring(idx2));
        }
        if(s.length()==0) {
            if (p.chars().mapToObj(x -> (char) x).allMatch(c -> c == '*')) {
                match = true;
                return;
            } else {
                return;
            }
        }
        if(match){
            return;
        }
        else if((idx2 == p.length()-1 && p.charAt(idx2) == '*') || idx1 == s.length() && idx2 == p.length()){
            match = true;
            return;
        }
        else if(idx1 > s.length()-1 || idx2 > p.length()-1){
            return;
        }
        else if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            recur(s, idx1 + 1, p, idx2 + 1);
        }
        else if(p.charAt(idx2) == '*'){
            recur(s, idx1, p, idx2 + 1);
            recur(s, idx1 + 1, p, idx2);
        }
    }

    public boolean dpIsMatch(String s, String p) {
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];

        dp[dp.length-1][dp[0].length-1] = true;

        for (int i = dp.length-2; i>=0; i--){
            if(p.charAt(i) == '*'){
                dp[i][dp[0].length-1] = dp[i+1][dp[0].length-1];
            }
        }

        for (int i = dp.length-2; i>=0; i--){
            for (int j = dp[0].length-2; j>=0; j--){
                if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
                    dp[i][j] = dp[i+1][j+1];
                } else if (p.charAt(i) == '*') {
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }


        System.out.println(dp[0][0]);
        return dp[0][0];
    }

    public static void main(String[] args) {
        WildcardMatching sol = new WildcardMatching();
        String p = "ab*cd";
        String s = "abdefcd";
        p = "**abcd";
        s = "abcd";
        p = "?ay";
        s = "ray";
        p = "ab?d";
        s = "abcc";
        s = "aa";
        p = "*";
        s = "adceb";
        p = "*a*b";
        s = "acdcb";
        p = "a*c?b";
        //s = "";
        //p = "***";
        //s = "ho";
        //p = "ho***";
        //sol.recursiveIsMatch(s, p);
        sol.dpIsMatch(s, p);
    }
}
