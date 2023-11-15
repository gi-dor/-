package Java.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateApp2 {

    public static void main(String[] args) {

        /*
        날짜와 시간 정보를 지정된 포맷형식의 텍스트로 변환

        SimpleDateFormat
            - Date 객체의 날짜와 시간정보를 지정된 포맷의 텍스트로 변환한다
            - 주요 메서드
                - 생성자
                    SimpleDateFormat(String pattern)
                    - 지정된 패턴으로 날짜와 텍스트간의 변환을 지원하는 객체
                - 멤버메서드
                    String format(Date date)
                        Date 객체의 날짜와 시간 정보를 생성자에서 지정한 패턴에 맞는 포맷형식의 텍스트로 변환
                    Date parse(String text)
                        텍스트가 생성자에서 지정한 형식으로 작성된 날짜와 시간정보라면
                        텍스트에 해당하는 날짜와 시간정보를 가진 Date객체로 변환해서 반환한다
         */

        Date now = new Date();

        String pattern1 = "yyyy-MM-dd";    // 주의 YYYY - MM -DD 하면 다른 결과
        SimpleDateFormat sdf = new SimpleDateFormat(pattern1);
        String text = sdf.format(now);

        System.out.println(text);

        sdf.applyPattern("yyyy-M-d");
        String text2 = sdf.format(now);
        System.out.println(text2);

        sdf.applyPattern("yyyy년 M월 d일");
        String text3 = sdf.format(now);
        System.out.println(text3);

        sdf.applyPattern("M월 d일 EEEE");
        String text5 = sdf.format(now);
        System.out.println(text5);

        sdf.applyPattern("HH:mm:ss");
        String text6 = sdf.format(now);
        System.out.println(text6);

        sdf.applyPattern("hh:mm:ss");
        String text7 = sdf.format(now);
        System.out.println(text7);

        sdf.applyPattern("a h시 m분 s초");
        String text8 = sdf.format(now);
        System.out.println(text8);

        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        String text9 = sdf.format(now);
        System.out.println(text9);

        String basicText = DateUtils.dateToString(now);
        System.out.println(basicText);

        String textDetail = DateUtils.dateToDetailString(now);
        System.out.println(textDetail);

    }
}
