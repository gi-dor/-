package Java.thread.thread1;

public class MyThread extends Thread {

    /*
    스레드를 이용해 동시에 수행해야하는 작업을작성하는 메서드
     */

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}


class MyThread2 implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}