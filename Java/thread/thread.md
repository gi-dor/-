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

❓ run ( ) , start ( )

+ main 메서드에서 run ( )  을 호출하는 것은 단순히 클래스에 선언되어있는 메서드를 호출하는 것
+ start ( )는 새로운 쓰레드가 작업할 call stack (호출 스택) 을 생성하고 그 다음에 run ( )을 호출

◻ 모든 쓰레드는 독립적인 작업을 수행하기 위해 자신만의 호출 스택을 필요 하기에

새로운 쓰레드를 생성하고 실행 시킬 때 마다 새로운 호출 스택시 생성되고 쓰레드가 종료되면 작업에 사용된 호출스택은 소멸 한다


----

스레드의 생성및 시작 <br><br>
동기화 처리
스레드 제어

sleep () - 스레드 일시정지

tield - 다른스에드에게서 자원사용을 양보

join() - 다른스레드 작업이 종료될 때 까지 대기하고 나서 실행

wait() ,notify() - 스레드 2개를 번갈아가면서 실행

interrupt() -

wait()

- Running 상태에 있는 스레드를 Non - Runnable 상태로 옮긴다

notify()

- Non - Runnable 상태에 있던 스레드를 Runnable 상태로 옮긴다

