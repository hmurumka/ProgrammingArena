package practice.programming.concurrency;

/**
 * 1115. Print FooBar Alternately
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Suppose you are given the following code:
 * 
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * 
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * The same instance of FooBar will be passed to two different threads:
 * 
 * thread A will call foo(), while
 * thread B will call bar().
 * Modify the given program to output "foobar" n times.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them
 * calls foo(), while the other calls bar().
 * "foobar" is being output 1 time.
 * Example 2:
 * 
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 * 
 * 
 * 
 * FooBarSequetial
 */
public class FooBarSequetial {

    public static void main(String[] args) {
        final FooBar o = new FooBar(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                o.foo();
            }
            
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                o.bar();
            }
        });

        t1.start();
        t2.start();
    }

    /////////////////////////////////////////////////////////////////////
    private static class Solution {

    }

    /////////////////////////////////////////////////////////////////////
    private static class FooBar {
        private int turns = 0;
        private volatile boolean flag = true;

        public FooBar(int n) {
            this.turns = n;
            // monitor = new Object();
        }

        public synchronized void foo() {
            for (int i = 0; i < this.turns; i++) {
                    try {
                        if(flag == false){
                            this.wait();
                        }
                        System.out.print("foo");
                        flag = false;
                        this.notifyAll();
                    } catch (InterruptedException e) {
                        System.out.println("Exception in foo()");
                    }

            }
        }

        public synchronized void bar() {
            for (int i = 0; i < this.turns; i++) {
                    try {
                        if(flag == true)
                            this.wait();
                        System.out.print("bar");
                        flag = true;
                        this.notifyAll();
                            
                    } catch (InterruptedException e) {
                        System.out.println("Exception in bar()");
                    }
            }
        }
    }

}
