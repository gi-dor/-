### 🔹 사용자 정의 스레드 만들기

                // Thread 추상 클래스를 상속
      public class MyThread extends Thread { 

        // Thread 내의 run() 메서드를 재정의 - 오버라이딩 , 자식에 맞기 변형 
        
        public void run() { 
                // 동시에 처리할 작업을 run() 메서드 내에 작업

        }
    }

<br>

    public class MyThread implments Runnable{
        // Runnable 인터페이스를 구현 
        // 인터페이스 내의 추상메서드 run()을 구현
        
        public void run() { 
                // 동시에 처리할 작업
        
        }

    }

----

<br>
◻ 사용자 정의 스레드 실행하기 - 일꾼 만들기
<br>

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        
        t1.start();
        t2.start();
        t3.start();

<br>

◻ 만든 일꾼이 사용 할 작업주기 - 일꾼 사용

        public class MyRunnable implements Runnable {

        // Thread 내의 run() 메서드를 재정의 - 오버라이딩 , 자식에 맞기 변형 
        
        public void run() { 
                // 동시에 처리할 작업을 run() 메서드 내에 작업

        }
    }
    
            MyRunnable r = new MyRunnable();
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            Thread t3 = new Thread(r);

📌 Runnable을 구현한 클래스의 인스턴스로 생성할 경우

1. Runnable 인터페이스를 구현한 클래스의 객체 생성
2. 이 객체를 Thread 클래스의 생성자의 매개변수로 제공해야한다.
