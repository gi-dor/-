package Java.io.io4;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputApp1 {

    public static void main(String[] args) throws Exception {

        DataInputStream in = new DataInputStream(
                new FileInputStream("Java/io/io4/sample.jpg"));

        // 순서가 바뀌면 값을 제대로 가져오지 못한다
        String value1 = in.readUTF();
        String value2 = in.readUTF();
        int value3 = in.readInt();
        double value4 = in.readDouble();
        boolean value5 = in.readBoolean();

        System.out.println("상품명 : " + value1);
        System.out.println("제조사 : " + value2);
        System.out.println("가격 : " + value3);
        System.out.println("할인료 : " + value4);
        System.out.println("절판여부 : " + value5);
    }
}
