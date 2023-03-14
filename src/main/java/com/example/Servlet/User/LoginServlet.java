package com.example.Servlet.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.Controllers.LoginController;
import com.example.Controllers.UserValidatorController;
import com.example.Service.LoginRepo;
import com.example.Service.UserService;
import com.example.Service.UserValidatorRepo;
import com.example.model.Users;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private UserValidatorRepo userValidatorRepo = new UserService();
    private UserValidatorController userValidatorController = new UserValidatorController(userValidatorRepo);
    private LoginRepo loginRepo = new UserService();
    private LoginController loginController = new LoginController(loginRepo);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("login.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            if (userValidatorController.validUser(email, password)) {
                out.println("Dang nhap thanh cong");

                Users userDB = loginController.login(email, password);

                HttpSession session = req.getSession();

                session.setAttribute("email", userDB.getEmail());
                session.setAttribute("fullname", userDB.getFull_name());

                if (userDB.getRole() == 0) {
                    resp.sendRedirect("home");
                    // hiển thị trang theo role
                } else if (userDB.getRole() == 1) {
                    out.println("<a href='listbook'>ADMIN PAGE</a>");
                }

            } else {
                out.println("Dang nhap that bai<a href='home'>CLICK HERE TO RETURN HOME PAGE</a>");
            }
        } catch (SQLException e) {
            // Xử lý lỗi kết nối cơ sở dữ liệu
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi kết nối cơ sở dữ liệu.");
        } catch (Exception e) {
            // Xử lý lỗi khác
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý yêu cầu.");
        }
    }
}
