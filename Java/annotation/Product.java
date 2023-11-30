package Java.annotation;

import java.util.Date;

public class Product {

    private int no;
    private String name;
    private int price;

    public Product(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    @CreatedAt
    private Date createdDate;

    private Date updatedDate;

    @Override
    public String toString() {
        return "Product{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
