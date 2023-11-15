package Java.lang.builder;

public class StringBuilderApp {

    public static void main(String[] args) {

        int no = 100;
        String name = "기선한";
        String tel = "홍길동";

        /*
        위의 데이터를 가지고 아래와 같은 형식의 텍스트로 구성
        번호 : 100 ,  이름 : 홍길동 , 전화번호 + 010-111-1234

        - 덧셈 연산자를 이용해 값을 이어보기
            값의 갯수가 적을 때 사용하자
                값의 갯수가 많으면 덧셈을 여러번 실행하게되고 덧셈이 실행될때마다
               새로운 String 객체가 계속 생성되기 때문에
               메모리의 누수가 발생할 수 있다.

         - StringBuilder 객체 활용하기
            StringBuilder 는 객체 내부에 임시저장소를 가지고있다
            append(값) 메서드를 사용해서 값을 추가 하면 임시저장소에 저장될 뿐
            새로운 객체가 생성되지는 않는다
         */
        String text1 = "번호 : " + no + "이름 : " + name + " ,  연락처 : " + tel;

        StringBuilder sb = new StringBuilder();
        sb.append("번호");
        sb.append(no);
        sb.append("이름");
        sb.append(name);
        sb.append("연락처");
        sb.append(tel);


    }
}
