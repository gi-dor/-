package web.listener;

import dto.LoginUser;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LoginUserAddListener implements HttpSessionAttributeListener {


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

        // 세션에 추가된 속성값을 조회
        LoginUser loginUser = (LoginUser) se.getValue();

        // HttpSession 객체를 획득
        HttpSession session = se.getSession();

        // ServletContext 객체를 획득
        ServletContext application = session.getServletContext();
        Set<LoginUser> set = (Set) application.getAttribute("LOGIN_USERS");

        if (set == null) {
            set = new HashSet<LoginUser>();
            application.setAttribute("LOGIN_USERS", set);
        }
        set.add(loginUser);

//		System.out.println("HttpSession객체에 속성이 추가되었다");
//		String	name =  se.getName();
//		Object value = se.getValue();
//		
//		System.out.println("속성명 : "+name);
//		System.out.println("속성값 : "+value);
    }
}
