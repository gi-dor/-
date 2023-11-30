package Java.thread.thread3;

public class MyThread1 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                sleep(500); // 0.5초 라고 함
            } catch (InterruptedException e) {

            }
            // 처리되지 않은 예외: java.lang.InterruptedException
        }
    }
}
