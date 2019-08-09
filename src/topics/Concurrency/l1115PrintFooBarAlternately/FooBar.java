package topics.Concurrency.l1115PrintFooBarAlternately;

import java.util.concurrent.Semaphore;
public class FooBar {
    private int n;
    Semaphore s1;
    Semaphore s2;
    public FooBar(int n) {
        this.n = n;
        s1 = new Semaphore(0);
        s2 = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s2.release();
        }
    }
}