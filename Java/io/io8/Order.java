package Java.io.io8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Order {

    private int lottoNo;    // 회차번호
    private long orderNo;    // 주문번호
    private List<Set<Integer>> numbers; // 구매한 로또번호


    public Order() {
    }

    public Order(int lottoNo, long orderNo, List<Set<Integer>> numbers) {
        this.lottoNo = lottoNo;
        this.orderNo = orderNo;
        this.numbers = numbers;
    }

    public int getLottoNo() {
        return lottoNo;
    }

    public void setLottoNo(int lottoNo) {
        this.lottoNo = lottoNo;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    public List<Set<Integer>> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Set<Integer>> numbers) {
        this.numbers = numbers;
    }

    // 20231124:1700000000000:1,2,3,4,5,6/10,20,30,40,42/12,21,29,39,42
    public static Order toOrder(String text) {
        String[] items = text.split(",");

        int lottoNo = Integer.parseInt(items[0]);
        long orderNo = Long.parseLong(items[1]);
        List<Set<Integer>> numbers = tolist(items[2]);

        Order order = new Order();
        order.setLottoNo(lottoNo);
        order.setOrderNo(orderNo);
        order.setNumbers(numbers);

        return order;
    }


    // text는 10,20,30,40,42/12,21,29,39,42
    private static List<Set<Integer>> tolist(String text) {
        List<Set<Integer>> numbers = new ArrayList<>();
        String[] items = text.split("/");
        for (String item : items) {
            numbers.add(toSet(item));
        }

        return numbers;
    }


    // text 10,20,30,40,42
    // text 12,21,29,39,42
    private static Set<Integer> toSet(String text) {
        Set<Integer> set = new TreeSet<Integer>();
        String[] items = text.split(",");

        for (String item : items) {
            set.add(Integer.parseInt(item));
        }

        return set;
    }


    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoNo);
        sb.append(":");
        sb.append(orderNo);
        sb.append(":");

        StringJoiner joiner = new StringJoiner("/");

        for (Set<Integer> set : numbers) {
            StringJoiner innerJoiner = new StringJoiner(",");

            for (Integer num : set) {
                innerJoiner.add(String.valueOf(num));
            }

            joiner.add(innerJoiner.toString());
        }

        sb.append(joiner.toString());

        return sb.toString();
    }


}
