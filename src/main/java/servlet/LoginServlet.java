package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.BookDAO;
import dto.Account;
import dto.BookDTO;
import util.GenerateHashedPw;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getParameter("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		// 入力されたIDをもとにソルトを取得する。
		String salt = AccountDAO.getSalt(email);
		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if(salt == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		// 取得したソルトを使って入力したPWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		// 入力されたID、ハッシュしたPWに一致するユーザを検索する
		Account account = AccountDAO.login(email, hashedPw);

		// 一致するユーザがいなければ、ログイン失敗
			
			
		if(account == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}  else if(account.getMail().equals("kanrisha@123")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("root", account);
			
			String view = "WEB-INF/view/manager_menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			// ログイン情報をセッションに登録
			HttpSession session = request.getSession();
			session.setAttribute("user", account);
			
			List<BookDTO> List = BookDAO.SelectAllBookD();

			request.setAttribute("list", List);
			
			String view = "WEB-INF/view/book_list_login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
