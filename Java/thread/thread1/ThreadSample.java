package Java.thread.thread1;

public class ThreadSample {

    /**
     * 하나의 쓰레드로 2개의 작업하기
     */
    public static void main(String[] args) {

        /**
         * System.out.printf("%s", new String("-"));
         *  System.out.print("-");
         *
         *  " - " 을 사용하는것보다 new String("-")를 사용해 수행속도를 늦췄다.
         */

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        for (int i = 0; i < 100; i++) {
//            System.out.print("-");
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1 : " + (System.currentTimeMillis() - startTime));

        for (int j = 0; j < 100; j++) {
//            System.out.print("|");
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간 2 : " + (System.currentTimeMillis() - startTime));

    }
}
