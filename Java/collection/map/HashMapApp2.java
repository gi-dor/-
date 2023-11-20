package Java.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapApp2 {

    public static void main(String[] args) {

        /*
        VO 객체를 대체하는 Map객체

        상품 정보를 저장하는 Product 클래스
        public class Product{
            private int no;
            private String name;
            private String maker;
            private int price;
            private double discountRate;
        }

        Product item1 = new Product(100,"galaxy22","samsung",990000,0.05);
        Product item2 = new Product(100,"galaxy23","samsung",990000,0.05);
        Product item3 = new Product(100,"galaxy24","samsung",990000,0.05);
        Product item4 = new Product(100,"galaxy25","samsung",990000,0.05);


        상품 정보를 저장하는 Map 객체
        Map<String,Object> item = new HashMap<>();
        item.put("no",100);
        item.put("name","galaxy22");
        item.put("maker","samsung");
        item.put("price",990000);
        item.put("discountRate",0.05);

         */

        // 상품 정보를 저장하는 Map객체
        Map<String, Object> item1 = new HashMap<String, Object>();
        item1.put("no", 100);
        item1.put("name", "iphone10");
        item1.put("maker", "apple");
        item1.put("price", 1000000);
        item1.put("discountRate", 0.05);

        Map<String, Object> item2 = new HashMap<String, Object>();
        item2.put("no", 101);
        item2.put("name", "galaxt22");
        item2.put("maker", "samsung");
        item2.put("price", 900000);
        item2.put("discountRate", 0.05);

        // 상품정보가 저장된 Map객체를 여러개 저장하는 List객체 생성
        List<Map<String, Object>> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        System.out.println("---------------------------------------------");

        // List객체에 저장된 모든 정보 출력하기
        for (Map<String, Object> map : items) {
            int no = (Integer) map.get("no");
            String name = (String) map.get("name");
            String maker = (String) map.get("maker");
            int price = (Integer) map.get("price");
            double discountRate = (double) map.get("discountRate");

            System.out.println("번호 : " + no);
            System.out.println("이름 : " + name);
            System.out.println("제조사 : " + maker);
            System.out.println("가격 : " + price);
            System.out.println("할인율 : " + discountRate);
            System.out.println();
            System.out.println();

        }


    }
}
