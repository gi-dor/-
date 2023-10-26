package Java.control;

public class IfApp06 {
    public static void main(String[] args) {


        // 국어 영어 수학 성적으로 합격여부 , 장학금 지급여부를 판단하기
        // 국어 영어 수학 중 한과목이라도 40점 미만인 경우 과락으로 불합격
        // 평균 점수 60점 이상이면 합격
        // 평균점수 96점 이상이면 장학금 지급대상

        // 출력내용
        // 합격 , 불합격 여부
        // 			불합격 일시 사유출력 - 과락 ( 과목명과 점수) , 평균 점수부족

        int kor = 90;
        int eng = 60;
        int math = 70;
        int total = kor + eng +math;
        int average = total / 3;

        boolean subFail = false;	// Flag변수

        // 과락 여부
        // 왜 if elseif 를 쓰지 않은걸까 ?
        // kor도 40점 미만 , 영어도 40점 미만 일수도 있고 전부다 미만일수도 있고 흠...
        if(kor < 40 ) {
            System.out.println("국어 과목 점수 미달 불합격 : " + kor);
            subFail = true;
        } else if(eng < 40 ) {
            System.out.println("영어 과목 점수 미달 불합격 : " + eng);
            subFail = true;
        } else if(math < 40 ) {
            System.out.println("수학 과목 점수 미달 불합격 : " + math);
            subFail = true;
        }

        // 합격 여부
        if(!subFail) {
            if(average >= 60) {
                System.out.println("합격 입니다.");
                if(average >= 96) {
                    System.out.println("평균점수 "+average+ "점으로 장학금 지급 대상입니다");
                }else {
                    System.out.println("평균점수 "+average+ "점으로 장학금 미지급 대상입니다.");
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        if(kor < 40) {
            System.out.println("국어 점수미달 과락 점수 : "+kor);
        }else if (eng < 40) {
            System.out.println("영어 점수미달 과락 점수 : "+eng);
        } else if (math < 40) {
            System.out.println("수학 점수미달 과락 점수 : "+math);
        }

        // kor >= 60 && eng >= 60 && math >= 60    이거는 average >= 60 과 동일하다
        if (kor >= 60 && eng >= 60 && math >= 60 ) {
            System.out.println("합격 입니다");
            if (average >= 96) {
                System.out.println("평균 점수 "+average+ "점으로 장학금 지급 대상입니다");
            } else {
                System.out.println("평균 점수 "+average+ "점으로 장학금 미지급 대상입니다.");
            }
        }
    }
}
