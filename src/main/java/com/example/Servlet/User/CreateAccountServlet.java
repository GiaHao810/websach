package com.example.Servlet.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Controllers.CreateAccountController;
import com.example.Service.CreateAccountRepo;
import com.example.Service.UserService;
import com.example.model.Users;

@WebServlet(urlPatterns = {"/createaccount"})
public class CreateAccountServlet extends HttpServlet {
    private CreateAccountRepo createAccountRepo = new UserService();
    private CreateAccountController createAccountController = new CreateAccountController(createAccountRepo);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("register.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        // Chỗ này không thể tự động tạo ra
        Users user = new Users(68, email, password, fullname, address, 0);
        String result = null;

        try {
            result = createAccountController.createaccount(user);
        } catch (SQLException e) {
            // Xử lý lỗi kết nối cơ sở dữ liệu
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi kết nối cơ sở dữ liệu.");
        } catch (Exception e) {
            // Xử lý lỗi khác
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý yêu cầu.");
        }

        out.print(result);

        if(result == "Added User") {
            out.println("Thanh cong");
        } else if(result == "Failed to Add User") {
            out.print("That bai");
        }
    }
}
