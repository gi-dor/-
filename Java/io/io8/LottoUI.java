package Java.io.io8;

import Java.io.io7.Scanner;
import java.util.List;
import java.util.Set;

public class LottoUI {

    LottoService service = new LottoService();
    Scanner scanner = new Scanner(System.in);


    private void showMenu() {

        System.out.print(" << 메뉴 선택 >>");
        System.out.println("---------------------------------------------------------");
        System.out.println("   1. 구매    2. 구매내역 조회   3. 당첨확인     4. 추첨       0 . 종료   ");
        System.out.println("---------------------------------------------------------");

        System.out.println();
        System.out.println("메뉴 선택");
        int menuNo = scanner.nextInt();
        System.out.println();

        switch (menuNo) {
            case 1:
                구매();
                break;
            case 2:
                구매내역();
                break;
            case 3:
                당첨확인();
                break;
            case 4:
                추첨();
                break;
            case 0:
                종료();
                break;
        }
        System.out.println();
        System.out.println();


    }


    private void 구매() {

        System.out.println(" << 구매  >>  ");
        System.out.println("### 구매 금액을 입력 하세요");
        System.out.print("## 구매금액 : ");
        int orderAmount = scanner.nextInt();

        Order order = service.buy(orderAmount);

        System.out.println("------------------------------------------------------");
        System.out.println("구매 내역");
        System.out.println("------------------------------------------------------");
        System.out.println("회차번호 : " + order.getLottoNo());
        System.out.println("주문번호 : " + order.getOrderNo());
        System.out.println("------------------------------------------------------");
        List<Set<Integer>> numberList = order.getNumbers();

        for (Set<Integer> set : numberList) {
            System.out.println(set);
        }

        System.out.println("-------------------------------------------------------");
    }

    private void 구매내역() {
        System.out.println("<<  구매 내역 확인 >>");

        System.out.println("### 회차번화와 주문번호를 입력하세요");
        System.out.print("### 회차번호 :");
        int lottoNo = scanner.nextInt();
        System.out.print("### 주문번호 :");
        long orderNo = scanner.nextLong();

        Order order = service.getOrder(lottoNo, orderNo);

        System.out.println("------------------------------------------------------");
        System.out.println("구매 내역");
        System.out.println("------------------------------------------------------");
        System.out.println("회차번호 : " + order.getLottoNo());
        System.out.println("주문번호 : " + order.getOrderNo());
        System.out.println("------------------------------------------------------");
        List<Set<Integer>> numberList = order.getNumbers();

        for (Set<Integer> set : numberList) {
            System.out.println(set);
        }

        System.out.println("-------------------------------------------------------");

    }

    private void 당첨확인() {

    }

    private void 추첨() {

    }

    private void 종료() {

    }


    public static void main(String[] args) {
        LottoUI ui = new LottoUI();
        ui.showMenu();
    }
}
