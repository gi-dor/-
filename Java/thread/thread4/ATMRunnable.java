package Java.thread.thread4;

public class ATMRunnable implements Runnable {

    private int deposit = 1000000;

    @Override
    public void run() {
        // 현재 실행중인 쓰레드 이름을 가져올수 있음
        String name = Thread.currentThread().getName();

        for (int i = 0; i < 10; i++) {
            System.out.println("[" + name + "] 출금 전 잔액 조회 : " + deposit);
            deposit -= 50000;
            System.out.println("[" + name + "] 출금 후 잔액 조회 : " + deposit);

            System.out.println();
        }


    }
}
