package com.example.Servlet.Book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.BookDAOimpl;
import com.example.model.Book;

@WebServlet({"/listbook"})
public class ListBookServlet extends HttpServlet {
    private BookDAOimpl book = new BookDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> blist = book.getAllBook();
        req.setAttribute("Booklist", blist);
    
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
        dispatcher.forward(req, resp);
    }


}

