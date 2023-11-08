package Java.oop01.method;

public class ParamReturnEx {

    public static void main(String[] args) {

        // 객체 생성
        ParamReturn px = new ParamReturn();

        // 메서드 호출 (실행)
        px.add(10,5);

        px.add2(10.5,12.5);

        String name =  px.getName();
        System.out.println("name 의 값 : " +name);

        int age = px.getAge();
        System.out.println("age의 값 : " + age);
    }
}
