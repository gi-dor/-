package Java.control;

public class If_else02 {
    public static void main(String[] args) {
        // 주차 정산시스템
        // 기본 주차비는 3000원
        // 1시간 초과후에는 10분마다 1000원씩 초과 주차비가 추가된다
        // 1시간 미만이어도 1시간 요금이 적용된다.
        // 차량배기량이 900cc미만은 50% 할인이 적용된다.
        // 79 분 이라면 60분 기본요금 + 10분 추가 요금만 , 9 분은 버린다. 10분단위로 쪼개서 추가 요금을 정산한다.


        // 기본요금
        int defaultPay = 3000;

        // 10분당 1000원
        int payPer10 = 1000;

        // 배기량 cc
        int engineDisplacement = 600;

        // 총 주차 시간 (분 단위)
        int minutes = 107;  // 50분 주차했음.

        // 주차 요금
        int pay = 0;

        if(minutes < 60){	// 60 분 초과 하지 않은 기본요금
            pay = defaultPay;
        }else { // 60분 초과
            // 60분 초과할 경우 10분당 1000원씩 초과요금이 적용된다

            // 초과된 시간을 계산한다 (분 단위)
            minutes -= 60;    // 105분 이용시 minutes = 105 - 60(기본)  45

            // 초과횟수 계산
            int times = minutes / 10;	 // times = 45 /10 ;  times = 4

            // 주차 요금 계산
            pay = defaultPay + payPer10 * times;    // pay = 3000 + 1000 * 4

        }
        System.out.println("총 주차 요금은 " + pay +" 원 입니다.");

        // 배기량이 900cc 미만일 경우 50% 할인
        if(engineDisplacement < 900) {
            pay = pay/2;
        }

        System.out.println("최종 결제 요금은 "+pay+ " 원 입니다");
    }
}
