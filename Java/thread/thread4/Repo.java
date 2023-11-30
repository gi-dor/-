package Java.thread.thread4;

public class Repo {

    private String data;

    // 공급자 스레드가 실행하는 메서드
    public synchronized void produce(int index) throws Exception {
        if (data != null) {
            wait();
        }
        data = index + "번째 값";
        System.out.println("[" + index + "]번째 값을 공급하다.");
        notify();    // 소비자의 일시정지를 해제한다.
    }

    // 소비자 스레드가 실행하는 메서드
    public synchronized void consume() throws Exception {
        // 데이터가 공급되어 있지 않으면 소비자는
        if (data == null) {
            wait();
        }
        System.out.println("[" + data + "]를 소비하다.");
        data = null;
        notify();
        System.out.println();
    }

    /*
     1  공급자 스레드가 start() 된후  repo.pdiruce(() 메서드를 실행한다
     2. Data가 null이다
     2. Repo에 data에 새로운 값을 저장
     3. notify() 를 실행해 서 소비자를 실행 가능상태로 변경

     repo.produce()
     3. repo.produce 메서드 실행
     3. data가 null 이다
     wait()를 실행해 자신을(소비자) 대기상태로 변경
     공급하기... 를 실행하지 못해 대기상태에서 대기중


     */


}
