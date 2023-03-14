package com.example.Servlet.Book;

import java.io.IOException;

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

@WebServlet(urlPatterns= {"/book"})
public class BookDetailServlet extends HttpServlet {  

    private BookDAOimpl book = new BookDAOimpl();

    private AuthorsDAOimpl Authors = new AuthorsDAOimpl(); 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Stringbook_id = req.getParameter("id");
        
        if (Stringbook_id == null || Stringbook_id.equals("")) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(" dung lai di dung pha nua :((( ");
          }
          else {
            try {
                int book_id = Integer.parseInt(Stringbook_id);

                Book a = book.getBookByID(book_id);

                String title = a.getTitle();
                float price = a.getPrice();
                int quantity = a.getQuantity();
                String description = a.getDescription();
                byte[] imageData = a.getImage_url();
                int author_id = a.getAuthor_id();
                String base64EncodedImage = Base64.encodeBase64String(imageData);

                req.setAttribute("book_id", book_id);
                req.setAttribute("book", title);
                req.setAttribute("price", price);
                req.setAttribute("quantity", quantity);
                req.setAttribute("description", description);
                req.setAttribute("image_url", base64EncodedImage);
                req.setAttribute("author_id", author_id);
                
                Authors b = Authors.getAuthorsByID(author_id);
                String NameAuthors = b.getName_a();
                req.setAttribute("NameAuthors", NameAuthors);

            RequestDispatcher dispatcher = req.getRequestDispatcher("show.jsp");
            dispatcher.forward(req, resp);

            } catch (NumberFormatException e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }
        }
        
    }
}
