package Java.io.io3;

import java.io.PrintWriter;

public class App2 {

    public static void main(String[] args) throws Exception {

        /*
        PrintWriter
            - 캐릭터 스트림의 출력 전용 스트림이다
            - print() , println() 메서드를 제공
            - println() 메서드를 사용하면 자동으로 줄바꿈 문자를 추가해준다
            - 줄바꿈 문자 추가 없이 한 줄씩 출력하는게 가능하다
                writer.write("홍길동,100,100,90\n")
         */

        PrintWriter writer = new PrintWriter("C:/Users/Han/IdeaProjects/HTA/Java/io/io3/data.csv");

        writer.println("김유신1,100,89,79");
        writer.println("을지문덕1,99,89,99");
        writer.println("이순신1,12,32,44");

        writer.flush();

        writer.close();

    }

}
