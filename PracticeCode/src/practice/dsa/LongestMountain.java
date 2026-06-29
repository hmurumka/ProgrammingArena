package practice.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Longest Mountain In Array
 * Medium
 * Acceptance: 39.3%
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 *
 * A subarray is a contiguous part of an array.
 *
 * Examples:
 * Example 1:
 *
 * Input:
 * arr = [2,1,4,7,3,2,5]
 *
 * Output:
 * 5
 *
 * Explanation:
 * The longest mountain is [1,4,7,3,2] which has length 5.
 *
 * Example 2:
 *
 * Input:
 * arr = [2,2,2]
 *
 * Output:
 * 0
 *
 * Explanation:
 * There is no mountain subarray.
 */
public class LongestMountain {

    static void main(String[] args) {
        //System.out.println(longestMountainInArray(new int[]{2,1,4,7,3,2,5}));
        //System.out.println(longestMountainInArray(new int[]{1,2,1}));
        System.out.println(longestMountainInArray(new int[]{1,1,1}));
    }

    public static int longestMountainInArray(int[] nums) {

        if(Objects.isNull(nums) || nums.length < 3)
            return 0;
        else {
            int largestMountain = 0;
            List<Integer> peaks = new ArrayList<>();
            final List<Integer> mountain = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                // find the peak
                if (nums[i+1] > nums[i] && nums[i+1] > nums[i + 2])
                    peaks.add(i+1); // got the peak.

            }
            if(peaks.size() > 0)
            {
                peaks.forEach(peak->{
                    int left = peak, right = peak;
                    while (left > 0 && nums[left] > nums[left - 1])
                        left--;
                    while (right < nums.length-1 && nums[right] > nums[right + 1])
                        right++;

                    mountain.add(right==left ? 0 : (right - left) + 1);
                    //largestMountain = (largestMountain < (right==left ? 0 : (right - left) + 1) ? (right==left ? 0 : (right - left) + 1) : largestMountain);
                });
                return mountain.stream().max(Integer::compare).get();
            }else
                return 0;

        }
    }
}
