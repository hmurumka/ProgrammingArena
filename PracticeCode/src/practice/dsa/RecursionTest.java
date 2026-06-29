// insert a number 'N' at the last in the stack

package practice.dsa;

import java.util.Stack;

public class RecursionTest {

    public static void main(String[] args) {
       Stack<Integer> sk  = new Stack<>();

       insertDummyData(sk);

        int N = 10;
        insertNLast(sk, N);

        System.out.println("OutPut");
        System.out.println(sk);
    }

    private static void insertDummyData(Stack<Integer> sk) {
        sk.push(3);
        sk.push(2);
        sk.push(5);
        sk.push(4);
        sk.push(8);
        sk.push(9);

    }

    private static void insertNLast(Stack<Integer> stk, int number) {
        int element;
        if(stk.isEmpty()) {
            stk.push(number);
            return;
        }
        else element = stk.pop();

        insertNLast(stk,number);
        stk.push(element);
    }
}