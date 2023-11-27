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
        // 회차번호를 획득한다.
        int lottoNo = orderRepo.getLottoNo();
        // 주문번호를 획득(생성)한다.
        long orderNo = System.currentTimeMillis();

        // 금액만큼 로또 번호를 발행합니다.
        int count = orderAmount / 1000;
        List<Set<Integer>> numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            // generateSet() 메소드는 로또번호를 발행한다.
            // generateSet()을 실행하면 숫자 6개가 포함된 Set객체를 획득한다.
            // numbers는 로또번호Set을 여러개 저장하는 객체다.
            // generateSet()으로 발행된 로또번호Set이 저장된다.
            numbers.add(generateSet());
        }

        // 주문정보는 로또회차번호, 주문번호, 로또번호로 구성된다.
        // Order객체를 생성해서 로또회차번호, 주문번호, 로또번호(자동으로 금액만큼 생성된)
        // 를 담는다.
        Order order = new Order();
        order.setLottoNo(lottoNo);
        order.setOrderNo(orderNo);
        order.setNumbers(numbers);

        // 주문정보가 담겨있는 Order객체를 OrderRepository객체에 전달해서 저장시킨다.
        orderRepo.save(order);

        // 주문정보를 UI로 반환한다.
        return order;
    }

    //

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

        throw new RuntimeException("[" + lottoNo + "][" + orderNo + "] 주문정보가 없습니다.");
    }

    /**
     * 로또 당첨번호를 추첨하고, 반환한다.
     *
     * @return 로또 당첨번호 정보
     */
    public Lotto lotto() {
        // 회차번호를 획득한다.
        int lottoNo = orderRepo.getLottoNo();
        // 로또 당첨번호를 획득한다.
        Set<Integer> numbers = this.generateSet();
        // 로또 보너스번호를 획득한다.
        int bonus = this.getBonusNumber(numbers);
        // 로또 당첨번호를 표현하는 객체를 생성하고 회차번호,당첨번호,보너스번호를 저장한다.
        Lotto lotto = new Lotto();
        lotto.setNo(lottoNo);
        lotto.setNumbers(numbers);
        lotto.setBonus(bonus);

        // 추첨된 로또번호를 저장하기
        lottoRepo.save(lotto);

        return lotto;
    }

    private int getBonusNumber(Set<Integer> numbers) {
        Random random = new Random();

        while (true) {
            int number = random.nextInt(45) + 1;
            if (!numbers.contains(number)) {
                return number;
            }
        }
    }

    /**
     * 회차번호, 주문번호를 전달받아서 당첨정보를 반환한다. 1. 회차번호에 해당하는 로또 추첨정보를 조회한다. 2. 회차번호에 해당하는 전체 로또구매정보를 조회한다. 3. 주문번호에 해당하는 로또 구매정보를
     * 조회한다. 4. 1번에서 조회한 추첨정보와 3번에서 조회한 구매정보를 비교해서 당첨정보를 알아낸다. 5. 당첨정보를 반환한다.
     *
     * @param lottoNo 회차번호
     * @param orderNo 주문번호
     * @return 당첨정보
     */
    public List<Winning> check(int lottoNo, long orderNo) {
        Lotto lotto = lottoRepo.getLotto(lottoNo);
        Order order = this.getOrder(lottoNo, orderNo);
        List<Winning> winnings = check(lotto, order.getNumbers());

        return winnings;
    }

    private List<Winning> check(Lotto lotto, List<Set<Integer>> numbers) {
        List<Winning> winnings = new ArrayList<Winning>();

        for (Set<Integer> set : numbers) {
            Winning winning = new Winning();
            winning.setWin(true);
            Set<Integer> correctNumbers = check(lotto.getNumbers(), set);
            int count = correctNumbers.size();
            if (count == 6) {
                winning.setRank(1);
            } else if (count == 5) {
                if (set.contains(lotto.getBonus())) {
                    winning.setRank(2);
                } else {
                    winning.setRank(3);
                }
            } else if (count == 4) {
                winning.setRank(4);
            } else if (count == 3) {
                winning.setRank(5);
            } else {
                winning.setWin(false);
            }
            winning.setCorrectNumbers(correctNumbers);
            winning.setCount(count);
            winning.setNumbers(set);
            winnings.add(winning);
        }
        return winnings;
    }

    private Set<Integer> check(Set<Integer> lotto, Set<Integer> numbers) {
        Set<Integer> collectNumbers = new TreeSet<Integer>();
        for (int num : numbers) {
            if (lotto.contains(num)) {
                collectNumbers.add(num);
            }
        }
        return collectNumbers;
    }
}



