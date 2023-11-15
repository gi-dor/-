package Java.lang.builder;

public class StringBuilderApp2 {

    public static void main(String[] args) {

        int no = 100;
        String name = "기선한";
        String tel = "010-4568-9632";

        StringBuilder sb = new StringBuilder();

        // StringBuilder 의 append() 메서드는 StringBuilder 객체를 반환
        // append() 메서드의 실행 결과가 StringBuilder 객체 이기 때문에
        // append() 메서드에 이어서 다시 append() 메서드를 실행하는 것이 가능
        // 이런식의 실행 방식을 Method chaining
        String text = sb.append("번호 : ")
                .append(no)
                .append(", 이름 : ")
                .append(name)
                .append(" , 전화번호 : ")
                .append(tel)
                .toString();

        System.out.println(text);

        // 메서드 체이닝 활용
        // 1번
        String sample = "Hello , IntelliJ";
        String sample2 = sample.toUpperCase();
        String sample3 = sample2.substring(8, 16);
        String sample4 = sample3.replace("E", "*");
        System.out.println(sample4);

        // 2번
        String fi_sample = "Hello , IntelliJ"
                .toUpperCase()
                .substring(8, 16)
                .replace("E", "*");

        System.out.println(fi_sample);

    }
}
