package SDESheet.Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubintervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> res = new ArrayList<>();

        for (int[] arr: intervals){
            if(res.isEmpty()) {
                res.add(arr);
                continue;
            }
            int[] prev = res.get(res.size()-1);
            if(prev[1] >= arr[0]){
                res.add(new int[]{prev[0], Math.max(arr[1], prev[1])});
                res.remove(prev);
            } else{
                res.add(arr);
            }
        }
        res.toArray();
        System.out.println(res);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                /*{1,3},
                {2,6},
                {8,10},
                {15,18}*/
                {1,4},
                {3,5},
                {6,8},
                {10,12},
                {8,9}
        };
        merge(intervals);
    }
}
