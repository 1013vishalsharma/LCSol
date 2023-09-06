package SDESheet.Arrays_I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr;
        List<Integer> prev = null;

        for (int i = 0; i<numRows; i++){
            curr = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                } else {
                    curr.add(prev.get(j-1) + prev.get(j));
                }
            }
            res.add(curr);
            prev = curr;
        }
        System.out.println(res);
    }
}
