package Blackjack;
import java.util.ArrayList;








public class Hand {
    private ArrayList<Card> cards;
    private Bet bet;
    private Gambler owner;
    private boolean isBust;
   
    public Hand(Gambler owner , Bet bet)
    {
        this.bet = bet;
        this.isBust = false;
        this.cards = new ArrayList<Card>();
        this.owner = owner;
    }
    
    public void addCard(Card topCard)
    {
        cards.add(topCard);
    }
     boolean getIsBust()
     {
         return isBust;
     }
     void setIsBust(boolean isBust)
     {
         this.isBust = isBust;
     }
     public Bet getBet()
     {
         return bet;
     }
    Gambler getGambler()
    {
        return owner;
    }
    public ArrayList getCardsInHand()
    {
        return cards;
    }
    public int getHandValue(){
        int total = 0;
        for (int count = 0; count < cards.size(); count++){
            total = total + cards.get(count).getValue();
        }
        return total;
    }




}































