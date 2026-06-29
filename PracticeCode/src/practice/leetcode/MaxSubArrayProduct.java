package practice.leetcode;
/**
 * Maximum Product Subarray
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

 * MaxSubArrayProduct
 */
public class MaxSubArrayProduct {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{2,3,-2,4}));;
    }

    private static class Solution {
        public int maxProduct(int[] nums) {
            int maxP = Integer.MIN_VALUE;
            int prefix = 1, suffix = 1;

            for(int i=0;i<nums.length;i++)
            {
                prefix = prefix*nums[i];
                suffix = suffix*nums[nums.length-i-1];

                maxP = Math.max(maxP, Math.max(prefix, suffix));

                if(suffix == 0)
                    suffix = 1;
                if(prefix == 0)
                    prefix = 1;

            }

            return maxP;
        }
    }

}
