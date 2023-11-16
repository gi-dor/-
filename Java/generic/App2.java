package Java.generic;

public class App2 {
    public static void main(String[] args) {

        /*
        제네릭이 적용된 Box 클래스
            - 객체 생성 시점에 타입파라미터에 그 객체의 타입을 지정할수 있다
            - 객체 생성시 지정한 타입의 객체만 저장할 수 있다
            - 저장된 객체를 사용할 때 형변환이 필요없다.
         */

        // 객체 생성시점에 타입을 명시함
        GenericBox<String> box1 = new GenericBox<String>();
        // new 연산자에 의헤 GenericBox 클래스를 String으로 다루는 제네릭박스 ? 객체 ? 를 만들고
        // box1 변수에 할당함

        box1.add("기선");
//        box1.add("기선");
//        box1.add("기선");
//        box1.add("기선");
        // 여러개를 추가해도 마지막으로 추가된 값만 유지한다.

        String value1 = box1.get();

        System.out.println(value1);

        // int가 아닌 Wrapper 타입 Integer
        GenericBox<Integer> box2 = new GenericBox<>();
        box2.add(19);
        int value2 = box2.get();
        System.out.println(value2);


    }
}
