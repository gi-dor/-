package Java.generic.wild;

public class App4 {

    public static void main(String[] args) {

        // box1 은 Fruit 종류를 저장하는 박스객체
        FruitBox<Fruit> box1 = null;

        box1 = new FruitBox<Fruit>();

        // 제네릭객체의 타입파라미터간에는 형변환이 불가능
//        box1 = new FruitBox<Apple>();
//        box1 = new FruitBox<Banana>();

    }
}
