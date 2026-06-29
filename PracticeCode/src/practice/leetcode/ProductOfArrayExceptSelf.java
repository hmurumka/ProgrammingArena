package practice.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
}
private static class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] prefix = new int[length];
        int[] suffix = new int[length];

        prefix[0] = 1;
        suffix[length-1] = 1;

        // initilize prefix arr
        for(int i = 1; i < length; i++)
        {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = length-2; i >= 0; i--)
        {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}


}
