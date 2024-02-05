package web.listener;

import dto.LoginUser;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginUserRemoveListener implements HttpSessionListener {


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

        ServletContext application = session.getServletContext();
        Set<LoginUser> set = (Set<LoginUser>) application.getAttribute("LOGIN_USER");
        if (set != null) {
            set.remove(loginUser);
        }
    }
}
