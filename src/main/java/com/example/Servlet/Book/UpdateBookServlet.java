package com.example.Servlet.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.BookDAOimpl;
import com.example.model.Book;
@WebServlet(urlPatterns = {"/Update"})
public class UpdateBookServlet extends HttpServlet {
    private BookDAOimpl book = new BookDAOimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String intbook_id = req.getParameter("book_id");
        String Stringtitle = req.getParameter("title");
        String floatprice = req.getParameter("price");
        String intquantity = req.getParameter("quantity");
        String Stringdescription = req.getParameter("description");
        String Stringimage_url =req.getParameter("image_url");
        String intauthor_id = req.getParameter("author_id");

        if (intbook_id == null || intbook_id.equals("")) {
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong id book "); 

          }
          else if (Stringtitle == null || Stringtitle.equals("")) {
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong tua id book "); 

          } 
          else if (floatprice == null || floatprice.equals("")){
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong gia tien "); 

          }
          else if (intquantity == null || intquantity.equals("")){
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong so luong "); 

          }
          else if (Stringdescription == null || Stringdescription.equals("")){

                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong mo ta sach "); 

          }
          else if (Stringimage_url == null || Stringimage_url.equals("")){

                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong bia sach "); 

          }
          else if (intauthor_id == null || intauthor_id.equals("")){

                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" khong duoc bo trong id tac gia "); 

          }else
            
            try {
                int book_id = Integer.parseInt(intbook_id);
                String title = Stringtitle;
                float price = Float.parseFloat(floatprice);
                int quantity = Integer.parseInt(intquantity);
                String description = Stringdescription;
                int author_id = Integer.parseInt(intauthor_id);
                byte[] imageData = Files.readAllBytes(Paths.get(Stringimage_url));

                Book B = new Book();

                B.setBook_id(book_id);
                B.setTitle(title);
                B.setPrice(price);
                B.setQuantity(quantity);
                B.setDescription(description);
                B.setImage_url(imageData);
                B.setAuthor_id(author_id);

                int result = book.update(B);
                
                if (result > 0) {
                    resp.setContentType("text/plain");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(" Book da duoc update ");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, " book chua duoc update ");
                }

            } catch (NumberFormatException e) {
                String errormessge = e.getMessage();
                resp.setContentType("text/plain");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(" da xay ra loi " + errormessge); 
            }
          }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp");
        dispatcher.forward(req, resp);
    }
}
