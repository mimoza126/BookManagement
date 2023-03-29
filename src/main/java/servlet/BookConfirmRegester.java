package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BookDTO;

/**
 * Servlet implementation class BookConfirmRegester
 */
@WebServlet("/BookConfirmRegester")
public class BookConfirmRegester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookConfirmRegester() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String isbn = request.getParameter("isbn");
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		
		
		
		BookDTO bo = new BookDTO( 0 , title , author , publisher , isbn ,category , type);
		
		int stock = (int)Integer.parseInt(request.getParameter("stock"));
		
		HttpSession session = request.getSession();
		session.setAttribute("stock_data" , stock);
		session.setAttribute("input_data", bo);
		
		String view = "WEB-INF/view/book_confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);	
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
