package Blackjack;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;




public class Shoe
{
	ArrayList cardsInShoe = new ArrayList();
	
	public Shoe(int numOfDecks)
	{
		refillShoe(numOfDecks);
		
	}
	
        //Creates decks and then adds all the cards from the deck into an array of cards.
	public void refillShoe(int numOfDecks)
	{
            for (int value = 0; value< numOfDecks; value++) 
	    {
			Deck deck = new Deck();
			cardsInShoe.addAll(deck.getDeck());
                        
	    }
            shuffleShoe();
	}
        
        public void shuffleShoe()
        {
            long seed = System.nanoTime();
            Collections.shuffle(cardsInShoe, new Random(seed));
        }
        
        //Removes the top card from the shoe and returns it from the method.
        public Card getTopCard()
        {  
            Card topCard = (Card)cardsInShoe.get(0);
            cardsInShoe.remove(0);
            return topCard;
        }




}











