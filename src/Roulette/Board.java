package Roulette;

import java.util.ArrayList;

public class Board
{
	public ArrayList allBets = new ArrayList();
	public Wheel wheel = new Wheel();
	
	
	public void addBetToArray(Bet newBet)
	{
		allBets.add(newBet);
	}
	
}
