package practice.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



/**
 * Find the Symmetric Difference
The mathematical term symmetric difference (△ or ⊕) of two sets is the set of elements which are in either of the two sets but not in both. For example, for sets A = {1, 2, 3} and B = {2, 3, 4}, A △ B = {1, 4}.

Symmetric difference is a binary operation, which means it operates on only two elements. So to evaluate an expression involving symmetric differences among three elements (A △ B △ C), you must complete one operation at a time. Thus, for sets A and B above, and C = {2, 3}, A △ B △ C = (A △ B) △ C = {1, 4} △ {2, 3} = {1, 2, 3, 4}.

Create a function that takes two or more arrays and returns an array of their symmetric difference. The returned array must contain only unique values (no duplicates).
 */
public class SymmetricDifference {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSymmetric(new int[]{1, 2, 3}, new int[]{2, 3, 4}, new int[]{2, 3})));
    }

    private static int[] findSymmetric(int[]... arrays)
    {

        if(arrays.length < 2)
            return arrays[0];
        else{
            int[] result = arrays[0];
            for (int i = 1; i < arrays.length; i++) {
                result = sym(result, arrays[i]);
            }

            return result;
        }

    }

    private static int[] sym(int[] a, int[] b)
    {
        // check for both the array
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            if(set.contains(b[i]))
                set.remove(b[i]);
            else
                set.add(b[i]);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
           
    }
}
