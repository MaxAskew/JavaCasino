

package Blackjack;




import java.util.ArrayList;




public class Deck {




    private ArrayList cards = new ArrayList();
    private String[] faceCards = new String[]{"Jack","Queen","King"};
    private String[] suits = new String[]{"Hearts","Spades","Diamonds","Clubs"};
    
    public Deck()
    {
        for (int suit = 0; suit < 4; suit++)
        {
            Card ace = new Card("Ace", 11, suits[suit]);
            cards.add(ace);
            
            for (int cardNumber = 2; cardNumber <= 10; cardNumber++)
            {
                String name = Integer.toString(cardNumber);
                Card card = new Card(name, cardNumber, suits[suit]);
                cards.add(card);
            }
            
            for (int faceType = 0; faceType < 3; faceType++)
            {
                Card faceCard = new Card(faceCards[faceType], 10, suits[suit]);
                cards.add(faceCard);
            }
            
        }
    }




    public ArrayList getDeck() {
        return cards;
    }




}












