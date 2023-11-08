package Java.oop01.method;

public class BankAccountApp {

    public static void main(String[] args) {

        // 계좌정보 객체를 생성하고 , 조회 , 입금 , 출금 , 비밀번호 변겅 , 해지기능 사용하기

        // 계좌정보 객체 생성
        BankAccount acc1 = new BankAccount("기선" , "110 - 382 - 388888" , 1111 , 10000000 , 0.05);

        // 계좌 조회하기
        acc1.display();
        System.out.println();

        // 입금하기
        acc1.deposit(50000);
        System.out.println();
        acc1.deposit(10000);
        System.out.println();
        acc1.deposit(100000);
        System.out.println();

        // 출금하기
        long amount1 = acc1.withdraw(100000, 1234);
        System.out.println("출금액  " + amount1);
        System.out.println();

        long amount2 = acc1.withdraw(160000, 1111);
        System.out.println("출금액 " + amount2);
        System.out.println();


        // 비밀번호 변경하기
        acc1.changePassword(1111, 1111);
        System.out.println();
        acc1.changePassword(1234, 3321);
        System.out.println();
        acc1.changePassword(1111,1234);
        System.out.println();

        // 계좌 해지하기
        acc1.terminate(1112);
        System.out.println();

        long amount = acc1.terminate(1234);
        System.out.println("해지 금액 : " + amount );

    }
}
