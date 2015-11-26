package wks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wks.gamelogic.GameManager;

/**
 * Servlet implementation class gameover
 */
@WebServlet("/gameover")
public class gameover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameover() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("playBtn") != null)
		{
			GameManager.getInstance().buildBoard(GameManager.getInstance().getMapSize());
			request.setAttribute("instr", GameManager.getInstance().getInstrText());
			request.setAttribute("size", GameManager.getInstance().getMapSize());
			
			RequestDispatcher rd = request.getRequestDispatcher("/game.jsp");
			rd.forward(request, response);
		}
		else if (request.getParameter("backBtn") != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
