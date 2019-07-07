package Roulette; 

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Roulette {

	public ArrayList players = new ArrayList();
	Board board = new Board();

	public Roulette() {
		
		
		 UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.CYAN);
		 UI.put("Panel.background", Color.CYAN);
		 
		addPlayers();
		newRound();  
	}

	public void addPlayers() {

		int numberOfPlayers = (Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of players playing")));  
		for (int x = 0; x < numberOfPlayers; x++) {
			String pName = JOptionPane.showInputDialog(null, "Enter player " + (x + 1) + "'s name.");
			Player player = new Player(pName, 200);
			players.add(player);

		}
	}

	void newRound()
	{
		takeBets();
		findWinners();	
                newRound();
	}
	
	void findWinners()  
	{ 
		int binRandNum = board.wheel.GenerateRandomNumber();
		Bin winningBin = (Bin)board.wheel.allBins.get(binRandNum);
		
		for (int x = 0; x < board.allBets  .size(); x++)
		{
			Bet curPlayersBet = (Bet) board.allBets.get(x);
			Outcome tempOutcome = curPlayersBet.getOutcome();
                        
			if(winningBin.getColour() == tempOutcome.GetOutcomeColour())
			{
                            payOut(curPlayersBet,tempOutcome);
                            System.out.println(curPlayersBet.player.getName()+" has won on colour");
                        }
			if(winningBin.getNumber() == tempOutcome.GetOutcomeNumber())
			{
                            payOut(curPlayersBet,tempOutcome);
                            System.out.println(curPlayersBet.player.getName()+" has won on number");
			}
			if(winningBin.getNumber()==0)
			{
				if(tempOutcome.GetOutcomeOddEven() == "green")
				{
                                    payOut(curPlayersBet,tempOutcome);
					System.out.println(curPlayersBet.player.getName()+" has won on lucky green");
				}
			}
			else if((winningBin.getNumber()%2==0))
			{
				if(tempOutcome.GetOutcomeOddEven() == "even")
				{
                                    payOut(curPlayersBet,tempOutcome);
					System.out.println(curPlayersBet.player.getName()+" has won on even");
				}
				
			}else{
				if(tempOutcome.GetOutcomeOddEven() == "odd")
				{
                                    payOut(curPlayersBet,tempOutcome);
					System.out.println(curPlayersBet.player.getName()+" has won on odd");
				}
			}
		}
		
		
	}
	
	void takeBets() {
		// take multiple bets from multiple people
		for (int x = 0; x < players.size(); x++)
		{
			Player temp = (Player) players.get(x);
			
			Bet newBet = temp.placeBet();
			board.addBetToArray(newBet);  
			
		}
		
		//Outcome roundSpinOutcome = board.wheel.GenerateRandomNumber();
		// Spin Wheel
		// Check if any bets on the board have won and then take/return money.
	}

	void payOut(Bet curPlayersBet,Outcome tempOutcome)  
	{
            int ammountWon = (curPlayersBet.getAmmount() * tempOutcome.GetOdds())+curPlayersBet.getAmmount();
            curPlayersBet.player.changeBalance(ammountWon);
	}
}


