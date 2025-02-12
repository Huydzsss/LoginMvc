package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("✅ LoginServlet initialized!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("🔍 Login attempt: " + username); // Debug

        if (UserDao.validateUser(username, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60);
            System.out.println("✅ User logged in: " + username);
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            System.out.println("❌ Login failed for user: " + username);
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }
}
