package Roulette;

import javax.swing.JOptionPane;

public class Player
{
	private String name;
	private int balance;
	public boolean wantsToBet = true;
	public Player(String name,int balance)
	{
		this.name = name;
		this.balance = balance;
	}
	
	public void changeBalance(int amountToChange)
	{
		balance += amountToChange;
	}
	
	public Bet placeBet()
	{
		
		if(wantsToBet)
		{
			int reply = JOptionPane.showConfirmDialog(null, this.getName() + ", Would you like to bet?", "",JOptionPane.YES_NO_OPTION);	
		if (reply == JOptionPane.YES_OPTION)
		{
			Outcome newOutcome = chooseOutcome();
			String ammountBet = JOptionPane.showInputDialog(null, "Your balance is: "+getBalance()+", How much would you like to bet? (min bet £5)");
                         int ammountBetInt = Integer.parseInt(ammountBet);
                        
                        while(ammountBetInt > this.getBalance() || ammountBetInt<= 5)
                        {
                            JOptionPane.showMessageDialog(null, "You have entered an invalid amount to bet, Please try again.");
                            ammountBetInt = Integer.parseInt(JOptionPane.showInputDialog(null, "Your balance is: "+getBalance()+", How much would you like to bet? (min bet £5)"));
                            
                        }
			JOptionPane.showMessageDialog(null, "You have selected: £" + ammountBet);
			
			Bet newBet = new Bet(ammountBetInt,newOutcome,this);
			return newBet;
			
		} else
		{
			wantsToBet = false;
			JOptionPane.showMessageDialog(null, "No bet was placed.");
			return null;

		}
			}
		return null;
		
	}
	
	public Outcome chooseOutcome()
	{
		Outcome newOutcome = new Outcome("",99, "",0);
		
		String[] firstQ = { "Odd/Even", "Single Number", "Colour"};    
		int returnValue = JOptionPane.showOptionDialog(null, "What would you like to bet on?", "",JOptionPane.WARNING_MESSAGE, 0, null, firstQ, firstQ[0]);
		
			if(returnValue == 0)
			{
				String[] oddEvenOptions = { "Odd", "Even"};  
				int oddEven = JOptionPane.showOptionDialog(null, "Odd or even?", "",JOptionPane.WARNING_MESSAGE, 0, null, oddEvenOptions, oddEvenOptions[0]);
				if(oddEven == 0) 
				{
						newOutcome = new Outcome("",99,"odd",1);
				}else
				{
					newOutcome = new Outcome("",99,"even",1);
				}
			}
		
			if(returnValue == 1)
			{
				int singleNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Which number would you like to bet on (0-36)?"));
                                while(singleNum > 36 || singleNum < 0)
                                {
                                    JOptionPane.showMessageDialog(null, "You cannot bet on: " + singleNum + ", Enter a valid number (0-36)");
                                    singleNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Which number would you like to bet on (0-36)?"));
                                }
				newOutcome = new Outcome("",singleNum,"",35);
			}
		
			if(returnValue == 2)
			{
				String[] colours = { "Black", "Red","Green"};   
				int colourChosen = JOptionPane.showOptionDialog(null, "What colour would you like to bet on", "",JOptionPane.WARNING_MESSAGE, 0, null, colours, colours[0]);
				if(colourChosen == 0) 
				{
						newOutcome = new Outcome("black",99,"",1);
				}
				if(colourChosen == 1) 
				{
					newOutcome = new Outcome("red",99,"",1);
				}
				if(colourChosen == 2) 
				{
					newOutcome = new Outcome("green",99,"",35);
				}
			}
			return newOutcome;
	}
	
	public int getBalance(){
		return balance;
	}
	public String getName(){
		return name;
	}
	

}
