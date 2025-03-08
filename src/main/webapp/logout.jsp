<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionUser = request.getSession();
    sessionUser.invalidate(); // Hủy session
    response.sendRedirect("login.jsp"); // Quay lại trang đăng nhập
%>
