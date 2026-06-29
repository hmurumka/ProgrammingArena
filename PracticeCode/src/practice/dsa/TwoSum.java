package practice.dsa;

import java.util.HashMap;
import java.util.Map;

/*
Two Sum
Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Examples:
Example 1:

Input:
nums = [2,7,11,15], target = 9
 */
public class TwoSum {

    static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int diff = 0;
        for(int i = 0; i < nums.length; i++)
        {
            diff = target-nums[i];
            if(map.containsKey(Integer.valueOf(diff)))
                return new int[] {map.get(Integer.valueOf(diff)), i};
            map.put(nums[i],i);
        }
        return null;
    }
}
