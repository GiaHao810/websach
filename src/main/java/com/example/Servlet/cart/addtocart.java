package com.example.Servlet.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.DAO.BookDAOimpl;
import com.example.model.Book;
import com.example.model.CartBook;
@WebServlet(urlPatterns = {"/addtocart"})
public class addtocart extends HttpServlet{

    BookDAOimpl book = new BookDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Id = req.getParameter("id");
		Book newbook = book.getBookByID(Integer.parseInt(Id));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if (obj == null) {
			// Tao mat hang
			CartBook CartBook = new CartBook();
			CartBook.setBook(newbook);
			CartBook.setQuantity(1);
			CartBook.setUnitPrice(newbook.getPrice());
			// gio hang co nhieu mat hang
			Map<String, CartBook> map = new HashMap<>();
			map.put(Id, CartBook);

			session.setAttribute("cart", map);
		} else {
			Map<String, CartBook> map = (Map<String, CartBook>) obj;

			CartBook CartBook = map.get(Id);

			if (CartBook == null) {
				CartBook = new CartBook();
				CartBook.setBook(newbook);
				CartBook.setQuantity(1);
				CartBook.setUnitPrice(newbook.getPrice());

				map.put(Id, CartBook);
			} else {

				CartBook.setQuantity(CartBook.getQuantity() + 1);
			}

			session.setAttribute("cart", map);
		}

		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
