package practice.leetcode;
/**
 * 
 * ReverseNumber
 * 
 * Program reverse the Number from Back to front
 * eg. 12345 -> 54321
 */
public class ReverseNumber {
    public static void main(String[] args) {
        ReverseNumber o = new ReverseNumber();
        System.out.println(o.reverse(12345));
    }

    private int reverse(int i)
    {
        int reminder = 0;
        StringBuilder b = new StringBuilder();
        while((reminder = i%10) > 0)
        {
            i = i/10;
            b.append(reminder);
        }

        return Integer.parseInt(b.toString());
    }
}
