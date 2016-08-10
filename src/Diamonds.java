

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Diamonds {
	private ArrayList<Card> diamondsLeft;
	protected ArrayList<Card> userCards;
	protected ArrayList<Card> computerCards;

	User u;
	Computer c;
	
	double userScore;
	
	Diamonds(){
		diamondsLeft = new ArrayList<Card>();
		userCards = new ArrayList<Card>();
		computerCards = new ArrayList<Card>();

		for(int i=0;i<13;i++){
			diamondsLeft.add(new Card(2,i));
			userCards.add(new Card(0,i));
			computerCards.add(new Card(1,i));
		}
		
		Collections.shuffle(diamondsLeft);
		 u=new User(userCards);
		 c=new Computer(computerCards);
	}
	
	

	public void play(){
		while(!diamondsLeft.isEmpty()){
			Card bidCard = getNextBidCard();
			System.out.println("\nThe Open Bid Card is: "+bidCard);
			
			String computerBid=c.getNextBid(bidCard);
			
			System.out.println("Computer Bid received.\nEnter the face value of the card you wish to pick:");
			String userBid=u.getNextBid(bidCard);
			
			int bid=getValue(bidCard.rank);
			
			System.out.println("Computer Bid:  "+computerBid+"  Your Bid:" +userBid);
			System.out.println(compareBids(computerBid,userBid,bid));
		}
		double computerScore=c.getScore();
		double userScore=u.getScore();
		System.out.println("Game Over ! \nComputer Score: "+computerScore+" \nUser Score: "+userScore);
		if(computerScore>userScore)
			System.out.println("Computer wins !! :) ");
		else if(computerScore<userScore)
			System.out.println("You win !! :D ");
		else
			System.out.println("Its a draw :| ");
	}
	
	private String compareBids(String computerBid, String userBid, int bid) {
		// TODO Auto-generated method stub
		int bid1= getValue(computerBid);
		int bid2= getValue(userBid);
		if(bid1>bid2){
			c.updateScore(bid);
			return "Computer Wins the Bid";
		}
		else if(bid2>bid1){
			u.updateScore(bid);
			return "User Wins the Bid";
		}
		else{
			double score=(double)bid/2;
			u.updateScore(score);
			c.updateScore(score);
			return "Draw !!";
		}
	}



	private int getValue(String bid) {
		// TODO Auto-generated method stub
		switch(bid){
		
		case "King" : return 13;
		case "Queen" :return 12;
		case "Jack" : return 13;
		case  "Ace" : return 14;
		default: return Integer.parseInt(bid);  
	  }
	}		
		
	private Card getNextBidCard() {
		// TODO Auto-generated method stub
		Card nextBidCard= diamondsLeft.get(0);
		diamondsLeft.remove(0);
		return nextBidCard;
	}


}
