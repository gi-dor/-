package Java.exception.exception1;

import java.io.FileWriter;
import java.io.IOException;

public class App1 {

    public static void main(String[] args) {

        /*
        try - catch 를 이용한 예외 처리

        try {
                예외를 발생시키는 수행문;
        } catch (예외클래스명 변수명 ) {
            예외 발생시 실행할 수행문;
        } catch (예외클래스명 변수명 ) {
            예외 발생시 실행할 수행문;
        } catch (예외클래스명 변수명 ) {
            예외 발생시 실행할 수행문;
        }

        + catch 블럭을 여러개 작성할 때는 부모타입 예외를 잡은 catch 블럭에 아래쪽에 위치시킨다.
        + 맨 아래쪽 catch 블럭에 Excetption 타입의 예외를 잡을 수 있게
          구성하면 예상하지 못한 예외도 잘을 수 있다.
        + 발생이 예상되는 예외들이 부모 - 자식 관계가 아닐 때는 순서와 상관없이 catch 블럭을 구성해도된다
        + cathch 블럭에서 선언한 변수는 해당 블럭에서만 사용 할 수 있다.

   try {
                예외를 발생시키는 수행문;
        } catch (예외클래스명 변수명 ) {
            예외 발생시 실행할 수행문;
        } catch (IOException e; ) {
            예외 발생시 실행할 수행문;
        } catch (Exception e; ) {
            예외 발생시 실행할 수행문;
        }


         */

        try {
            // 예외 발생이 예상되는 수행문
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("예외 처리 테스팅");

            writer.close();
        } catch (IOException e) {
            // 예외 발생시 실행할 수행문
            System.out.println("파일 쓰기 작업 중 오류가 발생");
        }


    }
}
