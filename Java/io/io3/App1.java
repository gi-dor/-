package Java.io.io3;

import java.io.BufferedReader;
import java.io.FileReader;

public class App1 {
    public static void main(String[] args) throws Exception {

        /*
        BufferedReader
            ` 다른 Reader와 연결해서 읽기 성능을 향상시키는 스트림
            ` 스트림의 끝을만나면 null 반환
            ` 텍스트를 읽어올 때 줄 바꿈 문자로 바로 앞까지 읽어온다
         */

        String path = "C:/Users/Han/IdeaProjects/HTA/Java/io/io3/data.csv";

        BufferedReader reader = new BufferedReader(new FileReader(path));

//        String text = reader.readLine();
//        String text1 = reader.readLine();
//        String text2 = reader.readLine();
//        String text3 = reader.readLine();
//        String text4 = reader.readLine();
//
//        System.out.println(text);
//        System.out.println(text1);
//        System.out.println(text2);
//        System.out.println(text3);
//        System.out.println(text4);

        String text = null;
        while ((text = reader.readLine()) != null) {
            String[] items = text.split(",");
            String name = items[0];

            int kor = Integer.parseInt(items[1]);
            int eng = Integer.parseInt(items[2]);
            int math = Integer.parseInt(items[3]);

            int total = kor + eng + math;
            int average = total / 3;

            System.out.println("이름 : " + name);
            System.out.println("평균 : " + average);
            System.out.println();

//            System.out.println(text);
        }

        reader.close();


    }
}
