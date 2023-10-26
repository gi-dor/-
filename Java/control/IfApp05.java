package Java.control;

public class IfApp05 {
    public static void main(String[] args) {
        /*
         * 내포된 if문
         * if문 안에 if문
         *
         * if (조건식1){
         * 		수행문;
         * 		 // 조건식2는 조건식1이 true로 판정시 검사가 진행된다.
         * 		if (조건식2) {
         * 				수행문;
         * 				} else {
         * 					수행문;
         * 		if (조건식3) {
         * 				수행문;
         *  			} else {
         *  				수행문;
         * 				 }
         * 		}
         *
         *
         * if블럭이나 else 블럭 내부에 포함된 if문 혹은 if - else
         *
         */


        // 장학금 지급하기

        // 장학금은 시험 합격자 중에서 평균 96점수 이상인 경우 장학금 지급대상이된다
        // 평균 점수 60점 이상이면 합격 그외에는 불합격이다

        int kor = 80;
        int eng = 70;
        int math = 60;

        int total = kor + eng + math;
        int average = total / 3;

        if (average >= 60) {
            System.out.println("합격 입니다");

            if (average >= 96) {
                System.out.println("장학금 지급 대상입니다 축하합니다. ");
            }
        } else {
            System.out.println("불합격 입니다");
        }



        if ( average >= 60) {
            System.out.println("합격 입니다");
            if( average >= 96 ) {
                System.out.println("장학금 지급 대상입니다");
            }
        } else {
            System.out.println("불합격 입니다.");
        }


    }
}
