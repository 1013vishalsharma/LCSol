package main.java.SDESheet.DynamicProgramming.Strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EditDistance {

    static int min = Integer.MAX_VALUE;
    public int minDistance(String word1, String word2) {
        List<Character> li1 = word1.chars().mapToObj(x -> (char)x).collect(Collectors.toList());
        LinkedList<Character> li = new LinkedList<>(li1);
        recur(word1, word1.length()-1, word2, word2.length()-1, li, 0);
        System.out.println(min);
        return min;
    }

    private void recur(String s1, int idx1, String s2, int idx2, LinkedList<Character> li, int count){

        if(li.stream().map(Object::toString).collect(Collectors.joining()).equals(s2)){
                if(count < min){
                    System.out.println(li);
                    min = count;
                }
            }
        if(idx2 == -1 || idx1 == -1){
            return;
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            recur(s1, idx1+1, s2, idx2+1, li, count);
        } else {
            recur(s1, idx1-1, s2, idx2, li, count+1);
            recur(s1, idx1-1, s2, idx2-1, li, count+1);
            recur(s1, idx1, s2, idx2-1, li, count+1);
        }

        li.addFirst(s2.charAt(idx2));
        recur(s1, idx1 + 1, s2, idx2 + 1, li, count+1);
        li.removeFirst();
        recur(s1, idx1 + 1, s2, idx2 +1, li, count+1);
        li.set(idx1, s2.charAt(idx2));
        recur(s1, idx1 + 1, s2, idx2 +1, li, count+1);
    }

    public int dpMinDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int k = 0;
        for (int i= dp.length-1; i>=0; i--){
            dp[i][dp[0].length-1] = k;
            k++;
        }
        k=0;
        for (int i= dp[0].length-1; i>=0; i--){
            dp[dp.length-1][i] = k;
            k++;
        }

        for (int i=dp.length-2; i>=0; i--){
            for (int j=dp[0].length-2; j>=0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }

        System.out.println(dp[0][0]);
        return dp[0][0];
    }


    public static void main(String[] args) {
        EditDistance sol = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        //word1 = "at";
        //word2 = "ut";
        //sol.minDistance(word1, word2);
        sol.dpMinDistance(word1, word2);
    }
}
