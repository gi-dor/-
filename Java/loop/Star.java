package Java.loop;

public class Star {
    public static void main(String[] args) {
        /*
         * 중첩된 for문
         *
         * for( 초기식; 조건식; 증감식){
         * 		수행문1
         * 	for( 초기식2; 조건식2; 증감식){
         * 		수행문2
         *
         * 		}
         * 	}
         *
         *  수행문 1은 바깥쪽 for문의 반복횟수 만큼 실행
         *  수행문 1에서는 안쪽 for문의 초기식에서 생성한 변수에 접근 할수 없다.
         *
         *  수행문 2는 바깥쪽 for문이 한번 실행 될 때마다 안쪽 for문의 반복횟수 만큼 실행
         *  수행문2 에서는 바깥 for문의 초기식에서 생성한 변수
         *  안쪽 for문의 초기식에서 생성한 변수에 접근 할수 없다.
         *
         */


        /* *****
         * *****
         * *****
         * *****
         * *****
         */

        System.out.println("1번");

        for(int line = 1; line <= 5; line++) {		// 행을 출력  5번
            for(int count = 1; count <= 5; count++) {				// 별을 출력 줄마다 5번
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("------------------------");



        /*
         *
         * * 		1번줄  1개
         * **		2번줄  2개
         * ***		3번줄  3개
         * ****		4번줄  4개
         * *****	5번줄  5개
         *
         * ---------------
         */

        System.out.println("2번");

        for(int line = 1; line <= 5; line++) {
            for(int count =1; count <= line; count++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("-----------------------");


        /* *****   1번줄 5개 = 6  -> 6 - i 번째줄 5개
         * ****	2번줄 4개 = 6  -> 6 - i 번째줄 4개
         * ***		3번줄 3개 = 6
         * **		4번줄 2개 = 6
         * *		5번줄 1개 = 6
         *
         *
         * ----------------
         */

        System.out.println("3번");
        for (int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 6 - i; j++) {   // for(int j = 6 - i; j >= 1 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }




        System.out.println("--------------");





        //	 행	 공백   별
        /*      *   1행  4칸  별1     행 == 별
         *     **	2행  3칸  별2     5 - 행 = 공백
         *    ***	3행  2칸  별3
         *   ****	4행  1칸  별4
         *  *****	5행  0칸  별5
         *
         *  ---------------
         */

        System.out.println("4번");
        for(int line = 1; line <= 5; line++) {
            // 공백
            for(int space = 1; space <= 5 - line; space++) {
                System.out.print(" ");
            }
            // 별찍기
            for(int star = 1; star <= line; star++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
