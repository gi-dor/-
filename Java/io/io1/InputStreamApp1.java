package Java.io.io1;

import java.io.FileInputStream;

public class InputStreamApp1 {

    public static void main(String[] args) throws Exception {
        /*
            FileInpturStream
            ` 파일의 내용을 1byte씩 읽어오는 스트림 객체
         */

        // src/io1.txt
        FileInputStream in = new FileInputStream("Java/io/io1/app3.txt");

        // 스트림이 읽어오는 데이터를 1byte 씩 읽어오기

        int value = in.read();
        while ((value = in.read()) != -1) {
            System.out.println((char) value);
        }
    }

}
