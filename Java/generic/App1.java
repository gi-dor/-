package Java.generic;

import java.util.Date;

public class App1 {
    public static void main(String[] args) {

        /*
        제네릭이 적용되지 않은 박스객체
           - 아무객체나 담을수 없다
           - 항상 Object타입으로 꺼내지기 때문에 매번형변환 해여함
         */

        NoneGeneric box1 = new NoneGeneric();
        box1.add(100);
        int value1 = (Integer) box1.get();
        System.out.println(value1);

        NoneGeneric box2 = new NoneGeneric();
        box2.add("기선");
        String value2 = (String) box2.get();
        System.out.println(value2);

        NoneGeneric box3 = new NoneGeneric();
        Date date = new Date();
        box3.add(date);

        Date value3 = (Date) box3.get();
        System.out.println(value3);

    }
}
