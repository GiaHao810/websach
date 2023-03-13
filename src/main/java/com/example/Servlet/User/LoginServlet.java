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

import com.example.Controllers.LoginController;
import com.example.Controllers.UserValidatorController;
import com.example.Service.LoginRepo;
import com.example.Service.UserService;
import com.example.Service.UserValidatorRepo;

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
        boolean result_login = false;
        boolean result_valid = false;

        try {
            result_valid = userValidatorController.validUser(email, password);
        } catch (SQLException e) {
            // Xử lý lỗi kết nối cơ sở dữ liệu
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi kết nối cơ sở dữ liệu.");
        } catch (Exception e) {
            // Xử lý lỗi khác
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý yêu cầu.");
        }

        if (result_valid) {
            
            result_login = false;
            try {
                result_login = loginController.login(email, password);
            } catch (SQLException e) {
                // Xử lý lỗi kết nối cơ sở dữ liệu
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi kết nối cơ sở dữ liệu.");
            } catch (Exception e) {
                // Xử lý lỗi khác
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý yêu cầu.");
            }
            

            if(result_login) {
                // Xu ly dang nhap thanh cong
                out.println("Dang nhap thanh cong");
            }

        } else {
            out.println("Dang nhap that bai");
        }
    }
}
