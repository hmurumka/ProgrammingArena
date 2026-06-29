package practice.dsa;

import java.util.Arrays;
import java.util.Objects;

/**
 * Squares of a Sorted Array
 * Easy
 * Acceptance: 72.8%
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Examples:
 * Example 1:
 *
 * Input:
 * nums = [-4,-1,0,3,10]
 *
 * Output:
 * [0,1,9,16,100]
 */
public class SquareOfSortedArray {


    static void main(String[] args) {
        squaresOfASortedArray(new int[]{-4,-1,0,3,10});
    }
    public static int[] squaresOfASortedArray(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0)
            return new int[0];

        else {
            nums = Arrays.stream(nums).map(x->x*x).toArray();
            int i = 0;
            int right = nums.length-1;
            int temp = 0;
            while ( i <= right) {
                if(nums[i] > nums[right]) {
                    temp = nums[right];
                    nums[right] = Math.abs(nums[i]);
                    nums[i] = Math.abs(temp);
                }
                right--;
            }
            return nums;
        }
    }

}
