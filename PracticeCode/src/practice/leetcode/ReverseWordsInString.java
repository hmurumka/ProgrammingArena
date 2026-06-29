package practice.leetcode;

/**
 * 
 * ReverseWordsInString
 * Reverse Words in a String
Medium
Topics
premium lock icon
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
 */
public class ReverseWordsInString {

public static void main(String[] args) {
    Solution s = new Solution();
    //System.out.println(s.reverseWords("the sky is blue"));
    System.out.println(s.reverseWords("a good   example"));
}


private static class Solution {
    public String reverseWords(String s) {
        if(s.isBlank() || s.isEmpty())
            return s;

        s = s.strip();
        String[] strA = s.split("\\s+");

        if(strA.length == 1)
            return strA[0];

        int left = 0, right = strA.length-1;
        String temp;
        while(left < right)
        {   
            temp = strA[right];
            strA[right] = strA[left];
            strA[left] = temp;

            right--; left++;
        }

        return String.join(" ", strA);
        
    }


}

    
}
