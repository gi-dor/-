package Java.array;

public class Array03 {
    public static void main(String[] args) {

        /*
         * 배열 객체의 활용
         * 		- 인덱스를 활용해 배열의 각 저장소를 쉽게 접근할 수 있다.
         * 		- 배열객체의 생성 목적은 같은 종류와 같은 타입의 값들을 하나의 이름으로 관리 할수 있다.
         *
         * 		예시 )
         * 			회원이름
         * 				String name1 = "김유신";
         * 				String name2 = "곽재우";
         * 				String name3 = "김시민";
         * 				String name4 = "권율";
         *
         *  			String[] names = { "김유신", "곽재우" ,"김시민" ,"권율" };
         *
         */


        /*
         * 국어 영어 수학 점수가 저장된 배열이 있다
         * 국어 점수의 평균 , 영어 점수의 평균 , 수학 점수의 평균을 계산하라
         */

        int [] korScores = {100 , 80 , 80 , 90 , 60 , 70};
        int [] engScores = {90 , 80 , 60 , 70 , 60 , 60};
        int [] mathScores = {100 , 60 , 50 , 80 , 40 , 60};


        int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;

        // 과목별 총점

//		for( int value : korScores) {
//			korTotal += value;
//		}
//		for( int value : engScores) {
//			engTotal += value;
//		}
//		for( int value : mathScores) {
//			mathTotal += value;
//		}



        for(int index = 0; index < korScores.length; index++) {
            korTotal += korScores[index];
        }

        for(int index = 0; index < engScores.length; index++) {
            engTotal += engScores[index];
        }

        for(int index = 0; index < mathScores.length; index++) {
            mathTotal += mathScores[index];
        }


        // 평균
        int korAvg = korTotal / korScores.length;
        int engAvg = engTotal / engScores.length;
        int mathAvg = mathTotal / mathScores.length;

        System.out.println("국어 점수 평균 : " + korAvg);
        System.out.println("영어 점수 평균 : " + engAvg);
        System.out.println("수학 점수 평균 : " + mathAvg);


		/*
		 * index = 0일 때:

			korScores[0] = 100
			초기 korTotal = 0
			연산: 0 += 100
			결과적인 korTotal = 100
			index = 1일 때:

			korScores[1] = 80
			현재 korTotal = 100 (이전 단계에서 계산된 값)
			연산: 100 += 80
			결과적인 korTotal = 180
			index = 2일 때:

			korScores[2] = 80
			현재 korTotal = 180
			연산: 180 += 80
			결과적인 korTotal = 260
			index = 3일 때:

			korScores[3] = 90
			현재 korTotal = 260
			연산: 260 += 90
			결과적인 korTotal = 350
			index = 4일 때:

			korScores[4] = 60
			현재 korTotal = 350
			연산: 350 += 60
			결과적인 korTotal = 410
			index = 5일 때:

			korScores[5] = 70
			현재 korTotal = 410
			연산: 410 += 70
			결과적인 korTotal = 480
		 */

    }
}
