package Java.thread.thread1;

public class MyThreadApp {

    public static void main(String[] args) {

        // 사용자 정의 스레드 - 일꾼만들기

        // Thread 클래스 상속받음 MyThread로 객체 만들기
        MyThread t1 = new MyThread();

        Runnable r = new MyThread2(); // Runnable 구현한 MyThread2
        Thread tt1 = new Thread(r);

        /**
         *  Runnable을 구현한 클래스의 인스턴스로 생성할 경우
         *  1. Runnable 인터페이스를 구현한 클래스의 객체 생성
         *  2. 이 객체를 Thread 클래스의 생성자의 매개변수로 제공해야한다.
         */

        t1.start();
        tt1.start();

//        t1.run(); 클래스 실행 x
//        tt1.run(); 단순 클래스에서 메서드 호출하는것

    }
}
