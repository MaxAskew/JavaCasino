package Blackjack;




public class Bet
{
    private int amount;
    private Gambler owner;
    
    public Bet(int amount, Gambler gambler)
    {
        this.amount = amount;
        this.owner = gambler;
    }
    public int getAmount()
    {
        return amount;
    }
    
    public Gambler getOwner()
    {
        return owner;
    }
    
}












