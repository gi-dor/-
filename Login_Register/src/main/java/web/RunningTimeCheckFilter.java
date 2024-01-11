package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RunningTimeCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        // 서블릿 / JSP 실행 전 시간을 조회한다
        long startUnixTime = System.currentTimeMillis();

        filterChain.doFilter(req, res);

        // 서블릿 / JSP 실행 후 시간을 조회한다
        long endUnixTime = System.currentTimeMillis();

        // 두시간간의 간격을 계산하다.
        long runningTime = endUnixTime - startUnixTime;
        System.out.println("실행 시간 : " + runningTime + " 밀리초");


    }
}
