package Java.exception.exception1;

import java.io.FileWriter;
import java.io.IOException;

public class App3 {
    /*
     *  throws 키워드를 사용해서 예외처리 위임하기
     *
     *  public void 메서드() throws 예외클래스명, 예외클래스명, 예외클래스명 {
     *     예외발생이 예상되는 수행문;
     *     예외발생이 예상되는 수행문;
     *
     *  + 메서드내에서 발생되는 예외를 직접처리하지 않고, 이 메서드를 호출하는 측에게 예외를 전달한다.
     *  + throws 키워드 뒤에 예외클래스를 쉼표로 구분해서 나열하면 된다.
     */


    public static void main(String[] args) {
        try {
            first();
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("입출력 작업 중 오류가 발생하였습니다. ");
        }
    }

    public static void first() throws IOException {
        second();
    }

    public static void second() throws IOException {

        FileWriter writer = new FileWriter("app3.txt");
        writer.write("예외처리 위임하기");
        writer.close();

//------------------------------------------------------------------------------
/*
Unhandled exception type IOException
였는데
throws IOException 하자 빨간줄 사라짐 (예외처리 위임)


second(); 를 적었더니 빨간줄 ->
throws IOException 하자 빨간줄 사라짐 (예외처리 위임) => 또 떠넘김


first(); 를 적었더니 빨간줄 ->
   try 를 하자 빨간줄 사라짐 (예외 직접처리)

   만약 여기서도 throws IOException 하면 jvm으로 던지는거라 jvm이 프로그램 종료시킴


   예외 일괄처리

   ----------------------------------------------

   예외가 생기면 무조건 던져서 일괄처리 하고 메인메서드에서 처리하는거다.
   개별메서드에서는 트라이캐치를 쓸 일이 없다.
   예외는 잡는게 아니고 던지는거다.
*/
    }

}
