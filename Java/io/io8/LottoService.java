package Java.io.io8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoService {

    private LottoRepository lottoRepo = new LottoRepository();
    private OrderRepository orderRepo = new OrderRepository();


    public Order buy(int orderAmount) {
        // 회차 번호 획득
        int lottoNo = orderRepo.getLottoNo();
        // 주문번호 획득 - 생성
        long orderNo = System.currentTimeMillis();

        // 금액만큼 로또 번호 발행
        int count = orderAmount / 1000;
        List<Set<Integer>> numbers = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            // generateSet() 메서드로 로또번호 발행
            // generateSet() 실행하면 숫자 6개가 포함된 Set 객체를 획득한다
            // numbers 는 로또번호를 Set을 여러개 저장하는 객체다
            // generateSet() 으로 발행된 로또번호 Set이 저장된다.

            numbers.add(generateSet());
        }

        // 주문정보는 로또회차번호 , 주문번호 , 로또번호로 구성
        // Order객체를 생성해서 로또회차번호 , 주문번호 ,로또번호 를 담음(자동으로 금액만큼 생성된)

        Order order = new Order();
        order.setLottoNo(lottoNo);
        order.setOrderNo(orderNo);
        order.setNumbers(numbers);

        // 주문번호가 담겨있는 Order 객체를 OrderRepository에 전달해서 저장
        orderRepo.save(order);

        // 주문번ㄹ호를 UI 로 반환
        return order;
    }


    // 로또 번호 추첨
    private Set<Integer> generateSet() {
        Set<Integer> set = new TreeSet<Integer>();

        Random random = new Random();
        while (true) {
            int num = random.nextInt(45) + 1;
            set.add(num);
            if (set.size() == 6) {
                break;
            }
        }
        return set;
    }


    public Order getOrder(int lottoNo, long orderNo) {
        List<Order> orders = orderRepo.getOrders(lottoNo);

        for (Order order : orders) {
            if (order.getOrderNo() == orderNo) {
                return order;
            }
        }
        throw new RuntimeException("[" + lottoNo + "] [" + orderNo + "] 주문정보가 없습니다.");

    }


}
