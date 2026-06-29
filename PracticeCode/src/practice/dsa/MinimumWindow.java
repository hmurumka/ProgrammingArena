package practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Minimum Window Sort
 * Medium
 * Acceptance: 40.5%
 * Given an array of integers, find the length of the shortest subarray that, if sorted, would make the whole array sorted in ascending order.
 *
 * Return the length of such subarray. If the array is already sorted, return 0.
 *
 * Examples:
 * Example 1:
 *
 * Input:
 * [2, 6, 4, 8, 10, 9, 15]
 *
 * Output:
 * 5
 *
 * Explanation:
 * Sorting the subarray [6, 4, 8, 10, 9] makes the whole array sorted.
 *
 * Example 2:
 *
 * Input:
 * [1, 2, 3, 4]
 *
 * Output:
 * 0
 */
public class MinimumWindow {

    static void main(String[] args) {
        //System.out.println(minimumWindowSort(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(minimumWindowSort(new int[]{1,2,3,4}));
    }

    public static int minimumWindowSort(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0)
            return 0;
        else{
            int minIndex = 0, maxIndex = nums.length-1;
            while(minIndex < nums.length-1 && (nums[minIndex] <  nums[minIndex+1]))
                minIndex++;
            while(minIndex != maxIndex && (nums[maxIndex] > nums[maxIndex-1]))
                maxIndex--;
            if(minIndex != maxIndex && minIndex < maxIndex)
            {
                List<Integer> integers = new ArrayList<>();
                while(minIndex <= maxIndex) {
                    integers.add(nums[minIndex]);
                    minIndex++;
                }
                return integers.size();
            }
        }

        return 0;
    }
}
