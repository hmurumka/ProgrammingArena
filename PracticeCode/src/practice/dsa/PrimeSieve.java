package practice.dsa;

/*The Prime Sieve, more commonly known as the Sieve of Eratosthenes,
is an efficient algorithm used to find all prime numbers up to a given number N.
It is particularly useful because it avoids unnecessary repetitive division checks for each number.
 */
// Example : 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 (Array might be sorted or unsorted)
// Result: Primes ≤ 20 are 2, 3, 5, 7, 11, 13, 17, 19.

import java.util.Arrays;

public class PrimeSieve {

    static void main() {
        int[] arr = {2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        boolean[] flags = new boolean[arr.length+1];
        Arrays.fill(flags, true);

        flags[0] = false;
        flags[1] = false;

        for(int idx=2; idx < arr.length; idx++)
        {
            if(flags[idx])
            {

            }
        }
    }
}
