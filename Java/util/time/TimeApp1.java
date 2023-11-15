package Java.util.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeApp1 {

    public static void main(String[] args) {

        // 현재 날짜 정보를 가진 LocalDate
        LocalDate date1 = LocalDate.now();
        System.out.println("현재 날짜  : " + date1);

        // 현재 시간 정보를 가진 LocalTime
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println("현재 시간 : " + time1);

        // 지정된 날짜 정보를 가진 LocalDate객체
        LocalDate date2 = LocalDate.of(2023, 11, 15);
        System.out.println("지징된 날짜 : " + date2);

        // 지정된 날짜 , 시간 정보를 가진 LocalDateTime 객체 생성
        LocalDateTime dateTime2 = LocalDateTime.of(2023, 10, 31, 10, 5, 50);
        System.out.println(dateTime2);

    }
}
