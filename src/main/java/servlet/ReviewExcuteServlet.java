
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dto.ReviewDTO;

/**
 * Servlet implementation class ReviewExcuteServlet
 */
@WebServlet("/ReviewExcuteServlet")
public class ReviewExcuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewExcuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReviewDTO re = (ReviewDTO)session.getAttribute("input_data");
		//int stock = (int)session.getAttribute("stock_data");
		
			int result = BookDAO.RegisterReview(re);
			System.out.println(result);
			String path = "";
			request.setAttribute("input", re);
			if(result == 1) {
				// 登録に成功したので、sessionのデータを削除
				session.removeAttribute("input_data");
			//session.removeAttribute("stock_data");
				
				path = "WEB-INF/view/review_success.jsp";
				
			} else {
				// 失敗した場合はパラメータ付きで登録画面に戻す
				path = "WEB-INF/view/review_write.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
