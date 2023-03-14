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

import com.example.Controllers.ChangepassController;
import com.example.Controllers.UserValidatorController;
import com.example.Service.ChangepassRepo;
import com.example.Service.UserService;
import com.example.Service.UserValidatorRepo;

@WebServlet(urlPatterns = {"/changepassword"})
public class ChangepassServlet extends HttpServlet {
    private UserValidatorRepo userValidatorRepo = new UserService();
    private UserValidatorController userValidatorController = new UserValidatorController(userValidatorRepo);
    private ChangepassRepo changepassRepo = new UserService();
    private ChangepassController changpassController = new ChangepassController(changepassRepo);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("changepw.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        
        String email = req.getParameter("email");
        String oldP = req.getParameter("oldPassword");
        String newP = req.getParameter("newPassword");

        try {
            if(userValidatorController.validUser(email, oldP)){
                changpassController.changepassword(email, oldP, newP);

                resp.sendRedirect("home");
            } else {
                out.println("Doi mat khau khong thanh cong <a href='home'>CLICK HERE TO RETURN HOME PAGE</a>");
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
