package Java.lang;

import java.util.Objects;

public class Contact {
    String name;
    String phone;
    String email;
    String companyString;

    // Object로 부터 상속받은 toString() 재정의하기
//    @Override
//    public String toString() {
//        // TODO Auto-generated method stub
//        return name + " - " + phone;
//    }


    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", companyString='" + companyString + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
