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
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String player1Name = (String)request.getParameter("player1").trim();
		String player2Name = (String)request.getParameter("player2").trim();
		
		if (player1Name.isEmpty() && player2Name.isEmpty())
		{
			System.out.println("No Names");
			request.setAttribute("error", "Please enter player names!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
		}
		else
		{
			GameManager.getInstance().buildBoard(Integer.valueOf(request.getParameter("boardSize")));
			GameManager.getInstance().setP1Name(player1Name);
			GameManager.getInstance().setP2Name(player2Name);
			
			if (player1Name.isEmpty() || player2Name.isEmpty())
			{
				System.out.println("One Name");
				GameManager.getInstance().AI = true;
			}
			
			System.out.println("Both Names");
			request.setAttribute("instr", GameManager.getInstance().getInstrText());
			request.setAttribute("size", GameManager.getInstance().getMapSize());
			RequestDispatcher rd = request.getRequestDispatcher("/game.jsp");
			rd.forward(request, response);
		}
	}

}
