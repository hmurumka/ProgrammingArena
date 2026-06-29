package practice.dsa;

// print a febbonachi series up to < Number N
public class Febonacchi {

    static void main() {
        int number = 3;
        printFebbonachi(number);
    }

    private static int printFebbonachi(int num) {

        if(num == 0) {
            System.out.println("0 ");
            return 0;
        }
        else
        {
            System.out.println(printFebbonachi(--num) + printFebbonachi(num));
            return num;
        }


    }
}
