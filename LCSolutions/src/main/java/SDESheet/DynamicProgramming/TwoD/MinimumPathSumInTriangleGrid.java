package main.java.SDESheet.DynamicProgramming.TwoD;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSumInTriangleGrid {

    static int minTotal = Integer.MAX_VALUE;
    public int recursiveMinimumTotal(List<List<Integer>> triangle) {
        minimumSum(triangle, 0, 0, 0);

        return minTotal;
    }

    private int minimumSum(List<List<Integer>> triangle, int pos, int rowIdx, int count){
        if(rowIdx >= triangle.size() || pos >= triangle.get(rowIdx).size() || rowIdx < 0 || pos < 0){
            return count;
        }
        else {
            count = count + triangle.get(rowIdx).get(pos);
            if(rowIdx == triangle.size()-1){
                if(count < minTotal){
                    minTotal = count;
                }
                System.out.println("count: " + count + " minTotal: " + minTotal);
            }
            count = minimumSum(triangle, pos+1, rowIdx, count);
            count = minimumSum(triangle, pos, rowIdx+1, count);
            count = count - triangle.get(rowIdx).get(pos);
            return count;
        }
    }

    public void dpMinimumPathSum(List<List<Integer>> triangle){
        List<List<Integer>> dp = new ArrayList<>();
        //dp.add(List.of(triangle.get(0).get(0)));

        for (int i=0; i< triangle.size(); i++){
            List<Integer> li = new ArrayList<>(triangle.get(triangle.size()-1).size());
            int prev = 0;
            for (int j = 0; j<triangle.get(i).size(); j++){
                if(i==0){
                    li.add(triangle.get(i).get(j));
                } else {
                    if(j == 0){
                        prev = triangle.get(i).get(j) + dp.get(i-1).get(j);
                        li.add(prev);
                    } else {
                        if(dp.get(i-1).size() >= j+1){
                            li.add(Math.min(prev, dp.get(i-1).get(j)) + triangle.get(i).get(j));
                        } else {
                            li.add(prev + triangle.get(i).get(j));
                        }
                    }
                }
            }
            dp.add(li);
        }

        int min = dp.get(dp.size()-1)
                .stream().min(Integer::compareTo).get();
        System.out.println(min);
    }

    public static void main(String[] args) {
        MinimumPathSumInTriangleGrid sol = new MinimumPathSumInTriangleGrid();
        List<List<Integer>> triangle =
                List.of(
                        List.of(1),
                        List.of(2,3),
                        List.of(3,6,7),
                        List.of(8,9,6,10));
                /*List.of(
                        List.of(2),
                        List.of(3,4),
                        List.of(6,5,7),
                        List.of(4,1,8,3));*/
        //sol.recursiveMinimumTotal(triangle);
        sol.dpMinimumPathSum(triangle);
    }
}
