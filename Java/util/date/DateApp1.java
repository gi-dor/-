package Java.util.date;

import java.util.Date;

public class DateApp1 {

    public static void main(String[] args) {

        /*

        자바의 날짜 / 시간 API
        java.util.Data
                - 날짜 시간 , 시간대 정보 차저

         java.util.Calendar
                - 날짜 시건 조작과  관련된 다양한 메서드 제공

         java.text.SimpleDate Format
                - 날짜 <<ㅡㅡㅡ>> 텍스트 변환
         */

        Date now = new Date();
        System.out.println(now);

        // 영국 기준 1970년 1월 1일 0시 0분 0초에 해당하는 날짤와 시간정ㅗ러
        Date date1 = new Date(0);
        System.out.println(date1);

        long unixTime = now.getTime();
        System.out.println(unixTime);
    }
}
