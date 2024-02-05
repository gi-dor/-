<%@page import="com.google.gson.Gson" %>
<%@page import="org.apache.catalina.valves.JsonAccessLogValve" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.HashSet" %>
<%@page import="vo.User" %>
<%@page import="dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%

    /*
        요청 URL
            localhost/comm/checkId.jsp?id=rltjs987
        요청 파라미터
            id=xxx

        응답 URL
            localhost/comm/checkId.jsp?id=hong
        응답파라미터
            id=xxx
        */

    String id = request.getParameter("id");

    UserDao userDao = new UserDao();
    User savedUser = userDao.getUserById(id);

    Map<String, Object> map = new HashMap<>();

    map.put("id", id);

    if (savedUser != null) {
        map.put("exist", true);
    } else {
        map.put("exist", false);
    }

    // Gson을 이용해 Map 객체를 JSON Object 구조의 텍스트로 변환한다
    Gson gson = new Gson();
    String jsonText = gson.toJson(map);

    // JSON 텍스트를 응답으로 보낸다
    out.write(jsonText);

%>