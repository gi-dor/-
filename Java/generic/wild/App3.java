package Java.generic.wild;

public class App3 {
    public static void main(String[] args) {

        FruitBox<Apple> box1 = new FruitBox<Apple>();
        box1.add(new Apple());
        Apple apple = box1.get();

        FruitBox<Banana> box2 = new FruitBox<Banana>();
        box2.add(new Banana());

//        FruitBox<String> box2 = new FruitBox<String>();
//        String value1 = box2.get();

    }
}
