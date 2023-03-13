package com.example.Servlet.Book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.BookDAOimpl;
import com.example.model.Book;
@WebServlet(urlPatterns = {"/Findbook"})
public class FindBookServlet extends HttpServlet{
    private BookDAOimpl book = new BookDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
        dispatcher.forward(req, resp);
    }

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

                Book a = book.getBookByID(book_id);
                if( a != null){

                    String title = a.getTitle();
                    float price = a.getPrice();
                    int quantity = a.getQuantity();
                    String description = a.getDescription();
                    byte[] imageData = a.getImage_url();
                    int author_id = a.getAuthor_id();
    
                    req.setAttribute("book_id", book_id);
                    req.setAttribute("book", title);
                    req.setAttribute("price", price);
                    req.setAttribute("quantity", quantity);
                    req.setAttribute("description", description);
                    req.setAttribute("image_url", imageData);
                    req.setAttribute("author_id", author_id);
    
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
                    dispatcher.forward(req, resp);

                }
                    resp.setContentType("text/plain");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(" khong co sach trong danh sach " ); 

            } catch (NumberFormatException e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }
        }
    }
        






        
}

