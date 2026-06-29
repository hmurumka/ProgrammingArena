package practice.dsa;


/**
 * Container With Most Water
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * Example 2:
 * 
 * Input: height = [1,1]
 * Output: 1
 */
public class MaxConatinerWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        //System.out.println(maxArea(new int[] { 1, 1 }));
        //System.out.println(maxArea(new int[] { 1,8,100,2,100,4,8,3,7 }));
    }

    private static int maxArea(int[] heights) {
        int maxArea = 0;
        int width = 0, height = 0;
        if (heights == null || heights.length == 0)
            return maxArea;
        else {
            int left = 0, right = heights.length-1;

            while(left < right)
            {
                width = right - left;
                height = Math.min(heights[left], heights[right]);

                int tempArea = width * height;
                maxArea = (maxArea < tempArea) ? tempArea : maxArea;

                if(heights[left] < heights[right])
                    left++;
                else
                    right--;
            }
        }

        return maxArea;
    }
}
