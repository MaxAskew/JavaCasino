package Roulette;

public class Bet
{
	private int ammount;
	private Outcome outcome;
	Player player;
	
	public Bet(int ammount, Outcome outcome,Player player)
	{
		this.ammount = ammount;
		this.outcome = outcome;
		this.player = player;
	}
        int getAmmount()
        {
            return ammount;
        }
	
	Outcome getOutcome()
	{
		return outcome;
	}
}
