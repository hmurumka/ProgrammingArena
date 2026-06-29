package practice.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSinglePointer {

    static void main(String[] args) {
        System.out.println(removeDuplicatesFromSortedArray(new int[]{1,1,2,3,3,4,5}));
    }

    public static int removeDuplicatesFromSortedArray(int[] nums) {
        Set<Integer> list = new HashSet<Integer>();
        if(nums != null && nums.length ==0)
            return 0;
        else
        {
            int next = 0;
            for(int i = 0; i < nums.length; i++)
            {
                next = i+1;
                if(next >= nums.length)
                    next = i;
                if(nums[i] != nums[next])
                {
                    list.add(nums[i]);
                    list.add(nums[next]);
                }
                else
                    list.add(nums[i]);

            }
        }

        return (int)list.stream().count();
    }
}
