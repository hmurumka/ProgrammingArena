package practice.leetcode;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex obj = new PivotIndex();
        System.out.println(obj.getPivotIndex(new int[]{2, 1, -1}));
    }

    private int getPivotIndex(int[] a)
    {
        int[] sum = new int[a.length];
        int left_sum = 0, right_sum = 0;
        for (int i = 0; i < a.length; i++) {
            left_sum = 0;
            right_sum = 0;
            for (int j = i-1; j >=0; j--) {
                left_sum += a[j];
            }
            for (int k = i+1; k < a.length; k++) {
                right_sum += a[k];
            }

            sum[i] = left_sum-right_sum;
        }

        OptionalInt opt = IntStream.range(0, sum.length)
                .filter(i -> sum[i]==0).findFirst();
        if(opt.isPresent())
            return opt.getAsInt();
        else
            return -1;
    }

    
}
