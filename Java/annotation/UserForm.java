package Java.annotation;

public class UserForm {

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;

    @NotBlank(message = "아이디는 필수 입력 값입니다")
    @Min(length = 5, message = "아이디는 최소 5글자 이상입니다")
    private String id;


    @Min(length = 8, message = "비밀번호는 8 글자 이상입니다")
    @Max(length = 16, message = "비밀번호는 16글자를 넘길수 없습니다")

    private String password;

    public UserForm(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }


}
