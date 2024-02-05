package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy년 M월 d일");

    /**
     * 날짜를 전달받아 "2023년 1월21" 과 같은 형식의 문자열로 반환
     *
     * @param date 날짜
     * @return 형식
     */
    public static String toText(Date date) {
        if (date == null) {
            return "";
        }
        return DATE_FORMAT.format(date);
    }
}
