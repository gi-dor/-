package Java.enum1;

public class App4 {

    public static void main(String[] args) {

        Grade grade1 = Grade.BRONZE;
        int orderPrice = 1000000;

        double depositRate = grade1.getDepositRate();
        int point = (int) (orderPrice * depositRate);

        System.out.println("적립 포인트 : " + point);
    }

}
