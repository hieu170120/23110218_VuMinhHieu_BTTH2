package vdmvctrenlop.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vdmvctrenlop.model.User;
import vdmvctrenlop.service.UserService;
import vdmvctrenlop.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isRememberMe = false;
        String remember = req.getParameter("remember");

        if ("on".equals(remember)) {
            isRememberMe = true;
        }

        String alertMsg = "";

        // Kiểm tra dữ liệu nhập
        if (username == null || username.isEmpty() 
                || password == null || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        // Gọi service để check login
        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user != null) {
            // Nếu login thành công -> lưu session
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);

            // Nếu chọn Remember me -> lưu cookie
            if (isRememberMe) {
                saveRememberMe(resp, username);
            }

            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            // Sai tài khoản hoặc mật khẩu
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    // Hàm lưu cookie Remember Me
    private void saveRememberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(60 * 60 * 24 * 7); // 7 ngày
        resp.addCookie(cookie);
    }
}
