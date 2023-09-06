package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSum {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {5,2,1};

        List<Integer> li = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        // since empty set is always going to be in the answer so
        ans.add(new ArrayList<>());

        int c = 0, i = 0;
        createSubSet(arr, ans, c, new ArrayList<>(), set);
        System.out.println(3/2);
        System.out.println(ans);
        System.out.println(set);

    }

    private static void createSubSet(int[] arr, List<List<Integer>> ans, int c, List<Integer> li, Set<List<Integer>> set) {
        if (c == arr.length) {
            ans.add(new ArrayList<>(li));
            set.add(new ArrayList<>(li));
            return;
        }

        li.add(arr[c]);
        createSubSet(arr, ans, c + 1, li, set);
        li.remove(li.size() - 1);
        createSubSet(arr, ans, c + 1, li, set);
    }
}
