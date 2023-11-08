package Java.oop01.static1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 날짜를 전달 받아 "년 - 월 - 일" 형식의 문자열로 반환하는 정적 메서드
     * @param date 날짜
     * @return "년 - 월 - 일"
     */
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // yyyy , MM , dd 표현 주의하기
        return  sdf.format(date);                                          // YYYY MM DD 안됨
    }

    /**
     * 날짜를 전달받아 "년-월-일 시:분:초" 형식의 문자열로 반환하는 정적 메서드
     * @param date 날짜
     * @return "년-월-일 시:분:초"형식의 문자열
     */
    public static String dateToDetailString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


    /**
     * 날짜를 전달받아 "2023년 11월 8일 오전 12시 20분 2초" 형식의 문자열로 반환하는 정적 메서드
     * @param date 날짜
     * @return 지역화된 자세한 문자열
     */
    public static String dateToLocaleString(Date date) {
        String pattern = "yyyy M월 d일 EEEE a h시 m분 s초";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
