package Java.io.io4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App2 {

    public static void main(String[] args) throws Exception {

        // 키보드로 입력을 한줄씩 입력하기
        // Application -> BufferedReader -> InputStreamReader -> InputStream

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("### 입력 : ");
        String text = reader.readLine();
        System.out.println("입력 내용 : " + text);

    }
}
