

package Blackjack;








public class Card {
    private String suit;
    private int value;
    private String name;
    
    public Card(String importName, int importValue, String importSuit){
        
        this.name = importName;
        this.value = importValue;
        this.suit = importSuit;
        
        
    }
    
    public void setValue(int amount)
    {
        this.value = amount;
    }
    public String getName(){
        return name;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getSuit(){
        return suit;
    }
    
}











