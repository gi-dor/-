package Java.thread.thread1;

public class ThreadSample2 {

    static long startTime = 0;

    public static void main(String[] args) {

        /**
         * 1. 사용자가 입력을 하는 작업
         * 2. 화면에 숫자를 출력하는 작업을
         * 두개의 쓰레드로 나누어서 처리 하기때문에
         * 입력을 마치지 않아도 화면에 숫자가 출력이된다
         *
         */

        ThreadSam ts = new ThreadSam();
        ts.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 200; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간 1 : " + (System.currentTimeMillis() - ThreadSample2.startTime));

    }
}


class ThreadSam extends Thread {

    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간 2: " + (System.currentTimeMillis() - ThreadSample2.startTime));
    }
}