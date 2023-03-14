package com.example.Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.AuthorsDAOimpl;
import com.example.DAO.BookDAOimpl;
import com.example.model.Authors;
import com.example.model.Book;

@WebServlet (urlPatterns ={"/home"})

public class HomeServlet extends HttpServlet {
    private BookDAOimpl book = new BookDAOimpl();
    private AuthorsDAOimpl author = new AuthorsDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // List<Book> a = book.getAllBook();
        // req.setAttribute("productList", a);

                // List<Book> a = book.getAllBook();
        // req.setAttribute("productList", a);

        // List<Authors> b = author.getAllAuthors();
        // req.setAttribute("authorlist", b);
        RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
