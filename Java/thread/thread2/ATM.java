package Java.thread.thread2;

public class ATM implements Runnable {

    private int balance = 1000000; // 계좌 잔액

    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            balance -= 20000;
            String name = Thread.currentThread().getName(); // 쓰레드의 이름을 가져옴

            System.out.println("[" + name + "] 이 출금함 . 잔액 : [" + balance + "]");

        }
    }


}
