package JDBC.JDBC2;

public class BookDaoApp {

    public static void main(String[] args) throws Exception {

        Book b1 = new Book();
        b1.setNo(101);
        b1.setTitle("자바의 신 vol.1");
        b1.setWriter("이상민");
        b1.setPrice(27000);
        b1.setStock(50);

        Book b2 = new Book();
        b2.setNo(102);
        b2.setTitle("자바의 신 vol.2");
        b2.setWriter("이상민");
        b2.setPrice(31500);
        b2.setStock(100);

        BookDao dao = new BookDao();

        dao.insertBook(b1);
        dao.insertBook(b2);

    }
}
