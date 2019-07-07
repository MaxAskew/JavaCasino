package Blackjack;




import java.util.ArrayList;
import javax.swing.JOptionPane;




public class Dealer {
    
    private ArrayList<Card> cards;
    private boolean isBust = false;
    
    public void showTopCard()
    {
       Card curCard = (Card)cards.get(0);
       String cardOne = curCard.getName()+" of "+curCard.getSuit()+"("+curCard.getValue()+")";
       JOptionPane.showMessageDialog(null,"Dealers top card is: "+cardOne);
    }
    
    public void playGame(Shoe shoe)
    {
        String allCards = "";
        for (int x = 0; x < cards.size(); x++)
        {
            allCards += (cards.get(x).getName()+", ");
        }
        
        JOptionPane.showMessageDialog(null,"Dealers hand has value: "+this.getHandValue()+"\n"+"Cards: "+allCards);
        if(getHandValue() == 21)
        {
            JOptionPane.showMessageDialog(null,"Dealer Blackjack!"+this.getHandValue());
        }
        else{
        while(getHandValue() <= 16)
        {
            Hit(shoe);
        }
        }
       
    }
    
    void Hit(Shoe shoe)
    {
        Card newCard = (Card)shoe.getTopCard();
        cards.add(newCard);
        JOptionPane.showMessageDialog(null,"Dealer has drawn: "+newCard.getName()+", "+newCard.getSuit());
        if(this.getHandValue() > 21)
        {
            
            for (int x = 0; x < cards.size(); x++)
            {
                Card card = (Card)cards.get(x);
                if(card.getValue()==11)
                {
                    card.setValue(1);
                    JOptionPane.showMessageDialog(null,"Dealers ace has been re-valued from 11 to 1. Dealers hand value is now: "+this.getHandValue());
                    this.isBust=false;
                    break;
                }
                this.isBust=true;
                        
            }
            
    }}
    
    public Dealer()
    {
         this.cards = new ArrayList<Card>();
    }
    ArrayList getDealerCards()
    {
        return cards;
    }
    public boolean getBust()
    {
        return isBust;
    }
    public int getHandValue(){
        int total = 0;
        for (int count = 0; count < cards.size(); count++){
            total = total + cards.get(count).getValue();
        }
        return total;
    }
}











