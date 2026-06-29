package practice.leetcode;

import java.util.Objects;

/**
 * 
 * SwapVowels
 * 
 * Interchange Vowels 
 * Input : hello
 * Output : holle
 * 
 * Input: s = "IceCreAm"
 * Output: "AceCreIm"
 * 
 */
public class SwapVowels {

    public static void main(String[] args) {
        SwapVowels o = new SwapVowels();
        System.out.println(o.swap("IceCreAm"));
    }

    private String swap(String s)
    {
        if(Objects.isNull(s) || s.isBlank() || s.isEmpty())
            return "No valid Input";
        else{
            char[] arr = s.toCharArray();
            int left = 0, right = arr.length-1;
            boolean leftV, rightV;
            char temp;
            while(left < right)
            {
                leftV = isVowel(arr[left]);
                rightV = isVowel(arr[right]);

                if(leftV == true && rightV == true)
                {
                    temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }
                if(!leftV)
                    left++;
                if(!rightV)
                    right--;

                leftV = false;
                rightV = false;
            }

            return new String(arr);
        }
    }

    private boolean isVowel(char c)
    {
        char ch = Character.toUpperCase(c);
        if(ch == 'A' 
        || ch == 'E'
        || ch == 'I'
        || ch == 'O'
        || ch == 'U')
        return true;
        else
            return false;
    }
}
