package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerDAO;
import dto.LendingDTO;


/**
 * Servlet implementation class manager_retrundecisionServlet
 */
@WebServlet("/manager_retrundecisionServlet")
public class manager_retrundecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manager_retrundecisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=Integer.parseInt(request.getParameter("id"));
		String retrun="済";
		List <LendingDTO> list =ManagerDAO.selectAlllendingDTO();
		for(LendingDTO e : list)  {
			if(i == e.getId() ) {
				
				LendingDTO book =new LendingDTO( i,e.getBook_id(),e.getUser_id(),e.getLendin_date(),e.getReturn_data(),retrun);
				ManagerDAO.UpdateBook(book);
				System.out.println("返却しました。");
			}
			}
		
		
		String view = "WEB-INF/view/manager_retrundecision.jsp";
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
