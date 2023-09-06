package SDESheet.Arrays_I;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRepeatingAndMissingNumber {

    public static void main(String[] args) {

        int[] arr = {3,1,2,5,4,6,7,5};
        int sum = ((arr.length) * (arr.length + 1)) / 2;
        Set<Integer> set = new HashSet<>();
        int duplicate = 0;

        for (int i: arr){
            if(set.contains(i)){
                duplicate = i;
            } else {
                set.add(i);
                sum -= i;
            }
        }
        System.out.println("missing number: " + sum + ", duplicate number: " + duplicate);
    }
}
