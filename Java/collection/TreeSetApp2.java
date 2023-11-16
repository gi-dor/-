package Java.collection;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetApp2 {

    public static void main(String[] args) {

        // 로또 번호 추출하기
        // 1. 번호추출
        // 2. 중복 체크 - Set 으로 처리
        // 3. 저장
        // 4. 정렬 - TreeSet 처리

        Random random = new Random();
        TreeSet<Integer> lotto = new TreeSet<>();
        // - TreeSet<E> 사용
        // 중복 값은 저장하지 않음 , 자동정렬 오름차순으로  해줌 개꿀

        while (true) {
            int num = random.nextInt(45) + 1;

            // 변수 lotto 에 담음
            lotto.add(num);

            if (lotto.size() == 6) {
                break;
            }
        }
        System.out.println(lotto);
    }
}
