package wks.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameManager {

	private static GameManager gm = null;
	private String[][] cells = null;
	
	public boolean AI = false;
	
	public String p1;
	public String p2;
	
	private int mapSize = 11; //default the small board
	
	private int p1Score;
	private int p2Score;
	
	private int currentPlayer = 0;
	private int maxPlayers = 2;
	
	private GameManager() {
		cells = new String[mapSize][mapSize];
	}
	
	public void setP1Name(String val)
	{
		if (val == null || val.isEmpty())
			p1 = "AI Player";
		else
			p1 = val;
	}
	public void setP2Name(String val)
	{
		if (val == null || val.isEmpty())
			p2 = "AI Player";
		else
			p2 = val;
	}
	
	public String getWinName()
	{
		if (p1Score > p2Score)
			return p1;
		else
			return p2;
	}
	public int getWinScore()
	{
		if (p1Score > p2Score)
			return p1Score;
		else
			return p2Score;
	}
	public String getLoseName()
	{
		if (p1Score > p2Score)
			return p2;
		else
			return p1;
	}
	public int getLoseScore()
	{
		if (p1Score > p2Score)
			return p2Score;
		else
			return p1Score;
	}
	
	public int getP1Score()
	{
		return p1Score;
	}
	public int getP2Score()
	{
		return p2Score;
	}
	
	public String getInstrText()
	{
		String turn;
		if (currentPlayer == 0)
			turn = p1;
		else
			turn = p2;
		
		return "Current Turn: " + turn;
	}

	public int getTotalPossibleScore()
	{
		int i = (mapSize - 1) / 2;
		return i * i;
	}
	public boolean getGameDone()
	{
		int i = p1Score + p2Score;
		if (i >= getTotalPossibleScore())
		{
			return true;
		}
		
		return false;
	}
	
	public void buildBoard(int i)
	{
		if (i == 0)
			mapSize = 11;
		else if (i == 1)
			mapSize = 17;
		else if (i == 2)
			mapSize = 23;
		
		currentPlayer = 0;
		p1Score = 0;
		p2Score = 0;
		System.out.println("Board created at size: " + mapSize);
		cells = new String[mapSize][mapSize];
	}
	
	public synchronized static GameManager getInstance() {
		if (gm == null) {
			gm = new GameManager();
		}
		return gm;
	}
	
	public void setCell(int x, int y, String val)
	{
		cells[x][y] = val;

		//player = currentplayer 0
		//AI = currentplayer 1
		if (!checkSquares())
		{
			currentPlayer++;
			currentPlayer %= maxPlayers;
			
			if (AI)
			{
				if (currentPlayer == 1)
					AiPlay();
			}
		}
		else
		{
			if (AI)
			{
				if (currentPlayer == 1)
					AiPlay();
			}
		}
	}
	
	public void AiPlay()
	{
		Random aiMove = new Random();
		List<AIMove> moves = new ArrayList<AIMove>();
		//check for 3
		for (int i= 1; i < mapSize; i+=2)
		{
			for (int j = 1; j < mapSize; j+=2)
			{
				int open = aiCheckSquare(i,j, 3, moves);
				if (open == 3)
				{
					System.out.println("AI Logic -> 1 Open Square At: " + i + ", " + j);
				}
			}
		}
		System.out.println("AI Logic -> Total Moves: " + moves.size());
		if (moves.size() > 0)
		{
			int rnd = aiMove.nextInt(moves.size());
			AIMove current = moves.get(rnd);
			System.out.println("AI Logic -> placing line at: " + current.X +", " + current.Y);
			setCell(current.X, current.Y, "a");
			return;
		}
		
		//check for 0
				for (int i= 1; i < mapSize; i+=2)
				{
					for (int j = 1; j < mapSize; j+=2)
					{
						int open = aiCheckSquare(i,j, 0, moves);
						if (open == 1)
						{
							System.out.println("AI Logic -> 4 Open Square At: " + i + ", " + j);
						}
					}
				}
				System.out.println("AI Logic -> Total Moves: " + moves.size());
				if (moves.size() > 0)
				{
					int rnd = aiMove.nextInt(moves.size());
					AIMove current = moves.get(rnd);
					System.out.println("AI Logic -> placing line at: " + current.X +", " + current.Y);
					setCell(current.X, current.Y, "a");
					return;
				}
		
		//check for 1
		for (int i= 1; i < mapSize; i+=2)
		{
			for (int j = 1; j < mapSize; j+=2)
			{
				int open = aiCheckSquare(i,j, 1, moves);
				if (open == 1)
				{
					System.out.println("AI Logic -> 3 Open Square At: " + i + ", " + j);
				}
			}
		}
		System.out.println("AI Logic -> Total Moves: " + moves.size());
		if (moves.size() > 0)
		{
			int rnd = aiMove.nextInt(moves.size());
			AIMove current = moves.get(rnd);
			System.out.println("AI Logic -> placing line at: " + current.X +", " + current.Y);
			setCell(current.X, current.Y, "a");
			return;
		}
		
		//check for 2
				for (int i= 1; i < mapSize; i+=2)
				{
					for (int j = 1; j < mapSize; j+=2)
					{
						int open = aiCheckSquare(i,j,2, moves);
						if (open == 2)
						{
							System.out.println("AI Logic -> 2 Open Square At: " + i + ", " + j);
						}
					}
				}
				System.out.println("AI Logic -> Total Moves: " + moves.size());
				if (moves.size() > 0)
				{
					int rnd = aiMove.nextInt(moves.size());
					AIMove current = moves.get(rnd);
					System.out.println("AI Logic -> placing line at: " + current.X +", " + current.Y);
					setCell(current.X, current.Y, "a");
					return;
				}
	}
	
	public String getCell(int x, int y)
	{
		return cells[x][y];
	}
	
	public int aiCheckSquare(int x, int y, int open, List<AIMove> moves)
	{
		int num = 0;
		
				if (cells[x][y] == null)
				{
					if (cells[x - 1][y] == "a")
					{
						num++;
					}
					if (cells[x + 1][y] == "a") 
					{
						num++;
					}
					if (cells[x][y-1] == "a") 
					{
						num++;
					}
					if (cells[x][y+1] == "a")
					{
						num++;
					}
				}
				
				if (num == open)
				{
					if (cells[x - 1][y] == null)
					{
						moves.add(new AIMove(x-1, y));
					}
					if (cells[x + 1][y] == null) 
					{
						moves.add(new AIMove(x+1, y));
					}
					if (cells[x][y-1] == null) 
					{
						moves.add(new AIMove(x, y-1));
					}
					if (cells[x][y+1] == null)
					{
						moves.add(new AIMove(x, y+1));
					}
				}
				
		return num;
	}
	
	public boolean checkSquares()
	{
		boolean boxMade = false;
		for (int i= 0; i < mapSize; i++)
		{
			for (int j = 0; j < mapSize; j++)
			{
				if (i % 2 == 1 && j % 2 == 1)
				{
					if (cells[i][j] == null)
					{
						if (cells[i - 1][j] == "a" && cells[i + 1][j] == "a" && cells[i][j-1] == "a" && cells[i][j+1] == "a")
							{
								if (currentPlayer == 0)
								{
									p1Score++;
									cells[i][j] = "b";
									boxMade = true;
								}
								else if (currentPlayer == 1)
								{
									p2Score++;
									cells[i][j] = "c";
									boxMade = true;
								}
							}
					}
				}
			}
		}
		
		return boxMade;
	}
	
	public int getMapSize()
	{
		return mapSize;
	}
	public void setMapSize(int val)
	{
		mapSize = val;
	}
	
	public String[][] getCells()
	{
		return cells;
	}
	
	public void resetGame()
	{
		cells = new String[15][15];
	}
}