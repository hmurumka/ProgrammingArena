package practice.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Top K Frequent Elements
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */


public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopKFrequent(new int[]{1,1,1,2,2,2,4,4,5,6,9,10,9}, 2)));

    }

    static int[] findTopKFrequent(int[] nums, int k)
    {
        if(Objects.isNull(nums) || nums.length < 1)
            return null;
        else
        {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            return map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(2)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
