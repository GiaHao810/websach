package com.example.Servlet.Author;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.AuthorsDAOimpl;
@WebServlet(urlPatterns = {"/deletedAuthor"})
public class deletedAuthorServlet extends HttpServlet {
    private AuthorsDAOimpl Authors = new AuthorsDAOimpl(); 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String intauthor_id = req.getParameter("author_id");
        if (intauthor_id == null || intauthor_id.equals("")) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(" khong duoc bo trong id tac gia  ");
          }
          else{
            try {
                int author_id = Integer.parseInt(intauthor_id);

                int result = Authors.deleted(author_id);
                 if (result > 0) {
                    resp.setContentType("text/plain");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(" xoa thanh cong tac gia ");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, " tac gia  chua bi xoa ");
                }

            }catch (NumberFormatException e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }
    
        }
    }
}
