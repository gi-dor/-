package Java.thread;

public class MyThreadApp {

    public static void main(String[] args) {

        // 사용자 정의 스레드 - 일꾼만들기

        // Thread 클래스 상속받음 MyThread로 객체 만들기
        MyThread t1 = new MyThread();

        Runnable r = new MyThread2(); // Runnable 구현한 MyThread2
        Thread tt1 = new Thread(r);

        t1.start();
        tt1.start();

//        t1.run(); 클래스 실행 x
//        tt1.run(); 단순 클래스에서 메서드 호출하는것

    }
}
