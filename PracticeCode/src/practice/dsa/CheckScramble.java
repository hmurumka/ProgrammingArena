package practice.dsa;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CheckScramble {
    static void main(String[] args) {
        String s1 = "great", s2="rgeat";
        if(args.length > 0)
        {
            s1 = !args[0].isEmpty() ? args[0] : s1;
            s2 = !args[1].isEmpty() ? args[1] : s2;
        }
        if(s1.length()==1)
            System.out.println(s1.equals(s2));
        else
            System.out.println(isScramble(s1, s2));

    }

    private static boolean isScramble(String s1, String s2) {
        int randIdx = ThreadLocalRandom.current().nextInt(0, s1.length()-1);



        return false;
    }
}
