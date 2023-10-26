package Java.control;

public class IfApp07 {
    public static void main(String[] args) {


        // return문을 사용해서 빠르게 종료 할수 있다
        /*
         * 나쁜 조건이 발견되면 더이상 수행문을 수행하지 않고 해당 위치에서 메서드의 실행을 중단한다
         *
         * "빠르게 종료하기"를 활용하면 불필요한 검사가 실행되지 않는다
         * 프로그램의 구조를 단순하게 작성할수 있다
         * 코드의 가독성을 향상 시킨다
         *
         *
         *	if(나쁜조건){
         *		수행문;
         *		return;
         *	}
         *	수행문;	// 나쁜 조건이 아닐 때만 실행 된다 . 나쁜조건이면 실행안된다,
         *
         */


        int kor = 100;
        int eng = 90;
        int math = 100;

        // 과락 if문 시작
        if (kor < 40 ) {
            System.out.println("불합격 (국어과목 과락) :"+kor);
            return;	// return 키워드 사용시 즉시 종료
        }

        if (eng < 40 ) {
            System.out.println("불합격 (국어과목 과락) :"+kor);
            return;		// 메서드 즉시 종료
        }

        if (math < 40) {
            System.out.println("불합격 (국어과목 과락) :"+kor);
            return;
        }	// 과락 if 문 끝

        // 평균점수
        int avg = (kor + eng + math) / 3;

        // 합격 불합격
        if (avg >= 60) {
            System.out.println("합격");
            if(avg >= 96) {
                System.out.println("장학금 지급대상 "+avg+" 점");
            }
        } else {
            System.out.println("불합격");
        }


    }
}
