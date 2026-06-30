package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 
 * Given a string text, find the maximum length of consecutive 
 * identical characters(excluding whitespace) and return all the character that occur
 * consucatively with the maximum length.
 * 
 * Input : "thiis iss a teest seentennce"
 * Output : ['i', 's', 'e', 'e', 'n']
 * 
 * 
 * MaxRepeatedCharacter
 */
public class MaxRepeatedCharacter {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getMaxRepeatedChars("thiis iss a teest seentennce");

    }
    private static class Solution{
        private char[] getMaxRepeatedChars(String s)
        {
            char[] arr = s.toCharArray();
            int maxLength = 0, maxFreq = 1;
            List<Character> l = new ArrayList<>();

            // find the max consecutive length for repeated character
            for(int i = 0; i < arr.length-1; i++)
            {
                if(arr[i] == ' ' || arr[i+1] == ' ')
                    continue;
                if(arr[i] == arr[i+1])
                    maxFreq++;
                else{
                    maxLength = maxLength > maxFreq ? maxLength : maxFreq;
                    maxFreq = 1;
                }
            }

            // chaeck for all the character having same consecutive length
            maxFreq = 1;
            for(int i = 0; i < arr.length-1; i++)
            {
                if(arr[i] == arr[i+1])
                    maxFreq++;

                if(maxFreq == maxLength)
                {
                    l.add(arr[i]);
                    maxFreq = 1;
                }
                    
            }

            return l.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
        }
    }
}
