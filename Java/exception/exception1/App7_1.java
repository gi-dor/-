package Java.exception.exception1;
/*
- final
try 블럭의 수행문이 정상 수행되던지 , 오류가 발생 하던지에 , 상관없이  반드시 실행해야하는 수행문을 포함한 블럭
*/

import java.io.FileWriter;
import java.io.IOException;

/*
try {
1. 오류 발생이 예상되는 수행문

2. - 1번 수행문이 정상적으로 수행되었을 때 실행되는 수행문;
2. - 1번 수행문이 정상적으로 수행되었을 때 실행되는 수행문;
2. - 1번 수행문이 정상적으로 수행되었을 때 실행되는 수행문;
2. - 1번 수행문이 정상적으로 수행되었을 때 실행되는 수행문;
} catch (예외 클래스 변수명) {
3 - 1번 수행문에 오류가 발생했을 떄 실행되는 수행문;
} finally {
4   -   1 번 수행문의 정상수행 / 오류 발생과 상관없이 반드시 실행되는 수핼문;
}

`  1번과 2번 수행문은 시스템의 자원을 사용하는 수행문
`  4번 수행문은 1번 2번 수행문에서 사용했던 시스템의 자원 (I/O 자원 , 네트워크 자원 , 데이터베이스 연결자원)을 반납하는 수행문
`  Java7 부터 프로그램이 사용했던 자원을 자동으로 반납하는 기능이 추가되면서
자원을 반납하기 위한 finally 블럭은 필요가 없어짐

` 일반적으로 데이터 베이스 엑세스 작업에는 외부 라이브러리 (myBatis , jpa)를 사용하게되는데
이런 라이브러리들은 데이터베이스 작업과 관련된 자원 반납을 자동으로 처리해준다
이로인해 finally 블럭 사용할 필요 없다

*/
public class App7_1 {
    public static void main(String[] args) {

        FileWriter writer = null;
        try {
            writer = new FileWriter("app7.txt");
            writer.write("finally 연습");

        } catch (IOException ex) {

        } finally {
            try {
                if (writer != null) {
                    // FileWriter 객체가 사용했던
                    // 시스템의 입출력 직원을 반납하는 수행문이다.
                    writer.close();
                }
            } catch (IOException e) {
                // 이 catch 블록에는 수행문을 작성하지 않는다
            }
        }


    }
}
