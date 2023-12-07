package JDBC.JDBC3;

import java.util.Date;

public class Product {

    private int no;
    private String name;
    private String maker;
    private int price;
    private int discountPrice;
    private int stock;
    private String soldOut;
    private Date createdDate;
    private Date updateDate;


    @Override
    public String toString() {
        return "Product{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", stock=" + stock +
                ", soldOut='" + soldOut + '\'' +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(String soldOut) {
        this.soldOut = soldOut;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
