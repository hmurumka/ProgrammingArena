package practice.dsa;

/*
Trapping Rain Water
Hard
Topics
premium lock icon
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */

public class TrapingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        //System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    private static int trap(int[] heights) {
        int trappedWater = 0;
        
        /*if (heights == null || heights.length == 0)
            return trappedWater;
        else {
            int left = 0, right = heights.length-1, lMax = 0, rMax = 0;

            while(left < right)
            {

                lMax = Math.max(lMax, heights[left]);
                rMax = Math.max(rMax, heights[right]);

                if(lMax < rMax)
                {
                    trappedWater += lMax - heights[left];
                    left++;
                }else{
                    trappedWater += rMax - heights[right];
                    right--;
                }
            }
        }*/
       
       for (int i = 0; i < heights.length; i++) {
            int leftMax = heights[i],rightMax = heights[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }
            for (int j = i+1; j < heights.length; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }

            trappedWater += Math.min(leftMax, rightMax) - heights[i];
       }

        return trappedWater;


    }
}


