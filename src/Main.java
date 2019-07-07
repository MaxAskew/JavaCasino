import javax.swing.JOptionPane;

import Blackjack.Blackjack;
import Roulette.Roulette;

public class Main {
	public static void main(String[] args) 
	{
		String[] firstQ = { "Blackjack", "Roulette"};    
		int returnValue = JOptionPane.showOptionDialog(null, "Which game would you like to play?", "",JOptionPane.WARNING_MESSAGE, 0, null, firstQ, firstQ[0]);
		
	       if(returnValue==0) {
	    	   Blackjack bj = new Blackjack();
	    	   }
	       else {
	       Roulette r = new Roulette();
	       }
	 }
	    
	}



