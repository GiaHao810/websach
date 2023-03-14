package com.example.Servlet.Author;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.AuthorsDAOimpl;
import com.example.model.Authors;

@WebServlet({"/addAuthor"})
public class addAuthorServlet extends HttpServlet{
    private AuthorsDAOimpl Authors = new AuthorsDAOimpl();  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String intauthor_id = req.getParameter("author_id");
        String StringName_a = req.getParameter("name_a");

        if (intauthor_id == null || intauthor_id.equals("")) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(" khong duoc bo trong id tac gia  ");
          }
          else if(StringName_a == null || StringName_a.equals("")){
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(" khong duoc bo trong ten tac gia ");
        }else{

            try {
                int author_id = Integer.parseInt(intauthor_id);
                String Name_a = StringName_a;
                Authors A = new Authors();
                A.setAuthor_id(author_id);
                A.setName_a(Name_a);
                int result = Authors.add(A);
                if (result == 200 ) {
                    resp.setContentType("text/plain");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(" Book da duoc them vao ");
                } else if( result == 400 ){
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, " database co van de ");
                }

            } catch (Exception e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }

    }
    
}
}
