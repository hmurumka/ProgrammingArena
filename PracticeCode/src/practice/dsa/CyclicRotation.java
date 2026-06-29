package practice.dsa;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 9, 7, 6};
        arr = getRotatedArry(arr, 7);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getRotatedArry(int[] a, int rotation) {
        int[] result = new int[]{};
        if(a == null || a.length < 1)
            return result;
        else if(a.length == 1 || rotation == 0)
            return a;
        else
        {
            int newIndex = -1;
            result = new int[a.length];
            rotation = rotation>a.length ?  rotation%a.length :  rotation;
            for (int i = 0; i < a.length; i++) 
            {
                newIndex = i+rotation;
                newIndex = (newIndex >= a.length) ? (newIndex-a.length) : newIndex;
                
                result[newIndex] = a[i];
                
            }

            return result;
        }



    }
}
