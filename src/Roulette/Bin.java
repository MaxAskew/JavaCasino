package Roulette;

import java.util.ArrayList;

public class Bin {
	
	private int binNumber;
	private String binColour;
	private String oddeven;
		
	public Bin(String colour,int number)
	{
		this.binColour = colour;
		this.binNumber = number;	
	}
	
	public String getColour(){
		return binColour;
	}
	public int getNumber()
	{
		return binNumber;
	}
	
	
	
}
