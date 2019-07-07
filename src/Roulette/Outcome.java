package Roulette;

public class Outcome
{
	private String colour;
	private int number;
	private String oddEven;
        private int odds;
	
	public Outcome(String colour, int number, String oddEven, int odds)
	{
		this.colour = colour;
		this.number = number;
		this.oddEven = oddEven;
                this.odds = odds;
	}
	int GetOdds()
	{
		return odds;
	}
	
	int GetOutcomeNumber()
	{
		return number;
	}
	String GetOutcomeColour()
	{
		return colour;
	}
	String GetOutcomeOddEven()
	{
		return oddEven;
	}

}
