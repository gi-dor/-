package Java.generic.wild;

public class App5 {

    public static void main(String[] args) {

        FruitBox<? extends Fruit> box1;

//        box1 = new FruitBox<Fruit>();
        /*
        제네릭 와일드카드

        <?>
            - 제한없음
            - 타입 파타미터의 구체적인 타입으로 모든 클래스 , 모든 인터페이스 적요

        <? extendx 상위타입>
            - 상위 클래스 제한
            - 하입 파라미터의 구체적인 타입으로 상위타입 혹은 지정된
            상위 타입의 하위 타입만 가능

          <?  super 하위타입>
          - 하위 클래스 제한
          - 타입 파라미터의 구체적인 타입으로 하위타입혹은 지정된 하위타입의 상위타입만 가능하다
      */

    }
}
