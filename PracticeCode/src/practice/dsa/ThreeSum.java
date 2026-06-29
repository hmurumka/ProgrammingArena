package practice.dsa;

import java.util.*;

/*
3Sum
Medium
Acceptance: 29.2%
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Examples:
Example 1:

Input:
nums = [-1,0,1,2,-1,-4]

Output:
[[-1,-1,2],[-1,0,1]]

Explanation:
The triplets that sum to zero are [-1, -1, 2] and [-1, 0, 1].
 */
public class ThreeSum {

    static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    static List<List<Integer>> threeSum(int[] nums) {
        if(Objects.isNull(nums) || nums.length < 3)
            return Collections.emptyList();
        else
        {
            Arrays.sort(nums);
            int left = 0, right = 0, sum = 0;// left and right pointers
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                left = i+1;
                right = nums.length-1;
                while(left < right)
                {
                    sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0)
                        left++;
                    else if (sum > 0)
                        right--;
                    else // sum = 0;
                    {
                        //System.out.printf("[ %s, %s, %s]", nums[i], nums[left], nums[right]);
                        List<Integer> elements = new ArrayList<>();
                        elements.add(nums[i]);
                        elements.add(nums[left]);
                        elements.add(nums[right]);
                        result.add(elements);
                        break;
                    }
                }
            }

            return result;

        }
    }
}
