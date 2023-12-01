package Java.enum1;

public class App2 {

    public static void main(String[] args) {

        CustomerGrade grade1 = CustomerGrade.GOLD;
        CustomerGrade grade2 = CustomerGrade.SILVER;
        CustomerGrade grade3 = CustomerGrade.BRONZE;

        // String name();
        // 열거객체가 가지고있믄 문자열 반환 ,열거상수의 이름과 같음
        String name1 = grade1.name();
        String name2 = grade2.name();

        System.out.println("열거상수이름 : " + name1);
        System.out.println("열거상수이름 : " + name2);

        // int ordinal()
        // 열거 객체의 순번 반환 0 부터 시작
        int index1 = grade1.ordinal();
        int index2 = grade2.ordinal();
        int index3 = grade3.ordinal();

        System.out.println("열거객체 순번 : " + index1);
        System.out.println("열거객체 순번 : " + index2);
        System.out.println("열거객체 순번 : " + index3);

        // enum valueOf(String name)
        CustomerGrade grade4 = CustomerGrade.valueOf("GOLD");
        CustomerGrade grade5 = CustomerGrade.valueOf("SILVER");
        CustomerGrade grade6 = CustomerGrade.valueOf("BRONZE");
        System.out.println(grade4);
        System.out.println(grade5);
        System.out.println(grade6);

        // int compareTo(enum other)

    }
}
