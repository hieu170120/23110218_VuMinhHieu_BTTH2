package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			if (u.getRoleId() == 1) {
				 req.getRequestDispatcher("/views/login-success.jsp").forward(req, resp);
			} else if (u.getRoleId() == 2) {
				 req.getRequestDispatcher("/views/login-success.jsp").forward(req, resp);
			} else {
				 req.getRequestDispatcher("/views/login-success.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}