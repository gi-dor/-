package Java.util.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeApp3 {
    public static void main(String[] args) {

        // 두 날짜 사이의 기간 조회하기

        LocalDate today = LocalDate.now();
        LocalDate birthDay = LocalDate.of(1994, 01, 20);

//        Period pr = Period.between(birthDay, today);
//        int years = pr.getYears();
//        int months = pr.getMonths();
//        int days = pr.getDays();

        long years = ChronoUnit.YEARS.between(birthDay, today);
        long months = ChronoUnit.MONTHS.between(birthDay, today);
        long days = ChronoUnit.DAYS.between(birthDay, today);

        System.out.println("년수 : " + years);
        System.out.println("개월수 : " + months);
        System.out.println("일 수 : " + days);
    }
}
