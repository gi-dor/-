package Java.util.date;

import java.util.Calendar;
import java.util.Date;

public class CalendarApp {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        // Calendar 는 abstract 클래스 라고 메시지 발생함

        /*
        int get(int field)
            - Calendar객체에서 field에 해당하는 정보를 반환

         void set(int field , int value)
            - Calendar 객체에서 지정된 field 에 해당하는정보를 변경한다
         */

        cal.set(Calendar.MONTH, 2); // 월을 2월로 지정함

        // 날짜와 시간을 조회
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);

        System.out.println("년 : " + year);
        System.out.println("월 : " + month);
        System.out.println("일 : " + day);
        System.out.println("시 : " + hours);
        System.out.println("분 : " + minutes);
        System.out.println("처 : " + seconds);

        Date dt = cal.getTime();
        System.out.println(dt);

    }
}
