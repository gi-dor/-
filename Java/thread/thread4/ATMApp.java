package Java.thread.thread4;

public class ATMApp {

    public static void main(String[] args) {

        ATMRunnable runnable = new ATMRunnable();

        Thread t1 = new Thread(runnable, "홍길동");
        Thread t2 = new Thread(runnable, "김유신");

        t1.start();
        t2.start();

    }
}
