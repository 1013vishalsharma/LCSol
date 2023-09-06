package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CominationSumOne {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sum(candidates, target, res, new ArrayList<>(), 0);
        System.out.println(res);
        return res;
    }

    private void sum(int[] candidates, int target, List<List<Integer>> res, List<Integer> currRes, int idx){
        if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(currRes));
            }
            return;
        }
        if(candidates[idx] <= target) {
            currRes.add(candidates[idx]);
            System.out.println(currRes);
            sum(candidates, target - candidates[idx], res, currRes, idx);
            currRes.remove(currRes.size()-1);
        }
        sum(candidates, target, res, currRes, idx+1);
    }

    public static void main(String[] args) {
        CominationSumOne sol = new CominationSumOne();
        sol.combinationSum(new int[]{2,3,6,7}, 7);

    }
}
