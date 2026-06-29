package practice.dsa;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(findMaxGap(529));
    }

    private static int findMaxGap(int N)
    {
        String s = Integer.toBinaryString(N);
        int ones = 0, zeros = 0, maxDiff = 0;
        char[] arr = s.toCharArray();
        /*int left = 0, right = arr.length-1;

        while(left < right)
        {
            if(arr[left] == 1)
                left++;
        }*/

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '1')
                ones++;
        }

        if(ones > 1)
        {
            ones = 0;

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == '1')
                    ones++;

                if(arr[i] == '0' && ones == 1)
                {
                    zeros++;
                }

                if(ones%2 == 0)
                {
                    ones--;
                    maxDiff = (zeros > maxDiff) ?  zeros : maxDiff;
                    zeros = 0;
                }
            }

            return maxDiff;
        }
        return 0; // if no success condition met, then returns 0;
    }
}
