package main.java.SDESheet.DynamicProgramming.Strings;

public class LongestCommonSubstring {

    static int max = Integer.MIN_VALUE;
    public static int recursiveLcs(String str1, String str2){
        int i = recur(str1, str1.length()-1, str2, str2.length()-1, 0);
        System.out.println(max);
        System.out.println(i);
        return max;
    }

    private static int recur(String str1, int idx1, String str2, int idx2, int count) {
        if (idx1 == -1 || idx2 == -1) {
            return 0;
        }
        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            count = count + 1;
            if (count > max) {
                max = count;
            }
            return 1 + recur(str1, idx1 - 1, str2, idx2 - 1, count);
        } else {
            recur(str1, idx1 - 1, str2, idx2, 0);
            recur(str1, idx1, str2, idx2 - 1, 0);
        }
        //return 0;
        /*if(str1.charAt(idx1) == str2.charAt(idx2)){
            count=count+1;
            if(count > max){
                max = count;
            }
            return 1 + recur(str1, idx1+1, str2, idx2+1, count);
        }
        if(str1.charAt(idx1) != str2.charAt(idx2)){
            count = 0;
            return Math.max(recur(str1, idx1+1, str2, idx2, count), recur(str1, idx1, str2, idx2+1, count));
        }
        return 0;*/
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "abbedabdaec";
        String str2 = "bebccc";
        str1 = "abbedabdaec";
        str2 = "bebccc";
        LongestCommonSubstring.recursiveLcs(str1, str2);
    }
}
