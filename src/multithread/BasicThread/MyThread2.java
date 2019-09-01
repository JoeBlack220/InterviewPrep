package multithread.BasicThread;
// better than inheritance, implementing interface and override run method
public class MyThread2 implements Runnable {
    int i;
    public MyThread2(int i) {this.i = i;}
    @Override
    public void run() {
        for(int ctr = 0; ctr < 500; ctr++) {
            System.out.println(i);
        }
    }

}

class MyThreadDemo3 {
    // using run() methods, all the threads I created are still run sequentially
    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);
        t1.run();
        t2.run();
        t3.run();
    }
}

class MyThreadDemo4 {
    // by calling start(), the new threads are actually been created and run in parallel
    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);
        t1.start();
        t2.start();
        t3.start();
    }
}