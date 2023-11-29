package Java.thread;

public class ThreadSample2 {

    static long startTime = 0;

    public static void main(String[] args) {

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