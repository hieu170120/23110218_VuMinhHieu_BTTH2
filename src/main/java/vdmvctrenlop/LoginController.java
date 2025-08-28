package vdmvctrenlop;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login") // URL mapping cho servlet
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Tạo model và gán giá trị
        LoginModel bean = new LoginModel();
        bean.setName(name);
        bean.setPassword(password);

        // Đặt attribute để JSP có thể sử dụng
        request.setAttribute("bean", bean);

        // Kiểm tra đăng nhập
        boolean status = bean.validate();
        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
