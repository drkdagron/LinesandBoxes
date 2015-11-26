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
 * Servlet implementation class game
 */
@WebServlet("/game")
public class game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public game() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("but"));
		String btnpress = request.getParameter("but");
		int x = Integer.valueOf(btnpress.split(",")[0]);
		int y = Integer.valueOf(btnpress.split(",")[1]);	
		GameManager.getInstance().setCell(x, y, "a");
		
		request.setAttribute("size", GameManager.getInstance().getMapSize());
		request.setAttribute("instr", GameManager.getInstance().getInstrText());
		request.setAttribute("board", GameManager.getInstance().getCells());
		
		if (GameManager.getInstance().getGameDone())
		{
			request.setAttribute("winName", GameManager.getInstance().getWinName());
			request.setAttribute("loseName", GameManager.getInstance().getLoseName());
			
			request.setAttribute("winScore", GameManager.getInstance().getWinScore());
			request.setAttribute("loseScore", GameManager.getInstance().getLoseScore());
			
			RequestDispatcher rd = request.getRequestDispatcher("/gameover.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/game.jsp");
			rd.forward(request, response);
		}
	}

}
