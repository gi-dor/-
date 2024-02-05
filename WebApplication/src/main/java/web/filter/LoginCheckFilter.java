package web.filter;

import java.io.IOException;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
@WebFilter(
		urlPatterns = "/*" ,
		initParams = {
				@WebInitParam (name = "attrName" , value = "LOGIN_USER")
		}
)
*/
public class LoginCheckFilter implements Filter {


    // 로그인한 사용자만 접근이 허용된 요청 URI를 저장하는 Set 객체
    private Set<String> urlSet = Set.of(
            "/comm/board/form.jsp",
            "/comm/board/insert",
            "/comm/board/modifyform.jsp",
            "/comm/board/modify.jsp",
            "/comm/board/delete.jsp",
            "/comm/board/info.jsp"
    );


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        // 전처리 코드 작성하는곳
        System.out.println("LoginCheckFilter 전처리 실행");

        // 요청 URI 조회
        // 요청 URI는 URI 에서 url-path 값을 반환
        String requestURI = httpReq.getRequestURI();
        System.out.println("요청 URI : " + requestURI);

        if (urlSet.contains(requestURI)) {
            System.out.println("로그인이 필요한 요청이다");

            // 로그인이 필요한 요청
            HttpSession session = httpReq.getSession();
            if (session.getAttribute("LOGIN_USER") != null) {
                System.out.println("로그인이 된 상태");
                filterChain.doFilter(req, res);
            } else {
                System.out.println("로그인이 안된 상태다.");
                httpRes.sendRedirect("/comm/loginform.jsp?error=deny");
            }

        } else {
            // 로그인이 필요하지 않은 요청
            System.out.println("로그인이 필요치 않은 요청이다");
            filterChain.doFilter(req, res);

        }

        // 후처리 코드 작성하는곳
        System.out.println("LoginCheckFilter 후처리 실행");

    }

}
