<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="topbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <h2>Đăng nhập</h2>

        <c:if test="${alert != null}">
            <h3 style="color:red;">${alert}</h3>
        </c:if>

        <section>
            <label>
                <input type="text" placeholder="Tài khoản" name="username">
            </label>
        </section>

        <section>
            <label>
                <input type="password" placeholder="Mật khẩu" name="password">
            </label>
        </section>

        <!-- Remember me -->
        <section>
            <label>
                <input type="checkbox" name="remember"> Ghi nhớ đăng nhập
            </label>
        </section>

        <button type="submit">Đăng nhập</button>
    </form>

    <p>
        Test tài khoản: <br>
        usn: <b>admin</b> <br>
        pass: <b>123456</b>
    </p>
</body>
</html>
