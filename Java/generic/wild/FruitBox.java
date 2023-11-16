package Java.generic.wild;

/*
<T extends 타입> 으로 타입 파라미터의 타입을 제한 할수 있다.
 */

public class FruitBox<T extends Fruit> {
    T fruit;

    public void add(T t) {
        this.fruit = t;
    }

    public T get() {
        return fruit;
    }

}
