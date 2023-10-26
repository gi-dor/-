package Java.control;

public class Switch {
    public static void main(String[] args) {

        /*
         * 	switch (값 ) {
         * 		case 값1 :       // 값이 case에 값1 과 일치하면 아래수행문 실행
         * 				수행문;
         * 				수행문;
         * 			break;
         * 		case 값2 :		// 값이 case에 값2 와 일치하면 아래수행문 실행
         * 				수행문;
         * 				수행문;
         * 			break;
         * 		case 값3 :		// 값이 case에 값3 과 일치하면 아래수행문 실행
         * 				수행문;
         * 				수행문;
         * 			break;
         * 		default:		// 값이 case에 값1 , 값2 , 값3 과 모두 일치하지 않으면 아래수행문 실행
         * 				수행문;
         * 				수행문;
         * 		}
         * 	Java7 부터 값의 타입으로 String이 사용 가능해졌다
         * 	이전에는 정수 , 문자만 가능했음
         *
         *  switch문은 값에 대한 범위 비교는 불가능하다
         *  case문에서 break를 생략 하게되면 , 해당 case가 실행되고 난 후에 다음 case도 실행한다
         *
         *  switch문은 범주형 데이터의 값을 비교할 때 사용 한다.
         *  (범주형 데이터의 예
         * 		성별 : 남자 , 여자
         * 		혈액형 : A , O , B , AB
         *  	고객등급 : 골드 , 실버 , 브론즈
         *  	주문상태 : 결제 완료 , 상품 준비중 , 배송중 , 배송완료
         *  	)
         *
         */


        // 고객 등급별 구매금액에 대한 포인트 계산
        // 골드등급 구매금액의 5% 적립
        // 실버 등급 구매금액의 2% 적립
        // 브론즈 등급 구매금액의 1% 적립


        String customerGrade = "실버";
        int orderPrice = 1_000_000;
        int point = 0;

        switch (customerGrade = "실버") {
            case "골드" :
                System.out.println("골드 등급에 대한 포인트 계산");
                point = (int)(orderPrice * 0.05);
                System.out.println("적립 포인트는 "+point+ "점 입니다");
                break;

            case "실버" :
                System.out.println("실버 등급에 대한 포인트 계산");
                point = (int)(orderPrice * 0.03);
                System.out.println("적립 포인트는 "+point+ "점 입니다");
                break;

            case "브론즈" :
                System.out.println("브론즈 등급에 대한 포인트 계산");
                point = (int)(orderPrice * 0.01);
                System.out.println("적립 포인트는 "+point+ "점 입니다");
                break;

        }
    }
}
