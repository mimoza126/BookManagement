package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dto.ReviewDTO;

/**
 * Servlet implementation class ReviewConfirm
 */
@WebServlet("/ReviewConfirm")
public class ReviewConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("id"));
		int book_id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");

		
		ReviewDTO re = new ReviewDTO( 0 ,book_id,title ,comment);
		HttpSession session = request.getSession();
		session.setAttribute("input_data", re);
		
		
		String view = "WEB-INF/view/review_confirm.jsp";

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