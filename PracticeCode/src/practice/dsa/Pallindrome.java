package practice.dsa;

import java.util.Objects;

public class Pallindrome {

    public static void main(String[] args) {

        System.out.println(isPallindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPallindrome("race a car"));
        System.out.println(isPallindrome("0P"));
    }

    private static boolean isPallindrome(String s) {
        if (Objects.isNull(s) || s.length() == 0)
            return false;
        else if (s.length() == 1)
            return true;
        else {
            int balance = 0;
            char[] chars = s.toCharArray();
            StringBuffer buff = new StringBuffer();
            if (chars.length >= 1 && chars.length <= 2 * Math.pow(10, 5)) {
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isLetterOrDigit(chars[i])) {
                        // buff.append(Character.toLowerCase(chars[i]));
                        buff.append(Character.toLowerCase(chars[i]));
                    }
                }
                int left=0, right=buff.length()-1;
                char[] resultArr = buff.toString().toCharArray();
                while(left < right)
                {
                    if(resultArr[left] != resultArr[right])
                        return false;
                    left++;
                    right--;
                }
                return true;
            }

            return false;
        }

    }

}
