package com.example.Servlet.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Controllers.UserValidatorController;
import com.example.Service.UserService;
import com.example.Service.UserValidatorRepo;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private UserValidatorRepo userValidatorRepo = new UserService();
    private UserValidatorController userValidatorController = new UserValidatorController(userValidatorRepo);

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

        String result = null;
        try {
            result = userValidatorController.validUser(email, password);
        } catch (SQLException e) {
            // Xử lý lỗi kết nối cơ sở dữ liệu
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi kết nối cơ sở dữ liệu.");
        } catch (Exception e) {
            // Xử lý lỗi khác
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý yêu cầu.");
        }
    
        if (result == "Valid") {
            out.println("Thanh cong" );
        } else if (result == "Unvalid") {
            out.println("That bai");
        }
    }
}
