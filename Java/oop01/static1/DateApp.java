package Java.oop01.static1;

import java.util.Date;

public class DateApp {

    public static void main(String[] args) {

        // 현재 날짜와 시간 정보를 표현하는 Date 객체 생성
        Date now = new Date();
        System.out.println(now);

        String text1 = DateUtils.dateToString(now);
        System.out.println(text1);

        String text2 = DateUtils.dateToDetailString(now);
        System.out.println(text2);

        String text3 = DateUtils.dateToLocaleString(now);
        System.out.println(text3);
    }
}
