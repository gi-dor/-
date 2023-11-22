package Java.exception.exception2;

import java.util.HashMap;
import java.util.Map;

public class App1 {

    /**
     * 고객 등급과 주문금액을 전달받아서 적립포인트를 반환
     *
     * @param grade      등급
     * @param orderPrice 가격
     * @return 적립포인트 point 반환
     */

    public static int getPoint(String grade, int orderPrice) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("gold", 0.05);
        map.put("silver", 0.03);
        map.put("bronze", 0.01);

        if (!map.containsKey(grade)) {
            throw new RuntimeException("[" + grade + "]가 비어있거나 유효한 고객등급이 아닙니다");
        }

        // 고객등급에 해당하는 적립률 조회하기
        double rate = map.get(grade);

        // 적립률과 주문금액을 이용해서  적립포인트 계산하기
        int point = (int) (orderPrice * rate);

        // 적립 포인트 반환
        return point;
    }

    public static void main(String[] args) {

        try {
            int point1 = getPoint("gold", 1000000);
            int point2 = getPoint("silver", 1000000);
            int point3 = getPoint("", 1000000);

        } catch (RuntimeException ex) {
            // 예외일괄 처리하는 곳에서는 실질적인 예외처리 코드를 작성한다
            // 1. 예외 발생내용을 로그에 기록
            // 2. 오류메세지를 경고창 등을 통해 사용자에게 알려주기
            // 3. 오류를 수정할 수 있도록 수행문 실행
            // ` 1번 3번은 프로그램 유지보수하는 개발자를 위한 처리
            // ` 2번은 프로그램을 사용하는 사용자를 위한 처리
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
