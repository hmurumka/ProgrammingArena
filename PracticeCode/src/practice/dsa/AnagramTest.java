package practice.dsa;

import java.util.Objects;

public class AnagramTest {

     public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "agramna"));
     }

     private static boolean isAnagram(String s, String t)
     {
        if(Objects.isNull(s) || Objects.isNull(t))
            return false;
        else if (s.length() != t.length())
            return false;
        else
        {
            int sArrSum = 0, tArrSum = 0;
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            for (char c : sArr) {
                sArrSum += Character.getNumericValue(c);
            }

            for (char c : tArr) {
                tArrSum += Character.getNumericValue(c);
            }

            return sArrSum == tArrSum ? true : false;
        }
     }
}