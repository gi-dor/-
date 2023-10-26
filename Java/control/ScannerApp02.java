package Java.control;

import java.util.Scanner;

public class ScannerApp02 {
    public static void main(String[] args) {

        /*
         * 완료시간 출력하기
         *
         * 입력으로 현재 시간의 정보와 분 정보를 입력받느다
         * 입력으로 소요 시간을 분단위로 입력받는다
         *
         * 완료 시간을 시 , 분 단위로 출력한다
         *
         * 예시.
         * 시작시간의 hour : 15시
         * 시작 시간의 minute : 20
         * 소요시간 (분) : 50
         *
         * 예상 완료 시간 ?
         *
         */

        // 15시 20분인데
        // 소요되는 시간이 50분이니
        // 예상완료 시간은 16시 10분 이렇게 나와야한다

        Scanner scanner = new Scanner(System.in);

        // ==========   입력 =====================
        // 시작시간 입력
        System.out.print("시간 입력 : ");
        int startHours = scanner.nextInt();

        // 시작 시간의 분 입력
        System.out.print("분 입력 : ");
        int startMinutes = scanner.nextInt();


        // 소요되는 시간
        System.out.print("소요 시간 입력 (분): ");
        int runningTime = scanner.nextInt();

        int endHours = 0;
        int endMinutes = 0;

        // startMinutes + runningTime이 60의 보다 클 떄
        // 둘이 더한 값은 최종 진행된 minutes이됨
        // increMinutes / 60 하고 나온 값으로 startHours + increMinutes
        //
        //

        // ========= 예상 완료 계산========================
        if(startMinutes + runningTime >= 60) {
            // 총 분 구하기
            int totalMinutes = startMinutes + runningTime;
            // 총 분 구한뒤에 60으로 나누어서 시간 증가 시키기
            int increseHours = totalMinutes / 60;

            // 완료 시점은 시간은 시작시간 + 증가한 시간
            endHours = startHours + increseHours;
            // 완료 시점의 분은 60으로 나누고 나서 나온 나머지 값이 분이됨
//			endMinutes = totalMinutes % 60;
            endMinutes = totalMinutes - (increseHours * 60);

        } else {
            endHours = startHours;
            endMinutes = startMinutes + runningTime;


        }


        System.out.println("완료시간 : "+ endHours + "시 " + endMinutes +"분" );
        scanner.close();



    }
}
