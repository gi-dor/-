package utils;

import java.time.LocalDate;
import java.util.Date;


/**
 *  EmployeeVO 에 정의한 Date 떄문에 만들었음.
 */

public class DateUtils {

    public static Date toDate(String text) {
    // 날짜 형식의 텍스트를 파싱해서 LocalDate 객체를 획득한다
       LocalDate localDate = LocalDate.parse(text);

       // java.sql.Date의 valueOf(LocalDate localDate)를 실행해서
       // LocalDate 객체로 java.sql.Date 객체를 획득한다
        // java.sql.Date는 java.util.Date의 하위 클래스 임으로
        // java.util.Date로 클래스 형변환 되어 반환
       return java.sql.Date.valueOf(localDate);
    }
}
