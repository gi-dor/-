package Java.util.time;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDateTime;


public class TimeApp4 {

    public static void main(String[] args) {

        // 문자열로 변환하기
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        String text1 = now.format(ofPattern("yyyy-MM-dd"));
        System.out.println(text1);

        String text2 = now.format(ofPattern("M월 d일 EEEE"));
        System.out.println(text2);

    }
}
