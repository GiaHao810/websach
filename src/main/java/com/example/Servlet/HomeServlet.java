package com.example.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.example.DAO.AuthorsDAOimpl;
import com.example.DAO.BookDAOimpl;
import com.example.model.Authors;
import com.example.model.Book;
import com.example.model.BookAuthorDTO;

@WebServlet (urlPatterns ={"/home"})

public class HomeServlet extends HttpServlet {
    private BookDAOimpl book = new BookDAOimpl();
    private AuthorsDAOimpl author = new AuthorsDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        List<Book> blist = book.getAllBook();
        List<Authors> alist = author.getAllAuthors();
        List<BookAuthorDTO> dtoList = new ArrayList<>();

        for (Book book : blist) {
            String authorName = null;
            for (Authors Authors : alist) {
                if (book.getAuthor_id() == Authors.getAuthor_id()) {    
                    authorName = Authors.getName_a();
                    break;
                }
            }
            byte [] imageData = book.getImage_url();
            String base64EncodedImage = Base64.encodeBase64String(imageData);
            BookAuthorDTO dto = new BookAuthorDTO(book.getTitle(), book.getPrice(), book.getQuantity() ,  base64EncodedImage ,book.getDescription() , authorName);
            dtoList.add(dto);
        }
        req.setAttribute("productList", dtoList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
