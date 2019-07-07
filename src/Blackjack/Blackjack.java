package Blackjack;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Blackjack
{
    
    public ArrayList gamblers = new ArrayList();
    
    public Blackjack()
    {
        Table table = new Table(3);
        addGamblers();
        Dealer dealer = new Dealer();
        startRound(table,dealer);
    }
        
    public void startRound(Table table,Dealer dealer)
    {
        while(gamblers.size() > 0)
        {
         table.newRound(gamblers,dealer);
         addGamblers();
        }
    }
    
    public void removeGambler(Gambler gambler)
    {
       gamblers.remove(gambler);
    }
    public void addGamblers()
    {
        int numberOfGamblers = (Integer.parseInt(JOptionPane.showInputDialog(null, "How many players are joining?")));
        for (int x = 0; x < numberOfGamblers; x++)
        {
            String name = JOptionPane.showInputDialog(null, "Enter new player " + (x + 1) + "'s name.");
            Gambler gambler = new Gambler(name,200);
            gamblers.add(gambler);
        }
    }
    
    
}	












