package Blackjack;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Table {
	private Shoe gameShoe;
	private ArrayList<Hand> playerHands;

	public Table(int noOfDecks) {
		this.gameShoe = new Shoe(noOfDecks);
		this.playerHands = new ArrayList<Hand>();
	}

	void newRound(ArrayList gamblers, Dealer dealer) {
		createHands(gamblers);
		startDraw(dealer);
		playGame(dealer, gameShoe);
		compareHands(playerHands, dealer);
		playerHands.clear();
		dealer.getDealerCards().clear();

		removeFromTable(gamblers);
	}

	void removeFromTable(ArrayList gamblers) {
		ArrayList leftGamblers = new ArrayList<Gambler>();
		for (int x = 0; x < gamblers.size(); x++) {
			Gambler temp = (Gambler) gamblers.get(x);

			int reply = JOptionPane.showConfirmDialog(null, temp.getName() + ", Do you want to play another round?", "",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.NO_OPTION) {
				leftGamblers.add(temp);

			}

		}
		gamblers.removeAll(leftGamblers);
		String gamblerNamesLeft = "";
		for (int x = 0; x < leftGamblers.size(); x++) {
			Gambler tempLeft = (Gambler) leftGamblers.get(x);
			gamblerNamesLeft += tempLeft.getName() + ", ";

		}
		JOptionPane.showMessageDialog(null, gamblerNamesLeft + " have left the table.");

	}

	void playGame(Dealer dealer, Shoe gameShoe) {
		for (int x = 0; x < playerHands.size(); x++) {
			Gambler curGambler = playerHands.get(x).getGambler();
			curGambler.playGame(playerHands.get(x), gameShoe,this);
		}
		dealer.playGame(gameShoe);
	}

	public ArrayList<Hand> getPlayerHands() {
		return playerHands;
	}
	public void createHands(ArrayList gamblers) {
		for (int x = 0; x < gamblers.size(); x++) {
			Gambler temp = (Gambler) gamblers.get(x);
			int curNumOfHands = (Integer.parseInt(
					JOptionPane.showInputDialog(null, temp.getName() + ", How many hands do you want? (1-3)")));
			while (curNumOfHands <= 0 || curNumOfHands > 3) {
				curNumOfHands = (Integer.parseInt(
						JOptionPane.showInputDialog(null, temp.getName() + ", Enter a valid number of hands (1-3)")));
			}

			for (int y = 0; y < curNumOfHands; y++) {
				if (temp.getStack() <= 0) {
					JOptionPane.showMessageDialog(null,
							"Im sorry but you have 0 money left, Your hand was not created.");
					break;
				}
				int amountBet = (Integer.parseInt(JOptionPane.showInputDialog(null, temp.getName()
						+ ", How much do you want to bet on hand " + (y + 1) + ". You have: " + temp.getStack())));
				while (amountBet > temp.getStack() || amountBet <= 0) {
					amountBet = (Integer.parseInt(JOptionPane.showInputDialog(null,
							temp.getName() + "You dont have enough to bet that much! Choose another ammount. You have: "
									+ temp.getStack())));
				}
				Bet newBet = new Bet(amountBet, temp);
				temp.decreaseStack(amountBet);

				Hand newHand = new Hand(temp, newBet);
				playerHands.add(newHand);
			}
		}
	}

	public void startDraw(Dealer dealer) {
		for (int count = 0; count < playerHands.size(); count++)
		{
			specificDraw(playerHands.get(count));
			specificDraw(playerHands.get(count));
		}
		ArrayList dealerCards = dealer.getDealerCards();
		dealerCards.add(gameShoe.getTopCard());
		dealerCards.add(gameShoe.getTopCard());
	}

	public void specificDraw(Hand targetHand) {
		targetHand.addCard(gameShoe.getTopCard());
		
	}

	public void compareHands(ArrayList<Hand> playerHands, Dealer dealer) {
		if (dealer.getBust())
		{
			JOptionPane.showMessageDialog(null,"Dealer bust with hand value: " + dealer.getHandValue() + "\n Everybody who didnt bust wins!");
			for (int x = 0; x < playerHands.size(); x++)
			{
				Hand curHand = (Hand) playerHands.get(x);
				if (curHand.getHandValue() <= 21)
				{
				int winnings = curHand.getBet().getAmount() * 2;
				curHand.getGambler().addStack(winnings);
				JOptionPane.showMessageDialog(null,curHand.getGambler().getName()+ " has recieved £" + winnings);
				}
			}
			
		}
		
		for (int x = 0; x < playerHands.size(); x++) {
			Hand curHand = (Hand) playerHands.get(x);
			
			if (curHand.getHandValue() <= 21) {

				

				if (curHand.getHandValue() > dealer.getHandValue()) {

					int winnings = curHand.getBet().getAmount() * 2;
					curHand.getGambler().addStack(winnings);
					JOptionPane.showMessageDialog(null,curHand.getGambler().getName() + "'s hand beat the Dealer. It had value "+ "\n"+curHand.getGambler().getName()+ " has recieved £" + winnings);
				}

				else if (curHand.getHandValue() == dealer.getHandValue()) {
					int winnings = curHand.getBet().getAmount() * 2;
					curHand.getGambler().addStack(winnings);JOptionPane.showMessageDialog(null,curHand.getGambler().getName() + "'s hand drew with the Dealer. It had value "+ curHand.getHandValue() + "\n"+curHand.getGambler().getName()+ " has recieved £" + winnings);

				}

				else if (curHand.getHandValue() < dealer.getHandValue())
				{
					JOptionPane.showMessageDialog(null, curHand.getGambler().getName()+ "'s hand lost to the Dealer. It had value " + curHand.getHandValue());
				}
				
			}else{
				JOptionPane.showMessageDialog(null,curHand.getGambler().getName() + "'s hand bust. It had value "+ curHand.getHandValue());
			}
		}
	}
}


