package com.example.Servlet.Book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.BookDAOimpl;
@WebServlet(urlPatterns = {"/DeletedBook"})
public class DeletedBookServlet extends HttpServlet {
    private BookDAOimpl book = new BookDAOimpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Stringbook_id = req.getParameter("book_id");
        
        if (Stringbook_id == null || Stringbook_id.equals("")) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(" id khong duoc de trong ");
          }
          else {
            try {
                int book_id = Integer.parseInt(Stringbook_id);
                int result = book.deleted(book_id);

                if (result > 0) {
                    resp.setContentType("text/plain");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(" :((( em vẫn đẹp như ngày anh mất em á á ");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, " book chua bi xoa ");
                }

            } catch (NumberFormatException e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
        dispatcher.forward(req, resp);
    }
    
}
