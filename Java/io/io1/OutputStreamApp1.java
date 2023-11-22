package Java.io.io1;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamApp1 {

    public static void main(String[] args) throws IOException {

        FileOutputStream out = new FileOutputStream("Java/io/io1/app3.txt");

        out.write(65);
        out.write(66);
        out.write(67);
        out.write(68);
        out.write(69);

        String hello = "안녕하세요";

        // '안' -> [][]
        // '녕' -> [1110xxxx][10xxxxxxx][10xxxxxx]

        /*
        byte[] getBytes();
        ` 문자열을 byte 배열로 변환해서 반환
        ` 문자열을 분석해서 각문자를 utf - 8 형식의 byte 값으로 변환 한 다음
        ` 배열에 담아서 반환한다
         */

        byte[] buf = hello.getBytes();
        out.write(buf, 0, buf.length);
        out.close();


    }
}
