package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
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
		HttpSession session = request.getSession();
		Account user_id = (Account)session.getAttribute("user");
		if(user_id == null){
			//セッションの中身がnullであれば不正アクセスと判断し
			//ログイン画面へ戻る
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		int book_id = (int)Integer.parseInt(request.getParameter("id"));
		
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		
		
		
		
		ReviewDTO re = new ReviewDTO( 0 ,book_id,title ,comment);
		session.setAttribute("book_data" , book_id);
		session.setAttribute("input_data", re);
		
		
		String view = "WEB-INF/view/reivew_confirm.jsp";
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
