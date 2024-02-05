### 🔹 Filter

#### Servlet Filter

- Client 로 부터 Server로 요청이 들어오기 전에 서블릿을 거쳐서 필터링 하는것
  <br><br>

- 전처리 . 후처리 담당하는 **서블릿의 API**
- 전처리 작업 - 로그인체크 , 권한체크 ,암호화된 요청 데이터의 복호화 , 요청 파라미터에 대한 로그 출력
- 후처리 작업 - 응답 데이터의 암호화 , 응답 컨텐츠 압축 , 요청 처리에 소요된 시간 출력 ( 요청 처리 성능 체크)
- 필터는 **여러개를 등록**할수 있고 등록된 필터들 **FilterChain 객체에 의해 관리**된다
- FilterChain 객체는 요청이 접수되면 등록된 필터를 **순서대로 실행**하고 , 더이상 실행할 필터가 없으면 JSP 를 실행 한다.

#### 필터 배포하기

1. ```@WebFilter``` 어노테이션

- 필터클래스 정의와 필터배포를 클래스에서 한번에 정의한다

```java
   import javax.servlet.annotation.WebInitParam;

@WebFilter(
        urlPatterns = "/*",
        initParams = @WebInitParam(name = "attributeName", value = "LOGIN_USER"))
public class LoginCheckFilter implements Filter {

}
```

2. web-app/WEB_INF/web.xml 설정파일

- 필터 클래스정의하기

```java
import java.io.File;

public class LoginCheckFilter implements Filter {

}
```

- web.xml 에서 필터 클래스 배포

```html

<filter>
    <filter-name> logincheck</filter-name>
    <filter-class>web.filter.LoginCheckFilter</filter-class>
    <init-param>
        <param-name>attributeName</param-name>
        <param-value>LOGIN_USER</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name> logincheck</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

<img src="">