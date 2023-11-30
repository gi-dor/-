package Java.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Min {

    /*
    어노테이션 속성 추가하기
     - 형식
            타입 속성명 () default 기본값;
            default 기본값은 생략할 수 있다 .
     */

    int length() default 0;

    String message() default "";
}
