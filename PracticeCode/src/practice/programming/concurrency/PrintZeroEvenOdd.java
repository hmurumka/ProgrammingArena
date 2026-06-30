package practice.programming.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/***
 * LEETCODE - 1116
 * Print Zero Even Odd
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * You have a function printNumber that can be called with an integer parameter
 * and prints it to the console.
 * 
 * For example, calling printNumber(7) prints 7 to the console.
 * You are given an instance of the class ZeroEvenOdd that has three functions:
 * zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three
 * different threads:
 * 
 * Thread A: calls zero() that should only output 0's.
 * Thread B: calls even() that should only output even numbers.
 * Thread C: calls odd() that should only output odd numbers.
 * Modify the given class to output the series "010203040506..." where the
 * length of the series must be 2n.
 * 
 * Implement the ZeroEvenOdd class:
 * 
 * ZeroEvenOdd(int n) Initializes the object with the number n that represents
 * the numbers that should be printed.
 * void zero(printNumber) Calls printNumber to output one zero.
 * void even(printNumber) Calls printNumber to output one even number.
 * void odd(printNumber) Calls printNumber to output one odd number.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously.
 * One of them calls zero(), the other calls even(), and the last one calls
 * odd().
 * "0102" is the correct output.
 * Example 2:
 * 
 * Input: n = 5
 * Output: "0102030405"
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 * 
 * 
 * 
 * PrintZeroEvenOdd
 */
public class PrintZeroEvenOdd {

    public static void main(String[] args) {
        final ZeroEvenOdd obj = new ZeroEvenOdd(10);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    obj.zero(new Printer());
                } catch (InterruptedException e) {
                }
            }
            
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    obj.even(new Printer());
                } catch (InterruptedException e) {
                }
            }
            
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    obj.odd(new Printer());
                } catch (InterruptedException e) {
                }
            }
            
        });

        t1.start();
        t2.start();
        t3.start();
    }
    /////////////////////////////////////////////////
    private static class Printer implements IntConsumer{

        @Override
        public void accept(int value) {
            System.out.print(value);
        }

    }
    ////////////////////////////////////////////////
    private static class ZeroEvenOdd {
        private int n;

        final Semaphore semaz = new Semaphore(1, false);
        final Semaphore semae = new Semaphore(0, false);
        final Semaphore semao = new Semaphore(0, false);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i++)
            {
                semaz.acquire();
                printNumber.accept(0);
                if(i%2 == 0)
                    semae.release();
                else
                    semao.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i = 2; i <= n; i+=2)
            {
                semae.acquire();
                printNumber.accept(i);
                semaz.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i+=2){
                semao.acquire();
                printNumber.accept(i);
                semaz.release();
            }
        }
    }

}
