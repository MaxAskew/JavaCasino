package Roulette;

import java.util.ArrayList;
import java.util.Random;

public class Wheel
{
	public ArrayList allBins = new ArrayList();
	public Wheel()
	{
		createBins();
	}
	
			
	Bin zero = new Bin("green",0);
	Bin one = new Bin("red",1);
	Bin two = new Bin("black",2);
	Bin three = new Bin("red",3);
	Bin four = new Bin("black",4);
	Bin five = new Bin("red",5);
	Bin six = new Bin("black",6);
	Bin seven = new Bin("red",7);
	Bin eight = new Bin("black",8);
	Bin nine = new Bin("red",9);
	Bin ten = new Bin("black",10);
	Bin eleven = new Bin("black",11);
	Bin twelve = new Bin("red",12);	
	Bin thirteen = new Bin("black",13);
	Bin fourteen = new Bin("red",14);
	Bin fifteen = new Bin("black",15);
	Bin sixteen = new Bin("red",16);
	Bin seventeen = new Bin("black",17);
	Bin eighteen = new Bin("red",18);
	Bin nineteen = new Bin("red",19);
	Bin twenty = new Bin("black",20);
	Bin twentyone = new Bin("red",21);
	Bin twentytwo = new Bin("black",22);
	Bin twentythree = new Bin("red",23);
	Bin twentyfour = new Bin("black",24);
	Bin twentyfive = new Bin("red",25);
	Bin twentysix = new Bin("black",26);
	Bin twentyseven = new Bin("red",27);
	Bin twentyeight = new Bin("black",28);
	Bin twentynine = new Bin("black",29);
	Bin thirty = new Bin("red",30);
	Bin thirtyone = new Bin("black",31);
	Bin thirtytwo = new Bin("red",32);
	Bin thirtythree = new Bin("black",33);
	Bin thirtyfour = new Bin("red",34);
	Bin thirtyfive = new Bin("black",35);
	Bin thirtysix = new Bin("red",36);

	public void createBins()
	{
		allBins.add(zero);
		allBins.add(one);
		allBins.add(two);
		allBins.add(three);
		allBins.add(four);
		allBins.add(five);
		allBins.add(six);
		allBins.add(seven);
		allBins.add(eight);
		allBins.add(nine);
		allBins.add(ten);
		allBins.add(eleven);
		allBins.add(twelve);
		allBins.add(thirteen);
		allBins.add(fourteen);
		allBins.add(fifteen);
		allBins.add(sixteen);
		allBins.add(seventeen);
		allBins.add(eighteen);
		allBins.add(nineteen);
		allBins.add(twenty);
		allBins.add(twentyone);
		allBins.add(twentytwo);
		allBins.add(twentythree);
		allBins.add(twentyfour);
		allBins.add(twentyfive);
		allBins.add(twentysix);
		allBins.add(twentyseven);
		allBins.add(twentyeight);
		allBins.add(twentynine);
		allBins.add(thirty);
		allBins.add(thirtyone);
		allBins.add(thirtytwo);
		allBins.add(thirtythree);
		allBins.add(thirtyfour);
		allBins.add(thirtyfive);
		allBins.add(thirtysix);
		
	}
	
	 public int GenerateRandomNumber() {
	        Random rand = new Random();
	        return rand.nextInt(36);
	    }
}

	
