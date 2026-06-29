package practice.dsa;

import java.util.Arrays;
import java.util.List;

// Happy number is a umber when you sqare of the its each digit and sum then it should
// final come as 1.
// example : 19 ->  1^2 + 9^2 -> 82 -> 8^2 + 2^2 -> 68 -> 6^2 + 8^2 -> 100 -> 1^2 + 0^2 + 0^2 = 1
public class HappyNumber {

    public static void main() {
        int num_ = 19;
        int hareSum = num_;
        int tortoiseSum = num_;
        while(true)
        {
            // hare approach will calculate twice.

            hareSum = findHappyNumber(hareSum, true);


            // tortoise approach will calculate only once.

            tortoiseSum = findHappyNumber(tortoiseSum, false);

            System.out.println("HareSum : [" + hareSum + "]  TortoiseSum : [" + tortoiseSum + "]");
            if(hareSum == tortoiseSum)
            {
                System.out.println("Found : Number [" + num_ + "] is a Happy Number");
                break;
            }
        }


    }


    private static int findHappyNumber(int num, boolean isHare) {

        if (num == 1) return num;
        int sum = String.valueOf(Math.abs(num)).chars().map(c-> c-'0').map(d-> d*d).sum();
        if (isHare){
            return findHappyNumber(sum, false);
        }

        return sum;
    }
}
