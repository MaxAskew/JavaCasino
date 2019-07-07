package Blackjack;




import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;








public class Gambler{
    private String name;
    private int stack;
    Object[] stickStand = {"Hit","Stand"};
    Object[] stickStandSplit = {"Hit","Stand","Split"};
    
    public Gambler(String importName, int importStack){
        
        this.name = importName;
        this.stack = importStack;
    }
   
    public void addStack(int amount)
    {
        stack += amount;
    }
    public void decreaseStack(int amount)
    {
        stack -= amount;
    }
    public void playGame(Hand currentHand,Shoe shoe,Table table)
    {
        
        if(currentHand.getHandValue() == 21)
        {
            JOptionPane.showMessageDialog(null,this.getName()+", Your hand has value: "+currentHand.getHandValue()+"\n Cards: "+cardsInHand(currentHand)+"\n This hand blackjacked!: ");
        }
        else{
        while(currentHand.getHandValue() < 21)
        {
        	 Card c1 = (Card) currentHand.getCardsInHand().get(0);
        	 Card c2 = (Card) currentHand.getCardsInHand().get(1);
             if(currentHand.getCardsInHand().size() ==2 && c1.getValue()==c2.getValue())
             {
            	{
            		 int chosen = JOptionPane.showOptionDialog(null,this.getName()+", Your hand has value: "+currentHand.getHandValue()+"\n"+"Cards: "+cardsInHand(currentHand)+"\n What do you want to do?",null,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,stickStandSplit,null);
                     if(chosen == 0)
                     {
                       Hit(currentHand,shoe);
                       
                     }
                     if(chosen == 1)
                     {
                       break;
                     }
                     if(chosen == 2)
                     {
                    	 if (getStack() <= currentHand.getBet().getAmount())
                    	 {
                    		 JOptionPane.showMessageDialog(null,"Im sorry but you dont have enough money to split, Your hand was not split.");

    					}
                    	 JOptionPane.showMessageDialog(null,this.getName()+", Your hand has been split into two hands which will each be indipendantly played now");
                         //create hand one
                    	 Hand hand1 = new Hand(this, currentHand.getBet());
                    	 hand1.addCard(c1);
                    	 hand1.addCard(shoe.getTopCard());
                    	 table.getPlayerHands().add(hand1);
                    	 
                    	 //create hand two
                    	 Hand hand2 = new Hand(this, currentHand.getBet());
                    	 hand2.addCard(c2);
                    	 hand2.addCard(shoe.getTopCard());
                    	 table.getPlayerHands().add(hand2);
                    	 this.decreaseStack(currentHand.getBet().getAmount());
                    	 table.getPlayerHands().remove(currentHand);
                    	 break;
                     }
            	 }
             }
             else
             {
            
           
            int chosen = JOptionPane.showOptionDialog(null,this.getName()+", Your hand has value: "+currentHand.getHandValue()+"\n"+"Cards: "+cardsInHand(currentHand)+"\n What do you want to do?",null,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,stickStand,null);
            if(chosen == 0)
            {
              Hit(currentHand,shoe);
              
            }
            if(chosen == 1)
            {
              break;
            }
        }
        }
        }
    }
    public String cardsInHand(Hand currentHand)
    {
        String allCards = "";
        for (int x = 0; x < currentHand.getCardsInHand().size(); x++)
        {
            Card curCard = (Card)currentHand.getCardsInHand().get(x);
            allCards += (curCard.getName()+" of "+curCard.getSuit()+"("+curCard.getValue()+"), ");
        }
        return allCards;
    }
    
    public void Hit(Hand currentHand, Shoe shoe)
    {
        
        Card tempCard = shoe.getTopCard();
        currentHand.addCard(tempCard);
        JOptionPane.showMessageDialog(null, this.getName()+", You drew the card: "+tempCard.getName()+" of "+tempCard.getSuit()+"("+tempCard.getValue()+")");
        if(currentHand.getHandValue() > 21)
        {
            ArrayList currentHandCards = currentHand.getCardsInHand();
            Boolean hasAce = false;
            for (int x = 0; x < currentHandCards.size(); x++)
            {
                Card card = (Card)currentHandCards.get(x);
                if(card.getName()=="Ace")
                {
                    hasAce = true;
                    card.setValue(1);
                    JOptionPane.showMessageDialog(null, this.getName()+", Your ace has been re-valued from 11 to 1. Hand value is now: "+currentHand.getHandValue());
                    currentHand.setIsBust(false);
                }
           
                        
            }
             if(hasAce == false)
            {
                currentHand.setIsBust(true);
                JOptionPane.showMessageDialog(null, this.getName()+", You bust!. Hand value was: "+currentHand.getHandValue()+"\n Cards: "+cardsInHand(currentHand));
            }
           
        }
        
    }                                   
     
    public String getName(){
        return name;
    }
    
    public int getStack(){
        return stack;
    }
}
































