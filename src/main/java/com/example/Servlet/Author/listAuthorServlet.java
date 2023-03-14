package com.example.Servlet.Author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.AuthorsDAOimpl;
import com.example.model.Authors;

@WebServlet(urlPatterns = {"/listAuthor"})
public class listAuthorServlet extends HttpServlet{
    private AuthorsDAOimpl Authors = new AuthorsDAOimpl(); 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Authors> alist = Authors.getAllAuthors();
        req.setAttribute("authorlist", alist);
  
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
        dispatcher.forward(req, resp);

    }
    
}
