package Java.util.random;

import java.util.Arrays;
import java.util.Random;

public class RandomApp {
    public static void main(String[] args) {

        Random random = new Random();


        /*
            int nextInt(int bound)
                - 임의의 정수를 반환
                - 정수값의 범위는 0 <= 정수 < bound
         */
//        System.out.println(random.nextInt(10));
//        System.out.println(random.nextInt(10));
//        System.out.println(random.nextInt(10));
//        System.out.println(random.nextInt(10));
//        System.out.println(random.nextInt(10));

        // 임의의 정수 1 ~ 45 사이 값 받기
//        for (int i = 1; i <= 6; i++) {
//            int num = random.nextInt(45) + 1;
//            System.out.println(num);
//        }
        // 로또 번호 6개 받기
        // 중복이 없어야하며 , 오름차순으로 정렬하기
        int[] lotto = new int[6];
        int position = 0;  // 번호 위치 담당
        while (true) {

            int num = random.nextInt(45) + 1;

            // 중복검사 , 배열에 번호 저장하기
            if (position == 0) {
                lotto[position++] = num;
            } else {
                // 중복 여부를 저장하는 변수 플래그 변수 라고한다, 기본값으로 false
                boolean isExist = false;
                for (int index = 0; index <= position; index++) {

                    if (lotto[index] == num) {
                        isExist = true;
                        break;
                    } // if종료

                } // for 종료
                // isExist가 false이면 배열에 번호를 저장
                if (!isExist) {
                    lotto[position++] = num;
                }
            }
            if (position == 6) {
                break;
            }

        } // while 종료
        Arrays.sort(lotto);
        System.out.println("로또 번호 : " + Arrays.toString(lotto));

    }
}
